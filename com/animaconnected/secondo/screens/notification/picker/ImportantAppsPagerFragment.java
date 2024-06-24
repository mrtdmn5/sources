package com.animaconnected.secondo.screens.notification.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.screens.BaseFragment;
import com.google.android.material.tabs.TabLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class ImportantAppsPagerFragment extends BaseFragment {
    public static ImportantAppsPagerFragment newInstance() {
        return new ImportantAppsPagerFragment();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_notification);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Important Apps Pager";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context context = getContext();
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context, R.drawable.ic_close);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_important_apps_pager, viewGroup, false);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ImportantAppsFragmentPagerAdapter(getChildFragmentManager(), getActivity().getApplicationContext()));
        ((TabLayout) inflate.findViewById(R.id.sliding_tabs)).setupWithViewPager(viewPager);
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View view2 = getView();
        if (view2 != null) {
            view2.setTranslationZ(100.0f);
        }
    }
}
