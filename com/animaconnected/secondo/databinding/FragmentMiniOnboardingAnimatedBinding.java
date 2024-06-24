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
public final class FragmentMiniOnboardingAnimatedBinding implements ViewBinding {
    public final LottieAnimationView animationView;
    public final TextView description;
    public final ProgressBar loadingProgressbar;
    public final RelativeLayout lottieContainer;
    private final LinearLayout rootView;
    public final TextView title;

    private FragmentMiniOnboardingAnimatedBinding(LinearLayout linearLayout, LottieAnimationView lottieAnimationView, TextView textView, ProgressBar progressBar, RelativeLayout relativeLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.animationView = lottieAnimationView;
        this.description = textView;
        this.loadingProgressbar = progressBar;
        this.lottieContainer = relativeLayout;
        this.title = textView2;
    }

    public static FragmentMiniOnboardingAnimatedBinding bind(View view) {
        int r0 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.animation_view, view);
        if (lottieAnimationView != null) {
            r0 = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.description, view);
            if (textView != null) {
                r0 = R.id.loading_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.loading_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.lottie_container;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.lottie_container, view);
                    if (relativeLayout != null) {
                        r0 = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title, view);
                        if (textView2 != null) {
                            return new FragmentMiniOnboardingAnimatedBinding((LinearLayout) view, lottieAnimationView, textView, progressBar, relativeLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentMiniOnboardingAnimatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMiniOnboardingAnimatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mini_onboarding_animated, viewGroup, false);
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
