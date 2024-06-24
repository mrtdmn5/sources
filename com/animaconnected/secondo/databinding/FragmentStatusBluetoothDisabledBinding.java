package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentStatusBluetoothDisabledBinding implements ViewBinding {
    public final Button enableBluetoothButton;
    private final FrameLayout rootView;
    public final TextView statusBoardDesc;
    public final TextView statusBoardTitle;

    private FragmentStatusBluetoothDisabledBinding(FrameLayout frameLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.enableBluetoothButton = button;
        this.statusBoardDesc = textView;
        this.statusBoardTitle = textView2;
    }

    public static FragmentStatusBluetoothDisabledBinding bind(View view) {
        int r0 = R.id.enable_bluetooth_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.enable_bluetooth_button, view);
        if (button != null) {
            r0 = R.id.status_board_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.status_board_desc, view);
            if (textView != null) {
                r0 = R.id.status_board_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.status_board_title, view);
                if (textView2 != null) {
                    return new FragmentStatusBluetoothDisabledBinding((FrameLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentStatusBluetoothDisabledBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStatusBluetoothDisabledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_bluetooth_disabled, viewGroup, false);
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
