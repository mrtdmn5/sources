package com.animaconnected.secondo.screens.onboarding;

import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseOnboardingFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseOnboardingFragment extends BaseFragment {
    public static final int $stable = 8;
    private boolean isBackAllowed = true;

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public int getEnterAnimRes(Onboarding.State fromState) {
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        return R.anim.onboarding_enter;
    }

    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        return R.anim.onboarding_exit;
    }

    public final Onboarding getOnboarding() {
        return getOnboardingViewController().getOnboarding();
    }

    public final OnboardingViewController getOnboardingViewController() {
        OnboardingViewController onboardingViewController;
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof OnboardingViewController) {
            onboardingViewController = (OnboardingViewController) activity;
        } else {
            onboardingViewController = null;
        }
        if (onboardingViewController != null) {
            return onboardingViewController;
        }
        throw new RuntimeException("Containing Activity " + getActivity() + " needs to implement OnboardingViewController");
    }

    public int getPopEnterAnimRes() {
        return R.anim.none;
    }

    public int getPopExitAnimRes() {
        return R.anim.none;
    }

    public abstract boolean handlesState(Onboarding.State state);

    public boolean isBackAllowed() {
        return this.isBackAllowed;
    }

    public final boolean isOnboarding() {
        return getActivity() instanceof OnboardingViewController;
    }

    public void setBackAllowed(boolean z) {
        this.isBackAllowed = z;
    }

    public void foundOneDeviceWhenScanning() {
    }

    public void updateUI() {
    }
}
