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
public final class DialogfragmentOnboardingEnableBluetoothBinding implements ViewBinding {
    public final Button btnTurnOnBluetooth;
    private final LinearLayout rootView;

    private DialogfragmentOnboardingEnableBluetoothBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.btnTurnOnBluetooth = button;
    }

    public static DialogfragmentOnboardingEnableBluetoothBinding bind(View view) {
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_turn_on_bluetooth, view);
        if (button != null) {
            return new DialogfragmentOnboardingEnableBluetoothBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btn_turn_on_bluetooth)));
    }

    public static DialogfragmentOnboardingEnableBluetoothBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentOnboardingEnableBluetoothBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_onboarding_enable_bluetooth, viewGroup, false);
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
