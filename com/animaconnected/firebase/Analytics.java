package com.animaconnected.firebase;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: Analytics.kt */
/* loaded from: classes.dex */
public final class Analytics {
    private final AppEvents appEvents;
    private final AnalyticsBackend backend;
    private List<String> disabledEvents;
    private final int maxEvenNameLength;
    private final int maxNoParams;
    private final int maxParamKeyLength;
    private final int maxParamValueLength;
    private final WatchEvents watchEvents;

    public Analytics(AnalyticsBackend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
        this.maxNoParams = 25;
        this.maxEvenNameLength = 40;
        this.maxParamKeyLength = 40;
        this.maxParamValueLength = 100;
        this.disabledEvents = EmptyList.INSTANCE;
        this.appEvents = new AppEvents(this);
        this.watchEvents = new WatchEvents(this);
    }

    private final boolean isEventDisabled(String str) {
        return this.disabledEvents.contains(str);
    }

    private final String validate(String str, int r3, String str2) {
        int r4;
        if (str.length() >= r3) {
            if (str2 != null) {
                r4 = str2.length();
            } else {
                r4 = 0;
            }
            String substring = str.substring(0, r3 - r4);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static /* synthetic */ String validate$default(Analytics analytics, String str, int r2, String str2, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            str2 = null;
        }
        return analytics.validate(str, r2, str2);
    }

    private final String validateEventName(String str, String str2) {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), validate(str, this.maxEvenNameLength, str2), str2);
    }

    private final String validateParamName(String str, String str2) {
        return validate(str, this.maxParamKeyLength, str2);
    }

    private final String validateParamValue(String str) {
        return validate$default(this, str, this.maxParamValueLength, null, 4, null);
    }

    public final void clearDeviceInfo() {
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_TYPE, null);
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_SERIALNO, null);
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_FW_VERSION, null);
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_ITEM_NO, null);
    }

    public final Map<String, Map<String, String>> formatMap$firebase_release(String eventName, Map<String, String> map) {
        String validateEventName;
        String valueOf;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(map, "map");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = asSequence.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (true) {
            int r5 = 0;
            if (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (str2 != null) {
                    int r8 = this.maxParamValueLength;
                    Iterator it3 = StringsKt___StringsKt.windowed(str2, r8, r8, true, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowed$1
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(CharSequence charSequence) {
                            CharSequence it4 = charSequence;
                            Intrinsics.checkNotNullParameter(it4, "it");
                            return it4.toString();
                        }
                    }).iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        int r9 = r5 + 1;
                        if (r5 >= 0) {
                            String str3 = (String) next;
                            if (r5 == 0) {
                                valueOf = "";
                            } else {
                                valueOf = String.valueOf(r5);
                            }
                            linkedHashMap.put(validateParamName(str, valueOf) + valueOf, str3);
                            r5 = r9;
                        } else {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                            throw null;
                        }
                    }
                } else {
                    linkedHashMap.put(validateParamName(str, null), str2);
                }
                arrayList2.add(MapsKt__MapsKt.toMap(linkedHashMap));
            } else {
                ArrayList arrayList3 = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    CollectionsKt__ReversedViewsKt.addAll(((Map) it4.next()).entrySet(), arrayList3);
                }
                ArrayList chunked = CollectionsKt___CollectionsKt.chunked(arrayList3, this.maxNoParams);
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked, 10));
                Iterator it5 = chunked.iterator();
                while (it5.hasNext()) {
                    Object next2 = it5.next();
                    int r6 = r5 + 1;
                    if (r5 >= 0) {
                        List<Map.Entry> list = (List) next2;
                        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                        if (mapCapacity < 16) {
                            mapCapacity = 16;
                        }
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
                        for (Map.Entry entry2 : list) {
                            Object key = entry2.getKey();
                            String str4 = (String) entry2.getValue();
                            if (str4 == null) {
                                str4 = "";
                            }
                            linkedHashMap2.put(key, str4);
                        }
                        if (r5 == 0) {
                            validateEventName = eventName;
                        } else {
                            validateEventName = validateEventName(eventName, String.valueOf(r5));
                        }
                        arrayList4.add(new Pair(validateEventName, linkedHashMap2));
                        r5 = r6;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                return MapsKt__MapsKt.toMap(arrayList4);
            }
        }
    }

    public final AppEvents getAppEvents() {
        return this.appEvents;
    }

    public final WatchEvents getWatchEvents() {
        return this.watchEvents;
    }

    public final void sendEvent$firebase_release(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isEventDisabled(eventName)) {
            return;
        }
        this.backend.logEvent(eventName, EmptyMap.INSTANCE);
    }

    public final void sendEventMap$firebase_release(String eventName, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(map, "map");
        if (isEventDisabled(eventName) || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Map<String, String>> entry : formatMap$firebase_release(eventName, map).entrySet()) {
            this.backend.logEvent(entry.getKey(), entry.getValue());
        }
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.backend.setAnalyticsCollectionEnabled(z);
    }

    public final void setAppId(String str) {
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
    }

    public final void setAppMode(String str) {
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_APP_MODE, str);
    }

    public final void setDeviceInfo(Integer num, String str, String str2, Integer num2, String str3) {
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_TYPE, String.valueOf(num));
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_SERIALNO, str);
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_FW_VERSION, str2);
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_FW_VARIANT, String.valueOf(num2));
        this.backend.setUserProperty(AnalyticsConstants.USER_PROPERTY_DEVICE_ITEM_NO, str3);
    }

    public final void setDisabledEvents(List<String> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.disabledEvents = events;
    }

    public final void setUserCategory(String userCategory) {
        Intrinsics.checkNotNullParameter(userCategory, "userCategory");
        this.backend.setUserProperty("category", userCategory);
    }
}
