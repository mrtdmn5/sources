package com.animaconnected.secondo.provider;

import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;

/* compiled from: NotificationDetailsAnalytics.kt */
/* loaded from: classes3.dex */
public final class NotificationDetailsAnalyticsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, String> jsonEncodeValues(Map<String, ? extends Object> map) {
        Gson gson = new Gson();
        Set<Map.Entry<String, ? extends Object>> entrySet = map.entrySet();
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entrySet, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), gson.toJson(entry.getValue()));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void sendDetailedAnalytics(final android.service.notification.StatusBarNotification r17, com.animaconnected.firebase.Analytics r18) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.NotificationDetailsAnalyticsKt.sendDetailedAnalytics(android.service.notification.StatusBarNotification, com.animaconnected.firebase.Analytics):void");
    }

    private static final String sendDetailedAnalytics$notificationVisibilityName(int r1) {
        if (r1 != -1) {
            if (r1 != 0) {
                if (r1 != 1) {
                    return "Unknown";
                }
                return "PUBLIC";
            }
            return "PRIVATE";
        }
        return "SECRET";
    }

    private static final String sendDetailedAnalytics$semanticActionName(int r0) {
        switch (r0) {
            case 0:
                return "NONE";
            case 1:
                return "REPLY";
            case 2:
                return "MARK_AS_READ";
            case 3:
                return "MARK_AS_UNREAD";
            case 4:
                return "DELETE";
            case 5:
                return "ARCHIVE";
            case 6:
                return "MUTE";
            case 7:
                return "UNMUTE";
            case 8:
                return "THUMBS_UP";
            case 9:
                return "THUMBS_DOWN";
            case 10:
                return "CALL";
            default:
                return "Unknown";
        }
    }
}
