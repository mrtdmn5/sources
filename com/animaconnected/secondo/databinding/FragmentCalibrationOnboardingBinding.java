package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.screens.calibration.CalibrationWheelView;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentCalibrationOnboardingBinding implements ViewBinding {
    public final Button calibrationNextOrDoneButton;
    public final ViewPager calibrationPager;
    public final Button calibrationPreviousButton;
    public final FrameLayout calibrationProgress;
    public final TextView calibrationTitle;
    public final CalibrationWheelView calibrationWheel;
    public final CirclePageIndicator pageIndicator;
    private final FrameLayout rootView;

    private FragmentCalibrationOnboardingBinding(FrameLayout frameLayout, Button button, ViewPager viewPager, Button button2, FrameLayout frameLayout2, TextView textView, CalibrationWheelView calibrationWheelView, CirclePageIndicator circlePageIndicator) {
        this.rootView = frameLayout;
        this.calibrationNextOrDoneButton = button;
        this.calibrationPager = viewPager;
        this.calibrationPreviousButton = button2;
        this.calibrationProgress = frameLayout2;
        this.calibrationTitle = textView;
        this.calibrationWheel = calibrationWheelView;
        this.pageIndicator = circlePageIndicator;
    }

    public static FragmentCalibrationOnboardingBinding bind(View view) {
        int r0 = R.id.calibration_next_or_done_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.calibration_next_or_done_button, view);
        if (button != null) {
            r0 = R.id.calibration_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(R.id.calibration_pager, view);
            if (viewPager != null) {
                r0 = R.id.calibration_previous_button;
                Button button2 = (Button) ViewBindings.findChildViewById(R.id.calibration_previous_button, view);
                if (button2 != null) {
                    r0 = R.id.calibration_progress;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.calibration_progress, view);
                    if (frameLayout != null) {
                        r0 = R.id.calibration_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.calibration_title, view);
                        if (textView != null) {
                            r0 = R.id.calibration_wheel;
                            CalibrationWheelView calibrationWheelView = (CalibrationWheelView) ViewBindings.findChildViewById(R.id.calibration_wheel, view);
                            if (calibrationWheelView != null) {
                                r0 = R.id.page_indicator;
                                CirclePageIndicator circlePageIndicator = (CirclePageIndicator) ViewBindings.findChildViewById(R.id.page_indicator, view);
                                if (circlePageIndicator != null) {
                                    return new FragmentCalibrationOnboardingBinding((FrameLayout) view, button, viewPager, button2, frameLayout, textView, calibrationWheelView, circlePageIndicator);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentCalibrationOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCalibrationOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_calibration_onboarding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
