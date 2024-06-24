package com.amplifyframework.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Immutable {
    private Immutable() {
    }

    public static <K, V> Map<K, V> of(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static <E> Set<E> of(Set<E> set) {
        if (set == null) {
            return null;
        }
        return Collections.unmodifiableSet(new HashSet(set));
    }

    public static <T> List<T> of(List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }
}
