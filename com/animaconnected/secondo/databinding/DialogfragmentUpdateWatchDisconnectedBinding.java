package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentUpdateWatchDisconnectedBinding implements ViewBinding {
    public final TextView dialogForgetWatchDescription;
    private final LinearLayout rootView;

    private DialogfragmentUpdateWatchDisconnectedBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.dialogForgetWatchDescription = textView;
    }

    public static DialogfragmentUpdateWatchDisconnectedBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dialog_forget_watch_description, view);
        if (textView != null) {
            return new DialogfragmentUpdateWatchDisconnectedBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.dialog_forget_watch_description)));
    }

    public static DialogfragmentUpdateWatchDisconnectedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentUpdateWatchDisconnectedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_update_watch_disconnected, viewGroup, false);
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
