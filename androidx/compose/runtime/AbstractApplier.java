package androidx.compose.runtime;

import java.util.ArrayList;

/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public abstract class AbstractApplier<T> implements Applier<T> {
    public T current;
    public final T root;
    public final ArrayList stack = new ArrayList();

    public AbstractApplier(T t) {
        this.root = t;
        this.current = t;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        this.current = this.root;
        onClear();
    }

    @Override // androidx.compose.runtime.Applier
    public final void down(T t) {
        this.stack.add(this.current);
        this.current = t;
    }

    @Override // androidx.compose.runtime.Applier
    public final T getCurrent() {
        return this.current;
    }

    public abstract void onClear();

    @Override // androidx.compose.runtime.Applier
    public final void up() {
        ArrayList arrayList = this.stack;
        if (!arrayList.isEmpty()) {
            this.current = (T) arrayList.remove(arrayList.size() - 1);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
