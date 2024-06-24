package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class NotificationCompat$BigPictureStyle extends NotificationCompat$Style {
    public IconCompat mBigLargeIcon;
    public boolean mBigLargeIconSet;
    public IconCompat mPictureIcon;

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static Notification.BigPictureStyle bigPicture(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
            return bigPictureStyle.bigPicture(bitmap);
        }

        public static Notification.BigPictureStyle createBigPictureStyle(Notification.Builder builder) {
            return new Notification.BigPictureStyle(builder);
        }

        public static Notification.BigPictureStyle setBigContentTitle(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            return bigPictureStyle.setBigContentTitle(charSequence);
        }

        public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
            bigPictureStyle.bigLargeIcon(bitmap);
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigLargeIcon(icon);
        }
    }

    /* loaded from: classes.dex */
    public static class Api31Impl {
        public static void setBigPicture(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigPicture(icon);
        }

        public static void setContentDescription(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            bigPictureStyle.setContentDescription(charSequence);
        }

        public static void showBigPictureWhenCollapsed(Notification.BigPictureStyle bigPictureStyle, boolean z) {
            bigPictureStyle.showBigPictureWhenCollapsed(z);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(NotificationCompatBuilder notificationCompatBuilder) {
        Bitmap createLegacyIconFromAdaptiveIcon;
        int r0 = Build.VERSION.SDK_INT;
        Notification.BigPictureStyle bigContentTitle = Api16Impl.setBigContentTitle(Api16Impl.createBigPictureStyle(notificationCompatBuilder.mBuilder), null);
        IconCompat iconCompat = this.mPictureIcon;
        Context context = notificationCompatBuilder.mContext;
        if (iconCompat != null) {
            if (r0 >= 31) {
                Api31Impl.setBigPicture(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat, context));
            } else {
                int r5 = iconCompat.mType;
                if (r5 == -1) {
                    r5 = IconCompat.Api23Impl.getType(iconCompat.mObj1);
                }
                if (r5 == 1) {
                    IconCompat iconCompat2 = this.mPictureIcon;
                    int r7 = iconCompat2.mType;
                    if (r7 == -1) {
                        Object obj = iconCompat2.mObj1;
                        if (obj instanceof Bitmap) {
                            createLegacyIconFromAdaptiveIcon = (Bitmap) obj;
                        } else {
                            createLegacyIconFromAdaptiveIcon = null;
                        }
                    } else if (r7 == 1) {
                        createLegacyIconFromAdaptiveIcon = (Bitmap) iconCompat2.mObj1;
                    } else if (r7 == 5) {
                        createLegacyIconFromAdaptiveIcon = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap) iconCompat2.mObj1, true);
                    } else {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bigContentTitle = Api16Impl.bigPicture(bigContentTitle, createLegacyIconFromAdaptiveIcon);
                }
            }
        }
        if (this.mBigLargeIconSet) {
            IconCompat iconCompat3 = this.mBigLargeIcon;
            if (iconCompat3 == null) {
                Api16Impl.setBigLargeIcon(bigContentTitle, null);
            } else {
                Api23Impl.setBigLargeIcon(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat3, context));
            }
        }
        if (r0 >= 31) {
            Api31Impl.showBigPictureWhenCollapsed(bigContentTitle, false);
            Api31Impl.setContentDescription(bigContentTitle, null);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
