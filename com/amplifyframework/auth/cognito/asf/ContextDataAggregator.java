package com.amplifyframework.auth.cognito.asf;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextDataAggregator.kt */
/* loaded from: classes.dex */
public final class ContextDataAggregator {
    private List<? extends DataCollector> dataCollectors;

    public ContextDataAggregator(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.dataCollectors = CollectionsKt__CollectionsKt.listOf((Object[]) new DataCollector[]{new ApplicationDataCollector(), new BuildDataCollector(), new DeviceDataCollector(deviceId)});
    }

    public final Map<String, String> getAggregatedData(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        List<? extends DataCollector> list = this.dataCollectors;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__ReversedViewsKt.addAll(((DataCollector) it.next()).collect(context).entrySet(), arrayList);
        }
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getValue();
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
