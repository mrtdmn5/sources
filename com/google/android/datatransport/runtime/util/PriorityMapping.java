package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class PriorityMapping {
    public static final HashMap<Priority, Integer> PRIORITY_INT_MAP;
    public static final SparseArray<Priority> PRIORITY_MAP = new SparseArray<>();

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        PRIORITY_INT_MAP = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        hashMap.put(Priority.VERY_LOW, 1);
        hashMap.put(Priority.HIGHEST, 2);
        for (Priority priority : hashMap.keySet()) {
            PRIORITY_MAP.append(PRIORITY_INT_MAP.get(priority).intValue(), priority);
        }
    }

    public static int toInt(Priority priority) {
        Integer num = PRIORITY_INT_MAP.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority valueOf(int r2) {
        Priority priority = PRIORITY_MAP.get(r2);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unknown Priority for value ", r2));
    }
}
