package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentStatusDummyBinding implements ViewBinding {
    private final FrameLayout rootView;

    private FragmentStatusDummyBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public static FragmentStatusDummyBinding bind(View view) {
        if (view != null) {
            return new FragmentStatusDummyBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static FragmentStatusDummyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStatusDummyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_status_dummy, viewGroup, false);
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
