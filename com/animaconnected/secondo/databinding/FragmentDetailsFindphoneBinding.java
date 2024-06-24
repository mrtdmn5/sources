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
public final class FragmentDetailsFindphoneBinding implements ViewBinding {
    public final ImageView chevron;
    public final TextView findPhoneDescriptionAlwaysAvailable;
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final TextView setSound;
    public final LinearLayout setSoundContainer;
    public final TextView soundType;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;

    private FragmentDetailsFindphoneBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, DetailLottieViewPager detailLottieViewPager, ImageView imageView2, TextView textView2, TextView textView3, LinearLayout linearLayout2, TextView textView4, TextView textView5, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.chevron = imageView;
        this.findPhoneDescriptionAlwaysAvailable = textView;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView2;
        this.pusherHeaderTitle = textView2;
        this.setSound = textView3;
        this.setSoundContainer = linearLayout2;
        this.soundType = textView4;
        this.titleTextView = textView5;
        this.triggerContainer = linearLayout3;
    }

    public static FragmentDetailsFindphoneBinding bind(View view) {
        int r0 = R.id.chevron;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.chevron, view);
        if (imageView != null) {
            r0 = R.id.find_phone_description_always_available;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.find_phone_description_always_available, view);
            if (textView != null) {
                r0 = R.id.lottie_animation_pager;
                DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
                if (detailLottieViewPager != null) {
                    r0 = R.id.overview_end_line;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                    if (imageView2 != null) {
                        r0 = R.id.pusher_header_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                        if (textView2 != null) {
                            r0 = R.id.set_sound;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.set_sound, view);
                            if (textView3 != null) {
                                r0 = R.id.set_sound_container;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.set_sound_container, view);
                                if (linearLayout != null) {
                                    r0 = R.id.sound_type;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.sound_type, view);
                                    if (textView4 != null) {
                                        r0 = R.id.title_text_view;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                        if (textView5 != null) {
                                            r0 = R.id.trigger_container;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                                            if (linearLayout2 != null) {
                                                return new FragmentDetailsFindphoneBinding((LinearLayout) view, imageView, textView, detailLottieViewPager, imageView2, textView2, textView3, linearLayout, textView4, textView5, linearLayout2);
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

    public static FragmentDetailsFindphoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsFindphoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_findphone, viewGroup, false);
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
