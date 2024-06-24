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
public final class FragmentWatchUpdateCompletedBinding implements ViewBinding {
    public final LinearLayout changeLogView;
    private final LinearLayout rootView;
    public final Button updateDoneButton;

    private FragmentWatchUpdateCompletedBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button) {
        this.rootView = linearLayout;
        this.changeLogView = linearLayout2;
        this.updateDoneButton = button;
    }

    public static FragmentWatchUpdateCompletedBinding bind(View view) {
        int r0 = R.id.change_log_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.change_log_view, view);
        if (linearLayout != null) {
            r0 = R.id.update_done_button;
            Button button = (Button) ViewBindings.findChildViewById(R.id.update_done_button, view);
            if (button != null) {
                return new FragmentWatchUpdateCompletedBinding((LinearLayout) view, linearLayout, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentWatchUpdateCompletedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWatchUpdateCompletedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_watch_update_completed, viewGroup, false);
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
