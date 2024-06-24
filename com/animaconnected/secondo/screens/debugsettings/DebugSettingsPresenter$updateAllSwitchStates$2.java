package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$updateAllSwitchStates$2", f = "DebugSettingsPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$updateAllSwitchStates$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$updateAllSwitchStates$2(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$updateAllSwitchStates$2> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugSettingsPresenter$updateAllSwitchStates$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugUiState value;
        DebugUiState debugUiState;
        boolean isCurrentlyEnabled;
        DebugStorage debugStorage;
        boolean forceMockFitnessProvider;
        boolean z;
        boolean showWipStuff;
        KronabyApplication.Companion companion;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<DebugUiState> uiState = this.this$0.getUiState();
            DebugSettingsPresenter debugSettingsPresenter = this.this$0;
            do {
                value = uiState.getValue();
                debugUiState = value;
                isCurrentlyEnabled = debugSettingsPresenter.watchProvider.getWatchManager().getDemoModeProvider().isCurrentlyEnabled();
                debugStorage = DebugStorage.INSTANCE;
                forceMockFitnessProvider = debugStorage.getForceMockFitnessProvider();
                if (!debugStorage.isSpeedCalibrationEnabled() && !debugSettingsPresenter.watchProvider.getRemoteConfig().getSpeedCalibrationEnabled()) {
                    z = false;
                } else {
                    z = true;
                }
                showWipStuff = debugStorage.getShowWipStuff();
                companion = KronabyApplication.Companion;
            } while (!uiState.compareAndSet(value, DebugUiState.copy$default(debugUiState, null, null, null, null, new DebugSwitchStatus(isCurrentlyEnabled, forceMockFitnessProvider, z, showWipStuff, DebugStorage.getShowWorkoutSessions(companion.getContext()), debugStorage.isKtorHttpLoggingEnabled(), ProviderFactory.getSettingProvider().getAvailability(), debugStorage.getCustomerSupportDevEnvironment(companion.getContext()), debugSettingsPresenter.watchProvider.isBluetoothInDebug(), debugSettingsPresenter.watchProvider.isRssiNotificationActive()), null, null, null, false, 495, null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugSettingsPresenter$updateAllSwitchStates$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
