package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.FeedbackView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsCounterBinding implements ViewBinding {
    public final Button btnAddCount;
    public final Button btnCounterReset;
    public final Button btnDeleteCount;
    public final RelativeLayout countController;
    public final TextView currentCountAmountTextView;
    public final LinearLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    private final LinearLayout rootView;
    public final TextView titleTextView;

    private FragmentDetailsCounterBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout2, ImageView imageView, FeedbackView feedbackView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnAddCount = button;
        this.btnCounterReset = button2;
        this.btnDeleteCount = button3;
        this.countController = relativeLayout;
        this.currentCountAmountTextView = textView;
        this.detailLayout = linearLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.titleTextView = textView2;
    }

    public static FragmentDetailsCounterBinding bind(View view) {
        int r0 = R.id.btn_add_count;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_add_count, view);
        if (button != null) {
            r0 = R.id.btn_counter_reset;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_counter_reset, view);
            if (button2 != null) {
                r0 = R.id.btn_delete_count;
                Button button3 = (Button) ViewBindings.findChildViewById(R.id.btn_delete_count, view);
                if (button3 != null) {
                    r0 = R.id.count_controller;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.count_controller, view);
                    if (relativeLayout != null) {
                        r0 = R.id.current_count_amount_text_view;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.current_count_amount_text_view, view);
                        if (textView != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            r0 = R.id.feature_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
                            if (imageView != null) {
                                r0 = R.id.feedback_view;
                                FeedbackView feedbackView = (FeedbackView) ViewBindings.findChildViewById(R.id.feedback_view, view);
                                if (feedbackView != null) {
                                    r0 = R.id.title_text_view;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                    if (textView2 != null) {
                                        return new FragmentDetailsCounterBinding(linearLayout, button, button2, button3, relativeLayout, textView, linearLayout, imageView, feedbackView, textView2);
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

    public static FragmentDetailsCounterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsCounterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_counter, viewGroup, false);
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
