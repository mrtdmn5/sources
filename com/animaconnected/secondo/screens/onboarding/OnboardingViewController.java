package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.screens.BaseFragment;

/* compiled from: OnboardingViewController.kt */
/* loaded from: classes3.dex */
public interface OnboardingViewController {
    void clearBackStack();

    Onboarding getOnboarding();

    void gotoNextFragment(BaseFragment baseFragment, boolean z);

    void setOnboarding(Onboarding onboarding);
}
