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
import com.animaconnected.secondo.screens.CustomToolbar;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingResetPasswordConfirmBinding implements ViewBinding {
    public final Button btnContinue;
    public final ComposeView composeView;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final CustomToolbar toolbar;
    public final TextView tvCodeSentTo;

    private FragmentOnboardingResetPasswordConfirmBinding(LinearLayout linearLayout, Button button, ComposeView composeView, ProgressBar progressBar, CustomToolbar customToolbar, TextView textView) {
        this.rootView = linearLayout;
        this.btnContinue = button;
        this.composeView = composeView;
        this.progressBar = progressBar;
        this.toolbar = customToolbar;
        this.tvCodeSentTo = textView;
    }

    public static FragmentOnboardingResetPasswordConfirmBinding bind(View view) {
        int r0 = R.id.btn_continue;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_continue, view);
        if (button != null) {
            r0 = R.id.compose_view;
            ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(R.id.compose_view, view);
            if (composeView != null) {
                r0 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                if (progressBar != null) {
                    r0 = R.id.toolbar;
                    CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar, view);
                    if (customToolbar != null) {
                        r0 = R.id.tv_code_sent_to;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_code_sent_to, view);
                        if (textView != null) {
                            return new FragmentOnboardingResetPasswordConfirmBinding((LinearLayout) view, button, composeView, progressBar, customToolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOnboardingResetPasswordConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingResetPasswordConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_reset_password_confirm, viewGroup, false);
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
