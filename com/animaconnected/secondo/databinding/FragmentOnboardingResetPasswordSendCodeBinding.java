package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingResetPasswordSendCodeBinding implements ViewBinding {
    public final Button btnContinue;
    public final LayoutTextinputLoginBinding layoutEmail;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final CustomToolbar toolbar;

    private FragmentOnboardingResetPasswordSendCodeBinding(LinearLayout linearLayout, Button button, LayoutTextinputLoginBinding layoutTextinputLoginBinding, ProgressBar progressBar, CustomToolbar customToolbar) {
        this.rootView = linearLayout;
        this.btnContinue = button;
        this.layoutEmail = layoutTextinputLoginBinding;
        this.progressBar = progressBar;
        this.toolbar = customToolbar;
    }

    public static FragmentOnboardingResetPasswordSendCodeBinding bind(View view) {
        int r0 = R.id.btn_continue;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_continue, view);
        if (button != null) {
            r0 = R.id.layout_email;
            View findChildViewById = ViewBindings.findChildViewById(R.id.layout_email, view);
            if (findChildViewById != null) {
                LayoutTextinputLoginBinding bind = LayoutTextinputLoginBinding.bind(findChildViewById);
                r0 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                if (progressBar != null) {
                    r0 = R.id.toolbar;
                    CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar, view);
                    if (customToolbar != null) {
                        return new FragmentOnboardingResetPasswordSendCodeBinding((LinearLayout) view, button, bind, progressBar, customToolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOnboardingResetPasswordSendCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingResetPasswordSendCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_reset_password_send_code, viewGroup, false);
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
