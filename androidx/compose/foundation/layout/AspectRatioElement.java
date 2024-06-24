package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AspectRatio.kt */
/* loaded from: classes.dex */
public final class AspectRatioElement extends ModifierNodeElement<AspectRatioNode> {
    public final float aspectRatio;
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final boolean matchHeightConstraintsFirst;

    public AspectRatioElement(float f, boolean z) {
        boolean z2;
        InspectableValueKt$NoInspectorInfo$1 inspectorInfo = InspectableValueKt.NoInspectorInfo;
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        this.inspectorInfo = inspectorInfo;
        if (f > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
        } else {
            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("aspectRatio ", f, " must be > 0").toString());
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final AspectRatioNode create() {
        return new AspectRatioNode(this.aspectRatio, this.matchHeightConstraintsFirst);
    }

    public final boolean equals(Object obj) {
        AspectRatioElement aspectRatioElement;
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatioElement) {
            aspectRatioElement = (AspectRatioElement) obj;
        } else {
            aspectRatioElement = null;
        }
        if (aspectRatioElement == null) {
            return false;
        }
        if (this.aspectRatio == aspectRatioElement.aspectRatio) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.matchHeightConstraintsFirst == ((AspectRatioElement) obj).matchHeightConstraintsFirst) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.matchHeightConstraintsFirst) + (Float.hashCode(this.aspectRatio) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(AspectRatioNode aspectRatioNode) {
        AspectRatioNode node = aspectRatioNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.aspectRatio = this.aspectRatio;
        node.matchHeightConstraintsFirst = this.matchHeightConstraintsFirst;
    }
}
