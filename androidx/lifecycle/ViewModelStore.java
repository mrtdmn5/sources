package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: ViewModelStore.kt */
/* loaded from: classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        LinkedHashMap linkedHashMap = this.map;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((ViewModel) it.next()).clear();
        }
        linkedHashMap.clear();
    }
}
