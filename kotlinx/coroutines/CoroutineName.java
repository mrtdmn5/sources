package kotlinx.coroutines;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineName.kt */
/* loaded from: classes4.dex */
public final class CoroutineName extends AbstractCoroutineContextElement {
    public static final Key Key = new Key();
    public final String name;

    /* compiled from: CoroutineName.kt */
    /* loaded from: classes4.dex */
    public static final class Key implements CoroutineContext.Key<CoroutineName> {
    }

    public CoroutineName(String str) {
        super(Key);
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CoroutineName) && Intrinsics.areEqual(this.name, ((CoroutineName) obj).name)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("CoroutineName("), this.name, ')');
    }
}
