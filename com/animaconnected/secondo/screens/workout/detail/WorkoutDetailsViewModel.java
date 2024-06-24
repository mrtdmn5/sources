package com.animaconnected.secondo.screens.workout.detail;

import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.MetricItem;
import com.animaconnected.watch.workout.SessionListItem;
import com.animaconnected.watch.workout.WorkoutDataClassesKt;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: WorkoutDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class WorkoutDetailsViewModel {
    public static final int $stable = 8;
    private final Function1<LocationEntry, String> addressFormatter;
    private final MutableStateFlow<AnimationState> animationState;
    private final Function1<Long, String> dateFormatter;
    private final Function1<Integer, String> getString;
    private final SessionListItem session;
    private final Function1<Long, String> timeFormatter;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WorkoutDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class AnimationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationState[] $VALUES;
        public static final AnimationState NOT_STARTED = new AnimationState("NOT_STARTED", 0);
        public static final AnimationState EXPANDED = new AnimationState("EXPANDED", 1);
        public static final AnimationState COLLAPSED = new AnimationState("COLLAPSED", 2);
        public static final AnimationState PLAY_COLLAPSE = new AnimationState("PLAY_COLLAPSE", 3);
        public static final AnimationState PLAY_EXPAND = new AnimationState("PLAY_EXPAND", 4);

        private static final /* synthetic */ AnimationState[] $values() {
            return new AnimationState[]{NOT_STARTED, EXPANDED, COLLAPSED, PLAY_COLLAPSE, PLAY_EXPAND};
        }

        static {
            AnimationState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private AnimationState(String str, int r2) {
        }

        public static EnumEntries<AnimationState> getEntries() {
            return $ENTRIES;
        }

        public static AnimationState valueOf(String str) {
            return (AnimationState) Enum.valueOf(AnimationState.class, str);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) $VALUES.clone();
        }
    }

    /* compiled from: WorkoutDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] r02 = new int[AnimationState.values().length];
            try {
                r02[AnimationState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[AnimationState.EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[AnimationState.COLLAPSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r02[AnimationState.PLAY_COLLAPSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r02[AnimationState.PLAY_EXPAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkoutDetailsViewModel(SessionListItem session, Function1<? super Long, String> dateFormatter, Function1<? super Long, String> timeFormatter, Function1<? super LocationEntry, String> addressFormatter, Function1<? super Integer, String> getString) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(timeFormatter, "timeFormatter");
        Intrinsics.checkNotNullParameter(addressFormatter, "addressFormatter");
        Intrinsics.checkNotNullParameter(getString, "getString");
        this.session = session;
        this.dateFormatter = dateFormatter;
        this.timeFormatter = timeFormatter;
        this.addressFormatter = addressFormatter;
        this.getString = getString;
        this.animationState = StateFlowKt.MutableStateFlow(AnimationState.NOT_STARTED);
    }

    private final List<List<Pair<String, String>>> getListOfMetric() {
        String workoutDetailsViewModelKt;
        List<MetricItem> metricItems = WorkoutDataClassesKt.metricItems(this.session);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(metricItems, 10));
        for (MetricItem metricItem : metricItems) {
            workoutDetailsViewModelKt = WorkoutDetailsViewModelKt.toString(metricItem.getType(), this.getString);
            arrayList.add(new Pair(workoutDetailsViewModelKt, metricItem.getValue()));
        }
        return CollectionsKt___CollectionsKt.chunked(arrayList, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActivityState getActivityState() {
        Pair pair;
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.session.getSessionType().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 == 4) {
                        pair = new Pair(Integer.valueOf(R.drawable.ic_other), StringsExtensionsKt.getAppString(Key.workout_type_other));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    pair = new Pair(Integer.valueOf(R.drawable.ic_bike), StringsExtensionsKt.getAppString(Key.workout_type_bike));
                }
            } else {
                pair = new Pair(Integer.valueOf(R.drawable.ic_walk), StringsExtensionsKt.getAppString(Key.workout_type_walk));
            }
        } else {
            pair = new Pair(Integer.valueOf(R.drawable.ic_run), StringsExtensionsKt.getAppString(Key.workout_type_run));
        }
        return new ActivityState(((Number) pair.first).intValue(), (String) pair.second, this.dateFormatter.invoke(Long.valueOf(this.session.getTimestamp())), (String) this.addressFormatter.invoke(CollectionsKt___CollectionsKt.firstOrNull((List) this.session.getRoute())), this.timeFormatter.invoke(Long.valueOf(this.session.getTimestamp())), getListOfMetric());
    }

    public final MutableStateFlow<AnimationState> getAnimationState() {
        return this.animationState;
    }

    public final boolean getAreElevationEntriesValid() {
        if (this.session.getElevations().size() > 1) {
            return true;
        }
        return false;
    }

    public final boolean getAreHeartEntriesValid() {
        if (this.session.getHeartrates().size() > 1) {
            return true;
        }
        return false;
    }

    public final boolean getAreSplitEntriesValid() {
        return !this.session.getSplits().isEmpty();
    }

    public final void onEndAnimation() {
        int r0 = WhenMappings.$EnumSwitchMapping$1[this.animationState.getValue().ordinal()];
        if (r0 != 1) {
            if (r0 != 2 && r0 != 3) {
                if (r0 != 4) {
                    if (r0 == 5) {
                        this.animationState.setValue(AnimationState.EXPANDED);
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                this.animationState.setValue(AnimationState.COLLAPSED);
                return;
            }
            return;
        }
        this.animationState.setValue(AnimationState.NOT_STARTED);
    }

    public final void onPlayAnimation() {
        int r0 = WhenMappings.$EnumSwitchMapping$1[this.animationState.getValue().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4 && r0 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
                this.animationState.setValue(AnimationState.PLAY_EXPAND);
                return;
            }
            this.animationState.setValue(AnimationState.PLAY_COLLAPSE);
            return;
        }
        this.animationState.setValue(AnimationState.PLAY_EXPAND);
    }
}
