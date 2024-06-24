package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingVerifyAccountBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.widget.VerificationCodeInputKt;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: OnboardingVerifyAccountFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingVerifyAccountFragment extends BaseOnboardingFragment {
    private FragmentOnboardingVerifyAccountBinding binding;
    private LoginViewModel loginViewModel;
    private final String name = "OnboardingVerifyAccountFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingVerifyAccountFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingVerifyAccountFragment newInstance() {
            return new OnboardingVerifyAccountFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToPairingScreen() {
        ProviderFactory.createSigninProvider().setSignedIn(true);
        if (isAdded()) {
            getOnboardingViewController().clearBackStack();
        }
        getOnboarding().updateState();
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
        FragmentOnboardingVerifyAccountBinding inflate = FragmentOnboardingVerifyAccountBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        final FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        this.loginViewModel = ProviderFactory.createLoginViewModel();
        FragmentOnboardingVerifyAccountBinding fragmentOnboardingVerifyAccountBinding = this.binding;
        if (fragmentOnboardingVerifyAccountBinding != null) {
            Button btnContinue = fragmentOnboardingVerifyAccountBinding.btnContinue;
            Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
            FragmentOnboardingVerifyAccountBinding fragmentOnboardingVerifyAccountBinding2 = this.binding;
            if (fragmentOnboardingVerifyAccountBinding2 != null) {
                ProgressBar progressBar = fragmentOnboardingVerifyAccountBinding2.progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                Loading loading = new Loading(btnContinue, progressBar, false);
                FragmentOnboardingVerifyAccountBinding fragmentOnboardingVerifyAccountBinding3 = this.binding;
                if (fragmentOnboardingVerifyAccountBinding3 != null) {
                    fragmentOnboardingVerifyAccountBinding3.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(382533819, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r4v3, types: [com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1$1, kotlin.jvm.internal.Lambda] */
                        public final void invoke(Composer composer, int r4) {
                            if ((r4 & 11) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                            final FormValidationViewModel formValidationViewModel2 = FormValidationViewModel.this;
                            final OnboardingVerifyAccountFragment onboardingVerifyAccountFragment = this;
                            ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 669807628, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1.1

                                /* compiled from: OnboardingVerifyAccountFragment.kt */
                                @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1$1$2", f = "OnboardingVerifyAccountFragment.kt", l = {58}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$1$1$1$2, reason: invalid class name */
                                /* loaded from: classes3.dex */
                                public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                                    final /* synthetic */ FormValidationViewModel $formValidationViewModel;
                                    int label;
                                    final /* synthetic */ OnboardingVerifyAccountFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass2(FormValidationViewModel formValidationViewModel, OnboardingVerifyAccountFragment onboardingVerifyAccountFragment, Continuation<? super AnonymousClass2> continuation) {
                                        super(1, continuation);
                                        this.$formValidationViewModel = formValidationViewModel;
                                        this.this$0 = onboardingVerifyAccountFragment;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Continuation<?> continuation) {
                                        return new AnonymousClass2(this.$formValidationViewModel, this.this$0, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        LoginViewModel loginViewModel;
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
                                            this.$formValidationViewModel.setConfirmationCode("");
                                            loginViewModel = this.this$0.loginViewModel;
                                            if (loginViewModel != null) {
                                                this.label = 1;
                                                if (loginViewModel.resendCode(this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                                                throw null;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                public final void invoke(Composer composer2, int r14) {
                                    LoginViewModel loginViewModel;
                                    if ((r14 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    String str = (String) Platform.collectAsState(FormValidationViewModel.this.getConfirmationCodeFlow(), composer2).getValue();
                                    loginViewModel = onboardingVerifyAccountFragment.loginViewModel;
                                    if (loginViewModel != null) {
                                        boolean booleanValue = ((Boolean) Platform.collectAsState(loginViewModel.isLoading(), composer2).getValue()).booleanValue();
                                        String stringResource = URLProtocolKt.stringResource(R.string.account_send_new_verification_code, composer2);
                                        final FormValidationViewModel formValidationViewModel3 = FormValidationViewModel.this;
                                        VerificationCodeInputKt.m1634VerificationCodeInput1YH7lEI(null, str, booleanValue, stringResource, false, 0L, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment.onViewCreated.1.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                                invoke2(str2);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String code) {
                                                Intrinsics.checkNotNullParameter(code, "code");
                                                FormValidationViewModel.this.setConfirmationCode(code);
                                            }
                                        }, new AnonymousClass2(FormValidationViewModel.this, onboardingVerifyAccountFragment, null), composer2, 16777216, 49);
                                        return;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                                    throw null;
                                }
                            }), composer, 6);
                        }
                    }, true));
                    Button btnContinue2 = fragmentOnboardingVerifyAccountBinding3.btnContinue;
                    Intrinsics.checkNotNullExpressionValue(btnContinue2, "btnContinue");
                    onClick(btnContinue2, new OnboardingVerifyAccountFragment$onViewCreated$1$2(this, formValidationViewModel, null));
                    TextView textView = fragmentOnboardingVerifyAccountBinding3.textCheckEmailDescription;
                    Context context = view.getContext();
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    textView.setText(context.getString(R.string.account_check_your_email_verification_code, new SigninStorage(context2).getEmail()));
                    LoginViewModel loginViewModel = this.loginViewModel;
                    if (loginViewModel != null) {
                        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingVerifyAccountFragment$onViewCreated$2(loading, null), loginViewModel.isLoading()), Hashing.getLifecycleScope(this));
                        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingVerifyAccountFragment$onViewCreated$3(this, null), formValidationViewModel.isConfirmationCodeValid()), Hashing.getLifecycleScope(this));
                        LoginViewModel loginViewModel2 = this.loginViewModel;
                        if (loginViewModel2 != null) {
                            FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingVerifyAccountFragment$onViewCreated$4(this, null), loginViewModel2.getLoginState()), new OnboardingVerifyAccountFragment$onViewCreated$5(this, null)), Hashing.getLifecycleScope(this));
                            LoginViewModel loginViewModel3 = this.loginViewModel;
                            if (loginViewModel3 != null) {
                                loginViewModel3.getDialog().observe(getViewLifecycleOwner(), new OnboardingVerifyAccountFragment$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$6
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
                                        Context requireContext = OnboardingVerifyAccountFragment.this.requireContext();
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
}
