package com.animaconnected.watch;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.DevicesKt;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.msgpack.MsgPackKotlin;
import com.animaconnected.watch.account.fitness.FitnessCloudProvider;
import com.animaconnected.watch.account.fitness.FitnessCloudSyncApi;
import com.animaconnected.watch.account.fitness.FitnessHttpClient;
import com.animaconnected.watch.account.profile.ProfileProvider;
import com.animaconnected.watch.account.strava.StravaAuth;
import com.animaconnected.watch.account.strava.StravaClient;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.Button;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.DefaultWatchStyle;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.FullWatchEventListener;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.device.WatchBackend;
import com.animaconnected.watch.device.WatchEventListener;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.filter.FilterSettings;
import com.animaconnected.watch.filter.FilterSettingsImpl;
import com.animaconnected.watch.fitness.CSEMLogs;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.InternalFitnessProvider;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import com.animaconnected.watch.provider.WatchAlarmProviderListener;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import com.animaconnected.watch.provider.preferences.PreferenceProvider;
import com.animaconnected.watch.provider.preferences.Preferences;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.storage.models.DBWatch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;

/* compiled from: WatchManager.kt */
/* loaded from: classes3.dex */
public final class WatchManager {
    private final WatchAlarmProvider alarmsProvider;
    private final Behaviours behaviours;
    private final Lazy csemLogs$delegate;
    private Deferred<Boolean> currentSync;
    private CommonFlow<Watch> currentWatchFlow;
    private MutableStateFlow<Watch> currentWatchMutable;
    private final WatchDatabase db;
    private final DemoModeProvider demoModeProvider;
    private final DeviceDataSync deviceDataSync;
    private final FullWatchEventListener deviceEventListener;
    private boolean enabledNewDataNotification;
    private final Set<WatchEventListener> eventListeners;
    private final FilterSettings filterSettings;
    private final FitnessProvider fitnessProvider;
    private final boolean ignoreAlertAssign;
    private Instant lastPeriodical;
    private final LocationProvider locationProvider;
    private final MsgPackCreator msgPackCreator;
    private final long periodicalInterval;
    private final PreferenceProvider preferenceProvider;
    private final Preferences preferences;
    private final ProfileProvider profileProvider;
    private final QuietHoursProvider.QuietHoursChangedListener quietHoursListener;
    private final ResourceSynchronizer resourceSynchronizer;
    private final CoroutineScope scope;
    private final StravaClient stravaClient;
    private final String tag;
    private final WatchDb watchDb;
    private List<? extends Watch> watches;
    private Flow<? extends List<? extends Watch>> watchesFlow;
    private MutableStateFlow<List<Watch>> watchesMutable;
    private final HistoricalWeatherProvider weatherProvider;

    /* compiled from: WatchManager.kt */
    /* renamed from: com.animaconnected.watch.WatchManager$1 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<String> {
        public static final AnonymousClass1 INSTANCE = ;

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "WatchManager initialized";
        }
    }

    /* compiled from: WatchManager.kt */
    @DebugMetadata(c = "com.animaconnected.watch.WatchManager$3", f = "WatchManager.kt", l = {394}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.WatchManager$3 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                WatchManager watchManager = WatchManager.this;
                Watch currentWatch = watchManager.getCurrentWatch();
                this.label = 1;
                if (watchManager.setCurrentWatch(currentWatch, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            WatchManager.this.getDemoModeProvider().startJobIfEnabled$watch_release();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: WatchManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[Slot.values().length];
            try {
                r0[Slot.TopPusher.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Slot.BottomPusher.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Slot.MainComplication.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Slot.MainComplicationDouble.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Slot.MagicKey.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[DeviceType.values().length];
            try {
                r02[DeviceType.PASCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[DeviceType.PASCAL_FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public WatchManager(WatchDatabase db, String elevationApiKey, StravaAuth auth, boolean z) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(elevationApiKey, "elevationApiKey");
        Intrinsics.checkNotNullParameter(auth, "auth");
        this.db = db;
        this.ignoreAlertAssign = z;
        this.msgPackCreator = MsgPackKotlin.Companion;
        WatchDb watchDb = new WatchDb(db);
        this.watchDb = watchDb;
        PreferenceProvider preferenceProvider = new PreferenceProvider(db.getConfigQueries(), new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$preferenceProvider$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WatchManager.this.getCurrentWatch().getIdentifier();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.watch.WatchManager$preferenceProvider$2

            /* compiled from: WatchManager.kt */
            @DebugMetadata(c = "com.animaconnected.watch.WatchManager$preferenceProvider$2$1", f = "WatchManager.kt", l = {63}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.WatchManager$preferenceProvider$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ WatchManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(WatchManager watchManager, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = watchManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        WatchManager watchManager = this.this$0;
                        this.label = 1;
                        if (watchManager.sync(this) == coroutineSingletons) {
                            return coroutineSingletons;
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
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CoroutineScope coroutineScope;
                coroutineScope = WatchManager.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(WatchManager.this, null), 3);
            }
        });
        this.preferenceProvider = preferenceProvider;
        this.preferences = preferenceProvider;
        ProfileProvider profileProvider = new ProfileProvider(db.getFitnessQueries(), new Function0<Unit>() { // from class: com.animaconnected.watch.WatchManager$profileProvider$1

            /* compiled from: WatchManager.kt */
            @DebugMetadata(c = "com.animaconnected.watch.WatchManager$profileProvider$1$1", f = "WatchManager.kt", l = {73}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.WatchManager$profileProvider$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ WatchManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(WatchManager watchManager, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = watchManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        WatchManager watchManager = this.this$0;
                        this.label = 1;
                        if (watchManager.sync(this) == coroutineSingletons) {
                            return coroutineSingletons;
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
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CoroutineScope coroutineScope;
                coroutineScope = WatchManager.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(WatchManager.this, null), 3);
            }
        });
        this.profileProvider = profileProvider;
        this.stravaClient = new StravaClient(auth, db.getFitnessQueries(), new Function0<HistoryDeviceId>() { // from class: com.animaconnected.watch.WatchManager$stravaClient$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ HistoryDeviceId invoke() {
                return HistoryDeviceId.m1556boximpl(m1051invokeV9ZILtA());
            }

            /* renamed from: invoke-V9ZILtA, reason: not valid java name */
            public final String m1051invokeV9ZILtA() {
                return WatchManager.this.getCurrentWatch().m1046getHistoryDeviceIdV9ZILtA();
            }
        });
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        DeviceDataSync deviceDataSync = new DeviceDataSync(new DeviceDataStorage(serviceLocator.getStorageFactory()));
        this.deviceDataSync = deviceDataSync;
        ResourceSynchronizer resourceSynchronizer = new ResourceSynchronizer(db);
        this.resourceSynchronizer = resourceSynchronizer;
        this.filterSettings = new FilterSettingsImpl(resourceSynchronizer);
        CoroutineScope scope = serviceLocator.getScope();
        this.scope = scope;
        WatchAlarmProvider alarmsProvider = serviceLocator.getAlarmsProvider();
        this.alarmsProvider = alarmsProvider;
        this.tag = "WatchManager";
        this.weatherProvider = serviceLocator.getWeatherProvider();
        this.csemLogs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CSEMLogs>() { // from class: com.animaconnected.watch.WatchManager$csemLogs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CSEMLogs invoke() {
                CoroutineScope coroutineScope;
                coroutineScope = WatchManager.this.scope;
                return new CSEMLogs(coroutineScope);
            }
        });
        Instant.Companion.getClass();
        this.lastPeriodical = Instant.DISTANT_PAST;
        int r8 = Duration.$r8$clinit;
        this.periodicalInterval = DurationKt.toDuration(1, DurationUnit.HOURS);
        WatchManager$deviceEventListener$1 watchManager$deviceEventListener$1 = new WatchManager$deviceEventListener$1(this);
        this.deviceEventListener = watchManager$deviceEventListener$1;
        QuietHoursProvider.QuietHoursChangedListener quietHoursChangedListener = new QuietHoursProvider.QuietHoursChangedListener() { // from class: com.animaconnected.watch.WatchManager$$ExternalSyntheticLambda0
            @Override // com.animaconnected.watch.provider.quiethours.QuietHoursProvider.QuietHoursChangedListener
            public final void onQuietHoursChanged(boolean z2, int r82, int r9, int r10, int r11) {
                WatchManager.quietHoursListener$lambda$0(WatchManager.this, z2, r82, r9, r10, r11);
            }
        };
        this.quietHoursListener = quietHoursChangedListener;
        WatchFitnessProvider watchFitnessProvider = new WatchFitnessProvider(serviceLocator.getScope(), serviceLocator.getLocationProvider(), serviceLocator.getAccountBackend(), db.getFitnessQueries(), elevationApiKey, new FitnessCloudProvider(new FitnessCloudSyncApi(new FitnessHttpClient(serviceLocator.getAccountBackend().isSandbox())), serviceLocator.getStorageFactory().createStorage("fitnessCloudStorage"), db.getFitnessQueries()), profileProvider);
        this.fitnessProvider = watchFitnessProvider;
        this.demoModeProvider = new DemoModeProvider(this, watchFitnessProvider, watchDb);
        this.behaviours = new Behaviours(watchDb, deviceDataSync, this, resourceSynchronizer, watchManager$deviceEventListener$1, preferenceProvider);
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(toWatch(watchDb.getAllWatches()));
        this.watchesMutable = MutableStateFlow;
        this.watchesFlow = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
        this.watches = this.watchesMutable.getValue();
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(getPreferredWatch());
        this.currentWatchMutable = MutableStateFlow2;
        this.currentWatchFlow = FlowExtensionsKt.asCommonFlow(MutableStateFlow2);
        this.locationProvider = serviceLocator.getLocationProvider();
        LogKt.info$default((Object) this, "WatchManager", (Throwable) null, true, (Function0) AnonymousClass1.INSTANCE, 2, (Object) null);
        getQuietHours().registerListener(quietHoursChangedListener);
        alarmsProvider.registerListener(new WatchAlarmProviderListener() { // from class: com.animaconnected.watch.WatchManager$$ExternalSyntheticLambda1
            @Override // com.animaconnected.watch.provider.WatchAlarmProviderListener
            public final void onAlarmsChanged() {
                WatchManager._init_$lambda$1(WatchManager.this);
            }
        });
        BuildersKt.launch$default(scope, null, null, new AnonymousClass3(null), 3);
        this.eventListeners = new HashSet();
        this.enabledNewDataNotification = true;
    }

    public static final void _init_$lambda$1(WatchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deviceEventListener.onAlarm(5);
        this$0.deviceDataSync.setAlarmsDirty();
        BuildersKt.launch$default(this$0.scope, null, null, new WatchManager$2$1(this$0, null), 3);
    }

    private final void checkIfFirmwareWasUpdated(Watch watch, WatchBackend watchBackend) {
        final String firmwareRevision = watch.getFirmwareRevision();
        final String str = watchBackend.getDeviceInfo().get(DeviceInfo.FirmwareRevision);
        if (!Intrinsics.areEqual(firmwareRevision, str)) {
            LogKt.info$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$checkIfFirmwareWasUpdated$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Firmware changed: ");
                    sb.append(firmwareRevision);
                    sb.append(" -> ");
                    return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str, ". Clearing caches, deviceDataSync dirty");
                }
            }, 6, (Object) null);
            watch.clear();
            this.deviceDataSync.setAllDirty();
            this.deviceDataSync.setDirty();
            watch.setFirmwareRevision(str);
        }
    }

    private final Watch createWatch(String str, String str2, DeviceType deviceType, FirmwareVariant firmwareVariant) {
        BasicStorage createDeviceStorage = ServiceLocator.INSTANCE.getStorageFactory().createDeviceStorage(str);
        int r1 = WhenMappings.$EnumSwitchMapping$1[deviceType.ordinal()];
        if (r1 != 1 && r1 != 2) {
            return new HybridWatch(createDeviceStorage, str, str2, deviceType, firmwareVariant, this.msgPackCreator, this.resourceSynchronizer, this.watchDb, this.db.getFitnessQueries(), this.deviceDataSync, new WatchManager$createWatch$2(this), this.behaviours, this.ignoreAlertAssign);
        }
        return new DisplayWatch(createDeviceStorage, str, str2, deviceType, firmwareVariant, this.msgPackCreator, this.resourceSynchronizer, this.watchDb, this.db.getFitnessQueries(), this.deviceDataSync, new WatchManager$createWatch$1(this), this.behaviours, this.profileProvider, this.filterSettings, this.demoModeProvider, this.preferenceProvider, new DefaultWatchStyle(str));
    }

    public static /* synthetic */ Watch createWatch$default(WatchManager watchManager, String str, String str2, DeviceType deviceType, FirmwareVariant firmwareVariant, int r5, Object obj) {
        if ((r5 & 8) != 0) {
            firmwareVariant = new FirmwareVariant(null, 1, null);
        }
        return watchManager.createWatch(str, str2, deviceType, firmwareVariant);
    }

    public static final Object createWatch$sync(WatchManager watchManager, Continuation continuation) {
        Object sync = watchManager.sync(continuation);
        if (sync == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return sync;
        }
        return Unit.INSTANCE;
    }

    public static final Object createWatch$sync$13(WatchManager watchManager, Continuation continuation) {
        Object sync = watchManager.sync(continuation);
        if (sync == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return sync;
        }
        return Unit.INSTANCE;
    }

    private final Watch getPreferredWatch() {
        Object obj;
        DBWatch currentWatch = this.watchDb.getCurrentWatch();
        Iterator<T> it = getWatches().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String identifier = ((Watch) next).getIdentifier();
            if (currentWatch != null) {
                obj = currentWatch.getDevice_address();
            }
            if (Intrinsics.areEqual(identifier, obj)) {
                obj = next;
                break;
            }
        }
        Watch watch = (Watch) obj;
        if (watch == null) {
            return createWatch$default(this, DevicesKt.fakeMacAddress, null, DeviceType.GARBO, null, 8, null);
        }
        return watch;
    }

    public final void handleDisplayWatchButton(Button button, DisplayWatch displayWatch, ButtonAction buttonAction) {
        if (button != Button.Top) {
            return;
        }
        if (buttonAction == ButtonAction.LongPress) {
            LogKt.info$default((Object) this, buttonAction + " is not supported on Pascal, quick action conflict.", (String) null, (Throwable) null, false, 14, (Object) null);
            return;
        }
        WatchApp quickAction = this.behaviours.getQuickAction();
        if (quickAction == null) {
            LogKt.info$default((Object) this, "There is no quick action assigned!", (String) null, (Throwable) null, false, 14, (Object) null);
            return;
        }
        if (quickAction instanceof Pusher) {
            ((Pusher) quickAction).execute(buttonAction);
            ServiceLocator.INSTANCE.getAnalytics().getAppEvents().displayAppQATriggered(quickAction.getAnalyticsName());
        } else {
            LogKt.warn$default((Object) this, quickAction.getTitle() + " doesn't implement pusher", (String) null, (Throwable) null, false, 14, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleHybridWatchButton(com.animaconnected.watch.Slot r9, com.animaconnected.watch.device.ButtonAction r10, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends com.animaconnected.watch.behaviour.Behaviour, java.lang.Boolean>> r11) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager.handleHybridWatchButton(com.animaconnected.watch.Slot, com.animaconnected.watch.device.ButtonAction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object notifyMagicKeyIfRunning(com.animaconnected.watch.device.ButtonAction r5, com.animaconnected.watch.Slot r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.WatchManager$notifyMagicKeyIfRunning$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.WatchManager$notifyMagicKeyIfRunning$1 r0 = (com.animaconnected.watch.WatchManager$notifyMagicKeyIfRunning$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchManager$notifyMagicKeyIfRunning$1 r0 = new com.animaconnected.watch.WatchManager$notifyMagicKeyIfRunning$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.device.ButtonAction r5 = (com.animaconnected.watch.device.ButtonAction) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.Slot r7 = com.animaconnected.watch.Slot.TopPusher
            if (r6 == r7) goto L69
            com.animaconnected.watch.Slot r7 = com.animaconnected.watch.Slot.BottomPusher
            if (r6 != r7) goto L3f
            goto L69
        L3f:
            com.animaconnected.watch.behaviour.Behaviours r6 = r4.behaviours
            com.animaconnected.watch.Slot r7 = com.animaconnected.watch.Slot.MagicKey
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r6.getBehaviour(r7, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            boolean r6 = r7 instanceof com.animaconnected.watch.behaviour.Pusher
            if (r6 == 0) goto L55
            com.animaconnected.watch.behaviour.Pusher r7 = (com.animaconnected.watch.behaviour.Pusher) r7
            goto L56
        L55:
            r7 = 0
        L56:
            r6 = 0
            if (r7 == 0) goto L60
            boolean r0 = r7.isExecuting()
            if (r0 != r3) goto L60
            goto L61
        L60:
            r3 = r6
        L61:
            if (r3 == 0) goto L66
            r7.execute(r5)
        L66:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L69:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager.notifyMagicKeyIfRunning(com.animaconnected.watch.device.ButtonAction, com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void quietHoursListener$lambda$0(WatchManager this$0, boolean z, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deviceDataSync.setQuietHoursDirty();
        BuildersKt.launch$default(this$0.scope, null, null, new WatchManager$quietHoursListener$1$1(this$0, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setCurrentWatch(com.animaconnected.watch.Watch r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.WatchManager$setCurrentWatch$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.WatchManager$setCurrentWatch$1 r0 = (com.animaconnected.watch.WatchManager$setCurrentWatch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchManager$setCurrentWatch$1 r0 = new com.animaconnected.watch.WatchManager$setCurrentWatch$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            com.animaconnected.watch.Watch r6 = (com.animaconnected.watch.Watch) r6
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.WatchManager r0 = (com.animaconnected.watch.WatchManager) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6c
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.lang.Object r6 = r0.L$1
            com.animaconnected.watch.Watch r6 = (com.animaconnected.watch.Watch) r6
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.WatchManager r2 = (com.animaconnected.watch.WatchManager) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L46:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.behaviour.Behaviours r7 = r5.behaviours
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.deactivateBehaviours(r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            r2 = r5
        L59:
            r2.setCurrentWatch(r6)
            com.animaconnected.watch.behaviour.Behaviours r7 = r2.behaviours
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r7.activateBehaviours(r0)
            if (r7 != r1) goto L6b
            return r1
        L6b:
            r0 = r2
        L6c:
            com.animaconnected.watch.fitness.FitnessProvider r7 = r0.fitnessProvider
            com.animaconnected.watch.fitness.InternalFitnessProvider r7 = r0.internal$watch_release(r7)
            r7.setWatch(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager.setCurrentWatch(com.animaconnected.watch.Watch, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Watch toWatch(DBWatch dBWatch) {
        DeviceType fromAdvertisedNumber = DeviceType.Companion.fromAdvertisedNumber(dBWatch.getDevice_type());
        if (Intrinsics.areEqual(dBWatch.getDevice_address(), DevicesKt.fakeMacAddress)) {
            LogKt.warn$default((Object) dBWatch, this.tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$toWatch$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Watch with fake Mac address in db";
                }
            }, 2, (Object) null);
        }
        return createWatch(dBWatch.getDevice_address(), dBWatch.getSku(), fromAdvertisedNumber, new FirmwareVariant(dBWatch.getVariant()));
    }

    private final void triggerPeriodicalTasks() {
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        if (Duration.m1672compareToLRDsOJo(instant.m1704minus5sfh64U(this.lastPeriodical), this.periodicalInterval) > 0) {
            this.lastPeriodical = instant;
            BuildersKt.launch$default(this.scope, null, null, new WatchManager$triggerPeriodicalTasks$1(this, null), 3);
        }
    }

    private final void update(MutableStateFlow<List<Watch>> mutableStateFlow, List<DBWatch> list) {
        Object obj;
        List<Watch> value = mutableStateFlow.getValue();
        List<DBWatch> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        for (final DBWatch dBWatch : list2) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((Watch) obj).getIdentifier(), dBWatch.getDevice_address())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Watch watch = (Watch) obj;
            if (watch == null) {
                LogKt.info$default((Object) mutableStateFlow, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$update$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Adding new watch: " + DBWatch.this.getDevice_address();
                    }
                }, 6, (Object) null);
                watch = toWatch(dBWatch);
            }
            arrayList.add(watch);
        }
        mutableStateFlow.setValue(arrayList);
    }

    public final Object addWatch(String str, DeviceType deviceType, FirmwareVariant firmwareVariant, Continuation<? super Unit> continuation) {
        this.watchDb.saveWatch(str, deviceType, firmwareVariant);
        List<Watch> watches = getWatches();
        boolean z = true;
        if (!(watches instanceof Collection) || !watches.isEmpty()) {
            Iterator<T> it = watches.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Watch) it.next()).getHasDisplay()) {
                    z = false;
                    break;
                }
            }
        }
        if (z && this.resourceSynchronizer.getAllAppPositions().isEmpty()) {
            ResourceSynchronizer resourceSynchronizer = this.resourceSynchronizer;
            List<AppId> defaultApps = AppId.Companion.getDefaultApps();
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(defaultApps, 10));
            Iterator<T> it2 = defaultApps.iterator();
            while (it2.hasNext()) {
                arrayList.add(new Integer(((AppId) it2.next()).getCode()));
            }
            resourceSynchronizer.updateAppPositions(arrayList);
        }
        update(this.watchesMutable, this.watchDb.getAllWatches());
        Object currentWatch = setCurrentWatch(getPreferredWatch(), continuation);
        if (currentWatch == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return currentWatch;
        }
        return Unit.INSTANCE;
    }

    public final void changeAddressOnCurrent(String newAddress) {
        Intrinsics.checkNotNullParameter(newAddress, "newAddress");
        this.watchDb.changeAddressOnCurrent$watch_release(newAddress);
        update(this.watchesMutable, this.watchDb.getAllWatches());
    }

    public final Object closeCurrentWatch(Continuation<? super Unit> continuation) {
        getCurrentWatch().onDisconnect();
        Watch preferredWatch = getPreferredWatch();
        if (Intrinsics.areEqual(getCurrentWatch(), preferredWatch)) {
            return Unit.INSTANCE;
        }
        this.deviceDataSync.setDirty();
        this.deviceDataSync.setAllDirty();
        this.deviceDataSync.setForceTimeWrite();
        Object currentWatch = setCurrentWatch(preferredWatch, continuation);
        if (currentWatch == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return currentWatch;
        }
        return Unit.INSTANCE;
    }

    public final WatchAlarmProvider getAlarmsProvider() {
        return this.alarmsProvider;
    }

    public final Behaviours getBehaviours() {
        return this.behaviours;
    }

    public final CSEMLogs getCsemLogs() {
        return (CSEMLogs) this.csemLogs$delegate.getValue();
    }

    public final Watch getCurrent$watch_release() {
        return getCurrentWatch();
    }

    public final Watch getCurrentWatch() {
        return this.currentWatchMutable.getValue();
    }

    public final CommonFlow<Watch> getCurrentWatchFlow() {
        return this.currentWatchFlow;
    }

    public final DemoModeProvider getDemoModeProvider() {
        return this.demoModeProvider;
    }

    public final DeviceDataSync getDeviceDataSync() {
        return this.deviceDataSync;
    }

    public final boolean getEnabledNewDataNotification() {
        return this.enabledNewDataNotification;
    }

    public final FilterSettings getFilterSettings() {
        return this.filterSettings;
    }

    public final FitnessProvider getFitnessProvider() {
        return this.fitnessProvider;
    }

    public final LocationProvider getLocationProvider() {
        return this.locationProvider;
    }

    public final Preferences getPreferences() {
        return this.preferences;
    }

    public final QuietHoursProvider getQuietHours() {
        return ServiceLocator.INSTANCE.getQuietHoursProvider();
    }

    public final StravaClient getStravaClient() {
        return this.stravaClient;
    }

    public final Watch getWatch(String identifier) {
        Object obj;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Iterator<T> it = getWatches().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Watch) obj).getIdentifier(), identifier)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Watch) obj;
    }

    public final List<Watch> getWatches() {
        return this.watchesMutable.getValue();
    }

    public final Flow<List<Watch>> getWatchesFlow() {
        return this.watchesFlow;
    }

    public final HistoricalWeatherProvider getWeatherProvider() {
        return this.weatherProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initWatch(com.animaconnected.watch.device.WatchBackend r18, kotlin.coroutines.Continuation<? super com.animaconnected.watch.Watch> r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager.initWatch(com.animaconnected.watch.device.WatchBackend, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final InternalFitnessProvider internal$watch_release(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "<this>");
        return (InternalFitnessProvider) fitnessProvider;
    }

    public final InternalFitnessProvider.InternalSessionProvider internalSessionProvider$watch_release(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "<this>");
        FitnessProvider.SessionProvider sessionProvider = fitnessProvider.getSessionProvider();
        Intrinsics.checkNotNull(sessionProvider, "null cannot be cast to non-null type com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider");
        return (InternalFitnessProvider.InternalSessionProvider) sessionProvider;
    }

    public final long knownWatchCount() {
        return this.watchDb.amountOfWatches();
    }

    public final void registerEventListener(WatchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.eventListeners.add(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeWatch(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.WatchManager$removeWatch$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.WatchManager$removeWatch$1 r0 = (com.animaconnected.watch.WatchManager$removeWatch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.WatchManager$removeWatch$1 r0 = new com.animaconnected.watch.WatchManager$removeWatch$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.WatchManager r0 = (com.animaconnected.watch.WatchManager) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L86
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.WatchManager r2 = (com.animaconnected.watch.WatchManager) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L76
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.storage.WatchDb r8 = r6.watchDb
            com.animaconnected.watch.storage.models.DBWatch r8 = r8.getCurrentWatch()
            if (r8 == 0) goto L57
            java.lang.String r8 = r8.getDevice_address()
            goto L58
        L57:
            r8 = r3
        L58:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r8 == 0) goto L70
            com.animaconnected.watch.storage.WatchDb r8 = r6.watchDb
            r8.removeCurrentDevice$watch_release()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.closeCurrentWatch(r0)
            if (r8 != r1) goto L75
            return r1
        L70:
            com.animaconnected.watch.storage.WatchDb r8 = r6.watchDb
            r8.removeDevice$watch_release(r7)
        L75:
            r2 = r6
        L76:
            com.animaconnected.watch.behaviour.Behaviours r8 = r2.behaviours
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.deactivateBehaviours(r0)
            if (r8 != r1) goto L85
            return r1
        L85:
            r0 = r2
        L86:
            kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.animaconnected.watch.Watch>> r8 = r0.watchesMutable
            com.animaconnected.watch.storage.WatchDb r1 = r0.watchDb
            java.util.List r1 = r1.getAllWatches()
            r0.update(r8, r1)
            com.animaconnected.watch.ServiceLocator r8 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.StorageFactory r8 = r8.getStorageFactory()
            com.animaconnected.watch.device.BasicStorage r8 = r8.createDeviceStorage(r7)
            r8.clear()
            com.animaconnected.watch.display.ResourceSynchronizer r8 = r0.resourceSynchronizer
            r8.setAllFilesUnSynced(r7)
            com.animaconnected.watch.provider.preferences.Preferences r8 = r0.preferences
            boolean r0 = r8 instanceof com.animaconnected.watch.provider.preferences.PreferenceProvider
            if (r0 == 0) goto Lac
            r3 = r8
            com.animaconnected.watch.provider.preferences.PreferenceProvider r3 = (com.animaconnected.watch.provider.preferences.PreferenceProvider) r3
        Lac:
            if (r3 == 0) goto Lb1
            r3.clearPreferencesForDevice$watch_release(r7)
        Lb1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager.removeWatch(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setBehaviours(final List<? extends Behaviour> behaviours) {
        Intrinsics.checkNotNullParameter(behaviours, "behaviours");
        this.behaviours.setAll(behaviours);
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$setBehaviours$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Behaviours set: ".concat(CollectionsKt___CollectionsKt.joinToString$default(behaviours, null, null, null, new Function1<Behaviour, CharSequence>() { // from class: com.animaconnected.watch.WatchManager$setBehaviours$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Behaviour it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getAnalyticsName();
                    }
                }, 31));
            }
        }, 7, (Object) null);
    }

    public final void setCurrentWatchFlow(CommonFlow<Watch> commonFlow) {
        Intrinsics.checkNotNullParameter(commonFlow, "<set-?>");
        this.currentWatchFlow = commonFlow;
    }

    public final void setDisplayColors(String backgroundColor, String foregroundColor, String highlightColor) {
        DisplayWatch displayWatch;
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(foregroundColor, "foregroundColor");
        Intrinsics.checkNotNullParameter(highlightColor, "highlightColor");
        Watch currentWatch = getCurrentWatch();
        if (currentWatch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) currentWatch;
        } else {
            displayWatch = null;
        }
        if (displayWatch == null) {
            return;
        }
        displayWatch.getStyle().setBackgroundColor(backgroundColor);
        displayWatch.getStyle().setForegroundColor(foregroundColor);
        displayWatch.getStyle().setHighlightColor(highlightColor);
        BuildersKt.launch$default(this.scope, null, null, new WatchManager$setDisplayColors$2(this, null), 3);
    }

    public final void setEnabledNewDataNotification(boolean z) {
        this.enabledNewDataNotification = z;
    }

    public final Object setPreferredWatch(String str, Continuation<? super Unit> continuation) {
        this.deviceDataSync.setForceTimeWrite();
        this.watchDb.setCurrent(str);
        Object currentWatch = setCurrentWatch(getPreferredWatch(), continuation);
        if (currentWatch == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return currentWatch;
        }
        return Unit.INSTANCE;
    }

    public final void setWatchesFlow(Flow<? extends List<? extends Watch>> flow) {
        Intrinsics.checkNotNullParameter(flow, "<set-?>");
        this.watchesFlow = flow;
    }

    public final Object sync(Continuation<? super Boolean> continuation) {
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$sync$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "sync";
            }
        }, 6, (Object) null);
        Deferred<Boolean> deferred = this.currentSync;
        if (deferred != null) {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$sync$3$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "sync already in progress. Will request re-sync when finished";
                }
            }, 6, (Object) null);
            this.deviceDataSync.setDirty();
            return deferred.await(continuation);
        }
        DeferredCoroutine async$default = BuildersKt.async$default(getCurrentWatch().getScope(), DispatchersCommon.watchDispatcher(), new WatchManager$sync$sync$1(this, 10, null), 2);
        this.currentSync = async$default;
        async$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.animaconnected.watch.WatchManager$sync$sync$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                WatchManager.this.currentSync = null;
            }
        });
        triggerPeriodicalTasks();
        return async$default.await(continuation);
    }

    public final void unregisterEventListener(WatchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.eventListeners.remove(listener);
    }

    public final void updateStringBackend(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "stringsBackend");
        ServiceLocator.INSTANCE.updateStringBackend(stringsBackend);
    }

    private final List<Watch> toWatch(List<DBWatch> list) {
        List<DBWatch> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toWatch((DBWatch) it.next()));
        }
        return arrayList;
    }

    private final void setCurrentWatch(Watch watch) {
        this.currentWatchMutable.setValue(watch);
    }

    public static /* synthetic */ void getWatchesFlow$annotations() {
    }

    public /* synthetic */ WatchManager(WatchDatabase watchDatabase, String str, StravaAuth stravaAuth, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(watchDatabase, str, stravaAuth, (r5 & 8) != 0 ? false : z);
    }
}
