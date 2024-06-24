package com.animaconnected.watch;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import com.animaconnected.bluetooth.device.DeviceAnalyticsListener;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.BaseFotaController;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.firebase.config.StatusDiagEnabledParams;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.EmulatorInfo;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.info.UserCategory;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.DeviceService;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.provider.AccountBackendImpl;
import com.animaconnected.secondo.provider.MainWatchFonts;
import com.animaconnected.secondo.provider.MeasurementBackendImpl;
import com.animaconnected.secondo.provider.PlatformBackendImpl;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.provider.notification.NotificationMisuseProvider;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.screens.debugsettings.DebugStorage;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.utils.debugging.DogfoodLogger;
import com.animaconnected.secondo.utils.diagnostics.CrashBackendImpl;
import com.animaconnected.watch.DeviceInterface;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.device.BatteryState;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.CommandCenter;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DeviceDfuListener;
import com.animaconnected.watch.device.DeviceError;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.DfuStatus;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.animaconnected.watch.device.WatchEventListener;
import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchIODebug;
import com.animaconnected.watch.device.WatchListener;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.AppPosition;
import com.animaconnected.watch.display.FullScreenTest;
import com.animaconnected.watch.display.ImagePreviewWatchApp;
import com.animaconnected.watch.display.MitmapCompressionSettings;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.MockFitnessProvider;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.model.DriverFactoryKt;
import com.animaconnected.watch.model.SqlDriverFactory;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.storage.models.DBWatch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: WatchProvider.kt */
/* loaded from: classes3.dex */
public final class WatchProvider implements DeviceConnectionListener, WatchListener, DeviceInterface.FirmwareInfoListener, DeviceAnalyticsListener, CoroutineScope {
    private static final long PERIODIC_RSSI_MAX_VALUE = 127;
    private static final long PERIODIC_RSSI_MIN_VALUE = -128;
    private final AlarmDatabase alarmsDatabase;
    private final Lazy analyticsConfigHelper$delegate;
    private DeviceAnalyticsListener analyticsListener;
    private final BehaviourFactory behaviourFactory;
    private final Behaviours behaviours;
    private Capabilities capabilities;
    private final Context context;
    private final int currentConnInt;
    private final WatchDb db;
    private DeviceInterface device;
    private final Set<DeviceAvailableListener> deviceAvailableListeners;
    private final Set<DeviceConnectionListener> deviceConnectionListeners;
    private final DeviceDataSync deviceDataSync;
    private final Set<DeviceInterface.FirmwareInfoListener> firmwareChangedListeners;
    private final CompletableJob job;
    private final Set<WatchProviderListener> listeners;
    private final AndroidLocationBackend locationBackend;
    private final OnboardingFinishedStorage onboardingFinishedStorage;
    private HybridDevice previouslyConnectedDevice;
    private final RemoteConfigController remoteConfig;
    private final String tag;
    private final Vibrations vibrations;
    private final WatchDatabase watchDatabase;
    private final MainWatchFonts watchFonts;
    private final WatchManager watchManager;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final long DAILY_INTERVAL_MS = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);

    /* compiled from: WatchProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: WatchProvider.kt */
    /* loaded from: classes3.dex */
    public static final class PeriodicTasksWorker extends CoroutineWorker {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PeriodicTasksWorker(Context appContext, WorkerParameters workerParams) {
            super(appContext, workerParams);
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @Override // androidx.work.CoroutineWorker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$1
                if (r0 == 0) goto L13
                r0 = r6
                com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$1 r0 = (com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$1 r0 = new com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$1
                r0.<init>(r5, r6)
            L18:
                java.lang.Object r6 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.throwOnFailure(r6)
                goto L45
            L27:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L2f:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.scheduling.DefaultScheduler r6 = kotlinx.coroutines.Dispatchers.Default
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
                com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$2 r2 = new com.animaconnected.watch.WatchProvider$PeriodicTasksWorker$doWork$2
                r4 = 0
                r2.<init>(r4)
                r0.label = r3
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
                if (r6 != r1) goto L45
                return r1
            L45:
                java.lang.String r0 = "withContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.PeriodicTasksWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* compiled from: WatchProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Vibrations {
        public static final int $stable = 8;
        private final Function1<Integer, Unit> action;
        private final Handler handler;
        private final VibrateRunnable vibrateRunnable;

        /* compiled from: WatchProvider.kt */
        /* loaded from: classes3.dex */
        public final class VibrateRunnable implements Runnable {
            private int nbrOfAlerts;
            private final int timeBetweenAlerts = 3000;
            private final int maxTotalAlertMs = 90000;
            private final int maxNoAlerts = 90000 / 3000;
            private int alert = 1;

            public VibrateRunnable() {
            }

            public final void reset(int r1) {
                this.alert = r1;
                this.nbrOfAlerts = 0;
            }

            @Override // java.lang.Runnable
            public void run() {
                Vibrations.this.getAction().invoke(Integer.valueOf(this.alert));
                int r0 = this.nbrOfAlerts + 1;
                this.nbrOfAlerts = r0;
                if (r0 < this.maxNoAlerts) {
                    Vibrations.this.handler.postDelayed(this, this.timeBetweenAlerts);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Vibrations(Function1<? super Integer, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.action = action;
            this.handler = new Handler(Looper.getMainLooper());
            this.vibrateRunnable = new VibrateRunnable();
        }

        public final Function1<Integer, Unit> getAction() {
            return this.action;
        }

        public final void startVibrateForIncomingCall(int r2) {
            this.vibrateRunnable.reset(r2);
            this.handler.removeCallbacks(this.vibrateRunnable);
            this.handler.post(this.vibrateRunnable);
        }

        public final void stopVibrateForIncomingCall() {
            this.handler.removeCallbacks(this.vibrateRunnable);
        }
    }

    /* compiled from: WatchProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[FirmwareUpdate.values().length];
            try {
                r0[FirmwareUpdate.DFU15.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FirmwareUpdate.FOTA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[DeviceError.values().length];
            try {
                r02[DeviceError.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r02[DeviceError.BATTERY_CRITICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[DeviceError.BATTERY_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[DeviceError.BATTERY_OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[DeviceError.CALIBRATION_TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public WatchProvider(Context context, BehaviourFactory behaviourFactory, RemoteConfigController remoteConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(behaviourFactory, "behaviourFactory");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        this.context = context;
        this.behaviourFactory = behaviourFactory;
        this.remoteConfig = remoteConfig;
        this.job = SupervisorKt.SupervisorJob$default();
        this.tag = "WatchProvider";
        this.onboardingFinishedStorage = new OnboardingFinishedStorage(context);
        this.analyticsConfigHelper$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AnalyticsConfigHelper>() { // from class: com.animaconnected.watch.WatchProvider$analyticsConfigHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AnalyticsConfigHelper invoke() {
                Context context2;
                context2 = WatchProvider.this.context;
                return new AnalyticsConfigHelper(context2, WatchProvider.this, ProviderFactory.getNotificationProvider(), ProviderFactory.getAppAnalytics());
            }
        });
        AndroidLocationBackend androidLocationBackend = AndroidLocationBackend.INSTANCE;
        this.locationBackend = androidLocationBackend;
        try {
            WatchDatabase createWatchDatabase = DriverFactoryKt.createWatchDatabase(new SqlDriverFactory(context), WatchProvider$watchDatabase$1.INSTANCE);
            createWatchDatabase.getFitnessQueries().getActivityData(DAILY_INTERVAL_MS, DAILY_INTERVAL_MS).executeAsList();
            this.watchDatabase = createWatchDatabase;
            AlarmDatabase createAlarmsDatabase = DriverFactoryKt.createAlarmsDatabase(new SqlDriverFactory(context));
            this.alarmsDatabase = createAlarmsDatabase;
            MainWatchFonts mainWatchFonts = new MainWatchFonts();
            this.watchFonts = mainWatchFonts;
            ProviderFactory providerFactory = ProviderFactory.INSTANCE;
            Analytics analytics = providerFactory.getAnalytics();
            Locale translationCompatibleLocale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
            Intrinsics.checkNotNullExpressionValue(translationCompatibleLocale, "getTranslationCompatibleLocale(...)");
            String string = context.getString(com.kronaby.watch.app.R.string.brand);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            WatchManager prepareWatchManager = WatchManagerKt.prepareWatchManager(context, createWatchDatabase, createAlarmsDatabase, androidLocationBackend, analytics, new StringsBackendImpl(context, translationCompatibleLocale, string), new MitmapBackendImpl(context), remoteConfig.getElevationApiKey(), new AccountBackendImpl(ProviderFactory.getCloudProvider(), ProviderFactory.getPoolIdProvider()), new PlatformBackendImpl(context), new MeasurementBackendImpl(), new CrashBackendImpl(context), mainWatchFonts, new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$watchManager$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WatchProvider.this.getRemoteConfig().getWeatherApiKey();
                }
            }, providerFactory.getStravaAuth());
            this.watchManager = prepareWatchManager;
            this.deviceDataSync = prepareWatchManager.getDeviceDataSync();
            this.db = new WatchDb(createWatchDatabase);
            this.behaviours = prepareWatchManager.getBehaviours();
            this.listeners = new CopyOnWriteArraySet();
            this.deviceAvailableListeners = new CopyOnWriteArraySet();
            this.deviceConnectionListeners = new CopyOnWriteArraySet();
            this.firmwareChangedListeners = new CopyOnWriteArraySet();
            this.capabilities = prepareWatchManager.getCurrentWatch().getCapabilities();
            this.currentConnInt = getWatch().getConnectionInterval();
            this.vibrations = new Vibrations(new Function1<Integer, Unit>() { // from class: com.animaconnected.watch.WatchProvider$vibrations$1

                /* compiled from: WatchProvider.kt */
                @DebugMetadata(c = "com.animaconnected.watch.WatchProvider$vibrations$1$1", f = "WatchProvider.kt", l = {1027}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.watch.WatchProvider$vibrations$1$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $alert;
                    private /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ WatchProvider this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(WatchProvider watchProvider, int r2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = watchProvider;
                        this.$alert = r2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$alert, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineScope coroutineScope;
                        Exception exc;
                        WatchIO io2;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                } catch (Exception e) {
                                    exc = e;
                                    coroutineScope = coroutineScope2;
                                    LogKt.debug$default((Object) coroutineScope, "Failed to write alert", (String) null, (Throwable) exc, false, 10, (Object) null);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                            try {
                                io2 = this.this$0.getIo();
                                if (io2 != null) {
                                    int r3 = this.$alert;
                                    this.L$0 = coroutineScope3;
                                    this.label = 1;
                                    if (io2.writeAlert(r3, this) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                }
                            } catch (Exception e2) {
                                coroutineScope = coroutineScope3;
                                exc = e2;
                                LogKt.debug$default((Object) coroutineScope, "Failed to write alert", (String) null, (Throwable) exc, false, 10, (Object) null);
                                return Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int r5) {
                    BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AnonymousClass1(WatchProvider.this, r5, null), 3);
                }
            });
        } catch (SQLiteException e) {
            ViewKt.toast(this.context, String.valueOf(e.getMessage()), true);
            throw e;
        }
    }

    public final void configureFromRemoteConfig() {
        long version = this.remoteConfig.getVersion();
        DeviceDataSync deviceDataSync = this.watchManager.getDeviceDataSync();
        deviceDataSync.setRemoteConfigVersion(version);
        deviceDataSync.setStillnessParameters(this.remoteConfig.getAppMovingParams());
        deviceDataSync.setDeviceConfigSettings(this.remoteConfig.getDeviceConfigSettings());
        deviceDataSync.setDeviceDisconnectLedAndVibrateEnable(this.remoteConfig.getDeviceDisconnectLedAndVibrateEnable());
        updateSpeedCalibrationEnabled();
        this.behaviours.setDisabledBehaviours(ArraysKt___ArraysJvmKt.asList(this.remoteConfig.getDisabledBehaviours()));
        boolean isRemoteConfigDirty = this.deviceDataSync.isRemoteConfigDirty();
        if (isRemoteConfigDirty) {
            this.deviceDataSync.setAllDirty();
        }
        LogKt.debug$default((Object) this, "configureFromRemoteConfig() version: " + version + " dirty: " + isRemoteConfigDirty, (String) null, (Throwable) null, false, 14, (Object) null);
    }

    private final void dissociateDevice(final String str) {
        CompanionDeviceUtils companionDeviceUtils = CompanionDeviceUtils.INSTANCE;
        if (Intrinsics.areEqual(companionDeviceUtils.isDeviceAssociated(this.context, str), Boolean.TRUE)) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$dissociateDevice$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Disassociate " + str;
                }
            }, 7, (Object) null);
            companionDeviceUtils.disassociate(this.context, str);
        }
    }

    private final AnalyticsConfigHelper getAnalyticsConfigHelper() {
        return (AnalyticsConfigHelper) this.analyticsConfigHelper$delegate.getValue();
    }

    private final CommandCenter getCommandCenter() {
        return this.watchManager.getCurrentWatch().getCommandCenter();
    }

    private final DeviceInterface getConnectedDevice() {
        if (!isConnected() && !isInUpdateRequired()) {
            return null;
        }
        return this.device;
    }

    private final DeviceInterface getConnectedOrDfuDevice() {
        if (!isConnected() && !isInDfuMode() && !isInUpdateRequired()) {
            return null;
        }
        return this.device;
    }

    private final List<RemoteAppImpl> getDebugBehaviours() {
        Mitmap emptyMitmap;
        ListBuilder listBuilder = new ListBuilder();
        if (this.remoteConfig.getAppDebugMenuEnable()) {
            listBuilder.add(new ImagePreviewWatchApp());
            if (this.watchManager.getCurrentWatch().getWatchType() == DeviceType.PASCAL_FULL) {
                Bitmap readBitmap = AndroidGraphicsKt.readBitmap(this.context, "watch/dog.png");
                if (readBitmap == null || (emptyMitmap = AndroidGraphicsKt.toMitmap(readBitmap, new MitmapCompressionSettings(null, null, false, 7, null))) == null) {
                    emptyMitmap = GraphicsKt.emptyMitmap();
                }
                listBuilder.add(new FullScreenTest(emptyMitmap));
            }
        }
        return CollectionsKt__CollectionsKt.build(listBuilder);
    }

    public final WatchIO getIo() {
        return this.watchManager.getCurrentWatch().getIo();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0120 A[Catch: Exception -> 0x0129, TRY_LEAVE, TryCatch #0 {Exception -> 0x0129, blocks: (B:18:0x0037, B:19:0x00ed, B:25:0x0120), top: B:17:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0134 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onHandlePeriodicTasks(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.onHandlePeriodicTasks(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066 A[LOOP:0: B:11:0x0060->B:13:0x0066, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readDeviceDebugDisconnect(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.WatchProvider$readDeviceDebugDisconnect$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.WatchProvider$readDeviceDebugDisconnect$1 r0 = (com.animaconnected.watch.WatchProvider$readDeviceDebugDisconnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$readDeviceDebugDisconnect$1 r0 = new com.animaconnected.watch.WatchProvider$readDeviceDebugDisconnect$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.WatchProvider r0 = (com.animaconnected.watch.WatchProvider) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.secondo.app.RemoteConfigController r7 = r6.remoteConfig
            boolean r7 = r7.getDeviceDebugDisconnectEnable()
            if (r7 != 0) goto L41
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L41:
            com.animaconnected.watch.device.WatchIO r7 = r6.getIo()
            if (r7 != 0) goto L4a
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L4a:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.readDebugDisconnect(r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r0 = r6
        L56:
            java.util.List r7 = (java.util.List) r7
            java.util.Set<com.animaconnected.watch.WatchProvider$WatchProviderListener> r0 = r0.listeners
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L60:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L84
            java.lang.Object r1 = r0.next()
            com.animaconnected.watch.WatchProvider$WatchProviderListener r1 = (com.animaconnected.watch.WatchProvider.WatchProviderListener) r1
            r2 = 0
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r2, r7)
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r3, r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            r5 = 2
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r5, r7)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r1.onDeviceDebugDisconnect(r2, r4, r5)
            goto L60
        L84:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.readDeviceDebugDisconnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeDevice(boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.WatchProvider$removeDevice$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.WatchProvider$removeDevice$1 r0 = (com.animaconnected.watch.WatchProvider$removeDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$removeDevice$1 r0 = new com.animaconnected.watch.WatchProvider$removeDevice$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            boolean r7 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.WatchProvider r0 = (com.animaconnected.watch.WatchProvider) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.DeviceInterface r8 = r6.device
            if (r8 == 0) goto L64
            java.lang.String r8 = r8.getAddress()
            if (r8 == 0) goto L64
            com.animaconnected.watch.WatchManager r2 = r6.watchManager
            r0.L$0 = r6
            r0.L$1 = r8
            r0.Z$0 = r7
            r0.label = r3
            java.lang.Object r0 = r2.removeWatch(r8, r0)
            if (r0 != r1) goto L57
            return r1
        L57:
            r0 = r6
            r1 = r8
        L59:
            com.animaconnected.watch.SharedPreferencesCache r8 = new com.animaconnected.watch.SharedPreferencesCache
            android.content.Context r2 = r0.context
            r8.<init>(r2, r1)
            r8.clear()
            goto L65
        L64:
            r0 = r6
        L65:
            com.animaconnected.watch.DeviceInterface r8 = r0.device
            if (r8 == 0) goto L89
            java.util.Set<com.animaconnected.watch.DeviceAvailableListener> r1 = r0.deviceAvailableListeners
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L71:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L81
            java.lang.Object r2 = r1.next()
            com.animaconnected.watch.DeviceAvailableListener r2 = (com.animaconnected.watch.DeviceAvailableListener) r2
            r2.onDeviceRemoved()
            goto L71
        L81:
            com.animaconnected.watch.WatchProvider$Vibrations r1 = r0.vibrations
            r1.stopVibrateForIncomingCall()
            r8.close()
        L89:
            r8 = 0
            r0.device = r8
            com.animaconnected.watch.WatchManager r8 = r0.watchManager
            long r1 = r8.knownWatchCount()
            r4 = 0
            int r8 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            r1 = 0
            if (r8 <= 0) goto La3
            if (r7 != 0) goto La3
            r0.onDisconnected()
            r0.setupDevice()
            r3 = r1
            goto Lb2
        La3:
            com.animaconnected.watch.DeviceDataSync r7 = r0.deviceDataSync
            r7.setOnboardingFinished(r1)
            com.animaconnected.watch.OnboardingFinishedStorage r7 = r0.onboardingFinishedStorage
            r7.setIsOnboardingFinished(r1)
            com.animaconnected.watch.LePingReq r7 = com.animaconnected.watch.LePingReq.INSTANCE
            r7.disable()
        Lb2:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.removeDevice(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void schedulePeriodicTasks() {
        Constraints constraints = new Constraints(new Constraints.Builder());
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(PeriodicTasksWorker.class, TimeUnit.HOURS);
        builder.mWorkSpec.constraints = constraints;
        builder.mTags.add("PeriodicTask");
        PeriodicWorkRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(this.context);
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE;
        workManagerImpl.getClass();
        new WorkContinuationImpl(workManagerImpl, "PeriodicTask", ExistingWorkPolicy.KEEP, Collections.singletonList(build)).enqueue();
    }

    private final void setAllSettingsDirty() {
        this.deviceDataSync.setDirty();
        this.deviceDataSync.setAllDirty();
    }

    public final void setupDevice() {
        DeviceInterface create;
        Watch currentWatch = this.watchManager.getCurrentWatch();
        String identifier = currentWatch.getIdentifier();
        DeviceType watchType = currentWatch.getWatchType();
        FirmwareVariant firmwareVariant = currentWatch.getFirmwareVariant();
        LogKt.debug$default((Object) this, "Setting device: " + currentWatch.getIdentifier() + " type: " + currentWatch.getWatchType(), (String) null, (Throwable) null, true, 6, (Object) null);
        if (StringsKt__StringsJVMKt.startsWith(identifier, "EMULATOR", false)) {
            create = new EmulatorDevice(EmulatorInfo.Companion.getForType(watchType), this);
        } else {
            create = BtDevice.Companion.create(this.context, new RxJavaTwoGattDevice(this.context, identifier, watchType, firmwareVariant, this.onboardingFinishedStorage, this), this, new SharedPreferencesCache(this.context, identifier));
        }
        ProductInfoProvider.INSTANCE.setCurrentSku(getSku());
        this.device = create;
        if (create != null) {
            create.setFirmwareInfoListener(this);
            Iterator<T> it = this.deviceAvailableListeners.iterator();
            while (it.hasNext()) {
                ((DeviceAvailableListener) it.next()).onDeviceAdded();
            }
            create.connect();
        }
    }

    private final <T> Future<T> wrapInFuture(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return FutureCoroutineKt.asFuture(BuildersKt.async$default(scope, MainDispatcherLoader.dispatcher, new WatchProvider$wrapInFuture$1(function1, null), 2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095 A[Catch: Exception -> 0x002b, LOOP:0: B:13:0x008f->B:15:0x0095, LOOP_END, TRY_LEAVE, TryCatch #1 {Exception -> 0x002b, blocks: (B:11:0x0027, B:12:0x0078, B:13:0x008f, B:15:0x0095), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeDeviceSettings(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.WatchProvider$writeDeviceSettings$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.WatchProvider$writeDeviceSettings$1 r0 = (com.animaconnected.watch.WatchProvider$writeDeviceSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$writeDeviceSettings$1 r0 = new com.animaconnected.watch.WatchProvider$writeDeviceSettings$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.WatchProvider r0 = (com.animaconnected.watch.WatchProvider) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2b
            goto L78
        L2b:
            r12 = move-exception
            goto La1
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r11.isConnected()
            if (r12 != 0) goto L5e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "writeDeviceSettings NOT writing settings isConnected() "
            r12.<init>(r0)
            boolean r0 = r11.isConnected()
            r12.append(r0)
            java.lang.String r2 = r12.toString()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 14
            r7 = 0
            r1 = r11
            com.animaconnected.logger.LogKt.debug$default(r1, r2, r3, r4, r5, r6, r7)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L5e:
            java.lang.String r5 = r11.tag     // Catch: java.lang.Exception -> L9f
            r6 = 0
            r7 = 0
            com.animaconnected.watch.WatchProvider$writeDeviceSettings$2 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.WatchProvider$writeDeviceSettings$2
                static {
                    /*
                        com.animaconnected.watch.WatchProvider$writeDeviceSettings$2 r0 = new com.animaconnected.watch.WatchProvider$writeDeviceSettings$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.WatchProvider$writeDeviceSettings$2) com.animaconnected.watch.WatchProvider$writeDeviceSettings$2.INSTANCE com.animaconnected.watch.WatchProvider$writeDeviceSettings$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Starting sync"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$2.invoke():java.lang.Object");
                }
            }     // Catch: java.lang.Exception -> L9f
            r9 = 6
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.info$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9f
            com.animaconnected.watch.WatchManager r12 = r11.watchManager     // Catch: java.lang.Exception -> L9f
            r0.L$0 = r11     // Catch: java.lang.Exception -> L9f
            r0.label = r3     // Catch: java.lang.Exception -> L9f
            java.lang.Object r12 = r12.sync(r0)     // Catch: java.lang.Exception -> L9f
            if (r12 != r1) goto L77
            return r1
        L77:
            r0 = r11
        L78:
            java.lang.String r5 = r0.tag     // Catch: java.lang.Exception -> L2b
            r6 = 0
            r7 = 0
            com.animaconnected.watch.WatchProvider$writeDeviceSettings$3 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.WatchProvider$writeDeviceSettings$3
                static {
                    /*
                        com.animaconnected.watch.WatchProvider$writeDeviceSettings$3 r0 = new com.animaconnected.watch.WatchProvider$writeDeviceSettings$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.WatchProvider$writeDeviceSettings$3) com.animaconnected.watch.WatchProvider$writeDeviceSettings$3.INSTANCE com.animaconnected.watch.WatchProvider$writeDeviceSettings$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$3.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Sync done"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$3.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$writeDeviceSettings$3.invoke():java.lang.Object");
                }
            }     // Catch: java.lang.Exception -> L2b
            r9 = 6
            r10 = 0
            r4 = r0
            com.animaconnected.logger.LogKt.info$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L2b
            r0.setWroteOnboardingDeviceSettings(r3)     // Catch: java.lang.Exception -> L2b
            java.util.Set<com.animaconnected.watch.WatchProvider$WatchProviderListener> r12 = r0.listeners     // Catch: java.lang.Exception -> L2b
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Exception -> L2b
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> L2b
        L8f:
            boolean r1 = r12.hasNext()     // Catch: java.lang.Exception -> L2b
            if (r1 == 0) goto Lb0
            java.lang.Object r1 = r12.next()     // Catch: java.lang.Exception -> L2b
            com.animaconnected.watch.WatchProvider$WatchProviderListener r1 = (com.animaconnected.watch.WatchProvider.WatchProviderListener) r1     // Catch: java.lang.Exception -> L2b
            r1.onWroteDeviceSettings()     // Catch: java.lang.Exception -> L2b
            goto L8f
        L9f:
            r12 = move-exception
            r0 = r11
        La1:
            r3 = r12
            java.lang.String r12 = "Failed to send device settings: "
            java.lang.String r1 = com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0.m(r12, r3)
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.err$default(r0, r1, r2, r3, r4, r5, r6)
        Lb0:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.writeDeviceSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void alert(int r3) {
        NotificationMisuseProvider.getInstance(this.context).calculateNotification();
        BuildersKt.launch$default(this, null, null, new WatchProvider$alert$1(this, r3, null), 3);
    }

    public final Unit cancelFota() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.cancelFota();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Unit changeAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.changeAddress(address);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Object changeDevice(String str, Continuation<? super Future<Void>> continuation) {
        return BuildersKt.withContext(getCoroutineContext(), new WatchProvider$changeDevice$2(this, str, null), continuation);
    }

    public final void deactivateCurrentDevice() {
        this.watchManager.unregisterEventListener(this);
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            this.previouslyConnectedDevice = new HybridDevice(deviceInterface.getAddress(), 0, deviceInterface.getDeviceType(), null, 8, null);
            this.vibrations.stopVibrateForIncomingCall();
            deviceInterface.close();
        }
        this.device = null;
        onDisconnected();
    }

    public final void debugClose() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$debugClose$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Debug close clicked!";
            }
        }, 7, (Object) null);
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.close();
        }
    }

    public final void debugConnect() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$debugConnect$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Debug connect clicked!";
            }
        }, 7, (Object) null);
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.close();
        }
        setupDevice();
    }

    public final Object debugFakeConnect(Continuation<? super Unit> continuation) {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$debugFakeConnect$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Debug fake connect clicked!";
            }
        }, 7, (Object) null);
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            Object debugFakeConnect = deviceInterface.debugFakeConnect(continuation);
            if (debugFakeConnect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return debugFakeConnect;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object debugScan(Continuation<? super Unit> continuation) {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$debugScan$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Debug scan clicked!";
            }
        }, 7, (Object) null);
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            Object debugScan = deviceInterface.debugScan(continuation);
            if (debugScan == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return debugScan;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void enableBluetoothDebug(boolean z) {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.setDebugMode(z);
        }
        WatchIODebug debugIo = this.watchManager.getCurrentWatch().getDebugIo();
        if (debugIo != null) {
            debugIo.setDebugEnabled(z);
        }
    }

    public final void fireBatteryStateChanged(BatteryState batteryState) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onBatteryStateChanged(batteryState);
        }
    }

    public final FitnessProvider fitness() {
        if (DebugStorage.INSTANCE.getForceMockFitnessProvider()) {
            return new MockFitnessProvider(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        return this.watchManager.getFitnessProvider();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[PHI: r13
  0x0091: PHI (r13v7 java.lang.Object) = (r13v6 java.lang.Object), (r13v1 java.lang.Object) binds: [B:20:0x008e, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object forgetDevice(boolean r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.WatchProvider$forgetDevice$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.WatchProvider$forgetDevice$1 r0 = (com.animaconnected.watch.WatchProvider$forgetDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$forgetDevice$1 r0 = new com.animaconnected.watch.WatchProvider$forgetDevice$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L91
        L2a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L32:
            boolean r12 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.DeviceInterface r2 = (com.animaconnected.watch.DeviceInterface) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.watch.WatchProvider r4 = (com.animaconnected.watch.WatchProvider) r4
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            r13.getClass()
            r13 = r4
            goto L68
        L46:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.DeviceInterface r2 = r11.device
            if (r2 != 0) goto L50
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            return r12
        L50:
            com.animaconnected.watch.WatchProvider$Vibrations r13 = r11.vibrations
            r13.stopVibrateForIncomingCall()
            r2.close()
            r0.L$0 = r11
            r0.L$1 = r2
            r0.Z$0 = r12
            r0.label = r4
            java.lang.Object r13 = r2.mo1044removeBondIoAF18A(r0)
            if (r13 != r1) goto L67
            return r1
        L67:
            r13 = r11
        L68:
            boolean r2 = r2.isBonded()
            java.lang.String r5 = "Remove_bond_forget"
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r13
            r6 = r2
            com.animaconnected.bluetooth.device.DeviceAnalyticsListener.onSendAnalytics$default(r4, r5, r6, r7, r8, r9)
            if (r2 == 0) goto L83
            java.lang.String r5 = "Remove bond failed, user will need to forget watch in bt settings!"
            r6 = 0
            r7 = 0
            r8 = 1
            r9 = 6
            r10 = 0
            r4 = r13
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
        L83:
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r13 = r13.removeDevice(r12, r0)
            if (r13 != r1) goto L91
            return r1
        L91:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.forgetDevice(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getAddress() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.getAddress();
        }
        return null;
    }

    public final Future<Behaviour> getBehaviourAsFuture(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return FutureCoroutineKt.asFuture(BuildersKt.async$default(this, null, new WatchProvider$getBehaviourAsFuture$1(this, slot, null), 3));
    }

    public final Behaviours getBehaviours() {
        return this.behaviours;
    }

    public final Capabilities getCapabilities() {
        return this.watchManager.getCurrentWatch().getCapabilities();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher.plus(this.job);
    }

    public final int getCurrentConnInt() {
        return this.currentConnInt;
    }

    public final HybridDevice getCurrentOnboardedDevice() {
        HybridDevice hybridDevice = this.previouslyConnectedDevice;
        if (hybridDevice != null) {
            return hybridDevice;
        }
        DBWatch currentWatch = this.db.getCurrentWatch();
        if (currentWatch != null) {
            return new HybridDevice(currentWatch.getDevice_address(), 0, DeviceType.Companion.fromAdvertisedNumber(currentWatch.getDevice_type()), null, 8, null);
        }
        return null;
    }

    public final WatchDb getDb() {
        return this.db;
    }

    public final Future<Map<DeviceInfo, String>> getDeviceInformation() {
        Future<Map<DeviceInfo, String>> deviceInformationCached;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null || (deviceInformationCached = deviceInterface.getDeviceInformationCached()) == null) {
            Future<Map<DeviceInfo, String>> error = FutureUtils.error(new IllegalStateException("No device"));
            Intrinsics.checkNotNullExpressionValue(error, "error(...)");
            return error;
        }
        return deviceInformationCached;
    }

    public final DeviceType getDeviceType() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.getDeviceType();
        }
        return null;
    }

    public final Object getDfuStatus(Continuation<? super DfuStatus> continuation) {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null) {
            return DfuStatus.Unknown;
        }
        boolean z = false;
        if (deviceInterface != null && deviceInterface.isInDfuMode()) {
            z = true;
        }
        if (z) {
            return DfuStatus.Unknown;
        }
        return getWatch().dfuReady(continuation);
    }

    public final String getFirmwareRevisionCached() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.getFirmwareRevisionCached();
        }
        return null;
    }

    public final FirmwareUpdate getFirmwareUpdate() {
        FirmwareUpdate firmwareUpdate;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null || (firmwareUpdate = deviceInterface.getFirmwareUpdate()) == null) {
            return FirmwareUpdate.NONE;
        }
        return firmwareUpdate;
    }

    public final FirmwareUpdate getFirmwareUpdateCached() {
        FirmwareUpdate firmwareUpdateCached;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null || (firmwareUpdateCached = deviceInterface.getFirmwareUpdateCached()) == null) {
            return FirmwareUpdate.NONE;
        }
        return firmwareUpdateCached;
    }

    public final FirmwareVariant getFirmwareVariant() {
        FirmwareVariant firmwareVariant;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null || (firmwareVariant = deviceInterface.getFirmwareVariant()) == null) {
            return new FirmwareVariant(null, 1, null);
        }
        return firmwareVariant;
    }

    public final String getLastDfuReadyResult() {
        String last_dfu_result;
        DBWatch currentWatch = this.db.getCurrentWatch();
        if (currentWatch == null || (last_dfu_result = currentWatch.getLast_dfu_result()) == null) {
            return "None";
        }
        return last_dfu_result;
    }

    public final List<Byte> getLastPagesInfo() {
        List<Byte> lastPagesInfo;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null || (lastPagesInfo = deviceInterface.getLastPagesInfo()) == null) {
            return new ArrayList();
        }
        return lastPagesInfo;
    }

    public final List<HybridDevice> getOnboardedDevices() {
        List<DBWatch> allWatches = this.db.getAllWatches();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(allWatches, 10));
        for (DBWatch dBWatch : allWatches) {
            arrayList.add(new HybridDevice(dBWatch.getDevice_address(), 0, DeviceType.Companion.fromAdvertisedNumber(dBWatch.getDevice_type()), null, 8, null));
        }
        return arrayList;
    }

    public final RemoteConfigController getRemoteConfig() {
        return this.remoteConfig;
    }

    public final String getSku() {
        DBWatch currentWatch = this.db.getCurrentWatch();
        if (currentWatch != null) {
            return currentWatch.getSku();
        }
        return null;
    }

    public final boolean getStillnessActive() {
        return this.deviceDataSync.getStillnessActive();
    }

    public final long getTimeWhenDiagnosticsSent() {
        DBWatch currentWatch = this.db.getCurrentWatch();
        if (currentWatch != null) {
            return currentWatch.getTime_diagnostics_sent();
        }
        return DAILY_INTERVAL_MS;
    }

    public final String getTimeZoneId() {
        return this.deviceDataSync.getTimeZoneId();
    }

    public final boolean getUseHidForMusic() {
        return this.deviceDataSync.getUseHidForMusic();
    }

    public final UserCategory getUserCategory() {
        String str;
        UserCategory.Companion companion = UserCategory.Companion;
        DBWatch currentWatch = this.db.getCurrentWatch();
        if (currentWatch != null) {
            str = currentWatch.getCategory();
        } else {
            str = null;
        }
        UserCategory fromIdentifier = companion.fromIdentifier(str);
        if (fromIdentifier == null) {
            return UserCategory.Live;
        }
        return fromIdentifier;
    }

    public final Watch getWatch() {
        return this.watchManager.getCurrentWatch();
    }

    public final WatchManager getWatchManager() {
        return this.watchManager;
    }

    public final boolean getWroteOnboardingDeviceSettings() {
        return this.deviceDataSync.getWroteOnboardingDeviceSettings();
    }

    public final boolean hasDevice() {
        if (this.device != null) {
            return true;
        }
        return false;
    }

    public final boolean hasDoNotDisturb() {
        return getCommandCenter().hasDoNotDisturb();
    }

    public final boolean hasFastMode() {
        boolean z;
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            z = deviceInterface.isConnected();
        } else {
            z = false;
        }
        if (!z || !getCommandCenter().hasFastMode()) {
            return false;
        }
        return true;
    }

    public final void incomingCall(int r13, boolean z, Integer num) {
        WatchIO io2 = getIo();
        if (io2 == null) {
            LogKt.debug$default((Object) this, "incomingCall: no device, cant write call change", (String) null, (Throwable) null, false, 14, (Object) null);
        } else {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            BuildersKt.launch$default(this, MainDispatcherLoader.dispatcher, null, new WatchProvider$incomingCall$1(this, z, num, io2, r13, null), 2);
        }
    }

    public final void init() {
        ThreadUtils.assertIsOnMainThread();
        this.behaviourFactory.initBehaviours(this.context);
        List<Behaviour> allBehaviours = this.behaviourFactory.getAllBehaviours();
        List<RemoteAppImpl> debugBehaviours = getDebugBehaviours();
        if (!debugBehaviours.isEmpty()) {
            List<AppPosition> appPositions = this.watchManager.getBehaviours().getAppPositions();
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(appPositions, 10));
            Iterator<T> it = appPositions.iterator();
            while (it.hasNext()) {
                arrayList.add(((AppPosition) it.next()).getAppId());
            }
            this.watchManager.getBehaviours().updatePositions(CollectionsKt___CollectionsKt.plus((Iterable) CollectionsKt__CollectionsKt.listOf((Object[]) new AppId[]{AppId.DebugImages, AppId.DebugFullScreen}), (Collection) arrayList));
        }
        this.watchManager.setBehaviours(CollectionsKt___CollectionsKt.plus((Iterable) debugBehaviours, (Collection) allBehaviours));
        StorageToDbMigration.INSTANCE.migrate(KronabyApplication.Companion.getContext(), this.db, fitness());
        if (this.watchManager.knownWatchCount() > DAILY_INTERVAL_MS) {
            setupDevice();
            CompanionDeviceUtils companionDeviceUtils = CompanionDeviceUtils.INSTANCE;
            Context context = this.context;
            List<Watch> watches = this.watchManager.getWatches();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(watches, 10));
            Iterator<T> it2 = watches.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Watch) it2.next()).getIdentifier());
            }
            companionDeviceUtils.startObservingDevicePresence(context, arrayList2);
        }
        if (isOnboardingFinished()) {
            this.onboardingFinishedStorage.setIsOnboardingFinished(true);
        }
        this.remoteConfig.registerListener(new RemoteConfigController.RemoteConfigControllerListener() { // from class: com.animaconnected.watch.WatchProvider$init$2
            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetch() {
                WatchProvider.this.configureFromRemoteConfig();
                if ((WatchProvider.this.getRemoteConfig().getDebuggingEnabled() || UserCategoryKt.useDogfoodingLogger(ProviderFactory.getWatch().getUserCategory())) && !(LogKt.getCurrentLogger() instanceof DogfoodLogger)) {
                    LogKt.prepareLogger(new DogfoodLogger(KronabyApplication.Companion.getContext()));
                }
                WatchProvider watchProvider = WatchProvider.this;
                BuildersKt.launch$default(watchProvider, null, null, new WatchProvider$init$2$onFetch$1(watchProvider, null), 3);
            }

            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetchFailed(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        });
        schedulePeriodicTasks();
        configureFromRemoteConfig();
    }

    public final boolean isAlertComplicationEnabled() {
        Integer num;
        Map<String, Integer> deviceConfigSettings = this.remoteConfig.getDeviceConfigSettings();
        if (deviceConfigSettings.containsKey("alert_complication_enabled") && (num = deviceConfigSettings.get("alert_complication_enabled")) != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean isBluetoothInDebug() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.getDebugMode();
        }
        return false;
    }

    public final boolean isConnected() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.isConnected();
        }
        return false;
    }

    public final boolean isFotaSlowModeEnabled() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.isFotaSlowModeEnabled();
        }
        return false;
    }

    public final boolean isInDfuMode() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.isInDfuMode();
        }
        return false;
    }

    public final boolean isInUpdateRequired() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.isInUpdateRequired();
        }
        return false;
    }

    public final boolean isOnboardingFinished() {
        return this.deviceDataSync.isOnboardingFinished();
    }

    public final boolean isRssiNotificationActive() {
        return this.deviceDataSync.getRssiNotification();
    }

    public final boolean isRunningFota() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            return deviceInterface.isRunningFota();
        }
        return false;
    }

    public final Future<Unit> makeNewCalibration(WatchFace watchFace, int r9, int r10) {
        Intrinsics.checkNotNullParameter(watchFace, "watchFace");
        WatchIO io2 = getIo();
        if (io2 == null) {
            Future<Unit> error = FutureUtils.error(new IllegalStateException("No connected device"));
            Intrinsics.checkNotNullExpressionValue(error, "error(...)");
            return error;
        }
        if (!getCapabilities().getHasRecalibrateHand()) {
            return wrapInFuture(new WatchProvider$makeNewCalibration$1(io2, watchFace, r9, r10, null));
        }
        return wrapInFuture(new WatchProvider$makeNewCalibration$2(io2, watchFace, r9, r10, null));
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlarm(int r3) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onAlarmEvent(r3);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onAlert(int r9, int r10, int r11, int r12, int r13) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onAlertEvent(r9, r10, r11, r12, r13);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryCharger(boolean z) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onBatteryChargerChanged(z);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onBatteryPercent(float f) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onBatteryPercentChanged(f);
        }
    }

    @Override // com.animaconnected.watch.device.BehaviourListener
    public void onBehaviourSet(Slot slot, Behaviour behaviour) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onBehaviourSet(slot, behaviour);
        }
        getAnalyticsConfigHelper().sendCorrectAnalyticsConfig(slot);
    }

    @Override // com.animaconnected.watch.device.BehaviourListener
    public void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(action, "action");
        if (behaviour != null) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((WatchProviderListener) it.next()).onBehaviourExecuted(behaviour);
            }
        }
        Iterator<T> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            ((WatchProviderListener) it2.next()).onButtonClicked(slot, behaviour, action, z);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onConnIntChange(int r10, int r11, int r12) {
        LogKt.debug$default((Object) this, AndroidWindowInsets$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("onConnIntChange() called with: currentConnInt[", r10, "], slaveLatency = [", r11, "], timeout = ["), r12, ']'), (String) null, (Throwable) null, false, 14, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onConnIntChange(r10, r11, r12);
        }
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.onConnectionIntervalChange(r10);
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        boolean z;
        LogKt.info$default((Object) this, "onConnected", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        this.previouslyConnectedDevice = null;
        fireBatteryStateChanged(BatteryState.NORMAL);
        LabsProvider labsProvider = ProviderFactory.getLabsProvider();
        if (labsProvider.isMoreNumbersEnabled() && getCapabilities().getHasSixAlerts()) {
            z = true;
        } else {
            z = false;
        }
        labsProvider.syncMoreNumbersInDatabase(z);
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$onConnected$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Device connection ready, notifying listeners";
            }
        }, 6, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onConnectionChanged(true);
        }
        Iterator<T> it2 = this.deviceConnectionListeners.iterator();
        while (it2.hasNext()) {
            ((DeviceConnectionListener) it2.next()).onConnected();
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(this, MainDispatcherLoader.dispatcher, null, new WatchProvider$onConnected$4(this, null), 2);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnecting() {
        ThreadUtils.assertIsOnMainThread();
        Iterator<T> it = this.deviceConnectionListeners.iterator();
        while (it.hasNext()) {
            ((DeviceConnectionListener) it.next()).onConnecting();
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceButtonClicked(Button button, ButtonAction action) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceError(DeviceError deviceError) {
        Intrinsics.checkNotNullParameter(deviceError, "deviceError");
        int r0 = WhenMappings.$EnumSwitchMapping$1[deviceError.ordinal()];
        if (r0 != 1) {
            if (r0 != 2 && r0 != 3 && r0 != 4) {
                if (r0 != 5) {
                    LogKt.err$default((Object) this, "On deviceError: unhandled error: " + deviceError, (String) null, (Throwable) null, false, 14, (Object) null);
                    return;
                } else {
                    Iterator<T> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((WatchProviderListener) it.next()).onCalibrationTimeout();
                    }
                    return;
                }
            }
            fireBatteryStateChanged(BatteryState.Companion.fromDeviceError(deviceError));
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDiagEvent(Map<String, String> diagEvent) {
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
        LogKt.debug$default((Object) this, "Diag event received: " + diagEvent, (String) null, (Throwable) null, false, 14, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onDiagEvent(diagEvent);
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        LogKt.debug$default((Object) this, "Device disconnected", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WatchProvider$onDisconnected$1(this, null));
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onConnectionChanged(false);
        }
        Iterator<T> it2 = this.deviceConnectionListeners.iterator();
        while (it2.hasNext()) {
            ((DeviceConnectionListener) it2.next()).onDisconnected();
        }
        LePingReq.INSTANCE.disable();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        LogKt.debug$default((Object) this, "DFU resume available", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WatchProvider$onEnterDfuMode$1(this, null));
        Iterator<T> it = this.deviceConnectionListeners.iterator();
        while (it.hasNext()) {
            ((DeviceConnectionListener) it.next()).onEnterDfuMode();
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        LogKt.debug$default((Object) this, "Enter UpdateRequired", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        Iterator<T> it = this.deviceConnectionListeners.iterator();
        while (it.hasNext()) {
            ((DeviceConnectionListener) it.next()).onEnterUpdateRequired();
        }
    }

    @Override // com.animaconnected.watch.DeviceInterface.FirmwareInfoListener
    public void onFirmwareChanged(String str, String str2, boolean z) {
        ThreadUtils.assertIsOnMainThread();
        Iterator<T> it = this.firmwareChangedListeners.iterator();
        while (it.hasNext()) {
            ((DeviceInterface.FirmwareInfoListener) it.next()).onFirmwareChanged(str, str2, z);
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        LogKt.debug$default((Object) this, "DFU resume unavailable", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        Iterator<T> it = this.deviceConnectionListeners.iterator();
        while (it.hasNext()) {
            ((DeviceConnectionListener) it.next()).onLeaveDfuMode();
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
        LogKt.debug$default((Object) this, "Leave UpdateRequired", (String) null, (Throwable) null, false, 14, (Object) null);
        ThreadUtils.assertIsOnMainThread();
        Iterator<T> it = this.deviceConnectionListeners.iterator();
        while (it.hasNext()) {
            ((DeviceConnectionListener) it.next()).onLeaveUpdateRequired();
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onPressDuringCall(int r1) {
        CallHelper.INSTANCE.dismissCall();
    }

    public final void onResume() {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface == null) {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchProvider$onResume$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onResume: No device is active. Nothing to resume or restart";
                }
            }, 6, (Object) null);
        } else {
            deviceInterface.onResume();
            DeviceService.Companion.start(this.context);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onRssiEvent(int r9) {
        LogKt.debug$default((Object) this, SubMenuBuilder$$ExternalSyntheticOutline0.m("Rssi event received: ", r9), (String) null, (Throwable) null, false, 14, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onRssiEvent(r9);
        }
    }

    @Override // com.animaconnected.bluetooth.device.DeviceAnalyticsListener
    public void onSendAnalytics(String state, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(state, "state");
        ThreadUtils.assertIsOnMainThread();
        DeviceAnalyticsListener deviceAnalyticsListener = this.analyticsListener;
        if (deviceAnalyticsListener != null) {
            deviceAnalyticsListener.onSendAnalytics(state, z, bool);
        }
    }

    @Override // com.animaconnected.bluetooth.device.DeviceAnalyticsListener
    public void onServicesNotFound(int r2) {
        ThreadUtils.assertIsOnMainThread();
        DeviceAnalyticsListener deviceAnalyticsListener = this.analyticsListener;
        if (deviceAnalyticsListener != null) {
            deviceAnalyticsListener.onServicesNotFound(r2);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStepsNow(int r8, int r9, int r10, int r11) {
        LogKt.debug$default((Object) this, SubMenuBuilder$$ExternalSyntheticOutline0.m("Steps today received: ", r8), (String) null, (Throwable) null, false, 14, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onStepsNow(r8, r11);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStillnessEvent(int r9) {
        LogKt.debug$default((Object) this, SubMenuBuilder$$ExternalSyntheticOutline0.m("Stillness event received: ", r9), (String) null, (Throwable) null, false, 14, (Object) null);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onStillnessEvent(r9);
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onStopwatchDataChanged() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onStopwatchDataChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onWatchConnecting(com.animaconnected.watch.device.WatchBackend r9, com.animaconnected.info.DeviceType r10, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.WatchConnectingResult> r11) {
        /*
            r8 = this;
            boolean r10 = r11 instanceof com.animaconnected.watch.WatchProvider$onWatchConnecting$1
            if (r10 == 0) goto L13
            r10 = r11
            com.animaconnected.watch.WatchProvider$onWatchConnecting$1 r10 = (com.animaconnected.watch.WatchProvider$onWatchConnecting$1) r10
            int r0 = r10.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r10.label = r0
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$onWatchConnecting$1 r10 = new com.animaconnected.watch.WatchProvider$onWatchConnecting$1
            r10.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r9 = r10.L$0
            com.animaconnected.watch.WatchProvider r9 = (com.animaconnected.watch.WatchProvider) r9
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r9
            goto L4f
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.WatchManager r11 = r8.watchManager
            r11.unregisterEventListener(r8)
            com.animaconnected.watch.WatchManager r11 = r8.watchManager
            r11.registerEventListener(r8)
            com.animaconnected.watch.WatchManager r11 = r8.watchManager
            r10.L$0 = r8
            r10.label = r2
            java.lang.Object r11 = r11.initWatch(r9, r10)
            if (r11 != r0) goto L4e
            return r0
        L4e:
            r1 = r8
        L4f:
            com.animaconnected.watch.Watch r11 = (com.animaconnected.watch.Watch) r11
            java.lang.String r2 = r1.tag
            r3 = 0
            r4 = 0
            com.animaconnected.watch.WatchProvider$onWatchConnecting$2 r5 = new com.animaconnected.watch.WatchProvider$onWatchConnecting$2
            r5.<init>()
            r6 = 6
            r7 = 0
            com.animaconnected.logger.LogKt.debug$default(r1, r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.flow.StateFlow r9 = r11.getState()
            java.lang.Object r9 = r9.getValue()
            com.animaconnected.watch.Watch$WatchState r10 = com.animaconnected.watch.Watch.WatchState.UpdateRequired
            if (r9 != r10) goto L6e
            com.animaconnected.watch.device.WatchConnectingResult r9 = com.animaconnected.watch.device.WatchConnectingResult.UpdateRequired
            goto L70
        L6e:
            com.animaconnected.watch.device.WatchConnectingResult r9 = com.animaconnected.watch.device.WatchConnectingResult.Success
        L70:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.onWatchConnecting(com.animaconnected.watch.device.WatchBackend, com.animaconnected.info.DeviceType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onboardDevice(HybridDevice scannedDevice) {
        Intrinsics.checkNotNullParameter(scannedDevice, "scannedDevice");
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WatchProvider$onboardDevice$1(this, scannedDevice, null));
        setupDevice();
    }

    public final Unit performFota() {
        DeviceInterface connectedDevice = getConnectedDevice();
        if (connectedDevice != null) {
            connectedDevice.performFota();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Future<Map<String, String>> readBuildInfo() {
        return wrapInFuture(new WatchProvider$readBuildInfo$1(this, null));
    }

    public final Future<Map<String, String>> readBuildInfoBl() {
        return wrapInFuture(new WatchProvider$readBuildInfoBl$1(this, null));
    }

    public final Future<Map<String, String>> readDiagnostics() {
        boolean z = false;
        if (getDeviceType() == DeviceType.BT003 && !getCapabilities().getHasDiagnosticPages()) {
            StatusDiagEnabledParams statusDiagPagingRequired = this.remoteConfig.getStatusDiagPagingRequired();
            int r1 = WhenMappings.$EnumSwitchMapping$0[getFirmwareUpdateCached().ordinal()];
            if (r1 != 1) {
                if (r1 == 2) {
                    z = statusDiagPagingRequired.getFota();
                }
            } else {
                z = statusDiagPagingRequired.getDfu();
            }
        }
        return wrapInFuture(new WatchProvider$readDiagnostics$1(z, this, null));
    }

    public final Future<List<Integer[]>> readStopwatch() {
        return wrapInFuture(new WatchProvider$readStopwatch$1(this, null));
    }

    public final boolean registerDeviceAvailableListener(DeviceAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.deviceAvailableListeners.add(listener);
    }

    public final boolean registerDeviceConnectionListener(DeviceConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.deviceConnectionListeners.add(listener);
    }

    public final Unit registerDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.registerDfuListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void registerEventListener(WatchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.watchManager.registerEventListener(listener);
    }

    public final boolean registerFirmwareChangedListener(DeviceInterface.FirmwareInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.firmwareChangedListeners.add(listener);
    }

    public final Unit registerFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.registerFotaListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final boolean registerListener(WatchProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.add(listener);
    }

    public final Unit registerOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.registerOnboardingConnectionListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void removeInactiveDevice(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        new SharedPreferencesCache(this.context, address).clear();
        try {
            Bonding.getInstance().removeBondFromDevice(address);
        } catch (Exception unused) {
        }
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WatchProvider$removeInactiveDevice$1(this, address, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* renamed from: resetDevice-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1052resetDeviceIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.watch.WatchProvider$resetDevice$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.watch.WatchProvider$resetDevice$1 r0 = (com.animaconnected.watch.WatchProvider$resetDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchProvider$resetDevice$1 r0 = new com.animaconnected.watch.WatchProvider$resetDevice$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L45
            goto L42
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.device.WatchIO r5 = r4.getIo()     // Catch: java.lang.Exception -> L45
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> L45
            r0.label = r3     // Catch: java.lang.Exception -> L45
            java.lang.Object r5 = r5.writeForgetDevice(r0)     // Catch: java.lang.Exception -> L45
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L45
            goto L4a
        L45:
            r5 = move-exception
            kotlin.Result$Failure r5 = kotlin.ResultKt.createFailure(r5)
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider.m1052resetDeviceIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void saveNewAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        LogKt.debug$default((Object) this, "Saving new address: ".concat(address), (String) null, (Throwable) null, true, 6, (Object) null);
        this.watchManager.changeAddressOnCurrent(address);
    }

    public final void sendFilterNotificationAnalytics() {
        getAnalyticsConfigHelper().sendFilterNotificationAnalytics();
    }

    public final void setAlertTypes(int r7, int r8, int r9, int r10, int r11) {
        if (this.deviceDataSync.updateAlertTypes(r7, r8, r9, r10, r11)) {
            BuildersKt.launch$default(this, null, null, new WatchProvider$setAlertTypes$1(this, null), 3);
        }
    }

    public final void setCalibrationMode(boolean z) {
        WatchIO io2 = getIo();
        if (io2 == null) {
            return;
        }
        BuildersKt.launch$default(this, null, null, new WatchProvider$setCalibrationMode$1(io2, z, this, null), 3);
    }

    public final void setDeviceAnalyticsListener(DeviceAnalyticsListener deviceAnalyticsListener) {
        this.analyticsListener = deviceAnalyticsListener;
    }

    public final void setDeviceTime() {
        this.deviceDataSync.setDirty();
        this.deviceDataSync.setForceTimeWrite();
        BuildersKt.launch$default(this, null, null, new WatchProvider$setDeviceTime$1(this, null), 3);
    }

    public final void setFastMode(boolean z) {
        BuildersKt.launch$default(this, null, null, new WatchProvider$setFastMode$1(this, z, null), 3);
    }

    public final Unit setFotaSlowMode(boolean z) {
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.setFotaSlowMode(z);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void setLastDfuReadyResult(String str) {
        this.db.updateLastDfuResult(str);
    }

    public final void setOnboardingFinished(boolean z) {
        this.deviceDataSync.setOnboardingFinished(z);
        this.deviceDataSync.setComplicationDirty();
        this.deviceDataSync.setCrownButtonComplicationDirty();
        this.deviceDataSync.setCrownDoubleButtonComplicationDirty();
        this.deviceDataSync.setDefaultComplicationDirty();
        this.deviceDataSync.setRemoteComplicationDataConfigDirty();
        this.deviceDataSync.setRemoteComplicationDirty();
        this.onboardingFinishedStorage.setIsOnboardingFinished(z);
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new WatchProvider$isOnboardingFinished$1(this, null));
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onOnboardingFinished(z);
        }
        BuildersKt.launch$default(this, null, null, new WatchProvider$isOnboardingFinished$3(this, null), 3);
    }

    public final void setOnboardingStarted() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((WatchProviderListener) it.next()).onOnboardingStarted();
        }
    }

    public final void setRssiNotification(boolean z) {
        this.deviceDataSync.setRssiNotification(z);
        BuildersKt.launch$default(this, null, null, new WatchProvider$setRssiNotification$1(this, null), 3);
    }

    public final void setSku(String str) {
        this.db.updateSku(str);
        this.watchManager.getCurrentWatch().setSku(getSku());
    }

    public final void setStillnessActive(boolean z) {
        this.deviceDataSync.setStillnessActive(z);
        BuildersKt.launch$default(this, null, null, new WatchProvider$stillnessActive$1(this, null), 3);
    }

    public final void setTimeWhenDiagnosticsSent(long j) {
        this.db.updateTimeDiagnosticsSent(Long.valueOf(j));
    }

    public final void setTimeZoneId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.deviceDataSync.setTimeZoneId(value);
        BuildersKt.launch$default(this, null, null, new WatchProvider$timeZoneId$1(this, null), 3);
    }

    public final void setUseHidForMusic(boolean z) {
        this.deviceDataSync.setUseHidForMusic(z);
        BuildersKt.launch$default(this, null, null, new WatchProvider$useHidForMusic$1(this, null), 3);
    }

    public final void setUserCategory(UserCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.db.updateCategory(category);
    }

    public final void setWroteOnboardingDeviceSettings(boolean z) {
        this.deviceDataSync.setWroteOnboardingDeviceSettings(z);
    }

    public final Future<Void> startDfu(BaseDfuController dfu, Uri uri) {
        Intrinsics.checkNotNullParameter(dfu, "dfu");
        Intrinsics.checkNotNullParameter(uri, "uri");
        DeviceInterface connectedOrDfuDevice = getConnectedOrDfuDevice();
        if (connectedOrDfuDevice != null) {
            return connectedOrDfuDevice.startDfu(dfu, uri);
        }
        return null;
    }

    public final Unit startFota(BaseFotaController fota, Uri firmware, boolean z) {
        Intrinsics.checkNotNullParameter(fota, "fota");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        DeviceInterface connectedDevice = getConnectedDevice();
        if (connectedDevice != null) {
            connectedDevice.startFota(fota, firmware, z);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void startVibratorWithPattern(int[] ints) {
        Intrinsics.checkNotNullParameter(ints, "ints");
        LogKt.debug$default((Object) this, "startVibratorWithPattern called", (String) null, (Throwable) null, false, 14, (Object) null);
        wrapInFuture(new WatchProvider$startVibratorWithPattern$1(this, ints, null));
    }

    public final Unit unRegisterOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.unregisterOnboardingConnectionListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final boolean unregisterDeviceAvailableListener(DeviceAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.deviceAvailableListeners.remove(listener);
    }

    public final boolean unregisterDeviceConnectionListener(DeviceConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.deviceConnectionListeners.remove(listener);
    }

    public final Unit unregisterDfuListener(DeviceDfuListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.unregisterDfuListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void unregisterEventListener(WatchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.watchManager.unregisterEventListener(listener);
    }

    public final boolean unregisterFirmwareChangedListener(DeviceInterface.FirmwareInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.firmwareChangedListeners.remove(listener);
    }

    public final Unit unregisterFotaListener(DeviceFotaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DeviceInterface deviceInterface = this.device;
        if (deviceInterface != null) {
            deviceInterface.unregisterFotaListener(listener);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final boolean unregisterListener(WatchProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.remove(listener);
    }

    public final void updateRemoteComplication() {
        Watch currentWatch = this.watchManager.getCurrentWatch();
        if (currentWatch instanceof HybridWatch) {
            ((HybridWatch) currentWatch).updateRemoteComplication();
        }
    }

    public final void updateSpeedCalibrationEnabled() {
        boolean z;
        FitnessProvider.SessionProvider sessionProvider = this.watchManager.getFitnessProvider().getSessionProvider();
        if (!this.remoteConfig.getSpeedCalibrationEnabled() && !DebugStorage.INSTANCE.isSpeedCalibrationEnabled()) {
            z = false;
        } else {
            z = true;
        }
        sessionProvider.setEnableSpeedCalibration(z);
    }

    public final void writeHardFault(boolean z) {
        BuildersKt.launch$default(this, null, null, new WatchProvider$writeHardFault$1(this, z, null), 3);
    }

    /* compiled from: WatchProvider.kt */
    /* loaded from: classes3.dex */
    public interface WatchProviderListener {
        default void onBehaviourSet(Slot slot, Behaviour behaviour) {
            Intrinsics.checkNotNullParameter(slot, "slot");
        }

        default void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            Intrinsics.checkNotNullParameter(action, "action");
        }

        default void onDiagEvent(Map<String, String> diagEvent) {
            Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
        }

        default void onCalibrationTimeout() {
        }

        default void onDaily() {
        }

        default void onHourly() {
        }

        default void onOnboardingStarted() {
        }

        default void onStopwatchDataChanged() {
        }

        default void onWroteDeviceSettings() {
        }

        default void onAlarmEvent(int r1) {
        }

        default void onBatteryChargerChanged(boolean z) {
        }

        default void onBatteryPercentChanged(float f) {
        }

        default void onBatteryStateChanged(BatteryState batteryState) {
        }

        default void onBehaviourExecuted(Behaviour behaviour) {
        }

        default void onConnectionChanged(boolean z) {
        }

        default void onOnboardingFinished(boolean z) {
        }

        default void onRssiEvent(int r1) {
        }

        default void onStillnessEvent(int r1) {
        }

        default void onStepsNow(int r1, int r2) {
        }

        default void onConnIntChange(int r1, int r2, int r3) {
        }

        default void onDeviceDebugDisconnect(Integer num, Integer num2, Integer num3) {
        }

        default void onAlertEvent(int r1, int r2, int r3, int r4, int r5) {
        }
    }

    @Override // com.animaconnected.watch.device.WatchEventListener
    public void onDeviceCrash(int r1) {
    }
}
