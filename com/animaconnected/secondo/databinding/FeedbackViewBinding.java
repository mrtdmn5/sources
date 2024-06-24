package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FeedbackViewBinding implements ViewBinding {
    public final Button labsFeedbackBtn;
    public final ImageView labsFeedbackBtnNegative;
    public final ImageView labsFeedbackBtnPositive;
    public final LinearLayout labsFeedbackView;
    private final LinearLayout rootView;

    private FeedbackViewBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.labsFeedbackBtn = button;
        this.labsFeedbackBtnNegative = imageView;
        this.labsFeedbackBtnPositive = imageView2;
        this.labsFeedbackView = linearLayout2;
    }

    public static FeedbackViewBinding bind(View view) {
        int r0 = R.id.labs_feedback_btn;
        Button button = (Button) ViewBindings.findChildViewById(R.id.labs_feedback_btn, view);
        if (button != null) {
            r0 = R.id.labs_feedback_btn_negative;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.labs_feedback_btn_negative, view);
            if (imageView != null) {
                r0 = R.id.labs_feedback_btn_positive;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.labs_feedback_btn_positive, view);
                if (imageView2 != null) {
                    r0 = R.id.labs_feedback_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.labs_feedback_view, view);
                    if (linearLayout != null) {
                        return new FeedbackViewBinding((LinearLayout) view, button, imageView, imageView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FeedbackViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeedbackViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.feedback_view, viewGroup, false);
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
