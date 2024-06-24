package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LayoutTextinputLoginPasswordBinding implements ViewBinding {
    public final TextInputEditText etPassword;
    private final TextInputLayout rootView;
    public final TextInputLayout textInputLayout;

    private LayoutTextinputLoginPasswordBinding(TextInputLayout textInputLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout2) {
        this.rootView = textInputLayout;
        this.etPassword = textInputEditText;
        this.textInputLayout = textInputLayout2;
    }

    public static LayoutTextinputLoginPasswordBinding bind(View view) {
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.et_password, view);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) view;
            return new LayoutTextinputLoginPasswordBinding(textInputLayout, textInputEditText, textInputLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.et_password)));
    }

    public static LayoutTextinputLoginPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTextinputLoginPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_textinput_login_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextInputLayout getRoot() {
        return this.rootView;
    }
}
