package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentImportantAppsPagerBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TabLayout slidingTabs;
    public final ViewPager viewpager;

    private FragmentImportantAppsPagerBinding(LinearLayout linearLayout, TabLayout tabLayout, ViewPager viewPager) {
        this.rootView = linearLayout;
        this.slidingTabs = tabLayout;
        this.viewpager = viewPager;
    }

    public static FragmentImportantAppsPagerBinding bind(View view) {
        int r0 = R.id.sliding_tabs;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(R.id.sliding_tabs, view);
        if (tabLayout != null) {
            r0 = R.id.viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(R.id.viewpager, view);
            if (viewPager != null) {
                return new FragmentImportantAppsPagerBinding((LinearLayout) view, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentImportantAppsPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentImportantAppsPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_important_apps_pager, viewGroup, false);
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
