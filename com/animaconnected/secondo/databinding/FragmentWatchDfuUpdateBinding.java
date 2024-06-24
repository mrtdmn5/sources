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
public final class FragmentWatchDfuUpdateBinding implements ViewBinding {
    public final ProgressBar dfuProgressBar;
    public final TextView dfuProgressStep;
    public final TextView dfuProgressText;
    public final LottieAnimationView lottieAnimationView;
    public final ProgressBar pausedView;
    private final RelativeLayout rootView;
    public final Button startUpdateButton;
    public final ProgressBar startUpdateButtonProgress;
    public final LinearLayout startUpdateLayout;
    public final TextView startUpdateVarningText;
    public final LinearLayout updateProgressLayout;

    private FragmentWatchDfuUpdateBinding(RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, TextView textView2, LottieAnimationView lottieAnimationView, ProgressBar progressBar2, Button button, ProgressBar progressBar3, LinearLayout linearLayout, TextView textView3, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.dfuProgressBar = progressBar;
        this.dfuProgressStep = textView;
        this.dfuProgressText = textView2;
        this.lottieAnimationView = lottieAnimationView;
        this.pausedView = progressBar2;
        this.startUpdateButton = button;
        this.startUpdateButtonProgress = progressBar3;
        this.startUpdateLayout = linearLayout;
        this.startUpdateVarningText = textView3;
        this.updateProgressLayout = linearLayout2;
    }

    public static FragmentWatchDfuUpdateBinding bind(View view) {
        int r0 = R.id.dfu_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.dfu_progress_bar, view);
        if (progressBar != null) {
            r0 = R.id.dfu_progress_step;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dfu_progress_step, view);
            if (textView != null) {
                r0 = R.id.dfu_progress_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.dfu_progress_text, view);
                if (textView2 != null) {
                    r0 = R.id.lottie_animation_view;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
                    if (lottieAnimationView != null) {
                        r0 = R.id.paused_view;
                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(R.id.paused_view, view);
                        if (progressBar2 != null) {
                            r0 = R.id.start_update_button;
                            Button button = (Button) ViewBindings.findChildViewById(R.id.start_update_button, view);
                            if (button != null) {
                                r0 = R.id.start_update_button_progress;
                                ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(R.id.start_update_button_progress, view);
                                if (progressBar3 != null) {
                                    r0 = R.id.start_update_layout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.start_update_layout, view);
                                    if (linearLayout != null) {
                                        r0 = R.id.start_update_varning_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.start_update_varning_text, view);
                                        if (textView3 != null) {
                                            r0 = R.id.update_progress_layout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.update_progress_layout, view);
                                            if (linearLayout2 != null) {
                                                return new FragmentWatchDfuUpdateBinding((RelativeLayout) view, progressBar, textView, textView2, lottieAnimationView, progressBar2, button, progressBar3, linearLayout, textView3, linearLayout2);
                                            }
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

    public static FragmentWatchDfuUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWatchDfuUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_watch_dfu_update, viewGroup, false);
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
