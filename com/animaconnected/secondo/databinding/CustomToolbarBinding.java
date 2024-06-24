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
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class CustomToolbarBinding implements ViewBinding {
    public final AnimatedToolbar animatedToolbar;
    public final ImageView helpButton;
    public final ImageView quietHoursButton;
    private final LinearLayout rootView;
    public final TextView toolbarAction;
    public final TextView toolbarTitle;
    public final FrameLayout touchAreaHelpButton;
    public final FrameLayout touchAreaQuietHoursButton;

    private CustomToolbarBinding(LinearLayout linearLayout, AnimatedToolbar animatedToolbar, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.animatedToolbar = animatedToolbar;
        this.helpButton = imageView;
        this.quietHoursButton = imageView2;
        this.toolbarAction = textView;
        this.toolbarTitle = textView2;
        this.touchAreaHelpButton = frameLayout;
        this.touchAreaQuietHoursButton = frameLayout2;
    }

    public static CustomToolbarBinding bind(View view) {
        int r0 = R.id.animated_toolbar;
        AnimatedToolbar animatedToolbar = (AnimatedToolbar) ViewBindings.findChildViewById(R.id.animated_toolbar, view);
        if (animatedToolbar != null) {
            r0 = R.id.help_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.help_button, view);
            if (imageView != null) {
                r0 = R.id.quiet_hours_button;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.quiet_hours_button, view);
                if (imageView2 != null) {
                    r0 = R.id.toolbar_action;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.toolbar_action, view);
                    if (textView != null) {
                        r0 = R.id.toolbar_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.toolbar_title, view);
                        if (textView2 != null) {
                            r0 = R.id.touch_area_help_button;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.touch_area_help_button, view);
                            if (frameLayout != null) {
                                r0 = R.id.touch_area_quiet_hours_button;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(R.id.touch_area_quiet_hours_button, view);
                                if (frameLayout2 != null) {
                                    return new CustomToolbarBinding((LinearLayout) view, animatedToolbar, imageView, imageView2, textView, textView2, frameLayout, frameLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static CustomToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.custom_toolbar, viewGroup, false);
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
