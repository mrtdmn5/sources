package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordConfirmBinding;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.animaconnected.secondo.screens.settings.PasswordManagementViewModel;
import com.animaconnected.secondo.screens.settings.PasswordState;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.widget.VerificationCodeInputKt;
import com.google.common.collect.Platform;
import io.ktor.http.URLProtocolKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPasswordConfirm.kt */
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordConfirmKt {
    private static final String KEY_EMAIL = "key-email";
    private static final String KEY_NEW_PASSWORD = "key-new-password";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1, kotlin.jvm.internal.Lambda] */
    public static final FragmentOnboardingResetPasswordConfirmBinding setup(final BaseFragment baseFragment, final FragmentOnboardingResetPasswordConfirmBinding fragmentOnboardingResetPasswordConfirmBinding, final String str, String str2, final Function0<Unit> function0) {
        Button btnContinue = fragmentOnboardingResetPasswordConfirmBinding.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        ProgressBar progressBar = fragmentOnboardingResetPasswordConfirmBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        final Loading loading = new Loading(btnContinue, progressBar, false, 4, null);
        final PasswordManagementViewModel passwordManagementViewModel = new PasswordManagementViewModel();
        final FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        fragmentOnboardingResetPasswordConfirmBinding.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(2103954879, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r5v3, types: [com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r5) {
                if ((r5 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final FormValidationViewModel formValidationViewModel2 = FormValidationViewModel.this;
                final PasswordManagementViewModel passwordManagementViewModel2 = passwordManagementViewModel;
                final String str3 = str;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -619685872, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1.1

                    /* compiled from: OnboardingResetPasswordConfirm.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1$1$2", f = "OnboardingResetPasswordConfirm.kt", l = {R.styleable.AppTheme_stepsHistoryNoDataBackgroundDetail}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$1$1$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                        final /* synthetic */ String $email;
                        final /* synthetic */ FormValidationViewModel $formValidationViewModel;
                        final /* synthetic */ PasswordManagementViewModel $viewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(FormValidationViewModel formValidationViewModel, PasswordManagementViewModel passwordManagementViewModel, String str, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.$formValidationViewModel = formValidationViewModel;
                            this.$viewModel = passwordManagementViewModel;
                            this.$email = str;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.$formValidationViewModel, this.$viewModel, this.$email, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
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
                                PasswordManagementViewModel passwordManagementViewModel = this.$viewModel;
                                String str = this.$email;
                                this.label = 1;
                                if (passwordManagementViewModel.sendConfirmationCode(str, this) == coroutineSingletons) {
                                    return coroutineSingletons;
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
                        if ((r14 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        String str4 = (String) Platform.collectAsState(FormValidationViewModel.this.getConfirmationCodeFlow(), composer2).getValue();
                        boolean booleanValue = ((Boolean) Platform.collectAsState(passwordManagementViewModel2.isLoading(), composer2).getValue()).booleanValue();
                        String stringResource = URLProtocolKt.stringResource(com.kronaby.watch.app.R.string.account_send_new_verification_code, composer2);
                        final FormValidationViewModel formValidationViewModel3 = FormValidationViewModel.this;
                        VerificationCodeInputKt.m1634VerificationCodeInput1YH7lEI(null, str4, booleanValue, stringResource, false, 0L, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt.setup.1.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                                invoke2(str5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String code) {
                                Intrinsics.checkNotNullParameter(code, "code");
                                FormValidationViewModel.this.setConfirmationCode(code);
                            }
                        }, new AnonymousClass2(FormValidationViewModel.this, passwordManagementViewModel2, str3, null), composer2, 16777216, 49);
                    }
                }), composer, 6);
            }
        }, true));
        Button btnContinue2 = fragmentOnboardingResetPasswordConfirmBinding.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue2, "btnContinue");
        baseFragment.onClick(btnContinue2, new OnboardingResetPasswordConfirmKt$setup$1$2(passwordManagementViewModel, str, str2, formValidationViewModel, null));
        fragmentOnboardingResetPasswordConfirmBinding.tvCodeSentTo.setText(baseFragment.getString(com.kronaby.watch.app.R.string.account_enter_reset_code, str));
        BaseFragmentUtilsKt.collectSafelyOnStarted(baseFragment, passwordManagementViewModel.getState(), new Function1<PasswordState, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (Intrinsics.areEqual(state, PasswordState.ResetPasswordConfirmed.INSTANCE)) {
                    function0.invoke();
                }
            }
        });
        BaseFragmentUtilsKt.collectSafely$default(baseFragment, FlowExtensionsKt.asCommonFlow(passwordManagementViewModel.isLoading()), null, null, null, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$4
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
        passwordManagementViewModel.getDialog().observe(baseFragment.getViewLifecycleOwner(), new OnboardingResetPasswordConfirmKt$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$5
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
                Context requireContext = BaseFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                Intrinsics.checkNotNull(dialogMessage);
                AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
            }
        }));
        BaseFragmentUtilsKt.collectSafely$default(baseFragment, FlowExtensionsKt.asCommonFlow(formValidationViewModel.isConfirmationCodeValid()), null, null, null, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$setup$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FragmentOnboardingResetPasswordConfirmBinding.this.btnContinue.setEnabled(z);
            }
        }, 14, null);
        AnimatedToolbar toolbar = baseFragment.getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirmKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnboardingResetPasswordConfirmKt.setup$lambda$1$lambda$0(BaseFragment.this, view);
                }
            });
        }
        return fragmentOnboardingResetPasswordConfirmBinding;
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
