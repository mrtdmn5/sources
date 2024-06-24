package aws.smithy.kotlin.runtime.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValuesMap.kt */
/* loaded from: classes.dex */
public class ValuesMapBuilder<T> {
    public final Map<String, List<T>> values = new CaseInsensitiveMap();

    public final void appendAll(ValuesMap<T> valuesMap) {
        Intrinsics.checkNotNullParameter(valuesMap, "valuesMap");
        valuesMap.forEach(new Function2<String, List<? extends T>, Unit>(this) { // from class: aws.smithy.kotlin.runtime.util.ValuesMapBuilder$appendAll$1
            public final /* synthetic */ ValuesMapBuilder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(String str, Object obj) {
                String name = str;
                List values = (List) obj;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                this.this$0.appendAll(name, values);
                return Unit.INSTANCE;
            }
        });
    }

    public final List ensureListForKey(int r3, String str) {
        Map<String, List<T>> map = this.values;
        List<T> list = map.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList(r3);
            map.put(str, arrayList);
            return arrayList;
        }
        return list;
    }

    public final void set(String str, String str2) {
        List ensureListForKey = ensureListForKey(1, str2);
        ensureListForKey.clear();
        ensureListForKey.add(str);
    }

    public final void setMissing(String str) {
        if (!this.values.containsKey("Content-Type")) {
            set(str, "Content-Type");
        }
    }

    public final void appendAll(String name, Iterable<? extends T> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection collection = values instanceof Collection ? (Collection) values : null;
        List ensureListForKey = ensureListForKey(collection != null ? collection.size() : 2, name);
        Iterator<? extends T> it = values.iterator();
        while (it.hasNext()) {
            ensureListForKey.add(it.next());
        }
    }
}
