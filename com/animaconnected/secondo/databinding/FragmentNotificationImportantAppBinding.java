package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentNotificationImportantAppBinding implements ViewBinding {
    public final ImageView appIcon;
    public final FrameLayout bottomDialogContainer;
    public final LinearLayout container;
    public final Button remove;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentNotificationImportantAppBinding(RelativeLayout relativeLayout, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, Button button, TextView textView) {
        this.rootView = relativeLayout;
        this.appIcon = imageView;
        this.bottomDialogContainer = frameLayout;
        this.container = linearLayout;
        this.remove = button;
        this.titleTextView = textView;
    }

    public static FragmentNotificationImportantAppBinding bind(View view) {
        int r0 = R.id.app_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.app_icon, view);
        if (imageView != null) {
            r0 = R.id.bottom_dialog_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
            if (frameLayout != null) {
                r0 = R.id.container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
                if (linearLayout != null) {
                    r0 = R.id.remove;
                    Button button = (Button) ViewBindings.findChildViewById(R.id.remove, view);
                    if (button != null) {
                        r0 = R.id.title_text_view;
                        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                        if (textView != null) {
                            return new FragmentNotificationImportantAppBinding((RelativeLayout) view, imageView, frameLayout, linearLayout, button, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentNotificationImportantAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNotificationImportantAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_notification_important_app, viewGroup, false);
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
