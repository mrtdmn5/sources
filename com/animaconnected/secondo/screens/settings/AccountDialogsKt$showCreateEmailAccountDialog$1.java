package com.animaconnected.secondo.screens.settings;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountCreateEmailBinding;
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
public final class AccountDialogsKt$showCreateEmailAccountDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ ProfileFragment $this_showCreateEmailAccountDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateEmailAccountDialog$1(ProfileFragment profileFragment) {
        super(2);
        this.$this_showCreateEmailAccountDialog = profileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(Job loginJob, Job formValidationJob, Job loadingJob, LoginViewModel loginViewModel, ProfileFragment this_showCreateEmailAccountDialog, DialogInterface dialogInterface) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(loginJob, "$loginJob");
        Intrinsics.checkNotNullParameter(formValidationJob, "$formValidationJob");
        Intrinsics.checkNotNullParameter(loadingJob, "$loadingJob");
        Intrinsics.checkNotNullParameter(loginViewModel, "$loginViewModel");
        Intrinsics.checkNotNullParameter(this_showCreateEmailAccountDialog, "$this_showCreateEmailAccountDialog");
        loginJob.cancel(null);
        formValidationJob.cancel(null);
        loadingJob.cancel(null);
        LiveData<DialogMessage> dialog = loginViewModel.getDialog();
        dialogObserver = AccountDialogsKt.getDialogObserver(this_showCreateEmailAccountDialog);
        dialog.removeObserver(dialogObserver);
        this_showCreateEmailAccountDialog.checkAndUpdateUiState();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountCreateEmailBinding inflate = DialogAccountCreateEmailBinding.inflate(inflater);
        final ProfileFragment profileFragment = this.$this_showCreateEmailAccountDialog;
        final LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        FormValidationViewModel formValidationViewModel = new FormValidationViewModel();
        Button btnCreate = inflate.btnCreate;
        Intrinsics.checkNotNullExpressionValue(btnCreate, "btnCreate");
        ProgressBar progressBar = inflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        Loading loading = new Loading(btnCreate, progressBar, false, 4, null);
        TextInputLayout root = inflate.layoutEmail.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        AccountUtilsKt.initEmailField(root, formValidationViewModel, Hashing.getLifecycleScope(profileFragment));
        TextInputLayout root2 = inflate.layoutPassword.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        AccountUtilsKt.initPasswordField(root2, formValidationViewModel, Hashing.getLifecycleScope(profileFragment));
        Button btnCreate2 = inflate.btnCreate;
        Intrinsics.checkNotNullExpressionValue(btnCreate2, "btnCreate");
        profileFragment.onClick(btnCreate2, new AccountDialogsKt$showCreateEmailAccountDialog$1$1$1(createLoginViewModel, inflate, dialog, null));
        final StandaloneCoroutine launchIn = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showCreateEmailAccountDialog$1$1$loginJob$1(profileFragment, null), createLoginViewModel.getLoginState()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn2 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showCreateEmailAccountDialog$1$1$formValidationJob$1(inflate, null), formValidationViewModel.getState()), Hashing.getLifecycleScope(profileFragment));
        final StandaloneCoroutine launchIn3 = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountDialogsKt$showCreateEmailAccountDialog$1$1$loadingJob$1(loading, null), createLoginViewModel.isLoading()), Hashing.getLifecycleScope(profileFragment));
        LiveData<DialogMessage> dialog2 = createLoginViewModel.getDialog();
        LifecycleOwner viewLifecycleOwner = profileFragment.getViewLifecycleOwner();
        dialogObserver = AccountDialogsKt.getDialogObserver(profileFragment);
        dialog2.observe(viewLifecycleOwner, dialogObserver);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateEmailAccountDialog$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountDialogsKt$showCreateEmailAccountDialog$1.invoke$lambda$1$lambda$0(launchIn, launchIn2, launchIn3, createLoginViewModel, profileFragment, dialogInterface);
            }
        });
        return inflate;
    }
}
