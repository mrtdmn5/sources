package com.animaconnected.secondo.screens.debugsettings;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogChangePoolIdBinding;
import com.animaconnected.secondo.provider.PoolIdProvider;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.utils.ViewKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DebugSettingsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugSettingsFragment$changePoolId$1 extends Lambda implements Function2<BottomDialog, LayoutInflater, ViewBinding> {
    final /* synthetic */ PoolIdProvider $poolIdProvider;
    final /* synthetic */ DebugSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsFragment$changePoolId$1(PoolIdProvider poolIdProvider, DebugSettingsFragment debugSettingsFragment) {
        super(2);
        this.$poolIdProvider = poolIdProvider;
        this.this$0 = debugSettingsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$0(PoolIdProvider poolIdProvider, DebugSettingsFragment this$0, String changePoolId, View view) {
        Intrinsics.checkNotNullParameter(poolIdProvider, "$poolIdProvider");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(changePoolId, "$changePoolId");
        poolIdProvider.setOnSandbox(!poolIdProvider.isOnSandbox());
        ViewKt.toast$default((Fragment) this$0, "Start app again and pool id has changed to ".concat(changePoolId), false, 2, (Object) null);
        this$0.requireActivity().finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(BottomDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // kotlin.jvm.functions.Function2
    public final ViewBinding invoke(final BottomDialog dialog, LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogChangePoolIdBinding inflate = DialogChangePoolIdBinding.inflate(inflater);
        final PoolIdProvider poolIdProvider = this.$poolIdProvider;
        final DebugSettingsFragment debugSettingsFragment = this.this$0;
        final String str = poolIdProvider.isOnSandbox() ? "Production" : "Sandbox";
        inflate.dialogTitle.setText("Change pool id to ".concat(str));
        inflate.btnApprove.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$changePoolId$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugSettingsFragment$changePoolId$1.invoke$lambda$2$lambda$0(PoolIdProvider.this, debugSettingsFragment, str, view);
            }
        });
        inflate.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment$changePoolId$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugSettingsFragment$changePoolId$1.invoke$lambda$2$lambda$1(BottomDialog.this, view);
            }
        });
        return inflate;
    }
}
