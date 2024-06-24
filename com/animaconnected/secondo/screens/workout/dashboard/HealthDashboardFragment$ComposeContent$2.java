package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.runtime.State;
import com.animaconnected.watch.workout.DashboardViewModel;
import com.animaconnected.watch.workout.HealthOnboardingState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthDashboardFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$2", f = "HealthDashboardFragment.kt", l = {67, 68, 69, 71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthDashboardFragment$ComposeContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DashboardViewModel $dashboardVm;
    final /* synthetic */ HealthOnboardingUIState $onboarding;
    final /* synthetic */ State<HealthOnboardingState> $onboardingState$delegate;
    int label;

    /* compiled from: HealthDashboardFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[HealthOnboardingState.values().length];
            try {
                r0[HealthOnboardingState.Workout.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[HealthOnboardingState.Metric.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[HealthOnboardingState.LetsGo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[HealthOnboardingState.InteractionComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HealthDashboardFragment$ComposeContent$2(HealthOnboardingUIState healthOnboardingUIState, DashboardViewModel dashboardViewModel, State<? extends HealthOnboardingState> state, Continuation<? super HealthDashboardFragment$ComposeContent$2> continuation) {
        super(2, continuation);
        this.$onboarding = healthOnboardingUIState;
        this.$dashboardVm = dashboardViewModel;
        this.$onboardingState$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthDashboardFragment$ComposeContent$2(this.$onboarding, this.$dashboardVm, this.$onboardingState$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HealthOnboardingState ComposeContent$lambda$10;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1 && r1 != 2 && r1 != 3) {
                if (r1 == 4) {
                    ResultKt.throwOnFailure(obj);
                    this.$dashboardVm.onboardingDone();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ComposeContent$lambda$10 = HealthDashboardFragment.ComposeContent$lambda$10(this.$onboardingState$delegate);
        int r7 = WhenMappings.$EnumSwitchMapping$0[ComposeContent$lambda$10.ordinal()];
        if (r7 != 1) {
            if (r7 != 2) {
                if (r7 != 3) {
                    if (r7 == 4) {
                        HealthOnboardingUIState healthOnboardingUIState = this.$onboarding;
                        this.label = 4;
                        if (healthOnboardingUIState.scrollToTop(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        this.$dashboardVm.onboardingDone();
                    }
                } else {
                    HealthOnboardingUIState healthOnboardingUIState2 = this.$onboarding;
                    this.label = 3;
                    if (healthOnboardingUIState2.scrollToBottomCard(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                HealthOnboardingUIState healthOnboardingUIState3 = this.$onboarding;
                this.label = 2;
                if (healthOnboardingUIState3.scrollToMetric(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            HealthOnboardingUIState healthOnboardingUIState4 = this.$onboarding;
            this.label = 1;
            if (healthOnboardingUIState4.scrollToWorkout(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthDashboardFragment$ComposeContent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
