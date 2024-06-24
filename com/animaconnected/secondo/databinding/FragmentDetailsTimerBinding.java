package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsTimerBinding implements ViewBinding {
    public final MorseCodeView crownPressMorse;
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    private final LinearLayout rootView;
    public final LinearLayout timerOverviewSection;
    public final TextView titleTextView;
    public final LinearLayout triggerLayoutAdjusting;

    private FragmentDetailsTimerBinding(LinearLayout linearLayout, MorseCodeView morseCodeView, DetailLottieViewPager detailLottieViewPager, ImageView imageView, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.crownPressMorse = morseCodeView;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView;
        this.timerOverviewSection = linearLayout2;
        this.titleTextView = textView;
        this.triggerLayoutAdjusting = linearLayout3;
    }

    public static FragmentDetailsTimerBinding bind(View view) {
        int r0 = R.id.crown_press_morse;
        MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.crown_press_morse, view);
        if (morseCodeView != null) {
            r0 = R.id.lottie_animation_pager;
            DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
            if (detailLottieViewPager != null) {
                r0 = R.id.overview_end_line;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                if (imageView != null) {
                    r0 = R.id.timer_overview_section;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.timer_overview_section, view);
                    if (linearLayout != null) {
                        r0 = R.id.title_text_view;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                        if (textView != null) {
                            r0 = R.id.trigger_layout_adjusting;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_layout_adjusting, view);
                            if (linearLayout2 != null) {
                                return new FragmentDetailsTimerBinding((LinearLayout) view, morseCodeView, detailLottieViewPager, imageView, linearLayout, textView, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsTimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsTimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_timer, viewGroup, false);
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
