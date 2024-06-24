package com.animaconnected.watch.display;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.coroutines.FlowQuery;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import com.animaconnected.watch.WatchDatabase;
import com.animaconnected.watch.device.files.FileDescriptor;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.filter.Ancs;
import com.animaconnected.watch.filter.AncsFilter;
import com.animaconnected.watch.filter.AncsQueries;
import com.animaconnected.watch.filter.Application;
import com.animaconnected.watch.filter.ApplicationQueries;
import com.animaconnected.watch.filter.ApplicationSetting;
import com.animaconnected.watch.filter.DBAncsFilter;
import com.animaconnected.watch.filter.DBApplication;
import com.animaconnected.watch.filter.FilterSettingsExtensionKt;
import com.animaconnected.watch.filter.ImportantContact;
import com.animaconnected.watch.filter.ImportantContactQueries;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.sync.AppsQueries;
import com.animaconnected.watch.sync.ConfigQueries;
import com.animaconnected.watch.sync.DBApp;
import com.animaconnected.watch.sync.DBAppPositions;
import com.animaconnected.watch.sync.DBFile;
import com.animaconnected.watch.sync.FilesQueries;
import com.animaconnected.watch.sync.GetEditableFiles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ResourceSynchronizer.kt */
/* loaded from: classes3.dex */
public final class ResourceSynchronizer {
    private final AncsQueries ancs;
    private final AppsQueries apps;
    private final ConfigQueries configs;
    private final FilesQueries files;
    private final FitnessQueries fitness;
    private final ApplicationQueries importantApplications;
    private final ImportantContactQueries importantContacts;
    private final String tag;

    public ResourceSynchronizer(WatchDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.files = database.getFilesQueries();
        this.apps = database.getAppsQueries();
        this.configs = database.getConfigQueries();
        this.fitness = database.getFitnessQueries();
        this.ancs = database.getAncsQueries();
        this.importantContacts = database.getImportantContactQueries();
        this.importantApplications = database.getApplicationQueries();
        this.tag = "WatchSync";
    }

    private final void addNewApp(int r4, long j) {
        long j2;
        this.apps.addApp(Integer.valueOf(r4), j);
        Long l = (Long) CollectionsKt___CollectionsKt.maxOrNull(this.apps.getAllPositions(new Function2<Integer, Long, Long>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$addNewApp$maxPos$1
            public final Long invoke(int r1, long j3) {
                return Long.valueOf(j3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(Integer num, Long l2) {
                return invoke(num.intValue(), l2.longValue());
            }
        }).executeAsList());
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = -1;
        }
        this.apps.updatePosition(Integer.valueOf(r4), j2 + 1);
    }

    private final Query<Application> getImportantAppsQuery() {
        return this.importantApplications.getAllApplications(new Function3<String, Long, String, Application>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$getImportantAppsQuery$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Application invoke(String str, Long l, String str2) {
                return invoke(str, l.longValue(), str2);
            }

            public final Application invoke(String identifier, long j, String displayName) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(displayName, "displayName");
                return new Application(identifier, displayName, ApplicationSetting.Companion.fromInt((int) j));
            }
        });
    }

    private final Query<ImportantContact> getImportantContactsQuery() {
        return this.importantContacts.getAllImportantContacts(new Function4<String, String, String, String, ImportantContact>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$getImportantContactsQuery$1
            @Override // kotlin.jvm.functions.Function4
            public final ImportantContact invoke(String platform_specific_identifier, String display_name, String str, String str2) {
                Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
                Intrinsics.checkNotNullParameter(display_name, "display_name");
                return new ImportantContact(platform_specific_identifier, display_name, false, 4, (DefaultConstructorMarker) null);
            }
        });
    }

    public final boolean addAppIfMissing(AppId appId, String name, boolean z) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(name, "name");
        int code = appId.getCode();
        if (this.apps.getApp(code).executeAsOneOrNull() != null) {
            return false;
        }
        addNewApp(code, (name + ":null:" + z).hashCode());
        return true;
    }

    public final void addImportantContact(String platformSpecificIdentifier, String displayName) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.importantContacts.addImportantContact(platformSpecificIdentifier, displayName, null, null);
    }

    public final void addOrUpdateImportantApp(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.importantApplications.addOrUpdatesApplication(application.getIdentifier(), application.getDisplayName(), application.getSetting().getRawValue());
    }

    public final void ancsFilterWritten(final AncsFilter ancsFilter, String identifier) {
        Intrinsics.checkNotNullParameter(ancsFilter, "ancsFilter");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (FilterSettingsExtensionKt.isDeleteFilter(ancsFilter)) {
            LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$ancsFilterWritten$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Adding empty filter to DB at index ");
                    sb.append(AncsFilter.this.getIndex());
                    return sb.toString();
                }
            }, 7, (Object) null);
            this.ancs.addEmptyAncsFilter(identifier, ancsFilter.getIndex());
            return;
        }
        LogKt.verbose$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$ancsFilterWritten$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder("Adding filter to DB at index ");
                sb.append(AncsFilter.this.getIndex());
                return sb.toString();
            }
        }, 7, (Object) null);
        AncsQueries ancsQueries = this.ancs;
        long index = ancsFilter.getIndex();
        Ancs.Category.Companion companion = Ancs.Category.Companion;
        Intrinsics.checkNotNull(ancsFilter.getAncsCategory());
        Long valueOf = Long.valueOf(companion.bitmask(r2));
        Intrinsics.checkNotNull(ancsFilter.getAncsAttribute());
        ancsQueries.addAncsFilter(identifier, index, valueOf, Long.valueOf(r1.bitmask()), ancsFilter.getSearchString(), Long.valueOf(Ancs.VibrationPattern.Single.getRawValue()));
    }

    public final Set<AncsFilter> ancsFilters(String identifier) {
        Set<Ancs.Category> set;
        Ancs.Attribute attribute;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        List<DBAncsFilter> executeAsList = this.ancs.getAncsFiltersForWatch(identifier).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList, 10));
        for (DBAncsFilter dBAncsFilter : executeAsList) {
            int idx = (int) dBAncsFilter.getIdx();
            Long ancs_category = dBAncsFilter.getAncs_category();
            if (ancs_category != null) {
                set = Ancs.Category.Companion.fromBitmask((int) ancs_category.longValue());
            } else {
                set = null;
            }
            Long ancs_attribute = dBAncsFilter.getAncs_attribute();
            if (ancs_attribute != null) {
                attribute = Ancs.Attribute.Companion.fromInt((int) ancs_attribute.longValue());
            } else {
                attribute = null;
            }
            String search_string = dBAncsFilter.getSearch_string();
            if (search_string == null) {
                search_string = "";
            }
            arrayList.add(new AncsFilter(idx, set, attribute, search_string, Ancs.VibrationPattern.Single));
        }
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj : arrayList) {
            linkedHashMap.put(Integer.valueOf(((AncsFilter) obj).getIndex()), obj);
        }
        IntRange until = RangesKt___RangesKt.until(0, 35);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            AncsFilter ancsFilter = (AncsFilter) linkedHashMap.get(Integer.valueOf(nextInt));
            if (ancsFilter == null) {
                ancsFilter = new AncsFilter(nextInt, null, null, "", Ancs.VibrationPattern.Single);
            }
            arrayList2.add(ancsFilter);
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    public final void clearDatabases() {
        this.apps.clearApps();
        this.apps.clearPositions();
        this.files.clearFiles();
        this.files.clearFileSync();
        this.configs.clearConfigs();
    }

    public final boolean ensureApp(AppId appId, long j) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        int code = appId.getCode();
        DBApp executeAsOneOrNull = this.apps.getApp(code).executeAsOneOrNull();
        if (executeAsOneOrNull == null) {
            addNewApp(code, j);
            return true;
        }
        if (j != executeAsOneOrNull.getData_hash()) {
            this.apps.updateApp(Integer.valueOf(code), j);
            return true;
        }
        return false;
    }

    public final List<DBAppPositions> getAllAppPositions() {
        return this.apps.getAllPositions().executeAsList();
    }

    public final List<FileDescriptor> getAllSyncedFiles(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        List<DBFile> executeAsList = this.files.getFilesOnWatch(identifier).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList, 10));
        Iterator<T> it = executeAsList.iterator();
        while (it.hasNext()) {
            arrayList.add(ResourceSynchronizerKt.toFileDescriptor$default((DBFile) it.next(), null, 1, null));
        }
        return arrayList;
    }

    public final List<Integer> getAppIds() {
        return this.apps.getAllAppIds().executeAsList();
    }

    public final Long getAppPosition(int r2) {
        return this.apps.getPosition(r2).executeAsOneOrNull();
    }

    public final HealthGoals getCurrentDailyGoals() {
        return FitnessDatabaseExtensionsKt.getGoals(this.fitness, DateTimeUtilsKt.currentTimeMillis()).executeAsOneOrNull();
    }

    public final DBFile getEditableFile(String address, String pathHash) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(pathHash, "pathHash");
        return this.files.getEditableFile(address, pathHash).executeAsOneOrNull();
    }

    public final List<GetEditableFiles> getEditableFiles(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.files.getEditableFiles(address).executeAsList();
    }

    public final Application getImportantApp(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        DBApplication executeAsOneOrNull = this.importantApplications.getApplication(identifier).executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            return new Application(executeAsOneOrNull.getIdentifier(), executeAsOneOrNull.getDisplay_name(), ApplicationSetting.Companion.fromInt((int) executeAsOneOrNull.getSetting()));
        }
        return null;
    }

    public final int getImportantAppCount() {
        return (int) this.importantApplications.getNbrOfApplications().executeAsOne().longValue();
    }

    public final List<Application> getImportantApps() {
        return getImportantAppsQuery().executeAsList();
    }

    public final Flow<Query<Application>> getImportantAppsFlow(ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        return FlowQuery.toFlow(getImportantAppsQuery(setting));
    }

    public final List<ImportantContact> getImportantContacts() {
        return getImportantContactsQuery().executeAsList();
    }

    public final Flow<Query<ImportantContact>> getImportantContactsFlow() {
        return FlowQuery.toFlow(getImportantContactsQuery());
    }

    public final int getNbrOfImportantContacts() {
        return (int) this.importantContacts.getNbrOfImportantContacts().executeAsOne().longValue();
    }

    public final List<FileDescriptor> getSyncedFiles(String address, String directory) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        List<DBFile> executeAsList = this.files.getSyncedFiles(address, directory).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList, 10));
        Iterator<T> it = executeAsList.iterator();
        while (it.hasNext()) {
            arrayList.add(ResourceSynchronizerKt.toFileDescriptor$default((DBFile) it.next(), null, 1, null));
        }
        return arrayList;
    }

    public final boolean isConfigSynced(String address, String command, int r4) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(command, "command");
        if (this.configs.getConfig(address, command, r4).executeAsOneOrNull() != null) {
            return true;
        }
        return false;
    }

    public final boolean isFileSynced(String address, WatchFile file) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(file, "file");
        return isFileSynced(address, file.getDirectory(), file.getName(), Long.toString(file.m1107getDataHashpVg5ArA() & 4294967295L, 10), file.getSize(), file.getEditablePathHash());
    }

    public final void removeImportantApp(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.importantApplications.removeApplication(identifier);
    }

    public final void removeImportantApps() {
        removeImportantAppsWith(ApplicationSetting.Important);
        removeImportantAppsWith(ApplicationSetting.NotImportant);
    }

    public final void removeImportantAppsWith(ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        this.importantApplications.removeApplicationsWithSetting(setting.getRawValue());
    }

    public final void removeImportantContact(String platformSpecificIdentifier) {
        Intrinsics.checkNotNullParameter(platformSpecificIdentifier, "platformSpecificIdentifier");
        this.importantContacts.removeImportantContact(platformSpecificIdentifier);
    }

    public final void setAllFilesUnSynced(final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.files.setAllFilesNotSynched(address);
        LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setAllFilesUnSynced$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Files UnSynced for " + address;
            }
        }, 6, (Object) null);
    }

    public final void setConfigSynced(String address, String command, int r4) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(command, "command");
        this.configs.removeConfig(address, command);
        this.configs.addConfig(address, command, r4);
    }

    public final void setConfigUnSynced(String address, String command) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(command, "command");
        this.configs.removeConfig(address, command);
    }

    public final void setDirectoryUnsynced(final String address, String directory) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.files.unsyncDirectory(address, directory);
        LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setDirectoryUnsynced$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Links UnSynced for " + address;
            }
        }, 6, (Object) null);
    }

    public final void setFileNotSynced(String str, final String str2, final String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, WatchSettingsFragment.addressBundleKey, str2, "directory", str3, "name");
        try {
            DBFile executeAsOneOrNull = this.files.getSyncedFile(str, str2, str3).executeAsOneOrNull();
            if (executeAsOneOrNull != null) {
                long id = executeAsOneOrNull.getId();
                LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setFileNotSynced$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "File with same name exist, removing file: " + str2 + " + " + str3;
                    }
                }, 6, (Object) null);
                this.files.setFileNotSynchedForWatch(id, str);
            }
        } catch (Exception unused) {
            for (final DBFile dBFile : this.files.getSyncedFile(str, str2, str3).executeAsList()) {
                LogKt.err$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setFileNotSynced$fileId$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Multiple Files with same name exist, removing " + str2 + " + " + str3 + " removing " + dBFile;
                    }
                }, 6, (Object) null);
                this.files.setFileNotSynchedForWatch(dBFile.getId(), str);
            }
        }
    }

    public final void setFileSynced(final String address, final WatchFile file) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(file, "file");
        if (isFileSynced(address, file)) {
            LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setFileSynced$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "File already Synced: " + address + " -> " + file;
                }
            }, 6, (Object) null);
        } else {
            this.files.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setFileSynced$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                    invoke2(transactionWithoutReturn);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TransactionWithoutReturn transaction) {
                    FilesQueries filesQueries;
                    FilesQueries filesQueries2;
                    String str;
                    Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                    ResourceSynchronizer.this.setFileNotSynced(address, file);
                    filesQueries = ResourceSynchronizer.this.files;
                    DBFile executeAsOneOrNull = filesQueries.getFile(file.getDirectory(), file.getName(), Long.toString(file.m1107getDataHashpVg5ArA() & 4294967295L, 10), file.getSize(), file.getEditablePathHash()).executeAsOneOrNull();
                    if (executeAsOneOrNull != null) {
                        final DBFile dBFile = executeAsOneOrNull;
                        filesQueries2 = ResourceSynchronizer.this.files;
                        filesQueries2.setSynced(address, dBFile.getId());
                        str = ResourceSynchronizer.this.tag;
                        final String str2 = address;
                        LogKt.verbose$default((Object) transaction, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$setFileSynced$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "File Synced: " + str2 + " -> " + dBFile.getId();
                            }
                        }, 6, (Object) null);
                        return;
                    }
                    throw new IllegalArgumentException("File isn't stored into database, this should never happen".toString());
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlin.collections.EmptyList] */
    public final List<Integer> updateAppPositions(final List<Integer> appPositions) {
        Intrinsics.checkNotNullParameter(appPositions, "appPositions");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = EmptyList.INSTANCE;
        this.apps.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$updateAppPositions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.ArrayList] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                AppsQueries appsQueries;
                Integer num;
                AppsQueries appsQueries2;
                AppsQueries appsQueries3;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                List<Integer> list = appPositions;
                ResourceSynchronizer resourceSynchronizer = this;
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                int r4 = 0;
                while (true) {
                    Integer num2 = null;
                    if (!it.hasNext()) {
                        final ArrayList filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
                        appsQueries = this.apps;
                        List<Integer> executeAsList = appsQueries.getAllAppIds().executeAsList();
                        List<Integer> list2 = appPositions;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : executeAsList) {
                            if (!list2.contains(Integer.valueOf(((Number) obj).intValue()))) {
                                arrayList2.add(obj);
                            }
                        }
                        ResourceSynchronizer resourceSynchronizer2 = this;
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            int intValue = ((Number) it2.next()).intValue();
                            if (resourceSynchronizer2.getAppPosition(intValue) != null) {
                                appsQueries2 = resourceSynchronizer2.apps;
                                appsQueries2.removePosition(intValue);
                                num = Integer.valueOf(intValue);
                            } else {
                                num = null;
                            }
                            if (num != null) {
                                arrayList3.add(num);
                            }
                        }
                        LogKt.debug$default((Object) transaction, "WatchManager", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$updateAppPositions$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Updated apps: ".concat(CollectionsKt___CollectionsKt.joinToString$default(filterNotNull, null, null, null, null, 63));
                            }
                        }, 6, (Object) null);
                        ref$ObjectRef.element = CollectionsKt___CollectionsKt.plus((Iterable) arrayList3, (Collection) filterNotNull);
                        return;
                    }
                    Object next = it.next();
                    int r7 = r4 + 1;
                    if (r4 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                    int intValue2 = ((Number) next).intValue();
                    Long appPosition = resourceSynchronizer.getAppPosition(intValue2);
                    if (!(appPosition != null && ((int) appPosition.longValue()) == r4)) {
                        appsQueries3 = resourceSynchronizer.apps;
                        appsQueries3.updatePosition(Integer.valueOf(intValue2), r4);
                        num2 = Integer.valueOf(intValue2);
                    }
                    arrayList.add(num2);
                    r4 = r7;
                }
            }
        });
        return (List) ref$ObjectRef.element;
    }

    private final Query<Application> getImportantAppsQuery(ApplicationSetting applicationSetting) {
        return this.importantApplications.getAllApplicationsBySetting(applicationSetting.getRawValue(), new Function3<String, Long, String, Application>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$getImportantAppsQuery$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Application invoke(String str, Long l, String str2) {
                return invoke(str, l.longValue(), str2);
            }

            public final Application invoke(String identifier, long j, String displayName) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(displayName, "displayName");
                return new Application(identifier, displayName, ApplicationSetting.Companion.fromInt((int) j));
            }
        });
    }

    public final List<Application> getImportantApps(ApplicationSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        return getImportantAppsQuery(setting).executeAsList();
    }

    public final Flow<Query<Application>> getImportantAppsFlow() {
        return FlowQuery.toFlow(getImportantAppsQuery());
    }

    private final boolean isFileSynced(final String str, final String str2, final String str3, final String str4, final int r18, final String str5) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        this.files.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$isFileSynced$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                FilesQueries filesQueries;
                FilesQueries filesQueries2;
                String str6;
                FilesQueries filesQueries3;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                filesQueries = ResourceSynchronizer.this.files;
                if (filesQueries.getFile(str2, str3, str4, r18, str5).executeAsOneOrNull() == null) {
                    str6 = ResourceSynchronizer.this.tag;
                    final String str7 = str3;
                    final String str8 = str4;
                    LogKt.verbose$default((Object) transaction, str6, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$isFileSynced$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "File did not exist in database. Adding File name: " + str7 + " hash: " + str8;
                        }
                    }, 6, (Object) null);
                    filesQueries3 = ResourceSynchronizer.this.files;
                    filesQueries3.addFile(str2, str3, str4, r18, str5);
                    ref$BooleanRef.element = false;
                    return;
                }
                Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                filesQueries2 = ResourceSynchronizer.this.files;
                ref$BooleanRef2.element = filesQueries2.isFileSynced(str, str2, str3, str4, r18, str5).executeAsOneOrNull() != null;
            }
        });
        LogKt.verbose$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.ResourceSynchronizer$isFileSynced$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "File (" + str3 + ") did exist in database. Is synced? " + ref$BooleanRef.element;
            }
        }, 6, (Object) null);
        return ref$BooleanRef.element;
    }

    public final void setFileNotSynced(String address, WatchFile file) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(file, "file");
        setFileNotSynced(address, file.getDirectory(), file.getName());
    }
}
