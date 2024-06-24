package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailBottomDialogBinding implements ViewBinding {
    public final ImageView bottomDialogBadge;
    public final Button bottomDialogButton;
    public final TextView bottomDialogDescription;
    public final FrameLayout bottomDialogStripe;
    public final TextView bottomDialogTitle;
    private final LinearLayout rootView;

    private FragmentDetailBottomDialogBinding(LinearLayout linearLayout, ImageView imageView, Button button, TextView textView, FrameLayout frameLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.bottomDialogBadge = imageView;
        this.bottomDialogButton = button;
        this.bottomDialogDescription = textView;
        this.bottomDialogStripe = frameLayout;
        this.bottomDialogTitle = textView2;
    }

    public static FragmentDetailBottomDialogBinding bind(View view) {
        int r0 = R.id.bottom_dialog_badge;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.bottom_dialog_badge, view);
        if (imageView != null) {
            r0 = R.id.bottom_dialog_button;
            Button button = (Button) ViewBindings.findChildViewById(R.id.bottom_dialog_button, view);
            if (button != null) {
                r0 = R.id.bottom_dialog_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.bottom_dialog_description, view);
                if (textView != null) {
                    r0 = R.id.bottom_dialog_stripe;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_stripe, view);
                    if (frameLayout != null) {
                        r0 = R.id.bottom_dialog_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.bottom_dialog_title, view);
                        if (textView2 != null) {
                            return new FragmentDetailBottomDialogBinding((LinearLayout) view, imageView, button, textView, frameLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailBottomDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailBottomDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_detail_bottom_dialog, viewGroup, false);
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
