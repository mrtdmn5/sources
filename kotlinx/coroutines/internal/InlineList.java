package kotlinx.coroutines.internal;

import java.util.ArrayList;

/* compiled from: InlineList.kt */
/* loaded from: classes4.dex */
public final class InlineList<E> {
    /* renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m1703plusFjFbRPM(Object obj, E e) {
        if (obj == null) {
            return e;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return arrayList;
    }
}
