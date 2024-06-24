package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentStatusDistressNoAcceptedInviteBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView statusBoardDesc;
    public final TextView statusBoardTitle;

    private FragmentStatusDistressNoAcceptedInviteBinding(FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.statusBoardDesc = textView;
        this.statusBoardTitle = textView2;
    }

    public static FragmentStatusDistressNoAcceptedInviteBinding bind(View view) {
        int r0 = R.id.status_board_desc;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.status_board_desc, view);
        if (textView != null) {
            r0 = R.id.status_board_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.status_board_title, view);
            if (textView2 != null) {
                return new FragmentStatusDistressNoAcceptedInviteBinding((FrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentStatusDistressNoAcceptedInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStatusDistressNoAcceptedInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_distress_no_accepted_invite, viewGroup, false);
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
