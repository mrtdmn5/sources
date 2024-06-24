package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
public final class Pools$SimplePool<T> {
    public final Object[] mPool = new Object[256];
    public int mPoolSize;

    public final T acquire() {
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

    public final void release(ArrayRow arrayRow) {
        int r0 = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (r0 < objArr.length) {
            objArr[r0] = arrayRow;
            this.mPoolSize = r0 + 1;
        }
    }
}
