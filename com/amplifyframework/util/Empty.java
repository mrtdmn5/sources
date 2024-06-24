package com.amplifyframework.util;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class Empty {
    private Empty() {
    }

    public static boolean check(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean check(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean check(String str) {
        return str == null || str.length() == 0;
    }
}
