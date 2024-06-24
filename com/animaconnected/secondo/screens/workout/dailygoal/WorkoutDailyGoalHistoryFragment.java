package com.animaconnected.secondo.screens.workout.dailygoal;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.workout.DailyGoalsViewModel;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WorkoutDailyGoalHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutDailyGoalHistoryFragment extends ComposeFragment {
    private final Lazy featurePathName$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragment$featurePathName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return WorkoutDailyGoalHistoryFragment.this.getString(R.string.health_top_title);
        }
    });
    private final String name = "WorkoutDailyGoalHistoryFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WorkoutDailyGoalHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutDailyGoalHistoryFragment newInstance() {
            return new WorkoutDailyGoalHistoryFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r8) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1338941982);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-878906807);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new DailyGoalsViewModel(ProviderFactory.getWatch().fitness());
            startRestartGroup.updateValue(nextSlot);
        }
        DailyGoalsViewModel dailyGoalsViewModel = (DailyGoalsViewModel) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -878906721);
        if (m == composer$Companion$Empty$1) {
            m = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness()).getGoals();
            startRestartGroup.updateValue(m);
        }
        HealthGoals healthGoals = (HealthGoals) m;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -878906623);
        if (m2 == composer$Companion$Empty$1) {
            m2 = new SnapshotStateList();
            startRestartGroup.updateValue(m2);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) m2;
        startRestartGroup.end(false);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new WorkoutDailyGoalHistoryFragment$ComposeContent$1(this, snapshotStateList, dailyGoalsViewModel, null), startRestartGroup);
        WorkoutDailyGoalHistoryFragmentKt.DailyGoalHistoryScreen(snapshotStateList, healthGoals, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragment$ComposeContent$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WorkoutDailyGoalHistoryFragment.this.getMainController().goBack();
            }
        }, startRestartGroup, 70);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalHistoryFragment$ComposeContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    WorkoutDailyGoalHistoryFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r8 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return (String) this.featurePathName$delegate.getValue();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
