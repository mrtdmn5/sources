package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogAccountVerifyBinding implements ViewBinding {
    public final Button btnContinue;
    public final ComposeView composeView;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView textCheckEmailDescription;

    private DialogAccountVerifyBinding(LinearLayout linearLayout, Button button, ComposeView composeView, ProgressBar progressBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnContinue = button;
        this.composeView = composeView;
        this.progressBar = progressBar;
        this.textCheckEmailDescription = textView;
    }

    public static DialogAccountVerifyBinding bind(View view) {
        int r0 = R.id.btn_continue;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_continue, view);
        if (button != null) {
            r0 = R.id.compose_view;
            ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(R.id.compose_view, view);
            if (composeView != null) {
                r0 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                if (progressBar != null) {
                    r0 = R.id.text_check_email_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.text_check_email_description, view);
                    if (textView != null) {
                        return new DialogAccountVerifyBinding((LinearLayout) view, button, composeView, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountVerifyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountVerifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_verify, viewGroup, false);
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
