package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentGetMovingBinding implements ViewBinding {
    public final LinearLayout container;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentGetMovingBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.container = linearLayout;
        this.titleTextView = textView;
    }

    public static FragmentGetMovingBinding bind(View view) {
        int r0 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
        if (linearLayout != null) {
            r0 = R.id.title_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
            if (textView != null) {
                return new FragmentGetMovingBinding((RelativeLayout) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentGetMovingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGetMovingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_get_moving, viewGroup, false);
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
