package com.animaconnected.secondo.screens.activity;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ActivityGoalFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.activity.ActivityGoalFragment$onStepGoalPicked$1", f = "ActivityGoalFragment.kt", l = {90}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ActivityGoalFragment$onStepGoalPicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $stepsGoal;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityGoalFragment$onStepGoalPicked$1(int r1, Continuation<? super ActivityGoalFragment$onStepGoalPicked$1> continuation) {
        super(2, continuation);
        this.$stepsGoal = r1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityGoalFragment$onStepGoalPicked$1(this.$stepsGoal, continuation);
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
            FitnessProvider fitness = ProviderFactory.getWatch().fitness();
            Integer num = new Integer(this.$stepsGoal);
            this.label = 1;
            if (FitnessProvider.setGoal$default(fitness, num, null, null, this, 6, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityGoalFragment$onStepGoalPicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
