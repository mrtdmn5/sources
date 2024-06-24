package com.animaconnected.secondo.screens.workout.dailygoal;

import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.workout.DailyGoalsProgressItem;
import com.animaconnected.watch.workout.DailyGoalsViewModel;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDailyGoalDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutDailyGoalDetailFragment extends ComposeFragment implements Dismissible {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "WorkoutDailyGoalDetailFragment";

    /* compiled from: WorkoutDailyGoalDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutDailyGoalDetailFragment newInstance() {
            return new WorkoutDailyGoalDetailFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r14) {
        int r0;
        boolean z;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(574490646);
        if ((r14 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r14;
        } else {
            r0 = r14;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(181598592);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = new DailyGoalsViewModel(ProviderFactory.getWatch().fitness());
                startRestartGroup.updateValue(nextSlot);
            }
            DailyGoalsViewModel dailyGoalsViewModel = (DailyGoalsViewModel) nextSlot;
            Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 181598678);
            if (m == composer$Companion$Empty$1) {
                m = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness());
                startRestartGroup.updateValue(m);
            }
            startRestartGroup.end(false);
            HealthGoals goals = ((HealthSettingsViewModel) m).getGoals();
            DailyGoalsProgressItem dailyGoalsProgressItem = (DailyGoalsProgressItem) Platform.collectAsState(dailyGoalsViewModel.observeDailyGoalsToday(), WorkoutDailyGoalDetailFragmentKt.access$getEmptyProgress$p(), null, startRestartGroup, 2).getValue();
            List list = (List) Platform.collectAsState(dailyGoalsViewModel.observeDailyGoalsLastWeek(), EmptyList.INSTANCE, null, startRestartGroup, 2).getValue();
            startRestartGroup.startReplaceableGroup(181599137);
            int r03 = r0 & 14;
            boolean z2 = true;
            if (r03 == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragment$ComposeContent$1$1
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
                        WorkoutDailyGoalDetailFragment.this.getMainController().goBack();
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            Function0 function0 = (Function0) nextSlot2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(181599195);
            if (r03 != 4) {
                z2 = false;
            }
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (z2 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragment$ComposeContent$2$1
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
                        WorkoutDailyGoalDetailFragment.this.getMainController().gotoNextFragment(WorkoutDailyGoalHistoryFragment.Companion.newInstance());
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            WorkoutDailyGoalDetailFragmentKt.access$DailyGoalsDetailScreen(null, dailyGoalsProgressItem, goals, list, function0, (Function0) nextSlot3, startRestartGroup, 4672, 1);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dailygoal.WorkoutDailyGoalDetailFragment$ComposeContent$3
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
                    WorkoutDailyGoalDetailFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r14 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        View viewAnimContainer = getBinding().viewAnimContainer;
        Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
        AnimationFactoryKotlinKt.exitCardRevealAnim(this, root, viewAnimContainer, getCardBounds(), listener);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
