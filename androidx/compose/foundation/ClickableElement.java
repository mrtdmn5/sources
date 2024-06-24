package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
final class ClickableElement extends ModifierNodeElement<ClickableNode> {
    public final boolean enabled;
    public final MutableInteractionSource interactionSource;
    public final Function0<Unit> onClick;
    public final String onClickLabel;
    public final Role role;

    public ClickableElement() {
        throw null;
    }

    public ClickableElement(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.interactionSource = interactionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ClickableElement.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.ClickableElement");
        ClickableElement clickableElement = (ClickableElement) obj;
        if (Intrinsics.areEqual(this.interactionSource, clickableElement.interactionSource) && this.enabled == clickableElement.enabled && Intrinsics.areEqual(this.onClickLabel, clickableElement.onClickLabel) && Intrinsics.areEqual(this.role, clickableElement.role) && Intrinsics.areEqual(this.onClick, clickableElement.onClick)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r2;
        int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.enabled, this.interactionSource.hashCode() * 31, 31);
        int r1 = 0;
        String str = this.onClickLabel;
        if (str != null) {
            r2 = str.hashCode();
        } else {
            r2 = 0;
        }
        int r0 = (m + r2) * 31;
        Role role = this.role;
        if (role != null) {
            r1 = Integer.hashCode(role.value);
        }
        return this.onClick.hashCode() + ((r0 + r1) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(ClickableNode clickableNode) {
        ClickableNode node = clickableNode;
        Intrinsics.checkNotNullParameter(node, "node");
        MutableInteractionSource interactionSource = this.interactionSource;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Function0<Unit> onClick = this.onClick;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        if (!Intrinsics.areEqual(node.interactionSource, interactionSource)) {
            node.disposeInteractionSource();
            node.interactionSource = interactionSource;
        }
        boolean z = node.enabled;
        boolean z2 = this.enabled;
        if (z != z2) {
            if (!z2) {
                node.disposeInteractionSource();
            }
            node.enabled = z2;
        }
        node.onClick = onClick;
        ClickableSemanticsNode clickableSemanticsNode = node.clickableSemanticsNode;
        clickableSemanticsNode.getClass();
        clickableSemanticsNode.enabled = z2;
        clickableSemanticsNode.onClickLabel = this.onClickLabel;
        clickableSemanticsNode.role = this.role;
        clickableSemanticsNode.onClick = onClick;
        clickableSemanticsNode.onLongClickLabel = null;
        clickableSemanticsNode.onLongClick = null;
        ClickablePointerInputNode clickablePointerInputNode = node.clickablePointerInputNode;
        clickablePointerInputNode.getClass();
        clickablePointerInputNode.enabled = z2;
        clickablePointerInputNode.onClick = onClick;
        clickablePointerInputNode.interactionSource = interactionSource;
    }
}
