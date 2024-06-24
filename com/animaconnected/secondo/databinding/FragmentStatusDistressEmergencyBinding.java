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
public final class FragmentStatusDistressEmergencyBinding implements ViewBinding {
    public final Button btnSafe;
    private final FrameLayout rootView;
    public final TextView statusBoardTitle;

    private FragmentStatusDistressEmergencyBinding(FrameLayout frameLayout, Button button, TextView textView) {
        this.rootView = frameLayout;
        this.btnSafe = button;
        this.statusBoardTitle = textView;
    }

    public static FragmentStatusDistressEmergencyBinding bind(View view) {
        int r0 = R.id.btn_safe;
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_safe, view);
        if (button != null) {
            r0 = R.id.status_board_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.status_board_title, view);
            if (textView != null) {
                return new FragmentStatusDistressEmergencyBinding((FrameLayout) view, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentStatusDistressEmergencyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStatusDistressEmergencyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_distress_emergency, viewGroup, false);
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
