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
public final class DialogfragmentScrollPickerBinding implements ViewBinding {
    public final Button btnOk;
    public final NumberPicker numberPicker;
    public final TextView pickerTitle;
    private final LinearLayout rootView;

    private DialogfragmentScrollPickerBinding(LinearLayout linearLayout, Button button, NumberPicker numberPicker, TextView textView) {
        this.rootView = linearLayout;
        this.btnOk = button;
        this.numberPicker = numberPicker;
        this.pickerTitle = textView;
    }

    public static DialogfragmentScrollPickerBinding bind(View view) {
        int r0 = R.id.btn_ok;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_ok, view);
        if (button != null) {
            r0 = R.id.numberPicker;
            NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.numberPicker, view);
            if (numberPicker != null) {
                r0 = R.id.picker_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.picker_title, view);
                if (textView != null) {
                    return new DialogfragmentScrollPickerBinding((LinearLayout) view, button, numberPicker, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentScrollPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentScrollPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_scroll_picker, viewGroup, false);
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
