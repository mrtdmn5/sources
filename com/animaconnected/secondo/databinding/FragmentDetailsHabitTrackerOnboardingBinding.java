package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsHabitTrackerOnboardingBinding implements ViewBinding {
    public final Button btnStartTracking;
    public final LinearLayout detailLayout;
    public final TextInputEditText nameEditText;
    private final LinearLayout rootView;
    public final LinearLayout setGoalButtonContainer;
    public final TextView setGoalValue;
    public final LinearLayout setResetIntervalButtonContainer;
    public final TextView setResetIntervalValue;

    private FragmentDetailsHabitTrackerOnboardingBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, TextInputEditText textInputEditText, LinearLayout linearLayout3, TextView textView, LinearLayout linearLayout4, TextView textView2) {
        this.rootView = linearLayout;
        this.btnStartTracking = button;
        this.detailLayout = linearLayout2;
        this.nameEditText = textInputEditText;
        this.setGoalButtonContainer = linearLayout3;
        this.setGoalValue = textView;
        this.setResetIntervalButtonContainer = linearLayout4;
        this.setResetIntervalValue = textView2;
    }

    public static FragmentDetailsHabitTrackerOnboardingBinding bind(View view) {
        int r0 = R.id.btn_start_tracking;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_start_tracking, view);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            r0 = R.id.name_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.name_edit_text, view);
            if (textInputEditText != null) {
                r0 = R.id.set_goal_button_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.set_goal_button_container, view);
                if (linearLayout2 != null) {
                    r0 = R.id.set_goal_value;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.set_goal_value, view);
                    if (textView != null) {
                        r0 = R.id.set_reset_interval_button_container;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.set_reset_interval_button_container, view);
                        if (linearLayout3 != null) {
                            r0 = R.id.set_reset_interval_value;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.set_reset_interval_value, view);
                            if (textView2 != null) {
                                return new FragmentDetailsHabitTrackerOnboardingBinding(linearLayout, button, linearLayout, textInputEditText, linearLayout2, textView, linearLayout3, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsHabitTrackerOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsHabitTrackerOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_habit_tracker_onboarding, viewGroup, false);
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
