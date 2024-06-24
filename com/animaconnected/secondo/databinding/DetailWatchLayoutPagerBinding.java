package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.animaconnected.secondo.widget.DynamicHeightViewPager;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailWatchLayoutPagerBinding implements ViewBinding {
    public final CirclePageIndicator pageIndicator;
    private final LinearLayout rootView;
    public final DynamicHeightViewPager watchLayoutPager;

    private DetailWatchLayoutPagerBinding(LinearLayout linearLayout, CirclePageIndicator circlePageIndicator, DynamicHeightViewPager dynamicHeightViewPager) {
        this.rootView = linearLayout;
        this.pageIndicator = circlePageIndicator;
        this.watchLayoutPager = dynamicHeightViewPager;
    }

    public static DetailWatchLayoutPagerBinding bind(View view) {
        int r0 = R.id.page_indicator;
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) ViewBindings.findChildViewById(R.id.page_indicator, view);
        if (circlePageIndicator != null) {
            r0 = R.id.watch_layout_pager;
            DynamicHeightViewPager dynamicHeightViewPager = (DynamicHeightViewPager) ViewBindings.findChildViewById(R.id.watch_layout_pager, view);
            if (dynamicHeightViewPager != null) {
                return new DetailWatchLayoutPagerBinding((LinearLayout) view, circlePageIndicator, dynamicHeightViewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DetailWatchLayoutPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DetailWatchLayoutPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.detail_watch_layout_pager, viewGroup, false);
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
