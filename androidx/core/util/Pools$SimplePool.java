package androidx.core.util;

/* loaded from: classes.dex */
public class Pools$SimplePool<T> {
    public final Object[] mPool;
    public int mPoolSize;

    public Pools$SimplePool(int r2) {
        if (r2 > 0) {
            this.mPool = new Object[r2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T acquire() {
        int r0 = this.mPoolSize;
        if (r0 <= 0) {
            return null;
        }
        int r2 = r0 - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[r2];
        objArr[r2] = null;
        this.mPoolSize = r0 - 1;
        return t;
    }

    public boolean release(T t) {
        int r2;
        Object[] objArr;
        boolean z;
        int r1 = 0;
        while (true) {
            r2 = this.mPoolSize;
            objArr = this.mPool;
            if (r1 < r2) {
                if (objArr[r1] == t) {
                    z = true;
                    break;
                }
                r1++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            if (r2 >= objArr.length) {
                return false;
            }
            objArr[r2] = t;
            this.mPoolSize = r2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
