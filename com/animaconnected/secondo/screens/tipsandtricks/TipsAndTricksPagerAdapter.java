package com.animaconnected.secondo.screens.tipsandtricks;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksPagerAdapter.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksPagerAdapter extends FragmentPagerAdapter {
    public static final int $stable = 8;
    private final List<TipsAndTricksPageFragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TipsAndTricksPagerAdapter(FragmentManager childFragmentManager, List<? extends TipsAndTricksPageFragment> fragments) {
        super(childFragmentManager, 1);
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public TipsAndTricksPageFragment getItem(int r2) {
        return this.fragments.get(r2);
    }
}
