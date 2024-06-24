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
public final class ClickableWatchLayoutBinding implements ViewBinding {
    public final ImageView imageViewMeter;
    public final WatchLayout imageViewMeterWatchHandContainer;
    public final ImageView imageViewWatchGlass;
    public final ImageView imageViewWatchHandHours;
    public final ImageView imageViewWatchHandMinutes;
    private final WatchLayout rootView;

    private ClickableWatchLayoutBinding(WatchLayout watchLayout, ImageView imageView, WatchLayout watchLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        this.rootView = watchLayout;
        this.imageViewMeter = imageView;
        this.imageViewMeterWatchHandContainer = watchLayout2;
        this.imageViewWatchGlass = imageView2;
        this.imageViewWatchHandHours = imageView3;
        this.imageViewWatchHandMinutes = imageView4;
    }

    public static ClickableWatchLayoutBinding bind(View view) {
        int r0 = R.id.imageViewMeter;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
        if (imageView != null) {
            WatchLayout watchLayout = (WatchLayout) view;
            r0 = R.id.imageViewWatchGlass;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchGlass, view);
            if (imageView2 != null) {
                r0 = R.id.imageViewWatchHandHours;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHours, view);
                if (imageView3 != null) {
                    r0 = R.id.imageViewWatchHandMinutes;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandMinutes, view);
                    if (imageView4 != null) {
                        return new ClickableWatchLayoutBinding(watchLayout, imageView, watchLayout, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ClickableWatchLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ClickableWatchLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.clickable_watch_layout, viewGroup, false);
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
