package aws.smithy.kotlin.runtime.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ValuesMap.kt */
/* loaded from: classes.dex */
public interface ValuesMap<T> {

    /* compiled from: ValuesMap.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static <T> void forEach(ValuesMap<T> valuesMap, Function2<? super String, ? super List<? extends T>, Unit> function2) {
            Iterator<T> it = valuesMap.entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                function2.invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }
    }

    Set<Map.Entry<String, List<T>>> entries();

    void forEach(Function2<? super String, ? super List<? extends T>, Unit> function2);

    T get(String str);

    List<T> getAll(String str);

    boolean getCaseInsensitiveName();

    Set<String> names();
}
