package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentCalibrationInitiationBinding implements ViewBinding {
    public final TextView calibrationTitle;
    public final LottieAnimationView lottieAnimationView;
    private final LinearLayout rootView;
    public final ProgressBar setupProgressbar;
    public final Button skipCalibration;
    public final Button startCalibration;

    private FragmentCalibrationInitiationBinding(LinearLayout linearLayout, TextView textView, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Button button, Button button2) {
        this.rootView = linearLayout;
        this.calibrationTitle = textView;
        this.lottieAnimationView = lottieAnimationView;
        this.setupProgressbar = progressBar;
        this.skipCalibration = button;
        this.startCalibration = button2;
    }

    public static FragmentCalibrationInitiationBinding bind(View view) {
        int r0 = R.id.calibration_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.calibration_title, view);
        if (textView != null) {
            r0 = R.id.lottie_animation_view;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
            if (lottieAnimationView != null) {
                r0 = R.id.setup_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.setup_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.skip_calibration;
                    Button button = (Button) ViewBindings.findChildViewById(R.id.skip_calibration, view);
                    if (button != null) {
                        r0 = R.id.start_calibration;
                        Button button2 = (Button) ViewBindings.findChildViewById(R.id.start_calibration, view);
                        if (button2 != null) {
                            return new FragmentCalibrationInitiationBinding((LinearLayout) view, textView, lottieAnimationView, progressBar, button, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentCalibrationInitiationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCalibrationInitiationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_calibration_initiation, viewGroup, false);
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
