package androidx.work;

import android.app.Notification;

/* loaded from: classes.dex */
public final class ForegroundInfo {
    public final int mForegroundServiceType;
    public final Notification mNotification;
    public final int mNotificationId;

    public ForegroundInfo(int notificationId, int notification, Notification foregroundServiceType) {
        this.mNotificationId = notificationId;
        this.mNotification = foregroundServiceType;
        this.mForegroundServiceType = notification;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || ForegroundInfo.class != o.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) o;
        if (this.mNotificationId != foregroundInfo.mNotificationId || this.mForegroundServiceType != foregroundInfo.mForegroundServiceType) {
            return false;
        }
        return this.mNotification.equals(foregroundInfo.mNotification);
    }

    public final int hashCode() {
        return this.mNotification.hashCode() + (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.mNotificationId + ", mForegroundServiceType=" + this.mForegroundServiceType + ", mNotification=" + this.mNotification + '}';
    }
}
