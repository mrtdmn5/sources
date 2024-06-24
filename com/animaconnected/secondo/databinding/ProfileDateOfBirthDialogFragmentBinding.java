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
public final class ProfileDateOfBirthDialogFragmentBinding implements ViewBinding {
    public final Button buttonConfirm;
    public final Button buttonNotSay;
    public final NumberPicker dayPicker;
    public final NumberPicker monthPicker;
    private final LinearLayout rootView;
    public final NumberPicker yearPicker;

    private ProfileDateOfBirthDialogFragmentBinding(LinearLayout linearLayout, Button button, Button button2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        this.rootView = linearLayout;
        this.buttonConfirm = button;
        this.buttonNotSay = button2;
        this.dayPicker = numberPicker;
        this.monthPicker = numberPicker2;
        this.yearPicker = numberPicker3;
    }

    public static ProfileDateOfBirthDialogFragmentBinding bind(View view) {
        int r0 = R.id.button_confirm;
        Button button = (Button) ViewBindings.findChildViewById(R.id.button_confirm, view);
        if (button != null) {
            r0 = R.id.button_not_say;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.button_not_say, view);
            if (button2 != null) {
                r0 = R.id.day_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.day_picker, view);
                if (numberPicker != null) {
                    r0 = R.id.month_picker;
                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(R.id.month_picker, view);
                    if (numberPicker2 != null) {
                        r0 = R.id.year_picker;
                        NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(R.id.year_picker, view);
                        if (numberPicker3 != null) {
                            return new ProfileDateOfBirthDialogFragmentBinding((LinearLayout) view, button, button2, numberPicker, numberPicker2, numberPicker3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ProfileDateOfBirthDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProfileDateOfBirthDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.profile_date_of_birth_dialog_fragment, viewGroup, false);
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
