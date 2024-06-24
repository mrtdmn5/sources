package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsLabsBinding implements ViewBinding {
    public final FrameLayout bottomDialogContainer;
    public final LinearLayout detailLayout;
    public final FrameLayout fragmentContainer;
    public final TopFadeScrollView fragmentScrollContainer;
    private final LinearLayout rootView;

    private FragmentDetailsLabsBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, FrameLayout frameLayout2, TopFadeScrollView topFadeScrollView) {
        this.rootView = linearLayout;
        this.bottomDialogContainer = frameLayout;
        this.detailLayout = linearLayout2;
        this.fragmentContainer = frameLayout2;
        this.fragmentScrollContainer = topFadeScrollView;
    }

    public static FragmentDetailsLabsBinding bind(View view) {
        int r0 = R.id.bottom_dialog_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.bottom_dialog_container, view);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            r0 = R.id.fragment_container;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(R.id.fragment_container, view);
            if (frameLayout2 != null) {
                r0 = R.id.fragment_scroll_container;
                TopFadeScrollView topFadeScrollView = (TopFadeScrollView) ViewBindings.findChildViewById(R.id.fragment_scroll_container, view);
                if (topFadeScrollView != null) {
                    return new FragmentDetailsLabsBinding(linearLayout, frameLayout, linearLayout, frameLayout2, topFadeScrollView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsLabsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsLabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_labs, viewGroup, false);
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
