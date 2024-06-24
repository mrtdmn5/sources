package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes.dex */
final class PaddingValuesElement extends ModifierNodeElement<PaddingValuesModifier> {
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final PaddingValues paddingValues;

    public PaddingValuesElement(PaddingValues paddingValues, PaddingKt$padding$4 paddingKt$padding$4) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
        this.inspectorInfo = paddingKt$padding$4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final PaddingValuesModifier create() {
        return new PaddingValuesModifier(this.paddingValues);
    }

    public final boolean equals(Object obj) {
        PaddingValuesElement paddingValuesElement;
        if (obj instanceof PaddingValuesElement) {
            paddingValuesElement = (PaddingValuesElement) obj;
        } else {
            paddingValuesElement = null;
        }
        if (paddingValuesElement == null) {
            return false;
        }
        return Intrinsics.areEqual(this.paddingValues, paddingValuesElement.paddingValues);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.paddingValues.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(PaddingValuesModifier paddingValuesModifier) {
        PaddingValuesModifier node = paddingValuesModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        PaddingValues paddingValues = this.paddingValues;
        Intrinsics.checkNotNullParameter(paddingValues, "<set-?>");
        node.paddingValues = paddingValues;
    }
}
