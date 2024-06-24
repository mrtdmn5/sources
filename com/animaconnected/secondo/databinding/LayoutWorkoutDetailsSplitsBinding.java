package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LayoutWorkoutDetailsSplitsBinding implements ViewBinding {
    public final ChartView chartView;
    private final LinearLayout rootView;
    public final TextView tvHeading;

    private LayoutWorkoutDetailsSplitsBinding(LinearLayout linearLayout, ChartView chartView, TextView textView) {
        this.rootView = linearLayout;
        this.chartView = chartView;
        this.tvHeading = textView;
    }

    public static LayoutWorkoutDetailsSplitsBinding bind(View view) {
        int r0 = R.id.chart_view;
        ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.chart_view, view);
        if (chartView != null) {
            r0 = R.id.tv_heading;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_heading, view);
            if (textView != null) {
                return new LayoutWorkoutDetailsSplitsBinding((LinearLayout) view, chartView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static LayoutWorkoutDetailsSplitsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWorkoutDetailsSplitsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_workout_details_splits, viewGroup, false);
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
