package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.FeedbackView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsPhoneBatteryBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private FragmentDetailsPhoneBatteryBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FeedbackView feedbackView, TextView textView) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.titleTextView = textView;
    }

    public static FragmentDetailsPhoneBatteryBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r0 = R.id.feature_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
        if (imageView != null) {
            r0 = R.id.feedback_view;
            FeedbackView feedbackView = (FeedbackView) ViewBindings.findChildViewById(R.id.feedback_view, view);
            if (feedbackView != null) {
                r0 = R.id.title_text_view;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                if (textView != null) {
                    return new FragmentDetailsPhoneBatteryBinding(linearLayout, linearLayout, imageView, feedbackView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsPhoneBatteryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsPhoneBatteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_phone_battery, viewGroup, false);
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
