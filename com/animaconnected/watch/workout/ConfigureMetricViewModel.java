package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.provider.preferences.Preferences;
import com.animaconnected.watch.provider.preferences.WorkoutMetrics;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ConfigureMetricViewModel.kt */
/* loaded from: classes3.dex */
public final class ConfigureMetricViewModel {
    private final Preferences preference;

    /* compiled from: ConfigureMetricViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ConfigureMetricViewModel(Preferences preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        this.preference = preference;
    }

    private final List<UIWorkoutMetric> getUIWorkoutMetric(SessionType sessionType) {
        int r11 = WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
        if (r11 != 1 && r11 != 2) {
            if (r11 != 3) {
                if (r11 == 4) {
                    return CollectionsKt__CollectionsKt.listOf((Object[]) new UIWorkoutMetric[]{new UIWorkoutMetric("Elapsed time", WorkoutMetrics.ELAPSED_TIME), new UIWorkoutMetric("Heart rate", WorkoutMetrics.HEART_RATE), new UIWorkoutMetric("Steps", WorkoutMetrics.STEPS), new UIWorkoutMetric("Calories", WorkoutMetrics.CALORIES), new UIWorkoutMetric("👇 Disabled | Enabled ☝️", null)});
                }
                throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt__CollectionsKt.listOf((Object[]) new UIWorkoutMetric[]{new UIWorkoutMetric("Elapsed time", WorkoutMetrics.ELAPSED_TIME), new UIWorkoutMetric("Distance", WorkoutMetrics.DISTANCE), new UIWorkoutMetric("Speed", WorkoutMetrics.SPEED), new UIWorkoutMetric("Heart rate", WorkoutMetrics.HEART_RATE), new UIWorkoutMetric("Calories", WorkoutMetrics.CALORIES), new UIWorkoutMetric("👇 Disabled | Enabled ☝️", null)});
        }
        return CollectionsKt__CollectionsKt.listOf((Object[]) new UIWorkoutMetric[]{new UIWorkoutMetric("Elapsed time", WorkoutMetrics.ELAPSED_TIME), new UIWorkoutMetric("Distance", WorkoutMetrics.DISTANCE), new UIWorkoutMetric("Pace", WorkoutMetrics.PACE), new UIWorkoutMetric("Heart rate", WorkoutMetrics.HEART_RATE), new UIWorkoutMetric("Steps", WorkoutMetrics.STEPS), new UIWorkoutMetric("Calories", WorkoutMetrics.CALORIES), new UIWorkoutMetric("👇 Disabled | Enabled ☝️", null)});
    }

    public final Flow<List<UIWorkoutMetric>> getWorkoutMetrics(SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        final List<UIWorkoutMetric> uIWorkoutMetric = getUIWorkoutMetric(sessionType);
        final CommonFlow<List<WorkoutMetrics>> metricsForSessionType = this.preference.getMetricsForSessionType(sessionType);
        return new Flow<List<? extends UIWorkoutMetric>>() { // from class: com.animaconnected.watch.workout.ConfigureMetricViewModel$getWorkoutMetrics$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.ConfigureMetricViewModel$getWorkoutMetrics$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ List $uiMetrics$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.ConfigureMetricViewModel$getWorkoutMetrics$$inlined$map$1$2", f = "ConfigureMetricViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.ConfigureMetricViewModel$getWorkoutMetrics$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, List list) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$uiMetrics$inlined = list;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x00c2 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0086 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r14, kotlin.coroutines.Continuation r15) {
                    /*
                        Method dump skipped, instructions count: 258
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.ConfigureMetricViewModel$getWorkoutMetrics$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends UIWorkoutMetric>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, uIWorkoutMetric), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public final Object sync(SessionType sessionType, List<UIWorkoutMetric> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.Default, new ConfigureMetricViewModel$sync$2(list, this, sessionType, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
