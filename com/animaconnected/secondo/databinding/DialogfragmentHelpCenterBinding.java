package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentHelpCenterBinding implements ViewBinding {
    public final Button helpCenterButton;
    public final TextView helpCenterDescription;
    public final TextView helpCenterDescriptionHidden;
    public final TextView helpCenterDescriptionNew;
    public final TextView helpCenterDialogTitle;
    public final TextView helpCenterDialogTitleNew;
    public final ImageView helpCenterImage;
    public final ImageView helpCenterImageOverlay;
    public final ProgressBar helpCenterProgressbar;
    private final LinearLayout rootView;

    private DialogfragmentHelpCenterBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, ImageView imageView2, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.helpCenterButton = button;
        this.helpCenterDescription = textView;
        this.helpCenterDescriptionHidden = textView2;
        this.helpCenterDescriptionNew = textView3;
        this.helpCenterDialogTitle = textView4;
        this.helpCenterDialogTitleNew = textView5;
        this.helpCenterImage = imageView;
        this.helpCenterImageOverlay = imageView2;
        this.helpCenterProgressbar = progressBar;
    }

    public static DialogfragmentHelpCenterBinding bind(View view) {
        int r0 = R.id.help_center_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.help_center_button, view);
        if (button != null) {
            r0 = R.id.help_center_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.help_center_description, view);
            if (textView != null) {
                r0 = R.id.help_center_description_hidden;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.help_center_description_hidden, view);
                if (textView2 != null) {
                    r0 = R.id.help_center_description_new;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.help_center_description_new, view);
                    if (textView3 != null) {
                        r0 = R.id.help_center_dialog_title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.help_center_dialog_title, view);
                        if (textView4 != null) {
                            r0 = R.id.help_center_dialog_title_new;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.help_center_dialog_title_new, view);
                            if (textView5 != null) {
                                r0 = R.id.help_center_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.help_center_image, view);
                                if (imageView != null) {
                                    r0 = R.id.help_center_image_overlay;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.help_center_image_overlay, view);
                                    if (imageView2 != null) {
                                        r0 = R.id.help_center_progressbar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.help_center_progressbar, view);
                                        if (progressBar != null) {
                                            return new DialogfragmentHelpCenterBinding((LinearLayout) view, button, textView, textView2, textView3, textView4, textView5, imageView, imageView2, progressBar);
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

    public static DialogfragmentHelpCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentHelpCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_help_center, viewGroup, false);
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
