package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentAlarmBinding implements ViewBinding {
    public final ComposeView alarmLayout;
    public final LinearLayout container;
    public final ImageView featureIcon;
    public final TopFadeScrollView fragmentContainer;
    public final ImageView overviewEndLine;
    public final TextView pusherHeaderTitle;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private FragmentAlarmBinding(LinearLayout linearLayout, ComposeView composeView, LinearLayout linearLayout2, ImageView imageView, TopFadeScrollView topFadeScrollView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.alarmLayout = composeView;
        this.container = linearLayout2;
        this.featureIcon = imageView;
        this.fragmentContainer = topFadeScrollView;
        this.overviewEndLine = imageView2;
        this.pusherHeaderTitle = textView;
        this.titleTextView = textView2;
    }

    public static FragmentAlarmBinding bind(View view) {
        int r0 = R.id.alarm_layout;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(R.id.alarm_layout, view);
        if (composeView != null) {
            r0 = R.id.container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
            if (linearLayout != null) {
                r0 = R.id.feature_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
                if (imageView != null) {
                    r0 = R.id.fragment_container;
                    TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.fragment_container, view);
                    if (topFadeScrollView != null) {
                        r0 = R.id.overview_end_line;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.overview_end_line, view);
                        if (imageView2 != null) {
                            r0 = R.id.pusher_header_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.pusher_header_title, view);
                            if (textView != null) {
                                r0 = R.id.title_text_view;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                if (textView2 != null) {
                                    return new FragmentAlarmBinding((LinearLayout) view, composeView, linearLayout, imageView, topFadeScrollView, imageView2, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentAlarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAlarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_alarm, viewGroup, false);
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
