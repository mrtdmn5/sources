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
public final class FragmentWeatherBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final TextView tvCurrentTemp;

    private FragmentWeatherBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.titleTextView = textView;
        this.tvCurrentTemp = textView2;
    }

    public static FragmentWeatherBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r1 = R.id.title_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
        if (textView != null) {
            r1 = R.id.tv_current_temp;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_current_temp, view);
            if (textView2 != null) {
                return new FragmentWeatherBinding(linearLayout, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentWeatherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWeatherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_weather, viewGroup, false);
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
