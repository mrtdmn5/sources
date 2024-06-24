package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.animaconnected.secondo.widget.WatchLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsTemperatureBinding implements ViewBinding {
    public final MorseCodeView crownPressMorse;
    public final LinearLayout detailLayout;
    public final ImageView imageViewMeter;
    public final WatchLayout imageViewMeterWatchHandContainer;
    public final ImageView imageViewWatchHandMinutes;
    public final LinearLayout overviewCrownContainer;
    public final ImageView overviewEndLine;
    public final LinearLayout overviewSubDialContainer;
    private final LinearLayout rootView;
    public final ImageView slotDivider;
    public final TextView subComplicationTitle;
    public final TextView temperatureScaleChoice;
    public final TextView titleTextView;
    public final TextView tvCurrentTemp;
    public final TextView tvMinuteScale;
    public final TextView tvPercentScale;

    private FragmentDetailsTemperatureBinding(LinearLayout linearLayout, MorseCodeView morseCodeView, LinearLayout linearLayout2, ImageView imageView, WatchLayout watchLayout, ImageView imageView2, LinearLayout linearLayout3, ImageView imageView3, LinearLayout linearLayout4, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.crownPressMorse = morseCodeView;
        this.detailLayout = linearLayout2;
        this.imageViewMeter = imageView;
        this.imageViewMeterWatchHandContainer = watchLayout;
        this.imageViewWatchHandMinutes = imageView2;
        this.overviewCrownContainer = linearLayout3;
        this.overviewEndLine = imageView3;
        this.overviewSubDialContainer = linearLayout4;
        this.slotDivider = imageView4;
        this.subComplicationTitle = textView;
        this.temperatureScaleChoice = textView2;
        this.titleTextView = textView3;
        this.tvCurrentTemp = textView4;
        this.tvMinuteScale = textView5;
        this.tvPercentScale = textView6;
    }

    public static FragmentDetailsTemperatureBinding bind(View view) {
        int r1 = R.id.crown_press_morse;
        MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.crown_press_morse, view);
        if (morseCodeView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            r1 = R.id.imageViewMeter;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.imageViewMeter, view);
            if (imageView != null) {
                r1 = R.id.imageViewMeterWatchHandContainer;
                WatchLayout watchLayout = (WatchLayout) ViewBindings.findChildViewById(R.id.imageViewMeterWatchHandContainer, view);
                if (watchLayout != null) {
                    r1 = R.id.imageViewWatchHandMinutes;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.imageViewWatchHandMinutes, view);
                    if (imageView2 != null) {
                        r1 = R.id.overview_crown_container;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_crown_container, view);
                        if (linearLayout2 != null) {
                            r1 = R.id.overview_end_line;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                            if (imageView3 != null) {
                                r1 = R.id.overview_sub_dial_container;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_sub_dial_container, view);
                                if (linearLayout3 != null) {
                                    r1 = R.id.slot_divider;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.slot_divider, view);
                                    if (imageView4 != null) {
                                        r1 = R.id.sub_complication_title;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.sub_complication_title, view);
                                        if (textView != null) {
                                            r1 = R.id.temperature_scale_choice;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.temperature_scale_choice, view);
                                            if (textView2 != null) {
                                                r1 = R.id.title_text_view;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                                if (textView3 != null) {
                                                    r1 = R.id.tv_current_temp;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_current_temp, view);
                                                    if (textView4 != null) {
                                                        r1 = R.id.tv_minute_scale;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_minute_scale, view);
                                                        if (textView5 != null) {
                                                            r1 = R.id.tv_percent_scale;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_percent_scale, view);
                                                            if (textView6 != null) {
                                                                return new FragmentDetailsTemperatureBinding(linearLayout, morseCodeView, linearLayout, imageView, watchLayout, imageView2, linearLayout2, imageView3, linearLayout3, imageView4, textView, textView2, textView3, textView4, textView5, textView6);
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

    public static FragmentDetailsTemperatureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsTemperatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_temperature, viewGroup, false);
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
