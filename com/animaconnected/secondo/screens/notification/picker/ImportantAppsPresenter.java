package com.animaconnected.secondo.screens.notification.picker;

import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.provider.ImportantAppsProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda5;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppsPresenter;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class ImportantAppsPresenter {
    private final MainController controller;
    private final ImportantAppsProvider mAppProvider = ProviderFactory.getImportantAppsProvider();
    private final boolean mFetchAllApps;
    private final PickerView mPickerView;

    /* loaded from: classes3.dex */
    public interface PickerView {
        void setData(List<AppInfo> list);
    }

    public ImportantAppsPresenter(PickerView pickerView, MainController mainController, boolean z) {
        this.mPickerView = pickerView;
        this.controller = mainController;
        this.mFetchAllApps = z;
    }

    private void fetchAllInstalledApps(Set<String> set) {
        Future<List<AppInfo>> fetchAllInstalledApps = this.mAppProvider.fetchAllInstalledApps(set);
        PickerView pickerView = this.mPickerView;
        Objects.requireNonNull(pickerView);
        fetchAllInstalledApps.success(new RemoteCrashProvider$$ExternalSyntheticLambda5(1, pickerView));
    }

    private void fetchFeaturedInstalledApps(Set<String> set) {
        Future<List<AppInfo>> fetchFeaturedInstalledApps = this.mAppProvider.fetchFeaturedInstalledApps(set);
        final PickerView pickerView = this.mPickerView;
        Objects.requireNonNull(pickerView);
        fetchFeaturedInstalledApps.success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.picker.ImportantAppsPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                ImportantAppsPresenter.PickerView.this.setData((List) obj);
            }
        });
    }

    public void onAppSelected(String str, String str2) {
        ProviderFactory.getNotificationProvider().addImportantApp(new ImportantApp(str, str2), null);
        this.controller.goBack();
    }

    public void onViewCreated(Set<String> set) {
        if (this.mFetchAllApps) {
            fetchAllInstalledApps(set);
        } else {
            fetchFeaturedInstalledApps(set);
        }
    }
}
