package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentOnboardingWaitingProductInfoBinding implements ViewBinding {
    private final LinearLayout rootView;

    private FragmentOnboardingWaitingProductInfoBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static FragmentOnboardingWaitingProductInfoBinding bind(View view) {
        if (view != null) {
            return new FragmentOnboardingWaitingProductInfoBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static FragmentOnboardingWaitingProductInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentOnboardingWaitingProductInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_waiting_product_info, viewGroup, false);
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
