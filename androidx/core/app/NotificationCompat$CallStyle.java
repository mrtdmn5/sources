package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class NotificationCompat$CallStyle extends NotificationCompat$Style {

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
        bundle.putInt("android.callType", 0);
        bundle.putBoolean("android.callIsVideo", false);
        bundle.putCharSequence("android.verificationText", null);
        bundle.putParcelable("android.answerIntent", null);
        bundle.putParcelable("android.declineIntent", null);
        bundle.putParcelable("android.hangUpIntent", null);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(NotificationCompatBuilder notificationCompatBuilder) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 31) {
            if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(0));
                return;
            }
            return;
        }
        Notification.Builder builder = notificationCompatBuilder.mBuilder;
        CharSequence charSequence2 = null;
        builder.setContentTitle(null);
        Bundle bundle = this.mBuilder.mExtras;
        if (bundle != null && bundle.containsKey("android.text")) {
            charSequence = this.mBuilder.mExtras.getCharSequence("android.text");
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            charSequence2 = charSequence;
        }
        builder.setContentText(charSequence2);
        Api21Impl.setCategory(builder, "call");
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }
}
