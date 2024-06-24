package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TransferUtility {
    static final int DEFAULT_MINIMUM_UPLOAD_PART_SIZE_IN_BYTES = 5242880;
    static final long MAXIMUM_SUPPORTED_UPLOAD_PART_SIZE_IN_BYTES = 5368709120L;
    static final int MINIMUM_SUPPORTED_UPLOAD_PART_SIZE_IN_BYTES = 5242880;
    private static final String TRANSFER_ADD = "add_transfer";
    private static final String TRANSFER_CANCEL = "cancel_transfer";
    private static final String TRANSFER_PAUSE = "pause_transfer";
    private static final String TRANSFER_RESUME = "resume_transfer";
    final ConnectivityManager connManager;
    private TransferDBUtil dbUtil;
    private final String defaultBucket;
    private final AmazonS3 s3;
    private final TransferUtilityOptions transferUtilityOptions;
    private TransferStatusUpdater updater;
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferUtility.class);
    private static final Object LOCK = new Object();
    private static String userAgentFromConfig = "";

    /* loaded from: classes.dex */
    public static class Builder {
        private Context appContext;
        private AWSConfiguration awsConfig;
        private String defaultBucket;
        private AmazonS3 s3;
        private TransferUtilityOptions transferUtilityOptions;

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfig = aWSConfiguration;
            return this;
        }

        public TransferUtility build() {
            boolean z;
            if (this.s3 != null) {
                if (this.appContext != null) {
                    AWSConfiguration aWSConfiguration = this.awsConfig;
                    if (aWSConfiguration != null) {
                        try {
                            JSONObject optJsonObject = aWSConfiguration.optJsonObject("S3TransferUtility");
                            this.s3.setRegion(Region.getRegion(optJsonObject.getString("Region")));
                            this.defaultBucket = optJsonObject.getString("Bucket");
                            if (optJsonObject.has(Constants.LOCAL_TESTING_FLAG_NAME)) {
                                z = optJsonObject.getBoolean(Constants.LOCAL_TESTING_FLAG_NAME);
                            } else {
                                z = false;
                            }
                            if (z) {
                                this.s3.setEndpoint(Constants.LOCAL_TESTING_ENDPOINT);
                                this.s3.setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).skipContentMd5Check(true).build());
                            }
                            TransferUtility.setUserAgentFromConfig(this.awsConfig.getUserAgent());
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Failed to read S3TransferUtility please check your setup or awsconfiguration.json file", e);
                        }
                    }
                    if (this.transferUtilityOptions == null) {
                        this.transferUtilityOptions = new TransferUtilityOptions();
                    }
                    return new TransferUtility(this.s3, this.appContext, this.defaultBucket, this.transferUtilityOptions);
                }
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
            throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
        }

        public Builder context(Context context) {
            this.appContext = context.getApplicationContext();
            return this;
        }

        public Builder defaultBucket(String str) {
            this.defaultBucket = str;
            return this;
        }

        public Builder s3Client(AmazonS3 amazonS3) {
            this.s3 = amazonS3;
            return this;
        }

        public Builder transferUtilityOptions(TransferUtilityOptions transferUtilityOptions) {
            this.transferUtilityOptions = transferUtilityOptions;
            return this;
        }
    }

    public static <X extends AmazonWebServiceRequest> X appendMultipartTransferServiceUserAgentString(X x) {
        x.getRequestClientOptions().appendUserAgent("TransferService_multipart/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    public static <X extends AmazonWebServiceRequest> X appendTransferServiceUserAgentString(X x) {
        x.getRequestClientOptions().appendUserAgent("TransferService/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    public static Builder builder() {
        return new Builder();
    }

    private int createMultipartUploadRecords(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        int r19;
        long length = file.length();
        double d = length;
        long max = (long) Math.max(Math.ceil(d / 10000.0d), this.transferUtilityOptions.getMinimumUploadPartSizeInBytes());
        int ceil = ((int) Math.ceil(d / max)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[ceil];
        contentValuesArr[0] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
        long j = 0;
        int r25 = 1;
        for (int r7 = 1; r7 < ceil; r7++) {
            long min = Math.min(max, length);
            TransferDBUtil transferDBUtil = this.dbUtil;
            length -= max;
            if (length <= 0) {
                r19 = 1;
            } else {
                r19 = 0;
            }
            contentValuesArr[r7] = transferDBUtil.generateContentValuesForMultiPartUpload(str, str2, file, j, r25, "", min, r19, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
            j += max;
            r25++;
        }
        return this.dbUtil.bulkInsertTransferRecords(contentValuesArr);
    }

    private String getDefaultBucketOrThrow() {
        String str = this.defaultBucket;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("TransferUtility has not been configured with a default bucket. Please use the corresponding method that specifies bucket name or configure the default bucket name in construction of the object. See TransferUtility.builder().defaultBucket() or TransferUtility.builder().awsConfiguration()");
    }

    private List<Integer> getTransferIdsWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0) {
                    arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID))));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static String getUserAgentFromConfig() {
        synchronized (LOCK) {
            String str = userAgentFromConfig;
            if (str != null && !str.trim().isEmpty()) {
                return userAgentFromConfig.trim() + "/";
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setUserAgentFromConfig(String str) {
        synchronized (LOCK) {
            userAgentFromConfig = str;
        }
    }

    private boolean shouldUploadInMultipart(File file) {
        if (file != null && file.length() > this.transferUtilityOptions.getMinimumUploadPartSizeInBytes()) {
            return true;
        }
        return false;
    }

    private synchronized void submitTransferJob(String str, int r7) {
        S3ClientReference.put(Integer.valueOf(r7), this.s3);
        TransferRecord transfer = this.updater.getTransfer(r7);
        if (transfer == null) {
            transfer = this.dbUtil.getTransferById(r7);
            if (transfer == null) {
                LOGGER.error("Cannot find transfer with id: " + r7);
                return;
            }
            this.updater.addTransfer(transfer);
        } else if (TRANSFER_ADD.equals(str)) {
            LOGGER.warn("Transfer has already been added: " + r7);
            return;
        }
        if (!TRANSFER_ADD.equals(str) && !TRANSFER_RESUME.equals(str)) {
            if (TRANSFER_PAUSE.equals(str)) {
                transfer.pause(this.s3, this.updater);
            } else if (TRANSFER_CANCEL.equals(str)) {
                transfer.cancel(this.s3, this.updater);
            } else {
                LOGGER.error("Unknown action: " + str);
            }
        }
        transfer.start(this.s3, this.dbUtil, this.updater, this.connManager);
    }

    private File writeInputStreamToFile(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            File createTempFile = File.createTempFile("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002", ".tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        } else {
                            return createTempFile;
                        }
                    }
                } catch (IOException e) {
                    createTempFile.delete();
                    throw new IOException("Error writing the inputStream into a file.", e);
                }
            } finally {
                fileOutputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Invalid inputStream: " + inputStream);
        }
    }

    public boolean cancel(int r2) {
        submitTransferJob(TRANSFER_CANCEL, r2);
        return true;
    }

    public void cancelAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                cancel(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)));
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean deleteTransferRecord(int r2) {
        cancel(r2);
        if (this.dbUtil.deleteTransferRecords(r2) > 0) {
            return true;
        }
        return false;
    }

    public TransferObserver download(String str, String str2, File file) {
        return download(str, str2, file, null);
    }

    public TransferDBUtil getDbUtil() {
        return this.dbUtil;
    }

    public TransferObserver getTransferById(int r4) {
        Cursor cursor = null;
        try {
            Cursor queryTransferById = this.dbUtil.queryTransferById(r4);
            try {
                if (queryTransferById.moveToNext()) {
                    TransferObserver transferObserver = new TransferObserver(r4, this.dbUtil);
                    transferObserver.updateFromDB(queryTransferById);
                    queryTransferById.close();
                    return transferObserver;
                }
                queryTransferById.close();
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = queryTransferById;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public List<TransferObserver> getTransfersWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)), this.dbUtil);
                transferObserver.updateFromDB(cursor);
                arrayList.add(transferObserver);
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public List<TransferObserver> getTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        return getTransfersWithTypeAndStates(transferType, new TransferState[]{transferState});
    }

    public List<TransferObserver> getTransfersWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0) {
                    TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)), this.dbUtil);
                    transferObserver.updateFromDB(cursor);
                    arrayList.add(transferObserver);
                }
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean pause(int r2) {
        submitTransferJob(TRANSFER_PAUSE, r2);
        return true;
    }

    public void pauseAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                pause(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)));
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public TransferObserver resume(int r2) {
        submitTransferJob(TRANSFER_RESUME, r2);
        return getTransferById(r2);
    }

    public List<TransferObserver> resumeAllWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = getTransferIdsWithTypeAndStates(transferType, new TransferState[]{TransferState.PAUSED, TransferState.FAILED, TransferState.CANCELED}).iterator();
        while (it.hasNext()) {
            arrayList.add(resume(it.next().intValue()));
        }
        return arrayList;
    }

    public TransferObserver upload(String str, String str2, File file) {
        return upload(str, str2, file, new ObjectMetadata());
    }

    private TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions) {
        this.s3 = amazonS3;
        this.defaultBucket = str;
        this.transferUtilityOptions = transferUtilityOptions;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public TransferObserver download(String str, File file) {
        return download(getDefaultBucketOrThrow(), str, file, null);
    }

    public TransferObserver upload(String str, File file) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata());
    }

    public TransferObserver download(String str, String str2, File file, TransferListener transferListener) {
        if (file != null && !file.isDirectory()) {
            int parseInt = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.DOWNLOAD, str, str2, file, this.transferUtilityOptions).getLastPathSegment());
            if (file.isFile()) {
                LOGGER.warn("Overwrite existing file: " + file);
                file.delete();
            }
            TransferObserver transferObserver = new TransferObserver(parseInt, this.dbUtil, str, str2, file, transferListener);
            submitTransferJob(TRANSFER_ADD, parseInt);
            return transferObserver;
        }
        throw new IllegalArgumentException("Invalid file: " + file);
    }

    public TransferObserver upload(String str, String str2, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return upload(str, str2, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        int parseInt;
        if (file != null && !file.isDirectory() && file.exists()) {
            if (shouldUploadInMultipart(file)) {
                parseInt = createMultipartUploadRecords(str, str2, file, objectMetadata, cannedAccessControlList);
            } else {
                parseInt = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.transferUtilityOptions).getLastPathSegment());
            }
            TransferObserver transferObserver = new TransferObserver(parseInt, this.dbUtil, str, str2, file, transferListener);
            submitTransferJob(TRANSFER_ADD, parseInt);
            return transferObserver;
        }
        throw new IllegalArgumentException("Invalid file: " + file);
    }

    @Deprecated
    public TransferUtility(AmazonS3 amazonS3, Context context) {
        this.s3 = amazonS3;
        this.defaultBucket = null;
        TransferUtilityOptions transferUtilityOptions = new TransferUtilityOptions();
        this.transferUtilityOptions = transferUtilityOptions;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public TransferObserver download(String str, File file, TransferListener transferListener) {
        return download(getDefaultBucketOrThrow(), str, file, transferListener);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, transferListener);
    }

    public TransferObserver upload(String str, InputStream inputStream) throws IOException {
        return upload(str, inputStream, UploadOptions.builder().build());
    }

    public TransferObserver upload(String str, InputStream inputStream, UploadOptions uploadOptions) throws IOException {
        return upload(uploadOptions.getBucket() != null ? uploadOptions.getBucket() : getDefaultBucketOrThrow(), str, writeInputStreamToFile(inputStream), uploadOptions.getMetadata() != null ? uploadOptions.getMetadata() : new ObjectMetadata(), uploadOptions.getCannedAcl(), uploadOptions.getTransferListener());
    }
}
