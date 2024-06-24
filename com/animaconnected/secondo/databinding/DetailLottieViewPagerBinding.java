package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailLottieViewPagerBinding implements ViewBinding {
    public final ProgressBar animationProgressBar;
    public final ViewPager animationViewPager;
    public final CirclePageIndicator pageIndicator;
    private final LinearLayout rootView;

    private DetailLottieViewPagerBinding(LinearLayout linearLayout, ProgressBar progressBar, ViewPager viewPager, CirclePageIndicator circlePageIndicator) {
        this.rootView = linearLayout;
        this.animationProgressBar = progressBar;
        this.animationViewPager = viewPager;
        this.pageIndicator = circlePageIndicator;
    }

    public static DetailLottieViewPagerBinding bind(View view) {
        int r0 = R.id.animation_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.animation_progress_bar, view);
        if (progressBar != null) {
            r0 = R.id.animation_view_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(R.id.animation_view_pager, view);
            if (viewPager != null) {
                r0 = R.id.page_indicator;
                CirclePageIndicator circlePageIndicator = (CirclePageIndicator) ViewBindings.findChildViewById(R.id.page_indicator, view);
                if (circlePageIndicator != null) {
                    return new DetailLottieViewPagerBinding((LinearLayout) view, progressBar, viewPager, circlePageIndicator);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DetailLottieViewPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DetailLottieViewPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.detail_lottie_view_pager, viewGroup, false);
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
