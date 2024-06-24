package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.provider.Telephony;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.filter.Application;
import com.animaconnected.watch.filter.ApplicationSetting;
import com.animaconnected.watch.filter.FilterSettings;
import com.animaconnected.watch.filter.ImportantContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: DisplayNotificationViewModel.kt */
/* loaded from: classes3.dex */
public final class DisplayNotificationViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<AppsUIState> _appUiState;
    private final MutableStateFlow<FilterSettings.Allowed> _callsFilter;
    private final MutableStateFlow<FilterSettings.Allowed> _messageFilter;
    private final StateFlow<AppsUIState> appUiState;
    private final StateFlow<FilterSettings.Allowed> callsFilter;
    private final FilterSettings filter;
    private final CommonFlow<List<ImportantContact>> importantContacts;
    private final StateFlow<FilterSettings.Allowed> messageFilter;

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0031, code lost:            if (r7 != null) goto L4;     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0033, code lost:            r8 = r0.getValue();     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0047, code lost:            if (r0.compareAndSet(r8, com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState.copy$default((com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState) r8, false, r7, r7, 1, null)) == false) goto L9;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0049, code lost:            r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r9.filter.getCallsFilter());        r9._callsFilter = r0;        r9.callsFilter = new kotlinx.coroutines.flow.ReadonlyStateFlow(r0, null);        r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r9.filter.getTextsFilter());        r9._messageFilter = r0;        r9.messageFilter = new kotlinx.coroutines.flow.ReadonlyStateFlow(r0, null);     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0070, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DisplayNotificationViewModel() {
        /*
            r9 = this;
            r9.<init>()
            com.animaconnected.watch.WatchProvider r0 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.WatchManager r0 = r0.getWatchManager()
            com.animaconnected.watch.filter.FilterSettings r0 = r0.getFilterSettings()
            r9.filter = r0
            com.animaconnected.watch.CommonFlow r1 = r0.getImportantContactsFlow()
            r9.importantContacts = r1
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState r1 = new com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState
            boolean r3 = r0.isAllAppsEnabled()
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            kotlinx.coroutines.flow.StateFlowImpl r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r1)
            r9._appUiState = r0
            r9.appUiState = r0
            java.util.List r7 = r9.getInstalledAppsCache()
            if (r7 == 0) goto L49
        L33:
            java.lang.Object r8 = r0.getValue()
            r1 = r8
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState r1 = (com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState) r1
            r2 = 0
            r5 = 1
            r6 = 0
            r3 = r7
            r4 = r7
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState r1 = com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState.copy$default(r1, r2, r3, r4, r5, r6)
            boolean r1 = r0.compareAndSet(r8, r1)
            if (r1 == 0) goto L33
        L49:
            com.animaconnected.watch.filter.FilterSettings r0 = r9.filter
            com.animaconnected.watch.filter.FilterSettings$Allowed r0 = r0.getCallsFilter()
            kotlinx.coroutines.flow.StateFlowImpl r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r0)
            r9._callsFilter = r0
            kotlinx.coroutines.flow.ReadonlyStateFlow r1 = new kotlinx.coroutines.flow.ReadonlyStateFlow
            r2 = 0
            r1.<init>(r0, r2)
            r9.callsFilter = r1
            com.animaconnected.watch.filter.FilterSettings r0 = r9.filter
            com.animaconnected.watch.filter.FilterSettings$Allowed r0 = r0.getTextsFilter()
            kotlinx.coroutines.flow.StateFlowImpl r0 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r0)
            r9._messageFilter = r0
            kotlinx.coroutines.flow.ReadonlyStateFlow r1 = new kotlinx.coroutines.flow.ReadonlyStateFlow
            r1.<init>(r0, r2)
            r9.messageFilter = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006b A[PHI: r8
  0x006b: PHI (r8v8 java.lang.Object) = (r8v7 java.lang.Object), (r8v1 java.lang.Object) binds: [B:17:0x0068, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchAllInstalledAppsUncached(kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.secondo.screens.settings.displaynotifications.AppState>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$1 r0 = (com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$1 r0 = new com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6b
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel r2 = (com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.provider.ImportantAppsProvider r8 = com.animaconnected.secondo.provider.ProviderFactory.getImportantAppsProvider()
            r2 = 0
            java.util.Set r5 = r7.getIgnoredPackages()
            com.animaconnected.future.Future r8 = r8.fetchAllInstalledApps(r2, r5)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r8, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            r2 = r7
        L56:
            java.util.List r8 = (java.util.List) r8
            kotlinx.coroutines.scheduling.DefaultIoScheduler r4 = kotlinx.coroutines.Dispatchers.IO
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2 r5 = new com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$fetchAllInstalledAppsUncached$2
            r6 = 0
            r5.<init>(r2, r8, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel.fetchAllInstalledAppsUncached(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Set<String> getIgnoredPackages() {
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(KronabyApplication.Companion.getContext());
        if (defaultSmsPackage != null) {
            return SetsKt__SetsKt.setOf(defaultSmsPackage);
        }
        return EmptySet.INSTANCE;
    }

    private final List<AppState> getInstalledAppsCache() {
        List<AppInfo> allInstalledAppsCache = ProviderFactory.getImportantAppsProvider().getAllInstalledAppsCache(getIgnoredPackages());
        if (allInstalledAppsCache != null) {
            return toAppState(allInstalledAppsCache);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AppState> toAppState(List<AppInfo> list) {
        ApplicationSetting applicationSetting;
        boolean z;
        AppState appState;
        List<AppInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        for (AppInfo appInfo : list2) {
            Application application = this.filter.getApplication(appInfo.getPackageName());
            if (application != null) {
                applicationSetting = application.getSetting();
            } else {
                applicationSetting = null;
            }
            if (applicationSetting == ApplicationSetting.Important) {
                z = true;
            } else {
                z = false;
            }
            appState = DisplayNotificationViewModelKt.toAppState(appInfo, z);
            arrayList.add(appState);
        }
        return arrayList;
    }

    public final void addImportantContact(String uri, String displayName) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.filter.addImportantContact(uri, displayName);
    }

    public final void filterApps(String searchText) {
        AppsUIState value;
        AppsUIState appsUIState;
        ArrayList arrayList;
        AppsUIState value2;
        AppsUIState appsUIState2;
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        if (StringsKt__StringsJVMKt.isBlank(searchText)) {
            MutableStateFlow<AppsUIState> mutableStateFlow = this._appUiState;
            do {
                value2 = mutableStateFlow.getValue();
                appsUIState2 = value2;
            } while (!mutableStateFlow.compareAndSet(value2, AppsUIState.copy$default(appsUIState2, false, null, appsUIState2.getApps(), 3, null)));
            return;
        }
        MutableStateFlow<AppsUIState> mutableStateFlow2 = this._appUiState;
        do {
            value = mutableStateFlow2.getValue();
            appsUIState = value;
            List<AppState> apps = appsUIState.getApps();
            arrayList = new ArrayList();
            for (Object obj : apps) {
                if (StringsKt__StringsKt.contains(((AppState) obj).getName(), searchText, true)) {
                    arrayList.add(obj);
                }
            }
        } while (!mutableStateFlow2.compareAndSet(value, AppsUIState.copy$default(appsUIState, false, null, arrayList, 3, null)));
    }

    public final StateFlow<AppsUIState> getAppUiState() {
        return this.appUiState;
    }

    public final StateFlow<FilterSettings.Allowed> getCallsFilter() {
        return this.callsFilter;
    }

    public final CommonFlow<List<ImportantContact>> getImportantContacts() {
        return this.importantContacts;
    }

    public final StateFlow<FilterSettings.Allowed> getMessageFilter() {
        return this.messageFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshAppsList(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$refreshAppsList$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$refreshAppsList$1 r0 = (com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$refreshAppsList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$refreshAppsList$1 r0 = new com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel$refreshAppsList$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel r0 = (com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L42
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L33:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r8.fetchAllInstalledAppsUncached(r0)
            if (r9 != r1) goto L41
            return r1
        L41:
            r0 = r8
        L42:
            java.util.List r9 = (java.util.List) r9
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState> r0 = r0._appUiState
        L46:
            java.lang.Object r7 = r0.getValue()
            r1 = r7
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState r1 = (com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState) r1
            r2 = 0
            r5 = 1
            r6 = 0
            r3 = r9
            r4 = r9
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState r1 = com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState.copy$default(r1, r2, r3, r4, r5, r6)
            boolean r1 = r0.compareAndSet(r7, r1)
            if (r1 == 0) goto L46
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel.refreshAppsList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void removeImportantContact(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.filter.removeImportantContact(uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setAllEnabled(boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel.setAllEnabled(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setCallsFilter(FilterSettings.Allowed filterSetting) {
        Intrinsics.checkNotNullParameter(filterSetting, "filterSetting");
        this.filter.setCallsFilter(filterSetting);
        this._callsFilter.setValue(filterSetting);
    }

    public final void setEnabled(String packageName, String appName, boolean z) {
        ApplicationSetting applicationSetting;
        AppsUIState value;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        FilterSettings filterSettings = this.filter;
        if (z) {
            applicationSetting = ApplicationSetting.Important;
        } else {
            applicationSetting = ApplicationSetting.NotImportant;
        }
        if (!filterSettings.addOrUpdatesApplication(new Application(packageName, appName, applicationSetting))) {
            return;
        }
        List<AppState> apps = this._appUiState.getValue().getApps();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(apps, 10));
        for (AppState appState : apps) {
            if (Intrinsics.areEqual(appState.getPackageName(), packageName)) {
                appState = AppState.copy$default(appState, null, null, null, z, 7, null);
            }
            arrayList.add(appState);
        }
        List<AppState> filteredApps = this._appUiState.getValue().getFilteredApps();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(filteredApps, 10));
        for (AppState appState2 : filteredApps) {
            if (Intrinsics.areEqual(appState2.getPackageName(), packageName)) {
                appState2 = AppState.copy$default(appState2, null, null, null, z, 7, null);
            }
            arrayList2.add(appState2);
        }
        boolean z2 = true;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((AppState) it.next()).isSelected()) {
                        z2 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.filter.setAllAppsEnabled(z2);
        MutableStateFlow<AppsUIState> mutableStateFlow = this._appUiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(z2, arrayList, arrayList2)));
    }

    public final void setMessagesFilter(FilterSettings.Allowed filterSetting) {
        Intrinsics.checkNotNullParameter(filterSetting, "filterSetting");
        this.filter.setTextsFilter(filterSetting);
        this._messageFilter.setValue(filterSetting);
    }
}
