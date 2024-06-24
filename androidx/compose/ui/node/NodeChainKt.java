package androidx.compose.ui.node;

/* compiled from: NodeChain.kt */
/* loaded from: classes.dex */
public final class NodeChainKt {
    public static final NodeChainKt$SentinelHead$1 SentinelHead;

    static {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1 = new NodeChainKt$SentinelHead$1();
        nodeChainKt$SentinelHead$1.aggregateChildKindSet = -1;
        SentinelHead = nodeChainKt$SentinelHead$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            if (r4 != false) goto L42;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int actionForModifiers(androidx.compose.ui.Modifier.Element r4, androidx.compose.ui.Modifier.Element r5) {
        /*
            java.lang.String r0 = "prev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r0 == 0) goto L12
            r4 = 2
            goto L43
        L12:
            java.lang.Class r0 = r4.getClass()
            java.lang.Class r1 = r5.getClass()
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L20
            r0 = r2
            goto L21
        L20:
            r0 = r3
        L21:
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof androidx.compose.ui.node.ForceUpdateElement
            if (r0 == 0) goto L40
            androidx.compose.ui.node.ForceUpdateElement r4 = (androidx.compose.ui.node.ForceUpdateElement) r4
            java.lang.String r0 = "a"
            androidx.compose.ui.node.ModifierNodeElement<?> r4 = r4.original
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Class r4 = r4.getClass()
            java.lang.Class r5 = r5.getClass()
            if (r4 != r5) goto L3c
            r4 = r2
            goto L3d
        L3c:
            r4 = r3
        L3d:
            if (r4 == 0) goto L40
            goto L42
        L40:
            r4 = r3
            goto L43
        L42:
            r4 = r2
        L43:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChainKt.actionForModifiers(androidx.compose.ui.Modifier$Element, androidx.compose.ui.Modifier$Element):int");
    }
}
