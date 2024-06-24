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
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsCameraBinding implements ViewBinding {
    public final ImageView featureIcon;
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;

    private FragmentDetailsCameraBinding(LinearLayout linearLayout, ImageView imageView, DetailLottieViewPager detailLottieViewPager, ImageView imageView2, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.featureIcon = imageView;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView2;
        this.pusherHeaderTitle = textView;
        this.titleTextView = textView2;
        this.triggerContainer = linearLayout2;
    }

    public static FragmentDetailsCameraBinding bind(View view) {
        int r0 = R.id.feature_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
        if (imageView != null) {
            r0 = R.id.lottie_animation_pager;
            DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
            if (detailLottieViewPager != null) {
                r0 = R.id.overview_end_line;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                if (imageView2 != null) {
                    r0 = R.id.pusher_header_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                    if (textView != null) {
                        r0 = R.id.title_text_view;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                        if (textView2 != null) {
                            r0 = R.id.trigger_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                            if (linearLayout != null) {
                                return new FragmentDetailsCameraBinding((LinearLayout) view, imageView, detailLottieViewPager, imageView2, textView, textView2, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_camera, viewGroup, false);
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
