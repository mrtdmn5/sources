package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWaitingProductInfo.kt */
/* loaded from: classes3.dex */
public final class OnboardingWaitingProductInfo extends BaseOnboardingFragment {
    private boolean isBackAllowed;
    private final String name = "OnboardingWaitingProductInfo";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingWaitingProductInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingWaitingProductInfo newInstance() {
            return new OnboardingWaitingProductInfo();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.WAITING_PRODUCT_INFO) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean isBackAllowed() {
        return this.isBackAllowed;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_onboarding_waiting_product_info, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public void setBackAllowed(boolean z) {
        this.isBackAllowed = z;
    }
}
