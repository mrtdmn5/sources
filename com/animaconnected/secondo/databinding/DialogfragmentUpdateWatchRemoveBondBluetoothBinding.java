package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentUpdateWatchRemoveBondBluetoothBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Button tryAgainButton;

    private DialogfragmentUpdateWatchRemoveBondBluetoothBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.tryAgainButton = button;
    }

    public static DialogfragmentUpdateWatchRemoveBondBluetoothBinding bind(View view) {
        Button button = (Button) ViewBindings.findChildViewById(R.id.try_again_button, view);
        if (button != null) {
            return new DialogfragmentUpdateWatchRemoveBondBluetoothBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.try_again_button)));
    }

    public static DialogfragmentUpdateWatchRemoveBondBluetoothBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentUpdateWatchRemoveBondBluetoothBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_update_watch_remove_bond_bluetooth, viewGroup, false);
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
