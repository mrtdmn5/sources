package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.calibration.CalibrationFragment;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingCalibrationInitiationFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingCalibrationInitiationFragment extends BaseOnboardingFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "CalibrationInitiation";

    /* compiled from: OnboardingCalibrationInitiationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingCalibrationInitiationFragment newInstance() {
            return new OnboardingCalibrationInitiationFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$0(OnboardingCalibrationInitiationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboardingViewController().gotoNextFragment(CalibrationFragment.Companion.newInstance(true), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$1(OnboardingCalibrationInitiationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboarding().setCalibrationDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$2(LottieAnimationView lottieAnimationView, ProgressBar progressBar, LottieComposition lottieComposition) {
        if (lottieComposition != null) {
            lottieAnimationView.setComposition(lottieComposition);
        }
        progressBar.setVisibility(4);
        lottieAnimationView.setVisibility(0);
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        if (toState == Onboarding.State.CALIBRATION) {
            return R.anim.exit_to_left;
        }
        return super.getExitAnimRes(toState, z);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.CALIBRATION) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_calibration_initiation, viewGroup, false);
        ((Button) inflate.findViewById(R.id.start_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingCalibrationInitiationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingCalibrationInitiationFragment.onCreateView$lambda$3$lambda$0(OnboardingCalibrationInitiationFragment.this, view);
            }
        });
        ((Button) inflate.findViewById(R.id.skip_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingCalibrationInitiationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingCalibrationInitiationFragment.onCreateView$lambda$3$lambda$1(OnboardingCalibrationInitiationFragment.this, view);
            }
        });
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.setup_progressbar);
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.lottie_animation_view);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        Lottie.loadAnimation(requireContext, LottieFile.CalibrationAnimation).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingCalibrationInitiationFragment$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                OnboardingCalibrationInitiationFragment.onCreateView$lambda$3$lambda$2(LottieAnimationView.this, progressBar, (LottieComposition) obj);
            }
        });
        return inflate;
    }
}
