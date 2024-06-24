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
public final class ItemStopwatchLapBinding implements ViewBinding {
    public final TextView lapText;
    public final TextView lapTimeText;
    private final LinearLayout rootView;

    private ItemStopwatchLapBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.lapText = textView;
        this.lapTimeText = textView2;
    }

    public static ItemStopwatchLapBinding bind(View view) {
        int r0 = R.id.lap_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.lap_text, view);
        if (textView != null) {
            r0 = R.id.lap_time_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.lap_time_text, view);
            if (textView2 != null) {
                return new ItemStopwatchLapBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemStopwatchLapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemStopwatchLapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_stopwatch_lap, viewGroup, false);
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
