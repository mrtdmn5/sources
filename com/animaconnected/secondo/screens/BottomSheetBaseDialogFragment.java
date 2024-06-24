package com.animaconnected.secondo.screens;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetBaseDialogFragment.kt */
/* loaded from: classes3.dex */
public abstract class BottomSheetBaseDialogFragment extends BottomSheetDialogFragment {
    public static final int $stable = 0;

    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public abstract View onCreateDialogView(BottomDialog bottomDialog);

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public BottomDialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        return new BottomDialog(requireContext, new Function1<BottomDialog, View>() { // from class: com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment$onCreateDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final View invoke(BottomDialog it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return BottomSheetBaseDialogFragment.this.onCreateDialogView(it);
            }
        });
    }
}
