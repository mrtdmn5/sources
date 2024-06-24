package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogAccountInvalidInformationBinding implements ViewBinding {
    public final Button btnClose;
    private final LinearLayout rootView;
    public final TextView tvBody;
    public final TextView tvHeading;

    private DialogAccountInvalidInformationBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnClose = button;
        this.tvBody = textView;
        this.tvHeading = textView2;
    }

    public static DialogAccountInvalidInformationBinding bind(View view) {
        int r0 = R.id.btn_close;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_close, view);
        if (button != null) {
            r0 = R.id.tv_body;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_body, view);
            if (textView != null) {
                r0 = R.id.tv_heading;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_heading, view);
                if (textView2 != null) {
                    return new DialogAccountInvalidInformationBinding((LinearLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogAccountInvalidInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccountInvalidInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_account_invalid_information, viewGroup, false);
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
