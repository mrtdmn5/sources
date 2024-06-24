package com.amplifyframework.statemachine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConcurrentEffectExecutor.kt */
@DebugMetadata(c = "com.amplifyframework.statemachine.ConcurrentEffectExecutor$execute$1$1", f = "ConcurrentEffectExecutor.kt", l = {26}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ConcurrentEffectExecutor$execute$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Action $action;
    final /* synthetic */ Environment $environment;
    final /* synthetic */ EventDispatcher $eventDispatcher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcurrentEffectExecutor$execute$1$1(Action action, EventDispatcher eventDispatcher, Environment environment, Continuation<? super ConcurrentEffectExecutor$execute$1$1> continuation) {
        super(2, continuation);
        this.$action = action;
        this.$eventDispatcher = eventDispatcher;
        this.$environment = environment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConcurrentEffectExecutor$execute$1$1(this.$action, this.$eventDispatcher, this.$environment, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            Action action = this.$action;
            EventDispatcher eventDispatcher = this.$eventDispatcher;
            Environment environment = this.$environment;
            this.label = 1;
            if (action.execute(eventDispatcher, environment, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConcurrentEffectExecutor$execute$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
