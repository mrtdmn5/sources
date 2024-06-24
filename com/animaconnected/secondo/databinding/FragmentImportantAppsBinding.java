package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentImportantAppsBinding implements ViewBinding {
    public final RelativeLayout main;
    public final RecyclerView myRecyclerView;
    private final RelativeLayout rootView;

    private FragmentImportantAppsBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.main = relativeLayout2;
        this.myRecyclerView = recyclerView;
    }

    public static FragmentImportantAppsBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(R.id.my_recycler_view, view);
        if (recyclerView != null) {
            return new FragmentImportantAppsBinding(relativeLayout, relativeLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.my_recycler_view)));
    }

    public static FragmentImportantAppsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentImportantAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_important_apps, viewGroup, false);
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
