package androidx.compose.foundation.layout;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class RowColumnParentData {
    public CrossAxisAlignment crossAxisAlignment;
    public boolean fill;
    public float weight;

    public RowColumnParentData() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        if (Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2 = Float.hashCode(this.weight) * 31;
        boolean z = this.fill;
        int r1 = z;
        if (z != 0) {
            r1 = 1;
        }
        int r0 = (hashCode2 + r1) * 31;
        CrossAxisAlignment crossAxisAlignment = this.crossAxisAlignment;
        if (crossAxisAlignment == null) {
            hashCode = 0;
        } else {
            hashCode = crossAxisAlignment.hashCode();
        }
        return r0 + hashCode;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ')';
    }

    public RowColumnParentData(int r1) {
        this.weight = 0.0f;
        this.fill = true;
        this.crossAxisAlignment = null;
    }
}
