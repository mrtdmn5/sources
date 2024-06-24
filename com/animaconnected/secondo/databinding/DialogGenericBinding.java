package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogGenericBinding implements ViewBinding {
    public final Button btnPrimary;
    public final Button btnSecondary;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView tvBody;
    public final TextView tvTitle;

    private DialogGenericBinding(LinearLayout linearLayout, Button button, Button button2, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnPrimary = button;
        this.btnSecondary = button2;
        this.progressBar = progressBar;
        this.tvBody = textView;
        this.tvTitle = textView2;
    }

    public static DialogGenericBinding bind(View view) {
        int r0 = R.id.btn_primary;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_primary, view);
        if (button != null) {
            r0 = R.id.btn_secondary;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.btn_secondary, view);
            if (button2 != null) {
                r0 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.progress_bar, view);
                if (progressBar != null) {
                    r0 = R.id.tv_body;
                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_body, view);
                    if (textView != null) {
                        r0 = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_title, view);
                        if (textView2 != null) {
                            return new DialogGenericBinding((LinearLayout) view, button, button2, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogGenericBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogGenericBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_generic, viewGroup, false);
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
