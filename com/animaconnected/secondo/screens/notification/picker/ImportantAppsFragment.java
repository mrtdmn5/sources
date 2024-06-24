package com.animaconnected.secondo.screens.notification.picker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppsAdapter;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppsPresenter;
import com.kronaby.watch.app.R;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* loaded from: classes3.dex */
public class ImportantAppsFragment extends BaseFragment implements ImportantAppsPresenter.PickerView, ImportantAppsAdapter.ImportantAppsAdapterListener {
    private static final String FRAGMENT_FETCH_ALL_APPS = "fragment_fetch_all_apps";
    private ImportantAppsAdapter mAdapter;
    private ImportantAppsPresenter mPresenter;

    public static ImportantAppsFragment newInstance(boolean z) {
        ImportantAppsFragment importantAppsFragment = new ImportantAppsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(FRAGMENT_FETCH_ALL_APPS, z);
        importantAppsFragment.setArguments(bundle);
        return importantAppsFragment;
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
        return "Important Apps";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPresenter = new ImportantAppsPresenter(this, getMainController(), getArguments().getBoolean(FRAGMENT_FETCH_ALL_APPS));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mPresenter.onViewCreated((Set) ProviderFactory.getNotificationProvider().getImportantAppSync().stream().map(new ImportantAppsFragment$$ExternalSyntheticLambda0()).collect(Collectors.toSet()));
        return layoutInflater.inflate(R.layout.fragment_important_apps, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.notification.picker.ImportantAppsAdapter.ImportantAppsAdapterListener
    public void onListItemClicked(AppInfo appInfo) {
        this.mPresenter.onAppSelected(appInfo.getAppName(), appInfo.getPackageName());
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        ImportantAppsAdapter importantAppsAdapter = new ImportantAppsAdapter();
        this.mAdapter = importantAppsAdapter;
        recyclerView.setAdapter(importantAppsAdapter);
        this.mAdapter.setImportantAppsAdapterListener(this);
    }

    @Override // com.animaconnected.secondo.screens.notification.picker.ImportantAppsPresenter.PickerView
    public void setData(List<AppInfo> list) {
        this.mAdapter.setData(list);
    }
}
