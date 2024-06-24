package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogAccountLogInEmailBinding implements ViewBinding {
    public final Button btnLogIn;
    public final LayoutTextinputLoginDialogBinding layoutEmail;
    public final LayoutTextinputLoginPasswordDialogBinding layoutPassword;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView tvLogIn;
    public final Button tvResetPassword;

    private DialogAccountLogInEmailBinding(LinearLayout linearLayout, Button button, LayoutTextinputLoginDialogBinding layoutTextinputLoginDialogBinding, LayoutTextinputLoginPasswordDialogBinding layoutTextinputLoginPasswordDialogBinding, ProgressBar progressBar, TextView textView, Button button2) {
        this.rootView = linearLayout;
        this.btnLogIn = button;
        this.layoutEmail = layoutTextinputLoginDialogBinding;
        this.layoutPassword = layoutTextinputLoginPasswordDialogBinding;
        this.progressBar = progressBar;
        this.tvLogIn = textView;
        this.tvResetPassword = button2;
    }

    public static DialogAccountLogInEmailBinding bind(View view) {
        int r0 = R.id.btn_log_in;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_log_in, view);
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
                        r0 = R.id.tv_log_in;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_log_in, view);
                        if (textView != null) {
                            r0 = R.id.tv_reset_password;
                            Button button2 = (Button) ViewBindings.findChildViewById(R.id.tv_reset_password, view);
                            if (button2 != null) {
                                return new DialogAccountLogInEmailBinding((LinearLayout) view, button, bind, bind2, progressBar, textView, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountLogInEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountLogInEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_log_in_email, viewGroup, false);
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
