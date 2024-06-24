package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.onboarding.OnboardingWatchAnimationsLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingAnimationsBinding implements ViewBinding {
    public final Button btnAddHybrid;
    public final Button btnAddPascal;
    public final Button btnCancel;
    public final ImageView imageViewArrow;
    public final ImageView imageViewButton;
    public final LinearLayout imageViewContainer;
    public final ImageView imageViewMeter;
    public final ImageView imageViewWatchHandHours;
    public final ImageView imageViewWatchHandMinutes;
    public final OnboardingWatchAnimationsLayout layoutWatchAnimation;
    private final RelativeLayout rootView;
    public final LinearLayout textContainer;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private FragmentOnboardingAnimationsBinding(RelativeLayout relativeLayout, Button button, Button button2, Button button3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, OnboardingWatchAnimationsLayout onboardingWatchAnimationsLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btnAddHybrid = button;
        this.btnAddPascal = button2;
        this.btnCancel = button3;
        this.imageViewArrow = imageView;
        this.imageViewButton = imageView2;
        this.imageViewContainer = linearLayout;
        this.imageViewMeter = imageView3;
        this.imageViewWatchHandHours = imageView4;
        this.imageViewWatchHandMinutes = imageView5;
        this.layoutWatchAnimation = onboardingWatchAnimationsLayout;
        this.textContainer = linearLayout2;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    public static FragmentOnboardingAnimationsBinding bind(View view) {
        int r1 = R.id.btn_add_hybrid;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_add_hybrid, view);
        if (button != null) {
            r1 = R.id.btn_add_pascal;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_add_pascal, view);
            if (button2 != null) {
                r1 = R.id.btn_cancel;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
                if (button3 != null) {
                    r1 = R.id.imageViewArrow;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewArrow, view);
                    if (imageView != null) {
                        r1 = R.id.imageViewButton;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewButton, view);
                        if (imageView2 != null) {
                            r1 = R.id.imageViewContainer;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.imageViewContainer, view);
                            if (linearLayout != null) {
                                r1 = R.id.imageViewMeter;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
                                if (imageView3 != null) {
                                    r1 = R.id.imageViewWatchHandHours;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandHours, view);
                                    if (imageView4 != null) {
                                        r1 = R.id.imageViewWatchHandMinutes;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandMinutes, view);
                                        if (imageView5 != null) {
                                            r1 = R.id.layoutWatchAnimation;
                                            OnboardingWatchAnimationsLayout onboardingWatchAnimationsLayout = (OnboardingWatchAnimationsLayout) ViewBindings.findChildViewById(R.id.layoutWatchAnimation, view);
                                            if (onboardingWatchAnimationsLayout != null) {
                                                r1 = R.id.text_container;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.text_container, view);
                                                if (linearLayout2 != null) {
                                                    r1 = R.id.tv_description;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_description, view);
                                                    if (textView != null) {
                                                        r1 = R.id.tv_title;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_title, view);
                                                        if (textView2 != null) {
                                                            return new FragmentOnboardingAnimationsBinding((RelativeLayout) view, button, button2, button3, imageView, imageView2, linearLayout, imageView3, imageView4, imageView5, onboardingWatchAnimationsLayout, linearLayout2, textView, textView2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentOnboardingAnimationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingAnimationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_animations, viewGroup, false);
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
