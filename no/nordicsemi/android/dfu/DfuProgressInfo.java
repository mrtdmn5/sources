package no.nordicsemi.android.dfu;

import android.os.SystemClock;

/* loaded from: classes4.dex */
class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    /* loaded from: classes4.dex */
    public interface ProgressListener {
        void updateProgressNotification();
    }

    public DfuProgressInfo(ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    public void addBytesSent(int r2) {
        setBytesSent(this.bytesSent + r2);
    }

    public int getAvailableObjectSizeIsBytes() {
        int r0 = this.imageSizeInBytes;
        int r1 = this.bytesSent;
        int r2 = this.maxObjectSizeInBytes;
        return Math.min(r0 - r1, r2 - (r1 % r2));
    }

    public float getAverageSpeed() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.timeStart;
        if (elapsedRealtime - j != 0) {
            return (this.bytesSent - this.initialBytesSent) / ((float) (elapsedRealtime - j));
        }
        return 0.0f;
    }

    public int getBytesReceived() {
        return this.bytesReceived;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }

    public int getCurrentPart() {
        return this.currentPart;
    }

    public int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    public int getProgress() {
        return this.progress;
    }

    public float getSpeed() {
        float f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.timeStart != 0) {
            f = (this.bytesSent - this.lastBytesSent) / ((float) (elapsedRealtime - this.lastProgressTime));
        } else {
            f = 0.0f;
        }
        this.lastProgressTime = elapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f;
    }

    public int getTotalParts() {
        return this.totalParts;
    }

    public void init(int r1, int r2, int r3) {
        this.imageSizeInBytes = r1;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = r2;
        this.totalParts = r3;
    }

    public boolean isComplete() {
        if (this.bytesSent == this.imageSizeInBytes) {
            return true;
        }
        return false;
    }

    public boolean isLastPart() {
        if (this.currentPart == this.totalParts) {
            return true;
        }
        return false;
    }

    public boolean isObjectComplete() {
        if (this.bytesSent % this.maxObjectSizeInBytes == 0) {
            return true;
        }
        return false;
    }

    public void setBytesReceived(int r1) {
        this.bytesReceived = r1;
    }

    public void setBytesSent(int r5) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = r5;
        }
        this.bytesSent = r5;
        this.progress = (int) ((r5 * 100.0f) / this.imageSizeInBytes);
        this.mListener.updateProgressNotification();
    }

    public void setMaxObjectSizeInBytes(int r1) {
        this.maxObjectSizeInBytes = r1;
    }

    public void setProgress(int r1) {
        this.progress = r1;
        this.mListener.updateProgressNotification();
    }

    public DfuProgressInfo setTotalPart(int r1) {
        this.totalParts = r1;
        return this;
    }
}
