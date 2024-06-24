package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentWorkoutMetricDetailBinding implements ViewBinding {
    public final ChartView chartView;
    private final FrameLayout rootView;
    public final TextView tvTitle;

    private FragmentWorkoutMetricDetailBinding(FrameLayout frameLayout, ChartView chartView, TextView textView) {
        this.rootView = frameLayout;
        this.chartView = chartView;
        this.tvTitle = textView;
    }

    public static FragmentWorkoutMetricDetailBinding bind(View view) {
        int r0 = R.id.chart_view;
        ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.chart_view, view);
        if (chartView != null) {
            r0 = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_title, view);
            if (textView != null) {
                return new FragmentWorkoutMetricDetailBinding((FrameLayout) view, chartView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentWorkoutMetricDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWorkoutMetricDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_workout_metric_detail, viewGroup, false);
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
