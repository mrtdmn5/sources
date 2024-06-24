package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.details.watch.DetailWatchPager;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsDateBinding implements ViewBinding {
    public final MorseCodeView crownPressMorse;
    public final DetailWatchPager detailWatchLayoutPager;
    public final TextView displayedDate;
    public final LinearLayout overviewCrownContainer;
    public final ImageView overviewEndLine;
    public final LinearLayout overviewSubDialContainer;
    private final LinearLayout rootView;
    public final ImageView slotDivider;
    public final TextView subComplicationTitle;
    public final TextView titleTextView;

    private FragmentDetailsDateBinding(LinearLayout linearLayout, MorseCodeView morseCodeView, DetailWatchPager detailWatchPager, TextView textView, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, ImageView imageView2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.crownPressMorse = morseCodeView;
        this.detailWatchLayoutPager = detailWatchPager;
        this.displayedDate = textView;
        this.overviewCrownContainer = linearLayout2;
        this.overviewEndLine = imageView;
        this.overviewSubDialContainer = linearLayout3;
        this.slotDivider = imageView2;
        this.subComplicationTitle = textView2;
        this.titleTextView = textView3;
    }

    public static FragmentDetailsDateBinding bind(View view) {
        int r0 = R.id.crown_press_morse;
        MorseCodeView morseCodeView = (MorseCodeView) ViewBindings.findChildViewById(R.id.crown_press_morse, view);
        if (morseCodeView != null) {
            r0 = R.id.detail_watch_layout_pager;
            DetailWatchPager detailWatchPager = (DetailWatchPager) ViewBindings.findChildViewById(R.id.detail_watch_layout_pager, view);
            if (detailWatchPager != null) {
                r0 = R.id.displayed_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.displayed_date, view);
                if (textView != null) {
                    r0 = R.id.overview_crown_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_crown_container, view);
                    if (linearLayout != null) {
                        r0 = R.id.overview_end_line;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                        if (imageView != null) {
                            r0 = R.id.overview_sub_dial_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.overview_sub_dial_container, view);
                            if (linearLayout2 != null) {
                                r0 = R.id.slot_divider;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.slot_divider, view);
                                if (imageView2 != null) {
                                    r0 = R.id.sub_complication_title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.sub_complication_title, view);
                                    if (textView2 != null) {
                                        r0 = R.id.title_text_view;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                        if (textView3 != null) {
                                            return new FragmentDetailsDateBinding((LinearLayout) view, morseCodeView, detailWatchPager, textView, linearLayout, imageView, linearLayout2, imageView2, textView2, textView3);
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

    public static FragmentDetailsDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_date, viewGroup, false);
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
