package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class MiniOnboardingDialogFragmentBinding implements ViewBinding {
    public final Button miniOnboardingNextOrDoneButton;
    public final ViewPager miniOnboardingPager;
    public final Button miniOnboardingPreviousButton;
    public final CirclePageIndicator pageIndicator;
    private final LinearLayout rootView;

    private MiniOnboardingDialogFragmentBinding(LinearLayout linearLayout, Button button, ViewPager viewPager, Button button2, CirclePageIndicator circlePageIndicator) {
        this.rootView = linearLayout;
        this.miniOnboardingNextOrDoneButton = button;
        this.miniOnboardingPager = viewPager;
        this.miniOnboardingPreviousButton = button2;
        this.pageIndicator = circlePageIndicator;
    }

    public static MiniOnboardingDialogFragmentBinding bind(View view) {
        int r0 = R.id.mini_onboarding_next_or_done_button;
        Button button = (Button) ViewBindings.findChildViewById(R.id.mini_onboarding_next_or_done_button, view);
        if (button != null) {
            r0 = R.id.mini_onboarding_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(R.id.mini_onboarding_pager, view);
            if (viewPager != null) {
                r0 = R.id.mini_onboarding_previous_button;
                Button button2 = (Button) ViewBindings.findChildViewById(R.id.mini_onboarding_previous_button, view);
                if (button2 != null) {
                    r0 = R.id.page_indicator;
                    CirclePageIndicator circlePageIndicator = (CirclePageIndicator) ViewBindings.findChildViewById(R.id.page_indicator, view);
                    if (circlePageIndicator != null) {
                        return new MiniOnboardingDialogFragmentBinding((LinearLayout) view, button, viewPager, button2, circlePageIndicator);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static MiniOnboardingDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniOnboardingDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mini_onboarding_dialog_fragment, viewGroup, false);
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
