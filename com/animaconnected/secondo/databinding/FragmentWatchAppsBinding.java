package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.TopFadeRecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentWatchAppsBinding implements ViewBinding {
    public final LinearLayout rootView;
    private final LinearLayout rootView_;
    public final TopFadeRecyclerView rvApps;

    private FragmentWatchAppsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TopFadeRecyclerView topFadeRecyclerView) {
        this.rootView_ = linearLayout;
        this.rootView = linearLayout2;
        this.rvApps = topFadeRecyclerView;
    }

    public static FragmentWatchAppsBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TopFadeRecyclerView topFadeRecyclerView = (TopFadeRecyclerView) ViewBindings.findChildViewById(R.id.rv_apps, view);
        if (topFadeRecyclerView != null) {
            return new FragmentWatchAppsBinding(linearLayout, linearLayout, topFadeRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv_apps)));
    }

    public static FragmentWatchAppsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWatchAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_watch_apps, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView_;
    }
}
