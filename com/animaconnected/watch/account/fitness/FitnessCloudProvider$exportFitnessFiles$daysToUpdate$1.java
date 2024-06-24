package com.animaconnected.watch.account.fitness;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FitnessCloudProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1", f = "FitnessCloudProvider.kt", l = {R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends TimePeriod>>, Object> {
    final /* synthetic */ FitnessQueries $this_exportFitnessFiles;
    final /* synthetic */ TimePeriod $timePeriod;
    Object L$0;
    int label;
    final /* synthetic */ FitnessCloudProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1(FitnessCloudProvider fitnessCloudProvider, TimePeriod timePeriod, FitnessQueries fitnessQueries, Continuation<? super FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = fitnessCloudProvider;
        this.$timePeriod = timePeriod;
        this.$this_exportFitnessFiles = fitnessQueries;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1(this.this$0, this.$timePeriod, this.$this_exportFitnessFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends TimePeriod>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Set<TimePeriod>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List splitToDays;
        Object deletedDays;
        Collection collection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                collection = (Collection) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            splitToDays = this.this$0.splitToDays(this.$timePeriod);
            List list = splitToDays;
            FitnessCloudProvider fitnessCloudProvider = this.this$0;
            FitnessQueries fitnessQueries = this.$this_exportFitnessFiles;
            this.L$0 = list;
            this.label = 1;
            deletedDays = fitnessCloudProvider.getDeletedDays(fitnessQueries, this);
            if (deletedDays == coroutineSingletons) {
                return coroutineSingletons;
            }
            collection = list;
            obj = deletedDays;
        }
        return CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.plus((Iterable) obj, collection));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<TimePeriod>> continuation) {
        return ((FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
