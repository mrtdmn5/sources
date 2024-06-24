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
public final class FragmentDetailsMutePhoneBinding implements ViewBinding {
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;

    private FragmentDetailsMutePhoneBinding(LinearLayout linearLayout, DetailLottieViewPager detailLottieViewPager, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView;
        this.pusherHeaderTitle = textView;
        this.titleTextView = textView2;
        this.triggerContainer = linearLayout2;
    }

    public static FragmentDetailsMutePhoneBinding bind(View view) {
        int r0 = R.id.lottie_animation_pager;
        DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
        if (detailLottieViewPager != null) {
            r0 = R.id.overview_end_line;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
            if (imageView != null) {
                r0 = R.id.pusher_header_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                if (textView != null) {
                    r0 = R.id.title_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                    if (textView2 != null) {
                        r0 = R.id.trigger_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                        if (linearLayout != null) {
                            return new FragmentDetailsMutePhoneBinding((LinearLayout) view, detailLottieViewPager, imageView, textView, textView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsMutePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsMutePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_mute_phone, viewGroup, false);
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
