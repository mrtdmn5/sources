package com.animaconnected.watch;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HealthGoals;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;

/* compiled from: HealthSettingsViewModel.kt */
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel {
    private final CommonFlow<Bedtime> bedtimeFlow;
    private final FitnessProvider fitnessProvider;
    private final HealthGoals goals;
    private final CommonFlow<HealthGoals> goalsFlow;
    private final MutableStateFlow<Bedtime> mutableBedTimeFlow;
    public static final Companion Companion = new Companion(null);
    private static final List<Integer> steps = CollectionsKt___CollectionsKt.toList(RangesKt___RangesKt.step(new IntRange(1000, 30000), 1000));
    private static final List<Integer> stand = CollectionsKt___CollectionsKt.toList(new IntRange(6, 12));
    private static final List<Integer> exercise = CollectionsKt___CollectionsKt.toList(RangesKt___RangesKt.step(new IntRange(15, 120), 5));
    private static final Lazy<BasicStorage> storage$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BasicStorage>() { // from class: com.animaconnected.watch.HealthSettingsViewModel$Companion$storage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BasicStorage invoke() {
            return ServiceLocator.INSTANCE.getStorageFactory().createStorage("health-settings-badges");
        }
    });

    /* compiled from: HealthSettingsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BasicStorage getStorage() {
            return (BasicStorage) HealthSettingsViewModel.storage$delegate.getValue();
        }

        public final List<Integer> getExercise() {
            return HealthSettingsViewModel.exercise;
        }

        public final List<Integer> getStand() {
            return HealthSettingsViewModel.stand;
        }

        public final List<Integer> getSteps() {
            return HealthSettingsViewModel.steps;
        }

        public final Object isSettingsBadgeVisible(Continuation<? super Boolean> continuation) {
            return BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2(null), continuation);
        }

        public final Object setSettingsBadgeVisibility(boolean z, Continuation<? super Unit> continuation) {
            Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2(z, null), continuation);
            if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return withContext;
            }
            return Unit.INSTANCE;
        }

        private Companion() {
        }
    }

    public HealthSettingsViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        Instant.Companion.getClass();
        this.goalsFlow = fitnessProvider.getGoal(Instant.DISTANT_FUTURE.toEpochMilliseconds());
        this.goals = fitnessProvider.getGoalOnce(DateTimeUtilsKt.currentTimeMillis());
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(fitnessProvider.getProfile().getBedtime());
        this.mutableBedTimeFlow = MutableStateFlow;
        this.bedtimeFlow = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
    }

    public final Object getBedTime(Continuation<? super Bedtime> continuation) {
        return BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$getBedTime$2(this, null), continuation);
    }

    public final CommonFlow<Bedtime> getBedtimeFlow() {
        return this.bedtimeFlow;
    }

    public final HealthGoals getGoals() {
        return this.goals;
    }

    public final CommonFlow<HealthGoals> getGoalsFlow() {
        return this.goalsFlow;
    }

    public final Object setBedTime(Bedtime bedtime, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$setBedTime$2(this, bedtime, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setExerciseGoal(int r4, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$setExerciseGoal$2(this, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setStandGoal(int r4, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$setStandGoal$2(this, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object setWalkGoal(int r4, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new HealthSettingsViewModel$setWalkGoal$2(this, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
