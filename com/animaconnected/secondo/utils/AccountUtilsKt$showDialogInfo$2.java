package com.animaconnected.secondo.utils;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogAccountInvalidInformationBinding;
import com.animaconnected.secondo.provider.login.DialogInfo;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AccountUtils.kt */
/* loaded from: classes3.dex */
public final class AccountUtilsKt$showDialogInfo$2 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ DialogInfo $info;
    final /* synthetic */ Function0<Unit> $onClose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountUtilsKt$showDialogInfo$2(DialogInfo dialogInfo, Function0<Unit> function0) {
        super(2);
        this.$info = dialogInfo;
        this.$onClose = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$0(BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(Function0 onClose, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(onClose, "$onClose");
        onClose.invoke();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(final BottomDialog dialog, LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogAccountInvalidInformationBinding inflate = DialogAccountInvalidInformationBinding.inflate(inflater);
        DialogInfo dialogInfo = this.$info;
        final Function0<Unit> function0 = this.$onClose;
        inflate.tvHeading.setText(dialogInfo.getTitle());
        inflate.tvBody.setText(dialogInfo.getBody());
        inflate.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$showDialogInfo$2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountUtilsKt$showDialogInfo$2.invoke$lambda$2$lambda$0(BottomDialog.this, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$showDialogInfo$2$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountUtilsKt$showDialogInfo$2.invoke$lambda$2$lambda$1(Function0.this, dialogInterface);
            }
        });
        return inflate;
    }
}
