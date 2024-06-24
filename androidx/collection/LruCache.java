package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class LruCache<K, V> {
    public int hitCount;
    public final LinkedHashMap<K, V> map;
    public final int maxSize;
    public int missCount;
    public int size;

    public LruCache(int r4) {
        if (r4 > 0) {
            this.maxSize = r4;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public V create(K k) {
        return null;
    }

    public final V get(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.map.get(k);
                if (v != null) {
                    this.hitCount++;
                    return v;
                }
                this.missCount++;
                V create = create(k);
                if (create == null) {
                    return null;
                }
                synchronized (this) {
                    put = this.map.put(k, create);
                    if (put != null) {
                        this.map.put(k, put);
                    } else {
                        this.size++;
                    }
                }
                if (put != null) {
                    return put;
                }
                trimToSize(this.maxSize);
                return create;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V put(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                this.size++;
                put = this.map.put(k, v);
                if (put != null) {
                    this.size--;
                }
            }
            trimToSize(this.maxSize);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized String toString() {
        int r0;
        int r02 = this.hitCount;
        int r1 = this.missCount + r02;
        if (r1 != 0) {
            r0 = (r02 * 100) / r1;
        } else {
            r0 = 0;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(r0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void trimToSize(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.size     // Catch: java.lang.Throwable -> L63
            if (r0 < 0) goto L44
            java.util.LinkedHashMap<K, V> r0 = r2.map     // Catch: java.lang.Throwable -> L63
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L11
            int r0 = r2.size     // Catch: java.lang.Throwable -> L63
            if (r0 != 0) goto L44
        L11:
            int r0 = r2.size     // Catch: java.lang.Throwable -> L63
            if (r0 <= r3) goto L42
            java.util.LinkedHashMap<K, V> r0 = r2.map     // Catch: java.lang.Throwable -> L63
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L1e
            goto L42
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r2.map     // Catch: java.lang.Throwable -> L63
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L63
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L63
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L63
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L63
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L63
            r0.getValue()     // Catch: java.lang.Throwable -> L63
            java.util.LinkedHashMap<K, V> r0 = r2.map     // Catch: java.lang.Throwable -> L63
            r0.remove(r1)     // Catch: java.lang.Throwable -> L63
            int r0 = r2.size     // Catch: java.lang.Throwable -> L63
            int r0 = r0 + (-1)
            r2.size = r0     // Catch: java.lang.Throwable -> L63
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            goto L0
        L42:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            return
        L44:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r0.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.Class r1 = r2.getClass()     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L63
            r0.append(r1)     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L63
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L63
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L63
            throw r3     // Catch: java.lang.Throwable -> L63
        L63:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
