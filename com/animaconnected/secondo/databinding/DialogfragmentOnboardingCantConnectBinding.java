package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentOnboardingCantConnectBinding implements ViewBinding {
    public final Button cantConnectButton;
    public final TextView helpCenterDescription;
    public final TextView helpCenterDialogTitle;
    public final ImageView helpCenterImageOverlay;
    private final LinearLayout rootView;

    private DialogfragmentOnboardingCantConnectBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = linearLayout;
        this.cantConnectButton = button;
        this.helpCenterDescription = textView;
        this.helpCenterDialogTitle = textView2;
        this.helpCenterImageOverlay = imageView;
    }

    public static DialogfragmentOnboardingCantConnectBinding bind(View view) {
        int r0 = R.id.cant_connect_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.cant_connect_button, view);
        if (button != null) {
            r0 = R.id.help_center_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.help_center_description, view);
            if (textView != null) {
                r0 = R.id.help_center_dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.help_center_dialog_title, view);
                if (textView2 != null) {
                    r0 = R.id.help_center_image_overlay;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.help_center_image_overlay, view);
                    if (imageView != null) {
                        return new DialogfragmentOnboardingCantConnectBinding((LinearLayout) view, button, textView, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentOnboardingCantConnectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentOnboardingCantConnectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_onboarding_cant_connect, viewGroup, false);
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
