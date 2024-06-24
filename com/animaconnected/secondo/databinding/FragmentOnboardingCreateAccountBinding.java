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
import com.animaconnected.secondo.screens.CustomToolbar;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingCreateAccountBinding implements ViewBinding {
    public final Button btnContinue;
    public final LayoutTextinputLoginBinding layoutEmail;
    public final LinearLayout layoutForms;
    public final LayoutTextinputLoginPasswordBinding layoutPassword;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final CustomToolbar toolbar;
    public final TextView tvHeading;

    private FragmentOnboardingCreateAccountBinding(LinearLayout linearLayout, Button button, LayoutTextinputLoginBinding layoutTextinputLoginBinding, LinearLayout linearLayout2, LayoutTextinputLoginPasswordBinding layoutTextinputLoginPasswordBinding, ProgressBar progressBar, CustomToolbar customToolbar, TextView textView) {
        this.rootView = linearLayout;
        this.btnContinue = button;
        this.layoutEmail = layoutTextinputLoginBinding;
        this.layoutForms = linearLayout2;
        this.layoutPassword = layoutTextinputLoginPasswordBinding;
        this.progressBar = progressBar;
        this.toolbar = customToolbar;
        this.tvHeading = textView;
    }

    public static FragmentOnboardingCreateAccountBinding bind(View view) {
        int r0 = R.id.btn_continue;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_continue, view);
        if (button != null) {
            r0 = R.id.layout_email;
            View findChildViewById = ViewBindings.findChildViewById(R.id.layout_email, view);
            if (findChildViewById != null) {
                LayoutTextinputLoginBinding bind = LayoutTextinputLoginBinding.bind(findChildViewById);
                r0 = R.id.layout_forms;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.layout_forms, view);
                if (linearLayout != null) {
                    r0 = R.id.layout_password;
                    View findChildViewById2 = ViewBindings.findChildViewById(R.id.layout_password, view);
                    if (findChildViewById2 != null) {
                        LayoutTextinputLoginPasswordBinding bind2 = LayoutTextinputLoginPasswordBinding.bind(findChildViewById2);
                        r0 = R.id.progress_bar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                        if (progressBar != null) {
                            r0 = R.id.toolbar;
                            CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar, view);
                            if (customToolbar != null) {
                                r0 = R.id.tv_heading;
                                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_heading, view);
                                if (textView != null) {
                                    return new FragmentOnboardingCreateAccountBinding((LinearLayout) view, button, bind, linearLayout, bind2, progressBar, customToolbar, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOnboardingCreateAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingCreateAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_create_account, viewGroup, false);
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
