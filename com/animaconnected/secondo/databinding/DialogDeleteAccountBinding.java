package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogDeleteAccountBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnDelete;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    private DialogDeleteAccountBinding(LinearLayout linearLayout, Button button, Button button2, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnDelete = button2;
        this.progressBar = progressBar;
    }

    public static DialogDeleteAccountBinding bind(View view) {
        int r0 = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
        if (button != null) {
            r0 = R.id.btn_delete;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_delete, view);
            if (button2 != null) {
                r0 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                if (progressBar != null) {
                    return new DialogDeleteAccountBinding((LinearLayout) view, button, button2, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_delete_account, viewGroup, false);
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
