package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentOnboardingEnableInternetAccessBinding implements ViewBinding {
    private final LinearLayout rootView;

    private DialogfragmentOnboardingEnableInternetAccessBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static DialogfragmentOnboardingEnableInternetAccessBinding bind(View view) {
        if (view != null) {
            return new DialogfragmentOnboardingEnableInternetAccessBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static DialogfragmentOnboardingEnableInternetAccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentOnboardingEnableInternetAccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_onboarding_enable_internet_access, viewGroup, false);
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
