package com.animaconnected.secondo.provider.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviours;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnalyticsConfigHelper.kt */
/* loaded from: classes3.dex */
public final class AnalyticsConfigHelper {
    private static final String ANALYTICS_SLOT_EMPTY = "empty";
    private static final String ANALYTICS_SLOT_NOT_SUPPORTED = "not_supported";
    private static final int NR_OF_FILTER_NOTIFICATION_SLOTS = 12;
    private final AppEvents analyticsFeatureProvider;
    private final Behaviours behaviours;
    private final Context context;
    private final NotificationProvider notificationProvider;
    private final CoroutineScope scope;
    private final Lazy storage$delegate;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AnalyticsConfigHelper.kt */
    /* loaded from: classes3.dex */
    public static final class AnalyticsConfigStorage {
        private static final String ANALYTICS_CONFIG_STORAGE = "analyticsConfigStorage";
        public static final Companion Companion = new Companion(null);
        private static final String KEY_LAST_APP_UPDATE = "lastAppUpdate";
        private final Context context;

        /* compiled from: AnalyticsConfigHelper.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public AnalyticsConfigStorage(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        private final SharedPreferences getSharedPreferences() {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(ANALYTICS_CONFIG_STORAGE, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return sharedPreferences;
        }

        public final long getLastStoredAppUpdate() {
            return getSharedPreferences().getLong(KEY_LAST_APP_UPDATE, 0L);
        }

        public final void setLastAppUpdate(long j) {
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.putLong(KEY_LAST_APP_UPDATE, j);
            edit.apply();
        }
    }

    /* compiled from: AnalyticsConfigHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AnalyticsConfigHelper(Context context, WatchProvider watchProvider, NotificationProvider notificationProvider, AppEvents analyticsFeatureProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        Intrinsics.checkNotNullParameter(notificationProvider, "notificationProvider");
        Intrinsics.checkNotNullParameter(analyticsFeatureProvider, "analyticsFeatureProvider");
        this.context = context;
        this.watchProvider = watchProvider;
        this.notificationProvider = notificationProvider;
        this.analyticsFeatureProvider = analyticsFeatureProvider;
        this.storage$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AnalyticsConfigStorage>() { // from class: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$storage$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AnalyticsConfigHelper.AnalyticsConfigStorage invoke() {
                Context context2;
                context2 = AnalyticsConfigHelper.this.context;
                return new AnalyticsConfigHelper.AnalyticsConfigStorage(context2);
            }
        });
        this.behaviours = watchProvider.getWatchManager().getBehaviours();
        this.scope = KronabyApplication.Companion.getScope();
    }

    private final long getLastAppInstall() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getApplicationInfo().packageName, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0L;
        }
    }

    private final AnalyticsConfigStorage getStorage() {
        return (AnalyticsConfigStorage) this.storage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendComplicationAnalytics(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendComplicationAnalytics$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendComplicationAnalytics$1 r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendComplicationAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendComplicationAnalytics$1 r0 = new com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendComplicationAnalytics$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7b
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3a:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r2 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.behaviour.Behaviours r7 = r6.behaviours
            com.animaconnected.watch.Slot r2 = com.animaconnected.watch.Slot.MainComplication
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getBehaviour(r2, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r2 = r6
        L55:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getAnalyticsName()
            com.animaconnected.watch.WatchProvider r4 = r2.watchProvider
            com.animaconnected.watch.device.Capabilities r4 = r4.getCapabilities()
            boolean r4 = r4.getHasDoubleMainComplication()
            if (r4 == 0) goto L83
            com.animaconnected.watch.behaviour.Behaviours r4 = r2.behaviours
            com.animaconnected.watch.Slot r5 = com.animaconnected.watch.Slot.MainComplicationDouble
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = r4.getBehaviour(r5, r0)
            if (r0 != r1) goto L78
            return r1
        L78:
            r1 = r7
            r7 = r0
            r0 = r2
        L7b:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getAnalyticsName()
            r2 = r0
            goto L87
        L83:
            java.lang.String r0 = "not_supported"
            r1 = r7
            r7 = r0
        L87:
            com.animaconnected.firebase.AppEvents r0 = r2.analyticsFeatureProvider
            r0.sendComplicationSetting(r1, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper.sendComplicationAnalytics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendFilterNotificationAnalytics$lambda$1(AnalyticsConfigHelper this$0, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppEvents appEvents = this$0.analyticsFeatureProvider;
        String[] strArr = new String[12];
        for (int r3 = 0; r3 < 12; r3++) {
            strArr[r3] = ANALYTICS_SLOT_EMPTY;
        }
        ArrayList arrayList = new ArrayList(12);
        int r4 = 0;
        int r5 = 0;
        while (r4 < 12) {
            String str = strArr[r4];
            int r7 = r5 + 1;
            if (hashMap.containsKey(Integer.valueOf(r5))) {
                str = (String) hashMap.get(Integer.valueOf(r5));
            }
            arrayList.add(str);
            r4++;
            r5 = r7;
        }
        appEvents.sendFilterNotificationSetting((String[]) arrayList.toArray(new String[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendFullAppConfig(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendFullAppConfig$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendFullAppConfig$1 r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendFullAppConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendFullAppConfig$1 r0 = new com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendFullAppConfig$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6f
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L39:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r2 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L63
        L41:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r2 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L49:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.sendPusherAnalytics(r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            r2 = r6
        L58:
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r2.sendComplicationAnalytics(r0)
            if (r7 != r1) goto L63
            return r1
        L63:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r2.sendSubComplicationAnalytics(r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            r0 = r2
        L6f:
            r0.sendFilterNotificationAnalytics()
            r0.sendWatchAppAnalytics()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper.sendFullAppConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendPusherAnalytics(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendPusherAnalytics$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendPusherAnalytics$1 r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendPusherAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendPusherAnalytics$1 r0 = new com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendPusherAnalytics$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6f
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3a:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r2 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.behaviour.Behaviours r7 = r6.behaviours
            com.animaconnected.watch.Slot r2 = com.animaconnected.watch.Slot.TopPusher
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getBehaviour(r2, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r2 = r6
        L55:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getAnalyticsName()
            com.animaconnected.watch.behaviour.Behaviours r4 = r2.behaviours
            com.animaconnected.watch.Slot r5 = com.animaconnected.watch.Slot.BottomPusher
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = r4.getBehaviour(r5, r0)
            if (r0 != r1) goto L6c
            return r1
        L6c:
            r1 = r7
            r7 = r0
            r0 = r2
        L6f:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getAnalyticsName()
            com.animaconnected.firebase.AppEvents r0 = r0.analyticsFeatureProvider
            r0.sendPusherSetting(r1, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper.sendPusherAnalytics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSubComplicationAnalytics(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendSubComplicationAnalytics$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendSubComplicationAnalytics$1 r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendSubComplicationAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendSubComplicationAnalytics$1 r0 = new com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendSubComplicationAnalytics$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            java.lang.String r3 = "not_supported"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r0 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L8c
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper r2 = (com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L63
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchProvider r7 = r6.watchProvider
            com.animaconnected.watch.device.Capabilities r7 = r7.getCapabilities()
            boolean r7 = r7.hasSubComplications()
            if (r7 == 0) goto L6a
            com.animaconnected.watch.behaviour.Behaviours r7 = r6.behaviours
            com.animaconnected.watch.Slot r2 = com.animaconnected.watch.Slot.SubComplication1
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.getBehaviour(r2, r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            r2 = r6
        L63:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getAnalyticsName()
            goto L6c
        L6a:
            r2 = r6
            r7 = r3
        L6c:
            com.animaconnected.watch.WatchProvider r5 = r2.watchProvider
            com.animaconnected.watch.device.Capabilities r5 = r5.getCapabilities()
            boolean r5 = r5.hasTwoSubComplications()
            if (r5 == 0) goto L94
            com.animaconnected.watch.behaviour.Behaviours r3 = r2.behaviours
            com.animaconnected.watch.Slot r5 = com.animaconnected.watch.Slot.SubComplication2
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r0 = r3.getBehaviour(r5, r0)
            if (r0 != r1) goto L89
            return r1
        L89:
            r1 = r7
            r7 = r0
            r0 = r2
        L8c:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r3 = r7.getAnalyticsName()
            r2 = r0
            r7 = r1
        L94:
            com.animaconnected.firebase.AppEvents r0 = r2.analyticsFeatureProvider
            r0.sendSubComplicationSetting(r7, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper.sendSubComplicationAnalytics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void sendWatchAppAnalytics() {
        boolean z;
        String appPositionsAnalytics = this.behaviours.getAppPositionsAnalytics();
        if (appPositionsAnalytics.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.analyticsFeatureProvider.displayAppSendAllPositions(appPositionsAnalytics);
        }
    }

    public final void sendAppConfigIfAppHasBeenUpdated() {
        long lastAppInstall = getLastAppInstall();
        if (lastAppInstall != getStorage().getLastStoredAppUpdate()) {
            getStorage().setLastAppUpdate(lastAppInstall);
            BuildersKt.launch$default(this.scope, null, null, new AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1(this, null), 3);
        }
    }

    public final void sendCorrectAnalyticsConfig(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BuildersKt.launch$default(this.scope, null, null, new AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1(slot, this, null), 3);
    }

    public final void sendFilterNotificationAnalytics() {
        this.notificationProvider.getFilterNotificationConfig().success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                AnalyticsConfigHelper.sendFilterNotificationAnalytics$lambda$1(AnalyticsConfigHelper.this, (HashMap) obj);
            }
        });
    }
}
