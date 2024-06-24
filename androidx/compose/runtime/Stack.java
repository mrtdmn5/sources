package androidx.compose.runtime;

import java.util.ArrayList;

/* compiled from: Stack.kt */
/* loaded from: classes.dex */
public final class Stack<T> {
    public final ArrayList<T> backing = new ArrayList<>();

    public final T pop() {
        return this.backing.remove(r0.size() - 1);
    }

    public final void push(Object obj) {
        this.backing.add(obj);
    }
}
