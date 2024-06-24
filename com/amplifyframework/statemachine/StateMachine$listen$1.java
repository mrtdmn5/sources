package com.amplifyframework.statemachine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StateMachine.kt */
@DebugMetadata(c = "com.amplifyframework.statemachine.StateMachine$listen$1", f = "StateMachine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StateMachine$listen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<StateType, Unit> $listener;
    final /* synthetic */ Function0<Unit> $onSubscribe;
    final /* synthetic */ StateChangeListenerToken $token;
    int label;
    final /* synthetic */ StateMachine<StateType, EnvironmentType> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StateMachine$listen$1(StateMachine<StateType, EnvironmentType> stateMachine, StateChangeListenerToken stateChangeListenerToken, Function1<? super StateType, Unit> function1, Function0<Unit> function0, Continuation<? super StateMachine$listen$1> continuation) {
        super(2, continuation);
        this.this$0 = stateMachine;
        this.$token = stateChangeListenerToken;
        this.$listener = function1;
        this.$onSubscribe = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateMachine$listen$1(this.this$0, this.$token, this.$listener, this.$onSubscribe, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.addSubscription(this.$token, this.$listener, this.$onSubscribe);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateMachine$listen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
