package com.animaconnected.secondo.behaviour.distress.detail;

import android.view.View;
import android.widget.Button;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DistressFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ View.OnCreateContextMenuListener f$1;

    public /* synthetic */ DistressFragment$$ExternalSyntheticLambda0(Object obj, View.OnCreateContextMenuListener onCreateContextMenuListener, int r3) {
        this.$r8$classId = r3;
        this.f$0 = obj;
        this.f$1 = onCreateContextMenuListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int r0 = this.$r8$classId;
        View.OnCreateContextMenuListener onCreateContextMenuListener = this.f$1;
        Object obj = this.f$0;
        switch (r0) {
            case 0:
                DistressFragment.$r8$lambda$1klNp44VIqlO3qK_V4MgqPp0gB4((Button) obj, (DistressFragment) onCreateContextMenuListener, view);
                return;
            default:
                ConfigurationChecker.m837$r8$lambda$XJmkIaVGUkhoh8ChE0E16GJhGw((ConfigurationChecker.DialogListener) obj, (BottomSheetDialog) onCreateContextMenuListener, view);
                return;
        }
    }
}
