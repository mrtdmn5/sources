package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.graphics.drawable.IconCompat;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class NotificationCompat$Builder {
    public final boolean mAllowSystemGeneratedContextualActions;
    public String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public IconCompat mLargeIcon;
    public final Notification mNotification;
    public int mNumber;

    @Deprecated
    public final ArrayList<String> mPeople;
    public int mPriority;
    public int mProgress;
    public boolean mProgressIndeterminate;
    public int mProgressMax;
    public NotificationCompat$Style mStyle;
    public final ArrayList<NotificationCompat$Action> mActions = new ArrayList<>();
    public final ArrayList<Person> mPersonList = new ArrayList<>();
    public final ArrayList<NotificationCompat$Action> mInvisibleActions = new ArrayList<>();
    public boolean mShowWhen = true;
    public boolean mLocalOnly = false;
    public int mColor = 0;
    public int mVisibility = 0;

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static AudioAttributes build(AudioAttributes.Builder builder) {
            return builder.build();
        }

        public static AudioAttributes.Builder createBuilder() {
            return new AudioAttributes.Builder();
        }

        public static AudioAttributes.Builder setContentType(AudioAttributes.Builder builder, int r1) {
            return builder.setContentType(r1);
        }

        public static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder builder, int r1) {
            return builder.setLegacyStreamType(r1);
        }

        public static AudioAttributes.Builder setUsage(AudioAttributes.Builder builder, int r1) {
            return builder.setUsage(r1);
        }
    }

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList<>();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        if (charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    public final void addAction(int r17, String str, PendingIntent pendingIntent) {
        IconCompat createWithResource;
        ArrayList<NotificationCompat$Action> arrayList = this.mActions;
        if (r17 == 0) {
            createWithResource = null;
        } else {
            createWithResource = IconCompat.createWithResource(null, "", r17);
        }
        arrayList.add(new NotificationCompat$Action(createWithResource, str, pendingIntent, new Bundle(), null, null, true, 0, true, false, false));
    }

    public final Notification build() {
        Notification build;
        Bundle bundle;
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat$Builder notificationCompat$Builder = notificationCompatBuilder.mBuilderCompat;
        NotificationCompat$Style notificationCompat$Style = notificationCompat$Builder.mStyle;
        if (notificationCompat$Style != null) {
            notificationCompat$Style.apply(notificationCompatBuilder);
        }
        int r3 = Build.VERSION.SDK_INT;
        Notification.Builder builder = notificationCompatBuilder.mBuilder;
        if (r3 >= 26) {
            build = NotificationCompatBuilder.Api16Impl.build(builder);
        } else {
            build = NotificationCompatBuilder.Api16Impl.build(builder);
        }
        if (notificationCompat$Style != null) {
            notificationCompat$Builder.mStyle.getClass();
        }
        if (notificationCompat$Style != null && (bundle = build.extras) != null) {
            notificationCompat$Style.addCompatExtras(bundle);
        }
        return build;
    }

    public final void setContentText(CharSequence charSequence) {
        this.mContentText = limitCharSequenceLength(charSequence);
    }

    public final void setContentTitle(CharSequence charSequence) {
        this.mContentTitle = limitCharSequenceLength(charSequence);
    }

    public final void setDefaults(int r2) {
        Notification notification = this.mNotification;
        notification.defaults = r2;
        if ((r2 & 4) != 0) {
            notification.flags |= 1;
        }
    }

    public final void setFlag(int r2, boolean z) {
        Notification notification = this.mNotification;
        if (z) {
            notification.flags = r2 | notification.flags;
        } else {
            notification.flags = (~r2) & notification.flags;
        }
    }

    public final void setLargeIcon(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.mObj1 = bitmap;
            iconCompat = iconCompat2;
        }
        this.mLargeIcon = iconCompat;
    }

    public final void setProgress(int r1, int r2, boolean z) {
        this.mProgressMax = r1;
        this.mProgress = r2;
        this.mProgressIndeterminate = z;
    }

    public final void setSound(Uri uri) {
        Notification notification = this.mNotification;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = Api21Impl.build(Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5));
    }

    public final void setStyle(NotificationCompat$Style notificationCompat$Style) {
        if (this.mStyle != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (notificationCompat$Style != null) {
                notificationCompat$Style.setBuilder(this);
            }
        }
    }
}
