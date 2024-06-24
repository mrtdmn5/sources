package com.animaconnected.secondo.screens.settings;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountCreateBinding;
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
public final class AccountDialogsKt$showCreateAccountDialog$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ ProfileFragment $this_showCreateAccountDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountDialogsKt$showCreateAccountDialog$1(ProfileFragment profileFragment) {
        super(2);
        this.$this_showCreateAccountDialog = profileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(LoginViewModel loginViewModel, ProfileFragment this_showCreateAccountDialog, DialogInterface dialogInterface) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(loginViewModel, "$loginViewModel");
        Intrinsics.checkNotNullParameter(this_showCreateAccountDialog, "$this_showCreateAccountDialog");
        LiveData<DialogMessage> dialog = loginViewModel.getDialog();
        dialogObserver = AccountDialogsKt.getDialogObserver(this_showCreateAccountDialog);
        dialog.removeObserver(dialogObserver);
        this_showCreateAccountDialog.checkAndUpdateUiState();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
        Observer<? super DialogMessage> dialogObserver;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountCreateBinding inflate = DialogAccountCreateBinding.inflate(inflater);
        final ProfileFragment profileFragment = this.$this_showCreateAccountDialog;
        final LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        Button btnLoginApple = inflate.btnLoginApple;
        Intrinsics.checkNotNullExpressionValue(btnLoginApple, "btnLoginApple");
        profileFragment.onClick(btnLoginApple, new AccountDialogsKt$showCreateAccountDialog$1$1$1(createLoginViewModel, profileFragment, dialog, null));
        Button btnLoginGoogle = inflate.btnLoginGoogle;
        Intrinsics.checkNotNullExpressionValue(btnLoginGoogle, "btnLoginGoogle");
        profileFragment.onClick(btnLoginGoogle, new AccountDialogsKt$showCreateAccountDialog$1$1$2(createLoginViewModel, profileFragment, dialog, null));
        TextView btnCreateAccount = inflate.btnCreateAccount;
        Intrinsics.checkNotNullExpressionValue(btnCreateAccount, "btnCreateAccount");
        profileFragment.onClick(btnCreateAccount, new AccountDialogsKt$showCreateAccountDialog$1$1$3(dialog, profileFragment, null));
        TextView btnCancel = inflate.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        profileFragment.onClick(btnCancel, new AccountDialogsKt$showCreateAccountDialog$1$1$4(dialog, null));
        LiveData<DialogMessage> dialog2 = createLoginViewModel.getDialog();
        LifecycleOwner viewLifecycleOwner = profileFragment.getViewLifecycleOwner();
        dialogObserver = AccountDialogsKt.getDialogObserver(profileFragment);
        dialog2.observe(viewLifecycleOwner, dialogObserver);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$showCreateAccountDialog$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountDialogsKt$showCreateAccountDialog$1.invoke$lambda$1$lambda$0(LoginViewModel.this, profileFragment, dialogInterface);
            }
        });
        return inflate;
    }
}
