package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentAllMessagesBinding implements ViewBinding {
    public final FrameLayout bottomDialogContainer;
    public final LinearLayout container;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentAllMessagesBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.bottomDialogContainer = frameLayout;
        this.container = linearLayout;
        this.titleTextView = textView;
    }

    public static FragmentAllMessagesBinding bind(View view) {
        int r0 = R.id.bottom_dialog_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
        if (frameLayout != null) {
            r0 = R.id.container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
            if (linearLayout != null) {
                r0 = R.id.title_text_view;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                if (textView != null) {
                    return new FragmentAllMessagesBinding((RelativeLayout) view, frameLayout, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentAllMessagesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAllMessagesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_all_messages, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
