package com.animaconnected.watch.filter;

import app.cash.sqldelight.coroutines.FlowQuery;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.AncsNotificationsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.display.ResourceSynchronizer;
import com.animaconnected.watch.filter.FilterSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: FilterSettingsImpl.kt */
/* loaded from: classes3.dex */
public final class FilterSettingsImpl implements FilterSettings {
    private final String allAppsKey;
    private final String callsFilterKey;
    private final long debounceTimeoutMilliseconds;
    private final MutableStateFlow<FilterNotifications> filterNotificationsFlow;
    private final ResourceSynchronizer resourceSynchronizer;
    private final BasicStorage storage;
    private final String textsFilterKey;

    public FilterSettingsImpl(ResourceSynchronizer resourceSynchronizer) {
        Intrinsics.checkNotNullParameter(resourceSynchronizer, "resourceSynchronizer");
        this.resourceSynchronizer = resourceSynchronizer;
        this.callsFilterKey = "callsFilter";
        this.textsFilterKey = "textsFilter";
        this.allAppsKey = "appFilter";
        this.storage = ServiceLocator.INSTANCE.getStorageFactory().createStorage("notificationsStorage");
        this.filterNotificationsFlow = StateFlowKt.MutableStateFlow(asFilterNotification());
        this.debounceTimeoutMilliseconds = DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT;
    }

    private final FilterNotifications asFilterNotification() {
        return new FilterNotifications(getCallsFilter(), getTextsFilter(), isAllAppsEnabled(), getApplications(), getImportantContacts());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canAddOrUpdateApplication(Application application) {
        final int r1;
        boolean z;
        List<Application> applications = getApplications();
        final boolean z2 = true;
        if ((applications instanceof Collection) && applications.isEmpty()) {
            r1 = 0;
        } else {
            Iterator<T> it = applications.iterator();
            r1 = 0;
            while (it.hasNext()) {
                if (((Application) it.next()).getSetting() == ApplicationSetting.Important) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (r1 = r1 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                    throw null;
                }
            }
        }
        if (r1 >= AncsNotificationsKt.getMaxNbrImportantApps() && application.getSetting() == ApplicationSetting.Important) {
            z2 = false;
        }
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$canAddOrUpdateApplication$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "canAddOrUpdateApplication, canAdd=" + z2 + ", nbrImportantApps=" + r1 + ", getMaxNbrOfImportantApplications=" + AncsNotificationsKt.getMaxNbrImportantContacts();
            }
        }, 7, (Object) null);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFilterNotifications() {
        this.filterNotificationsFlow.setValue(asFilterNotification());
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public boolean addImportantContact(String platformSpecificIdentifier, String displayName) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        if (getNbrOfImportantContacts() < AncsNotificationsKt.getMaxNbrImportantContacts()) {
            this.resourceSynchronizer.addImportantContact(platformSpecificIdentifier, displayName);
            emitFilterNotifications();
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public boolean addOrUpdatesApplication(final Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (canAddOrUpdateApplication(application)) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$addOrUpdatesApplication$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "add important application identifier=" + Application.this.getIdentifier() + ", " + Application.this.getDisplayName();
                }
            }, 7, (Object) null);
            this.resourceSynchronizer.addOrUpdateImportantApp(application);
            emitFilterNotifications();
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public CommonFlow<FilterNotifications> filterNotificationsFlow() {
        boolean z;
        Flow flow = this.filterNotificationsFlow;
        final long j = this.debounceTimeoutMilliseconds;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j != 0) {
                final FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(new Function1<Object, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Long invoke(Object obj) {
                        return Long.valueOf(j);
                    }
                }, flow, null);
                flow = new Flow<Object>() { // from class: kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(flowKt__DelayKt$debounceInternal$1, flowCollector, null);
                        FlowCoroutine flowCoroutine = new FlowCoroutine(continuation, continuation.getContext());
                        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(flowCoroutine, flowCoroutine, flowCoroutineKt$scopedFlow$1$1);
                        if (startUndispatchedOrReturn == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return startUndispatchedOrReturn;
                        }
                        return Unit.INSTANCE;
                    }
                };
            }
            return FlowExtensionsKt.asCommonFlow(flow);
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public Application getApplication(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return this.resourceSynchronizer.getImportantApp(identifier);
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public List<Application> getApplications() {
        return this.resourceSynchronizer.getImportantApps();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public CommonFlow<List<Application>> getApplicationsFlow(ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(this.resourceSynchronizer.getImportantAppsFlow(setting), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public FilterSettings.Allowed getCallsFilter() {
        FilterSettings.Allowed parseFromId = FilterSettings.Allowed.Companion.parseFromId(this.storage.getInt(this.callsFilterKey));
        if (parseFromId == null) {
            return FilterSettings.Allowed.All;
        }
        return parseFromId;
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public List<ImportantContact> getImportantContacts() {
        return this.resourceSynchronizer.getImportantContacts();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public CommonFlow<List<ImportantContact>> getImportantContactsFlow() {
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(this.resourceSynchronizer.getImportantContactsFlow(), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public int getNbrOfApplications() {
        return this.resourceSynchronizer.getImportantAppCount();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public int getNbrOfImportantContacts() {
        return this.resourceSynchronizer.getNbrOfImportantContacts();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public FilterSettings.Allowed getTextsFilter() {
        FilterSettings.Allowed parseFromId = FilterSettings.Allowed.Companion.parseFromId(this.storage.getInt(this.textsFilterKey));
        if (parseFromId == null) {
            return FilterSettings.Allowed.All;
        }
        return parseFromId;
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public boolean isAllAppsEnabled() {
        Boolean bool = this.storage.getBoolean(this.allAppsKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void removeApplication(final String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$removeApplication$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "remove important application with identifier=" + identifier;
            }
        }, 7, (Object) null);
        this.resourceSynchronizer.removeImportantApp(identifier);
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void removeImportantContact(String platformSpecificIdentifier) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        this.resourceSynchronizer.removeImportantContact(platformSpecificIdentifier);
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void setAllAppsEnabled(final boolean z) {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$isAllAppsEnabled$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Change setting `isAllAppsOn`=" + z;
            }
        }, 7, (Object) null);
        this.storage.put(this.allAppsKey, z);
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public Object setApplications(List<Application> list, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(DispatchersKt.mainDispatcher(), new FilterSettingsImpl$setApplications$2(this, list, null), continuation);
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void setCallsFilter(final FilterSettings.Allowed value) {
        Intrinsics.checkNotNullParameter(value, "value");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$callsFilter$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Change setting `callsFilter`=" + FilterSettings.Allowed.this.getId();
            }
        }, 7, (Object) null);
        this.storage.put(this.callsFilterKey, value.getId());
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void setIgnoredApplications(final List<Application> ignoredApplications) {
        Intrinsics.checkNotNullParameter(ignoredApplications, "ignoredApplications");
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$setIgnoredApplications$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "setIgnoredApplications=" + ignoredApplications;
            }
        }, 7, (Object) null);
        this.resourceSynchronizer.removeImportantAppsWith(ApplicationSetting.Ignored);
        List<Application> list = ignoredApplications;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.resourceSynchronizer.addOrUpdateImportantApp((Application) it.next());
            arrayList.add(Unit.INSTANCE);
        }
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void setTextApplications(final List<Application> textApplications) {
        Intrinsics.checkNotNullParameter(textApplications, "textApplications");
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$setTextApplications$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "setTextApplications=" + textApplications;
            }
        }, 7, (Object) null);
        this.resourceSynchronizer.removeImportantAppsWith(ApplicationSetting.MessagingApplication);
        List<Application> list = textApplications;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.resourceSynchronizer.addOrUpdateImportantApp((Application) it.next());
            arrayList.add(Unit.INSTANCE);
        }
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void setTextsFilter(final FilterSettings.Allowed value) {
        Intrinsics.checkNotNullParameter(value, "value");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$textsFilter$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Change setting `textsFilter`=" + FilterSettings.Allowed.this.getId();
            }
        }, 7, (Object) null);
        this.storage.put(this.textsFilterKey, value.getId());
        emitFilterNotifications();
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public void trackCurrentFilterSettingState() {
        boolean z;
        FilterNotifications value = this.filterNotificationsFlow.getValue();
        List<Application> applications = getApplications();
        AppEvents appEvents = ServiceLocator.INSTANCE.getAnalytics().getAppEvents();
        String trackingString = FilterSettingsImplKt.trackingString(value.getCalls());
        String trackingString2 = FilterSettingsImplKt.trackingString(value.getTexts());
        boolean isAllAppsEnabled = value.isAllAppsEnabled();
        int nbrOfImportantContacts = getNbrOfImportantContacts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : applications) {
            if (((Application) obj).getSetting() == ApplicationSetting.Important) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        final Map<String, String> sendFilterNotification = appEvents.sendFilterNotification(trackingString, trackingString2, isAllAppsEnabled, nbrOfImportantContacts, applications.size(), arrayList.size());
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.filter.FilterSettingsImpl$trackCurrentFilterSettingState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "filter-notification tracked: " + sendFilterNotification;
            }
        }, 7, (Object) null);
    }

    @Override // com.animaconnected.watch.filter.FilterSettings
    public List<Application> getApplications(ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        return this.resourceSynchronizer.getImportantApps(setting);
    }
}
