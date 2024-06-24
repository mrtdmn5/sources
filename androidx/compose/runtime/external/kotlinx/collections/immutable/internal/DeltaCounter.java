package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: MutableCounter.kt */
/* loaded from: classes.dex */
public final class DeltaCounter {
    public int count;

    public DeltaCounter() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DeltaCounter) && this.count == ((DeltaCounter) obj).count) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.count);
    }

    public final String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("DeltaCounter(count="), this.count, ')');
    }

    public DeltaCounter(int r1) {
        this.count = 0;
    }
}
