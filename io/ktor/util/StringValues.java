package io.ktor.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StringValues.kt */
/* loaded from: classes3.dex */
public interface StringValues {

    /* compiled from: StringValues.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void forEach(StringValues stringValues, Function2<? super String, ? super List<String>, Unit> function2) {
            Iterator<T> it = stringValues.entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                function2.invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }
    }

    Set<Map.Entry<String, List<String>>> entries();

    void forEach(Function2<? super String, ? super List<String>, Unit> function2);

    String get(String str);

    List<String> getAll(String str);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();
}
