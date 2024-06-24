package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailQuickActionHeaderLayoutBinding implements ViewBinding {
    public final ImageView ivChevron;
    public final LinearLayout quickActionContainer;
    public final TextView quickActionDescription;
    public final TextView quickActionDescriptionLongPress;
    public final LinearLayout quickActionHeader;
    private final View rootView;

    private DetailQuickActionHeaderLayoutBinding(View view, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.rootView = view;
        this.ivChevron = imageView;
        this.quickActionContainer = linearLayout;
        this.quickActionDescription = textView;
        this.quickActionDescriptionLongPress = textView2;
        this.quickActionHeader = linearLayout2;
    }

    public static DetailQuickActionHeaderLayoutBinding bind(View view) {
        int r0 = R.id.iv_chevron;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.iv_chevron, view);
        if (imageView != null) {
            r0 = R.id.quick_action_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.quick_action_container, view);
            if (linearLayout != null) {
                r0 = R.id.quick_action_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.quick_action_description, view);
                if (textView != null) {
                    r0 = R.id.quick_action_description_long_press;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.quick_action_description_long_press, view);
                    if (textView2 != null) {
                        r0 = R.id.quick_action_header;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.quick_action_header, view);
                        if (linearLayout2 != null) {
                            return new DetailQuickActionHeaderLayoutBinding(view, imageView, linearLayout, textView, textView2, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DetailQuickActionHeaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.detail_quick_action_header_layout, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
