package androidx.compose.ui.node;

import androidx.compose.ui.unit.DensityImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNode.kt */
/* loaded from: classes.dex */
public final class LayoutNodeKt {
    public static final DensityImpl DefaultDensity = new DensityImpl(1.0f, 1.0f);

    public static final Owner requireOwner(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Owner owner = layoutNode.owner;
        if (owner != null) {
            return owner;
        }
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }
}
