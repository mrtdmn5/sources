package com.animaconnected.secondo.behaviour.steps;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: Steps.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.steps.Steps$startCollecting$1", f = "Steps.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Steps$startCollecting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Steps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Steps$startCollecting$1(Steps steps, Continuation<? super Steps$startCollecting$1> continuation) {
        super(2, continuation);
        this.this$0 = steps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Steps$startCollecting$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitnessProvider;
        TimePeriod timePeriod;
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
            timePeriod = this.this$0.periodCollecting;
            CommonFlow<List<StepEntry>> stepsWithResolution = fitnessProvider.getStepsWithResolution(timePeriod, 1);
            final Steps steps = this.this$0;
            FlowCollector<? super List<StepEntry>> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.behaviour.steps.Steps$startCollecting$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<StepEntry>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<StepEntry> list, Continuation<? super Unit> continuation) {
                    MutableStateFlow mutableStateFlow;
                    mutableStateFlow = Steps.this.stepsToday;
                    StepEntry stepEntry = (StepEntry) CollectionsKt___CollectionsKt.firstOrNull((List) list);
                    mutableStateFlow.setValue(new Integer(stepEntry != null ? stepEntry.getSteps() : 0));
                    Steps.this.notifyDataChanged();
                    Steps.this.refreshCollectionIfNeeded();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (stepsWithResolution.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Steps$startCollecting$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
