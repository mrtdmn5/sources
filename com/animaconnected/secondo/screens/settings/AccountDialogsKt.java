package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.settings.profile.ProfileFragment;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountDialogs.kt */
/* loaded from: classes3.dex */
public final class AccountDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_dialogObserver_$lambda$0(ProfileFragment this_dialogObserver, DialogMessage message) {
        Intrinsics.checkNotNullParameter(this_dialogObserver, "$this_dialogObserver");
        Intrinsics.checkNotNullParameter(message, "message");
        Context requireContext = this_dialogObserver.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(message), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Observer<DialogMessage> getDialogObserver(final ProfileFragment profileFragment) {
        return new Observer() { // from class: com.animaconnected.secondo.screens.settings.AccountDialogsKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountDialogsKt._get_dialogObserver_$lambda$0(ProfileFragment.this, (DialogMessage) obj);
            }
        };
    }

    public static final void showCreateAccountDialog(ProfileFragment profileFragment) {
        Intrinsics.checkNotNullParameter(profileFragment, "<this>");
        Context requireContext = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new AccountDialogsKt$showCreateAccountDialog$1(profileFragment)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCreateEmailAccountDialog(ProfileFragment profileFragment) {
        Context requireContext = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new AccountDialogsKt$showCreateEmailAccountDialog$1(profileFragment)).show();
    }

    public static final void showLoginDialog(ProfileFragment profileFragment) {
        Intrinsics.checkNotNullParameter(profileFragment, "<this>");
        Context requireContext = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new AccountDialogsKt$showLoginDialog$1(profileFragment)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoginEmailDialog(ProfileFragment profileFragment) {
        Context requireContext = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new AccountDialogsKt$showLoginEmailDialog$1(profileFragment)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showVerifyDialog(ProfileFragment profileFragment) {
        Context requireContext = profileFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new AccountDialogsKt$showVerifyDialog$1(profileFragment)).show();
    }
}
