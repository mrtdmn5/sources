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
public final class FragmentDetailspickerBinding implements ViewBinding {
    public final TopFadeRecyclerView optionsList;
    private final LinearLayout rootView;

    private FragmentDetailspickerBinding(LinearLayout linearLayout, TopFadeRecyclerView topFadeRecyclerView) {
        this.rootView = linearLayout;
        this.optionsList = topFadeRecyclerView;
    }

    public static FragmentDetailspickerBinding bind(View view) {
        TopFadeRecyclerView topFadeRecyclerView = (TopFadeRecyclerView) ViewBindings.findChildViewById(R.id.options_list, view);
        if (topFadeRecyclerView != null) {
            return new FragmentDetailspickerBinding((LinearLayout) view, topFadeRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.options_list)));
    }

    public static FragmentDetailspickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailspickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_detailspicker, viewGroup, false);
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
