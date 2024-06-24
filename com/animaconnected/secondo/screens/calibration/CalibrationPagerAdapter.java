package com.animaconnected.secondo.screens.calibration;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class CalibrationPagerAdapter extends FragmentPagerAdapter {
    private List<CalibrationPageFragment> mFragments;

    public CalibrationPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    public void setData(List<CalibrationPageFragment> list) {
        this.mFragments = list;
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public CalibrationPageFragment getItem(int r2) {
        return this.mFragments.get(r2);
    }
}
