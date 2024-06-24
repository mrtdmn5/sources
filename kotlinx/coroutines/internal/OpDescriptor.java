package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStringsKt;

/* compiled from: Atomic.kt */
/* loaded from: classes4.dex */
public abstract class OpDescriptor {
    public abstract Object perform(Object obj);

    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.getHexAddress(this);
    }
}
