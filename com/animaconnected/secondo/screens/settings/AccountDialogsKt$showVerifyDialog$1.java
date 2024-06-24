package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountVerifyBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: AccountDialogs.kt */
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showVerifyDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ ProfileFragment $this_showVerifyDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showVerifyDialog$1(ProfileFragment profileFragment) {
        super(2);
        this.$this_showVerifyDialog = profileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2(Job loginJob, Job formValidationJob, Job loadingJob, LoginViewModel loginViewModel, ProfileFragment this_showVerifyDialog, DialogInterface dialogInterface) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(loginJob, "$loginJob");
        Intrinsics.checkNotNullParameter(formValidationJob, "$formValidationJob");
        Intrinsics.checkNotNullParameter(loadingJob, "$loadingJob");
        Intrinsics.checkNotNullParameter(loginViewModel, "$loginViewModel");
        Intrinsics.checkNotNullParameter(this_showVerifyDialog, "$this_showVerifyDialog");
        loginJob.cancel(null);
        formValidationJob.cancel(null);
        loadingJob.cancel(null);
        LiveData<DialogMessage> dialog = loginViewModel.getDialog();
        dialogObserver = AccountDialogsKt.getDialogObserver(this_showVerifyDialog);
        dialog.removeObserver(dialogObserver);
        this_showVerifyDialog.checkAndUpdateUiState();
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
        Observer<? super DialogMessage> dialogObserver;
        View decorView;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountVerifyBinding inflate = DialogAccountVerifyBinding.inflate(inflater);
        final ProfileFragment profileFragment = this.$this_showVerifyDialog;
        final LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        final FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        Button btnContinue = inflate.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        ProgressBar progressBar = inflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        Loading loading = new Loading(btnContinue, progressBar, false, 4, null);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            Object context = profileFragment.getContext();
            ViewTreeViewModelStoreOwner.set(decorView, context instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) context : null);
            Object context2 = profileFragment.getContext();
            ViewTreeLifecycleOwner.set(decorView, context2 instanceof LifecycleOwner ? (LifecycleOwner) context2 : null);
            Object context3 = profileFragment.getContext();
            ViewTreeSavedStateRegistryOwner.set(decorView, context3 instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) context3 : null);
        }
        inflate.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1400715589, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v3, types: [com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r4) {
                if ((r4 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final FormValidationViewModel formValidationViewModel2 = FormValidationViewModel.this;
                final LoginViewModel loginViewModel = createLoginViewModel;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -1109233386, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1.1

                    /* compiled from: AccountDialogs.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1$1$2", f = "AccountDialogs.kt", l = {200}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$1$2$1$1$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                        final /* synthetic */ FormValidationViewModel $formValidationVm;
                        final /* synthetic */ LoginViewModel $loginViewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(FormValidationViewModel formValidationViewModel, LoginViewModel loginViewModel, Continuation<? super AnonymousClass2> continuation) {
                            super(1, continuation);
                            this.$formValidationVm = formValidationViewModel;
                            this.$loginViewModel = loginViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Continuation<?> continuation) {
                            return new AnonymousClass2(this.$formValidationVm, this.$loginViewModel, continuation);
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
                                this.$formValidationVm.setConfirmationCode("");
                                LoginViewModel loginViewModel = this.$loginViewModel;
                                this.label = 1;
                                if (loginViewModel.resendCode(this) == coroutineSingletons) {
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
                        String str = (String) Platform.collectAsState(FormValidationViewModel.this.getConfirmationCodeFlow(), composer2).getValue();
                        boolean booleanValue = ((Boolean) Platform.collectAsState(loginViewModel.isLoading(), composer2).getValue()).booleanValue();
                        String stringResource = URLProtocolKt.stringResource(R.string.account_send_new_verification_code, composer2);
                        long m174getSurface0d7_KjU = ((Colors) composer2.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
                        final FormValidationViewModel formValidationViewModel3 = FormValidationViewModel.this;
                        VerificationCodeInputKt.m1634VerificationCodeInput1YH7lEI(null, str, booleanValue, stringResource, true, m174getSurface0d7_KjU, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt.showVerifyDialog.1.1.2.1.1.1
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
                        }, new AnonymousClass2(FormValidationViewModel.this, loginViewModel, null), composer2, 16801792, 1);
                    }
                }), composer, 6);
            }
        }, true));
        Button btnContinue2 = inflate.btnContinue;
        Intrinsics.checkNotNullExpressionValue(btnContinue2, "btnContinue");
        profileFragment.onClick(btnContinue2, new AccountDialogsKt$showVerifyDialog$1$1$3(createLoginViewModel, formValidationViewModel, null));
        TextView textView = inflate.textCheckEmailDescription;
        Context requireContext = profileFragment.requireContext();
        Context requireContext2 = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        textView.setText(requireContext.getString(R.string.account_check_your_email_verification_code, new SigninStorage(requireContext2).getEmail()));
        final StandaloneCoroutine launchIn = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showVerifyDialog$1$1$loginJob$1(dialog, null), createLoginViewModel.getLoginState()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn2 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showVerifyDialog$1$1$formValidationJob$1(inflate, null), formValidationViewModel.isConfirmationCodeValid()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn3 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showVerifyDialog$1$1$loadingJob$1(loading, null), createLoginViewModel.isLoading()), Hashing.getLifecycleScope(profileFragment));
        LiveData<DialogMessage> dialog2 = createLoginViewModel.getDialog();
        LifecycleOwner viewLifecycleOwner = profileFragment.getViewLifecycleOwner();
        dialogObserver = AccountDialogsKt.getDialogObserver(profileFragment);
        dialog2.observe(viewLifecycleOwner, dialogObserver);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showVerifyDialog$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountDialogsKt$showVerifyDialog$1.invoke$lambda$3$lambda$2(launchIn, launchIn2, launchIn3, createLoginViewModel, profileFragment, dialogInterface);
            }
        });
        return inflate;
    }
}
