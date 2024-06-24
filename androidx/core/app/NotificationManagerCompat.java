package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public final NotificationManager mNotificationManager;

    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static boolean areNotificationsEnabled(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int getImportance(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static {
        new HashSet();
    }

    public NotificationManagerCompat(Context context) {
        this.mNotificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }
}
