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
public final class DialogAccountCreateEmailBinding implements ViewBinding {
    public final Button btnCreate;
    public final LayoutTextinputLoginDialogBinding layoutEmail;
    public final LayoutTextinputLoginPasswordDialogBinding layoutPassword;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    private DialogAccountCreateEmailBinding(LinearLayout linearLayout, Button button, LayoutTextinputLoginDialogBinding layoutTextinputLoginDialogBinding, LayoutTextinputLoginPasswordDialogBinding layoutTextinputLoginPasswordDialogBinding, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.btnCreate = button;
        this.layoutEmail = layoutTextinputLoginDialogBinding;
        this.layoutPassword = layoutTextinputLoginPasswordDialogBinding;
        this.progressBar = progressBar;
    }

    public static DialogAccountCreateEmailBinding bind(View view) {
        int r0 = R.id.btn_create;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_create, view);
        if (button != null) {
            r0 = R.id.layout_email;
            View findChildViewById = ViewBindings.findChildViewById(R.id.layout_email, view);
            if (findChildViewById != null) {
                LayoutTextinputLoginDialogBinding bind = LayoutTextinputLoginDialogBinding.bind(findChildViewById);
                r0 = R.id.layout_password;
                View findChildViewById2 = ViewBindings.findChildViewById(R.id.layout_password, view);
                if (findChildViewById2 != null) {
                    LayoutTextinputLoginPasswordDialogBinding bind2 = LayoutTextinputLoginPasswordDialogBinding.bind(findChildViewById2);
                    r0 = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                    if (progressBar != null) {
                        return new DialogAccountCreateEmailBinding((LinearLayout) view, button, bind, bind2, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountCreateEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountCreateEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_create_email, viewGroup, false);
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
