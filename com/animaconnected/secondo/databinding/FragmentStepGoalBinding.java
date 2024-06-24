package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentStepGoalBinding implements ViewBinding {
    public final LinearLayout container;
    public final Button gotoActivity;
    private final RelativeLayout rootView;
    public final TextView stepGoalDescription;
    public final TextView titleTextView;

    private FragmentStepGoalBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.container = linearLayout;
        this.gotoActivity = button;
        this.stepGoalDescription = textView;
        this.titleTextView = textView2;
    }

    public static FragmentStepGoalBinding bind(View view) {
        int r0 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
        if (linearLayout != null) {
            r0 = R.id.goto_activity;
            Button button = (Button) ViewBindings.findChildViewById(R.id.goto_activity, view);
            if (button != null) {
                r0 = R.id.step_goal_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.step_goal_description, view);
                if (textView != null) {
                    r0 = R.id.title_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                    if (textView2 != null) {
                        return new FragmentStepGoalBinding((RelativeLayout) view, linearLayout, button, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentStepGoalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStepGoalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_step_goal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
