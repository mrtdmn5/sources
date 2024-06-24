package com.animaconnected.secondo.screens.debugsettings;

import android.net.Uri;
import android.os.Build;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModel;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.screens.debugsettings.DebugBleStatus;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.File;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugSettingsPresenter.kt */
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter extends ViewModel {
    public static final int CRITICAL_BATTERY = 1800;
    public static final int LOW_BATTERY = 2500;
    public static final int NORMAL_BATTERY = 0;
    public static final String TAG = "DebugSettings";
    private final DebugCompanionDevice companionDevice;
    private final DebugSettingsPresenter$deviceConnectionListener$1 deviceConnectionListener;
    private final CoroutineScope scope;
    private final Function1<String, Unit> toast;
    private final MutableStateFlow<DebugUiState> uiState;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugSettingsPresenter.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$1", f = "DebugSettingsPresenter.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: DebugSettingsPresenter.kt */
        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$1$1", f = "DebugSettingsPresenter.kt", l = {69}, m = "invokeSuspend")
        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00531 extends SuspendLambda implements Function2<Watch, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DebugSettingsPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00531(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super C00531> continuation) {
                super(2, continuation);
                this.this$0 = debugSettingsPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00531 c00531 = new C00531(this.this$0, continuation);
                c00531.L$0 = obj;
                return c00531;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Watch watch, Continuation<? super Unit> continuation) {
                return ((C00531) create(watch, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                int r1 = this.label;
                if (r1 != 0) {
                    if (r1 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Watch watch = (Watch) this.L$0;
                    StateFlow<Watch.WatchState> state = watch.getState();
                    final DebugSettingsPresenter debugSettingsPresenter = this.this$0;
                    FlowCollector<? super Watch.WatchState> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((Watch.WatchState) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(Watch.WatchState watchState, Continuation<? super Unit> continuation) {
                            DebugUiState value;
                            MutableStateFlow<DebugUiState> uiState = DebugSettingsPresenter.this.getUiState();
                            Watch watch2 = watch;
                            do {
                                value = uiState.getValue();
                            } while (!uiState.compareAndSet(value, DebugUiState.copy$default(value, null, watch2.getState().getValue(), null, null, null, null, null, null, false, 509, null)));
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (state.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
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
                CommonFlow<Watch> currentWatchFlow = DebugSettingsPresenter.this.watchProvider.getWatchManager().getCurrentWatchFlow();
                C00531 c00531 = new C00531(DebugSettingsPresenter.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(currentWatchFlow, c00531, this) == coroutineSingletons) {
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

    /* compiled from: DebugSettingsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugSettingsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class DebugMenuFakeCrash extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DebugMenuFakeCrash(String msg) {
            super(msg);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$deviceConnectionListener$1] */
    public DebugSettingsPresenter(DebugCompanionDevice companionDevice, Function1<? super String, Unit> toast) {
        Intrinsics.checkNotNullParameter(companionDevice, "companionDevice");
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.companionDevice = companionDevice;
        this.toast = toast;
        SupervisorJobImpl SupervisorJob$default = SupervisorKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        ContextScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(MainDispatcherLoader.dispatcher.getImmediate()));
        this.scope = CoroutineScope;
        this.watchProvider = ProviderFactory.getWatch();
        this.uiState = StateFlowKt.MutableStateFlow(new DebugUiState(null, null, null, null, null, null, null, null, false, 511, null));
        this.deviceConnectionListener = new DeviceConnectionListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$deviceConnectionListener$1
            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onConnected() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onConnected$1(DebugSettingsPresenter.this, null), 3);
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onDisconnected() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onDisconnected$1(DebugSettingsPresenter.this, null), 3);
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onEnterDfuMode() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onEnterDfuMode$1(DebugSettingsPresenter.this, null), 3);
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onEnterUpdateRequired() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onEnterUpdateRequired$1(DebugSettingsPresenter.this, null), 3);
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onLeaveDfuMode() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onLeaveDfuMode$1(DebugSettingsPresenter.this, null), 3);
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onLeaveUpdateRequired() {
                CoroutineScope coroutineScope;
                coroutineScope = DebugSettingsPresenter.this.scope;
                BuildersKt.launch$default(coroutineScope, null, null, new DebugSettingsPresenter$deviceConnectionListener$1$onLeaveUpdateRequired$1(DebugSettingsPresenter.this, null), 3);
            }
        };
        BuildersKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchFirmwareUpdateStatus(Continuation<? super String> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return BuildersKt.withContext(MainDispatcherLoader.dispatcher, new DebugSettingsPresenter$fetchFirmwareUpdateStatus$2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5 A[Catch: Exception -> 0x0034, TRY_LEAVE, TryCatch #2 {Exception -> 0x0034, blocks: (B:12:0x002f, B:13:0x009b, B:15:0x00a5), top: B:11:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchUserCategoryAndFwVersion(kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> r14) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.fetchUserCategoryAndFwVersion(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDfuFromCloud$lambda$10(DebugSettingsPresenter this$0, final Throwable th) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LogKt.warn$default((Object) this$0, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$startDfuFromCloud$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0.m(th, new StringBuilder("Failed to start dfu from cloud. Exception: "));
            }
        }, 6, (Object) null);
        this$0.toast.invoke("FW download error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDfuFromCloud$lambda$9(WatchAppUpdateProvider updateProvider, DebugSettingsPresenter this$0, WatchFotaProvider fotaProvider, Void r6) {
        String m;
        Intrinsics.checkNotNullParameter(updateProvider, "$updateProvider");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fotaProvider, "$fotaProvider");
        File cachedFirmware = updateProvider.getCachedFirmware();
        String cachedVersion = updateProvider.getCachedVersion();
        FirmwareUpdate firmwareUpdate = this$0.watchProvider.getFirmwareUpdate();
        if (firmwareUpdate == FirmwareUpdate.FOTA) {
            fotaProvider.setFotaStartedFromDebug(true);
            fotaProvider.startFota(this$0.watchProvider, cachedFirmware);
            m = "Downloaded " + cachedVersion + ". Starting FOTA ..";
        } else if (firmwareUpdate.isDfu()) {
            ProviderFactory.getWatchDfuProvider().startDfu(this$0.watchProvider, cachedFirmware, null);
            m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Downloaded "), cachedVersion, ". Starting DFU ..");
        } else {
            m = zzav$$ExternalSyntheticOutline0.m("Downloaded ", cachedVersion, ". But don't know how to use it.");
        }
        this$0.toast.invoke(m);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearDisplayDatabase(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$clearDisplayDatabase$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$clearDisplayDatabase$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$clearDisplayDatabase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$clearDisplayDatabase$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$clearDisplayDatabase$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L63
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.WatchProvider r5 = r4.watchProvider
            com.animaconnected.info.DeviceType r5 = r5.getDeviceType()
            r2 = 0
            if (r5 == 0) goto L46
            boolean r5 = r5.getHasDisplay()
            if (r5 != r3) goto L46
            r2 = r3
        L46:
            if (r2 == 0) goto L66
            com.animaconnected.watch.WatchProvider r5 = r4.watchProvider
            com.animaconnected.watch.Watch r5 = r5.getWatch()
            r5.clearVariableStorage()
            com.animaconnected.watch.WatchProvider r5 = r4.watchProvider
            com.animaconnected.watch.WatchManager r5 = r5.getWatchManager()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.sync(r0)
            if (r5 != r1) goto L62
            return r1
        L62:
            r0 = r4
        L63:
            java.lang.String r5 = "Deleted!"
            goto L69
        L66:
            java.lang.String r5 = "Not a pascal device"
            r0 = r4
        L69:
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r0 = r0.toast
            r0.invoke(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.clearDisplayDatabase(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void close() {
        this.watchProvider.debugClose();
    }

    public final void connect() {
        this.watchProvider.debugConnect();
    }

    public final void disablePowerOptimizations() {
        PowerOptimizationStatusController powerOptimizationController = ProviderFactory.getStatusProvider().getPowerOptimizationController();
        if (powerOptimizationController != null) {
            powerOptimizationController.requestIgnorePowerOptimizations();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fakeConnect(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fakeConnect$1
            if (r2 == 0) goto L17
            r2 = r1
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fakeConnect$1 r2 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fakeConnect$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fakeConnect$1 r2 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fakeConnect$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            java.lang.Object r2 = r2.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r2 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L77
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.secondo.screens.debugsettings.DebugUiState> r1 = r0.uiState
        L3c:
            java.lang.Object r4 = r1.getValue()
            r6 = r4
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r6 = (com.animaconnected.secondo.screens.debugsettings.DebugUiState) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r13 = r6.getLoadingStates()
            r14 = 0
            r15 = 1
            r16 = 0
            r17 = 5
            r18 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r13 = com.animaconnected.secondo.screens.debugsettings.DebugLoadingState.copy$default(r13, r14, r15, r16, r17, r18)
            r14 = 0
            r15 = 0
            r16 = 447(0x1bf, float:6.26E-43)
            r17 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r6 = com.animaconnected.secondo.screens.debugsettings.DebugUiState.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r4 = r1.compareAndSet(r4, r6)
            if (r4 == 0) goto L3c
            com.animaconnected.watch.WatchProvider r1 = r0.watchProvider
            r2.L$0 = r0
            r2.label = r5
            java.lang.Object r1 = r1.debugFakeConnect(r2)
            if (r1 != r3) goto L76
            return r3
        L76:
            r2 = r0
        L77:
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.secondo.screens.debugsettings.DebugUiState> r4 = r2.uiState
        L79:
            java.lang.Object r1 = r4.getValue()
            r5 = r1
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r5 = (com.animaconnected.secondo.screens.debugsettings.DebugUiState) r5
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r12 = r5.getLoadingStates()
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 5
            r17 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r12 = com.animaconnected.secondo.screens.debugsettings.DebugLoadingState.copy$default(r12, r13, r14, r15, r16, r17)
            r13 = 0
            r15 = 447(0x1bf, float:6.26E-43)
            r16 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r2 = com.animaconnected.secondo.screens.debugsettings.DebugUiState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r1 = r4.compareAndSet(r1, r2)
            if (r1 == 0) goto L79
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.fakeConnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object fetchPostMortem(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new DebugSettingsPresenter$fetchPostMortem$2(this, null), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f5, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f6, code lost:            r6 = r0;        r2 = r18;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:11:0x002b, B:12:0x0077, B:13:0x007c, B:17:0x008b, B:19:0x0094, B:21:0x009e, B:23:0x00a7, B:25:0x00b1, B:29:0x00bc, B:30:0x00ce), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:11:0x002b, B:12:0x0077, B:13:0x007c, B:17:0x008b, B:19:0x0094, B:21:0x009e, B:23:0x00a7, B:25:0x00b1, B:29:0x00bc, B:30:0x00ce), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2 A[LOOP:0: B:30:0x00ce->B:32:0x00f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124 A[EDGE_INSN: B:33:0x0124->B:34:0x0124 BREAK  A[LOOP:0: B:30:0x00ce->B:32:0x00f2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLastDisconnectInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.getLastDisconnectInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final MutableStateFlow<DebugUiState> getUiState() {
        return this.uiState;
    }

    public final void onPause() {
        this.watchProvider.unregisterDeviceConnectionListener(this.deviceConnectionListener);
    }

    public final void onResume() {
        this.watchProvider.registerDeviceConnectionListener(this.deviceConnectionListener);
        BuildersKt.launch$default(this.scope, null, null, new DebugSettingsPresenter$onResume$1(this, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshAmplifySession(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$refreshAmplifySession$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$refreshAmplifySession$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$refreshAmplifySession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$refreshAmplifySession$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$refreshAmplifySession$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2b
            goto L44
        L2b:
            r5 = move-exception
            goto L4e
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch: java.lang.Exception -> L4c
            r0.label = r3     // Catch: java.lang.Exception -> L4c
            java.lang.Object r5 = com.animaconnected.cloud.CloudKt.forceFetchAuthSession(r0)     // Catch: java.lang.Exception -> L4c
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r5 = r0.toast     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "Refreshed"
            r5.invoke(r1)     // Catch: java.lang.Exception -> L2b
            goto L65
        L4c:
            r5 = move-exception
            r0 = r4
        L4e:
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r0 = r0.toast
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.invoke(r5)
        L65:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.refreshAmplifySession(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void removeAssociation() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.companionDevice.removeAssociation();
        } else {
            this.toast.invoke("Requires minimum Android 13");
        }
    }

    public final void removeBond() {
        try {
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$removeBond$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Remove bond for watch: " + DebugSettingsPresenter.this.watchProvider.getAddress();
                }
            }, 6, (Object) null);
            Bonding.getInstance().removeBondFromDevice(this.watchProvider.getAddress());
        } catch (Exception e) {
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$removeBond$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to remove bond: "));
                }
            }, 6, (Object) null);
        }
    }

    public final void requestAssociation() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.companionDevice.requestAssociation();
        } else {
            this.toast.invoke("Requires minimum Android 13");
        }
    }

    public final void resetRecentDemoData() {
        this.watchProvider.getWatchManager().getDemoModeProvider().resetRecent();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object scan(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$scan$1
            if (r2 == 0) goto L17
            r2 = r1
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$scan$1 r2 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$scan$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$scan$1 r2 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$scan$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            java.lang.Object r2 = r2.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r2 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L76
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.secondo.screens.debugsettings.DebugUiState> r1 = r0.uiState
        L3c:
            java.lang.Object r4 = r1.getValue()
            r6 = r4
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r6 = (com.animaconnected.secondo.screens.debugsettings.DebugUiState) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r13 = r6.getLoadingStates()
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 3
            r18 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r13 = com.animaconnected.secondo.screens.debugsettings.DebugLoadingState.copy$default(r13, r14, r15, r16, r17, r18)
            r14 = 0
            r16 = 447(0x1bf, float:6.26E-43)
            r17 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r6 = com.animaconnected.secondo.screens.debugsettings.DebugUiState.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r4 = r1.compareAndSet(r4, r6)
            if (r4 == 0) goto L3c
            com.animaconnected.watch.WatchProvider r1 = r0.watchProvider
            r2.L$0 = r0
            r2.label = r5
            java.lang.Object r1 = r1.debugScan(r2)
            if (r1 != r3) goto L75
            return r3
        L75:
            r2 = r0
        L76:
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.secondo.screens.debugsettings.DebugUiState> r4 = r2.uiState
        L78:
            java.lang.Object r1 = r4.getValue()
            r5 = r1
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r5 = (com.animaconnected.secondo.screens.debugsettings.DebugUiState) r5
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r12 = r5.getLoadingStates()
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 3
            r17 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugLoadingState r12 = com.animaconnected.secondo.screens.debugsettings.DebugLoadingState.copy$default(r12, r13, r14, r15, r16, r17)
            r13 = 0
            r15 = 447(0x1bf, float:6.26E-43)
            r16 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r2 = com.animaconnected.secondo.screens.debugsettings.DebugUiState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r1 = r4.compareAndSet(r1, r2)
            if (r1 == 0) goto L78
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.scan(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|(1:(1:9)(2:21|22))(2:23|(1:25)(1:26))|10|(1:12)|13|14|15|16))|27|6|(0)(0)|10|(0)|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:            r6 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:            r1.toast.invoke("Failed to send crashlytics. Exception: " + r6.getMessage());     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendCrashlytics(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Sent crash for "
            boolean r1 = r6 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$sendCrashlytics$1
            if (r1 == 0) goto L15
            r1 = r6
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$sendCrashlytics$1 r1 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$sendCrashlytics$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$sendCrashlytics$1 r1 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$sendCrashlytics$1
            r1.<init>(r5, r6)
        L1a:
            java.lang.Object r6 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            java.lang.Object r1 = r1.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r1 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.WatchProvider r6 = r5.watchProvider
            com.animaconnected.future.Future r6 = r6.getDeviceInformation()
            r1.L$0 = r5
            r1.label = r4
            java.lang.Object r6 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r6, r1)
            if (r6 != r2) goto L49
            return r2
        L49:
            r1 = r5
        L4a:
            java.util.Map r6 = (java.util.Map) r6
            com.animaconnected.watch.device.DeviceInfo r2 = com.animaconnected.watch.device.DeviceInfo.SerialNumber
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L58
            java.lang.String r6 = "XX:XX:XX:XX:XX:XX"
        L58:
            com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()     // Catch: java.lang.IllegalStateException -> L6e
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$DebugMenuFakeCrash r3 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$DebugMenuFakeCrash     // Catch: java.lang.IllegalStateException -> L6e
            r3.<init>(r6)     // Catch: java.lang.IllegalStateException -> L6e
            r2.recordException(r3)     // Catch: java.lang.IllegalStateException -> L6e
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r2 = r1.toast     // Catch: java.lang.IllegalStateException -> L6e
            java.lang.String r6 = r0.concat(r6)     // Catch: java.lang.IllegalStateException -> L6e
            r2.invoke(r6)     // Catch: java.lang.IllegalStateException -> L6e
            goto L86
        L6e:
            r6 = move-exception
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r0 = r1.toast
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to send crashlytics. Exception: "
            r1.<init>(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.invoke(r6)
        L86:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.sendCrashlytics(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(1:(4:11|12|13|14)(2:16|17))(2:18|19))(2:23|(4:31|32|(2:34|(1:36))|38)(2:29|30))|20|(1:22)|13|14))|44|6|7|(0)(0)|20|(0)|13|14|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x003e, code lost:            r14 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x003f, code lost:            r0 = r13;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setBatteryLevel(final int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r13 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r13 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L3e
            goto L90
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            java.lang.Object r13 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r13 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L3e
            goto L78
        L3e:
            r14 = move-exception
            r0 = r13
            goto L85
        L41:
            kotlin.ResultKt.throwOnFailure(r14)
            if (r13 == 0) goto L60
            r14 = 1800(0x708, float:2.522E-42)
            if (r13 == r14) goto L60
            r14 = 2500(0x9c4, float:3.503E-42)
            if (r13 == r14) goto L60
            java.lang.String r6 = "DebugSettings"
            r7 = 0
            r8 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$3 r9 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$3
            r9.<init>()
            r10 = 6
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.warn$default(r5, r6, r7, r8, r9, r10, r11)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L92
        L60:
            com.animaconnected.watch.WatchProvider r14 = r12.watchProvider     // Catch: java.lang.Exception -> L83
            com.animaconnected.watch.Watch r14 = r14.getWatch()     // Catch: java.lang.Exception -> L83
            com.animaconnected.watch.device.WatchIODebug r14 = r14.getDebugIo()     // Catch: java.lang.Exception -> L83
            if (r14 == 0) goto L77
            r0.L$0 = r12     // Catch: java.lang.Exception -> L83
            r0.label = r4     // Catch: java.lang.Exception -> L83
            java.lang.Object r13 = r14.writeVbatSim(r13, r0)     // Catch: java.lang.Exception -> L83
            if (r13 != r1) goto L77
            return r1
        L77:
            r13 = r12
        L78:
            r0.L$0 = r13     // Catch: java.lang.Exception -> L3e
            r0.label = r3     // Catch: java.lang.Exception -> L3e
            java.lang.Object r13 = r13.update(r0)     // Catch: java.lang.Exception -> L3e
            if (r13 != r1) goto L90
            return r1
        L83:
            r14 = move-exception
            r0 = r12
        L85:
            r2 = r14
            java.lang.String r1 = "DebugSettings"
            r3 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2
                static {
                    /*
                        com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2) com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2.INSTANCE com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed writing battery level"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$setBatteryLevel$2.invoke():java.lang.Object");
                }
            }
            r5 = 4
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
        L90:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L92:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.setBatteryLevel(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void startDfuFromCloud() {
        final WatchFotaProvider watchFotaProvider = ProviderFactory.getWatchFotaProvider();
        final WatchAppUpdateProvider watchAppUpdateProvider = ProviderFactory.getWatchAppUpdateProvider();
        watchAppUpdateProvider.downloadAlways(this.watchProvider).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DebugSettingsPresenter.startDfuFromCloud$lambda$9(WatchAppUpdateProvider.this, this, watchFotaProvider, (Void) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                DebugSettingsPresenter.startDfuFromCloud$lambda$10(DebugSettingsPresenter.this, th);
            }
        });
    }

    public final Object startDfuFromFile(Uri uri, Continuation<? super Unit> continuation) {
        FirmwareUpdate firmwareUpdate = this.watchProvider.getFirmwareUpdate();
        if (firmwareUpdate == FirmwareUpdate.FOTA) {
            this.toast.invoke("Flashing FOTA firmware: " + uri);
            ProviderFactory.getWatchFotaProvider().setFotaStartedFromDebug(true);
            ProviderFactory.getWatchFotaProvider().startFotaFromFile(this.watchProvider, uri);
        } else if (firmwareUpdate.isDfu()) {
            this.toast.invoke("Flashing DFU firmware: " + uri);
            ProviderFactory.getWatchDfuProvider().startDfuFromFile(this.watchProvider, uri);
        }
        Object update = update(continuation);
        if (update == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return update;
        }
        return Unit.INSTANCE;
    }

    public final void toggleAppAlwaysOn(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        ProviderFactory.getSettingProvider().setAvailability(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r1.copy((r22 & 1) != 0 ? r1.demoMode : false, (r22 & 2) != 0 ? r1.mockFitness : false, (r22 & 4) != 0 ? r1.speedCalibration : false, (r22 & 8) != 0 ? r1.workInProgress : false, (r22 & 16) != 0 ? r1.healthDashboard : false, (r22 & 32) != 0 ? r1.ktorLogs : false, (r22 & 64) != 0 ? r1.appAlwaysOn : z, (r22 & 128) != 0 ? r1.customerSupportDev : false, (r22 & 256) != 0 ? r1.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleBluetoothDebug(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        this.watchProvider.enableBluetoothDebug(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : false, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : false, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : false, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : false, (r22 & 256) != 0 ? r2.bluetoothDebug : z, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleCustomerSupportDevEnv(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setCustomerSupportDevEnvironment(KronabyApplication.Companion.getContext(), z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : false, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : false, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : false, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : z, (r22 & 256) != 0 ? r2.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleDemoMode(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        this.watchProvider.getWatchManager().getDemoModeProvider().setIsEnabled(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : z, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : false, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : false, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : false, (r22 & 256) != 0 ? r2.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleHealthDashboard(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setShowWorkoutSessions(KronabyApplication.Companion.getContext(), z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : false, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : false, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : z, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : false, (r22 & 256) != 0 ? r2.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleHttpLogs(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setKtorHttpLoggingEnabled(z);
        this.watchProvider.getWatchManager().getStravaClient().setHttpLoggingEnabled(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r1.copy((r22 & 1) != 0 ? r1.demoMode : false, (r22 & 2) != 0 ? r1.mockFitness : false, (r22 & 4) != 0 ? r1.speedCalibration : false, (r22 & 8) != 0 ? r1.workInProgress : false, (r22 & 16) != 0 ? r1.healthDashboard : false, (r22 & 32) != 0 ? r1.ktorLogs : z, (r22 & 64) != 0 ? r1.appAlwaysOn : false, (r22 & 128) != 0 ? r1.customerSupportDev : false, (r22 & 256) != 0 ? r1.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleMockFitness(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setForceMockFitnessProvider(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r1.copy((r22 & 1) != 0 ? r1.demoMode : false, (r22 & 2) != 0 ? r1.mockFitness : z, (r22 & 4) != 0 ? r1.speedCalibration : false, (r22 & 8) != 0 ? r1.workInProgress : false, (r22 & 16) != 0 ? r1.healthDashboard : false, (r22 & 32) != 0 ? r1.ktorLogs : false, (r22 & 64) != 0 ? r1.appAlwaysOn : false, (r22 & 128) != 0 ? r1.customerSupportDev : false, (r22 & 256) != 0 ? r1.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleRssiLiveUpdates(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        this.watchProvider.setRssiNotification(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : false, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : false, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : false, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : false, (r22 & 256) != 0 ? r2.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : z);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleSpeedCalibration(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setSpeedCalibrationEnabled(z);
        this.watchProvider.updateSpeedCalibrationEnabled();
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r2.copy((r22 & 1) != 0 ? r2.demoMode : false, (r22 & 2) != 0 ? r2.mockFitness : false, (r22 & 4) != 0 ? r2.speedCalibration : z, (r22 & 8) != 0 ? r2.workInProgress : false, (r22 & 16) != 0 ? r2.healthDashboard : false, (r22 & 32) != 0 ? r2.ktorLogs : false, (r22 & 64) != 0 ? r2.appAlwaysOn : false, (r22 & 128) != 0 ? r2.customerSupportDev : false, (r22 & 256) != 0 ? r2.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    public final void toggleWorkInProgress(boolean z) {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugSwitchStatus copy;
        DebugStorage.INSTANCE.setShowWipStuff(z);
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            copy = r1.copy((r22 & 1) != 0 ? r1.demoMode : false, (r22 & 2) != 0 ? r1.mockFitness : false, (r22 & 4) != 0 ? r1.speedCalibration : false, (r22 & 8) != 0 ? r1.workInProgress : z, (r22 & 16) != 0 ? r1.healthDashboard : false, (r22 & 32) != 0 ? r1.ktorLogs : false, (r22 & 64) != 0 ? r1.appAlwaysOn : false, (r22 & 128) != 0 ? r1.customerSupportDev : false, (r22 & 256) != 0 ? r1.bluetoothDebug : false, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? debugUiState.getSwitches().rssiLiveUpdates : false);
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, copy, null, null, null, false, 495, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object triggerAppError(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r0 = (com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2b
            goto L5d
        L2b:
            r8 = move-exception
            goto L52
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.WatchProvider r8 = r7.watchProvider     // Catch: java.lang.Exception -> L50
            com.animaconnected.watch.Watch r8 = r8.getWatch()     // Catch: java.lang.Exception -> L50
            com.animaconnected.watch.device.WatchIODebug r8 = r8.getDebugIo()     // Catch: java.lang.Exception -> L50
            if (r8 == 0) goto L5d
            r0.L$0 = r7     // Catch: java.lang.Exception -> L50
            r0.label = r3     // Catch: java.lang.Exception -> L50
            r2 = 0
            java.lang.Object r8 = r8.writeDebugAppError(r2, r0)     // Catch: java.lang.Exception -> L50
            if (r8 != r1) goto L5d
            return r1
        L50:
            r8 = move-exception
            r0 = r7
        L52:
            r2 = r8
            java.lang.String r1 = "DebugSettings"
            r3 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2
                static {
                    /*
                        com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2) com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2.INSTANCE com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed triggering app error"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$triggerAppError$2.invoke():java.lang.Object");
                }
            }
            r5 = 4
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
        L5d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.triggerAppError(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void triggerHardFault() {
        this.watchProvider.writeHardFault(false);
    }

    public final Object update(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugSettingsPresenter$update$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object updateAllSwitchStates(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugSettingsPresenter$updateAllSwitchStates$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final void updateBluetoothStatus() {
        DebugUiState value;
        DebugUiState debugUiState;
        DebugBleStatus debugBleStatus;
        MutableStateFlow<DebugUiState> mutableStateFlow = this.uiState;
        do {
            value = mutableStateFlow.getValue();
            debugUiState = value;
            if (this.watchProvider.isConnected()) {
                debugBleStatus = new DebugBleStatus(DebugBleStatus.ConnectionState.CONNECTED, this.companionDevice.isAssociated());
            } else if (this.watchProvider.isInDfuMode()) {
                debugBleStatus = new DebugBleStatus(DebugBleStatus.ConnectionState.DFU, this.companionDevice.isAssociated());
            } else {
                debugBleStatus = new DebugBleStatus(DebugBleStatus.ConnectionState.DISCONNECTED, this.companionDevice.isAssociated());
            }
        } while (!mutableStateFlow.compareAndSet(value, DebugUiState.copy$default(debugUiState, debugBleStatus, null, null, null, null, null, null, null, false, 510, null)));
    }

    public final Object updateTokens(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new DebugSettingsPresenter$updateTokens$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
