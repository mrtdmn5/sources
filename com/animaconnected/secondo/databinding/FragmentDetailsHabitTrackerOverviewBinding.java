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
public final class FragmentDetailsHabitTrackerOverviewBinding implements ViewBinding {
    public final Button btnAddCount;
    public final Button btnDeleteCount;
    public final Button btnDeleteHabit;
    public final Button btnResetCount;
    public final RelativeLayout countController;
    public final TextView currentCountAmountTextView;
    public final LinearLayout detailLayout;
    public final TextView habitTitle;
    public final TextView resetIntervalText;
    private final LinearLayout rootView;

    private FragmentDetailsHabitTrackerOverviewBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnAddCount = button;
        this.btnDeleteCount = button2;
        this.btnDeleteHabit = button3;
        this.btnResetCount = button4;
        this.countController = relativeLayout;
        this.currentCountAmountTextView = textView;
        this.detailLayout = linearLayout2;
        this.habitTitle = textView2;
        this.resetIntervalText = textView3;
    }

    public static FragmentDetailsHabitTrackerOverviewBinding bind(View view) {
        int r0 = R.id.btn_add_count;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_add_count, view);
        if (button != null) {
            r0 = R.id.btn_delete_count;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_delete_count, view);
            if (button2 != null) {
                r0 = R.id.btn_delete_habit;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_delete_habit, view);
                if (button3 != null) {
                    r0 = R.id.btn_reset_count;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.btn_reset_count, view);
                    if (button4 != null) {
                        r0 = R.id.count_controller;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.count_controller, view);
                        if (relativeLayout != null) {
                            r0 = R.id.current_count_amount_text_view;
                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.current_count_amount_text_view, view);
                            if (textView != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                r0 = R.id.habit_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.habit_title, view);
                                if (textView2 != null) {
                                    r0 = R.id.reset_interval_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.reset_interval_text, view);
                                    if (textView3 != null) {
                                        return new FragmentDetailsHabitTrackerOverviewBinding(linearLayout, button, button2, button3, button4, relativeLayout, textView, linearLayout, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsHabitTrackerOverviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsHabitTrackerOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_habit_tracker_overview, viewGroup, false);
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
