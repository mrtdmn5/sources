package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: SemanticsNode.kt */
/* loaded from: classes.dex */
public final class SemanticsNode$isUnmergedLeafNode$1 extends Lambda implements Function1<LayoutNode, Boolean> {
    public static final SemanticsNode$isUnmergedLeafNode$1 INSTANCE = new SemanticsNode$isUnmergedLeafNode$1();

    public SemanticsNode$isUnmergedLeafNode$1() {
        super(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:            if (r2.isMergingSemanticsOfDescendants == true) goto L8;     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
        /*
            r1 = this;
            androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getCollapsedSemantics$ui_release()
            if (r2 == 0) goto L13
            boolean r2 = r2.isMergingSemanticsOfDescendants
            r0 = 1
            if (r2 != r0) goto L13
            goto L14
        L13:
            r0 = 0
        L14:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNode$isUnmergedLeafNode$1.invoke(java.lang.Object):java.lang.Object");
    }
}
