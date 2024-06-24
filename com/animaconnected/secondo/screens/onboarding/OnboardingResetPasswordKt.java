package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordBinding;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.Hashing;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: OnboardingResetPassword.kt */
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordKt {
    private static final String KEY_EMAIL = "key-email";

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentOnboardingResetPasswordBinding setup(final BaseFragment baseFragment, FragmentOnboardingResetPasswordBinding fragmentOnboardingResetPasswordBinding, Function1<? super String, Unit> function1) {
        FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        TextInputLayout root = fragmentOnboardingResetPasswordBinding.layoutPassword.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        AccountUtilsKt.initPasswordField(root, formValidationViewModel, Hashing.getLifecycleScope(baseFragment));
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingResetPasswordKt$setup$1$1(fragmentOnboardingResetPasswordBinding, null), formValidationViewModel.getState()), new OnboardingResetPasswordKt$setup$1$2(null)), Hashing.getLifecycleScope(baseFragment));
        Button btnSave = fragmentOnboardingResetPasswordBinding.btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
        baseFragment.onClick(btnSave, new OnboardingResetPasswordKt$setup$1$3(function1, fragmentOnboardingResetPasswordBinding, null));
        AnimatedToolbar toolbar = baseFragment.getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnboardingResetPasswordKt.setup$lambda$1$lambda$0(BaseFragment.this, view);
                }
            });
        }
        return fragmentOnboardingResetPasswordBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setup$lambda$1$lambda$0(BaseFragment this_setup, View view) {
        Intrinsics.checkNotNullParameter(this_setup, "$this_setup");
        FragmentActivity activity = this_setup.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
