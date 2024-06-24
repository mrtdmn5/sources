package androidx.compose.material;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Swipeable.kt */
/* loaded from: classes.dex */
public final class SwipeableKt {
    public static final Float access$getOffset(Object obj, Map map) {
        Object obj2;
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual(((Map.Entry) obj2).getValue(), obj)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj2;
        if (entry == null) {
            return null;
        }
        return (Float) entry.getKey();
    }
}
