package com.animaconnected.secondo.screens.details.watch;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class DetailWatchPagerAdapter extends FragmentPagerAdapter {
    private List<BaseDetailWatchPage> mFragments;

    public DetailWatchPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    public List<BaseDetailWatchPage> getItems() {
        return this.mFragments;
    }

    public void setData(List<BaseDetailWatchPage> list) {
        this.mFragments = list;
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public BaseDetailWatchPage getItem(int r2) {
        return this.mFragments.get(r2);
    }
}
