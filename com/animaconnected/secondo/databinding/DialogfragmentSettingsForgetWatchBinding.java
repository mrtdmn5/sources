package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentSettingsForgetWatchBinding implements ViewBinding {
    public final Button dialogForgetWatchAbort;
    public final Button dialogForgetWatchAccept;
    public final TextView dialogForgetWatchDescription;
    public final FrameLayout forgetDeviceProgress;
    private final LinearLayout rootView;

    private DialogfragmentSettingsForgetWatchBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.dialogForgetWatchAbort = button;
        this.dialogForgetWatchAccept = button2;
        this.dialogForgetWatchDescription = textView;
        this.forgetDeviceProgress = frameLayout;
    }

    public static DialogfragmentSettingsForgetWatchBinding bind(View view) {
        int r0 = R.id.dialog_forget_watch_abort;
        Button button = (Button) ViewBindings.findChildViewById(R.id.dialog_forget_watch_abort, view);
        if (button != null) {
            r0 = R.id.dialog_forget_watch_accept;
            Button button2 = (Button) ViewBindings.findChildViewById(R.id.dialog_forget_watch_accept, view);
            if (button2 != null) {
                r0 = R.id.dialog_forget_watch_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dialog_forget_watch_description, view);
                if (textView != null) {
                    r0 = R.id.forget_device_progress;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.forget_device_progress, view);
                    if (frameLayout != null) {
                        return new DialogfragmentSettingsForgetWatchBinding((LinearLayout) view, button, button2, textView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentSettingsForgetWatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentSettingsForgetWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_settings_forget_watch, viewGroup, false);
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
