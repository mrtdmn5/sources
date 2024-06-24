package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDebugLottiePreviewBinding implements ViewBinding {
    public final LottieAnimationView lottieAnimationView;
    public final TextView lottieLoadTime;
    private final LinearLayout rootView;
    public final Button selectLottieButton;

    private FragmentDebugLottiePreviewBinding(LinearLayout linearLayout, LottieAnimationView lottieAnimationView, TextView textView, Button button) {
        this.rootView = linearLayout;
        this.lottieAnimationView = lottieAnimationView;
        this.lottieLoadTime = textView;
        this.selectLottieButton = button;
    }

    public static FragmentDebugLottiePreviewBinding bind(View view) {
        int r0 = R.id.lottie_animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
        if (lottieAnimationView != null) {
            r0 = R.id.lottie_load_time;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.lottie_load_time, view);
            if (textView != null) {
                r0 = R.id.select_lottie_button;
                Button button = (Button) ViewBindings.findChildViewById(R.id.select_lottie_button, view);
                if (button != null) {
                    return new FragmentDebugLottiePreviewBinding((LinearLayout) view, lottieAnimationView, textView, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDebugLottiePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDebugLottiePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_lottie_preview, viewGroup, false);
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
