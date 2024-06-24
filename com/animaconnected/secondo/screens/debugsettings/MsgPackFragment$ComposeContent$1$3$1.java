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
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$ComposeContent$1$3$1", f = "MsgPackFragment.kt", l = {67}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MsgPackFragment$ComposeContent$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $args$delegate;
    final /* synthetic */ MutableState<String> $cmd$delegate;
    int label;
    final /* synthetic */ MsgPackFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackFragment$ComposeContent$1$3$1(MsgPackFragment msgPackFragment, MutableState<String> mutableState, MutableState<String> mutableState2, Continuation<? super MsgPackFragment$ComposeContent$1$3$1> continuation) {
        super(1, continuation);
        this.this$0 = msgPackFragment;
        this.$cmd$delegate = mutableState;
        this.$args$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MsgPackFragment$ComposeContent$1$3$1(this.this$0, this.$cmd$delegate, this.$args$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String ComposeContent$lambda$1;
        String ComposeContent$lambda$4;
        Object write;
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
            MsgPackFragment msgPackFragment = this.this$0;
            ComposeContent$lambda$1 = MsgPackFragment.ComposeContent$lambda$1(this.$cmd$delegate);
            ComposeContent$lambda$4 = MsgPackFragment.ComposeContent$lambda$4(this.$args$delegate);
            this.label = 1;
            write = msgPackFragment.write(ComposeContent$lambda$1, ComposeContent$lambda$4, this);
            if (write == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MsgPackFragment$ComposeContent$1$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
