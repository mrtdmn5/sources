package com.animaconnected.watch.filter;

import com.animaconnected.watch.filter.Ancs;
import com.animaconnected.watch.filter.FilterSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: FilterSettingsExtension.kt */
/* loaded from: classes3.dex */
public final class FilterSettingsExtensionKt {

    /* compiled from: FilterSettingsExtension.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FilterSettings.Allowed.values().length];
            try {
                r0[FilterSettings.Allowed.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final AncsFilter ancsCallsFilter(FilterSettings filterSettings) {
        if (WhenMappings.$EnumSwitchMapping$0[filterSettings.getCallsFilter().ordinal()] == 1) {
            return new AncsFilter(0, SetsKt__SetsKt.setOf(Ancs.Category.IncomingCall), Ancs.Attribute.All, "", Ancs.VibrationPattern.Single);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public static final Object ancsFilters(FilterSettings filterSettings, Continuation<? super Set<AncsFilter>> continuation) {
        List list;
        int r3;
        AncsFilter ancsCallsFilter = ancsCallsFilter(filterSettings);
        List list2 = EmptyList.INSTANCE;
        if (ancsCallsFilter != null) {
            list = CollectionsKt__CollectionsKt.listOf(ancsCallsFilter);
        } else {
            list = list2;
        }
        AncsFilter ancsTextsFilter = ancsTextsFilter(filterSettings);
        if (ancsTextsFilter != null) {
            list2 = CollectionsKt__CollectionsKt.listOf(ancsTextsFilter);
        }
        List<AncsFilter> ancsImportantContacts = ancsImportantContacts(filterSettings, 2);
        AncsFilter ancsFilter = (AncsFilter) CollectionsKt___CollectionsKt.firstOrNull((List) ancsImportantContacts);
        if (ancsFilter != null) {
            r3 = ancsFilter.getIndex();
        } else {
            r3 = 2;
        }
        ArrayList flatten = CollectionsKt__IteratorsJVMKt.flatten(CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{list, list2, ancsImportantContacts, ancsImportantApplications(filterSettings, r3)}));
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(flatten, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator it = flatten.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            linkedHashMap.put(new Integer(((AncsFilter) next).getIndex()), next);
        }
        IntRange until = RangesKt___RangesKt.until(0, 35);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        ?? it2 = until.iterator();
        while (it2.hasNext) {
            int nextInt = it2.nextInt();
            AncsFilter ancsFilter2 = (AncsFilter) linkedHashMap.get(new Integer(nextInt));
            if (ancsFilter2 == null) {
                ancsFilter2 = new AncsFilter(nextInt, null, null, "", Ancs.VibrationPattern.Single);
            }
            arrayList.add(ancsFilter2);
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    private static final List<AncsFilter> ancsImportantApplications(FilterSettings filterSettings, int r12) {
        int r2;
        List<Application> applications = filterSettings.getApplications();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = applications.iterator();
        while (true) {
            r2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Application) next).getSetting() == ApplicationSetting.Important) {
                r2 = 1;
            }
            if (r2 != 0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        for (Object obj : arrayList) {
            int r3 = r2 + 1;
            if (r2 >= 0) {
                arrayList2.add(new AncsFilter(r12 + r2, Ancs.Category.Companion.all(), Ancs.Attribute.ApplicationId, ((Application) obj).getIdentifier(), Ancs.VibrationPattern.Single));
                r2 = r3;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return arrayList2;
    }

    private static final List<AncsFilter> ancsImportantContacts(FilterSettings filterSettings, int r13) {
        List<ImportantContact> importantContacts = filterSettings.getImportantContacts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(importantContacts, 10));
        int r2 = 0;
        for (Object obj : importantContacts) {
            int r4 = r2 + 1;
            if (r2 >= 0) {
                arrayList.add(new AncsFilter(r13 + r2, setOfCategories(filterSettings), Ancs.Attribute.Title, ((ImportantContact) obj).getDisplayName(), Ancs.VibrationPattern.Single));
                r2 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return arrayList;
    }

    private static final AncsFilter ancsTextsFilter(FilterSettings filterSettings) {
        if (WhenMappings.$EnumSwitchMapping$0[filterSettings.getTextsFilter().ordinal()] == 1) {
            return new AncsFilter(1, SetsKt__SetsKt.setOf(Ancs.Category.Social), Ancs.Attribute.Title, "", Ancs.VibrationPattern.Single);
        }
        return null;
    }

    public static final Object[] asArray(AncsFilter ancsFilter) {
        Object obj;
        Intrinsics.checkNotNullParameter(ancsFilter, "<this>");
        if (ancsFilter.getAncsCategory() == null) {
            return new Object[]{Integer.valueOf(ancsFilter.getIndex())};
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(ancsFilter.getIndex());
        objArr[1] = Integer.valueOf(Ancs.Category.Companion.bitmask(ancsFilter.getAncsCategory()));
        Ancs.Attribute ancsAttribute = ancsFilter.getAncsAttribute();
        if (ancsAttribute != null) {
            obj = Integer.valueOf(ancsAttribute.getRawValue());
        } else {
            obj = Ancs.Attribute.All;
        }
        objArr[2] = obj;
        objArr[3] = StringsKt___StringsKt.take(32, ancsFilter.getSearchString());
        objArr[4] = Integer.valueOf(ancsFilter.getVibration().getRawValue());
        return objArr;
    }

    public static final boolean isDeleteFilter(AncsFilter ancsFilter) {
        Intrinsics.checkNotNullParameter(ancsFilter, "<this>");
        if (ancsFilter.getAncsCategory() == null && ancsFilter.getAncsAttribute() == null) {
            return true;
        }
        return false;
    }

    private static final Set<Ancs.Category> setOfCategories(FilterSettings filterSettings) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        FilterSettings.Allowed callsFilter = filterSettings.getCallsFilter();
        FilterSettings.Allowed allowed = FilterSettings.Allowed.Important;
        if (callsFilter == allowed) {
            linkedHashSet.add(Ancs.Category.IncomingCall);
        }
        if (filterSettings.getTextsFilter() == allowed) {
            linkedHashSet.add(Ancs.Category.Social);
        }
        return linkedHashSet;
    }
}
