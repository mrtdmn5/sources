package androidx.compose.ui.node;

import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocalConsumerModifierNode.kt */
/* loaded from: classes.dex */
public final class CompositionLocalConsumerModifierNodeKt {
    public static final Object currentValueOf(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, ProvidableCompositionLocal local) {
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(local, "local");
        if (compositionLocalConsumerModifierNode.getNode().isAttached) {
            return DelegatableNodeKt.requireLayoutNode(compositionLocalConsumerModifierNode).compositionLocalMap.get(local);
        }
        throw new IllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.".toString());
    }
}
