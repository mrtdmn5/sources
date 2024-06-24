package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogChangePoolIdBinding implements ViewBinding {
    public final Button btnApprove;
    public final Button btnCancel;
    public final TextView dialogTitle;
    private final LinearLayout rootView;

    private DialogChangePoolIdBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.rootView = linearLayout;
        this.btnApprove = button;
        this.btnCancel = button2;
        this.dialogTitle = textView;
    }

    public static DialogChangePoolIdBinding bind(View view) {
        int r0 = R.id.btn_approve;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_approve, view);
        if (button != null) {
            r0 = R.id.btn_cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
            if (button2 != null) {
                r0 = R.id.dialog_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dialog_title, view);
                if (textView != null) {
                    return new DialogChangePoolIdBinding((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogChangePoolIdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChangePoolIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_change_pool_id, viewGroup, false);
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
