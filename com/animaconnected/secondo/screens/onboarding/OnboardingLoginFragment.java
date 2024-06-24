package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.auth.AuthProvider;
import com.animaconnected.secondo.databinding.FragmentOnboardingLoginBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Internet;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OnboardingLoginFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingLoginFragment extends BaseOnboardingFragment {
    private FragmentOnboardingLoginBinding binding;
    private LoginViewModel loginViewModel;
    private final String name = "OnboardingLoginFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingLoginFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingLoginFragment newInstance() {
            return new OnboardingLoginFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSignInUnavailable(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        if (ProviderFactory.getWatch().getWatchManager().getDemoModeProvider().isCurrentlyEnabled()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            DisabledFunctionalityDescriptionBottomDialogKt.showSignInDisabledInfoBottomDialog(requireContext);
        } else if (!Internet.INSTANCE.isAvailable()) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            AccountUtilsKt.showDialogInfo$default(requireContext2, DialogMessageKt.getDialogInfo(DialogMessage.NoInternetConnection.INSTANCE), null, 4, null);
        } else {
            Object invoke = function1.invoke(continuation);
            if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return invoke;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loginWithSocialProvider(AuthProvider authProvider, Continuation<? super Unit> continuation) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return Unit.INSTANCE;
        }
        LoginViewModel loginViewModel = this.loginViewModel;
        if (loginViewModel != null) {
            Object signInWithWebUI = loginViewModel.signInWithWebUI(authProvider, activity, continuation);
            if (signInWithWebUI == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return signInWithWebUI;
            }
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
        throw null;
    }

    public static final OnboardingLoginFragment newInstance() {
        return Companion.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onNotNowClick(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onNotNowClick$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onNotNowClick$1 r0 = (com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onNotNowClick$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onNotNowClick$1 r0 = new com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onNotNowClick$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment r0 = (com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment) r0
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
            com.animaconnected.secondo.provider.SigninStorage r5 = new com.animaconnected.secondo.provider.SigninStorage
            android.content.Context r1 = r0.requireContext()
            java.lang.String r2 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r5.<init>(r1)
            r5.setNotNow(r3)
            boolean r5 = r0.isAdded()
            if (r5 == 0) goto L68
            com.animaconnected.secondo.screens.onboarding.OnboardingViewController r5 = r0.getOnboardingViewController()
            r5.clearBackStack()
        L68:
            com.animaconnected.firebase.AppEvents r5 = com.animaconnected.secondo.provider.ProviderFactory.getAppAnalytics()
            r5.accountLoginSkipped()
            com.animaconnected.secondo.screens.onboarding.Onboarding r5 = r0.getOnboarding()
            r5.updateState()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment.onNotNowClick(kotlin.coroutines.Continuation):java.lang.Object");
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
        if (state == Onboarding.State.SIGNIN) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingLoginBinding inflate = FragmentOnboardingLoginBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.loginViewModel = ProviderFactory.createLoginViewModel();
        FragmentOnboardingLoginBinding fragmentOnboardingLoginBinding = this.binding;
        if (fragmentOnboardingLoginBinding != null) {
            Button btnLoginApple = fragmentOnboardingLoginBinding.btnLoginApple;
            Intrinsics.checkNotNullExpressionValue(btnLoginApple, "btnLoginApple");
            onClick(btnLoginApple, new OnboardingLoginFragment$onViewCreated$1$1(this, null));
            Button btnLoginGoogle = fragmentOnboardingLoginBinding.btnLoginGoogle;
            Intrinsics.checkNotNullExpressionValue(btnLoginGoogle, "btnLoginGoogle");
            onClick(btnLoginGoogle, new OnboardingLoginFragment$onViewCreated$1$2(this, null));
            Button tvCreateAccount = fragmentOnboardingLoginBinding.tvCreateAccount;
            Intrinsics.checkNotNullExpressionValue(tvCreateAccount, "tvCreateAccount");
            onClick(tvCreateAccount, new OnboardingLoginFragment$onViewCreated$1$3(this, null));
            TextView tvEmailLogin = fragmentOnboardingLoginBinding.tvEmailLogin;
            Intrinsics.checkNotNullExpressionValue(tvEmailLogin, "tvEmailLogin");
            onClick(tvEmailLogin, new OnboardingLoginFragment$onViewCreated$1$4(this, null));
            TextView tvNotNow = fragmentOnboardingLoginBinding.tvNotNow;
            Intrinsics.checkNotNullExpressionValue(tvNotNow, "tvNotNow");
            onClick(tvNotNow, new OnboardingLoginFragment$onViewCreated$1$5(this, null));
            LoginViewModel loginViewModel = this.loginViewModel;
            if (loginViewModel != null) {
                BaseFragmentUtilsKt.collectSafelyOnStarted(this, loginViewModel.getLoginState(), new Function1<LoginState, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$2

                    /* compiled from: OnboardingLoginFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$2$1", f = "OnboardingLoginFragment.kt", l = {64}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ OnboardingLoginFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(OnboardingLoginFragment onboardingLoginFragment, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = onboardingLoginFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object onNotNowClick;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                OnboardingLoginFragment onboardingLoginFragment = this.this$0;
                                this.label = 1;
                                onNotNowClick = onboardingLoginFragment.onNotNowClick(this);
                                if (onNotNowClick == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LoginState loginState) {
                        invoke2(loginState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LoginState state) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        if (state instanceof LoginState.SignedIn) {
                            LifecycleOwner viewLifecycleOwner = OnboardingLoginFragment.this.getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt.launch$default(Hashing.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(OnboardingLoginFragment.this, null), 3);
                        }
                    }
                });
                LoginViewModel loginViewModel2 = this.loginViewModel;
                if (loginViewModel2 != null) {
                    loginViewModel2.getDialog().observe(getViewLifecycleOwner(), new OnboardingLoginFragment$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$3
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
                            Context requireContext = OnboardingLoginFragment.this.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            Intrinsics.checkNotNull(dialogMessage);
                            AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
                        }
                    }));
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
