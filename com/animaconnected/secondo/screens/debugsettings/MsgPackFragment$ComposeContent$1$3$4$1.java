package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: MsgPackFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$ComposeContent$1$3$4$1", f = "MsgPackFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MsgPackFragment$ComposeContent$1$3$4$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $showResult$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackFragment$ComposeContent$1$3$4$1(MutableState<Boolean> mutableState, Continuation<? super MsgPackFragment$ComposeContent$1$3$4$1> continuation) {
        super(1, continuation);
        this.$showResult$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MsgPackFragment$ComposeContent$1$3$4$1(this.$showResult$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean ComposeContent$lambda$10;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState<Boolean> mutableState = this.$showResult$delegate;
            ComposeContent$lambda$10 = MsgPackFragment.ComposeContent$lambda$10(mutableState);
            MsgPackFragment.ComposeContent$lambda$11(mutableState, !ComposeContent$lambda$10);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MsgPackFragment$ComposeContent$1$3$4$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
