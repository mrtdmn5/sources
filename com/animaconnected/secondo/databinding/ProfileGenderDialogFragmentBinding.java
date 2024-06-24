package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ProfileGenderDialogFragmentBinding implements ViewBinding {
    public final Button buttonConfirm;
    public final Button buttonNotSay;
    public final NumberPicker genderPicker;
    private final LinearLayout rootView;

    private ProfileGenderDialogFragmentBinding(LinearLayout linearLayout, Button button, Button button2, NumberPicker numberPicker) {
        this.rootView = linearLayout;
        this.buttonConfirm = button;
        this.buttonNotSay = button2;
        this.genderPicker = numberPicker;
    }

    public static ProfileGenderDialogFragmentBinding bind(View view) {
        int r0 = R.id.button_confirm;
        Button button = (Button) ViewBindings.findChildViewById(R.id.button_confirm, view);
        if (button != null) {
            r0 = R.id.button_not_say;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.button_not_say, view);
            if (button2 != null) {
                r0 = R.id.gender_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.gender_picker, view);
                if (numberPicker != null) {
                    return new ProfileGenderDialogFragmentBinding((LinearLayout) view, button, button2, numberPicker);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ProfileGenderDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProfileGenderDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.profile_gender_dialog_fragment, viewGroup, false);
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
