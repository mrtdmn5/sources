package androidx.compose.runtime;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: SnapshotFlow.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final boolean access$intersects(Set set, Set set2) {
        if (set.size() < set2.size()) {
            Set set3 = set;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                Iterator it = set3.iterator();
                while (it.hasNext()) {
                    if (set2.contains(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
        Set set4 = set2;
        if (!(set4 instanceof Collection) || !set4.isEmpty()) {
            Iterator it2 = set4.iterator();
            while (it2.hasNext()) {
                if (set.contains(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
