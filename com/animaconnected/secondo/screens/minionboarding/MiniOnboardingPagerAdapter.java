package com.animaconnected.secondo.screens.minionboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class MiniOnboardingPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public MiniOnboardingPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int r2) {
        return this.mFragments.get(r2);
    }

    public void setData(List<Fragment> list) {
        this.mFragments = list;
        notifyDataSetChanged();
    }
}
