package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemWatchAppBinding implements ViewBinding {
    public final ImageView badge;
    public final ImageView ivAffordance;
    public final ImageView ivIconBackgroundDrag;
    public final ImageView ivIconBackgroundDrop;
    public final ImageView ivIconForeground;
    public final ImageView ivQuickAction;
    public final RelativeLayout layoutItemWatchAppIcon;
    public final RelativeLayout listItem;
    public final RadioButton radioButton;
    private final RelativeLayout rootView;
    public final TextView tvAppTitle;
    public final RelativeLayout viewRadioButton;

    private ItemWatchAppBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RadioButton radioButton, TextView textView, RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.badge = imageView;
        this.ivAffordance = imageView2;
        this.ivIconBackgroundDrag = imageView3;
        this.ivIconBackgroundDrop = imageView4;
        this.ivIconForeground = imageView5;
        this.ivQuickAction = imageView6;
        this.layoutItemWatchAppIcon = relativeLayout2;
        this.listItem = relativeLayout3;
        this.radioButton = radioButton;
        this.tvAppTitle = textView;
        this.viewRadioButton = relativeLayout4;
    }

    public static ItemWatchAppBinding bind(View view) {
        int r0 = R.id.badge;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.badge, view);
        if (imageView != null) {
            r0 = R.id.ivAffordance;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.ivAffordance, view);
            if (imageView2 != null) {
                r0 = R.id.ivIconBackgroundDrag;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(R.id.ivIconBackgroundDrag, view);
                if (imageView3 != null) {
                    r0 = R.id.ivIconBackgroundDrop;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(R.id.ivIconBackgroundDrop, view);
                    if (imageView4 != null) {
                        r0 = R.id.ivIconForeground;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(R.id.ivIconForeground, view);
                        if (imageView5 != null) {
                            r0 = R.id.ivQuickAction;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(R.id.ivQuickAction, view);
                            if (imageView6 != null) {
                                r0 = R.id.layout_item_watch_app_icon;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.layout_item_watch_app_icon, view);
                                if (relativeLayout != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                    r0 = R.id.radioButton;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(R.id.radioButton, view);
                                    if (radioButton != null) {
                                        r0 = R.id.tv_app_title;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_app_title, view);
                                        if (textView != null) {
                                            r0 = R.id.view_radio_button;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(R.id.view_radio_button, view);
                                            if (relativeLayout3 != null) {
                                                return new ItemWatchAppBinding(relativeLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout, relativeLayout2, radioButton, textView, relativeLayout3);
                                            }
                                        }
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

    public static ItemWatchAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemWatchAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_watch_app, viewGroup, false);
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
