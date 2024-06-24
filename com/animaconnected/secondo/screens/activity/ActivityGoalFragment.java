package com.animaconnected.secondo.screens.activity;

import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.res.Resources_androidKt;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment;
import com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragment;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ActivityGoalFragment.kt */
/* loaded from: classes3.dex */
public final class ActivityGoalFragment extends ComposeFragment implements ActivityStepGoalDialogFragmentCallback {
    private static final String HAS_DETAIL_STYLE_KEY_ID = "hasDetailStyleKeyId";
    private static final String IS_ONBOARDING_ACTIVE = "isOnboardingActiveKey";
    private static final String PARENT_NAME_KEY_ID = "parentNameKeyId";
    private final MutableStateFlow<String> currentStepGoal;
    private boolean hasDetailStyle;
    private boolean isOnboarding;
    private final String name = "ActivityGoalFragment";
    private String parentName;
    private final StepFormatHelper stepFormatHelper;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ActivityGoalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance(boolean z, String str, boolean z2) {
            ActivityGoalFragment activityGoalFragment = new ActivityGoalFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ActivityGoalFragment.HAS_DETAIL_STYLE_KEY_ID, z);
            bundle.putString(ActivityGoalFragment.PARENT_NAME_KEY_ID, str);
            bundle.putBoolean(ActivityGoalFragment.IS_ONBOARDING_ACTIVE, z2);
            activityGoalFragment.setArguments(bundle);
            return activityGoalFragment;
        }

        private Companion() {
        }
    }

    public ActivityGoalFragment() {
        StepFormatHelper stepFormatHelper = new StepFormatHelper(Locale.getDefault());
        this.stepFormatHelper = stepFormatHelper;
        this.currentStepGoal = StateFlowKt.MutableStateFlow(stepFormatHelper.formatNumber(getCurrentStepsGoal()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentStepsGoal() {
        return ProviderFactory.getWatch().fitness().getGoalOnce(DateTimeUtilsKt.currentTimeMillis()).getSteps();
    }

    public static final BaseFragment newInstance(boolean z, String str, boolean z2) {
        return Companion.newInstance(z, str, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r12) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1518528506);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-1905039983);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = new StepFormatHelper(Locale.getDefault());
            startRestartGroup.updateValue(nextSlot);
        }
        StepFormatHelper stepFormatHelper = (StepFormatHelper) nextSlot;
        startRestartGroup.end(false);
        String recommendedStepsGoalFromFormatted = stepFormatHelper.getRecommendedStepsGoalFromFormatted();
        Intrinsics.checkNotNullExpressionValue(recommendedStepsGoalFromFormatted, "getRecommendedStepsGoalFromFormatted(...)");
        String recommendedStepsGoalToFormatted = stepFormatHelper.getRecommendedStepsGoalToFormatted();
        Intrinsics.checkNotNullExpressionValue(recommendedStepsGoalToFormatted, "getRecommendedStepsGoalToFormatted(...)");
        String string = Resources_androidKt.resources(startRestartGroup).getString(R.string.activity_activate_set_goal, Arrays.copyOf(new Object[]{recommendedStepsGoalFromFormatted, recommendedStepsGoalToFormatted}, 2));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        boolean z = this.hasDetailStyle;
        boolean z2 = this.isOnboarding;
        String str = (String) FlowExtKt.collectAsStateWithLifecycle(this.currentStepGoal, startRestartGroup).getValue();
        Intrinsics.checkNotNull(str);
        ActivityGoalFragmentKt.StepGoalScreen(str, z, string, z2, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoalFragment$ComposeContent$1
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
                ActivityGoalFragment.this.getMainController().goBack();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoalFragment$ComposeContent$2
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
                boolean z3;
                String str2;
                MainController mainController = ActivityGoalFragment.this.getMainController();
                ActivityGoogleFitFragment.Companion companion = ActivityGoogleFitFragment.Companion;
                z3 = ActivityGoalFragment.this.hasDetailStyle;
                str2 = ActivityGoalFragment.this.parentName;
                mainController.gotoNextFragment(companion.newInstance(z3, str2));
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoalFragment$ComposeContent$3
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
                int currentStepsGoal;
                ActivityStepGoalDialogFragment.Companion companion = ActivityStepGoalDialogFragment.Companion;
                currentStepsGoal = ActivityGoalFragment.this.getCurrentStepsGoal();
                companion.newInstance(currentStepsGoal).show(ActivityGoalFragment.this.getChildFragmentManager(), (String) null);
            }
        }, startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoalFragment$ComposeContent$4
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
                    ActivityGoalFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r12 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hasDetailStyle = arguments.getBoolean(HAS_DETAIL_STYLE_KEY_ID);
            this.parentName = arguments.getString(PARENT_NAME_KEY_ID);
            this.isOnboarding = arguments.getBoolean(IS_ONBOARDING_ACTIVE);
        }
    }

    @Override // com.animaconnected.secondo.screens.activity.ActivityStepGoalDialogFragmentCallback
    public void onStepGoalPicked(int r6) {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), Dispatchers.IO, null, new ActivityGoalFragment$onStepGoalPicked$1(r6, null), 2);
        MutableStateFlow<String> mutableStateFlow = this.currentStepGoal;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), this.stepFormatHelper.formatNumber(r6)));
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        if (view2 != null) {
            view2.setTranslationZ(100.0f);
        }
    }
}
