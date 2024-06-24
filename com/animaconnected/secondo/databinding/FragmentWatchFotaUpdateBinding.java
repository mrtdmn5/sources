package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentWatchFotaUpdateBinding implements ViewBinding {
    public final TextView fotaProgressText;
    public final LottieAnimationView lottieAnimationView;
    public final ProgressBar pausedView;
    private final RelativeLayout rootView;
    public final Button startUpdateButton;
    public final LinearLayout startUpdateLayout;
    public final TextView startUpdateVarningText;

    private FragmentWatchFotaUpdateBinding(RelativeLayout relativeLayout, TextView textView, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Button button, LinearLayout linearLayout, TextView textView2) {
        this.rootView = relativeLayout;
        this.fotaProgressText = textView;
        this.lottieAnimationView = lottieAnimationView;
        this.pausedView = progressBar;
        this.startUpdateButton = button;
        this.startUpdateLayout = linearLayout;
        this.startUpdateVarningText = textView2;
    }

    public static FragmentWatchFotaUpdateBinding bind(View view) {
        int r0 = R.id.fota_progress_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.fota_progress_text, view);
        if (textView != null) {
            r0 = R.id.lottie_animation_view;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
            if (lottieAnimationView != null) {
                r0 = R.id.paused_view;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.paused_view, view);
                if (progressBar != null) {
                    r0 = R.id.start_update_button;
                    Button button = (Button) ViewBindings.findChildViewById(R.id.start_update_button, view);
                    if (button != null) {
                        r0 = R.id.start_update_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.start_update_layout, view);
                        if (linearLayout != null) {
                            r0 = R.id.start_update_varning_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.start_update_varning_text, view);
                            if (textView2 != null) {
                                return new FragmentWatchFotaUpdateBinding((RelativeLayout) view, textView, lottieAnimationView, progressBar, button, linearLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentWatchFotaUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWatchFotaUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_watch_fota_update, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
