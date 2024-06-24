package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentLabsBinding implements ViewBinding {
    public final Button joinLabsButton;
    public final TextView labsCurrentlyFeatureDice;
    public final TextView labsCurrentlyFeaturePhoneBattery;
    public final TextView labsCurrentlyFeatureStopTime;
    public final LinearLayout labsCurrentlyFeaturesAvailable;
    public final TextView labsCurrentlyOutOfRange;
    public final TextView labsCurrentlyWatchFace;
    public final TextView labsDescriptionText;
    public final TopFadeScrollView labsScrollView;
    public final Button leaveLabsButton;
    public final LottieAnimationView lottieAnimationView;
    private final FrameLayout rootView;

    private FragmentLabsBinding(FrameLayout frameLayout, Button button, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5, TextView textView6, TopFadeScrollView topFadeScrollView, Button button2, LottieAnimationView lottieAnimationView) {
        this.rootView = frameLayout;
        this.joinLabsButton = button;
        this.labsCurrentlyFeatureDice = textView;
        this.labsCurrentlyFeaturePhoneBattery = textView2;
        this.labsCurrentlyFeatureStopTime = textView3;
        this.labsCurrentlyFeaturesAvailable = linearLayout;
        this.labsCurrentlyOutOfRange = textView4;
        this.labsCurrentlyWatchFace = textView5;
        this.labsDescriptionText = textView6;
        this.labsScrollView = topFadeScrollView;
        this.leaveLabsButton = button2;
        this.lottieAnimationView = lottieAnimationView;
    }

    public static FragmentLabsBinding bind(View view) {
        int r0 = R.id.join_labs_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.join_labs_button, view);
        if (button != null) {
            r0 = R.id.labs_currently_feature_dice;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.labs_currently_feature_dice, view);
            if (textView != null) {
                r0 = R.id.labs_currently_feature_phone_battery;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.labs_currently_feature_phone_battery, view);
                if (textView2 != null) {
                    r0 = R.id.labs_currently_feature_stop_time;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.labs_currently_feature_stop_time, view);
                    if (textView3 != null) {
                        r0 = R.id.labs_currently_features_available;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.labs_currently_features_available, view);
                        if (linearLayout != null) {
                            r0 = R.id.labs_currently_out_of_range;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.labs_currently_out_of_range, view);
                            if (textView4 != null) {
                                r0 = R.id.labs_currently_watch_face;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.labs_currently_watch_face, view);
                                if (textView5 != null) {
                                    r0 = R.id.labs_description_text;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.labs_description_text, view);
                                    if (textView6 != null) {
                                        r0 = R.id.labs_scrollView;
                                        TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.labs_scrollView, view);
                                        if (topFadeScrollView != null) {
                                            r0 = R.id.leave_labs_button;
                                            Button button2 = (Button) ViewBindings.findChildViewById(R.id.leave_labs_button, view);
                                            if (button2 != null) {
                                                r0 = R.id.lottie_animation_view;
                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(R.id.lottie_animation_view, view);
                                                if (lottieAnimationView != null) {
                                                    return new FragmentLabsBinding((FrameLayout) view, button, textView, textView2, textView3, linearLayout, textView4, textView5, textView6, topFadeScrollView, button2, lottieAnimationView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentLabsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_labs, viewGroup, false);
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
