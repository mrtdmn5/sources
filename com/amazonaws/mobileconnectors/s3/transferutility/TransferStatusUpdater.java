package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TransferStatusUpdater {
    static final String TEMP_FILE_PREFIX = "aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002";
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private Context context;
    private final Handler mainHandler;
    private final Map<Integer, TransferRecord> transfers;
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));
    static final Map<Integer, List<TransferListener>> LISTENERS = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };

    /* loaded from: classes.dex */
    public class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                TransferStatusUpdater.LOGGER.info("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0L;
            } else {
                long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                this.bytesTransferredSoFar = bytesTransferred;
                TransferRecord transferRecord = this.transfer;
                if (bytesTransferred > transferRecord.bytesCurrent) {
                    transferRecord.bytesCurrent = bytesTransferred;
                    TransferStatusUpdater.this.updateProgress(transferRecord.id, bytesTransferred, transferRecord.bytesTotal, true);
                }
            }
        }
    }

    public TransferStatusUpdater(TransferDBUtil transferDBUtil, Context context) {
        dbUtil = transferDBUtil;
        this.context = context;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.transfers = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater getInstance(Context context) {
        TransferStatusUpdater transferStatusUpdater2;
        synchronized (TransferStatusUpdater.class) {
            if (transferStatusUpdater == null) {
                TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                dbUtil = transferDBUtil;
                transferStatusUpdater = new TransferStatusUpdater(transferDBUtil, context);
            }
            transferStatusUpdater2 = transferStatusUpdater;
        }
        return transferStatusUpdater2;
    }

    public static void registerListener(int r2, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(r2));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(r2), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    public static void unregisterListener(int r2, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(r2));
                if (list != null && !list.isEmpty()) {
                    list.remove(transferListener);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    public synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    public synchronized void clear() {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    public synchronized TransferRecord getTransfer(int r2) {
        return this.transfers.get(Integer.valueOf(r2));
    }

    public synchronized Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    public synchronized ProgressListener newProgressListener(int r5) {
        TransferRecord transfer;
        transfer = getTransfer(r5);
        if (transfer != null) {
            LOGGER.info("Creating a new progress listener for transfer: " + r5);
        } else {
            LOGGER.info("TransferStatusUpdater doesn't track the transfer: " + r5);
            throw new IllegalArgumentException("transfer " + r5 + " doesn't exist");
        }
        return new TransferProgressListener(transfer);
    }

    public synchronized void removeTransfer(int r3) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(r3));
        }
        this.transfers.remove(Integer.valueOf(r3));
    }

    public synchronized void removeTransferRecordFromDB(int r4) {
        TransferRecord transferById = dbUtil.getTransferById(r4);
        if (transferById != null) {
            String str = transferById.file;
            if (new File(str).getName().startsWith(TEMP_FILE_PREFIX)) {
                new File(str).delete();
            }
        }
        S3ClientReference.remove(Integer.valueOf(r4));
        dbUtil.deleteTransferRecords(r4);
    }

    public void throwError(final int r6, final Exception exc) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(r6));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                        @Override // java.lang.Runnable
                        public void run() {
                            transferListener.onError(r6, exc);
                        }
                    });
                }
            }
        }
    }

    public synchronized void updateProgress(final int r17, final long j, final long j2, boolean z) {
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(r17));
        if (transferRecord != null) {
            transferRecord.bytesCurrent = j;
            transferRecord.bytesTotal = j2;
        }
        dbUtil.updateBytesTransferred(r17, j);
        if (!z) {
            return;
        }
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(r17));
            if (list != null && !list.isEmpty()) {
                for (Iterator<TransferListener> it = list.iterator(); it.hasNext(); it = it) {
                    final TransferListener next = it.next();
                    this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                        @Override // java.lang.Runnable
                        public void run() {
                            next.onProgressChanged(r17, j, j2);
                        }
                    });
                }
            }
        }
    }

    public synchronized void updateState(final int r7, final TransferState transferState) {
        boolean contains = STATES_NOT_TO_NOTIFY.contains(transferState);
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(r7));
        if (transferRecord == null) {
            if (dbUtil.updateState(r7, transferState) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + r7);
            }
        } else {
            contains |= transferState.equals(transferRecord.state);
            transferRecord.state = transferState;
            if (dbUtil.updateTransferRecord(transferRecord) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + r7);
            }
        }
        if (contains) {
            return;
        }
        if (TransferState.COMPLETED.equals(transferState)) {
            removeTransferRecordFromDB(r7);
        }
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(r7));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    if (transferListener instanceof TransferObserver.TransferStatusListener) {
                        transferListener.onStateChanged(r7, transferState);
                    } else {
                        this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.onStateChanged(r7, transferState);
                            }
                        });
                    }
                }
                if (TransferState.isFinalState(transferState)) {
                    list.clear();
                }
            }
        }
    }
}
