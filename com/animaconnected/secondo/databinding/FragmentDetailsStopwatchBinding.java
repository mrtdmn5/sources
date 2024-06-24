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
public final class FragmentDetailsStopwatchBinding implements ViewBinding {
    public final ImageView chevron;
    public final LinearLayout contentWithoutDescription;
    public final MorseCodeView crownPressMorse;
    public final LinearLayout lastSessionButton;
    public final TextView lastSessionTime;
    public final TextView lastSessionTitle;
    public final DetailLottieViewPager miniOnboardingPager;
    public final ImageView overviewEndLine;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private FragmentDetailsStopwatchBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, MorseCodeView morseCodeView, LinearLayout linearLayout3, TextView textView, TextView textView2, DetailLottieViewPager detailLottieViewPager, ImageView imageView2, TextView textView3) {
        this.rootView = linearLayout;
        this.chevron = imageView;
        this.contentWithoutDescription = linearLayout2;
        this.crownPressMorse = morseCodeView;
        this.lastSessionButton = linearLayout3;
        this.lastSessionTime = textView;
        this.lastSessionTitle = textView2;
        this.miniOnboardingPager = detailLottieViewPager;
        this.overviewEndLine = imageView2;
        this.titleTextView = textView3;
    }

    public static FragmentDetailsStopwatchBinding bind(View view) {
        int r0 = R.id.chevron;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.chevron, view);
        if (imageView != null) {
            r0 = R.id.content_without_description;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.content_without_description, view);
            if (linearLayout != null) {
                r0 = R.id.crown_press_morse;
                MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.crown_press_morse, view);
                if (morseCodeView != null) {
                    r0 = R.id.last_session_button;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.last_session_button, view);
                    if (linearLayout2 != null) {
                        r0 = R.id.last_session_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.last_session_time, view);
                        if (textView != null) {
                            r0 = R.id.last_session_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.last_session_title, view);
                            if (textView2 != null) {
                                r0 = R.id.mini_onboarding_pager;
                                DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.mini_onboarding_pager, view);
                                if (detailLottieViewPager != null) {
                                    r0 = R.id.overview_end_line;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                                    if (imageView2 != null) {
                                        r0 = R.id.title_text_view;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                        if (textView3 != null) {
                                            return new FragmentDetailsStopwatchBinding((LinearLayout) view, imageView, linearLayout, morseCodeView, linearLayout2, textView, textView2, detailLottieViewPager, imageView2, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsStopwatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsStopwatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_stopwatch, viewGroup, false);
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
