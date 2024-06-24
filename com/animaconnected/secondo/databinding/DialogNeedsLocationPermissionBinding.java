package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogNeedsLocationPermissionBinding implements ViewBinding {
    public final Button btnApprove;
    public final Button btnCancel;
    private final LinearLayout rootView;

    private DialogNeedsLocationPermissionBinding(LinearLayout linearLayout, Button button, Button button2) {
        this.rootView = linearLayout;
        this.btnApprove = button;
        this.btnCancel = button2;
    }

    public static DialogNeedsLocationPermissionBinding bind(View view) {
        int r0 = R.id.btn_approve;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_approve, view);
        if (button != null) {
            r0 = R.id.btn_cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
            if (button2 != null) {
                return new DialogNeedsLocationPermissionBinding((LinearLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogNeedsLocationPermissionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogNeedsLocationPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_needs_location_permission, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
