package androidx.core.app;

import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class NotificationCompat$Style {
    public NotificationCompat$Builder mBuilder;

    public void addCompatExtras(Bundle bundle) {
        String className = getClassName();
        if (className != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", className);
        }
    }

    public abstract void apply(NotificationCompatBuilder notificationCompatBuilder);

    public abstract String getClassName();

    public final void setBuilder(NotificationCompat$Builder notificationCompat$Builder) {
        if (this.mBuilder != notificationCompat$Builder) {
            this.mBuilder = notificationCompat$Builder;
            if (notificationCompat$Builder != null) {
                notificationCompat$Builder.setStyle(this);
            }
        }
    }
}
