package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.FeedbackView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsHabitTrackerBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    public final FrameLayout habitContentLayout;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private FragmentDetailsHabitTrackerBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FeedbackView feedbackView, FrameLayout frameLayout, TextView textView) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.habitContentLayout = frameLayout;
        this.titleTextView = textView;
    }

    public static FragmentDetailsHabitTrackerBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r0 = R.id.feature_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
        if (imageView != null) {
            r0 = R.id.feedback_view;
            FeedbackView feedbackView = (FeedbackView) ViewBindings.findChildViewById(R.id.feedback_view, view);
            if (feedbackView != null) {
                r0 = R.id.habit_content_layout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.habit_content_layout, view);
                if (frameLayout != null) {
                    r0 = R.id.title_text_view;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                    if (textView != null) {
                        return new FragmentDetailsHabitTrackerBinding(linearLayout, linearLayout, imageView, feedbackView, frameLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsHabitTrackerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsHabitTrackerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_habit_tracker, viewGroup, false);
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
