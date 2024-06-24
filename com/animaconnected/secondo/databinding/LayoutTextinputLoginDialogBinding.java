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
public final class LayoutTextinputLoginDialogBinding implements ViewBinding {
    public final TextInputEditText editText;
    private final TextInputLayout rootView;
    public final TextInputLayout textInputLayout;

    private LayoutTextinputLoginDialogBinding(TextInputLayout textInputLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout2) {
        this.rootView = textInputLayout;
        this.editText = textInputEditText;
        this.textInputLayout = textInputLayout2;
    }

    public static LayoutTextinputLoginDialogBinding bind(View view) {
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.editText, view);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) view;
            return new LayoutTextinputLoginDialogBinding(textInputLayout, textInputEditText, textInputLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.editText)));
    }

    public static LayoutTextinputLoginDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTextinputLoginDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_textinput_login_dialog, viewGroup, false);
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
