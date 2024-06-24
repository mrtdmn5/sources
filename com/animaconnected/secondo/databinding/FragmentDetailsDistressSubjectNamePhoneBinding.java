package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsDistressSubjectNamePhoneBinding implements ViewBinding {
    public final Button continueBtn;
    public final TextInputEditText nameEditText;
    public final TextInputEditText phoneNumberEditText;
    private final LinearLayout rootView;

    private FragmentDetailsDistressSubjectNamePhoneBinding(LinearLayout linearLayout, Button button, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        this.rootView = linearLayout;
        this.continueBtn = button;
        this.nameEditText = textInputEditText;
        this.phoneNumberEditText = textInputEditText2;
    }

    public static FragmentDetailsDistressSubjectNamePhoneBinding bind(View view) {
        int r0 = R.id.continue_btn;
        Button button = (Button) ViewBindings.findChildViewById(R.id.continue_btn, view);
        if (button != null) {
            r0 = R.id.name_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.name_edit_text, view);
            if (textInputEditText != null) {
                r0 = R.id.phone_number_edit_text;
                TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(R.id.phone_number_edit_text, view);
                if (textInputEditText2 != null) {
                    return new FragmentDetailsDistressSubjectNamePhoneBinding((LinearLayout) view, button, textInputEditText, textInputEditText2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsDistressSubjectNamePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsDistressSubjectNamePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_distress_subject_name_phone, viewGroup, false);
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
