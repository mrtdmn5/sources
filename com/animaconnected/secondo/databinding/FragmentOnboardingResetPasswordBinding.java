package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingResetPasswordBinding implements ViewBinding {
    public final Button btnSave;
    public final LayoutTextinputLoginPasswordBinding layoutPassword;
    private final LinearLayout rootView;
    public final CustomToolbar toolbar;

    private FragmentOnboardingResetPasswordBinding(LinearLayout linearLayout, Button button, LayoutTextinputLoginPasswordBinding layoutTextinputLoginPasswordBinding, CustomToolbar customToolbar) {
        this.rootView = linearLayout;
        this.btnSave = button;
        this.layoutPassword = layoutTextinputLoginPasswordBinding;
        this.toolbar = customToolbar;
    }

    public static FragmentOnboardingResetPasswordBinding bind(View view) {
        int r0 = R.id.btn_save;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_save, view);
        if (button != null) {
            r0 = R.id.layout_password;
            View findChildViewById = ViewBindings.findChildViewById(R.id.layout_password, view);
            if (findChildViewById != null) {
                LayoutTextinputLoginPasswordBinding bind = LayoutTextinputLoginPasswordBinding.bind(findChildViewById);
                CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.toolbar, view);
                if (customToolbar != null) {
                    return new FragmentOnboardingResetPasswordBinding((LinearLayout) view, button, bind, customToolbar);
                }
                r0 = R.id.toolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOnboardingResetPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingResetPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_reset_password, viewGroup, false);
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
