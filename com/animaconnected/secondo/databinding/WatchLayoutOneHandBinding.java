package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.WatchLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WatchLayoutOneHandBinding implements ViewBinding {
    public final ImageView imageViewMeter;
    public final WatchLayout imageViewMeterWatchHandContainer;
    public final ImageView imageViewWatchHandHours;
    private final WatchLayout rootView;

    private WatchLayoutOneHandBinding(WatchLayout watchLayout, ImageView imageView, WatchLayout watchLayout2, ImageView imageView2) {
        this.rootView = watchLayout;
        this.imageViewMeter = imageView;
        this.imageViewMeterWatchHandContainer = watchLayout2;
        this.imageViewWatchHandHours = imageView2;
    }

    public static WatchLayoutOneHandBinding bind(View view) {
        int r0 = R.id.imageViewMeter;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
        if (imageView != null) {
            WatchLayout watchLayout = (WatchLayout) view;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHours, view);
            if (imageView2 != null) {
                return new WatchLayoutOneHandBinding(watchLayout, imageView, watchLayout, imageView2);
            }
            r0 = R.id.imageViewWatchHandHours;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WatchLayoutOneHandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WatchLayoutOneHandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.watch_layout_one_hand, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public WatchLayout getRoot() {
        return this.rootView;
    }
}
