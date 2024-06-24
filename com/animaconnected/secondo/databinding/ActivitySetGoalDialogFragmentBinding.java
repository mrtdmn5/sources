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
public final class ActivitySetGoalDialogFragmentBinding implements ViewBinding {
    public final Button btnOk;
    private final LinearLayout rootView;
    public final NumberPicker setGoalNumberPicker;
    public final TextView title;

    private ActivitySetGoalDialogFragmentBinding(LinearLayout linearLayout, Button button, NumberPicker numberPicker, TextView textView) {
        this.rootView = linearLayout;
        this.btnOk = button;
        this.setGoalNumberPicker = numberPicker;
        this.title = textView;
    }

    public static ActivitySetGoalDialogFragmentBinding bind(View view) {
        int r0 = R.id.btn_ok;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_ok, view);
        if (button != null) {
            r0 = R.id.setGoalNumberPicker;
            NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(R.id.setGoalNumberPicker, view);
            if (numberPicker != null) {
                r0 = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title, view);
                if (textView != null) {
                    return new ActivitySetGoalDialogFragmentBinding((LinearLayout) view, button, numberPicker, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ActivitySetGoalDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySetGoalDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_set_goal_dialog_fragment, viewGroup, false);
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
