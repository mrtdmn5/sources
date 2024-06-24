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
public final class ItemDetailsChooserBinding implements ViewBinding {
    public final LinearLayout container;
    public final TextView optionName;
    public final TextView optionSub;
    private final LinearLayout rootView;
    public final ImageView selected;

    private ItemDetailsChooserBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = linearLayout;
        this.container = linearLayout2;
        this.optionName = textView;
        this.optionSub = textView2;
        this.selected = imageView;
    }

    public static ItemDetailsChooserBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r0 = R.id.option_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.option_name, view);
        if (textView != null) {
            r0 = R.id.option_sub;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.option_sub, view);
            if (textView2 != null) {
                r0 = R.id.selected;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.selected, view);
                if (imageView != null) {
                    return new ItemDetailsChooserBinding(linearLayout, linearLayout, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemDetailsChooserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDetailsChooserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_details_chooser, viewGroup, false);
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
