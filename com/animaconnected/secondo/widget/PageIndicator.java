package com.animaconnected.secondo.widget;

import androidx.viewpager.widget.ViewPager;

/* compiled from: PageIndicator.kt */
/* loaded from: classes3.dex */
public interface PageIndicator extends ViewPager.OnPageChangeListener {
    void notifyDataSetChanged();

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    /* synthetic */ void onPageScrollStateChanged(int r1);

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    /* synthetic */ void onPageScrolled(int r1, float f, int r3);

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    /* synthetic */ void onPageSelected(int r1);

    void setCurrentItem(int r1);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int r2);
}
