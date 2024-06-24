package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.io.File;

/* loaded from: classes.dex */
public class TransferObserver {
    private String bucket;
    private long bytesTotal;
    private long bytesTransferred;
    private final TransferDBUtil dbUtil;
    private String filePath;
    private final int id;
    private String key;
    private TransferStatusListener statusListener;
    private TransferListener transferListener;
    private TransferState transferState;

    public TransferObserver(int r1, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.id = r1;
        this.dbUtil = transferDBUtil;
        this.bucket = str;
        this.key = str2;
        this.filePath = file.getAbsolutePath();
        this.bytesTotal = file.length();
        this.transferState = TransferState.WAITING;
    }

    public void cleanTransferListener() {
        synchronized (this) {
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                TransferStatusUpdater.unregisterListener(this.id, transferListener);
                this.transferListener = null;
            }
            TransferStatusListener transferStatusListener = this.statusListener;
            if (transferStatusListener != null) {
                TransferStatusUpdater.unregisterListener(this.id, transferStatusListener);
                this.statusListener = null;
            }
        }
    }

    public String getAbsoluteFilePath() {
        return this.filePath;
    }

    public String getBucket() {
        return this.bucket;
    }

    public long getBytesTotal() {
        return this.bytesTotal;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public TransferState getState() {
        return this.transferState;
    }

    public void refresh() {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransferById(this.id);
            if (cursor.moveToFirst()) {
                updateFromDB(cursor);
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void setTransferListener(TransferListener transferListener) {
        synchronized (this) {
            cleanTransferListener();
            if (this.statusListener == null) {
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.statusListener = transferStatusListener;
                TransferStatusUpdater.registerListener(this.id, transferStatusListener);
            }
            if (transferListener != null) {
                this.transferListener = transferListener;
                transferListener.onStateChanged(this.id, this.transferState);
                TransferStatusUpdater.registerListener(this.id, this.transferListener);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TransferObserver{id=");
        sb.append(this.id);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', bytesTotal=");
        sb.append(this.bytesTotal);
        sb.append(", bytesTransferred=");
        sb.append(this.bytesTransferred);
        sb.append(", transferState=");
        sb.append(this.transferState);
        sb.append(", filePath='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.filePath, "'}");
    }

    public void updateFromDB(Cursor cursor) {
        this.bucket = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_KEY));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
        this.bytesTransferred = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_CURRENT));
        this.transferState = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.filePath = cursor.getString(cursor.getColumnIndexOrThrow("file"));
    }

    public TransferObserver(int r1, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(r1, transferDBUtil, str, str2, file);
        setTransferListener(transferListener);
    }

    public TransferObserver(int r1, TransferDBUtil transferDBUtil) {
        this.id = r1;
        this.dbUtil = transferDBUtil;
    }

    /* loaded from: classes.dex */
    public class TransferStatusListener implements TransferListener {
        public TransferStatusListener() {
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onProgressChanged(int r1, long j, long j2) {
            TransferObserver.this.bytesTransferred = j;
            TransferObserver.this.bytesTotal = j2;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onStateChanged(int r1, TransferState transferState) {
            TransferObserver.this.transferState = transferState;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onError(int r1, Exception exc) {
        }
    }
}
