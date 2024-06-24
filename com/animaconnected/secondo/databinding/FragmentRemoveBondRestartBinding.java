package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentRemoveBondRestartBinding implements ViewBinding {
    public final Button dfuErrorContactSupportButton;
    private final FrameLayout rootView;

    private FragmentRemoveBondRestartBinding(FrameLayout frameLayout, Button button) {
        this.rootView = frameLayout;
        this.dfuErrorContactSupportButton = button;
    }

    public static FragmentRemoveBondRestartBinding bind(View view) {
        Button button = (Button) ViewBindings.findChildViewById(R.id.dfu_error_contact_support_button, view);
        if (button != null) {
            return new FragmentRemoveBondRestartBinding((FrameLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.dfu_error_contact_support_button)));
    }

    public static FragmentRemoveBondRestartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRemoveBondRestartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_remove_bond_restart, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
