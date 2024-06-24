package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentComposeBinding implements ViewBinding {
    public final ComposeView composeView;
    private final FrameLayout rootView;
    public final View viewAnimContainer;

    private FragmentComposeBinding(FrameLayout frameLayout, ComposeView composeView, View view) {
        this.rootView = frameLayout;
        this.composeView = composeView;
        this.viewAnimContainer = view;
    }

    public static FragmentComposeBinding bind(View view) {
        int r0 = R.id.compose_view;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(R.id.compose_view, view);
        if (composeView != null) {
            r0 = R.id.view_anim_container;
            View findChildViewById = ViewBindings.findChildViewById(R.id.view_anim_container, view);
            if (findChildViewById != null) {
                return new FragmentComposeBinding((FrameLayout) view, composeView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentComposeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentComposeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_compose, viewGroup, false);
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
