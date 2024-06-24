package com.animaconnected.secondo.notification;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.BuildConfig;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.RunOnUIThread;
import com.animaconnected.watch.WatchProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationCenter.kt */
/* loaded from: classes3.dex */
public final class NotificationCenter {
    public static final String INCOMING_CALL_ENDED_OR_ONGOING = "incoming_call_ended_or_ongoing";
    public static final String INCOMING_CALL_RINGING = "incoming_call_ringing";
    private static final long MIN_TIME_BETWEEN_NOTIFICATIONS_MS = 5000;
    public static final NotificationCenter INSTANCE = new NotificationCenter();
    private static final String TAG = "NotificationCenter";
    private static final AtomicLong sCurrentNotificationId = new AtomicLong(0);
    private static final List<Long> sLastHandledIds = Collections.synchronizedList(new ArrayList(CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{-1L, -1L, -1L, -1L, -1L})));
    private static final Set<NotificationListener> sListeners = new CopyOnWriteArraySet();
    private static long sLatestNotification = System.currentTimeMillis() - 5000;
    public static final int $stable = 8;

    private NotificationCenter() {
    }

    private final void checkNotification(final DeviceNotification deviceNotification, int r13) {
        boolean z = true;
        int r132 = r13 + 1;
        WatchProvider watch = ProviderFactory.getWatch();
        if (Intrinsics.areEqual(deviceNotification.getCategory(), "call")) {
            sendIncomingCallToDevice(deviceNotification, Integer.valueOf(r132));
        } else if (System.currentTimeMillis() - sLatestNotification > 5000) {
            if (!Intrinsics.areEqual(deviceNotification.getPackageName(), BuildConfig.APPLICATION_ID)) {
                watch.alert(r132);
            }
            sLatestNotification = System.currentTimeMillis();
        } else {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.info$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.NotificationCenter$checkNotification$notificationSent$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Notification already sent a moment ago\n (" + DeviceNotification.this + ')';
                }
            }, 6, (Object) null);
            z = false;
        }
        if (z) {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LogKt.info$default((Object) this, TAG3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.NotificationCenter$checkNotification$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Notification sent to device! (" + DeviceNotification.this + ')';
                }
            }, 6, (Object) null);
            Iterator<T> it = sListeners.iterator();
            while (it.hasNext()) {
                ((NotificationListener) it.next()).onNotificationHandled(deviceNotification);
            }
        }
    }

    public static /* synthetic */ void handleNotification$default(NotificationCenter notificationCenter, String str, String str2, CharSequence charSequence, String str3, long j, List list, int r17, Object obj) {
        String str4;
        long j2;
        List list2;
        if ((r17 & 8) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if ((r17 & 16) != 0) {
            j2 = notificationCenter.getNotificationGenerationId();
        } else {
            j2 = j;
        }
        if ((r17 & 32) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        notificationCenter.handleNotification(str, str2, charSequence, str4, j2, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleNotification$lambda$3(List list, String str, String str2, CharSequence charSequence, String str3, long j) {
        HashSet hashSet;
        String str4;
        boolean z;
        if (ProviderFactory.getWatch().getWatch().getCommandCenter().hasDisplay()) {
            return;
        }
        if (list != null) {
            hashSet = new HashSet(list);
        } else {
            hashSet = null;
        }
        if (charSequence != null) {
            str4 = charSequence.toString();
        } else {
            str4 = null;
        }
        final DeviceNotification deviceNotification = new DeviceNotification(str, str2, str4, str3, hashSet);
        if (Intrinsics.areEqual(deviceNotification.getCategory(), "event")) {
            Iterator<T> it = sListeners.iterator();
            while (it.hasNext()) {
                ((NotificationListener) it.next()).onNotificationWithCategoryEvent(deviceNotification);
            }
        }
        List<Long> list2 = sLastHandledIds;
        if (list2.contains(Long.valueOf(j))) {
            return;
        }
        int valid = ProviderFactory.getCriteriaProvider().getRootCriteria().valid(deviceNotification);
        if (valid != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            list2.add(Long.valueOf(j));
            list2.remove(0);
            INSTANCE.checkNotification(deviceNotification, valid);
        } else {
            if (Intrinsics.areEqual(deviceNotification.getCategory(), "call")) {
                INSTANCE.sendIncomingCallToDevice(deviceNotification, null);
                return;
            }
            NotificationCenter notificationCenter = INSTANCE;
            if (notificationCenter.isDebugEnabled()) {
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                LogKt.info$default((Object) notificationCenter, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.NotificationCenter$handleNotification$1$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Notification not sent! (" + DeviceNotification.this + ')';
                    }
                }, 6, (Object) null);
            }
        }
    }

    private final boolean isDebugEnabled() {
        return false;
    }

    private final void sendIncomingCallToDevice(DeviceNotification deviceNotification, Integer num) {
        if (!Intrinsics.areEqual(deviceNotification.getCategory(), "call")) {
            return;
        }
        if (Intrinsics.areEqual(deviceNotification.getMessage(), INCOMING_CALL_RINGING)) {
            ProviderFactory.getWatch().incomingCall(1, true, num);
        } else if (Intrinsics.areEqual(deviceNotification.getMessage(), INCOMING_CALL_ENDED_OR_ONGOING)) {
            ProviderFactory.getWatch().incomingCall(1, false, null);
        }
    }

    public final void addListener(NotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sListeners.add(listener);
    }

    public final long getNotificationGenerationId() {
        return sCurrentNotificationId.getAndIncrement();
    }

    public final void handleNotification(final String str, final String str2, final CharSequence charSequence, final String str3, final long j, final List<String> list) {
        RunOnUIThread.post(new Runnable() { // from class: com.animaconnected.secondo.notification.NotificationCenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NotificationCenter.handleNotification$lambda$3(list, str, str2, charSequence, str3, j);
            }
        });
    }

    public final void removeListener(NotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sListeners.remove(listener);
    }
}
