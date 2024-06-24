package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LayoutSleepChartInfoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvSleepDeep;
    public final TextView tvSleepDeepPercentage;
    public final TextView tvSleepLight;
    public final TextView tvSleepLightPercentage;
    public final TextView tvTotalSleep;
    public final TextView tvTotalSleepValue;

    private LayoutSleepChartInfoBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.tvSleepDeep = textView;
        this.tvSleepDeepPercentage = textView2;
        this.tvSleepLight = textView3;
        this.tvSleepLightPercentage = textView4;
        this.tvTotalSleep = textView5;
        this.tvTotalSleepValue = textView6;
    }

    public static LayoutSleepChartInfoBinding bind(View view) {
        int r0 = R.id.tv_sleep_deep;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_sleep_deep, view);
        if (textView != null) {
            r0 = R.id.tv_sleep_deep_percentage;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_sleep_deep_percentage, view);
            if (textView2 != null) {
                r0 = R.id.tv_sleep_light;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_sleep_light, view);
                if (textView3 != null) {
                    r0 = R.id.tv_sleep_light_percentage;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_sleep_light_percentage, view);
                    if (textView4 != null) {
                        r0 = R.id.tv_total_sleep;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_total_sleep, view);
                        if (textView5 != null) {
                            r0 = R.id.tv_total_sleep_value;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_total_sleep_value, view);
                            if (textView6 != null) {
                                return new LayoutSleepChartInfoBinding((RelativeLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static LayoutSleepChartInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutSleepChartInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_sleep_chart_info, viewGroup, false);
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
