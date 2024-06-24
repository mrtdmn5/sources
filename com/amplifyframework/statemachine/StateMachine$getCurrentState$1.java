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

/* compiled from: StateMachine.kt */
@DebugMetadata(c = "com.amplifyframework.statemachine.StateMachine$getCurrentState$1", f = "StateMachine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StateMachine$getCurrentState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<StateType, Unit> $completion;
    int label;
    final /* synthetic */ StateMachine<StateType, EnvironmentType> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StateMachine$getCurrentState$1(Function1<? super StateType, Unit> function1, StateMachine<StateType, EnvironmentType> stateMachine, Continuation<? super StateMachine$getCurrentState$1> continuation) {
        super(2, continuation);
        this.$completion = function1;
        this.this$0 = stateMachine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateMachine$getCurrentState$1(this.$completion, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        State state;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<StateType, Unit> function1 = this.$completion;
            state = ((StateMachine) this.this$0).currentState;
            function1.invoke(state);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateMachine$getCurrentState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
