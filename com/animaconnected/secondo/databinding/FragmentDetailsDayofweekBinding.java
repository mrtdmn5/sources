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
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsDayofweekBinding implements ViewBinding {
    public final DetailWatchPager detailWatchLayoutPager;
    public final TextView displayedDayofweek;
    public final ImageView overviewEndLine;
    private final LinearLayout rootView;
    public final TextView subComplicationTitle;
    public final TextView titleTextView;

    private FragmentDetailsDayofweekBinding(LinearLayout linearLayout, DetailWatchPager detailWatchPager, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.detailWatchLayoutPager = detailWatchPager;
        this.displayedDayofweek = textView;
        this.overviewEndLine = imageView;
        this.subComplicationTitle = textView2;
        this.titleTextView = textView3;
    }

    public static FragmentDetailsDayofweekBinding bind(View view) {
        int r0 = R.id.detail_watch_layout_pager;
        DetailWatchPager detailWatchPager = (DetailWatchPager) ViewBindings.findChildViewById(R.id.detail_watch_layout_pager, view);
        if (detailWatchPager != null) {
            r0 = R.id.displayed_dayofweek;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.displayed_dayofweek, view);
            if (textView != null) {
                r0 = R.id.overview_end_line;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                if (imageView != null) {
                    r0 = R.id.sub_complication_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.sub_complication_title, view);
                    if (textView2 != null) {
                        r0 = R.id.title_text_view;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                        if (textView3 != null) {
                            return new FragmentDetailsDayofweekBinding((LinearLayout) view, detailWatchPager, textView, imageView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsDayofweekBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsDayofweekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_dayofweek, viewGroup, false);
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
