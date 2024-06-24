package com.animaconnected.secondo.screens.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.provider.TipsAndTricksProvider;
import com.animaconnected.secondo.provider.analytics.AnalyticsTrackingProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksModel;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPageTextAnimationFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPagerAdapter;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksTextAnimationModel;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsAndTricksFragment.kt */
/* loaded from: classes3.dex */
public final class TipsAndTricksFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "TipsAndTricks";
    private int currentlyShownFragmentPosition = -1;

    /* compiled from: TipsAndTricksFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TipsAndTricksFragment newInstance() {
            return new TipsAndTricksFragment();
        }

        private Companion() {
        }
    }

    private final TipsAndTricksPageFragment createPageFragment(TipsAndTricksModel tipsAndTricksModel) {
        if (tipsAndTricksModel instanceof TipsAndTricksTextAnimationModel) {
            return TipsAndTricksPageTextAnimationFragment.Companion.newInstance((TipsAndTricksTextAnimationModel) tipsAndTricksModel);
        }
        return TipsAndTricksPageFragment.Companion.newInstance(tipsAndTricksModel);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_tips_and_tricks, viewGroup, false);
        List<TipsAndTricksModel> tipsAndTricksModels = TipsAndTricksProvider.getTipsAndTricksModels();
        ArrayList arrayList = new ArrayList();
        for (Object obj : tipsAndTricksModels) {
            if (((TipsAndTricksModel) obj).isCompatibleToBeShown()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(createPageFragment((TipsAndTricksModel) it.next()));
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        final TipsAndTricksPagerAdapter tipsAndTricksPagerAdapter = new TipsAndTricksPagerAdapter(childFragmentManager, arrayList2);
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.animaconnected.secondo.screens.settings.TipsAndTricksFragment$onCreateView$1$pageChangeListener$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r4) {
                int r0;
                int r1;
                r0 = TipsAndTricksFragment.this.currentlyShownFragmentPosition;
                if (r0 != -1) {
                    TipsAndTricksPagerAdapter tipsAndTricksPagerAdapter2 = tipsAndTricksPagerAdapter;
                    r1 = TipsAndTricksFragment.this.currentlyShownFragmentPosition;
                    tipsAndTricksPagerAdapter2.getItem(r1).stopAnimation();
                }
                TipsAndTricksFragment.this.currentlyShownFragmentPosition = r4;
                TipsAndTricksPageFragment item = tipsAndTricksPagerAdapter.getItem(r4);
                item.startAnimation();
                AnalyticsTrackingProvider.getInstance().startTrackingFragment("TTSettings-" + item.getName());
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int r1) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r1, float f, int r3) {
            }
        };
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.tips_and_tricks_pager);
        viewPager.setAdapter(tipsAndTricksPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin((int) viewPager.getResources().getDimension(R.dimen.padding_double));
        viewPager.addOnPageChangeListener(onPageChangeListener);
        onPageChangeListener.onPageSelected(0);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AnalyticsTrackingProvider.getInstance().stopTrackingFragment();
        super.onDestroy();
    }
}
