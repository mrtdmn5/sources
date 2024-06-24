package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsIftttBinding implements ViewBinding {
    public final TextView iftttDescriptionTxt;
    public final LinearLayout iftttOverviewSection;
    public final LinearLayout locationCheckboxContainer;
    public final TextView locationCheckboxDescription;
    public final TextView locationCheckboxTitle;
    public final SwitchCompat locationSwitch;
    public final DetailLottieViewPager lottieAnimationPager;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final Button setupBtn;
    public final ProgressBar setupProgressbar;
    public final TextView titleTextView;
    public final LinearLayout triggerContainer;
    public final TextView websiteDescriptionText;

    private FragmentDetailsIftttBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3, SwitchCompat switchCompat, DetailLottieViewPager detailLottieViewPager, ImageView imageView, TextView textView4, Button button, ProgressBar progressBar, TextView textView5, LinearLayout linearLayout4, TextView textView6) {
        this.rootView = linearLayout;
        this.iftttDescriptionTxt = textView;
        this.iftttOverviewSection = linearLayout2;
        this.locationCheckboxContainer = linearLayout3;
        this.locationCheckboxDescription = textView2;
        this.locationCheckboxTitle = textView3;
        this.locationSwitch = switchCompat;
        this.lottieAnimationPager = detailLottieViewPager;
        this.overviewEndLine = imageView;
        this.pusherHeaderTitle = textView4;
        this.setupBtn = button;
        this.setupProgressbar = progressBar;
        this.titleTextView = textView5;
        this.triggerContainer = linearLayout4;
        this.websiteDescriptionText = textView6;
    }

    public static FragmentDetailsIftttBinding bind(View view) {
        int r1 = R.id.ifttt_description_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.ifttt_description_txt, view);
        if (textView != null) {
            r1 = R.id.ifttt_overview_section;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.ifttt_overview_section, view);
            if (linearLayout != null) {
                r1 = R.id.location_checkbox_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.location_checkbox_container, view);
                if (linearLayout2 != null) {
                    r1 = R.id.location_checkbox_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.location_checkbox_description, view);
                    if (textView2 != null) {
                        r1 = R.id.location_checkbox_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.location_checkbox_title, view);
                        if (textView3 != null) {
                            r1 = R.id.location_switch;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.location_switch, view);
                            if (switchCompat != null) {
                                r1 = R.id.lottie_animation_pager;
                                DetailLottieViewPager detailLottieViewPager = (DetailLottieViewPager) ViewBindings.findChildViewById(R.id.lottie_animation_pager, view);
                                if (detailLottieViewPager != null) {
                                    r1 = R.id.overview_end_line;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                                    if (imageView != null) {
                                        r1 = R.id.pusher_header_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                                        if (textView4 != null) {
                                            r1 = R.id.setup_btn;
                                            Button button = (Button) ViewBindings.findChildViewById(R.id.setup_btn, view);
                                            if (button != null) {
                                                r1 = R.id.setup_progressbar;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.setup_progressbar, view);
                                                if (progressBar != null) {
                                                    r1 = R.id.title_text_view;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                                    if (textView5 != null) {
                                                        r1 = R.id.trigger_container;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.trigger_container, view);
                                                        if (linearLayout3 != null) {
                                                            r1 = R.id.website_description_text;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.website_description_text, view);
                                                            if (textView6 != null) {
                                                                return new FragmentDetailsIftttBinding((LinearLayout) view, textView, linearLayout, linearLayout2, textView2, textView3, switchCompat, detailLottieViewPager, imageView, textView4, button, progressBar, textView5, linearLayout3, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentDetailsIftttBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsIftttBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_ifttt, viewGroup, false);
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
