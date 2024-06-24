package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.google.android.material.tabs.TabLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentGenericWorkoutMetricHistoryBinding implements ViewBinding {
    public final ImageView btnNextDate;
    public final ImageView btnPreviousDate;
    public final ChartView chartView;
    public final LinearLayout containerDatePicker;
    public final LinearLayout containerDateSelection;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;
    public final TextView tvChartInfo;
    public final TextView tvDateTime;
    public final TextView tvDateTimeHeader;
    public final TextView tvMetricName;

    private FragmentGenericWorkoutMetricHistoryBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ChartView chartView, LinearLayout linearLayout2, LinearLayout linearLayout3, TabLayout tabLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnNextDate = imageView;
        this.btnPreviousDate = imageView2;
        this.chartView = chartView;
        this.containerDatePicker = linearLayout2;
        this.containerDateSelection = linearLayout3;
        this.tabLayout = tabLayout;
        this.tvChartInfo = textView;
        this.tvDateTime = textView2;
        this.tvDateTimeHeader = textView3;
        this.tvMetricName = textView4;
    }

    public static FragmentGenericWorkoutMetricHistoryBinding bind(View view) {
        int r0 = R.id.btn_next_date;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.btn_next_date, view);
        if (imageView != null) {
            r0 = R.id.btn_previous_date;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.btn_previous_date, view);
            if (imageView2 != null) {
                r0 = R.id.chart_view;
                ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.chart_view, view);
                if (chartView != null) {
                    r0 = R.id.container_date_picker;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container_date_picker, view);
                    if (linearLayout != null) {
                        r0 = R.id.container_date_selection;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.container_date_selection, view);
                        if (linearLayout2 != null) {
                            r0 = R.id.tab_layout;
                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(R.id.tab_layout, view);
                            if (tabLayout != null) {
                                r0 = R.id.tv_chart_info;
                                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_info, view);
                                if (textView != null) {
                                    r0 = R.id.tv_date_time;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_date_time, view);
                                    if (textView2 != null) {
                                        r0 = R.id.tv_date_time_header;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_date_time_header, view);
                                        if (textView3 != null) {
                                            r0 = R.id.tv_metric_name;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_metric_name, view);
                                            if (textView4 != null) {
                                                return new FragmentGenericWorkoutMetricHistoryBinding((LinearLayout) view, imageView, imageView2, chartView, linearLayout, linearLayout2, tabLayout, textView, textView2, textView3, textView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentGenericWorkoutMetricHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGenericWorkoutMetricHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_generic_workout_metric_history, viewGroup, false);
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
