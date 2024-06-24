package com.animaconnected.watch.behaviour.worldtime;

import androidx.compose.foundation.BorderStrokeKt;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPackKotlin;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.assets.WatchAsset;
import com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.WatchConstants;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.FirmwareApp;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: WorldTime.kt */
/* loaded from: classes3.dex */
public final class WorldTime implements FirmwareApp {
    public static final String TYPE = "world_time";
    public static final Companion Companion = new Companion(null);
    private static final List<String> ignoredTimeZoneIds = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"JST", "HKT", "UTC", "EST", "GST", "HST", "EDT", "WAT", "ICT", "EEST", "SGT", "CDT", "CAT", "COT", "NDT", "CLT", "BRT", "MDT", "CLST", "EAT", "ADT", "TRT", "MSK", "PHT", "AKST", "MSD", "CST", "NZST", "WET", "KST", "CEST", "BST", "PET", "AKDT", "ART", "MST", "BDT", "IRST", "NST", "PST", "WEST", "NZDT", "AST", "WIT", "PDT", "EET", "CET", "BRST", "PKT"});
    private final AppId id = AppId.WorldTime;
    private final Mitmap icon = MitmapBackend.getMitmap$default(ServiceLocator.INSTANCE.getMitmapBackend(), WatchAsset.World_Time_App_Icon, null, 2, null);
    private final String type = TYPE;
    private final String analyticsName = TYPE;
    private final Lazy storage$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BasicStorage>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTime$storage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BasicStorage invoke() {
            return ServiceLocator.INSTANCE.getStorageFactory().createStorage("worldTimeStorage");
        }
    });
    private final String worldTimeFile = "worldtime.msg";

    /* compiled from: WorldTime.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<TimeZoneListEntry.PredefinedTimeZoneListEntry> getAdditionalTimeZoneListEntries() {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new TimeZoneListEntry.PredefinedTimeZoneListEntry[]{new TimeZoneListEntry.PredefinedTimeZoneListEntry("Africa/Casablanca", "TimeZone_CityName_Rabat"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Africa/Johannesburg", "TimeZone_CityName_Cape_Town"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Africa/Johannesburg", "TimeZone_CityName_Port_Elizabeth"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Africa/Johannesburg", "TimeZone_CityName_Pretoria"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Africa/Lagos", "TimeZone_CityName_Abuja"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Chicago", "TimeZone_CityName_Minneapolis"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Chicago", "TimeZone_CityName_New_Orleans"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Chicago", "TimeZone_CityName_Austin"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Denver", "TimeZone_CityName_Salt_Lake_City"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Los_Angeles", "TimeZone_CityName_San_Francisco"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Los_Angeles", "TimeZone_CityName_Seattle"), new TimeZoneListEntry.PredefinedTimeZoneListEntry(WatchConstants.DEFAULT_SECONDTIMEZONE_IN_DEFAULT_SECONDTIMEZONE, "TimeZone_CityName_Washington"), new TimeZoneListEntry.PredefinedTimeZoneListEntry(WatchConstants.DEFAULT_SECONDTIMEZONE_IN_DEFAULT_SECONDTIMEZONE, "TimeZone_CityName_Miami"), new TimeZoneListEntry.PredefinedTimeZoneListEntry(WatchConstants.DEFAULT_SECONDTIMEZONE_IN_DEFAULT_SECONDTIMEZONE, "TimeZone_CityName_Atlanta"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Sao_Paulo", "TimeZone_CityName_Rio_de_Janeiro"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Sao_Paulo", "TimeZone_CityName_Brasilia"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Toronto", "TimeZone_CityName_Quebec"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("America/Toronto", "TimeZone_CityName_Ottawa"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Aden", "TimeZone_CityName_Sanaa"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Almaty", "TimeZone_CityName_Astana"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Calcutta", "TimeZone_CityName_New_Delhi"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Calcutta", "TimeZone_CityName_Mumbai"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Calcutta", "TimeZone_CityName_Chennai"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Calcutta", "TimeZone_CityName_Port_Blair"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Dubai", "TimeZone_CityName_Abu_Dhabi"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Ho_Chi_Minh", "TimeZone_CityName_Hanoi"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Jakarta", "TimeZone_CityName_Medan"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Karachi", "TimeZone_CityName_Islamabad"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Asia/Shanghai", "TimeZone_CityName_Beijing"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Australia/Darwin", "TimeZone_CityName_Alice_Springs"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Australia/Sydney", "TimeZone_CityName_Canberra"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Europe/Istanbul", "TimeZone_CityName_Ankara"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Europe/Lisbon", "TimeZone_CityName_Las_Palmas"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Europe/London", "TimeZone_CityName_Belfast"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Europe/London", "TimeZone_CityName_Edinburgh"), new TimeZoneListEntry.PredefinedTimeZoneListEntry(WatchConstants.DEFAULT_SECONDTIMEZONE, "TimeZone_CityName_Malmo"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Europe/Zurich", "TimeZone_CityName_Bern"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Indian/Mahe", "TimeZone_CityName_Seychelles"), new TimeZoneListEntry.PredefinedTimeZoneListEntry("Pacific/Auckland", "TimeZone_CityName_Wellington")});
        }

        public final List<TimeZoneListEntry> getTimeZoneEntries() {
            boolean z;
            TimeZone.Companion.getClass();
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            Intrinsics.checkNotNullExpressionValue(availableZoneIds, "getAvailableZoneIds()");
            Set set = CollectionsKt___CollectionsKt.toSet(WorldTime.ignoredTimeZoneIds);
            Set mutableSet = CollectionsKt___CollectionsKt.toMutableSet(availableZoneIds);
            if (!(set instanceof Collection)) {
                set = CollectionsKt___CollectionsKt.toList(set);
            }
            mutableSet.removeAll(set);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(mutableSet, 10));
            Iterator it = mutableSet.iterator();
            while (it.hasNext()) {
                arrayList.add(new TimeZoneListEntry.SystemTimeZoneListEntry((String) it.next()));
            }
            ArrayList plus = CollectionsKt___CollectionsKt.plus((Iterable) getAdditionalTimeZoneListEntries(), (Collection) arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = plus.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (((TimeZoneListEntry) next).getCity().app().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList2.add(next);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                Object next2 = it3.next();
                if (hashSet.add(((TimeZoneListEntry) next2).getCity().app())) {
                    arrayList3.add(next2);
                }
            }
            return CollectionsKt___CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTime$Companion$special$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return BorderStrokeKt.compareValues(((TimeZoneListEntry) t).getCity().app(), ((TimeZoneListEntry) t2).getCity().app());
                }
            });
        }

        public final KeyString translate(final String timeZoneId) {
            Intrinsics.checkNotNullParameter(timeZoneId, "timeZoneId");
            try {
                return StringsExtensionsKt.getKeyString(WorldTimeKt.toStringKey(timeZoneId));
            } catch (Exception unused) {
                LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTime$Companion$translate$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "did not find a translatable city for zoneId: " + timeZoneId;
                    }
                }, 7, (Object) null);
                return StringsExtensionsKt.m1571static("");
            }
        }

        private Companion() {
        }
    }

    private final /* synthetic */ <K> K get(BasicStorage basicStorage, String str) {
        if (basicStorage.getString(str) == null) {
            return null;
        }
        Json.Default.getClass();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    private final BasicStorage getStorage() {
        return (BasicStorage) this.storage$delegate.getValue();
    }

    private final /* synthetic */ <K> void put(BasicStorage basicStorage, String str, K k) {
        Json.Default.getClass();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.FirmwareApp
    public Object getFiles(Continuation<? super List<WatchFile>> continuation) {
        ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getTimeZones());
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(mutableList, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            TimeZoneListEntry timeZoneListEntry = (TimeZoneListEntry) it.next();
            String firmware = timeZoneListEntry.getCity().firmware();
            int r3 = Duration.$r8$clinit;
            TimeZone.Companion companion = TimeZone.Companion;
            String timeZoneId = timeZoneListEntry.getTimeZoneId();
            companion.getClass();
            TimeZone of = TimeZone.Companion.of(timeZoneId);
            Instant.Companion.getClass();
            linkedHashMap.put(firmware, new Integer((int) Duration.m1678getInWholeMinutesimpl(DurationKt.toDuration(TimeZoneKt.offsetAt(new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")), of).zoneOffset.getTotalSeconds(), DurationUnit.SECONDS))));
        }
        return CollectionsKt__CollectionsKt.listOf(new WatchFile(WatchFileSystem.prefsDir, this.worldTimeFile, MsgPackKotlin.Companion.newStringMap(linkedHashMap).toMsgPackBytes(), true));
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    public final List<TimeZoneListEntry> getTimeZones() {
        Object decodeFromString;
        String string = getStorage().getString("timeZones");
        if (string == null) {
            decodeFromString = null;
        } else {
            Json.Default r1 = Json.Default;
            r1.getClass();
            decodeFromString = r1.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(TimeZoneListEntry.Companion.serializer())), string);
        }
        List<TimeZoneListEntry> list = (List) decodeFromString;
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return StringsExtensionsKt.getKeyString(Key.world_time_title);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    public final void setTimeZones(List<? extends TimeZoneListEntry> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        BasicStorage storage = getStorage();
        Json.Default r1 = Json.Default;
        r1.getClass();
        storage.put("timeZones", r1.encodeToString(new ArrayListSerializer(TimeZoneListEntry.Companion.serializer()), value));
    }
}
