package com.animaconnected.secondo.screens;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheet.kt */
/* loaded from: classes3.dex */
public final class BottomDialog extends BottomSheetDialog {
    public static final int $stable = 8;
    private boolean dismissible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:            r2 = r2.getInsetsController();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BottomDialog(android.content.Context r2, kotlin.jvm.functions.Function1<? super com.animaconnected.secondo.screens.BottomDialog, ? extends android.view.View> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "createView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 2132082697(0x7f150009, float:1.9805515E38)
            r1.<init>(r2, r0)
            r2 = 1
            r1.dismissible = r2
            java.lang.Object r2 = r3.invoke(r1)
            android.view.View r2 = (android.view.View) r2
            r1.setContentView(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 < r3) goto L36
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L41
            android.view.WindowInsetsController r2 = androidx.core.view.WindowInsetsControllerCompat$Impl30$$ExternalSyntheticApiModelOutline0.m(r2)
            if (r2 == 0) goto L41
            int r3 = androidx.core.view.WindowInsetsCompat$TypeImpl30$$ExternalSyntheticApiModelOutline0.m()
            androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticApiModelOutline5.m(r2, r3)
            goto L41
        L36:
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L41
            r3 = 1024(0x400, float:1.435E-42)
            r2.setFlags(r3, r3)
        L41:
            com.animaconnected.secondo.screens.BottomDialog$$ExternalSyntheticLambda0 r2 = new com.animaconnected.secondo.screens.BottomDialog$$ExternalSyntheticLambda0
            r2.<init>()
            r1.setOnShowListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.BottomDialog.<init>(android.content.Context, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(final BottomDialog this$0, DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog;
        FrameLayout frameLayout;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CoordinatorLayout coordinatorLayout = null;
        if (dialogInterface instanceof BottomSheetDialog) {
            bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        } else {
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog != null) {
            frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            obj = frameLayout.getParent();
        } else {
            obj = null;
        }
        if (obj instanceof CoordinatorLayout) {
            coordinatorLayout = (CoordinatorLayout) obj;
        }
        if (frameLayout != null && coordinatorLayout != null) {
            this$0.getBehavior().setPeekHeight(frameLayout.getHeight());
            coordinatorLayout.getParent().requestLayout();
            BottomSheetBehavior<FrameLayout> behavior = this$0.getBehavior();
            BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.animaconnected.secondo.screens.BottomDialog$1$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(View bottomSheet, float f) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(View bottomSheet, int r3) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    if (r3 == 5) {
                        BottomDialog.this.dismiss();
                    } else if (r3 == 1 && !BottomDialog.this.getDismissible()) {
                        BottomDialog.this.getBehavior().setState(3);
                    }
                }
            };
            ArrayList<BottomSheetBehavior.BottomSheetCallback> arrayList = behavior.callbacks;
            if (!arrayList.contains(bottomSheetCallback)) {
                arrayList.add(bottomSheetCallback);
            }
            this$0.setCanceledOnTouchOutside(this$0.dismissible);
            this$0.setCancelable(this$0.dismissible);
        }
    }

    public final boolean getDismissible() {
        return this.dismissible;
    }

    public final void setDismissible(boolean z) {
        this.dismissible = z;
        setCanceledOnTouchOutside(z);
        setCancelable(this.dismissible);
    }
}
