package androidx.compose.foundation.layout;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoxWithConstraints.kt */
/* loaded from: classes.dex */
public final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    public final /* synthetic */ BoxScopeInstance $$delegate_0;
    public final long constraints;
    public final Density density;

    public BoxWithConstraintsScopeImpl(Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.density = density;
        this.constraints = j;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public final Modifier align(Modifier modifier, BiasAlignment biasAlignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return this.$$delegate_0.align(modifier, biasAlignment);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        if (Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m559equalsimpl0(this.constraints, boxWithConstraintsScopeImpl.constraints)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getConstraints-msEJaDk */
    public final long mo66getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxHeight-D9Ej5fM */
    public final float mo67getMaxHeightD9Ej5fM() {
        long j = this.constraints;
        if (Constraints.m560getHasBoundedHeightimpl(j)) {
            return this.density.mo46toDpu2uoSUM(Constraints.m564getMaxHeightimpl(j));
        }
        return Float.POSITIVE_INFINITY;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxWidth-D9Ej5fM */
    public final float mo68getMaxWidthD9Ej5fM() {
        long j = this.constraints;
        if (Constraints.m561getHasBoundedWidthimpl(j)) {
            return this.density.mo46toDpu2uoSUM(Constraints.m565getMaxWidthimpl(j));
        }
        return Float.POSITIVE_INFINITY;
    }

    public final int hashCode() {
        return Long.hashCode(this.constraints) + (this.density.hashCode() * 31);
    }

    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m568toStringimpl(this.constraints)) + ')';
    }
}
