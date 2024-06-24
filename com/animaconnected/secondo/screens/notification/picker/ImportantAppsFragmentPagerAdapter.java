package com.animaconnected.secondo.screens.notification.picker;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class ImportantAppsFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 2;
    private final String[] mTabTitles;

    public ImportantAppsFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager, 1);
        this.mTabTitles = r4;
        String[] strArr = {context.getString(R.string.nft_title_featured_important_app), context.getString(R.string.nft_title_all_important_app)};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int r2) {
        if (r2 != 0) {
            if (r2 == 1) {
                return ImportantAppsFragment.newInstance(true);
            }
            throw new RuntimeException("Unexpected position.");
        }
        return ImportantAppsFragment.newInstance(false);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r2) {
        return this.mTabTitles[r2];
    }
}
