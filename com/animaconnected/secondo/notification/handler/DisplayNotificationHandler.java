package com.animaconnected.secondo.notification.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.provider.Telephony;
import android.service.notification.StatusBarNotification;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.notification.receiver.NotificationReceiver;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.PhoneNotification;
import com.animaconnected.watch.device.WatchEventListener;
import com.animaconnected.watch.filter.FilterSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DisplayNotificationHandler.kt */
/* loaded from: classes3.dex */
public final class DisplayNotificationHandler implements NotificationHandler {
    public static final String TYPE = "Notifications";
    private final Context context;
    private final String defaultSmsApp;
    private final FilterSettings filter;
    private final List<PhoneNotification> notificationList;
    private final NotificationReceiver notificationReceiver;
    private final CoroutineScope scope;
    private final List<String> skippedCategories;
    private final String tag;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DisplayNotificationHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DisplayNotificationHandler(NotificationReceiver notificationReceiver) {
        Intrinsics.checkNotNullParameter(notificationReceiver, "notificationReceiver");
        this.notificationReceiver = notificationReceiver;
        this.tag = "DisplayNotificationHandler";
        this.notificationList = new ArrayList();
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        Context context = companion.getContext();
        this.context = context;
        this.scope = companion.getScope();
        this.filter = ProviderFactory.getWatch().getWatchManager().getFilterSettings();
        this.defaultSmsApp = Telephony.Sms.getDefaultSmsPackage(context);
        ProviderFactory.getWatch().getWatchManager().registerEventListener(new WatchEventListener() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler.1
            @Override // com.animaconnected.watch.device.WatchEventListener
            public void onNotificationDismissed(int r2) {
                DisplayNotificationHandler.this.dismissNotification(r2);
            }

            @Override // com.animaconnected.watch.device.WatchEventListener
            public void onStopwatchDataChanged() {
            }

            @Override // com.animaconnected.watch.device.WatchEventListener
            public void onDeviceCrash(int r1) {
            }

            @Override // com.animaconnected.watch.device.WatchEventListener
            public void onStillnessEvent(int r1) {
            }
        });
        this.skippedCategories = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{AnalyticsConstants.KEY_SERVICE, "sys", "progress", "transport"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable getIconDrawable(StatusBarNotification statusBarNotification) {
        Icon largeIcon = statusBarNotification.getNotification().getLargeIcon();
        if (largeIcon == null) {
            largeIcon = statusBarNotification.getNotification().getSmallIcon();
        }
        return largeIcon.loadDrawable(this.context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r14, r12.defaultSmsApp) == false) goto L22;     */
    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean canHandle(final java.lang.String r13, final java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.animaconnected.watch.WatchProvider r0 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.Watch r5 = r0.getWatch()
            com.animaconnected.watch.device.CommandCenter r0 = r5.getCommandCenter()
            boolean r4 = r0.hasDisplay()
            com.animaconnected.secondo.provider.ProviderFactory r0 = com.animaconnected.secondo.provider.ProviderFactory.INSTANCE
            com.animaconnected.watch.provider.quiethours.QuietHoursProvider r0 = r0.getQuietHoursProvider()
            boolean r0 = r0.isActive()
            r1 = 1
            r0 = r0 ^ r1
            if (r4 == 0) goto L62
            java.util.List<java.lang.String> r3 = r12.skippedCategories
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r3 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r3, r13)
            if (r3 != 0) goto L62
            java.lang.String r3 = "com.kronaby.watch.app"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r3)
            if (r3 != 0) goto L62
            if (r0 != 0) goto L3f
            java.lang.String r0 = r12.defaultSmsApp
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r0)
            if (r0 == 0) goto L62
        L3f:
            com.animaconnected.watch.filter.FilterSettings r0 = r12.filter
            boolean r0 = r0.isAllAppsEnabled()
            if (r0 != 0) goto L63
            com.animaconnected.watch.filter.FilterSettings r0 = r12.filter
            com.animaconnected.watch.filter.Application r0 = r0.getApplication(r14)
            if (r0 == 0) goto L54
            com.animaconnected.watch.filter.ApplicationSetting r0 = r0.getSetting()
            goto L55
        L54:
            r0 = 0
        L55:
            com.animaconnected.watch.filter.ApplicationSetting r3 = com.animaconnected.watch.filter.ApplicationSetting.Important
            if (r0 == r3) goto L63
            java.lang.String r0 = r12.defaultSmsApp
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r0)
            if (r0 == 0) goto L62
            goto L63
        L62:
            r1 = 0
        L63:
            r7 = r1
            java.lang.String r8 = r12.tag
            r9 = 0
            r10 = 0
            com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$canHandle$1 r11 = new com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$canHandle$1
            r0 = r11
            r1 = r7
            r2 = r14
            r3 = r13
            r0.<init>()
            r5 = 6
            r6 = 0
            r0 = r12
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler.canHandle(java.lang.String, java.lang.String):boolean");
    }

    public final void dismissNotification(int r10) {
        Object obj;
        boolean z;
        Iterator<T> it = this.notificationList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((PhoneNotification) obj).getId() == r10) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        final PhoneNotification phoneNotification = (PhoneNotification) obj;
        if (phoneNotification == null) {
            return;
        }
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$dismissNotification$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "dismissNotification: " + PhoneNotification.this;
            }
        }, 6, (Object) null);
        this.notificationReceiver.cancelNotification(phoneNotification.getKey());
        CollectionsKt__ReversedViewsKt.removeAll(this.notificationList, new Function1<PhoneNotification, Boolean>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$dismissNotification$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PhoneNotification it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it2.getKey(), PhoneNotification.this.getKey()));
            }
        });
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handle(StatusBarNotification sbn, long j) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Watch watch = ProviderFactory.getWatch().getWatch();
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        if (displayWatch == null) {
            return;
        }
        BuildersKt.launch$default(this.scope, Dispatchers.IO, null, new DisplayNotificationHandler$handle$1(sbn, this, displayWatch, null), 2);
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handleRemoval(final StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "handleRemoval: " + sbn.getKey() + " and package: " + sbn.getPackageName();
            }
        }, 6, (Object) null);
        if (!CollectionsKt__ReversedViewsKt.removeAll(this.notificationList, new Function1<PhoneNotification, Boolean>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$removed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PhoneNotification it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getKey(), sbn.getKey()));
            }
        })) {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "handleRemoval: Nothing done";
                }
            }, 6, (Object) null);
            return;
        }
        CoroutineScope coroutineScope = this.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new DisplayNotificationHandler$handleRemoval$3(this, sbn, null), 2);
    }
}
