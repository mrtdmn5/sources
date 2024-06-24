package androidx.compose.ui.text.caches;

import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCache<K, V> {
    public int hitCount;
    public int missCount;
    public int size;
    public final ExecutorsKt monitor = new ExecutorsKt();
    public final HashMap<K, V> map = new HashMap<>(0, 0.75f);
    public final LinkedHashSet<K> keySet = new LinkedHashSet<>();

    public final V get(K k) {
        synchronized (this.monitor) {
            V v = this.map.get(k);
            if (v != null) {
                this.keySet.remove(k);
                this.keySet.add(k);
                this.hitCount++;
                return v;
            }
            this.missCount++;
            return null;
        }
    }

    public final V put(K k, V v) {
        V put;
        Object obj;
        V v2;
        if (k != null) {
            if (v != null) {
                synchronized (this.monitor) {
                    this.size = size() + 1;
                    put = this.map.put(k, v);
                    if (put != null) {
                        this.size = size() - 1;
                    }
                    if (this.keySet.contains(k)) {
                        this.keySet.remove(k);
                    }
                    this.keySet.add(k);
                }
                while (true) {
                    synchronized (this.monitor) {
                        if (size() < 0 || ((this.map.isEmpty() && size() != 0) || this.map.isEmpty() != this.keySet.isEmpty())) {
                            break;
                        }
                        if (size() > 16 && !this.map.isEmpty()) {
                            obj = CollectionsKt___CollectionsKt.first(this.keySet);
                            v2 = this.map.get(obj);
                            if (v2 != null) {
                                TypeIntrinsics.asMutableMap(this.map).remove(obj);
                                TypeIntrinsics.asMutableCollection(this.keySet).remove(obj);
                                int size = size();
                                Intrinsics.checkNotNull(obj);
                                this.size = size - 1;
                            } else {
                                throw new IllegalStateException("inconsistent state");
                            }
                        } else {
                            obj = null;
                            v2 = null;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (obj == null && v2 == null) {
                        return put;
                    }
                    Intrinsics.checkNotNull(obj);
                    Intrinsics.checkNotNull(v2);
                }
                throw new IllegalStateException("map/keySet size inconsistency");
            }
            throw null;
        }
        throw null;
    }

    public final V remove(K k) {
        V remove;
        k.getClass();
        synchronized (this.monitor) {
            remove = this.map.remove(k);
            this.keySet.remove(k);
            if (remove != null) {
                this.size = size() - 1;
            }
            Unit unit = Unit.INSTANCE;
        }
        return remove;
    }

    public final int size() {
        int r1;
        synchronized (this.monitor) {
            r1 = this.size;
        }
        return r1;
    }

    public final String toString() {
        int r2;
        String str;
        synchronized (this.monitor) {
            int r22 = this.hitCount;
            int r3 = this.missCount + r22;
            if (r3 != 0) {
                r2 = (r22 * 100) / r3;
            } else {
                r2 = 0;
            }
            str = "LruCache[maxSize=16,hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + r2 + "%]";
        }
        return str;
    }
}
