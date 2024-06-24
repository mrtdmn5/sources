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
public final class DialogfragmentUpdateFailedBinding implements ViewBinding {
    public final TextView dialogUpdateFailedDescription;
    private final LinearLayout rootView;
    public final Button tryAgainButton;

    private DialogfragmentUpdateFailedBinding(LinearLayout linearLayout, TextView textView, Button button) {
        this.rootView = linearLayout;
        this.dialogUpdateFailedDescription = textView;
        this.tryAgainButton = button;
    }

    public static DialogfragmentUpdateFailedBinding bind(View view) {
        int r0 = R.id.dialog_update_failed_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dialog_update_failed_description, view);
        if (textView != null) {
            r0 = R.id.try_again_button;
            Button button = (Button) ViewBindings.findChildViewById(R.id.try_again_button, view);
            if (button != null) {
                return new DialogfragmentUpdateFailedBinding((LinearLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentUpdateFailedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentUpdateFailedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_update_failed, viewGroup, false);
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
