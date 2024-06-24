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
public final class ProfileHeightImperialDialogFragmentBinding implements ViewBinding {
    public final Button buttonConfirm;
    public final Button buttonNotSay;
    public final NumberPicker feetPicker;
    public final NumberPicker inchesPicker;
    private final LinearLayout rootView;

    private ProfileHeightImperialDialogFragmentBinding(LinearLayout linearLayout, Button button, Button button2, NumberPicker numberPicker, NumberPicker numberPicker2) {
        this.rootView = linearLayout;
        this.buttonConfirm = button;
        this.buttonNotSay = button2;
        this.feetPicker = numberPicker;
        this.inchesPicker = numberPicker2;
    }

    public static ProfileHeightImperialDialogFragmentBinding bind(View view) {
        int r0 = R.id.button_confirm;
        Button button = (Button) ViewBindings.findChildViewById(R.id.button_confirm, view);
        if (button != null) {
            r0 = R.id.button_not_say;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.button_not_say, view);
            if (button2 != null) {
                r0 = R.id.feet_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.feet_picker, view);
                if (numberPicker != null) {
                    r0 = R.id.inches_picker;
                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(R.id.inches_picker, view);
                    if (numberPicker2 != null) {
                        return new ProfileHeightImperialDialogFragmentBinding((LinearLayout) view, button, button2, numberPicker, numberPicker2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ProfileHeightImperialDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProfileHeightImperialDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.profile_height_imperial_dialog_fragment, viewGroup, false);
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
