package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordSendCodeBinding;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.FormUiState;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.screens.settings.PasswordManagementViewModel;
import com.animaconnected.secondo.screens.settings.PasswordState;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.animaconnected.watch.FlowExtensionsKt;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.Hashing;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: OnboardingResetPasswordSendCode.kt */
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordSendCodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentOnboardingResetPasswordSendCodeBinding setup(final BaseFragment baseFragment, final FragmentOnboardingResetPasswordSendCodeBinding fragmentOnboardingResetPasswordSendCodeBinding, final Function1<? super String, Unit> function1) {
        PasswordManagementViewModel passwordManagementViewModel = new PasswordManagementViewModel();
        FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        Button btnContinue = fragmentOnboardingResetPasswordSendCodeBinding.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        ProgressBar progressBar = fragmentOnboardingResetPasswordSendCodeBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        final Loading loading = new Loading(btnContinue, progressBar, false, 4, null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        TextInputLayout root = fragmentOnboardingResetPasswordSendCodeBinding.layoutEmail.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        AccountUtilsKt.initEmailField(root, formValidationViewModel, Hashing.getLifecycleScope(baseFragment));
        EditText editText = fragmentOnboardingResetPasswordSendCodeBinding.layoutEmail.getRoot().getEditText();
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$$ExternalSyntheticLambda0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int r3, KeyEvent keyEvent) {
                    boolean z;
                    z = OnboardingResetPasswordSendCodeKt.setup$lambda$2$lambda$0(FragmentOnboardingResetPasswordSendCodeBinding.this, textView, r3, keyEvent);
                    return z;
                }
            });
        }
        Button btnContinue2 = fragmentOnboardingResetPasswordSendCodeBinding.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue2, "btnContinue");
        baseFragment.onClick(btnContinue2, new OnboardingResetPasswordSendCodeKt$setup$1$2(ref$ObjectRef, fragmentOnboardingResetPasswordSendCodeBinding, passwordManagementViewModel, null));
        BaseFragmentUtilsKt.collectSafely$default(baseFragment, passwordManagementViewModel.getState(), null, null, null, new Function1<PasswordState, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$setup$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PasswordState passwordState) {
                invoke2(passwordState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PasswordState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (Intrinsics.areEqual(state, PasswordState.ConfirmationCodeSent.INSTANCE)) {
                    function1.invoke(ref$ObjectRef.element);
                }
            }
        }, 14, null);
        BaseFragmentUtilsKt.collectSafely$default(baseFragment, FlowExtensionsKt.asCommonFlow(passwordManagementViewModel.isLoading()), null, null, null, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$setup$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Loading.this.invalidate(z);
            }
        }, 14, null);
        BaseFragmentUtilsKt.collectSafely$default(baseFragment, FlowExtensionsKt.asCommonFlow(formValidationViewModel.getState()), null, null, null, new Function1<FormUiState, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$setup$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormUiState formUiState) {
                invoke2(formUiState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormUiState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                FragmentOnboardingResetPasswordSendCodeBinding.this.btnContinue.setEnabled(state.isEmailValid());
            }
        }, 14, null);
        passwordManagementViewModel.getDialog().observe(baseFragment.getViewLifecycleOwner(), new OnboardingResetPasswordSendCodeKt$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$setup$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogMessage dialogMessage) {
                invoke2(dialogMessage);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DialogMessage dialogMessage) {
                if (dialogMessage instanceof DialogMessage.ConfirmResetPassword) {
                    return;
                }
                Context requireContext = BaseFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                Intrinsics.checkNotNull(dialogMessage);
                AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
            }
        }));
        AnimatedToolbar toolbar = baseFragment.getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordSendCodeKt$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnboardingResetPasswordSendCodeKt.setup$lambda$2$lambda$1(BaseFragment.this, view);
                }
            });
        }
        return fragmentOnboardingResetPasswordSendCodeBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setup$lambda$2$lambda$0(FragmentOnboardingResetPasswordSendCodeBinding this_apply, TextView textView, int r2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (r2 == 6) {
            this_apply.layoutEmail.getRoot().clearFocus();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setup$lambda$2$lambda$1(BaseFragment this_setup, View view) {
        Intrinsics.checkNotNullParameter(this_setup, "$this_setup");
        FragmentActivity activity = this_setup.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
