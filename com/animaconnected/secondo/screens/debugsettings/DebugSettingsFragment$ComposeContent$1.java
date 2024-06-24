package com.animaconnected.secondo.screens.debugsettings;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$ComposeContent$1", f = "DebugSettingsFragment.kt", l = {58, 59}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugSettingsFragment$ComposeContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsFragment$ComposeContent$1(DebugSettingsFragment debugSettingsFragment, Continuation<? super DebugSettingsFragment$ComposeContent$1> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugSettingsFragment$ComposeContent$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugSettingsPresenter debugSettingsPresenter;
        DebugSettingsPresenter debugSettingsPresenter2;
        DebugSettingsPresenter debugSettingsPresenter3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            debugSettingsPresenter = this.this$0.presenter;
            if (debugSettingsPresenter != null) {
                debugSettingsPresenter.updateBluetoothStatus();
                debugSettingsPresenter2 = this.this$0.presenter;
                if (debugSettingsPresenter2 != null) {
                    this.label = 1;
                    if (debugSettingsPresenter2.updateAllSwitchStates(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        }
        debugSettingsPresenter3 = this.this$0.presenter;
        if (debugSettingsPresenter3 != null) {
            this.label = 2;
            if (debugSettingsPresenter3.updateTokens(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugSettingsFragment$ComposeContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
