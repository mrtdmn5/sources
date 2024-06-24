package com.animaconnected.dfu.fota;

import java.util.Arrays;

/* loaded from: classes.dex */
public class DataHandler {
    public static final int PAGE_SIZE = 4096;
    private long mCurrentBytesReceived;
    private long mCurrentPageIndex;
    private final byte[] mData;

    public DataHandler(byte[] bArr) {
        this.mData = bArr;
    }

    public void addBytesReceived(int r5) {
        this.mCurrentBytesReceived += r5;
    }

    public long getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    public byte[] getNextDataSection() {
        int pageSize = getPageSize();
        long j = this.mCurrentPageIndex * 4096;
        long j2 = this.mCurrentBytesReceived;
        int r1 = (int) (j + j2);
        long j3 = pageSize;
        if (j3 - j2 < 19) {
            return Arrays.copyOfRange(this.mData, r1, ((int) (j3 - j2)) + r1);
        }
        return Arrays.copyOfRange(this.mData, r1, r1 + 19);
    }

    public byte[] getPageData() {
        int pageSize = getPageSize();
        byte[] bArr = new byte[pageSize];
        System.arraycopy(this.mData, (int) (this.mCurrentPageIndex * 4096), bArr, 0, pageSize);
        return bArr;
    }

    public int getPageSize() {
        long j = (this.mCurrentPageIndex + 1) * 4096;
        byte[] bArr = this.mData;
        if (j <= bArr.length) {
            return 4096;
        }
        return bArr.length % 4096;
    }

    public int getTotalPages() {
        return (int) Math.ceil(this.mData.length / 4096.0d);
    }

    public boolean isPageCompleted() {
        if (getPageSize() == this.mCurrentBytesReceived) {
            return true;
        }
        return false;
    }

    public void resetCurrentBytesReceived() {
        this.mCurrentBytesReceived = 0L;
    }

    public void setCurrentData(long j, long j2) {
        this.mCurrentPageIndex = j;
        this.mCurrentBytesReceived = j2;
    }
}
