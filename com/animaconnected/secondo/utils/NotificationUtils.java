package com.animaconnected.secondo.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.DeviceService$$ExternalSyntheticApiModelOutline4;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: NotificationUtils.kt */
/* loaded from: classes3.dex */
public final class NotificationUtils {
    public static final String DEFAULT_NOTIFICATION_CHANNEL_ID = "default";
    public static final String EXTRA_KEY_FEATURE_ISSUE = "feature_issue";
    public static final String EXTRA_KEY_PERMISSIONS = "permissions";
    public static final String EXTRA_KEY_POWER_OPTIMIZATION = "power_optimization";
    public static final String EXTRA_KEY_WORKOUT_COMPLETE = "com.animaconnected.secondo.WorkoutComplete";
    private static final int FEATURE_ISSUE_CODE = 202160901;
    private static final String WORKOUT_NOTIFICATION_CHANNEL_ID = "workout";
    private static final int WORKOUT_NOTIFICATION_COMPLETED_ID = 203271812;
    public static final NotificationUtils INSTANCE = new NotificationUtils();
    private static final HashMap<String, Integer> permissionIdMap = new HashMap<>();
    public static final int $stable = 8;

    private NotificationUtils() {
    }

    public static final NotificationCompat$Builder createNotificationBuilder(Context context, String channelId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return setIconAndColor(new NotificationCompat$Builder(context, channelId), context);
    }

    private final List<String> filterKeyList(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            boolean z = false;
            List split$default = StringsKt__StringsKt.split$default((String) obj, new String[]{","}, 0, 6);
            if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
                Iterator it = split$default.iterator();
                while (it.hasNext()) {
                    if (list.contains(StringsKt__StringsKt.trim((String) it.next()).toString())) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int generateNotificationId(String str) {
        int hashCode = str.hashCode();
        permissionIdMap.put(str, Integer.valueOf(hashCode));
        return hashCode;
    }

    public static final boolean isNightMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static final NotificationCompat$Builder setIconAndColor(NotificationCompat$Builder notificationCompat$Builder, Context context) {
        int color;
        Intrinsics.checkNotNullParameter(notificationCompat$Builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isNightMode(context)) {
            Object obj = ContextCompat.sLock;
            color = ContextCompat.Api23Impl.getColor(context, R.color.white);
        } else {
            Object obj2 = ContextCompat.sLock;
            color = ContextCompat.Api23Impl.getColor(context, R.color.notificationColor);
        }
        notificationCompat$Builder.mColor = color;
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_notification;
        return notificationCompat$Builder;
    }

    public static final void setupNotificationChannelIfNeeded(Context context) {
        NotificationManager notificationManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            if (systemService instanceof NotificationManager) {
                notificationManager = (NotificationManager) systemService;
            } else {
                notificationManager = null;
            }
            String string = context.getString(R.string.secondo_app_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DeviceService$$ExternalSyntheticApiModelOutline4.m();
            NotificationChannel m = NotificationUtils$$ExternalSyntheticApiModelOutline0.m(string);
            m.setSound(null, null);
            DeviceService$$ExternalSyntheticApiModelOutline4.m();
            NotificationChannel m2 = NotificationUtils$$ExternalSyntheticApiModelOutline1.m(string);
            m2.setSound(null, null);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(m);
                notificationManager.createNotificationChannel(m2);
            }
        }
    }

    public static final void showPermissionNotification(String title, String[] permissions, FeatureIssue featureIssue) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(featureIssue, "featureIssue");
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        Context context = companion.getContext();
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        Intent createStartApplicationIntent = companion.createStartApplicationIntent();
        createStartApplicationIntent.putExtra(EXTRA_KEY_FEATURE_ISSUE, featureIssue);
        createStartApplicationIntent.putExtra(EXTRA_KEY_PERMISSIONS, permissions);
        PendingIntent activity = PendingIntent.getActivity(companion.getContext(), 0, createStartApplicationIntent, 268435456 | AppUtils.getPendingIntentFlag());
        int generateNotificationId = INSTANCE.generateNotificationId(ArraysKt___ArraysKt.joinToString$default(permissions, null, null, 63));
        NotificationCompat$Builder createNotificationBuilder = createNotificationBuilder(context, DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setDefaults(6);
        createNotificationBuilder.setContentTitle(title);
        createNotificationBuilder.setContentText(context.getString(R.string.notification_body));
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setProgress(0, 0, false);
        createNotificationBuilder.setFlag(16, true);
        ((NotificationManager) systemService).notify(generateNotificationId, createNotificationBuilder.build());
    }

    public static final void showWorkoutCompletedNotification() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        Context context = companion.getContext();
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        Intent createStartApplicationIntent = companion.createStartApplicationIntent();
        createStartApplicationIntent.putExtra(EXTRA_KEY_WORKOUT_COMPLETE, true);
        PendingIntent activity = PendingIntent.getActivity(companion.getContext(), 0, createStartApplicationIntent, 268435456 | AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = createNotificationBuilder(context, WORKOUT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setDefaults(6);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_workout_new_title));
        createNotificationBuilder.setContentText(context.getString(R.string.notification_workout_new_body));
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setProgress(0, 0, false);
        createNotificationBuilder.setFlag(16, true);
        ((NotificationManager) systemService).notify(WORKOUT_NOTIFICATION_COMPLETED_ID, createNotificationBuilder.build());
    }

    public final void removeNotificationId(List<String> permissionNames) {
        Intrinsics.checkNotNullParameter(permissionNames, "permissionNames");
        Object systemService = KronabyApplication.Companion.getContext().getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        Set<String> keySet = permissionIdMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        for (String str : filterKeyList(permissionNames, CollectionsKt___CollectionsKt.toList(keySet))) {
            HashMap<String, Integer> hashMap = permissionIdMap;
            Integer num = hashMap.get(str);
            if (num != null) {
                notificationManager.cancel(num.intValue());
                hashMap.remove(str);
            }
        }
    }
}
