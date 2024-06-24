package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentLabsMoreNumbersBinding implements ViewBinding {
    public final LottieAnimationView lottieAnimationView;
    public final SwitchCompat moreNumbersSwitch;
    private final FrameLayout rootView;
    public final ProgressBar setupProgressbar;
    public final TextView titleTextView;

    private FragmentLabsMoreNumbersBinding(FrameLayout frameLayout, LottieAnimationView lottieAnimationView, SwitchCompat switchCompat, ProgressBar progressBar, TextView textView) {
        this.rootView = frameLayout;
        this.lottieAnimationView = lottieAnimationView;
        this.moreNumbersSwitch = switchCompat;
        this.setupProgressbar = progressBar;
        this.titleTextView = textView;
    }

    public static FragmentLabsMoreNumbersBinding bind(View view) {
        int r0 = R.id.lottie_animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
        if (lottieAnimationView != null) {
            r0 = R.id.more_numbers_switch;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.more_numbers_switch, view);
            if (switchCompat != null) {
                r0 = R.id.setup_progressbar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.setup_progressbar, view);
                if (progressBar != null) {
                    r0 = R.id.title_text_view;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                    if (textView != null) {
                        return new FragmentLabsMoreNumbersBinding((FrameLayout) view, lottieAnimationView, switchCompat, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentLabsMoreNumbersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLabsMoreNumbersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_labs_more_numbers, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
