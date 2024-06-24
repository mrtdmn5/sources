package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpaqueKey.kt */
/* loaded from: classes.dex */
public final class OpaqueKey {
    public final String key;

    public OpaqueKey(String str) {
        this.key = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof OpaqueKey) && Intrinsics.areEqual(this.key, ((OpaqueKey) obj).key)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("OpaqueKey(key="), this.key, ')');
    }
}
