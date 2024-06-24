package com.animaconnected.watch.behaviour.settings;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.provider.preferences.Pref;
import com.animaconnected.watch.provider.preferences.PreferenceValue;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsApp.kt */
/* loaded from: classes3.dex */
public class SettingsApp implements FirmwareApp {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "SettingsApp";
    private DisplayWatch watch;
    private final String type = TYPE;
    private final String analyticsName = TYPE;
    private final Lazy mitmapBackend$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MitmapBackend>() { // from class: com.animaconnected.watch.behaviour.settings.SettingsApp$mitmapBackend$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MitmapBackend invoke() {
            return ServiceLocator.INSTANCE.getMitmapBackend();
        }
    });
    private final Mitmap icon = MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Settings_App_Icon, null, 2, null);
    private final boolean isHidden = true;
    private Function0<Boolean> checkPermissions = new Function0<Boolean>() { // from class: com.animaconnected.watch.behaviour.settings.SettingsApp$checkPermissions$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };
    private final AppId id = AppId.Settings;

    /* compiled from: SettingsApp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ Object getFiles$suspendImpl(SettingsApp settingsApp, Continuation<? super List<WatchFile>> continuation) {
        DisplayWatch displayWatch = settingsApp.watch;
        if (displayWatch != null) {
            PreferenceValue.Companion companion = PreferenceValue.Companion;
            return CollectionsKt__CollectionsKt.listOf((Object[]) new WatchFile[]{new WatchFile(WatchFileSystem.prefsDir, WatchFileSystem.settingsPrefFile, companion.encodeToMsgpack(displayWatch.getPreferences$watch_release().getPreferenceValuesForFile(WatchFileSystem.settingsPrefFile)), true), new WatchFile(WatchFileSystem.prefsDir, WatchFileSystem.watchPrefFile, companion.encodeToMsgpack(displayWatch.getPreferences$watch_release().getPreferenceValuesForFile(WatchFileSystem.watchPrefFile)), true), settingsApp.getUpdatedAppPrefFile(displayWatch)});
        }
        return null;
    }

    private final MitmapBackend getMitmapBackend() {
        return (MitmapBackend) this.mitmapBackend$delegate.getValue();
    }

    private final WatchFile getUpdatedAppPrefFile(DisplayWatch displayWatch) {
        displayWatch.getPreferences$watch_release().setPreference(Pref.LocationPermission, new int[]{ServiceLocator.INSTANCE.getLocationProvider().getHasLocationPermission() ? 1 : 0}, false);
        return new WatchFile(WatchFileSystem.prefsDir, WatchFileSystem.appPrefFile, PreferenceValue.Companion.encodeToMsgpack(displayWatch.getPreferences$watch_release().getPreferenceValuesForFile(WatchFileSystem.appPrefFile)), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object onWatchFileChange$suspendImpl(com.animaconnected.watch.behaviour.settings.SettingsApp r4, com.animaconnected.watch.device.files.WatchFile r5, com.animaconnected.watch.DisplayWatch r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.animaconnected.watch.behaviour.settings.SettingsApp$onWatchFileChange$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.behaviour.settings.SettingsApp$onWatchFileChange$1 r0 = (com.animaconnected.watch.behaviour.settings.SettingsApp$onWatchFileChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.settings.SettingsApp$onWatchFileChange$1 r0 = new com.animaconnected.watch.behaviour.settings.SettingsApp$onWatchFileChange$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            r6 = r4
            com.animaconnected.watch.DisplayWatch r6 = (com.animaconnected.watch.DisplayWatch) r6
            java.lang.Object r4 = r0.L$0
            r5 = r4
            com.animaconnected.watch.device.files.WatchFile r5 = (com.animaconnected.watch.device.files.WatchFile) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r4 = super.onWatchFileChange(r5, r6, r0)
            if (r4 != r1) goto L49
            return r1
        L49:
            java.lang.String r4 = "prefs_watch.msg"
            java.lang.String r7 = "prefs_app.msg"
            java.lang.String r0 = "prefs_settings.msg"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r7}
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r4)
            java.lang.String r7 = r5.getName()
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L6f
            com.animaconnected.watch.provider.preferences.PreferenceProvider r4 = r6.getPreferences$watch_release()
            byte[] r5 = r5.getBytes()
            r6 = 2
            r7 = 0
            r0 = 0
            com.animaconnected.watch.provider.preferences.PreferenceProvider.setPreferences$default(r4, r5, r0, r6, r7)
        L6f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.settings.SettingsApp.onWatchFileChange$suspendImpl(com.animaconnected.watch.behaviour.settings.SettingsApp, com.animaconnected.watch.device.files.WatchFile, com.animaconnected.watch.DisplayWatch, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void connected(Watch watch) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(watch, "watch");
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
        return MapsKt__MapsKt.mapOf(new Pair("radio_on", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Settings_Radio_On, null, 2, null)), new Pair("radio_off", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Settings_Radio_Off, null, 2, null)), new Pair("low_battery", MitmapBackend.getMitmap$default(getMitmapBackend(), WatchAsset.Setting_Low_battery, null, 2, null)));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.settings_name);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public boolean isHidden() {
        return this.isHidden;
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
