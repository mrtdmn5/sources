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
import com.animaconnected.secondo.databinding.FragmentOnboardingCreateAccountBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: OnboardingCreateAccountFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment extends BaseOnboardingFragment {
    private FragmentOnboardingCreateAccountBinding binding;
    private LoginViewModel loginViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
    private final String name = "OnboardingCreateAccountFragment";
    private final String featurePathName = "";

    /* compiled from: OnboardingCreateAccountFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingCreateAccountFragment newInstance() {
            return new OnboardingCreateAccountFragment();
        }

        private Companion() {
        }
    }

    public static final OnboardingCreateAccountFragment newInstance() {
        return Companion.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSuccessfulLogin() {
        ProviderFactory.createSigninProvider().setSignedIn(true);
        if (isAdded()) {
            getOnboardingViewController().clearBackStack();
        }
        getOnboarding().updateState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(OnboardingCreateAccountFragment this$0, View view) {
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
        FragmentOnboardingCreateAccountBinding inflate = FragmentOnboardingCreateAccountBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Button btnContinue = inflate.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        onClick(btnContinue, new OnboardingCreateAccountFragment$onCreateView$1$1(this, null));
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.loginViewModel = ProviderFactory.createLoginViewModel();
        FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding = this.binding;
        if (fragmentOnboardingCreateAccountBinding != null) {
            TextInputLayout root = fragmentOnboardingCreateAccountBinding.layoutEmail.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            AccountUtilsKt.initEmailField(root, this.formValidationViewModel, Hashing.getLifecycleScope(this));
            FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding2 = this.binding;
            if (fragmentOnboardingCreateAccountBinding2 != null) {
                TextInputLayout root2 = fragmentOnboardingCreateAccountBinding2.layoutPassword.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                AccountUtilsKt.initPasswordField(root2, this.formValidationViewModel, Hashing.getLifecycleScope(this));
                FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding3 = this.binding;
                if (fragmentOnboardingCreateAccountBinding3 != null) {
                    Button btnContinue = fragmentOnboardingCreateAccountBinding3.btnContinue;
                    Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
                    FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding4 = this.binding;
                    if (fragmentOnboardingCreateAccountBinding4 != null) {
                        ProgressBar progressBar = fragmentOnboardingCreateAccountBinding4.progressBar;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                        Loading loading = new Loading(btnContinue, progressBar, false, 4, null);
                        LoginViewModel loginViewModel = this.loginViewModel;
                        if (loginViewModel != null) {
                            FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingCreateAccountFragment$onViewCreated$1(loading, null), loginViewModel.isLoading()), Hashing.getLifecycleScope(this));
                            LoginViewModel loginViewModel2 = this.loginViewModel;
                            if (loginViewModel2 != null) {
                                FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingCreateAccountFragment$onViewCreated$2(this, null), loginViewModel2.getLoginState()), new OnboardingCreateAccountFragment$onViewCreated$3(null)), Hashing.getLifecycleScope(this));
                                LoginViewModel loginViewModel3 = this.loginViewModel;
                                if (loginViewModel3 != null) {
                                    loginViewModel3.getDialog().observe(getViewLifecycleOwner(), new OnboardingCreateAccountFragment$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onViewCreated$4
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
                                            Context requireContext = OnboardingCreateAccountFragment.this.requireContext();
                                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                            Intrinsics.checkNotNull(dialogMessage);
                                            AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
                                        }
                                    }));
                                    FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingCreateAccountFragment$onViewCreated$5(this, null), this.formValidationViewModel.getState()), new OnboardingCreateAccountFragment$onViewCreated$6(null)), Hashing.getLifecycleScope(this));
                                    AnimatedToolbar toolbar = getToolbar();
                                    if (toolbar != null) {
                                        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$$ExternalSyntheticLambda0
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view2) {
                                                OnboardingCreateAccountFragment.onViewCreated$lambda$1(OnboardingCreateAccountFragment.this, view2);
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
