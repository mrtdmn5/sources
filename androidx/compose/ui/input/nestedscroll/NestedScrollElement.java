package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NestedScrollModifier.kt */
/* loaded from: classes.dex */
public final class NestedScrollElement extends ModifierNodeElement<NestedScrollNode> {
    public final NestedScrollConnection connection;
    public final NestedScrollDispatcher dispatcher;

    public NestedScrollElement(NestedScrollConnection connection, NestedScrollDispatcher nestedScrollDispatcher) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
        this.dispatcher = nestedScrollDispatcher;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final NestedScrollNode create() {
        return new NestedScrollNode(this.connection, this.dispatcher);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof NestedScrollElement)) {
            return false;
        }
        NestedScrollElement nestedScrollElement = (NestedScrollElement) obj;
        if (!Intrinsics.areEqual(nestedScrollElement.connection, this.connection) || !Intrinsics.areEqual(nestedScrollElement.dispatcher, this.dispatcher)) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r1;
        int hashCode = this.connection.hashCode() * 31;
        NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
        if (nestedScrollDispatcher != null) {
            r1 = nestedScrollDispatcher.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(NestedScrollNode nestedScrollNode) {
        NestedScrollNode node = nestedScrollNode;
        Intrinsics.checkNotNullParameter(node, "node");
        NestedScrollConnection connection = this.connection;
        Intrinsics.checkNotNullParameter(connection, "connection");
        node.connection = connection;
        NestedScrollDispatcher nestedScrollDispatcher = node.resolvedDispatcher;
        if (nestedScrollDispatcher.modifierLocalNode == node) {
            nestedScrollDispatcher.modifierLocalNode = null;
        }
        NestedScrollDispatcher nestedScrollDispatcher2 = this.dispatcher;
        if (nestedScrollDispatcher2 == null) {
            node.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(nestedScrollDispatcher2, nestedScrollDispatcher)) {
            node.resolvedDispatcher = nestedScrollDispatcher2;
        }
        if (node.isAttached) {
            NestedScrollDispatcher nestedScrollDispatcher3 = node.resolvedDispatcher;
            nestedScrollDispatcher3.modifierLocalNode = node;
            nestedScrollDispatcher3.calculateNestedScrollScope = new NestedScrollNode$updateDispatcherFields$1(node);
            node.resolvedDispatcher.scope = node.getCoroutineScope();
        }
    }
}
