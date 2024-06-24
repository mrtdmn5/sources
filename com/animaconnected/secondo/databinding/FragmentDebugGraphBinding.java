package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugGraphBinding implements ViewBinding {
    public final ChartView debugGraphWorkoutSplits;
    private final ScrollView rootView;
    public final TextView tvDebugChartCalories;
    public final TextView tvDebugChartElevationDetail;
    public final TextView tvDebugChartHeartrateDetail;
    public final TextView tvDebugChartHeartrateHistory;
    public final TextView tvDebugChartRestingHeartrateDetail;
    public final TextView tvDebugChartRestingHeartrateHistory;
    public final TextView tvDebugChartSteps;

    private FragmentDebugGraphBinding(ScrollView scrollView, ChartView chartView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = scrollView;
        this.debugGraphWorkoutSplits = chartView;
        this.tvDebugChartCalories = textView;
        this.tvDebugChartElevationDetail = textView2;
        this.tvDebugChartHeartrateDetail = textView3;
        this.tvDebugChartHeartrateHistory = textView4;
        this.tvDebugChartRestingHeartrateDetail = textView5;
        this.tvDebugChartRestingHeartrateHistory = textView6;
        this.tvDebugChartSteps = textView7;
    }

    public static FragmentDebugGraphBinding bind(View view) {
        int r0 = R.id.debug_graph_workout_splits;
        ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.debug_graph_workout_splits, view);
        if (chartView != null) {
            r0 = R.id.tv_debug_chart_calories;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_calories, view);
            if (textView != null) {
                r0 = R.id.tv_debug_chart_elevation_detail;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_elevation_detail, view);
                if (textView2 != null) {
                    r0 = R.id.tv_debug_chart_heartrate_detail;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_heartrate_detail, view);
                    if (textView3 != null) {
                        r0 = R.id.tv_debug_chart_heartrate_history;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_heartrate_history, view);
                        if (textView4 != null) {
                            r0 = R.id.tv_debug_chart_resting_heartrate_detail;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_resting_heartrate_detail, view);
                            if (textView5 != null) {
                                r0 = R.id.tv_debug_chart_resting_heartrate_history;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_resting_heartrate_history, view);
                                if (textView6 != null) {
                                    r0 = R.id.tv_debug_chart_steps;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(R.id.tv_debug_chart_steps, view);
                                    if (textView7 != null) {
                                        return new FragmentDebugGraphBinding((ScrollView) view, chartView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static FragmentDebugGraphBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugGraphBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_graph, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}
