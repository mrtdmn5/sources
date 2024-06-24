package androidx.work;

/* loaded from: classes.dex */
public final class Constraints {
    public static final Constraints NONE = new Constraints(new Builder());
    public ContentUriTriggers mContentUriTriggers;
    public NetworkType mRequiredNetworkType;
    public boolean mRequiresBatteryNotLow;
    public boolean mRequiresCharging;
    public boolean mRequiresDeviceIdle;
    public boolean mRequiresStorageNotLow;
    public long mTriggerContentUpdateDelay;
    public long mTriggerMaxContentDelay;

    /* loaded from: classes.dex */
    public static final class Builder {
        public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        public final long mTriggerContentUpdateDelay = -1;
        public final long mTriggerContentMaxDelay = -1;
        public final ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
    }

    public Constraints() {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1L;
        this.mTriggerMaxContentDelay = -1L;
        this.mContentUriTriggers = new ContentUriTriggers();
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Constraints.class != o.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) o;
        if (this.mRequiresCharging != constraints.mRequiresCharging || this.mRequiresDeviceIdle != constraints.mRequiresDeviceIdle || this.mRequiresBatteryNotLow != constraints.mRequiresBatteryNotLow || this.mRequiresStorageNotLow != constraints.mRequiresStorageNotLow || this.mTriggerContentUpdateDelay != constraints.mTriggerContentUpdateDelay || this.mTriggerMaxContentDelay != constraints.mTriggerMaxContentDelay || this.mRequiredNetworkType != constraints.mRequiredNetworkType) {
            return false;
        }
        return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
    }

    public final int hashCode() {
        int hashCode = ((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31;
        long j = this.mTriggerContentUpdateDelay;
        int r0 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.mTriggerMaxContentDelay;
        return this.mContentUriTriggers.hashCode() + ((r0 + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public Constraints(Builder builder) {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1L;
        this.mTriggerMaxContentDelay = -1L;
        new ContentUriTriggers();
        this.mRequiresCharging = false;
        this.mRequiresDeviceIdle = false;
        this.mRequiredNetworkType = builder.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = false;
        this.mRequiresStorageNotLow = false;
        this.mContentUriTriggers = builder.mContentUriTriggers;
        this.mTriggerContentUpdateDelay = builder.mTriggerContentUpdateDelay;
        this.mTriggerMaxContentDelay = builder.mTriggerContentMaxDelay;
    }

    public Constraints(Constraints other) {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1L;
        this.mTriggerMaxContentDelay = -1L;
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = other.mRequiresCharging;
        this.mRequiresDeviceIdle = other.mRequiresDeviceIdle;
        this.mRequiredNetworkType = other.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = other.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = other.mRequiresStorageNotLow;
        this.mContentUriTriggers = other.mContentUriTriggers;
    }
}
