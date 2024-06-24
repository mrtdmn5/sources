package com.animaconnected.secondo.screens.settings;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountLogInEmailBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Loading;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.Hashing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: AccountDialogs.kt */
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showLoginEmailDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ ProfileFragment $this_showLoginEmailDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showLoginEmailDialog$1(ProfileFragment profileFragment) {
        super(2);
        this.$this_showLoginEmailDialog = profileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(Job loginJob, Job formValidationJob, Job loadingJob, LoginViewModel loginViewModel, ProfileFragment this_showLoginEmailDialog, DialogInterface dialogInterface) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(loginJob, "$loginJob");
        Intrinsics.checkNotNullParameter(formValidationJob, "$formValidationJob");
        Intrinsics.checkNotNullParameter(loadingJob, "$loadingJob");
        Intrinsics.checkNotNullParameter(loginViewModel, "$loginViewModel");
        Intrinsics.checkNotNullParameter(this_showLoginEmailDialog, "$this_showLoginEmailDialog");
        loginJob.cancel(null);
        formValidationJob.cancel(null);
        loadingJob.cancel(null);
        LiveData<DialogMessage> dialog = loginViewModel.getDialog();
        dialogObserver = AccountDialogsKt.getDialogObserver(this_showLoginEmailDialog);
        dialog.removeObserver(dialogObserver);
        this_showLoginEmailDialog.checkAndUpdateUiState();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountLogInEmailBinding inflate = DialogAccountLogInEmailBinding.inflate(inflater);
        final ProfileFragment profileFragment = this.$this_showLoginEmailDialog;
        final LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        Button btnLogIn = inflate.btnLogIn;
        Intrinsics.checkNotNullExpressionValue(btnLogIn, "btnLogIn");
        ProgressBar progressBar = inflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        Loading loading = new Loading(btnLogIn, progressBar, false, 4, null);
        TextInputLayout root = inflate.layoutEmail.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        AccountUtilsKt.initEmailField(root, formValidationViewModel, Hashing.getLifecycleScope(profileFragment));
        TextInputLayout root2 = inflate.layoutPassword.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        AccountUtilsKt.initPasswordField(root2, formValidationViewModel, Hashing.getLifecycleScope(profileFragment));
        Button tvResetPassword = inflate.tvResetPassword;
        Intrinsics.checkNotNullExpressionValue(tvResetPassword, "tvResetPassword");
        profileFragment.onClick(tvResetPassword, new AccountDialogsKt$showLoginEmailDialog$1$1$1(dialog, profileFragment, null));
        Button btnLogIn2 = inflate.btnLogIn;
        Intrinsics.checkNotNullExpressionValue(btnLogIn2, "btnLogIn");
        profileFragment.onClick(btnLogIn2, new AccountDialogsKt$showLoginEmailDialog$1$1$2(createLoginViewModel, inflate, dialog, null));
        final StandaloneCoroutine launchIn = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showLoginEmailDialog$1$1$loginJob$1(profileFragment, null), createLoginViewModel.getLoginState()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn2 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showLoginEmailDialog$1$1$formValidationJob$1(inflate, null), formValidationViewModel.getState()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn3 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showLoginEmailDialog$1$1$loadingJob$1(loading, null), createLoginViewModel.isLoading()), Hashing.getLifecycleScope(profileFragment));
        LiveData<DialogMessage> dialog2 = createLoginViewModel.getDialog();
        LifecycleOwner viewLifecycleOwner = profileFragment.getViewLifecycleOwner();
        dialogObserver = AccountDialogsKt.getDialogObserver(profileFragment);
        dialog2.observe(viewLifecycleOwner, dialogObserver);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showLoginEmailDialog$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountDialogsKt$showLoginEmailDialog$1.invoke$lambda$1$lambda$0(launchIn, launchIn2, launchIn3, createLoginViewModel, profileFragment, dialogInterface);
            }
        });
        return inflate;
    }
}
