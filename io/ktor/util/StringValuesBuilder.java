package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: StringValues.kt */
/* loaded from: classes3.dex */
public interface StringValuesBuilder {
    void append(String str, String str2);

    void appendAll(String str, Iterable<String> iterable);

    void clear();

    Set<Map.Entry<String, List<String>>> entries();

    List<String> getAll(String str);

    boolean isEmpty();

    Set<String> names();
}
