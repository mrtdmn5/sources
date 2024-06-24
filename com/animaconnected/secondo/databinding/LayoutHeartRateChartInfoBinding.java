package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class LayoutHeartRateChartInfoBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvCurrentHeartRateTitle;
    public final TextView tvHeartRateAvgTitle;
    public final TextView tvHeartRateAvgValue;
    public final TextView tvHeartRateHighValue;
    public final TextView tvHeartRateLowTitle;
    public final TextView tvHeartRateLowValue;
    public final TextView tvLiveUnit;
    public final TextView tvLiveValue;
    public final LinearLayout valueCont;

    private LayoutHeartRateChartInfoBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.tvCurrentHeartRateTitle = textView;
        this.tvHeartRateAvgTitle = textView2;
        this.tvHeartRateAvgValue = textView3;
        this.tvHeartRateHighValue = textView4;
        this.tvHeartRateLowTitle = textView5;
        this.tvHeartRateLowValue = textView6;
        this.tvLiveUnit = textView7;
        this.tvLiveValue = textView8;
        this.valueCont = linearLayout2;
    }

    public static LayoutHeartRateChartInfoBinding bind(View view) {
        int r0 = R.id.tv_current_heart_rate_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_current_heart_rate_title, view);
        if (textView != null) {
            r0 = R.id.tv_heart_rate_avg_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_heart_rate_avg_title, view);
            if (textView2 != null) {
                r0 = R.id.tv_heart_rate_avg_value;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_heart_rate_avg_value, view);
                if (textView3 != null) {
                    r0 = R.id.tv_heart_rate_high_value;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_heart_rate_high_value, view);
                    if (textView4 != null) {
                        r0 = R.id.tv_heart_rate_low_title;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_heart_rate_low_title, view);
                        if (textView5 != null) {
                            r0 = R.id.tv_heart_rate_low_value;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_heart_rate_low_value, view);
                            if (textView6 != null) {
                                r0 = R.id.tv_live_unit;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(R.id.tv_live_unit, view);
                                if (textView7 != null) {
                                    r0 = R.id.tv_live_value;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(R.id.tv_live_value, view);
                                    if (textView8 != null) {
                                        r0 = R.id.value_cont;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.value_cont, view);
                                        if (linearLayout != null) {
                                            return new LayoutHeartRateChartInfoBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, linearLayout);
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

    public static LayoutHeartRateChartInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutHeartRateChartInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_heart_rate_chart_info, viewGroup, false);
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
