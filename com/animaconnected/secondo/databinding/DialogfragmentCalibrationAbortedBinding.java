package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentCalibrationAbortedBinding implements ViewBinding {
    public final TextView description1TextView;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private DialogfragmentCalibrationAbortedBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.description1TextView = textView;
        this.titleTextView = textView2;
    }

    public static DialogfragmentCalibrationAbortedBinding bind(View view) {
        int r0 = R.id.description_1_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.description_1_text_view, view);
        if (textView != null) {
            r0 = R.id.title_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
            if (textView2 != null) {
                return new DialogfragmentCalibrationAbortedBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentCalibrationAbortedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentCalibrationAbortedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_calibration_aborted, viewGroup, false);
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
