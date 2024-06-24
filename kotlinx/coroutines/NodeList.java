package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListHead;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return this;
    }
}
