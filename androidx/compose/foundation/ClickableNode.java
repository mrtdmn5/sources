package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public final class ClickableNode extends AbstractClickableNode {
    public final ClickablePointerInputNode clickablePointerInputNode;
    public final ClickableSemanticsNode clickableSemanticsNode;

    public ClickableNode() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableNode(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        super(interactionSource, z, onClick);
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ClickableSemanticsNode clickableSemanticsNode = new ClickableSemanticsNode(z, str, role, onClick);
        delegate(clickableSemanticsNode);
        this.clickableSemanticsNode = clickableSemanticsNode;
        ClickablePointerInputNode clickablePointerInputNode = new ClickablePointerInputNode(z, interactionSource, onClick, this.interactionData);
        delegate(clickablePointerInputNode);
        this.clickablePointerInputNode = clickablePointerInputNode;
    }
}
