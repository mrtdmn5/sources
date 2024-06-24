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
public final class LayoutWorkoutChartInfoBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvDivider;
    public final TextView tvTextOne;
    public final TextView tvTextTwo;

    private LayoutWorkoutChartInfoBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.tvDivider = textView;
        this.tvTextOne = textView2;
        this.tvTextTwo = textView3;
    }

    public static LayoutWorkoutChartInfoBinding bind(View view) {
        int r0 = R.id.tv_divider;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_divider, view);
        if (textView != null) {
            r0 = R.id.tv_text_one;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_text_one, view);
            if (textView2 != null) {
                r0 = R.id.tv_text_two;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_text_two, view);
                if (textView3 != null) {
                    return new LayoutWorkoutChartInfoBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static LayoutWorkoutChartInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutWorkoutChartInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_workout_chart_info, viewGroup, false);
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
