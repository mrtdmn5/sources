package com.animaconnected.watch.behaviour.workout;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.display.QuickActionType;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.fitness.DBSpeedCalibration;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.preferences.Pref;
import com.animaconnected.watch.provider.preferences.PreferenceValue;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Workout.kt */
/* loaded from: classes3.dex */
public final class Workout implements FirmwareApp {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "Workout";
    private final String analyticsName;
    private final List<WatchAsset> assets;
    private Function0<Boolean> checkPermissions;
    private final Mitmap icon;
    private final AppId id;
    private final boolean isHidden;
    private final Lazy mitmapBackend$delegate;
    private final QuickActionType quickActionType;
    private final String type;
    private DisplayWatch watch;

    /* compiled from: Workout.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Workout(Function0<Boolean> checkPermissions) {
        Intrinsics.checkNotNullParameter(checkPermissions, "checkPermissions");
        this.checkPermissions = checkPermissions;
        this.mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.workout.Workout$mitmapBackend$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MitmapBackend invoke() {
                return ServiceLocator.INSTANCE.getMitmapBackend();
            }
        });
        this.type = TYPE;
        this.analyticsName = TYPE;
        this.id = AppId.Workout;
        this.icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Workout_App_Icon, null, 2, null);
        this.quickActionType = QuickActionType.LaunchApp;
        this.assets = CollectionsKt__CollectionsKt.listOf((Object[]) new WatchAsset[]{WatchAsset.Workout_Run_Icon, WatchAsset.Workout_Walk_Icon, WatchAsset.Workout_Bike_Icon, WatchAsset.Workout_Pause_Icon, WatchAsset.Workout_Other_Icon, WatchAsset.Workout_GPS_None_Icon, WatchAsset.Workout_GPS_Good_Icon, WatchAsset.Workout_GPS_Bad_Icon});
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    @Override // com.animaconnected.watch.display.FirmwareApp, com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.Display};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(watch, "watch");
        super.connected(watch);
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        this.watch = displayWatch;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void disconnected(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        super.disconnected(watch);
        this.watch = null;
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
        DBSpeedCalibration latestSpeedCalibrationCoefficient$watch_release;
        DisplayWatch displayWatch = this.watch;
        Integer num = null;
        if (displayWatch == null) {
            return null;
        }
        FitnessSyncWatch fitnessSync$watch_release = displayWatch.getFitnessSync$watch_release();
        if (fitnessSync$watch_release != null && (latestSpeedCalibrationCoefficient$watch_release = fitnessSync$watch_release.getLatestSpeedCalibrationCoefficient$watch_release()) != null) {
            num = new Integer(latestSpeedCalibrationCoefficient$watch_release.getCoefficient());
        }
        if (num != null) {
            displayWatch.getPreferences$watch_release().setPreference(Pref.SpeedCoefficient, new int[]{num.intValue()}, false);
        }
        return CollectionsKt__CollectionsKt.listOf(new WatchFile(WatchFileSystem.prefsDir, WatchFileSystem.workoutPrefFile, PreferenceValue.Companion.encodeToMsgpack(displayWatch.getPreferences$watch_release().getPreferenceValuesForFile(WatchFileSystem.workoutPrefFile)), true));
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
        List<WatchAsset> list = this.assets;
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (WatchAsset watchAsset : list) {
            String fwName = watchAsset.getFwName();
            Intrinsics.checkNotNull(fwName);
            linkedHashMap.put(fwName, MitmapBackend.getMitmap$default(getMitmapBackend(), watchAsset, null, 2, null));
        }
        return linkedHashMap;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public QuickActionType getQuickActionType() {
        return this.quickActionType;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.workout_name);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public boolean isHidden() {
        return this.isHidden;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp, com.animaconnected.watch.display.WatchApp
    public void onStateChanged(VisibilityState state) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(state, "state");
        super.onStateChanged(state);
        if (state == VisibilityState.Glanceable && (displayWatch = this.watch) != null) {
            displayWatch.reSync$watch_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.display.FirmwareApp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onWatchFileChange(com.animaconnected.watch.device.files.WatchFile r5, com.animaconnected.watch.DisplayWatch r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.behaviour.workout.Workout$onWatchFileChange$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.behaviour.workout.Workout$onWatchFileChange$1 r0 = (com.animaconnected.watch.behaviour.workout.Workout$onWatchFileChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.workout.Workout$onWatchFileChange$1 r0 = new com.animaconnected.watch.behaviour.workout.Workout$onWatchFileChange$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.animaconnected.watch.DisplayWatch r6 = (com.animaconnected.watch.DisplayWatch) r6
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.device.files.WatchFile r5 = (com.animaconnected.watch.device.files.WatchFile) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L48
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = super.onWatchFileChange(r5, r6, r0)
            if (r7 != r1) goto L48
            return r1
        L48:
            java.lang.String r7 = r5.getName()
            java.lang.String r0 = "prefs_workout.msg"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r7 == 0) goto L62
            com.animaconnected.watch.provider.preferences.PreferenceProvider r6 = r6.getPreferences$watch_release()
            byte[] r5 = r5.getBytes()
            r7 = 2
            r0 = 0
            r1 = 0
            com.animaconnected.watch.provider.preferences.PreferenceProvider.setPreferences$default(r6, r5, r1, r7, r0)
        L62:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.workout.Workout.onWatchFileChange(com.animaconnected.watch.device.files.WatchFile, com.animaconnected.watch.DisplayWatch, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void setCheckPermissions(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.checkPermissions = function0;
    }
}
