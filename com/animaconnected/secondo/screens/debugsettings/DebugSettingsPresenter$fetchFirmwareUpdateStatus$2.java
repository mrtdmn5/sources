package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fetchFirmwareUpdateStatus$2", f = "DebugSettingsPresenter.kt", l = {191}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$fetchFirmwareUpdateStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$fetchFirmwareUpdateStatus$2(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$fetchFirmwareUpdateStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugSettingsPresenter$fetchFirmwareUpdateStatus$2 debugSettingsPresenter$fetchFirmwareUpdateStatus$2 = new DebugSettingsPresenter$fetchFirmwareUpdateStatus$2(this.this$0, continuation);
        debugSettingsPresenter$fetchFirmwareUpdateStatus$2.L$0 = obj;
        return debugSettingsPresenter$fetchFirmwareUpdateStatus$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        CoroutineScope coroutineScope2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    LogKt.warn$default((Object) coroutineScope, DebugSettingsPresenter.TAG, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fetchFirmwareUpdateStatus$2$updateStatus$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Firmware update check failed";
                        }
                    }, 4, (Object) null);
                    return "FW status failed";
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                Future<Boolean> hasCloudNewerFirmware = ProviderFactory.getWatchAppUpdateProvider().hasCloudNewerFirmware(this.this$0.watchProvider);
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object suspending = FutureCoroutineKt.getSuspending(hasCloudNewerFirmware, this);
                if (suspending == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope2 = coroutineScope3;
                obj = suspending;
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                LogKt.warn$default((Object) coroutineScope, DebugSettingsPresenter.TAG, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$fetchFirmwareUpdateStatus$2$updateStatus$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Firmware update check failed";
                    }
                }, 4, (Object) null);
                return "FW status failed";
            }
        }
        if (((Boolean) obj).booleanValue()) {
            return "FW available";
        }
        return "FW latest";
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((DebugSettingsPresenter$fetchFirmwareUpdateStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
