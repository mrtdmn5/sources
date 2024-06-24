package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LayoutWorkoutDetailsLinechartBinding implements ViewBinding {
    public final ImageView btnArrow;
    public final ChartView chartView;
    private final RelativeLayout rootView;
    public final FrameLayout touchAreaBtnArrow;
    public final TextView tvChartBottom;

    private LayoutWorkoutDetailsLinechartBinding(RelativeLayout relativeLayout, ImageView imageView, ChartView chartView, FrameLayout frameLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.btnArrow = imageView;
        this.chartView = chartView;
        this.touchAreaBtnArrow = frameLayout;
        this.tvChartBottom = textView;
    }

    public static LayoutWorkoutDetailsLinechartBinding bind(View view) {
        int r0 = R.id.btn_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.btn_arrow, view);
        if (imageView != null) {
            r0 = R.id.chart_view;
            ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.chart_view, view);
            if (chartView != null) {
                r0 = R.id.touch_area_btn_arrow;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.touch_area_btn_arrow, view);
                if (frameLayout != null) {
                    r0 = R.id.tv_chart_bottom;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_bottom, view);
                    if (textView != null) {
                        return new LayoutWorkoutDetailsLinechartBinding((RelativeLayout) view, imageView, chartView, frameLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static LayoutWorkoutDetailsLinechartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWorkoutDetailsLinechartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_workout_details_linechart, viewGroup, false);
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
