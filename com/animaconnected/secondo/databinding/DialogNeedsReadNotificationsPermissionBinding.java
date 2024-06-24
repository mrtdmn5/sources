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
public final class DialogNeedsReadNotificationsPermissionBinding implements ViewBinding {
    public final Button btnApprove;
    public final Button btnCancel;
    public final ImageView ntfImageDescription;
    private final LinearLayout rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private DialogNeedsReadNotificationsPermissionBinding(LinearLayout linearLayout, Button button, Button button2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnApprove = button;
        this.btnCancel = button2;
        this.ntfImageDescription = imageView;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    public static DialogNeedsReadNotificationsPermissionBinding bind(View view) {
        int r0 = R.id.btn_approve;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_approve, view);
        if (button != null) {
            r0 = R.id.btn_cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_cancel, view);
            if (button2 != null) {
                r0 = R.id.ntf_image_description;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.ntf_image_description, view);
                if (imageView != null) {
                    r0 = R.id.tv_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_description, view);
                    if (textView != null) {
                        r0 = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_title, view);
                        if (textView2 != null) {
                            return new DialogNeedsReadNotificationsPermissionBinding((LinearLayout) view, button, button2, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogNeedsReadNotificationsPermissionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogNeedsReadNotificationsPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_needs_read_notifications_permission, viewGroup, false);
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
