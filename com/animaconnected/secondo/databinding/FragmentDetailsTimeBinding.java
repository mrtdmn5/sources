package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPager;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsTimeBinding implements ViewBinding {
    public final MorseCodeView crownPressMorse;
    public final DetailWatchPager detailWatchLayoutPager;
    public final TextView displayedTime;
    public final ImageView homeChevron;
    public final TextView homeSetTimeZone;
    public final LinearLayout homeSetTimeZoneContainer;
    public final TextView homeTimeZoneGmtOffset;
    public final TextView homeTimeZoneName;
    public final SwitchCompat homeTimeZoneSwitch;
    public final LinearLayout overviewCrownContainer;
    public final ImageView overviewEndLine;
    public final LinearLayout overviewSubDialContainer;
    private final LinearLayout rootView;
    public final TextView setTimeZone;
    public final LinearLayout setTimeZoneContainer;
    public final ImageView slotDivider;
    public final TextView subComplicationTitle;
    public final TextView timeZoneGmtOffset;
    public final TextView timeZoneName;
    public final TextView titleTextView;

    private FragmentDetailsTimeBinding(LinearLayout linearLayout, MorseCodeView morseCodeView, DetailWatchPager detailWatchPager, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, SwitchCompat switchCompat, LinearLayout linearLayout3, ImageView imageView2, LinearLayout linearLayout4, TextView textView5, LinearLayout linearLayout5, ImageView imageView3, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.crownPressMorse = morseCodeView;
        this.detailWatchLayoutPager = detailWatchPager;
        this.displayedTime = textView;
        this.homeChevron = imageView;
        this.homeSetTimeZone = textView2;
        this.homeSetTimeZoneContainer = linearLayout2;
        this.homeTimeZoneGmtOffset = textView3;
        this.homeTimeZoneName = textView4;
        this.homeTimeZoneSwitch = switchCompat;
        this.overviewCrownContainer = linearLayout3;
        this.overviewEndLine = imageView2;
        this.overviewSubDialContainer = linearLayout4;
        this.setTimeZone = textView5;
        this.setTimeZoneContainer = linearLayout5;
        this.slotDivider = imageView3;
        this.subComplicationTitle = textView6;
        this.timeZoneGmtOffset = textView7;
        this.timeZoneName = textView8;
        this.titleTextView = textView9;
    }

    public static FragmentDetailsTimeBinding bind(View view) {
        int r1 = R.id.crown_press_morse;
        MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.crown_press_morse, view);
        if (morseCodeView != null) {
            r1 = R.id.detail_watch_layout_pager;
            DetailWatchPager detailWatchPager = (DetailWatchPager) ViewBindings.findChildViewById(R.id.detail_watch_layout_pager, view);
            if (detailWatchPager != null) {
                r1 = R.id.displayed_time;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.displayed_time, view);
                if (textView != null) {
                    r1 = R.id.home_chevron;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.home_chevron, view);
                    if (imageView != null) {
                        r1 = R.id.home_set_time_zone;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.home_set_time_zone, view);
                        if (textView2 != null) {
                            r1 = R.id.home_set_time_zone_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.home_set_time_zone_container, view);
                            if (linearLayout != null) {
                                r1 = R.id.home_time_zone_gmt_offset;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.home_time_zone_gmt_offset, view);
                                if (textView3 != null) {
                                    r1 = R.id.home_time_zone_name;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.home_time_zone_name, view);
                                    if (textView4 != null) {
                                        r1 = R.id.home_time_zone_switch;
                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.home_time_zone_switch, view);
                                        if (switchCompat != null) {
                                            r1 = R.id.overview_crown_container;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_crown_container, view);
                                            if (linearLayout2 != null) {
                                                r1 = R.id.overview_end_line;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                                                if (imageView2 != null) {
                                                    r1 = R.id.overview_sub_dial_container;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_sub_dial_container, view);
                                                    if (linearLayout3 != null) {
                                                        r1 = R.id.set_time_zone;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.set_time_zone, view);
                                                        if (textView5 != null) {
                                                            r1 = R.id.set_time_zone_container;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(R.id.set_time_zone_container, view);
                                                            if (linearLayout4 != null) {
                                                                r1 = R.id.slot_divider;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.slot_divider, view);
                                                                if (imageView3 != null) {
                                                                    r1 = R.id.sub_complication_title;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.sub_complication_title, view);
                                                                    if (textView6 != null) {
                                                                        r1 = R.id.time_zone_gmt_offset;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(R.id.time_zone_gmt_offset, view);
                                                                        if (textView7 != null) {
                                                                            r1 = R.id.time_zone_name;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(R.id.time_zone_name, view);
                                                                            if (textView8 != null) {
                                                                                r1 = R.id.title_text_view;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                                                                if (textView9 != null) {
                                                                                    return new FragmentDetailsTimeBinding((LinearLayout) view, morseCodeView, detailWatchPager, textView, imageView, textView2, linearLayout, textView3, textView4, switchCompat, linearLayout2, imageView2, linearLayout3, textView5, linearLayout4, imageView3, textView6, textView7, textView8, textView9);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentDetailsTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_time, viewGroup, false);
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
