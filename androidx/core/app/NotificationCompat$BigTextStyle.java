package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
    public CharSequence mBigText;

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static Notification.BigTextStyle bigText(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.bigText(charSequence);
        }

        public static Notification.BigTextStyle createBigTextStyle(Notification.Builder builder) {
            return new Notification.BigTextStyle(builder);
        }

        public static Notification.BigTextStyle setBigContentTitle(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.setBigContentTitle(charSequence);
        }

        public static Notification.BigTextStyle setSummaryText(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
            return bigTextStyle.setSummaryText(charSequence);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(NotificationCompatBuilder notificationCompatBuilder) {
        Api16Impl.bigText(Api16Impl.setBigContentTitle(Api16Impl.createBigTextStyle(notificationCompatBuilder.mBuilder), null), this.mBigText);
    }

    public final void bigText(CharSequence charSequence) {
        this.mBigText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
