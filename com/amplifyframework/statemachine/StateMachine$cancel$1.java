package com.amplifyframework.statemachine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StateMachine.kt */
@DebugMetadata(c = "com.amplifyframework.statemachine.StateMachine$cancel$1", f = "StateMachine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StateMachine$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateChangeListenerToken $token;
    int label;
    final /* synthetic */ StateMachine<StateType, EnvironmentType> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMachine$cancel$1(StateMachine<StateType, EnvironmentType> stateMachine, StateChangeListenerToken stateChangeListenerToken, Continuation<? super StateMachine$cancel$1> continuation) {
        super(2, continuation);
        this.this$0 = stateMachine;
        this.$token = stateChangeListenerToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateMachine$cancel$1(this.this$0, this.$token, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.removeSubscription(this.$token);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateMachine$cancel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
