package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Shapes.kt */
/* loaded from: classes.dex */
public final class Shapes {
    public final CornerBasedShape large;
    public final CornerBasedShape medium;
    public final CornerBasedShape small;

    public Shapes() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        if (Intrinsics.areEqual(this.small, shapes.small) && Intrinsics.areEqual(this.medium, shapes.medium) && Intrinsics.areEqual(this.large, shapes.large)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.large.hashCode() + ((this.medium.hashCode() + (this.small.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ')';
    }

    public Shapes(CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large) {
        Intrinsics.checkNotNullParameter(small, "small");
        Intrinsics.checkNotNullParameter(medium, "medium");
        Intrinsics.checkNotNullParameter(large, "large");
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public Shapes(int r3) {
        this(RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(4), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(4), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(0));
    }
}
