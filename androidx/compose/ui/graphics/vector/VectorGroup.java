package androidx.compose.ui.graphics.vector;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ImageVector.kt */
/* loaded from: classes.dex */
public final class VectorGroup extends VectorNode implements Iterable<VectorNode>, KMappedMarker {
    public final List<VectorNode> children;
    public final List<PathNode> clipPathData;
    public final String name;
    public final float pivotX;
    public final float pivotY;
    public final float rotation;
    public final float scaleX;
    public final float scaleY;
    public final float translationX;
    public final float translationY;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorGroup(String name, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> clipPathData, List<? extends VectorNode> children) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
        Intrinsics.checkNotNullParameter(children, "children");
        this.name = name;
        this.rotation = f;
        this.pivotX = f2;
        this.pivotY = f3;
        this.scaleX = f4;
        this.scaleY = f5;
        this.translationX = f6;
        this.translationY = f7;
        this.clipPathData = clipPathData;
        this.children = children;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VectorGroup)) {
            return false;
        }
        VectorGroup vectorGroup = (VectorGroup) obj;
        if (!Intrinsics.areEqual(this.name, vectorGroup.name)) {
            return false;
        }
        if (this.rotation == vectorGroup.rotation) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.pivotX == vectorGroup.pivotX) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.pivotY == vectorGroup.pivotY) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        if (this.scaleX == vectorGroup.scaleX) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        if (this.scaleY == vectorGroup.scaleY) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            return false;
        }
        if (this.translationX == vectorGroup.translationX) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!z6) {
            return false;
        }
        if (this.translationY == vectorGroup.translationY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && Intrinsics.areEqual(this.clipPathData, vectorGroup.clipPathData) && Intrinsics.areEqual(this.children, vectorGroup.children)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.children.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.clipPathData, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.translationY, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.translationX, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.scaleY, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.scaleX, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.pivotY, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.pivotX, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.rotation, this.name.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @Override // java.lang.Iterable
    public final Iterator<VectorNode> iterator() {
        return new VectorGroup$iterator$1(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VectorGroup() {
        /*
            r11 = this;
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 0
            kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.INSTANCE
            int r0 = androidx.compose.ui.graphics.vector.VectorKt.$r8$clinit
            r0 = r11
            r9 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorGroup.<init>():void");
    }
}
