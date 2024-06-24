package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.WatchLayoutWithOneSubComplication;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WatchLayoutWithOneSubComplication21Binding implements ViewBinding {
    public final ImageView imageViewMeter;
    public final WatchLayoutWithOneSubComplication imageViewMeterWatchHandContainer;
    public final ImageView imageViewWatchGlass;
    public final ImageView imageViewWatchHandHours;
    public final ImageView imageViewWatchHandHoursComplication;
    public final ImageView imageViewWatchHandMinutes;
    private final WatchLayoutWithOneSubComplication rootView;

    private WatchLayoutWithOneSubComplication21Binding(WatchLayoutWithOneSubComplication watchLayoutWithOneSubComplication, ImageView imageView, WatchLayoutWithOneSubComplication watchLayoutWithOneSubComplication2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        this.rootView = watchLayoutWithOneSubComplication;
        this.imageViewMeter = imageView;
        this.imageViewMeterWatchHandContainer = watchLayoutWithOneSubComplication2;
        this.imageViewWatchGlass = imageView2;
        this.imageViewWatchHandHours = imageView3;
        this.imageViewWatchHandHoursComplication = imageView4;
        this.imageViewWatchHandMinutes = imageView5;
    }

    public static WatchLayoutWithOneSubComplication21Binding bind(View view) {
        int r0 = R.id.imageViewMeter;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
        if (imageView != null) {
            WatchLayoutWithOneSubComplication watchLayoutWithOneSubComplication = (WatchLayoutWithOneSubComplication) view;
            r0 = R.id.imageViewWatchGlass;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchGlass, view);
            if (imageView2 != null) {
                r0 = R.id.imageViewWatchHandHours;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHours, view);
                if (imageView3 != null) {
                    r0 = R.id.imageViewWatchHandHoursComplication;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHoursComplication, view);
                    if (imageView4 != null) {
                        r0 = R.id.imageViewWatchHandMinutes;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandMinutes, view);
                        if (imageView5 != null) {
                            return new WatchLayoutWithOneSubComplication21Binding(watchLayoutWithOneSubComplication, imageView, watchLayoutWithOneSubComplication, imageView2, imageView3, imageView4, imageView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WatchLayoutWithOneSubComplication21Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WatchLayoutWithOneSubComplication21Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.watch_layout_with_one_sub_complication_2_1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public WatchLayoutWithOneSubComplication getRoot() {
        return this.rootView;
    }
}
