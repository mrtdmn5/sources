package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingLoginWithEmailBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.settings.FormUiState;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.animaconnected.watch.FlowExtensionsKt;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OnboardingLoginWithEmailFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingLoginWithEmailFragment extends BaseOnboardingFragment {
    private FragmentOnboardingLoginWithEmailBinding binding;
    private LoginViewModel loginViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static String email = "";
    private static String password = "";
    private final FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
    private final String name = "OnboardingLoginWithEmailFragment";
    private final String featurePathName = "";

    /* compiled from: OnboardingLoginWithEmailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getEmail() {
            return OnboardingLoginWithEmailFragment.email;
        }

        public final String getPassword() {
            return OnboardingLoginWithEmailFragment.password;
        }

        public final OnboardingLoginWithEmailFragment newInstance() {
            return new OnboardingLoginWithEmailFragment();
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OnboardingLoginWithEmailFragment.email = str;
        }

        public final void setPassword(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OnboardingLoginWithEmailFragment.password = str;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onSuccessfulLogin(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onSuccessfulLogin$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onSuccessfulLogin$1 r0 = (com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onSuccessfulLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onSuccessfulLogin$1 r0 = new com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onSuccessfulLogin$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment r0 = (com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4a
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.secondo.screens.onboarding.Onboarding r5 = r4.getOnboarding()
            com.animaconnected.watch.account.profile.ProfileViewModel r5 = r5.getProfileViewModel()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.fetchFitnessConfig(r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            com.animaconnected.secondo.provider.SigninProvider r5 = com.animaconnected.secondo.provider.ProviderFactory.createSigninProvider()
            r5.setSignedIn(r3)
            boolean r5 = r0.isAdded()
            if (r5 == 0) goto L5e
            com.animaconnected.secondo.screens.onboarding.OnboardingViewController r5 = r0.getOnboardingViewController()
            r5.clearBackStack()
        L5e:
            com.animaconnected.secondo.screens.onboarding.Onboarding r5 = r0.getOnboarding()
            r5.updateState()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment.onSuccessfulLogin(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(OnboardingLoginWithEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
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
        return this.featurePathName;
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingLoginWithEmailBinding inflate = FragmentOnboardingLoginWithEmailBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        Button btnForgotPassword = inflate.btnForgotPassword;
        Intrinsics.checkNotNullExpressionValue(btnForgotPassword, "btnForgotPassword");
        onClick(btnForgotPassword, new OnboardingLoginWithEmailFragment$onCreateView$1$1(this, null));
        Button btnContinue = inflate.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        onClick(btnContinue, new OnboardingLoginWithEmailFragment$onCreateView$1$2(this, inflate, null));
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!StringsKt__StringsJVMKt.isBlank(email)) {
            FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding = this.binding;
            if (fragmentOnboardingLoginWithEmailBinding != null) {
                fragmentOnboardingLoginWithEmailBinding.layoutEmail.editText.setText(email);
                email = "";
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        }
        if (!StringsKt__StringsJVMKt.isBlank(password)) {
            FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding2 = this.binding;
            if (fragmentOnboardingLoginWithEmailBinding2 != null) {
                fragmentOnboardingLoginWithEmailBinding2.layoutPassword.etPassword.setText(password);
                password = "";
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.loginViewModel = ProviderFactory.createLoginViewModel();
        FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding = this.binding;
        if (fragmentOnboardingLoginWithEmailBinding != null) {
            TextInputLayout root = fragmentOnboardingLoginWithEmailBinding.layoutEmail.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            AccountUtilsKt.initEmailField(root, this.formValidationViewModel, Hashing.getLifecycleScope(this));
            FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding2 = this.binding;
            if (fragmentOnboardingLoginWithEmailBinding2 != null) {
                TextInputLayout root2 = fragmentOnboardingLoginWithEmailBinding2.layoutPassword.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                AccountUtilsKt.initPasswordField(root2, this.formValidationViewModel, Hashing.getLifecycleScope(this));
                FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding3 = this.binding;
                if (fragmentOnboardingLoginWithEmailBinding3 != null) {
                    Button btnContinue = fragmentOnboardingLoginWithEmailBinding3.btnContinue;
                    Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
                    FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding4 = this.binding;
                    if (fragmentOnboardingLoginWithEmailBinding4 != null) {
                        ProgressBar progressBar = fragmentOnboardingLoginWithEmailBinding4.progressBar;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                        final Loading loading = new Loading(btnContinue, progressBar, false, 4, null);
                        LoginViewModel loginViewModel = this.loginViewModel;
                        if (loginViewModel != null) {
                            BaseFragmentUtilsKt.collectSafely$default(this, FlowExtensionsKt.asCommonFlow(loginViewModel.isLoading()), null, null, null, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$1
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
                            BaseFragmentUtilsKt.launchOnStarted(this, new OnboardingLoginWithEmailFragment$onViewCreated$2(this, null));
                            BaseFragmentUtilsKt.collectSafely$default(this, FlowExtensionsKt.asCommonFlow(this.formValidationViewModel.getState()), null, null, null, new Function1<FormUiState, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$3
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
                                    FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding5;
                                    Intrinsics.checkNotNullParameter(state, "state");
                                    fragmentOnboardingLoginWithEmailBinding5 = OnboardingLoginWithEmailFragment.this.binding;
                                    if (fragmentOnboardingLoginWithEmailBinding5 != null) {
                                        fragmentOnboardingLoginWithEmailBinding5.btnContinue.setEnabled(state.isFormValid());
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        throw null;
                                    }
                                }
                            }, 14, null);
                            LoginViewModel loginViewModel2 = this.loginViewModel;
                            if (loginViewModel2 != null) {
                                loginViewModel2.getDialog().observe(getViewLifecycleOwner(), new OnboardingLoginWithEmailFragment$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$4
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
                                        Context requireContext = OnboardingLoginWithEmailFragment.this.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                        Intrinsics.checkNotNull(dialogMessage);
                                        AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
                                    }
                                }));
                                AnimatedToolbar toolbar = getToolbar();
                                if (toolbar != null) {
                                    toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$$ExternalSyntheticLambda0
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view2) {
                                            OnboardingLoginWithEmailFragment.onViewCreated$lambda$1(OnboardingLoginWithEmailFragment.this, view2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
