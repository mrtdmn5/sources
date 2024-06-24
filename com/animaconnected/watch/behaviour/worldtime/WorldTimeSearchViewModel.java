package com.animaconnected.watch.behaviour.worldtime;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.TimeZone;

/* compiled from: WorldTimeSearchViewModel.kt */
/* loaded from: classes3.dex */
public final class WorldTimeSearchViewModel {
    private final List<State> allTimeZones;
    private MutableStateFlow<List<State>> privateTimeZones;
    private final CommonFlow<List<State>> timeZones;
    private final WorldTime worldTime;

    /* compiled from: WorldTimeSearchViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private final String city;
        private final String cityKey;
        private final boolean isActive;
        private final String offset;
        private final String zoneId;

        public State(String city, String offset, String zoneId, String cityKey, boolean z) {
            Intrinsics.checkNotNullParameter(city, "city");
            Intrinsics.checkNotNullParameter(offset, "offset");
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            this.city = city;
            this.offset = offset;
            this.zoneId = zoneId;
            this.cityKey = cityKey;
            this.isActive = z;
        }

        public static /* synthetic */ State copy$default(State state, String str, String str2, String str3, String str4, boolean z, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                str = state.city;
            }
            if ((r9 & 2) != 0) {
                str2 = state.offset;
            }
            String str5 = str2;
            if ((r9 & 4) != 0) {
                str3 = state.zoneId;
            }
            String str6 = str3;
            if ((r9 & 8) != 0) {
                str4 = state.cityKey;
            }
            String str7 = str4;
            if ((r9 & 16) != 0) {
                z = state.isActive;
            }
            return state.copy(str, str5, str6, str7, z);
        }

        public final String component1() {
            return this.city;
        }

        public final String component2() {
            return this.offset;
        }

        public final String component3() {
            return this.zoneId;
        }

        public final String component4() {
            return this.cityKey;
        }

        public final boolean component5() {
            return this.isActive;
        }

        public final State copy(String city, String offset, String zoneId, String cityKey, boolean z) {
            Intrinsics.checkNotNullParameter(city, "city");
            Intrinsics.checkNotNullParameter(offset, "offset");
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            Intrinsics.checkNotNullParameter(cityKey, "cityKey");
            return new State(city, offset, zoneId, cityKey, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            if (Intrinsics.areEqual(this.city, state.city) && Intrinsics.areEqual(this.offset, state.offset) && Intrinsics.areEqual(this.zoneId, state.zoneId) && Intrinsics.areEqual(this.cityKey, state.cityKey) && this.isActive == state.isActive) {
                return true;
            }
            return false;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCityKey() {
            return this.cityKey;
        }

        public final String getOffset() {
            return this.offset;
        }

        public final String getZoneId() {
            return this.zoneId;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isActive) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.cityKey, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.zoneId, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.offset, this.city.hashCode() * 31, 31), 31), 31);
        }

        public final boolean isActive() {
            return this.isActive;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("State(city=");
            sb.append(this.city);
            sb.append(", offset=");
            sb.append(this.offset);
            sb.append(", zoneId=");
            sb.append(this.zoneId);
            sb.append(", cityKey=");
            sb.append(this.cityKey);
            sb.append(", isActive=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isActive, ')');
        }
    }

    public WorldTimeSearchViewModel(WorldTime worldTime) {
        Intrinsics.checkNotNullParameter(worldTime, "worldTime");
        this.worldTime = worldTime;
        List<TimeZoneListEntry> timeZoneEntries = WorldTime.Companion.getTimeZoneEntries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = timeZoneEntries.iterator();
        while (it.hasNext()) {
            State uIState = toUIState((TimeZoneListEntry) it.next());
            if (uIState != null) {
                arrayList.add(uIState);
            }
        }
        this.allTimeZones = arrayList;
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(arrayList);
        this.privateTimeZones = MutableStateFlow;
        this.timeZones = FlowExtensionsKt.asCommonFlow(MutableStateFlow);
    }

    public static /* synthetic */ boolean addTimeZone$default(WorldTimeSearchViewModel worldTimeSearchViewModel, String str, String str2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            str2 = "";
        }
        return worldTimeSearchViewModel.addTimeZone(str, str2);
    }

    private final List<TimeZoneListEntry> getStoredTimezones() {
        return this.worldTime.getTimeZones();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[Catch: Exception -> 0x0091, TryCatch #0 {Exception -> 0x0091, blocks: (B:3:0x0003, B:9:0x001f, B:11:0x0023, B:14:0x002c, B:18:0x0036, B:19:0x006b, B:21:0x0071, B:27:0x0085), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel.State toUIState(final com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry r11) {
        /*
            r10 = this;
            java.lang.String r0 = "GMT"
            r1 = 0
            com.animaconnected.watch.behaviour.worldtime.WorldTime$Companion r2 = com.animaconnected.watch.behaviour.worldtime.WorldTime.Companion     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = r11.getIdentifier()     // Catch: java.lang.Exception -> L91
            com.animaconnected.watch.strings.KeyString r2 = r2.translate(r3)     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = r2.app()     // Catch: java.lang.Exception -> L91
            int r3 = r3.length()     // Catch: java.lang.Exception -> L91
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L1b
            r3 = r4
            goto L1c
        L1b:
            r3 = r5
        L1c:
            if (r3 == 0) goto L1f
            return r1
        L1f:
            boolean r3 = r11 instanceof com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry.PredefinedTimeZoneListEntry     // Catch: java.lang.Exception -> L91
            if (r3 == 0) goto L27
            r3 = r11
            com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry$PredefinedTimeZoneListEntry r3 = (com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry.PredefinedTimeZoneListEntry) r3     // Catch: java.lang.Exception -> L91
            goto L28
        L27:
            r3 = r1
        L28:
            java.lang.String r6 = ""
            if (r3 == 0) goto L35
            java.lang.String r3 = r3.getCityKey()     // Catch: java.lang.Exception -> L91
            if (r3 != 0) goto L33
            goto L35
        L33:
            r7 = r3
            goto L36
        L35:
            r7 = r6
        L36:
            kotlinx.datetime.TimeZone$Companion r3 = kotlinx.datetime.TimeZone.Companion     // Catch: java.lang.Exception -> L91
            java.lang.String r8 = r11.getTimeZoneId()     // Catch: java.lang.Exception -> L91
            r3.getClass()     // Catch: java.lang.Exception -> L91
            kotlinx.datetime.TimeZone r3 = kotlinx.datetime.TimeZone.Companion.of(r8)     // Catch: java.lang.Exception -> L91
            kotlinx.datetime.Instant r8 = com.animaconnected.info.DateTimeUtilsKt.now()     // Catch: java.lang.Exception -> L91
            kotlinx.datetime.UtcOffset r3 = kotlinx.datetime.TimeZoneKt.offsetAt(r8, r3)     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L91
            java.lang.String r8 = "Z"
            java.lang.String r3 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r3, r8, r6)     // Catch: java.lang.Exception -> L91
            java.lang.String r0 = r0.concat(r3)     // Catch: java.lang.Exception -> L91
            java.lang.String r3 = r2.app()     // Catch: java.lang.Exception -> L91
            java.lang.String r6 = r11.getTimeZoneId()     // Catch: java.lang.Exception -> L91
            java.util.List r2 = r10.getStoredTimezones()     // Catch: java.lang.Exception -> L91
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Exception -> L91
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L91
        L6b:
            boolean r8 = r2.hasNext()     // Catch: java.lang.Exception -> L91
            if (r8 == 0) goto L7f
            java.lang.Object r8 = r2.next()     // Catch: java.lang.Exception -> L91
            r9 = r8
            com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry r9 = (com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry) r9     // Catch: java.lang.Exception -> L91
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r9)     // Catch: java.lang.Exception -> L91
            if (r9 == 0) goto L6b
            goto L80
        L7f:
            r8 = r1
        L80:
            if (r8 == 0) goto L84
            r8 = r4
            goto L85
        L84:
            r8 = r5
        L85:
            com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$State r9 = new com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$State     // Catch: java.lang.Exception -> L91
            r2 = r9
            r4 = r0
            r5 = r6
            r6 = r7
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L91
            r1 = r9
            goto La0
        L91:
            r0 = move-exception
            r3 = 0
            r4 = 0
            r5 = 0
            com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$toUIState$2 r6 = new com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$toUIState$2
            r6.<init>()
            r7 = 7
            r8 = 0
            r2 = r10
            com.animaconnected.logger.LogKt.warn$default(r2, r3, r4, r5, r6, r7, r8)
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel.toUIState(com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry):com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$State");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean addTimeZone(final String zoneId, final String cityKey) {
        TimeZoneListEntry.PredefinedTimeZoneListEntry predefinedTimeZoneListEntry;
        boolean z;
        Object predefinedTimeZoneListEntry2;
        String str;
        boolean z2;
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        Intrinsics.checkNotNullParameter(cityKey, "cityKey");
        try {
            Iterator<T> it = getStoredTimezones().iterator();
            while (true) {
                predefinedTimeZoneListEntry = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                TimeZoneListEntry timeZoneListEntry = (TimeZoneListEntry) next;
                if (timeZoneListEntry instanceof TimeZoneListEntry.PredefinedTimeZoneListEntry) {
                    predefinedTimeZoneListEntry = (TimeZoneListEntry.PredefinedTimeZoneListEntry) timeZoneListEntry;
                }
                if (predefinedTimeZoneListEntry == null || (str = predefinedTimeZoneListEntry.getCityKey()) == null) {
                    str = "";
                }
                if (Intrinsics.areEqual(timeZoneListEntry.getTimeZoneId(), zoneId) && Intrinsics.areEqual(str, cityKey)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    predefinedTimeZoneListEntry = next;
                    break;
                }
            }
            if (predefinedTimeZoneListEntry != null) {
                LogKt.debug$default((Object) this, "Timezone already added, zoneId = " + zoneId + ", cityKey = " + cityKey, (String) null, (Throwable) null, false, 14, (Object) null);
                return false;
            }
            TimeZone.Companion.getClass();
            TimeZone of = TimeZone.Companion.of(zoneId);
            WorldTime.Companion.translate(cityKey);
            if (cityKey.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                predefinedTimeZoneListEntry2 = new TimeZoneListEntry.SystemTimeZoneListEntry(of.getId());
            } else {
                predefinedTimeZoneListEntry2 = new TimeZoneListEntry.PredefinedTimeZoneListEntry(of.getId(), cityKey);
            }
            this.worldTime.setTimeZones(CollectionsKt___CollectionsKt.plus(getStoredTimezones(), predefinedTimeZoneListEntry2));
            return true;
        } catch (Exception e) {
            LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel$addTimeZone$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "could not add timezone -> zoneId: " + zoneId + ", cityKey: " + cityKey + ", exception: " + e;
                }
            }, 7, (Object) null);
            return false;
        }
    }

    public final void filterTimeZones(String searchText) {
        List<State> value;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        if (StringsKt__StringsJVMKt.isBlank(searchText)) {
            MutableStateFlow<List<State>> mutableStateFlow = this.privateTimeZones;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), this.allTimeZones));
            return;
        }
        String lowerCase = searchText.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        MutableStateFlow<List<State>> mutableStateFlow2 = this.privateTimeZones;
        do {
            value = mutableStateFlow2.getValue();
            List<State> list = this.allTimeZones;
            arrayList = new ArrayList();
            for (Object obj : list) {
                String lowerCase2 = ((State) obj).getCity().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt__StringsKt.contains(lowerCase2, lowerCase, false)) {
                    arrayList.add(obj);
                }
            }
        } while (!mutableStateFlow2.compareAndSet(value, arrayList));
    }

    public final CommonFlow<List<State>> getTimeZones() {
        return this.timeZones;
    }
}
