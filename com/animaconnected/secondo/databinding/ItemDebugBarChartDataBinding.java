package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemDebugBarChartDataBinding implements ViewBinding {
    public final EditText etItemDebugStepsChartData;
    private final LinearLayout rootView;
    public final TextView tvItemDebugStepsChartData;

    private ItemDebugBarChartDataBinding(LinearLayout linearLayout, EditText editText, TextView textView) {
        this.rootView = linearLayout;
        this.etItemDebugStepsChartData = editText;
        this.tvItemDebugStepsChartData = textView;
    }

    public static ItemDebugBarChartDataBinding bind(View view) {
        int r0 = R.id.et_item_debug_steps_chart_data;
        EditText editText = (EditText) ViewBindings.findChildViewById(R.id.et_item_debug_steps_chart_data, view);
        if (editText != null) {
            r0 = R.id.tv_item_debug_steps_chart_data;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_item_debug_steps_chart_data, view);
            if (textView != null) {
                return new ItemDebugBarChartDataBinding((LinearLayout) view, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemDebugBarChartDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDebugBarChartDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_debug_bar_chart_data, viewGroup, false);
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
