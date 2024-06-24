package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.WatchLayoutWithTwoSubComplications;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WatchLayoutWithTwoSubComplications211Binding implements ViewBinding {
    public final ImageView imageViewMeter;
    public final WatchLayoutWithTwoSubComplications imageViewMeterWatchHandContainer;
    public final ImageView imageViewWatchGlass;
    public final ImageView imageViewWatchHandHours;
    public final ImageView imageViewWatchHandHoursComplication1;
    public final ImageView imageViewWatchHandHoursComplication2;
    public final ImageView imageViewWatchHandMinutes;
    private final WatchLayoutWithTwoSubComplications rootView;

    private WatchLayoutWithTwoSubComplications211Binding(WatchLayoutWithTwoSubComplications watchLayoutWithTwoSubComplications, ImageView imageView, WatchLayoutWithTwoSubComplications watchLayoutWithTwoSubComplications2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.rootView = watchLayoutWithTwoSubComplications;
        this.imageViewMeter = imageView;
        this.imageViewMeterWatchHandContainer = watchLayoutWithTwoSubComplications2;
        this.imageViewWatchGlass = imageView2;
        this.imageViewWatchHandHours = imageView3;
        this.imageViewWatchHandHoursComplication1 = imageView4;
        this.imageViewWatchHandHoursComplication2 = imageView5;
        this.imageViewWatchHandMinutes = imageView6;
    }

    public static WatchLayoutWithTwoSubComplications211Binding bind(View view) {
        int r0 = R.id.imageViewMeter;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
        if (imageView != null) {
            WatchLayoutWithTwoSubComplications watchLayoutWithTwoSubComplications = (WatchLayoutWithTwoSubComplications) view;
            r0 = R.id.imageViewWatchGlass;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchGlass, view);
            if (imageView2 != null) {
                r0 = R.id.imageViewWatchHandHours;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHours, view);
                if (imageView3 != null) {
                    r0 = R.id.imageViewWatchHandHoursComplication1;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHoursComplication1, view);
                    if (imageView4 != null) {
                        r0 = R.id.imageViewWatchHandHoursComplication2;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHoursComplication2, view);
                        if (imageView5 != null) {
                            r0 = R.id.imageViewWatchHandMinutes;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandMinutes, view);
                            if (imageView6 != null) {
                                return new WatchLayoutWithTwoSubComplications211Binding(watchLayoutWithTwoSubComplications, imageView, watchLayoutWithTwoSubComplications, imageView2, imageView3, imageView4, imageView5, imageView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WatchLayoutWithTwoSubComplications211Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WatchLayoutWithTwoSubComplications211Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.watch_layout_with_two_sub_complications_2_1_1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public WatchLayoutWithTwoSubComplications getRoot() {
        return this.rootView;
    }
}
