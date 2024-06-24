package com.animaconnected.secondo.screens.workout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.watch.workout.WorkoutViewModel;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutHistory.kt */
/* loaded from: classes3.dex */
public final class WorkoutHistory extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "WorkoutHistory";

    /* compiled from: WorkoutHistory.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance() {
            return new WorkoutHistory();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToWorkoutDetailScreen(long j, Rect rect) {
        MainController mainController = getMainController();
        WorkoutDetailsFragment newInstance = WorkoutDetailsFragment.Companion.newInstance(j, true);
        AnimationFactoryKotlinKt.setupAnimVariables(newInstance, FontWeightKt.toAndroidRect(rect), true);
        mainController.gotoRevealedFragment(newInstance);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r11) {
        int r0;
        boolean z;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(453448756);
        if ((r11 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r11;
        } else {
            r0 = r11;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-1484817833);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = new WorkoutViewModel(ProviderFactory.getWatch().fitness());
                startRestartGroup.updateValue(nextSlot);
            }
            WorkoutViewModel workoutViewModel = (WorkoutViewModel) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1484817886);
            int r03 = r0 & 14;
            boolean z2 = true;
            if (r03 == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistory$ComposeContent$2$1
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
                        WorkoutHistory.this.getMainController().goBack();
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            Function0 function0 = (Function0) nextSlot2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1484817740);
            if (r03 != 4) {
                z2 = false;
            }
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (z2 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function2<Long, Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistory$ComposeContent$3$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Long l, Rect rect) {
                        invoke(l.longValue(), rect);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j, Rect cardRect) {
                        Intrinsics.checkNotNullParameter(cardRect, "cardRect");
                        WorkoutHistory.this.goToWorkoutDetailScreen(j, cardRect);
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            WorkoutHistoryKt.SessionHistoryScreen(null, workoutViewModel, function0, (Function2) nextSlot3, startRestartGroup, 64, 1);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistory$ComposeContent$4
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
                    WorkoutHistory.this.ComposeContent(composer2, Strings.updateChangedFlags(r11 | 1));
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
        String string = getString(R.string.health_top_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
