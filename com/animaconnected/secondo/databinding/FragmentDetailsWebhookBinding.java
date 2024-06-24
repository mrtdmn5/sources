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
public final class FragmentDetailsWebhookBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final LinearLayout webhookActionsContent;

    private FragmentDetailsWebhookBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FeedbackView feedbackView, TextView textView, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.titleTextView = textView;
        this.webhookActionsContent = linearLayout3;
    }

    public static FragmentDetailsWebhookBinding bind(View view) {
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
                    r0 = R.id.webhook_actions_content;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.webhook_actions_content, view);
                    if (linearLayout2 != null) {
                        return new FragmentDetailsWebhookBinding(linearLayout, linearLayout, imageView, feedbackView, textView, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsWebhookBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsWebhookBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_webhook, viewGroup, false);
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
