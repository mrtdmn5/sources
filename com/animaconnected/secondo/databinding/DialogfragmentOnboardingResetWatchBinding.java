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
public final class DialogfragmentOnboardingResetWatchBinding implements ViewBinding {
    public final LottieAnimationView animationViewIn;
    public final RelativeLayout lottieContainer;
    private final LinearLayout rootView;
    public final ProgressBar setupProgressbar;
    public final TextView tipsAndTricksDescriptionShort;

    private DialogfragmentOnboardingResetWatchBinding(LinearLayout linearLayout, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView) {
        this.rootView = linearLayout;
        this.animationViewIn = lottieAnimationView;
        this.lottieContainer = relativeLayout;
        this.setupProgressbar = progressBar;
        this.tipsAndTricksDescriptionShort = textView;
    }

    public static DialogfragmentOnboardingResetWatchBinding bind(View view) {
        int r0 = R.id.animation_view_in;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.animation_view_in, view);
        if (lottieAnimationView != null) {
            r0 = R.id.lottie_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.lottie_container, view);
            if (relativeLayout != null) {
                r0 = R.id.setup_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.setup_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.tips_and_tricks_description_short;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tips_and_tricks_description_short, view);
                    if (textView != null) {
                        return new DialogfragmentOnboardingResetWatchBinding((LinearLayout) view, lottieAnimationView, relativeLayout, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentOnboardingResetWatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentOnboardingResetWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_onboarding_reset_watch, viewGroup, false);
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
