package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugChartBinding implements ViewBinding {
    public final Button btnLast7Days;
    public final Button btnMonth;
    public final Button btnToday;
    public final Button btnWeek;
    public final Button btnYear;
    public final LinearLayout containerEdit;
    public final LinearLayout containerHistory;
    public final LinearLayout containerLast7Days;
    public final LinearLayout containerToday;
    public final LinearLayout containerViewButtons;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView tvChangeStepGoal;
    public final TextView tvEmptyData;
    public final TextView tvGoBack;
    public final TextView tvRandomizeData;
    public final TextView tvSetCustomData;

    private FragmentDebugChartBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnLast7Days = button;
        this.btnMonth = button2;
        this.btnToday = button3;
        this.btnWeek = button4;
        this.btnYear = button5;
        this.containerEdit = linearLayout2;
        this.containerHistory = linearLayout3;
        this.containerLast7Days = linearLayout4;
        this.containerToday = linearLayout5;
        this.containerViewButtons = linearLayout6;
        this.recyclerView = recyclerView;
        this.tvChangeStepGoal = textView;
        this.tvEmptyData = textView2;
        this.tvGoBack = textView3;
        this.tvRandomizeData = textView4;
        this.tvSetCustomData = textView5;
    }

    public static FragmentDebugChartBinding bind(View view) {
        int r1 = R.id.btn_last_7_days;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_last_7_days, view);
        if (button != null) {
            r1 = R.id.btn_month;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_month, view);
            if (button2 != null) {
                r1 = R.id.btn_today;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_today, view);
                if (button3 != null) {
                    r1 = R.id.btn_week;
                    Button button4 = (Button) ViewBindings.findChildViewById(R.id.btn_week, view);
                    if (button4 != null) {
                        r1 = R.id.btn_year;
                        Button button5 = (Button) ViewBindings.findChildViewById(R.id.btn_year, view);
                        if (button5 != null) {
                            r1 = R.id.container_edit;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container_edit, view);
                            if (linearLayout != null) {
                                r1 = R.id.container_history;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.container_history, view);
                                if (linearLayout2 != null) {
                                    r1 = R.id.container_last_7_days;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.container_last_7_days, view);
                                    if (linearLayout3 != null) {
                                        r1 = R.id.container_today;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(R.id.container_today, view);
                                        if (linearLayout4 != null) {
                                            r1 = R.id.container_view_buttons;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(R.id.container_view_buttons, view);
                                            if (linearLayout5 != null) {
                                                r1 = R.id.recycler_view;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(R.id.recycler_view, view);
                                                if (recyclerView != null) {
                                                    r1 = R.id.tv_change_step_goal;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_change_step_goal, view);
                                                    if (textView != null) {
                                                        r1 = R.id.tv_empty_data;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_empty_data, view);
                                                        if (textView2 != null) {
                                                            r1 = R.id.tv_go_back;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_go_back, view);
                                                            if (textView3 != null) {
                                                                r1 = R.id.tv_randomize_data;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_randomize_data, view);
                                                                if (textView4 != null) {
                                                                    r1 = R.id.tv_set_custom_data;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_set_custom_data, view);
                                                                    if (textView5 != null) {
                                                                        return new FragmentDebugChartBinding((LinearLayout) view, button, button2, button3, button4, button5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, recyclerView, textView, textView2, textView3, textView4, textView5);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentDebugChartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugChartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_chart, viewGroup, false);
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
