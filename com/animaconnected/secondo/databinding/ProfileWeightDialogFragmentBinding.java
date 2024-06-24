package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ProfileWeightDialogFragmentBinding implements ViewBinding {
    public final Button buttonConfirm;
    public final Button buttonNotSay;
    private final LinearLayout rootView;
    public final NumberPicker weightPicker;
    public final TextView weightUnitText;

    private ProfileWeightDialogFragmentBinding(LinearLayout linearLayout, Button button, Button button2, NumberPicker numberPicker, TextView textView) {
        this.rootView = linearLayout;
        this.buttonConfirm = button;
        this.buttonNotSay = button2;
        this.weightPicker = numberPicker;
        this.weightUnitText = textView;
    }

    public static ProfileWeightDialogFragmentBinding bind(View view) {
        int r0 = R.id.button_confirm;
        Button button = (Button) ViewBindings.findChildViewById(R.id.button_confirm, view);
        if (button != null) {
            r0 = R.id.button_not_say;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.button_not_say, view);
            if (button2 != null) {
                r0 = R.id.weight_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.weight_picker, view);
                if (numberPicker != null) {
                    r0 = R.id.weight_unit_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.weight_unit_text, view);
                    if (textView != null) {
                        return new ProfileWeightDialogFragmentBinding((LinearLayout) view, button, button2, numberPicker, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ProfileWeightDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProfileWeightDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.profile_weight_dialog_fragment, viewGroup, false);
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
