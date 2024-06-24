package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailLottiePageBinding implements ViewBinding {
    public final TextView animationTitle;
    public final LottieAnimationView animationView;
    public final ProgressBar loadingProgressbar;
    public final RelativeLayout lottieContainer;
    private final LinearLayout rootView;

    private DetailLottiePageBinding(LinearLayout linearLayout, TextView textView, LottieAnimationView lottieAnimationView, ProgressBar progressBar, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.animationTitle = textView;
        this.animationView = lottieAnimationView;
        this.loadingProgressbar = progressBar;
        this.lottieContainer = relativeLayout;
    }

    public static DetailLottiePageBinding bind(View view) {
        int r0 = R.id.animation_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.animation_title, view);
        if (textView != null) {
            r0 = R.id.animation_view;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.animation_view, view);
            if (lottieAnimationView != null) {
                r0 = R.id.loading_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.loading_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.lottie_container;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.lottie_container, view);
                    if (relativeLayout != null) {
                        return new DetailLottiePageBinding((LinearLayout) view, textView, lottieAnimationView, progressBar, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DetailLottiePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DetailLottiePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.detail_lottie_page, viewGroup, false);
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
