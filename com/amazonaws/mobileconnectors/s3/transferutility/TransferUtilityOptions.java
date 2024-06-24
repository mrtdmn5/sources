package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.Serializable;

/* loaded from: classes.dex */
public class TransferUtilityOptions implements Serializable {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferUtilityOptions.class);
    private static final int MILLIS_IN_MINUTE = 60000;
    private static final long serialVersionUID = 1;
    private long minimumUploadPartSizeInBytes;
    protected TransferNetworkConnectionType transferNetworkConnectionType;

    @Deprecated
    private long transferServiceCheckTimeInterval;
    private int transferThreadPoolSize;

    public TransferUtilityOptions() {
        this.transferServiceCheckTimeInterval = getDefaultCheckTimeInterval();
        this.transferThreadPoolSize = getDefaultThreadPoolSize();
        this.transferNetworkConnectionType = getDefaultTransferNetworkConnectionType();
        this.minimumUploadPartSizeInBytes = 5242880L;
    }

    @Deprecated
    public static long getDefaultCheckTimeInterval() {
        return 60000L;
    }

    public static int getDefaultThreadPoolSize() {
        return (Runtime.getRuntime().availableProcessors() + 1) * 2;
    }

    public static TransferNetworkConnectionType getDefaultTransferNetworkConnectionType() {
        return TransferNetworkConnectionType.ANY;
    }

    public long getMinimumUploadPartSizeInBytes() {
        return this.minimumUploadPartSizeInBytes;
    }

    public int getMinimumUploadPartSizeInMB() {
        return (int) (this.minimumUploadPartSizeInBytes / 1048576);
    }

    public TransferNetworkConnectionType getTransferNetworkConnectionType() {
        return this.transferNetworkConnectionType;
    }

    @Deprecated
    public long getTransferServiceCheckTimeInterval() {
        return this.transferServiceCheckTimeInterval;
    }

    public int getTransferThreadPoolSize() {
        return this.transferThreadPoolSize;
    }

    public void setMinimumUploadPartSizeInMB(int r5) {
        long j = r5 * 1048576;
        if (j > 5368709120L) {
            LOGGER.warn("The provided minimumUploadPartSize is greater than the maximum upload part size limit. Setting upload part size to the maximum allowed value of5MB.");
            this.minimumUploadPartSizeInBytes = 5368709120L;
        } else if (j < 5242880) {
            LOGGER.warn("The provided minimumUploadPartSize is less than the minimum upload part size limit. Setting upload part size to the minimum allowed value of5MB.");
            this.minimumUploadPartSizeInBytes = 5242880L;
        } else {
            this.minimumUploadPartSizeInBytes = j;
        }
    }

    public void setTransferThreadPoolSize(int r1) {
        if (r1 < 0) {
            this.transferThreadPoolSize = getDefaultThreadPoolSize();
        } else {
            this.transferThreadPoolSize = r1;
        }
    }

    public TransferUtilityOptions(int r3, TransferNetworkConnectionType transferNetworkConnectionType) {
        this.transferServiceCheckTimeInterval = getDefaultCheckTimeInterval();
        this.transferThreadPoolSize = r3;
        this.transferNetworkConnectionType = transferNetworkConnectionType;
        this.minimumUploadPartSizeInBytes = 5242880L;
    }

    @Deprecated
    public void setTransferServiceCheckTimeInterval(long j) {
    }
}
