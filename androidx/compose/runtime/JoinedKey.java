package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: JoinedKey.kt */
/* loaded from: classes.dex */
public final class JoinedKey {
    public final Object left;
    public final Object right;

    public JoinedKey(Integer num, Object obj) {
        this.left = num;
        this.right = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinedKey)) {
            return false;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        if (Intrinsics.areEqual(this.left, joinedKey.left) && Intrinsics.areEqual(this.right, joinedKey.right)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0;
        Object obj = this.left;
        int r2 = 0;
        if (obj instanceof Enum) {
            r0 = ((Enum) obj).ordinal();
        } else if (obj != null) {
            r0 = obj.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        Object obj2 = this.right;
        if (obj2 instanceof Enum) {
            r2 = ((Enum) obj2).ordinal();
        } else if (obj2 != null) {
            r2 = obj2.hashCode();
        }
        return r2 + r02;
    }

    public final String toString() {
        return "JoinedKey(left=" + this.left + ", right=" + this.right + ')';
    }
}
