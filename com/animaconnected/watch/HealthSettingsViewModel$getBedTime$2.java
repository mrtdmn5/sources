package com.animaconnected.watch;

import com.animaconnected.watch.fitness.Bedtime;
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
@DebugMetadata(c = "com.animaconnected.watch.HealthSettingsViewModel$getBedTime$2", f = "HealthSettingsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel$getBedTime$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bedtime>, Object> {
    int label;
    final /* synthetic */ HealthSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthSettingsViewModel$getBedTime$2(HealthSettingsViewModel healthSettingsViewModel, Continuation<? super HealthSettingsViewModel$getBedTime$2> continuation) {
        super(2, continuation);
        this.this$0 = healthSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsViewModel$getBedTime$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitnessProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            fitnessProvider = this.this$0.fitnessProvider;
            return fitnessProvider.getProfile().getBedtime();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bedtime> continuation) {
        return ((HealthSettingsViewModel$getBedTime$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
