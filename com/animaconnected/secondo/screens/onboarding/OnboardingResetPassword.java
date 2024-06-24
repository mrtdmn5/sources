package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordBinding;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirm;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPassword.kt */
/* loaded from: classes3.dex */
public final class OnboardingResetPassword extends BaseOnboardingFragment {
    private FragmentOnboardingResetPasswordBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "OnboardingResetPasswordSendCode";
    private String email = "";

    /* compiled from: OnboardingResetPassword.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingResetPassword newInstance(String email) {
            Intrinsics.checkNotNullParameter(email, "email");
            OnboardingResetPassword onboardingResetPassword = new OnboardingResetPassword();
            Bundle bundle = new Bundle();
            bundle.putString("key-email", email);
            onboardingResetPassword.setArguments(bundle);
            return onboardingResetPassword;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        return R.anim.exit_to_left;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return "";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopEnterAnimRes() {
        return R.anim.enter_from_left;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopExitAnimRes() {
        return R.anim.exit_to_right;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.SIGNIN) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key-email", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.email = string;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingResetPasswordBinding inflate = FragmentOnboardingResetPasswordBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentOnboardingResetPasswordBinding fragmentOnboardingResetPasswordBinding = this.binding;
        if (fragmentOnboardingResetPasswordBinding != null) {
            OnboardingResetPasswordKt.setup(this, fragmentOnboardingResetPasswordBinding, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPassword$onViewCreated$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String newPassword) {
                    String str;
                    Intrinsics.checkNotNullParameter(newPassword, "newPassword");
                    OnboardingViewController onboardingViewController = OnboardingResetPassword.this.getOnboardingViewController();
                    OnboardingResetPasswordConfirm.Companion companion = OnboardingResetPasswordConfirm.Companion;
                    str = OnboardingResetPassword.this.email;
                    onboardingViewController.gotoNextFragment(companion.newInstance(newPassword, str), true);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }
}
