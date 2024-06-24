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
public final class FragmentStatusDisconnectedBinding implements ViewBinding {
    public final TextView connectionStatus;
    private final FrameLayout rootView;
    public final Button startHelpCenterButton;
    public final TextView statusBoardDescription;
    public final TextView statusBoardTitle;

    private FragmentStatusDisconnectedBinding(FrameLayout frameLayout, TextView textView, Button button, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.connectionStatus = textView;
        this.startHelpCenterButton = button;
        this.statusBoardDescription = textView2;
        this.statusBoardTitle = textView3;
    }

    public static FragmentStatusDisconnectedBinding bind(View view) {
        int r0 = R.id.connection_status;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.connection_status, view);
        if (textView != null) {
            r0 = R.id.start_help_center_button;
            Button button = (Button) ViewBindings.findChildViewById(R.id.start_help_center_button, view);
            if (button != null) {
                r0 = R.id.status_board_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.status_board_description, view);
                if (textView2 != null) {
                    r0 = R.id.status_board_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.status_board_title, view);
                    if (textView3 != null) {
                        return new FragmentStatusDisconnectedBinding((FrameLayout) view, textView, button, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentStatusDisconnectedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStatusDisconnectedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_disconnected, viewGroup, false);
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
