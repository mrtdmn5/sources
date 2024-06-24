package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutModifier.kt */
/* loaded from: classes.dex */
public final class LayoutElement extends ModifierNodeElement<LayoutModifierImpl> {
    public final Function3<MeasureScope, Measurable, Constraints, MeasureResult> measure;

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutElement(Function3<? super MeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measure) {
        Intrinsics.checkNotNullParameter(measure, "measure");
        this.measure = measure;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final LayoutModifierImpl create() {
        return new LayoutModifierImpl(this.measure);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LayoutElement) && Intrinsics.areEqual(this.measure, ((LayoutElement) obj).measure)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.measure.hashCode();
    }

    public final String toString() {
        return "LayoutElement(measure=" + this.measure + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(LayoutModifierImpl layoutModifierImpl) {
        LayoutModifierImpl node = layoutModifierImpl;
        Intrinsics.checkNotNullParameter(node, "node");
        Function3<MeasureScope, Measurable, Constraints, MeasureResult> function3 = this.measure;
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        node.measureBlock = function3;
    }
}
