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
public final class FragmentSavedSpotsBinding implements ViewBinding {
    public final LinearLayout main;
    public final TopFadeRecyclerView myRecyclerView;
    private final LinearLayout rootView;

    private FragmentSavedSpotsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TopFadeRecyclerView topFadeRecyclerView) {
        this.rootView = linearLayout;
        this.main = linearLayout2;
        this.myRecyclerView = topFadeRecyclerView;
    }

    public static FragmentSavedSpotsBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TopFadeRecyclerView topFadeRecyclerView = (TopFadeRecyclerView) ViewBindings.findChildViewById(R.id.my_recycler_view, view);
        if (topFadeRecyclerView != null) {
            return new FragmentSavedSpotsBinding(linearLayout, linearLayout, topFadeRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.my_recycler_view)));
    }

    public static FragmentSavedSpotsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSavedSpotsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_saved_spots, viewGroup, false);
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
