package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemConfigurableMetricBinding implements ViewBinding {
    public final ImageView img;
    private final RelativeLayout rootView;
    public final TextView tvMetricName;

    private ItemConfigurableMetricBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.img = imageView;
        this.tvMetricName = textView;
    }

    public static ItemConfigurableMetricBinding bind(View view) {
        int r0 = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.img, view);
        if (imageView != null) {
            r0 = R.id.tv_metric_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_metric_name, view);
            if (textView != null) {
                return new ItemConfigurableMetricBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemConfigurableMetricBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemConfigurableMetricBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_configurable_metric, viewGroup, false);
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
