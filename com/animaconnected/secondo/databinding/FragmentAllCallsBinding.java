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
public final class FragmentAllCallsBinding implements ViewBinding {
    public final TextView allCallsDescription;
    public final FrameLayout bottomDialogContainer;
    public final LinearLayout container;
    private final RelativeLayout rootView;
    public final TextView titleTextView;

    private FragmentAllCallsBinding(RelativeLayout relativeLayout, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView2) {
        this.rootView = relativeLayout;
        this.allCallsDescription = textView;
        this.bottomDialogContainer = frameLayout;
        this.container = linearLayout;
        this.titleTextView = textView2;
    }

    public static FragmentAllCallsBinding bind(View view) {
        int r0 = R.id.all_calls_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.all_calls_description, view);
        if (textView != null) {
            r0 = R.id.bottom_dialog_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
            if (frameLayout != null) {
                r0 = R.id.container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.container, view);
                if (linearLayout != null) {
                    r0 = R.id.title_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.title_text_view, view);
                    if (textView2 != null) {
                        return new FragmentAllCallsBinding((RelativeLayout) view, textView, frameLayout, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentAllCallsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAllCallsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_all_calls, viewGroup, false);
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
