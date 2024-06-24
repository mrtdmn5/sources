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
public final class DialogfragmentUpdateWatchBluetoothDisabledBinding implements ViewBinding {
    public final TextView dialogForgetWatchDescription;
    private final LinearLayout rootView;
    public final Button turnOnBluetoothButton;

    private DialogfragmentUpdateWatchBluetoothDisabledBinding(LinearLayout linearLayout, TextView textView, Button button) {
        this.rootView = linearLayout;
        this.dialogForgetWatchDescription = textView;
        this.turnOnBluetoothButton = button;
    }

    public static DialogfragmentUpdateWatchBluetoothDisabledBinding bind(View view) {
        int r0 = R.id.dialog_forget_watch_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.dialog_forget_watch_description, view);
        if (textView != null) {
            r0 = R.id.turn_on_bluetooth_button;
            Button button = (Button) ViewBindings.findChildViewById(R.id.turn_on_bluetooth_button, view);
            if (button != null) {
                return new DialogfragmentUpdateWatchBluetoothDisabledBinding((LinearLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentUpdateWatchBluetoothDisabledBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentUpdateWatchBluetoothDisabledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_update_watch_bluetooth_disabled, viewGroup, false);
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
