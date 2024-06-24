package com.animaconnected.watch;

import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthSettingsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.HealthSettingsViewModel$setExerciseGoal$2", f = "HealthSettingsViewModel.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel$setExerciseGoal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $goal;
    int label;
    final /* synthetic */ HealthSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthSettingsViewModel$setExerciseGoal$2(HealthSettingsViewModel healthSettingsViewModel, int r2, Continuation<? super HealthSettingsViewModel$setExerciseGoal$2> continuation) {
        super(2, continuation);
        this.this$0 = healthSettingsViewModel;
        this.$goal = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsViewModel$setExerciseGoal$2(this.this$0, this.$goal, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitnessProvider;
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
            fitnessProvider = this.this$0.fitnessProvider;
            Integer num = new Integer(this.$goal);
            this.label = 1;
            if (FitnessProvider.setGoal$default(fitnessProvider, null, null, num, this, 3, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthSettingsViewModel$setExerciseGoal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
