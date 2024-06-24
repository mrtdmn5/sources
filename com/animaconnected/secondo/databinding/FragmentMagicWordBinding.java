package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.FeedbackView;
import com.google.android.material.textfield.TextInputEditText;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentMagicWordBinding implements ViewBinding {
    public final TextInputEditText addKeywordEditText;
    public final FrameLayout bottomDialogContainer;
    public final LinearLayout container;
    public final RelativeLayout detailLayout;
    public final ImageView featureIcon;
    public final FeedbackView feedbackView;
    public final RecyclerView magicWordRecyclerView;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentMagicWordBinding(RelativeLayout relativeLayout, TextInputEditText textInputEditText, FrameLayout frameLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, ImageView imageView, FeedbackView feedbackView, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.addKeywordEditText = textInputEditText;
        this.bottomDialogContainer = frameLayout;
        this.container = linearLayout;
        this.detailLayout = relativeLayout2;
        this.featureIcon = imageView;
        this.feedbackView = feedbackView;
        this.magicWordRecyclerView = recyclerView;
        this.titleTextView = textView;
    }

    public static FragmentMagicWordBinding bind(View view) {
        int r0 = R.id.add_keyword_edit_text;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.add_keyword_edit_text, view);
        if (textInputEditText != null) {
            r0 = R.id.bottom_dialog_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
            if (frameLayout != null) {
                r0 = R.id.container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
                if (linearLayout != null) {
                    r0 = R.id.detail_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.detail_layout, view);
                    if (relativeLayout != null) {
                        r0 = R.id.feature_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.feature_icon, view);
                        if (imageView != null) {
                            r0 = R.id.feedback_view;
                            FeedbackView feedbackView = (FeedbackView) ViewBindings.findChildViewById(R.id.feedback_view, view);
                            if (feedbackView != null) {
                                r0 = R.id.magic_word_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(R.id.magic_word_recycler_view, view);
                                if (recyclerView != null) {
                                    r0 = R.id.title_text_view;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                                    if (textView != null) {
                                        return new FragmentMagicWordBinding((RelativeLayout) view, textInputEditText, frameLayout, linearLayout, relativeLayout, imageView, feedbackView, recyclerView, textView);
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

    public static FragmentMagicWordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMagicWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_magic_word, viewGroup, false);
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
