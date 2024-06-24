package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DownloadTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) DownloadTask.class);
    private static final int SIXTEEN_KB = 16384;
    private final TransferRecord download;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.download = transferRecord;
        this.s3 = amazonS3;
        this.updater = transferStatusUpdater;
    }

    private void saveToFile(InputStream inputStream, File file) {
        boolean z;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z));
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                LOGGER.warn("got exception", e);
                            }
                        }
                    }
                    bufferedOutputStream2.close();
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        LOGGER.warn("got exception", e2);
                    }
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
                    LOGGER.error(str);
                    throw new AmazonClientException(str, e);
                } catch (IOException e4) {
                    e = e4;
                    throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            LOGGER.warn("got exception", e5);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException e6) {
                            LOGGER.warn("got exception", e6);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (SocketTimeoutException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                LOGGER.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e) {
            LOGGER.error("TransferUtilityException: [" + e + "]");
        }
        this.updater.updateState(this.download.id, TransferState.IN_PROGRESS);
        ProgressListener newProgressListener = this.updater.newProgressListener(this.download.id);
        try {
            TransferRecord transferRecord = this.download;
            GetObjectRequest getObjectRequest = new GetObjectRequest(transferRecord.bucketName, transferRecord.key);
            TransferUtility.appendTransferServiceUserAgentString(getObjectRequest);
            File file = new File(this.download.file);
            long length = file.length();
            if (length > 0) {
                LOGGER.debug(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.download.id), Long.valueOf(length)));
                getObjectRequest.setRange(length, -1L);
            }
            getObjectRequest.setGeneralProgressListener(newProgressListener);
            S3Object object = this.s3.getObject(getObjectRequest);
            if (object == null) {
                this.updater.throwError(this.download.id, new IllegalStateException("AmazonS3.getObject returns null"));
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return Boolean.FALSE;
            }
            long instanceLength = object.getObjectMetadata().getInstanceLength();
            this.updater.updateProgress(this.download.id, length, instanceLength, true);
            saveToFile(object.getObjectContent(), file);
            this.updater.updateProgress(this.download.id, instanceLength, instanceLength, true);
            this.updater.updateState(this.download.id, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e2) {
            if (TransferState.PENDING_CANCEL.equals(this.download.state)) {
                TransferStatusUpdater transferStatusUpdater = this.updater;
                int r2 = this.download.id;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.updateState(r2, transferState);
                LOGGER.info("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.download.state)) {
                TransferStatusUpdater transferStatusUpdater2 = this.updater;
                int r22 = this.download.id;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.updateState(r22, transferState2);
                LOGGER.info("Transfer is " + transferState2);
                new ProgressEvent(0L).setEventCode(32);
                newProgressListener.progressChanged(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                    Log log = LOGGER;
                    log.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                    log.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).setEventCode(32);
                    newProgressListener.progressChanged(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e3) {
                LOGGER.error("TransferUtilityException: [" + e3 + "]");
            }
            if (RetryUtils.isInterrupted(e2)) {
                LOGGER.info("Transfer is interrupted. " + e2);
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return Boolean.FALSE;
            }
            LOGGER.debug("Failed to download: " + this.download.id + " due to " + e2.getMessage());
            this.updater.throwError(this.download.id, e2);
            this.updater.updateState(this.download.id, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }
}
