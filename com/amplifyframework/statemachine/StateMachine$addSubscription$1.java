package com.amplifyframework.statemachine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX WARN: Incorrect field signature: TStateType; */
/* compiled from: StateMachine.kt */
@DebugMetadata(c = "com.amplifyframework.statemachine.StateMachine$addSubscription$1", f = "StateMachine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StateMachine$addSubscription$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State $currentState;
    final /* synthetic */ Function1<StateType, Unit> $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TStateType;Lkotlin/Unit;>;TStateType;Lkotlin/coroutines/Continuation<-Lcom/amplifyframework/statemachine/StateMachine$addSubscription$1;>;)V */
    public StateMachine$addSubscription$1(Function1 function1, State state, Continuation continuation) {
        super(2, continuation);
        this.$listener = function1;
        this.$currentState = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateMachine$addSubscription$1(this.$listener, this.$currentState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$listener.invoke(this.$currentState);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateMachine$addSubscription$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
