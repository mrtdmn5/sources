package com.animaconnected.watch;

import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.firebase.WatchEvents;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.Complication;
import com.animaconnected.watch.behaviour.types.Empty;
import com.animaconnected.watch.behaviour.util.HoursMinutesFwdAdjust24;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.CommandCenter;
import com.animaconnected.watch.device.CrashStatus;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.DfuStatus;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchIODebug;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: Watch.kt */
/* loaded from: classes3.dex */
public abstract class Watch {
    private final MutableStateFlow<WatchState> _state;
    private final AppEvents appEvents;
    private Behaviours behaviours;
    private Capabilities capabilities;
    private final CommandCenter commandCenter;
    private int connectionInterval;
    private Job crashHandlerJob;
    private final String crashTag;
    private final long dailyInterval;
    private final DeviceDataSync deviceDataSync;
    private Map<DeviceInfo, String> deviceInfo;
    private String deviceName;
    private final long dfuStatusValid;
    private final FirmwareVariant firmwareVariant;
    private final FitnessQueries fitnessDB;
    private FitnessSyncWatch fitnessSync;
    private final boolean hasDisplay;
    private final String historyDeviceId;
    private final String identifier;

    /* renamed from: io */
    private WatchIO f136io;
    private LastDfuStatus lastDfuStatus;
    private Instant lastTimeSync;
    private final int maxCrashHandlingAttempts;
    private final MsgPackCreator msgPackCreator;
    private final QuietHoursProvider quietHours;
    private final long refreshAllSettingsInterval;
    private final long refreshWatchTimeInterval;
    private final ResourceSynchronizer resourceSynchronizer;
    private CoroutineScope scope;
    private String sku;
    private final StateFlow<WatchState> state;
    private BasicStorage storage;
    private final Function1<Continuation<? super Unit>, Object> syncSuspend;
    private final String tag;
    private final WatchDb watchDb;
    private final WatchEvents watchEvents;
    private final DeviceType watchType;

    /* compiled from: Watch.kt */
    @DebugMetadata(c = "com.animaconnected.watch.Watch$1", f = "Watch.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.Watch$1 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<WatchState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        /* compiled from: Watch.kt */
        /* renamed from: com.animaconnected.watch.Watch$1$1 */
        /* loaded from: classes3.dex */
        public static final class C00731 extends Lambda implements Function0<String> {
            final /* synthetic */ WatchState $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00731(WatchState watchState) {
                super(0);
                r2 = watchState;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Watch " + Watch.this.getIdentifier() + " in state: " + r2;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WatchState watchState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(watchState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WatchState watchState = (WatchState) this.L$0;
                Watch watch = Watch.this;
                LogKt.verbose$default((Object) watch, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.Watch.1.1
                    final /* synthetic */ WatchState $it;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00731(WatchState watchState2) {
                        super(0);
                        r2 = watchState2;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Watch " + Watch.this.getIdentifier() + " in state: " + r2;
                    }
                }, 7, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Watch.kt */
    @DebugMetadata(c = "com.animaconnected.watch.Watch$2", f = "Watch.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.Watch$2 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super WatchState>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: Watch.kt */
        /* renamed from: com.animaconnected.watch.Watch$2$1 */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements Function0<String> {
            public static final AnonymousClass1 INSTANCE = ;

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Watch state logging over";
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogKt.verbose$default(this.L$0, (String) null, (Throwable) null, false, (Function0) AnonymousClass1.INSTANCE, 7, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super WatchState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = flowCollector;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: Watch.kt */
    /* loaded from: classes3.dex */
    public static final class LastDfuStatus {
        private final DfuStatus status;
        private final Instant time;

        public LastDfuStatus(Instant time, DfuStatus status) {
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(status, "status");
            this.time = time;
            this.status = status;
        }

        public final DfuStatus getStatus() {
            return this.status;
        }

        public final Instant getTime() {
            return this.time;
        }
    }

    /* compiled from: Watch.kt */
    /* loaded from: classes3.dex */
    public static final class WatchState extends Enum<WatchState> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WatchState[] $VALUES;
        public static final WatchState Ready = new WatchState("Ready", 0);
        public static final WatchState Syncing = new WatchState("Syncing", 1);
        public static final WatchState Initialized = new WatchState("Initialized", 2);
        public static final WatchState UpdateRequired = new WatchState("UpdateRequired", 3);
        public static final WatchState Initializing = new WatchState("Initializing", 4);
        public static final WatchState Disconnected = new WatchState("Disconnected", 5);
        public static final WatchState Inactive = new WatchState("Inactive", 6);

        private static final /* synthetic */ WatchState[] $values() {
            return new WatchState[]{Ready, Syncing, Initialized, UpdateRequired, Initializing, Disconnected, Inactive};
        }

        static {
            WatchState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private WatchState(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<WatchState> getEntries() {
            return $ENTRIES;
        }

        public static WatchState valueOf(String str) {
            return (WatchState) Enum.valueOf(WatchState.class, str);
        }

        public static WatchState[] values() {
            return (WatchState[]) $VALUES.clone();
        }
    }

    public /* synthetic */ Watch(BasicStorage basicStorage, String str, String str2, DeviceType deviceType, FirmwareVariant firmwareVariant, FitnessQueries fitnessQueries, MsgPackCreator msgPackCreator, ResourceSynchronizer resourceSynchronizer, WatchDb watchDb, DeviceDataSync deviceDataSync, Function1 function1, Behaviours behaviours, DefaultConstructorMarker defaultConstructorMarker) {
        this(basicStorage, str, str2, deviceType, firmwareVariant, fitnessQueries, msgPackCreator, resourceSynchronizer, watchDb, deviceDataSync, function1, behaviours);
    }

    private final HoursMinutesFwdAdjust24 calculateTimeZoneDiff(String str) {
        TimeZone.Companion.getClass();
        TimeZone of = TimeZone.Companion.of(str);
        Instant.Companion.getClass();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")), TimeZone.Companion.currentSystemDefault());
        return HoursMinutesFwdAdjust24.Companion.fromTo(localDateTime, TimeZoneKt.toLocalDateTime(TimeZoneKt.toInstant(localDateTime, TimeZone.Companion.currentSystemDefault()), of));
    }

    public final Object configureDebugSettings(Continuation<? super Unit> continuation) {
        WatchIO watchIO = this.f136io;
        if (watchIO == null) {
            return Unit.INSTANCE;
        }
        if (this.deviceDataSync.isDebugConfigDirty()) {
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.Watch$configureDebugSettings$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "sync debugConfig";
                }
            }, 6, (Object) null);
            Object writeDebugConfig = watchIO.writeDebugConfig(false, false, this.deviceDataSync.getDeviceDisconnectLedAndVibrateEnable(), true, 60, this.deviceDataSync.getRssiNotification(), continuation);
            if (writeDebugConfig == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeDebugConfig;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object doCommonSync(kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.doCommonSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object doPostSync$suspendImpl(Watch watch, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchCrashStatus(java.lang.Integer r12, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.CrashStatus> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.Watch$fetchCrashStatus$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.Watch$fetchCrashStatus$1 r0 = (com.animaconnected.watch.Watch$fetchCrashStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$fetchCrashStatus$1 r0 = new com.animaconnected.watch.Watch$fetchCrashStatus$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r12 = r0.L$2
            com.animaconnected.watch.storage.RemoteCrashStorage r12 = (com.animaconnected.watch.storage.RemoteCrashStorage) r12
            java.lang.Object r1 = r0.L$1
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.Watch r0 = (com.animaconnected.watch.Watch) r0
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r12
            r4 = r0
            r12 = r1
            goto L5c
        L36:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3e:
            kotlin.ResultKt.throwOnFailure(r13)
            com.animaconnected.watch.device.WatchIO r13 = r11.f136io
            com.animaconnected.watch.storage.RemoteCrashStorage r2 = new com.animaconnected.watch.storage.RemoteCrashStorage
            com.animaconnected.watch.device.BasicStorage r4 = r11.storage
            r2.<init>(r4)
            if (r13 == 0) goto Lcb
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r13 = r13.readCrashStatus(r0)
            if (r13 != r1) goto L5b
            return r1
        L5b:
            r4 = r11
        L5c:
            kotlin.Pair r13 = (kotlin.Pair) r13
            A r0 = r13.first
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            B r13 = r13.second
            r8 = r13
            com.animaconnected.watch.device.CrashInfo r8 = (com.animaconnected.watch.device.CrashInfo) r8
            boolean r13 = r8.isValid()
            if (r13 == 0) goto Lbb
            if (r12 == 0) goto Lbb
            com.animaconnected.watch.ServiceLocator r13 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.StringsBackend r13 = r13.getStringsBackend()
            com.animaconnected.watch.device.DateFormatter r13 = com.animaconnected.watch.provider.DateTimeFormattersKt.getIsoOffsetDateTime(r13)
            kotlinx.datetime.Instant r0 = com.animaconnected.info.DateTimeUtilsKt.now()
            kotlinx.datetime.TimeZone$Companion r1 = kotlinx.datetime.TimeZone.Companion
            r1.getClass()
            kotlinx.datetime.FixedOffsetTimeZone r1 = kotlinx.datetime.TimeZone.UTC
            java.lang.String r13 = com.animaconnected.watch.device.StringsBackendKt.format(r13, r0, r1, r3)
            com.animaconnected.watch.device.CrashStatus r0 = new com.animaconnected.watch.device.CrashStatus
            int r7 = r12.intValue()
            boolean r9 = r2.isRemotelyCrashed()
            r5 = r0
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            com.animaconnected.watch.device.CrashFile r12 = new com.animaconnected.watch.device.CrashFile
            java.util.Map<com.animaconnected.watch.device.DeviceInfo, java.lang.String> r1 = r4.deviceInfo
            if (r1 == 0) goto La8
            com.animaconnected.watch.device.DeviceInfo r5 = com.animaconnected.watch.device.DeviceInfo.SerialNumber
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto Laa
        La8:
            java.lang.String r1 = "unknown"
        Laa:
            r12.<init>(r1, r13)
            java.lang.String r12 = r12.getS3UploadUrl()
            r4.sendCrashAnalytics(r0, r12)
            r2.setCrashStatus(r0)
            r2.setHandleAttempts(r3)
            goto Lcf
        Lbb:
            java.lang.String r5 = r4.crashTag
            r6 = 0
            r7 = 0
            com.animaconnected.watch.Watch$fetchCrashStatus$2 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.Watch$fetchCrashStatus$2
                static {
                    /*
                        com.animaconnected.watch.Watch$fetchCrashStatus$2 r0 = new com.animaconnected.watch.Watch$fetchCrashStatus$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.Watch$fetchCrashStatus$2) com.animaconnected.watch.Watch$fetchCrashStatus$2.INSTANCE com.animaconnected.watch.Watch$fetchCrashStatus$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$fetchCrashStatus$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$fetchCrashStatus$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "No crash info stored on watch, using cached value"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$fetchCrashStatus$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$fetchCrashStatus$2.invoke():java.lang.Object");
                }
            }
            r9 = 6
            r10 = 0
            com.animaconnected.logger.LogKt.verbose$default(r4, r5, r6, r7, r8, r9, r10)
            com.animaconnected.watch.device.CrashStatus r0 = r2.getCrashStatus()
            goto Lcf
        Lcb:
            com.animaconnected.watch.device.CrashStatus r0 = r2.getCrashStatus()
        Lcf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.fetchCrashStatus(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Capabilities getCachedCapabilities() {
        if (!this.commandCenter.hasCapabilities()) {
            return Capabilities.Companion.createForLegacyDevices(this.watchType, this.commandCenter.hasCompBtnAndCompDef(), this.commandCenter.hasRecalibrateHand());
        }
        if (this.storage.contains(Command.CAPABILITIES)) {
            return Capabilities.Companion.createFromBytes(this.watchType, this.storage.getBytes(Command.CAPABILITIES), this.commandCenter.hasCompBtnAndCompDef(), this.commandCenter.hasRecalibrateHand(), this.msgPackCreator);
        }
        return Capabilities.Companion.createDefault();
    }

    private final String getTimeZoneId() {
        return this.deviceDataSync.getTimeZoneId();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object packageAndUploadCrash(com.animaconnected.watch.device.CrashStatus r19, byte[] r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.packageAndUploadCrash(com.animaconnected.watch.device.CrashStatus, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void sendCrashAnalytics(CrashStatus crashStatus, String str) {
        String str2;
        Integer num;
        String str3;
        String str4;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        String str5;
        WatchEvents watchEvents = this.watchEvents;
        String type = crashStatus.getType();
        int hw_reason = crashStatus.getHw_reason();
        Boolean valueOf = Boolean.valueOf(crashStatus.getRemoteCrash());
        CrashStatus.AppInfo appInfo = crashStatus.getAppInfo();
        Integer num9 = null;
        if (appInfo != null) {
            str2 = appInfo.getFilename();
        } else {
            str2 = null;
        }
        CrashStatus.AppInfo appInfo2 = crashStatus.getAppInfo();
        if (appInfo2 != null) {
            num = Integer.valueOf(appInfo2.getLineNumber());
        } else {
            num = null;
        }
        CrashStatus.AppInfo appInfo3 = crashStatus.getAppInfo();
        if (appInfo3 != null) {
            str3 = appInfo3.getErrorCodeString();
        } else {
            str3 = null;
        }
        CrashStatus.Registers registers = crashStatus.getRegisters();
        if (registers != null) {
            str4 = registers.getSPString();
        } else {
            str4 = null;
        }
        CrashStatus.Registers registers2 = crashStatus.getRegisters();
        if (registers2 != null) {
            num2 = Integer.valueOf(registers2.getLr());
        } else {
            num2 = null;
        }
        CrashStatus.Registers registers3 = crashStatus.getRegisters();
        if (registers3 != null) {
            num3 = Integer.valueOf(registers3.getPc());
        } else {
            num3 = null;
        }
        CrashStatus.Registers registers4 = crashStatus.getRegisters();
        if (registers4 != null) {
            num4 = Integer.valueOf(registers4.getR0());
        } else {
            num4 = null;
        }
        CrashStatus.Registers registers5 = crashStatus.getRegisters();
        if (registers5 != null) {
            num5 = Integer.valueOf(registers5.getR1());
        } else {
            num5 = null;
        }
        CrashStatus.Registers registers6 = crashStatus.getRegisters();
        if (registers6 != null) {
            num6 = Integer.valueOf(registers6.getR2());
        } else {
            num6 = null;
        }
        CrashStatus.Registers registers7 = crashStatus.getRegisters();
        if (registers7 != null) {
            num7 = Integer.valueOf(registers7.getR3());
        } else {
            num7 = null;
        }
        CrashStatus.Registers registers8 = crashStatus.getRegisters();
        if (registers8 != null) {
            num8 = Integer.valueOf(registers8.getPsr());
        } else {
            num8 = null;
        }
        CrashStatus.Registers registers9 = crashStatus.getRegisters();
        if (registers9 != null) {
            num9 = Integer.valueOf(registers9.getR12());
        }
        Integer num10 = num9;
        if (ServiceLocator.INSTANCE.getAccountBackend().isSandbox()) {
            str5 = "sandbox";
        } else {
            str5 = "prod";
        }
        watchEvents.deviceCrash(type, hw_reason, valueOf, str2, num, str3, str4, num2, num3, num4, num5, num6, num7, num8, num10, str, str5);
    }

    private final void setTimeZoneId(String str) {
        this.deviceDataSync.setTimeZoneId(str);
        reSync$watch_release();
    }

    public static /* synthetic */ Object sync$watch_release$default(Watch watch, boolean z, Continuation continuation, int r3, Object obj) {
        if (obj == null) {
            if ((r3 & 1) != 0) {
                z = false;
            }
            return watch.sync$watch_release(z, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sync");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(2:3|(16:5|6|7|(1:(1:(1:(7:12|13|14|15|16|17|18)(2:24|25))(5:26|27|28|29|(1:31)(4:32|16|17|18)))(1:39))(4:79|(2:82|(1:84)(1:85))|17|18)|40|(1:78)(1:44)|45|(1:47)|48|(2:50|(1:52)(1:76))(1:77)|(1:75)(1:56)|57|(3:59|(1:61)(1:63)|62)|(4:66|67|68|(1:70)(3:71|29|(0)(0)))|17|18))|7|(0)(0)|40|(1:42)|78|45|(0)|48|(0)(0)|(0)|75|57|(0)|(0)|66|67|68|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bc, code lost:            r4 = r8;     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ba, code lost:            r0 = th;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.animaconnected.watch.device.WatchIO] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, com.animaconnected.watch.device.WatchIO] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.coroutines.Continuation, com.animaconnected.watch.Watch$syncTime$1] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.animaconnected.watch.Watch] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.lang.Object, com.animaconnected.watch.Watch] */
    /* JADX WARN: Type inference failed for: r6v32, types: [com.animaconnected.watch.Watch] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncTime(com.animaconnected.watch.device.WatchIO r21, kotlinx.datetime.Instant r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.syncTime(com.animaconnected.watch.device.WatchIO, kotlinx.datetime.Instant, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncVibratorConfig(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.Watch$syncVibratorConfig$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.Watch$syncVibratorConfig$1 r0 = (com.animaconnected.watch.Watch$syncVibratorConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$syncVibratorConfig$1 r0 = new com.animaconnected.watch.Watch$syncVibratorConfig$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            java.lang.String r3 = "vibrator_config"
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.Watch r0 = (com.animaconnected.watch.Watch) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2f
            goto L98
        L2f:
            r12 = move-exception
        L30:
            r3 = r12
            goto Laf
        L33:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3b:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.device.WatchIO r12 = r11.f136io
            if (r12 != 0) goto L45
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L45:
            boolean r2 = r11.getStrongVibrationEnabled()
            if (r2 == 0) goto L4e
            com.animaconnected.watch.behaviour.util.Strength r2 = com.animaconnected.watch.behaviour.util.Strength.Stronger
            goto L50
        L4e:
            com.animaconnected.watch.behaviour.util.Strength r2 = com.animaconnected.watch.behaviour.util.Strength.Normal
        L50:
            r5 = 3
            int[][] r6 = new int[r5]
            com.animaconnected.watch.behaviour.util.VibratorPatterns r7 = com.animaconnected.watch.behaviour.util.VibratorPatterns.INSTANCE
            com.animaconnected.watch.behaviour.util.Vibration r8 = com.animaconnected.watch.behaviour.util.Vibration.One
            com.animaconnected.info.DeviceType r9 = r11.watchType
            int[] r8 = r7.get(r8, r2, r9)
            r9 = 0
            r6[r9] = r8
            com.animaconnected.watch.behaviour.util.Vibration r8 = com.animaconnected.watch.behaviour.util.Vibration.Two
            com.animaconnected.info.DeviceType r9 = r11.watchType
            int[] r8 = r7.get(r8, r2, r9)
            r6[r4] = r8
            com.animaconnected.watch.behaviour.util.Vibration r8 = com.animaconnected.watch.behaviour.util.Vibration.Three
            com.animaconnected.info.DeviceType r9 = r11.watchType
            int[] r2 = r7.get(r8, r2, r9)
            r7 = 2
            r6[r7] = r2
            int r2 = java.util.Arrays.deepHashCode(r6)
            com.animaconnected.watch.display.ResourceSynchronizer r7 = r11.resourceSynchronizer
            java.lang.String r8 = r11.identifier
            boolean r7 = r7.isConfigSynced(r8, r3, r2)
            if (r7 != 0) goto Lb9
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r5)     // Catch: java.lang.Exception -> Lac
            int[][] r5 = (int[][]) r5     // Catch: java.lang.Exception -> Lac
            r0.L$0 = r11     // Catch: java.lang.Exception -> Lac
            r0.I$0 = r2     // Catch: java.lang.Exception -> Lac
            r0.label = r4     // Catch: java.lang.Exception -> Lac
            java.lang.Object r12 = r12.writeConfigVibrator(r5, r0)     // Catch: java.lang.Exception -> Lac
            if (r12 != r1) goto L96
            return r1
        L96:
            r0 = r11
            r1 = r2
        L98:
            com.animaconnected.watch.display.ResourceSynchronizer r12 = r0.resourceSynchronizer     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = r0.identifier     // Catch: java.lang.Exception -> L2f
            r12.setConfigSynced(r2, r3, r1)     // Catch: java.lang.Exception -> L2f
            java.lang.String r5 = "Synced vibrator config to watch"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r0
            com.animaconnected.logger.LogKt.verbose$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L2f
            goto Lb9
        Lac:
            r12 = move-exception
            r0 = r11
            goto L30
        Laf:
            java.lang.String r1 = "Failed to vibrator config"
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
        Lb9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.syncVibratorConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object alert(int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.Watch$alert$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.Watch$alert$1 r0 = (com.animaconnected.watch.Watch$alert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$alert$1 r0 = new com.animaconnected.watch.Watch$alert$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r8 = r0.L$0
            com.animaconnected.watch.Watch r8 = (com.animaconnected.watch.Watch) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L2b
            goto L59
        L2b:
            r9 = move-exception
            r0 = r8
        L2d:
            r3 = r9
            goto L4f
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.device.WatchIO r9 = r7.f136io
            if (r9 != 0) goto L41
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L41:
            r0.L$0 = r7     // Catch: java.lang.Exception -> L4c
            r0.label = r3     // Catch: java.lang.Exception -> L4c
            java.lang.Object r8 = r9.writeAlert(r8, r0)     // Catch: java.lang.Exception -> L4c
            if (r8 != r1) goto L59
            return r1
        L4c:
            r9 = move-exception
            r0 = r7
            goto L2d
        L4f:
            java.lang.String r1 = "Failed to write alert"
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L59:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.alert(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clear() {
        this.commandCenter.clear$watch_release();
        this.storage.clear();
        resetConfigs();
    }

    public final void clearVariableStorage() {
        this.resourceSynchronizer.clearDatabases();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object dfuReady(kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.DfuStatus> r13) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.dfuReady(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object doConnect(WatchIO watchIO, Continuation<? super Unit> continuation);

    public abstract void doDisconnect();

    public Object doPostSync(Continuation<? super Unit> continuation) {
        return doPostSync$suspendImpl(this, continuation);
    }

    public abstract Object doSync(boolean z, Continuation<? super Unit> continuation);

    public final Behaviours getBehaviours$watch_release() {
        return this.behaviours;
    }

    public final Capabilities getCapabilities() {
        return this.capabilities;
    }

    public final CommandCenter getCommandCenter() {
        return this.commandCenter;
    }

    public final int getConnectionInterval() {
        return this.connectionInterval;
    }

    public final WatchIODebug getDebugIo() {
        return (WatchIODebug) this.f136io;
    }

    public final int getDeviceComplicationMode(Slot slot, Behaviour behaviour) {
        Complication complication;
        int r0;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        if (behaviour instanceof Complication) {
            complication = (Complication) behaviour;
        } else {
            complication = null;
        }
        if (complication != null) {
            r0 = complication.getDeviceComplicationMode();
        } else {
            r0 = 15;
        }
        if (Intrinsics.areEqual(behaviour.getType(), Empty.INSTANCE.getTYPE())) {
            if (!this.commandCenter.hasCompBtnAndCompDef() || (slot != Slot.MainComplication && slot != Slot.MainComplicationDouble)) {
                return 6;
            }
            return r0;
        }
        return r0;
    }

    public final DeviceDataSync getDeviceDataSync() {
        return this.deviceDataSync;
    }

    public final Map<DeviceInfo, String> getDeviceInfo() {
        return this.deviceInfo;
    }

    public final String getDeviceName() {
        WatchIO watchIO = this.f136io;
        if (watchIO != null) {
            return watchIO.getDeviceName();
        }
        return null;
    }

    public final String getFirmwareRevision() {
        return this.storage.getString(AnalyticsConstants.KEY_FIRMWAREREVISION);
    }

    public final FirmwareVariant getFirmwareVariant() {
        return this.firmwareVariant;
    }

    public final FitnessSyncWatch getFitnessSync$watch_release() {
        return this.fitnessSync;
    }

    public final boolean getHasDisplay() {
        return this.hasDisplay;
    }

    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public final String m1046getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final WatchIO getIo() {
        return this.f136io;
    }

    public final MsgPackCreator getMsgPackCreator$watch_release() {
        return this.msgPackCreator;
    }

    public final ResourceSynchronizer getResourceSynchronizer$watch_release() {
        return this.resourceSynchronizer;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final String getSku() {
        return this.sku;
    }

    public final StateFlow<WatchState> getState() {
        return this.state;
    }

    public final BasicStorage getStorage$watch_release() {
        return this.storage;
    }

    public final boolean getStrongVibrationEnabled() {
        DBWatch watch = this.watchDb.getWatch(this.identifier);
        if (watch != null) {
            return watch.getStronger_vibration();
        }
        return false;
    }

    public final Function1<Continuation<? super Unit>, Object> getSyncSuspend() {
        return this.syncSuspend;
    }

    public final String getTag$watch_release() {
        return this.tag;
    }

    public final WatchDb getWatchDb() {
        return this.watchDb;
    }

    public final DeviceType getWatchType() {
        return this.watchType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:            if (r5.isActive() == true) goto L21;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleCrash$watch_release(java.lang.Integer r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r3 = this;
            kotlinx.coroutines.Job r5 = r3.crashHandlerJob
            if (r5 == 0) goto Lc
            boolean r5 = r5.isActive()
            r0 = 1
            if (r5 != r0) goto Lc
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L12
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L12:
            kotlinx.coroutines.CoroutineScope r5 = r3.scope
            kotlinx.coroutines.scheduling.DefaultScheduler r0 = kotlinx.coroutines.Dispatchers.Default
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
            com.animaconnected.watch.Watch$handleCrash$2 r1 = new com.animaconnected.watch.Watch$handleCrash$2
            r2 = 0
            r1.<init>(r3, r4, r2)
            r4 = 2
            kotlinx.coroutines.StandaloneCoroutine r4 = kotlinx.coroutines.BuildersKt.launch$default(r5, r0, r2, r1, r4)
            r3.crashHandlerJob = r4
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.handleCrash$watch_release(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initConfigs(com.animaconnected.watch.device.WatchIO r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.Watch$initConfigs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.Watch$initConfigs$1 r0 = (com.animaconnected.watch.Watch$initConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$initConfigs$1 r0 = new com.animaconnected.watch.Watch$initConfigs$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.Watch r5 = (com.animaconnected.watch.Watch) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L42
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r5.readOnboardingDone(r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            r5 = r4
        L42:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L4d
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4d:
            com.animaconnected.watch.DeviceDataSync r6 = r5.deviceDataSync
            r6.setForceTimeWrite()
            com.animaconnected.watch.DeviceDataSync r6 = r5.deviceDataSync
            boolean r0 = r6.isOnboardingFinished()
            r6.setOnboardingFinished(r0)
            com.animaconnected.watch.DeviceDataSync r6 = r5.deviceDataSync
            r6.setAllDirty()
            r5.resetConfigs()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.initConfigs(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object isFirmwareSupported(WatchIO watchIO, Continuation<? super Boolean> continuation);

    public final boolean isOnboardingFinished() {
        return this.deviceDataSync.isOnboardingFinished();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onConnect$watch_release(com.animaconnected.watch.device.WatchIO r19, com.animaconnected.watch.device.WatchBackend r20, com.animaconnected.watch.device.DeviceEventHandler r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.onConnect$watch_release(com.animaconnected.watch.device.WatchIO, com.animaconnected.watch.device.WatchBackend, com.animaconnected.watch.device.DeviceEventHandler, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onDisconnect() {
        CoroutineScopeKt.cancel(this.scope, new CancellationException("onDisconnect"));
        this.f136io = null;
        this.fitnessSync = null;
        doDisconnect();
        this.behaviours.notifyDisconnected(this);
        this.scope = CoroutineScopeKt.CoroutineScope(DispatchersKt.ioDispatcher().plus(new JobImpl(JobKt.getJob(ServiceLocator.INSTANCE.getScope().getCoroutineContext()))));
        this._state.setValue(WatchState.Disconnected);
    }

    public final void reSync$watch_release() {
        BuildersKt.launch$default(this.scope, null, null, new Watch$reSync$1(this, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readCapabilities(com.animaconnected.watch.device.WatchIO r11, kotlin.coroutines.Continuation<? super com.animaconnected.watch.device.Capabilities> r12) throws java.lang.Exception {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.Watch$readCapabilities$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.Watch$readCapabilities$1 r0 = (com.animaconnected.watch.Watch$readCapabilities$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$readCapabilities$1 r0 = new com.animaconnected.watch.Watch$readCapabilities$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            java.lang.String r3 = "cap"
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            java.lang.Object r11 = r0.L$0
            com.animaconnected.watch.Watch r11 = (com.animaconnected.watch.Watch) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L59
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.device.CommandCenter r12 = r10.commandCenter
            boolean r12 = r12.hasCapabilities()
            if (r12 == 0) goto L7b
            com.animaconnected.watch.device.BasicStorage r12 = r10.storage
            boolean r12 = r12.contains(r3)
            if (r12 != 0) goto L7b
            com.animaconnected.watch.device.WatchIO r12 = r10.f136io
            if (r12 != 0) goto L4d
            goto L7b
        L4d:
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r12 = r11.readCapabilities(r0)
            if (r12 != r1) goto L58
            return r1
        L58:
            r11 = r10
        L59:
            com.animaconnected.msgpack.MsgPack r12 = (com.animaconnected.msgpack.MsgPack) r12
            byte[] r6 = r12.toMsgPackBytes()
            com.animaconnected.watch.device.BasicStorage r12 = r11.storage
            r12.put(r3, r6)
            com.animaconnected.watch.device.Capabilities$Companion r4 = com.animaconnected.watch.device.Capabilities.Companion
            com.animaconnected.info.DeviceType r5 = r11.watchType
            com.animaconnected.watch.device.CommandCenter r12 = r11.commandCenter
            boolean r7 = r12.hasCompBtnAndCompDef()
            com.animaconnected.watch.device.CommandCenter r12 = r11.commandCenter
            boolean r8 = r12.hasRecalibrateHand()
            com.animaconnected.msgpack.MsgPackCreator r9 = r11.msgPackCreator
            com.animaconnected.watch.device.Capabilities r11 = r4.createFromBytes(r5, r6, r7, r8, r9)
            goto L7f
        L7b:
            com.animaconnected.watch.device.Capabilities r11 = r10.getCachedCapabilities()
        L7f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.readCapabilities(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract void resetConfigs();

    public final void setBehaviours$watch_release(Behaviours behaviours) {
        Intrinsics.checkNotNullParameter(behaviours, "<set-?>");
        this.behaviours = behaviours;
    }

    public final void setCapabilities(Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(capabilities, "<set-?>");
        this.capabilities = capabilities;
    }

    public final void setConnectionInterval$watch_release(int r1) {
        this.connectionInterval = r1;
    }

    public final void setDeviceInfo(Map<DeviceInfo, String> map) {
        this.deviceInfo = map;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final void setFirmwareRevision(String str) {
        this.storage.put(AnalyticsConstants.KEY_FIRMWAREREVISION, str);
    }

    public final void setFitnessSync$watch_release(FitnessSyncWatch fitnessSyncWatch) {
        this.fitnessSync = fitnessSyncWatch;
    }

    public final void setSku(String str) {
        this.sku = str;
    }

    public final void setStorage$watch_release(BasicStorage basicStorage) {
        Intrinsics.checkNotNullParameter(basicStorage, "<set-?>");
        this.storage = basicStorage;
    }

    public final void setStrongVibrationEnabled(boolean z) {
        String str;
        this.watchDb.updateStrongerVibration(z, this.identifier);
        this.deviceDataSync.setDirty();
        AppEvents appEvents = this.appEvents;
        if (z) {
            str = "enabled";
        } else {
            str = "disabled";
        }
        appEvents.sendStrongVibrationToggle(str);
        reSync$watch_release();
    }

    public final Object sync$watch_release(boolean z, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(DispatchersCommon.watchDispatcher(), new Watch$sync$2(this, z, null), continuation);
    }

    public String toString() {
        return "Watch(identifier='" + this.identifier + "', sku=" + this.sku + ", watchType=" + this.watchType + ", firmwareVariant=" + this.firmwareVariant + ", firmwareRevision=" + getFirmwareRevision() + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeHardfault(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.Watch$writeHardfault$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.Watch$writeHardfault$1 r0 = (com.animaconnected.watch.Watch$writeHardfault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.Watch$writeHardfault$1 r0 = new com.animaconnected.watch.Watch$writeHardfault$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            boolean r8 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.Watch r0 = (com.animaconnected.watch.Watch) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L2d
            goto L50
        L2d:
            r8 = move-exception
        L2e:
            r3 = r8
            goto L62
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            com.animaconnected.watch.device.WatchIO r9 = r7.f136io
            if (r9 != 0) goto L42
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L42:
            r0.L$0 = r7     // Catch: java.lang.Exception -> L5f
            r0.Z$0 = r8     // Catch: java.lang.Exception -> L5f
            r0.label = r3     // Catch: java.lang.Exception -> L5f
            java.lang.Object r9 = r9.writeDebugHardFault(r0)     // Catch: java.lang.Exception -> L5f
            if (r9 != r1) goto L4f
            return r1
        L4f:
            r0 = r7
        L50:
            com.animaconnected.watch.storage.RemoteCrashStorage r9 = new com.animaconnected.watch.storage.RemoteCrashStorage     // Catch: java.lang.Exception -> L2d
            com.animaconnected.watch.device.BasicStorage r1 = r0.storage     // Catch: java.lang.Exception -> L2d
            r9.<init>(r1)     // Catch: java.lang.Exception -> L2d
            if (r8 == 0) goto L5a
            goto L5b
        L5a:
            r3 = 0
        L5b:
            r9.setRemotelyCrashed(r3)     // Catch: java.lang.Exception -> L2d
            goto L6c
        L5f:
            r8 = move-exception
            r0 = r7
            goto L2e
        L62:
            java.lang.String r1 = "Failed to write debug hard fault"
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L6c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.writeHardfault(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b2 -> B:17:0x00b6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeTimeZoneIfActive$watch_release(com.animaconnected.watch.device.WatchIO r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch.writeTimeZoneIfActive$watch_release(com.animaconnected.watch.device.WatchIO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Watch(BasicStorage basicStorage, String str, String str2, DeviceType deviceType, FirmwareVariant firmwareVariant, FitnessQueries fitnessQueries, MsgPackCreator msgPackCreator, ResourceSynchronizer resourceSynchronizer, WatchDb watchDb, DeviceDataSync deviceDataSync, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Behaviours behaviours) {
        this.storage = basicStorage;
        this.identifier = str;
        this.sku = str2;
        this.watchType = deviceType;
        this.firmwareVariant = firmwareVariant;
        this.fitnessDB = fitnessQueries;
        this.msgPackCreator = msgPackCreator;
        this.resourceSynchronizer = resourceSynchronizer;
        this.watchDb = watchDb;
        this.deviceDataSync = deviceDataSync;
        this.syncSuspend = function1;
        this.behaviours = behaviours;
        this.commandCenter = new CommandCenter(basicStorage);
        this.hasDisplay = deviceType.getHasDisplay();
        this.historyDeviceId = HistoryDeviceIdUtilsKt.getHistoryDeviceId(str);
        int r1 = Duration.$r8$clinit;
        this.dfuStatusValid = DurationKt.toDuration(30, DurationUnit.SECONDS);
        Instant.Companion.getClass();
        Instant instant = Instant.DISTANT_PAST;
        this.lastDfuStatus = new LastDfuStatus(instant, DfuStatus.NotReady);
        this.connectionInterval = Integer.MAX_VALUE;
        this.capabilities = getCachedCapabilities();
        CoroutineDispatcher ioDispatcher = DispatchersKt.ioDispatcher();
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.scope = CoroutineScopeKt.CoroutineScope(ioDispatcher.plus(new JobImpl(JobKt.getJob(serviceLocator.getScope().getCoroutineContext()))));
        this.tag = "WatchSync";
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(WatchState.Inactive);
        this._state = MutableStateFlow;
        this.state = MutableStateFlow;
        this.appEvents = serviceLocator.getAnalytics().getAppEvents();
        this.watchEvents = serviceLocator.getAnalytics().getWatchEvents();
        this.quietHours = serviceLocator.getQuietHoursProvider();
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(null), MutableStateFlow), new AnonymousClass2(null)), serviceLocator.getScope());
        this.refreshWatchTimeInterval = DurationKt.toDuration(1, DurationUnit.HOURS);
        this.lastTimeSync = instant;
        DurationUnit durationUnit = DurationUnit.DAYS;
        this.dailyInterval = DurationKt.toDuration(1, durationUnit);
        this.refreshAllSettingsInterval = DurationKt.toDuration(1, durationUnit);
        this.crashTag = "watchCrash";
        this.maxCrashHandlingAttempts = 10;
    }
}
