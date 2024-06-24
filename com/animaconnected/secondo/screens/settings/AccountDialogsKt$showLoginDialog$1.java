package com.animaconnected.secondo.screens.settings;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountLogInBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AccountDialogs.kt */
/* loaded from: classes3.dex */
public final class AccountDialogsKt$showLoginDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ ProfileFragment $this_showLoginDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showLoginDialog$1(ProfileFragment profileFragment) {
        super(2);
        this.$this_showLoginDialog = profileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(LoginViewModel loginViewModel, ProfileFragment this_showLoginDialog, DialogInterface dialogInterface) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(loginViewModel, "$loginViewModel");
        Intrinsics.checkNotNullParameter(this_showLoginDialog, "$this_showLoginDialog");
        LiveData<DialogMessage> dialog = loginViewModel.getDialog();
        dialogObserver = AccountDialogsKt.getDialogObserver(this_showLoginDialog);
        dialog.removeObserver(dialogObserver);
        this_showLoginDialog.checkAndUpdateUiState();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountLogInBinding inflate = DialogAccountLogInBinding.inflate(inflater);
        final ProfileFragment profileFragment = this.$this_showLoginDialog;
        final LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        Button btnLoginApple = inflate.btnLoginApple;
        Intrinsics.checkNotNullExpressionValue(btnLoginApple, "btnLoginApple");
        profileFragment.onClick(btnLoginApple, new AccountDialogsKt$showLoginDialog$1$1$1(createLoginViewModel, profileFragment, dialog, null));
        Button btnLoginGoogle = inflate.btnLoginGoogle;
        Intrinsics.checkNotNullExpressionValue(btnLoginGoogle, "btnLoginGoogle");
        profileFragment.onClick(btnLoginGoogle, new AccountDialogsKt$showLoginDialog$1$1$2(createLoginViewModel, profileFragment, dialog, null));
        TextView btnLoginEmail = inflate.btnLoginEmail;
        Intrinsics.checkNotNullExpressionValue(btnLoginEmail, "btnLoginEmail");
        profileFragment.onClick(btnLoginEmail, new AccountDialogsKt$showLoginDialog$1$1$3(dialog, profileFragment, null));
        TextView btnCancel = inflate.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        profileFragment.onClick(btnCancel, new AccountDialogsKt$showLoginDialog$1$1$4(dialog, null));
        LiveData<DialogMessage> dialog2 = createLoginViewModel.getDialog();
        LifecycleOwner viewLifecycleOwner = profileFragment.getViewLifecycleOwner();
        dialogObserver = AccountDialogsKt.getDialogObserver(profileFragment);
        dialog2.observe(viewLifecycleOwner, dialogObserver);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showLoginDialog$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountDialogsKt$showLoginDialog$1.invoke$lambda$1$lambda$0(LoginViewModel.this, profileFragment, dialogInterface);
            }
        });
        return inflate;
    }
}
