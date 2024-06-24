package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmsApp.kt */
/* loaded from: classes3.dex */
public class AlarmsApp implements FirmwareApp {
    public static final String AlarmAppFile = "alarms.bin";
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "AlarmsApp";
    private final String type = TYPE;
    private final String analyticsName = TYPE;
    private final WatchAlarmProvider alarmsProvider = ServiceLocator.INSTANCE.getAlarmsProvider();
    private final Lazy mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.alarms.AlarmsApp$mitmapBackend$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MitmapBackend invoke() {
            return ServiceLocator.INSTANCE.getMitmapBackend();
        }
    });
    private final Mitmap icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Alarm_App_Icon, null, 2, null);
    private Function0<Boolean> checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.alarms.AlarmsApp$checkPermissions$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };
    private final AppId id = AppId.Alarm;

    /* compiled from: AlarmsApp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object getFiles$suspendImpl(com.animaconnected.watch.behaviour.alarms.AlarmsApp r4, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.files.WatchFile>> r5) {
        /*
            boolean r0 = r5 instanceof com.animaconnected.watch.behaviour.alarms.AlarmsApp$getFiles$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.watch.behaviour.alarms.AlarmsApp$getFiles$1 r0 = (com.animaconnected.watch.behaviour.alarms.AlarmsApp$getFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.alarms.AlarmsApp$getFiles$1 r0 = new com.animaconnected.watch.behaviour.alarms.AlarmsApp$getFiles$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)
            goto L41
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.provider.WatchAlarmProvider r4 = r4.alarmsProvider
            com.animaconnected.watch.CommonFlow r4 = r4.getAlarms()
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r4, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.util.List r5 = (java.util.List) r5
            java.lang.String r4 = "/ram/prefs"
            com.animaconnected.watch.device.files.WatchFile r4 = com.animaconnected.watch.behaviour.alarms.AlarmsAppKt.access$makeWatchFile(r5, r4)
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.alarms.AlarmsApp.getFiles$suspendImpl(com.animaconnected.watch.behaviour.alarms.AlarmsApp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[LOOP:2: B:38:0x00e5->B:40:0x00eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object onWatchFileChange$suspendImpl(com.animaconnected.watch.behaviour.alarms.AlarmsApp r19, com.animaconnected.watch.device.files.WatchFile r20, com.animaconnected.watch.DisplayWatch r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.alarms.AlarmsApp.onWatchFileChange$suspendImpl(com.animaconnected.watch.behaviour.alarms.AlarmsApp, com.animaconnected.watch.device.files.WatchFile, com.animaconnected.watch.DisplayWatch, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Function0<Boolean> getCheckPermissions() {
        return this.checkPermissions;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Object getFiles(Continuation<? super List<WatchFile>> continuation) {
        return getFiles$suspendImpl(this, continuation);
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Map<String, Mitmap> getImages() {
        return MapsKt__MapsKt.mapOf(new Pair("enable", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Alarm_App_Enabled, null, 2, null)), new Pair("disable", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Alarm_App_Disabled, null, 2, null)), new Pair("ringing", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Alarm_App_Ringing, null, 2, null)));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.alarm_app_title);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Object onWatchFileChange(WatchFile watchFile, DisplayWatch displayWatch, Continuation<? super Unit> continuation) {
        return onWatchFileChange$suspendImpl(this, watchFile, displayWatch, continuation);
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }
}
