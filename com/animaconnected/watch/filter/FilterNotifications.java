package com.animaconnected.watch.filter;

import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.msgpack.ByteArrayValue;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.msgpack.MsgPackValuesKt;
import com.animaconnected.watch.device.files.WatchFileKt;
import com.animaconnected.watch.filter.FilterSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.UCollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: FilterNotifications.kt */
/* loaded from: classes3.dex */
public final class FilterNotifications {
    private final List<Application> applications;
    private final FilterSettings.Allowed calls;
    private final List<ImportantContact> importantContact;
    private final boolean isAllAppsEnabled;
    private final FilterSettings.Allowed texts;

    /* compiled from: FilterNotifications.kt */
    /* loaded from: classes3.dex */
    public static final class Setting extends Enum<Setting> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Setting[] $VALUES;
        public static final Companion Companion;
        private final int rawValue;
        public static final Setting None = new Setting("None", 0, 0);
        public static final Setting All = new Setting("All", 1, 1);
        public static final Setting List = new Setting("List", 2, 2);

        /* compiled from: FilterNotifications.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Setting fromInt(int r4) {
                boolean z;
                for (Setting setting : Setting.getEntries()) {
                    if (setting.getRawValue() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return setting;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Setting[] $values() {
            return new Setting[]{None, All, List};
        }

        static {
            Setting[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        private Setting(String str, int r2, int r3) {
            super(str, r2);
            this.rawValue = r3;
        }

        public static EnumEntries<Setting> getEntries() {
            return $ENTRIES;
        }

        public static Setting valueOf(String str) {
            return (Setting) Enum.valueOf(Setting.class, str);
        }

        public static Setting[] values() {
            return (Setting[]) $VALUES.clone();
        }

        public final int getRawValue() {
            return this.rawValue;
        }
    }

    /* compiled from: FilterNotifications.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FilterSettings.Allowed.values().length];
            try {
                r0[FilterSettings.Allowed.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FilterSettings.Allowed.Important.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FilterSettings.Allowed.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public FilterNotifications(FilterSettings.Allowed calls, FilterSettings.Allowed texts, boolean z, List<Application> applications, List<ImportantContact> importantContact) {
        Intrinsics.checkNotNullParameter(calls, "calls");
        Intrinsics.checkNotNullParameter(texts, "texts");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(importantContact, "importantContact");
        this.calls = calls;
        this.texts = texts;
        this.isAllAppsEnabled = z;
        this.applications = applications;
        this.importantContact = importantContact;
    }

    /* renamed from: dekHash-OGnWXxg */
    private final int m1115dekHashOGnWXxg(Application application) {
        return WatchFileKt.dekHash(StringsKt___StringsKt.take(31, application.getIdentifier()));
    }

    public final Map<String, Object> asMap() {
        boolean z;
        int rawValue;
        int rawValue2;
        int rawValue3;
        ByteArrayValue emptyByteArrayValue;
        ByteArrayValue byteArrayValue;
        boolean z2;
        boolean z3;
        boolean z4;
        FilterSettings.Allowed allowed;
        FilterSettings.Allowed allowed2;
        FilterSettings.Allowed allowed3 = this.calls;
        FilterSettings.Allowed allowed4 = FilterSettings.Allowed.Important;
        if (allowed3 != allowed4 && allowed3 != (allowed = FilterSettings.Allowed.All) && (allowed2 = this.texts) != allowed4 && allowed2 != allowed) {
            z = false;
        } else {
            z = true;
        }
        Pair[] pairArr = new Pair[7];
        int[] r5 = WhenMappings.$EnumSwitchMapping$0;
        int r0 = r5[allowed3.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    rawValue = Setting.None.getRawValue();
                } else {
                    rawValue = Setting.None.getRawValue();
                }
            } else {
                rawValue = Setting.List.getRawValue();
            }
        } else {
            rawValue = Setting.All.getRawValue();
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_FN_CALLS, Integer.valueOf(rawValue));
        int r02 = r5[this.texts.ordinal()];
        if (r02 != 1) {
            if (r02 != 2) {
                if (r02 != 3) {
                    rawValue2 = Setting.None.getRawValue();
                } else {
                    rawValue2 = Setting.None.getRawValue();
                }
            } else {
                rawValue2 = Setting.List.getRawValue();
            }
        } else {
            rawValue2 = Setting.All.getRawValue();
        }
        pairArr[1] = new Pair(AnalyticsConstants.KEY_FN_TEXTS, Integer.valueOf(rawValue2));
        boolean z5 = this.isAllAppsEnabled;
        if (z5) {
            rawValue3 = Setting.All.getRawValue();
        } else if (!z5) {
            rawValue3 = Setting.List.getRawValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        pairArr[2] = new Pair("apps", Integer.valueOf(rawValue3));
        List<Application> list = this.applications;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Application) obj).getSetting() == ApplicationSetting.Ignored) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new UInt(m1115dekHashOGnWXxg((Application) it.next())));
        }
        pairArr[3] = new Pair("ignored_apps", new ByteArrayValue(ByteUtils.m746toByteArrayLEajY9A(UCollectionsKt.toUIntArray(CollectionsKt___CollectionsKt.sorted(arrayList2)))));
        List<Application> list2 = this.applications;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (((Application) obj2).getSetting() == ApplicationSetting.MessagingApplication) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(new UInt(m1115dekHashOGnWXxg((Application) it2.next())));
        }
        pairArr[4] = new Pair("text_app_bundle_ids", new ByteArrayValue(ByteUtils.m746toByteArrayLEajY9A(UCollectionsKt.toUIntArray(CollectionsKt___CollectionsKt.sorted(arrayList4)))));
        if (z) {
            List<ImportantContact> list3 = this.importantContact;
            ArrayList arrayList5 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList5.add(new UInt(m1116dekHashOGnWXxg((ImportantContact) it3.next())));
            }
            emptyByteArrayValue = new ByteArrayValue(ByteUtils.m746toByteArrayLEajY9A(UCollectionsKt.toUIntArray(CollectionsKt___CollectionsKt.sorted(arrayList5))));
        } else if (!z) {
            emptyByteArrayValue = MsgPackValuesKt.emptyByteArrayValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        pairArr[5] = new Pair("person_list", emptyByteArrayValue);
        if (this.isAllAppsEnabled) {
            byteArrayValue = MsgPackValuesKt.emptyByteArrayValue();
        } else {
            List<Application> list4 = this.applications;
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : list4) {
                if (((Application) obj3).getSetting() == ApplicationSetting.Important) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList6.add(obj3);
                }
            }
            ArrayList arrayList7 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList6, 10));
            Iterator it4 = arrayList6.iterator();
            while (it4.hasNext()) {
                arrayList7.add(new UInt(m1115dekHashOGnWXxg((Application) it4.next())));
            }
            byteArrayValue = new ByteArrayValue(ByteUtils.m746toByteArrayLEajY9A(UCollectionsKt.toUIntArray(CollectionsKt___CollectionsKt.sorted(arrayList7))));
        }
        pairArr[6] = new Pair("app_list", byteArrayValue);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    public final List<Application> getApplications() {
        return this.applications;
    }

    public final FilterSettings.Allowed getCalls() {
        return this.calls;
    }

    public final FilterSettings.Allowed getTexts() {
        return this.texts;
    }

    public final boolean isAllAppsEnabled() {
        return this.isAllAppsEnabled;
    }

    public final MsgPack messagePack(MsgPackCreator msgPackCreator) {
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        return msgPackCreator.newStringMap(asMap());
    }

    /* renamed from: dekHash-OGnWXxg */
    private final int m1116dekHashOGnWXxg(ImportantContact importantContact) {
        return WatchFileKt.dekHash(importantContact.getDisplayName());
    }
}
