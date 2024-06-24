package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.provider.preferences.Preferences;
import com.animaconnected.watch.provider.preferences.WorkoutMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConfigureMetricViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.workout.ConfigureMetricViewModel$sync$2", f = "ConfigureMetricViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ConfigureMetricViewModel$sync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<UIWorkoutMetric> $list;
    final /* synthetic */ SessionType $sessionType;
    int label;
    final /* synthetic */ ConfigureMetricViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigureMetricViewModel$sync$2(List<UIWorkoutMetric> list, ConfigureMetricViewModel configureMetricViewModel, SessionType sessionType, Continuation<? super ConfigureMetricViewModel$sync$2> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = configureMetricViewModel;
        this.$sessionType = sessionType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigureMetricViewModel$sync$2(this.$list, this.this$0, this.$sessionType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Preferences preferences;
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<UIWorkoutMetric> list = this.$list;
            Iterator<UIWorkoutMetric> it = list.iterator();
            int r2 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getMetric() == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    r2++;
                } else {
                    r2 = -1;
                    break;
                }
            }
            List<UIWorkoutMetric> subList = list.subList(0, r2);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = subList.iterator();
            while (it2.hasNext()) {
                WorkoutMetrics metric = ((UIWorkoutMetric) it2.next()).getMetric();
                if (metric != null) {
                    arrayList.add(metric);
                }
            }
            preferences = this.this$0.preference;
            preferences.setMetricsForSessionType(this.$sessionType, arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConfigureMetricViewModel$sync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
