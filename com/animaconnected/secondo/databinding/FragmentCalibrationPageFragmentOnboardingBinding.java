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
public final class FragmentCalibrationPageFragmentOnboardingBinding implements ViewBinding {
    public final TextView calibrationDescription;
    private final LinearLayout rootView;

    private FragmentCalibrationPageFragmentOnboardingBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.calibrationDescription = textView;
    }

    public static FragmentCalibrationPageFragmentOnboardingBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.calibration_description, view);
        if (textView != null) {
            return new FragmentCalibrationPageFragmentOnboardingBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.calibration_description)));
    }

    public static FragmentCalibrationPageFragmentOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCalibrationPageFragmentOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_calibration_page_fragment_onboarding, viewGroup, false);
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
