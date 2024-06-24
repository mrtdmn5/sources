package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {
    public final Pools$SimplePool mListPool = new Pools$SimplePool(10);
    public final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    public final ArrayList<T> mSortResult = new ArrayList<>();
    public final HashSet<T> mSortTmpMarked = new HashSet<>();

    public final void dfs(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> orDefault = this.mGraph.getOrDefault(t, null);
            if (orDefault != null) {
                int size = orDefault.size();
                for (int r2 = 0; r2 < size; r2++) {
                    dfs(orDefault.get(r2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}
