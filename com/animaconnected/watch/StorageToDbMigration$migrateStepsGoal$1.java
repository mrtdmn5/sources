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

/* compiled from: StorageToDbMigration.kt */
@DebugMetadata(c = "com.animaconnected.watch.StorageToDbMigration$migrateStepsGoal$1", f = "StorageToDbMigration.kt", l = {208}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StorageToDbMigration$migrateStepsGoal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chosenValue;
    final /* synthetic */ FitnessProvider $fitness;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageToDbMigration$migrateStepsGoal$1(FitnessProvider fitnessProvider, int r2, Continuation<? super StorageToDbMigration$migrateStepsGoal$1> continuation) {
        super(2, continuation);
        this.$fitness = fitnessProvider;
        this.$chosenValue = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StorageToDbMigration$migrateStepsGoal$1(this.$fitness, this.$chosenValue, continuation);
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
            FitnessProvider fitnessProvider = this.$fitness;
            Integer num = new Integer(this.$chosenValue);
            this.label = 1;
            if (FitnessProvider.setGoal$default(fitnessProvider, num, null, null, this, 6, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StorageToDbMigration$migrateStepsGoal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
