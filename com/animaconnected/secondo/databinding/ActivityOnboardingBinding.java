package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ActivityOnboardingBinding implements ViewBinding {
    public final FrameLayout contentOnboarding;
    private final FrameLayout rootView;

    private ActivityOnboardingBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.contentOnboarding = frameLayout2;
    }

    public static ActivityOnboardingBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.contentOnboarding, view);
        if (frameLayout != null) {
            return new ActivityOnboardingBinding((FrameLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.contentOnboarding)));
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_onboarding, viewGroup, false);
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
