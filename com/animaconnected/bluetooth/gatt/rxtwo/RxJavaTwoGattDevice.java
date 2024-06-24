package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.content.ContextCompat;
import com.animaconnected.bluetooth.device.ClientProvider;
import com.animaconnected.bluetooth.device.DeviceAnalyticsListener;
import com.animaconnected.bluetooth.device.ScanToConnectInterface;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.gatt.GattId;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.bluetooth.gatt.ReadCallback;
import com.animaconnected.bluetooth.gatt.rxtwo.BondHelper;
import com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: RxJavaTwoGattDevice.kt */
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice implements GattDevice, CoroutineScope {
    private final String TAG;
    private final DeviceAnalyticsListener analyticsListener;
    private BondHelper bondHelper;
    private Job connectDelayJob;
    private RxJavaTwoGattConnection connection;
    private Job connectionJob;
    private final RxJavaTwoGattDevice$connectionListener$1 connectionListener;
    private final Context context;
    private final Set<DeviceListener> deviceListeners;
    private DeviceState deviceState;
    private final int gattAuthFail;
    private List<? extends BluetoothGattService> gattServices;
    private final CompletableJob job;
    private boolean missingConnectionPermission;
    private final Function1<Throwable, Unit> onDisconnect;
    private OnboardingConnectionListener onboardingListener;
    private boolean passiveConnect;
    private boolean refreshServices;
    private RxBleDevice rxBleDevice;
    private final ScanToConnectInterface scanToConnect;
    private boolean skipBond;
    private final DeviceType type;
    private final FirmwareVariant variant;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RxJavaTwoGattDevice.kt */
    /* loaded from: classes.dex */
    public static final class DeviceState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeviceState[] $VALUES;
        private final String analyticsName;
        public static final DeviceState Inactive = new DeviceState("Inactive", 0, "Inactive");
        public static final DeviceState ConnectionEstablished = new DeviceState("ConnectionEstablished", 1, "Connection_success");
        public static final DeviceState Bonding = new DeviceState("Bonding", 2, null, 1, null);
        public static final DeviceState DiscoverServices = new DeviceState("DiscoverServices", 3, null, 1, null);
        public static final DeviceState Connected = new DeviceState("Connected", 4, "Connected");
        public static final DeviceState Disconnected = new DeviceState("Disconnected", 5, "Disconnected");

        private static final /* synthetic */ DeviceState[] $values() {
            return new DeviceState[]{Inactive, ConnectionEstablished, Bonding, DiscoverServices, Connected, Disconnected};
        }

        static {
            DeviceState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private DeviceState(String str, int r2, String str2) {
            this.analyticsName = str2;
        }

        public static EnumEntries<DeviceState> getEntries() {
            return $ENTRIES;
        }

        public static DeviceState valueOf(String str) {
            return (DeviceState) Enum.valueOf(DeviceState.class, str);
        }

        public static DeviceState[] values() {
            return (DeviceState[]) $VALUES.clone();
        }

        public final String getAnalyticsName() {
            return this.analyticsName;
        }

        public /* synthetic */ DeviceState(String str, int r2, String str2, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, r2, (r4 & 1) != 0 ? null : str2);
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$connectionListener$1] */
    public RxJavaTwoGattDevice(Context context, String deviceAddress, DeviceType type, FirmwareVariant variant, ScanToConnectInterface scanToConnect, DeviceAnalyticsListener analyticsListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(scanToConnect, "scanToConnect");
        Intrinsics.checkNotNullParameter(analyticsListener, "analyticsListener");
        this.context = context;
        this.type = type;
        this.variant = variant;
        this.scanToConnect = scanToConnect;
        this.analyticsListener = analyticsListener;
        this.TAG = "RxJavaTwoGattDevice";
        RxBleDevice bleDevice = ClientProvider.getClient(context).getBleDevice(deviceAddress);
        this.rxBleDevice = bleDevice;
        this.deviceState = DeviceState.Inactive;
        BluetoothDevice bluetoothDevice = bleDevice.getBluetoothDevice();
        Intrinsics.checkNotNullExpressionValue(bluetoothDevice, "getBluetoothDevice(...)");
        this.bondHelper = new BondHelper(context, bluetoothDevice);
        this.gattServices = new ArrayList();
        this.deviceListeners = new CopyOnWriteArraySet();
        this.job = SupervisorKt.SupervisorJob$default();
        this.connectionListener = new ConnectionListener() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$connectionListener$1
            @Override // com.animaconnected.bluetooth.util.ConnectionListener
            public void onChanged(boolean z) {
                RxJavaTwoGattDevice.DeviceState deviceState;
                Job job;
                deviceState = RxJavaTwoGattDevice.this.deviceState;
                if (deviceState == RxJavaTwoGattDevice.DeviceState.Inactive) {
                    return;
                }
                if (!z) {
                    LogKt.debug$default((Object) this, "BT Disabled", RxJavaTwoGattDevice.this.getTAG(), (Throwable) null, true, 4, (Object) null);
                    job = RxJavaTwoGattDevice.this.connectDelayJob;
                    if (job != null) {
                        job.cancel(null);
                    }
                    RxJavaTwoGattDevice.this.connectDelayJob = null;
                    return;
                }
                RxJavaTwoGattDevice rxJavaTwoGattDevice = RxJavaTwoGattDevice.this;
                rxJavaTwoGattDevice.connectDelayJob = BuildersKt.launch$default(rxJavaTwoGattDevice, null, null, new RxJavaTwoGattDevice$connectionListener$1$onChanged$1(rxJavaTwoGattDevice, null), 3);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th) {
                RxJavaTwoGattDevice rxJavaTwoGattDevice = RxJavaTwoGattDevice.this;
                LogKt.info$default((Object) rxJavaTwoGattDevice, rxJavaTwoGattDevice.getTAG(), (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Global exception " + th;
                    }
                }, 2, (Object) null);
            }
        };
        RxJavaPlugins.errorHandler = new Consumer() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxJavaTwoGattDevice._init_$lambda$1(Function1.this, obj);
            }
        };
        this.onDisconnect = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1

            /* compiled from: RxJavaTwoGattDevice.kt */
            @DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1$2", f = "RxJavaTwoGattDevice.kt", l = {R.styleable.AppTheme_stepsHistoryLineColorActivity, R.styleable.AppTheme_stepsHistoryLineLegendColorActivity, R.styleable.AppTheme_stepsHistoryLineLegendColorDetail}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ RxJavaTwoGattDevice this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(RxJavaTwoGattDevice rxJavaTwoGattDevice, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = rxJavaTwoGattDevice;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x00a3 A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                    /*
                        r12 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r1 = r12.label
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L2a
                        if (r1 == r4) goto L21
                        if (r1 == r3) goto L1c
                        if (r1 != r2) goto L14
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto La4
                    L14:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r0)
                        throw r13
                    L1c:
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto L99
                    L21:
                        java.lang.Object r1 = r12.L$0
                        kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                        kotlin.ResultKt.throwOnFailure(r13)
                        r4 = r1
                        goto L7c
                    L2a:
                        kotlin.ResultKt.throwOnFailure(r13)
                        java.lang.Object r13 = r12.L$0
                        kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r1 = r12.this$0
                        boolean r1 = com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$hasConnectionPermission(r1)
                        if (r1 != 0) goto L51
                        java.lang.String r6 = "Missing nearby devices permission, halt conection"
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r0 = r12.this$0
                        java.lang.String r7 = r0.getTAG()
                        r8 = 0
                        r9 = 1
                        r10 = 4
                        r11 = 0
                        r5 = r13
                        com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r13 = r12.this$0
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$setMissingConnectionPermission$p(r13, r4)
                        kotlin.Unit r13 = kotlin.Unit.INSTANCE
                        return r13
                    L51:
                        java.lang.String r6 = "Scanning to connect..."
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r1 = r12.this$0
                        java.lang.String r7 = r1.getTAG()
                        r8 = 0
                        r9 = 1
                        r10 = 4
                        r11 = 0
                        r5 = r13
                        com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r1 = r12.this$0
                        com.polidea.rxandroidble2.RxBleDevice r5 = com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$getRxBleDevice$p(r1)
                        java.lang.String r5 = r5.getMacAddress()
                        java.lang.String r6 = "getMacAddress(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                        r12.L$0 = r13
                        r12.label = r4
                        java.lang.Object r1 = r1.scan(r5, r12)
                        if (r1 != r0) goto L7b
                        return r0
                    L7b:
                        r4 = r13
                    L7c:
                        java.lang.String r5 = "Scanning to connect done. fakeconnect()"
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r13 = r12.this$0
                        java.lang.String r6 = r13.getTAG()
                        r7 = 0
                        r8 = 1
                        r9 = 4
                        r10 = 0
                        com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r13 = r12.this$0
                        r1 = 0
                        r12.L$0 = r1
                        r12.label = r3
                        java.lang.Object r13 = r13.fakeConnect(r12)
                        if (r13 != r0) goto L99
                        return r0
                    L99:
                        r12.label = r2
                        r1 = 3000(0xbb8, double:1.482E-320)
                        java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r1, r12)
                        if (r13 != r0) goto La4
                        return r0
                    La4:
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r13 = r12.this$0
                        r0 = 0
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$setPassiveConnect$p(r13, r0)
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r13 = r12.this$0
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$startConnect(r13)
                        kotlin.Unit r13 = kotlin.Unit.INSTANCE
                        return r13
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: RxJavaTwoGattDevice.kt */
            @DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1$4", f = "RxJavaTwoGattDevice.kt", l = {R.styleable.AppTheme_themeBackgroundResource}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1$4, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ RxJavaTwoGattDevice this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(RxJavaTwoGattDevice rxJavaTwoGattDevice, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.this$0 = rxJavaTwoGattDevice;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass4(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z;
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
                        this.label = 1;
                        if (DelayKt.delay(3000L, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    RxJavaTwoGattDevice rxJavaTwoGattDevice = this.this$0;
                    z = rxJavaTwoGattDevice.passiveConnect;
                    rxJavaTwoGattDevice.passiveConnect = !z;
                    this.this$0.startConnect();
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                RxJavaTwoGattDevice.DeviceState deviceState;
                Job job;
                Job job2;
                RxJavaTwoGattDevice.DeviceState deviceState2;
                Set set;
                ScanToConnectInterface scanToConnectInterface;
                OnboardingConnectionListener onboardingConnectionListener;
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                deviceState = RxJavaTwoGattDevice.this.deviceState;
                boolean z = deviceState == RxJavaTwoGattDevice.DeviceState.Bonding;
                job = RxJavaTwoGattDevice.this.connectionJob;
                if (job != null) {
                    job.cancel(null);
                }
                job2 = RxJavaTwoGattDevice.this.connectDelayJob;
                if (job2 != null) {
                    job2.cancel(null);
                }
                deviceState2 = RxJavaTwoGattDevice.this.deviceState;
                if (deviceState2 != RxJavaTwoGattDevice.DeviceState.Inactive) {
                    RxJavaTwoGattDevice.this.setDeviceState(RxJavaTwoGattDevice.DeviceState.Disconnected);
                    if (ConnectionFactory.getConnection().isEnabled()) {
                        if (RxJavaTwoGattDevice.this.isBonded()) {
                            RxJavaTwoGattDevice rxJavaTwoGattDevice = RxJavaTwoGattDevice.this;
                            rxJavaTwoGattDevice.connectDelayJob = BuildersKt.launch$default(rxJavaTwoGattDevice, null, null, new AnonymousClass4(rxJavaTwoGattDevice, null), 3);
                        } else if (!z) {
                            scanToConnectInterface = RxJavaTwoGattDevice.this.scanToConnect;
                            if (scanToConnectInterface.shouldUseScanToConnect()) {
                                RxJavaTwoGattDevice rxJavaTwoGattDevice2 = RxJavaTwoGattDevice.this;
                                rxJavaTwoGattDevice2.connectDelayJob = BuildersKt.launch$default(rxJavaTwoGattDevice2, null, null, new AnonymousClass2(rxJavaTwoGattDevice2, null), 3);
                            } else {
                                RxJavaTwoGattDevice rxJavaTwoGattDevice3 = RxJavaTwoGattDevice.this;
                                LogKt.info((Object) rxJavaTwoGattDevice3, rxJavaTwoGattDevice3.getTAG(), throwable, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1.3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Disconnected during onboarding: ";
                                    }
                                });
                                onboardingConnectionListener = RxJavaTwoGattDevice.this.onboardingListener;
                                if (onboardingConnectionListener != null) {
                                    onboardingConnectionListener.onDisconnectDuringOnboarding();
                                }
                            }
                        } else {
                            RxJavaTwoGattDevice rxJavaTwoGattDevice4 = RxJavaTwoGattDevice.this;
                            LogKt.info$default((Object) rxJavaTwoGattDevice4, rxJavaTwoGattDevice4.getTAG(), (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Bonding seems to trigger a disconnect. DFU?";
                                }
                            }, 2, (Object) null);
                            RxJavaTwoGattDevice.this.skipBond = true;
                            RxJavaTwoGattDevice.this.startConnect();
                        }
                    } else {
                        RxJavaTwoGattDevice rxJavaTwoGattDevice5 = RxJavaTwoGattDevice.this;
                        LogKt.debug$default((Object) rxJavaTwoGattDevice5, "Bluetooth disabled. Don't start until enabled.", rxJavaTwoGattDevice5.getTAG(), (Throwable) null, true, 4, (Object) null);
                    }
                }
                RxJavaTwoGattDevice rxJavaTwoGattDevice6 = RxJavaTwoGattDevice.this;
                LogKt.info((Object) rxJavaTwoGattDevice6, rxJavaTwoGattDevice6.getTAG(), throwable, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$onDisconnect$1.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Disconnected: ";
                    }
                });
                set = RxJavaTwoGattDevice.this.deviceListeners;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((DeviceListener) it.next()).onDisconnected();
                }
            }
        };
        this.gattAuthFail = R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasConnectionPermission() {
        boolean z;
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return true;
        }
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            if (ContextCompat.checkSelfPermission(this.context, (String) it.next()) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDeviceState(DeviceState deviceState) {
        Boolean bool;
        String analyticsName;
        LogKt.debug$default((Object) this, "State changed: " + this.deviceState.name() + " --> " + deviceState.name(), this.TAG, (Throwable) null, true, 4, (Object) null);
        if (deviceState == DeviceState.ConnectionEstablished) {
            bool = Boolean.valueOf(this.passiveConnect);
        } else {
            bool = null;
        }
        if (this.deviceState != deviceState && (analyticsName = deviceState.getAnalyticsName()) != null) {
            this.analyticsListener.onSendAnalytics(analyticsName, isBonded(), bool);
        }
        this.deviceState = deviceState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConnect() {
        RxBleDevice rxBleDevice = this.rxBleDevice;
        Intrinsics.checkNotNullExpressionValue(rxBleDevice, "rxBleDevice");
        this.connection = new RxJavaTwoGattConnection(rxBleDevice);
        LogKt.info$default((Object) this, this.TAG, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                boolean z;
                StringBuilder sb = new StringBuilder("Start Connect [");
                z = RxJavaTwoGattDevice.this.passiveConnect;
                return OpaqueKey$$ExternalSyntheticOutline0.m(sb, z ? "Passive" : "Active", ']');
            }
        }, 2, (Object) null);
        RxJavaTwoGattConnection rxJavaTwoGattConnection = this.connection;
        if (rxJavaTwoGattConnection != null) {
            rxJavaTwoGattConnection.connect(this.passiveConnect, new Function1<RxJavaTwoGattConnection, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$2

                /* compiled from: RxJavaTwoGattDevice.kt */
                @DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$2$1", f = "RxJavaTwoGattDevice.kt", l = {205, 209, 497, 498, 498, 498, 222, 229}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ RxJavaTwoGattConnection $this_connect;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    final /* synthetic */ RxJavaTwoGattDevice this$0;

                    /* compiled from: RxJavaTwoGattDevice.kt */
                    /* renamed from: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$2$1$WhenMappings */
                    /* loaded from: classes.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] r0 = new int[BondHelper.Result.values().length];
                            try {
                                r0[BondHelper.Result.AlreadyInState.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                r0[BondHelper.Result.Success.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                r0[BondHelper.Result.Failed.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = r0;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RxJavaTwoGattDevice rxJavaTwoGattDevice, RxJavaTwoGattConnection rxJavaTwoGattConnection, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = rxJavaTwoGattDevice;
                        this.$this_connect = rxJavaTwoGattConnection;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$this_connect, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
                    /* JADX WARN: Removed duplicated region for block: B:111:0x00ff  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0269 A[Catch: Exception -> 0x0302, LOOP:0: B:11:0x0263->B:13:0x0269, LOOP_END, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x02de A[Catch: Exception -> 0x0302, LOOP:1: B:16:0x02d8->B:18:0x02de, LOOP_END, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x021e A[Catch: Exception -> 0x0302, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    /* JADX WARN: Removed duplicated region for block: B:31:0x023c A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x01fb  */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x0204 A[Catch: Exception -> 0x0302, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0192 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x0193  */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:64:0x01d2  */
                    /* JADX WARN: Removed duplicated region for block: B:70:0x0300 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
                    /* JADX WARN: Removed duplicated region for block: B:81:0x0119 A[Catch: Exception -> 0x0302, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x0121 A[Catch: Exception -> 0x0302, TryCatch #9 {Exception -> 0x0302, blocks: (B:8:0x0021, B:10:0x023d, B:11:0x0263, B:13:0x0269, B:15:0x0286, B:16:0x02d8, B:18:0x02de, B:23:0x002c, B:25:0x0216, B:27:0x021e, B:29:0x0223, B:33:0x0035, B:34:0x0301, B:37:0x0042, B:38:0x01d4, B:42:0x01fe, B:43:0x0204, B:52:0x017c, B:68:0x02ea, B:61:0x01bb, B:73:0x006a, B:75:0x00ee, B:76:0x00f6, B:79:0x0100, B:81:0x0119, B:83:0x0121, B:85:0x013a, B:86:0x014e, B:113:0x0075, B:116:0x0087, B:118:0x008f, B:120:0x00a8, B:124:0x00ca, B:126:0x00d2, B:127:0x00d5, B:129:0x00dd), top: B:2:0x000e }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
                        /*
                            Method dump skipped, instructions count: 796
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$startConnect$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
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
                public /* bridge */ /* synthetic */ Unit invoke(RxJavaTwoGattConnection rxJavaTwoGattConnection2) {
                    invoke2(rxJavaTwoGattConnection2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RxJavaTwoGattConnection connect) {
                    Intrinsics.checkNotNullParameter(connect, "$this$connect");
                    RxJavaTwoGattDevice rxJavaTwoGattDevice = RxJavaTwoGattDevice.this;
                    rxJavaTwoGattDevice.connectionJob = BuildersKt.launch$default(connect, null, null, new AnonymousClass1(rxJavaTwoGattDevice, connect, null), 3);
                }
            }, this.onDisconnect);
        }
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void changeAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        RxBleDevice bleDevice = ClientProvider.getClient(this.context).getBleDevice(address);
        this.rxBleDevice = bleDevice;
        Context context = this.context;
        BluetoothDevice bluetoothDevice = bleDevice.getBluetoothDevice();
        Intrinsics.checkNotNullExpressionValue(bluetoothDevice, "getBluetoothDevice(...)");
        this.bondHelper = new BondHelper(context, bluetoothDevice);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void connect() {
        if (this.deviceState != DeviceState.Inactive) {
            LogKt.debug$default((Object) this, "Device is already active", this.TAG, (Throwable) null, true, 4, (Object) null);
            return;
        }
        ConnectionFactory.getConnection().addConnectionListener(this.connectionListener);
        setDeviceState(DeviceState.Disconnected);
        this.passiveConnect = false;
        startConnect();
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void disconnect() {
        LogKt.info$default((Object) this, this.TAG, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$disconnect$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "disconnect()";
            }
        }, 2, (Object) null);
        ConnectionFactory.getConnection().removeConnectionListener(this.connectionListener);
        setDeviceState(DeviceState.Inactive);
        RxJavaTwoGattConnection rxJavaTwoGattConnection = this.connection;
        if (rxJavaTwoGattConnection != null) {
            rxJavaTwoGattConnection.disconnect();
        }
        this.connection = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.functions.Function2, com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4] */
    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fakeConnect(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L3a
            if (r2 == r3) goto L32
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L32:
            java.lang.Object r0 = r0.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9d
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L86
        L3e:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r2 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L89
            goto L74
        L46:
            kotlin.ResultKt.throwOnFailure(r10)
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r2 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection
            android.content.Context r10 = r9.context
            com.polidea.rxandroidble2.RxBleClient r10 = com.animaconnected.bluetooth.device.ClientProvider.getClient(r10)
            java.lang.String r7 = "FF:FF:FF:FF:FF:FF"
            com.polidea.rxandroidble2.RxBleDevice r10 = r10.getBleDevice(r7)
            java.lang.String r7 = "getBleDevice(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
            r2.<init>(r10)
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2 r10 = new kotlin.jvm.functions.Function1<com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection, kotlin.Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2
                static {
                    /*
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2) com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2.INSTANCE com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2.<init>():void");
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "$this$connect"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2.invoke2(com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r1) {
                    /*
                        r0 = this;
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r1 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection) r1
                        r0.invoke2(r1)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$2.invoke(java.lang.Object):java.lang.Object");
                }
            }     // Catch: java.lang.Throwable -> L89
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3 r7 = new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3
                static {
                    /*
                        com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3) com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3.INSTANCE com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3.<init>():void");
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.Throwable r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3.invoke2(java.lang.Throwable):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable r1) {
                    /*
                        r0 = this;
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        r0.invoke2(r1)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$3.invoke(java.lang.Object):java.lang.Object");
                }
            }     // Catch: java.lang.Throwable -> L89
            r8 = 0
            r2.connect(r8, r10, r7)     // Catch: java.lang.Throwable -> L89
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L89
            r0.label = r5     // Catch: java.lang.Throwable -> L89
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r7, r0)     // Catch: java.lang.Throwable -> L89
            if (r10 != r1) goto L74
            return r1
        L74:
            kotlinx.coroutines.NonCancellable r10 = kotlinx.coroutines.NonCancellable.INSTANCE
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4 r3 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4
            r3.<init>(r2, r6)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r3, r0)
            if (r10 != r1) goto L86
            return r1
        L86:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L89:
            r10 = move-exception
            kotlinx.coroutines.NonCancellable r4 = kotlinx.coroutines.NonCancellable.INSTANCE
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4 r5 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4
            r5.<init>(r2, r6)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r0 != r1) goto L9c
            return r1
        L9c:
            r0 = r10
        L9d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.fakeConnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public String getAddress() {
        String macAddress = this.rxBleDevice.getMacAddress();
        Intrinsics.checkNotNullExpressionValue(macAddress, "getMacAddress(...)");
        return macAddress;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public BluetoothGattCharacteristic getCharacteristic(UUID service, UUID characteristic) {
        Object obj;
        Object obj2;
        List<BluetoothGattCharacteristic> characteristics;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Iterator<T> it = this.gattServices.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual(((BluetoothGattService) obj2).getUuid(), service)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        BluetoothGattService bluetoothGattService = (BluetoothGattService) obj2;
        if (bluetoothGattService == null || (characteristics = bluetoothGattService.getCharacteristics()) == null) {
            return null;
        }
        Iterator<T> it2 = characteristics.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((BluetoothGattCharacteristic) next).getUuid(), characteristic)) {
                obj = next;
                break;
            }
        }
        return (BluetoothGattCharacteristic) obj;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher.plus(this.job);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public DeviceType getDeviceType() {
        return this.type;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public FirmwareVariant getFirmwareVariant() {
        return this.variant;
    }

    public final Function1<Throwable, Unit> getOnDisconnect() {
        return this.onDisconnect;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final DeviceType getType() {
        return this.type;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public boolean guessIfDeviceIsInDfu() {
        if (this.gattServices.size() == 3) {
            UUID GENERIC_ACCESS = GattId.Service.GENERIC_ACCESS;
            Intrinsics.checkNotNullExpressionValue(GENERIC_ACCESS, "GENERIC_ACCESS");
            if (hasGattService(GENERIC_ACCESS)) {
                UUID GENERIC_ATTRIBUTE = GattId.Service.GENERIC_ATTRIBUTE;
                Intrinsics.checkNotNullExpressionValue(GENERIC_ATTRIBUTE, "GENERIC_ATTRIBUTE");
                if (hasGattService(GENERIC_ATTRIBUTE)) {
                    UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8 = GattId.Service.NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8;
                    Intrinsics.checkNotNullExpressionValue(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8, "NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8");
                    if (!hasGattService(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK8)) {
                        UUID NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15 = GattId.Service.NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15;
                        Intrinsics.checkNotNullExpressionValue(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15, "NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15");
                        if (hasGattService(NORDIC_DEVICE_FIRMWARE_UPDATE_SDK15)) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public boolean hasGattService(UUID service) {
        Intrinsics.checkNotNullParameter(service, "service");
        List<? extends BluetoothGattService> list = this.gattServices;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((BluetoothGattService) it.next()).getUuid());
        }
        return arrayList.contains(service);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public boolean isBonded() {
        return this.bondHelper.isBonded();
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public boolean isConnected() {
        if (this.deviceState == DeviceState.Connected) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void onResume() {
        if (this.missingConnectionPermission && hasConnectionPermission()) {
            this.missingConnectionPermission = false;
            startConnect();
        }
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void read(UUID service, UUID characteristic, ReadCallback callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BluetoothGattCharacteristic characteristic2 = getCharacteristic(service, characteristic);
        if (characteristic2 == null) {
            callback.onError(new RuntimeException("Characteristic not found"));
        } else {
            BuildersKt.launch$default(this, null, null, new RxJavaTwoGattDevice$read$1(this, characteristic2, callback, null), 3);
        }
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void refreshConnection(boolean z) {
        LogKt.debug$default((Object) this, "refreshConnection(" + z + ')', this.TAG, (Throwable) null, true, 4, (Object) null);
        if (!z) {
            this.analyticsListener.onServicesNotFound(this.gattServices.size());
        }
        RxJavaTwoGattConnection rxJavaTwoGattConnection = this.connection;
        if (rxJavaTwoGattConnection != null) {
            rxJavaTwoGattConnection.disconnect();
        }
        this.connection = null;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void registerListener(DeviceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.deviceListeners.add(listener);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public Future<Void> removeBond() {
        return FutureCoroutineKt.asFuture(BuildersKt.async$default(this, null, new RxJavaTwoGattDevice$removeBond$1(this, null), 3));
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void removeOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onboardingListener = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object scan(java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r10 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L2b
            goto L57
        L2b:
            r2 = r10
            goto L4c
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2 r11 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4b
            r2 = 0
            r11.<init>(r9, r10, r2)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4b
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4b
            r0.label = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4b
            r2 = 7000(0x1b58, double:3.4585E-320)
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r11, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4b
            if (r10 != r1) goto L57
            return r1
        L4b:
            r2 = r9
        L4c:
            java.lang.String r3 = "Scan timed out"
            java.lang.String r4 = r2.TAG
            r5 = 0
            r6 = 1
            r7 = 4
            r8 = 0
            com.animaconnected.logger.LogKt.debug$default(r2, r3, r4, r5, r6, r7, r8)
        L57:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.scan(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void setNotification(UUID service, UUID characteristic, byte[] descriptorType) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(descriptorType, "descriptorType");
        setNotification(service, characteristic, descriptorType, new Callback<Void>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$setNotification$callback$1
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                LogKt.info$default((Object) this, "setNotification failed, refreshing connection", RxJavaTwoGattDevice.this.getTAG(), (Throwable) null, true, 4, (Object) null);
                RxJavaTwoGattDevice.this.refreshConnection(false);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r8) {
                LogKt.info$default((Object) this, "setNotification: Success", RxJavaTwoGattDevice.this.getTAG(), (Throwable) null, true, 4, (Object) null);
            }
        });
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void setOnboardingConnectionListener(OnboardingConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onboardingListener = listener;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void skipBondingAndRefresh() {
        this.skipBond = true;
        this.refreshServices = true;
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void unregisterListener(DeviceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.deviceListeners.remove(listener);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void write(UUID service, UUID characteristic, byte[] data, Callback<Void> callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(data, "data");
        BluetoothGattCharacteristic characteristic2 = getCharacteristic(service, characteristic);
        if (characteristic2 == null) {
            if (callback != null) {
                callback.onError(new RuntimeException("Characteristic not found"));
                return;
            }
            return;
        }
        BuildersKt.launch$default(this, null, null, new RxJavaTwoGattDevice$write$1(this, characteristic2, data, callback, null), 3);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void writeRead(UUID service, UUID characteristic, byte[] data, ReadCallback callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BluetoothGattCharacteristic characteristic2 = getCharacteristic(service, characteristic);
        if (characteristic2 == null) {
            callback.onError(new RuntimeException("Characteristic not found"));
        } else {
            BuildersKt.launch$default(this, null, null, new RxJavaTwoGattDevice$writeRead$1(this, characteristic2, data, callback, null), 3);
        }
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public RxJavaTwoGattDevice createClone(ScanToConnectInterface scanToConnect) {
        Intrinsics.checkNotNullParameter(scanToConnect, "scanToConnect");
        return new RxJavaTwoGattDevice(this.context, getAddress(), this.type, this.variant, scanToConnect, this.analyticsListener);
    }

    @Override // com.animaconnected.bluetooth.gatt.GattDevice
    public void setNotification(UUID service, UUID characteristic, byte[] descriptorType, Callback<Void> callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(descriptorType, "descriptorType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BluetoothGattCharacteristic characteristic2 = getCharacteristic(service, characteristic);
        if (characteristic2 == null) {
            callback.onError(new NullPointerException());
        } else {
            BuildersKt.launch$default(this, null, null, new RxJavaTwoGattDevice$setNotification$1(characteristic2, this, descriptorType, callback, service, characteristic, null), 3);
        }
    }
}
