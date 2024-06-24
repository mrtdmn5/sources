package com.animaconnected.secondo.notification.receiver;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.notification.handler.DisplayNotificationHandler;
import com.animaconnected.secondo.notification.handler.EmailNotificationHandler;
import com.animaconnected.secondo.notification.handler.EventNotificationHandler;
import com.animaconnected.secondo.notification.handler.ImportantAppHandler;
import com.animaconnected.secondo.notification.handler.NotificationHandler;
import com.animaconnected.secondo.provider.NotificationDetailsAnalyticsKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: NotificationReceiver.kt */
/* loaded from: classes3.dex */
public final class NotificationReceiver extends NotificationListenerService {
    private final List<NotificationHandler> notificationHandlers = new ArrayList();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "NotificationReceiver";

    /* compiled from: NotificationReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.notificationHandlers.add(new EventNotificationHandler());
        List<NotificationHandler> list = this.notificationHandlers;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        list.add(new EmailNotificationHandler(applicationContext));
        this.notificationHandlers.add(new DisplayNotificationHandler(this));
        this.notificationHandlers.add(new ImportantAppHandler());
        this.notificationHandlers.add(ProviderFactory.getMusicDataProvider());
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.notificationHandlers.clear();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(final StatusBarNotification sbn) {
        String str;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        final Notification notification = sbn.getNotification();
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        final long notificationGenerationId = providerFactory.getNotificationCenter().getNotificationGenerationId();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.verbose$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.receiver.NotificationReceiver$onNotificationPosted$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String trimMargin;
                trimMargin = StringsKt__IndentKt.trimMargin("onNotificationPosted() gen id: " + notificationGenerationId + " sbn id: " + sbn.getId() + " notification id: " + sbn.getNotification().extras.get("android.intent.extra.NOTIFICATION_ID") + " \n                |category: " + notification.category + " package: " + sbn.getPackageName(), "|");
                return trimMargin;
            }
        }, 6, (Object) null);
        String str2 = notification.category;
        String packageName = sbn.getPackageName();
        if (Build.VERSION.SDK_INT >= 26) {
            str = sbn.getNotification().getChannelId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(sbn.getPackageName(), "com.facebook.orca") && str != null && StringsKt__StringsKt.contains(str, "messenger_orca_800_live_location", false)) {
            return;
        }
        if (Intrinsics.areEqual(sbn.getPackageName(), "com.snapchat.android") && str2 == null) {
            return;
        }
        if (str2 != null && Intrinsics.areEqual(str2, "progress")) {
            return;
        }
        if (UserCategoryKt.useDogfoodingLogger(ProviderFactory.getWatch().getUserCategory())) {
            try {
                NotificationDetailsAnalyticsKt.sendDetailedAnalytics(sbn, providerFactory.getAnalytics());
            } catch (Exception e) {
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                LogKt.verbose((Object) this, TAG3, (Throwable) e, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.secondo.notification.receiver.NotificationReceiver$onNotificationPosted$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to send detailed notification analytics";
                    }
                });
            }
        }
        List<NotificationHandler> list = this.notificationHandlers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Intrinsics.checkNotNull(packageName);
            if (((NotificationHandler) obj).canHandle(str2, packageName)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((NotificationHandler) it.next()).handle(sbn, notificationGenerationId);
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return;
        }
        Iterator<T> it = this.notificationHandlers.iterator();
        while (it.hasNext()) {
            ((NotificationHandler) it.next()).handleRemoval(statusBarNotification);
        }
    }
}
