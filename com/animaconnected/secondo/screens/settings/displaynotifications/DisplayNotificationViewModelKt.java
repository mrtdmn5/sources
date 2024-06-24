package com.animaconnected.secondo.screens.settings.displaynotifications;

import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import com.animaconnected.watch.filter.Application;
import com.animaconnected.watch.filter.ApplicationSetting;

/* compiled from: DisplayNotificationViewModel.kt */
/* loaded from: classes3.dex */
public final class DisplayNotificationViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AppState toAppState(AppInfo appInfo, boolean z) {
        return new AppState(appInfo.getAppName(), appInfo.getPackageName(), appInfo.getAppIcon(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Application toApplication(AppState appState, ApplicationSetting applicationSetting) {
        return new Application(appState.getPackageName(), appState.getName(), applicationSetting);
    }
}
