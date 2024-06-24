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
@DebugMetadata(c = "com.amplifyframework.statemachine.StateMachine$send$1", f = "StateMachine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StateMachine$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateMachineEvent $event;
    int label;
    final /* synthetic */ StateMachine<StateType, EnvironmentType> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMachine$send$1(StateMachine<StateType, EnvironmentType> stateMachine, StateMachineEvent stateMachineEvent, Continuation<? super StateMachine$send$1> continuation) {
        super(2, continuation);
        this.this$0 = stateMachine;
        this.$event = stateMachineEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateMachine$send$1(this.this$0, this.$event, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.process(this.$event);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateMachine$send$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
