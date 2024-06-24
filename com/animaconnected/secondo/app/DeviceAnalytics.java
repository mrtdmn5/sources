package com.animaconnected.secondo.app;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.animaconnected.bluetooth.device.DeviceAnalyticsListener;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.dfu.fota.utils.FotaConstants;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.firebase.FotaState;
import com.animaconnected.firebase.WatchEvents;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.UserCategory;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.update.DfuState;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.DeviceAvailableListener;
import com.animaconnected.watch.DeviceInterface;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DeviceError;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.animaconnected.watch.device.WatchEventListener;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: DeviceAnalytics.kt */
/* loaded from: classes.dex */
public final class DeviceAnalytics extends BaseWatchProviderListener implements DeviceAnalyticsListener, DeviceConnectionListener, WatchEventListener, Bonding.BondingListener, DeviceInterface.FirmwareInfoListener, DeviceAvailableListener, WatchAppUpdateProvider.FirmwareListener, WatchDfuProvider.DfuStatusListener, WatchFotaProvider.FotaStatusListener {
    private final Analytics analytics;
    private final WatchEvents analyticsEvents;
    private final WatchAppUpdateProvider appUpdateProvider;
    private final Bonding bonding;
    private final Context context;
    private final WatchDfuProvider dfuProvider;
    private long dfuTime;
    private final WatchFotaProvider fotaProvider;
    private Float lastBatteryPercentage;
    private Boolean lastChargingState;
    private long lastSentBatteryPercentageTimestamp;
    private DfuState previousDFUState;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DeviceAnalytics";
    private static final long BATTERY_LEVEL_INTERVAL_MS = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS);

    /* compiled from: DeviceAnalytics.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: DeviceAnalytics.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Slot.values().length];
            try {
                r0[Slot.NotInitialized.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Slot.Unknown.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Slot.SubComplication1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Slot.SubComplication2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Slot.MainComplication.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Slot.MainComplicationDouble.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[Slot.TopPusher.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[Slot.BottomPusher.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r0[Slot.Display.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r0[Slot.MagicKey.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DeviceAnalytics(Context context, WatchProvider watchProvider, WatchDfuProvider dfuProvider, WatchFotaProvider fotaProvider, Bonding bonding, WatchAppUpdateProvider appUpdateProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        Intrinsics.checkNotNullParameter(dfuProvider, "dfuProvider");
        Intrinsics.checkNotNullParameter(fotaProvider, "fotaProvider");
        Intrinsics.checkNotNullParameter(bonding, "bonding");
        Intrinsics.checkNotNullParameter(appUpdateProvider, "appUpdateProvider");
        this.context = context;
        this.watchProvider = watchProvider;
        this.dfuProvider = dfuProvider;
        this.fotaProvider = fotaProvider;
        this.bonding = bonding;
        this.appUpdateProvider = appUpdateProvider;
        Analytics analytics = ProviderFactory.INSTANCE.getAnalytics();
        this.analytics = analytics;
        this.analyticsEvents = analytics.getWatchEvents();
        this.previousDFUState = DfuState.NotStarted.INSTANCE;
    }

    private final String getAnalyticsNameForSlot(Slot slot) {
        switch (WhenMappings.$EnumSwitchMapping$0[slot.ordinal()]) {
            case 1:
                return "not_initialized";
            case 2:
                return "unknown";
            case 3:
                return "complication_1";
            case 4:
                return "complication_2";
            case 5:
                return "crown";
            case 6:
                return "double_crown";
            case 7:
                return AnalyticsConstants.KEY_TOP;
            case 8:
                return AnalyticsConstants.KEY_BOTTOM;
            case 9:
                return "display";
            case 10:
                return "magic_key_1";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void periodically() {
        int r0 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(UserCategoryKt.diagnosticsReportIntervalInSeconds(this.watchProvider.getUserCategory()), DurationUnit.SECONDS);
        Instant.Companion companion = Instant.Companion;
        long timeWhenDiagnosticsSent = this.watchProvider.getTimeWhenDiagnosticsSent();
        companion.getClass();
        if (Duration.m1672compareToLRDsOJo(DateTimeUtilsKt.now().m1704minus5sfh64U(Instant.Companion.fromEpochMilliseconds(timeWhenDiagnosticsSent)), duration) >= 0) {
            setUserCategory(this.watchProvider);
            setDeviceInfo(this.watchProvider);
            sendDeviceDiagnostics(this.watchProvider);
            sendDeviceInfo(this.watchProvider);
        }
    }

    private final void sendDeviceDiagnostics(final WatchProvider watchProvider) {
        watchProvider.readDiagnostics().success(new SuccessCallback(this) { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda0
            public final /* synthetic */ DeviceAnalytics f$1;

            {
                this.f$1 = this;
            }

            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.sendDeviceDiagnostics$lambda$0(watchProvider, this.f$1, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendDeviceDiagnostics$lambda$0(WatchProvider watch, DeviceAnalytics this$0, Map result) {
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        watch.setTimeWhenDiagnosticsSent(System.currentTimeMillis());
        this$0.analyticsEvents.logDeviceDiagnostics(result);
    }

    private final void sendDeviceInfo(WatchProvider watchProvider) {
        watchProvider.readBuildInfo().success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.sendDeviceInfo$lambda$1(DeviceAnalytics.this, (Map) obj);
            }
        });
        watchProvider.readBuildInfoBl().success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.sendDeviceInfo$lambda$2(DeviceAnalytics.this, (Map) obj);
            }
        });
        watchProvider.getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.sendDeviceInfo$lambda$3(DeviceAnalytics.this, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendDeviceInfo$lambda$1(DeviceAnalytics this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WatchEvents watchEvents = this$0.analyticsEvents;
        Intrinsics.checkNotNull(map);
        watchEvents.logBuildInfo(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendDeviceInfo$lambda$2(DeviceAnalytics this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WatchEvents watchEvents = this$0.analyticsEvents;
        Intrinsics.checkNotNull(map);
        watchEvents.logBuildInfoBl(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendDeviceInfo$lambda$3(DeviceAnalytics this$0, Map deviceInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this$0.analyticsEvents.logDeviceInfo((String) deviceInfo.get(DeviceInfo.SerialNumber), (String) deviceInfo.get(DeviceInfo.ModelNumber), (String) deviceInfo.get(DeviceInfo.ManufacturerName), (String) deviceInfo.get(DeviceInfo.HardwareRevision), (String) deviceInfo.get(DeviceInfo.FirmwareRevision));
    }

    private final void setDeviceInfo(final WatchProvider watchProvider) {
        watchProvider.getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda7
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.setDeviceInfo$lambda$4(DeviceAnalytics.this, watchProvider, (Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDeviceInfo$lambda$4(DeviceAnalytics this$0, WatchProvider device, Map deviceInformation) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(device, "$device");
        Intrinsics.checkNotNullParameter(deviceInformation, "deviceInformation");
        String str = (String) deviceInformation.get(DeviceInfo.SerialNumber);
        Analytics analytics = this$0.analytics;
        DeviceType deviceType = device.getDeviceType();
        if (deviceType != null) {
            num = Integer.valueOf(deviceType.getAdvertisedNumber());
        } else {
            num = null;
        }
        analytics.setDeviceInfo(num, str, (String) deviceInformation.get(DeviceInfo.FirmwareRevision), device.getFirmwareVariant().getValue(), (String) deviceInformation.get(DeviceInfo.ModelNumber));
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (str == null) {
                str = "";
            }
            firebaseCrashlytics.setUserId(str);
        } catch (IllegalStateException unused) {
            ProviderFactory.getAppAnalytics().sendAction("crashlytics-init-failed");
        }
    }

    private final void setUserCategory(WatchProvider watchProvider) {
        if (!this.watchProvider.isOnboardingFinished()) {
            return;
        }
        watchProvider.getDeviceInformation().flatMap(new DeviceAnalytics$$ExternalSyntheticLambda4()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.app.DeviceAnalytics$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceAnalytics.setUserCategory$lambda$7(DeviceAnalytics.this, (String) obj);
            }
        }).fail(new DeviceAnalytics$$ExternalSyntheticLambda6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Future setUserCategory$lambda$5(Map deviceInformation) {
        Intrinsics.checkNotNullParameter(deviceInformation, "deviceInformation");
        return ProviderFactory.getCloudProvider().getWhoami((String) deviceInformation.get(DeviceInfo.SerialNumber));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserCategory$lambda$7(DeviceAnalytics this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null) {
            Log.d(TAG, "Failed retrieving user category");
            return;
        }
        UserCategory fromIdentifier = UserCategory.Companion.fromIdentifier(str);
        if (fromIdentifier != null) {
            this$0.watchProvider.setUserCategory(fromIdentifier);
        }
        Log.d(TAG, "Set category to ".concat(str));
        this$0.analytics.setUserCategory(str);
        RemoteConfigController.Companion.getInstance(this$0.context).fetch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserCategory$lambda$8(Throwable th) {
        Log.d(TAG, "Failed retrieving user category");
    }

    public final void init() {
        this.previousDFUState = this.dfuProvider.getDfuState();
        this.watchProvider.registerListener(this);
        this.watchProvider.registerDeviceAvailableListener(this);
        this.watchProvider.registerDeviceConnectionListener(this);
        this.watchProvider.registerFirmwareChangedListener(this);
        this.watchProvider.setDeviceAnalyticsListener(this);
        this.dfuProvider.registerListener(this);
        this.fotaProvider.registerFotaStatusListener(this);
        this.appUpdateProvider.registerFirmwareListener(this);
        this.bonding.registerBondingListener(this);
        if (this.watchProvider.hasDevice()) {
            onDeviceAdded();
        }
        setUserCategory(this.watchProvider);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryCharger(boolean z) {
        Boolean bool = this.lastChargingState;
        if (bool != null && Intrinsics.areEqual(bool, Boolean.valueOf(z))) {
            return;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.lastChargingState = valueOf;
        this.analyticsEvents.deviceBatteryEvent(valueOf, this.lastBatteryPercentage);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryPercent(float f) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Float f2 = this.lastBatteryPercentage;
        if ((f2 != null && Intrinsics.areEqual(f2, f)) || uptimeMillis < this.lastSentBatteryPercentageTimestamp + BATTERY_LEVEL_INTERVAL_MS) {
            return;
        }
        this.lastSentBatteryPercentageTimestamp = uptimeMillis;
        Float valueOf = Float.valueOf(f);
        this.lastBatteryPercentage = valueOf;
        this.analyticsEvents.deviceBatteryEvent(this.lastChargingState, valueOf);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBehaviourExecuted(Behaviour behaviour) {
        String str;
        if (behaviour != null) {
            str = behaviour.getAnalyticsName();
        } else {
            str = null;
        }
        this.analyticsEvents.behaviourUsed(str);
    }

    @Override // com.animaconnected.bluetooth.util.Bonding.BondingListener
    public void onBondCreated(boolean z) {
        this.analyticsEvents.bondCreated(z);
    }

    @Override // com.animaconnected.bluetooth.util.Bonding.BondingListener
    public void onBondRemoved(boolean z) {
        this.analyticsEvents.bondRemoved(z);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(action, "action");
        if (behaviour != null) {
            str = behaviour.getAnalyticsName();
        } else {
            str = null;
        }
        this.analyticsEvents.deviceButtonPressed(str, getAnalyticsNameForSlot(slot), action.getReadableName(), z);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        periodically();
        if (Intrinsics.areEqual(this.previousDFUState, DfuState.Successful.INSTANCE)) {
            this.previousDFUState = DfuState.NotStarted.INSTANCE;
        }
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceAdded() {
        this.watchProvider.registerEventListener(this);
        setDeviceInfo(this.watchProvider);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceButtonClicked(Button button, ButtonAction action) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onDeviceDebugDisconnect(Integer num, Integer num2, Integer num3) {
        LogKt.debug$default((Object) this, "debug_disconnect: rssi " + num + ", time " + num2 + ", reason " + num3, (String) null, (Throwable) null, false, 14, (Object) null);
        this.analyticsEvents.deviceDisconnected(num, num2, num3);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceError(DeviceError deviceError) {
        Intrinsics.checkNotNullParameter(deviceError, "deviceError");
        this.analyticsEvents.deviceError(deviceError.getErrorCode());
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceRemoved() {
        this.analytics.clearDeviceInfo();
        this.watchProvider.setTimeWhenDiagnosticsSent(0L);
        this.watchProvider.unregisterEventListener(this);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
    public void onDfuFirmwareDownloaded(File file, String str) {
        this.analyticsEvents.firmwareDownloaded(false, str);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchDfuProvider.DfuStatusListener
    public void onDfuStatusChanged(DfuState state) {
        String str;
        Intrinsics.checkNotNullParameter(state, "state");
        if (!Intrinsics.areEqual(state, this.previousDFUState)) {
            WatchEvents watchEvents = this.analyticsEvents;
            String analyticsString = state.analyticsString();
            if (state instanceof DfuState.Failed) {
                str = ((DfuState.Failed) state).getMessage();
            } else {
                str = null;
            }
            watchEvents.dfuStatusChanged(analyticsString, str);
        }
        this.previousDFUState = state;
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onDiagEvent(Map<String, String> diagEvent) {
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
        this.analyticsEvents.logDiag(diagEvent);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        this.dfuTime = SystemClock.elapsedRealtime();
        this.analyticsEvents.dfuStarted();
    }

    @Override // com.animaconnected.watch.DeviceInterface.FirmwareInfoListener
    public void onFirmwareChanged(String str, String str2, boolean z) {
        this.watchProvider.setTimeWhenDiagnosticsSent(0L);
        if (this.watchProvider.getFirmwareUpdate() == FirmwareUpdate.FOTA) {
            WatchEvents.fotaState$default(this.analyticsEvents, FotaState.Success, null, 2, null);
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
    public void onFirmwareRemoved() {
        boolean z;
        FirmwareUpdate firmwareUpdateCached = this.watchProvider.getFirmwareUpdateCached();
        if (firmwareUpdateCached != FirmwareUpdate.NONE) {
            WatchEvents watchEvents = this.analyticsEvents;
            if (firmwareUpdateCached == FirmwareUpdate.FOTA) {
                z = true;
            } else {
                z = false;
            }
            watchEvents.firmwareRemoved(z);
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.watchProvider.getFirmwareUpdateCached() == FirmwareUpdate.FOTA) {
            this.analyticsEvents.fotaState(FotaState.ErrorFailed, error);
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
    public void onFotaFirmwareDownloaded(File file, String str) {
        this.analyticsEvents.firmwareDownloaded(true, str);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaProgress(List<Byte> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (this.watchProvider.getFirmwareUpdateCached() == FirmwareUpdate.FOTA) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : pages) {
                boolean z = true;
                if (((Number) obj).byteValue() != 1) {
                    z = false;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            this.analyticsEvents.fotaProgress(arrayList.size(), pages.size());
        }
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onHourly() {
        periodically();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        this.analyticsEvents.dfuFinished(SystemClock.elapsedRealtime() - this.dfuTime);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onOnboardingFinished(boolean z) {
        setUserCategory(this.watchProvider);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaCompleted() {
        if (this.watchProvider.getFirmwareUpdateCached() == FirmwareUpdate.FOTA) {
            WatchEvents.fotaState$default(this.analyticsEvents, FotaState.PerformCompleted, null, 2, null);
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaError(byte b) {
        if (this.watchProvider.getFirmwareUpdateCached() == FirmwareUpdate.FOTA) {
            this.analyticsEvents.fotaState(FotaState.ErrorPerformFailed, FotaConstants.getResponseAsName(b));
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onReadyToPerformFota() {
        if (this.watchProvider.getFirmwareUpdateCached() == FirmwareUpdate.FOTA) {
            WatchEvents.fotaState$default(this.analyticsEvents, FotaState.ReadyToPerform, null, 2, null);
        }
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onRssiEvent(int r2) {
        this.analyticsEvents.debugLogRssi(r2);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceAnalyticsListener
    public void onSendAnalytics(String state, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.analyticsEvents.connectionEvent(state, z, bool);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceAnalyticsListener
    public void onServicesNotFound(int r2) {
        this.analyticsEvents.serviceDiscoveryFail(r2);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStepsNow(int r1, int r2, int r3, int r4) {
        this.analyticsEvents.logSteps(r1);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onWroteDeviceSettings() {
        this.analyticsEvents.logDeviceSettings(this.watchProvider.getStillnessActive(), this.watchProvider.fitness().getGoalOnce(DateTimeUtilsKt.currentTimeMillis()).getSteps(), this.watchProvider.isOnboardingFinished());
    }

    public final void shutdown() {
        this.watchProvider.unregisterListener(this);
        this.watchProvider.unregisterDeviceAvailableListener(this);
        this.watchProvider.unregisterDeviceConnectionListener(this);
        this.watchProvider.unregisterFirmwareChangedListener(this);
        this.dfuProvider.unregisterListener(this);
        this.fotaProvider.unregisterFotaStatusListener(this);
        this.appUpdateProvider.unregisterFirmwareListener(this);
        this.bonding.unregisterBondingListener(this);
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDevicePostMortem() {
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlarm(int r1) {
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceCrash(int r1) {
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onPressDuringCall(int r1) {
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onConnIntChange(int r1, int r2, int r3) {
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlert(int r1, int r2, int r3, int r4, int r5) {
    }
}
