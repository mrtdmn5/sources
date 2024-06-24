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
public final class FragmentDetailsRememberThisSpotBinding implements ViewBinding {
    public final TextView lastSpot;
    public final LinearLayout lastSpotContainer;
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;

    private FragmentDetailsRememberThisSpotBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, DetailLottieViewPager detailLottieViewPager, ImageView imageView, TextView textView2, TextView textView3, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.lastSpot = textView;
        this.lastSpotContainer = linearLayout2;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView;
        this.pusherHeaderTitle = textView2;
        this.titleTextView = textView3;
        this.triggerContainer = linearLayout3;
    }

    public static FragmentDetailsRememberThisSpotBinding bind(View view) {
        int r0 = R.id.last_spot;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.last_spot, view);
        if (textView != null) {
            r0 = R.id.last_spot_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.last_spot_container, view);
            if (linearLayout != null) {
                r0 = R.id.lottie_animation_pager;
                DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
                if (detailLottieViewPager != null) {
                    r0 = R.id.overview_end_line;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                    if (imageView != null) {
                        r0 = R.id.pusher_header_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                        if (textView2 != null) {
                            r0 = R.id.title_text_view;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                            if (textView3 != null) {
                                r0 = R.id.trigger_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                                if (linearLayout2 != null) {
                                    return new FragmentDetailsRememberThisSpotBinding((LinearLayout) view, textView, linearLayout, detailLottieViewPager, imageView, textView2, textView3, linearLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsRememberThisSpotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsRememberThisSpotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_remember_this_spot, viewGroup, false);
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
