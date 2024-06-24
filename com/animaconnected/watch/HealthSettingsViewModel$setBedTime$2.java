package com.animaconnected.watch;

import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: HealthSettingsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.HealthSettingsViewModel$setBedTime$2", f = "HealthSettingsViewModel.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel$setBedTime$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WatchLibResult<? extends Unit, ? extends WatchLibException>>, Object> {
    final /* synthetic */ Bedtime $bedtime;
    int label;
    final /* synthetic */ HealthSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthSettingsViewModel$setBedTime$2(HealthSettingsViewModel healthSettingsViewModel, Bedtime bedtime, Continuation<? super HealthSettingsViewModel$setBedTime$2> continuation) {
        super(2, continuation);
        this.this$0 = healthSettingsViewModel;
        this.$bedtime = bedtime;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsViewModel$setBedTime$2(this.this$0, this.$bedtime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<? extends Unit, ? extends WatchLibException>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super WatchLibResult<Unit, WatchLibException>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
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
            mutableStateFlow = this.this$0.mutableBedTimeFlow;
            mutableStateFlow.setValue(this.$bedtime);
            fitnessProvider = this.this$0.fitnessProvider;
            FitnessProvider.Profile profile = fitnessProvider.getProfile();
            Bedtime bedtime = this.$bedtime;
            this.label = 1;
            obj = profile.setBedtime(bedtime, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return ((HealthSettingsViewModel$setBedTime$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
