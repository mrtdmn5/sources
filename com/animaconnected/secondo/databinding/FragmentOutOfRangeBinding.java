package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.FeedbackView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOutOfRangeBinding implements ViewBinding {
    public final LinearLayout container;
    public final LinearLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentOutOfRangeBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FeedbackView feedbackView, TextView textView) {
        this.rootView = relativeLayout;
        this.container = linearLayout;
        this.detailLayout = linearLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.titleTextView = textView;
    }

    public static FragmentOutOfRangeBinding bind(View view) {
        int r0 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
        if (linearLayout != null) {
            r0 = R.id.detail_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.detail_layout, view);
            if (linearLayout2 != null) {
                r0 = R.id.feature_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
                if (imageView != null) {
                    r0 = R.id.feedback_view;
                    FeedbackView feedbackView = (FeedbackView) ViewBindings.findChildViewById(R.id.feedback_view, view);
                    if (feedbackView != null) {
                        r0 = R.id.title_text_view;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                        if (textView != null) {
                            return new FragmentOutOfRangeBinding((RelativeLayout) view, linearLayout, linearLayout2, imageView, feedbackView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentOutOfRangeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOutOfRangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_out_of_range, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
