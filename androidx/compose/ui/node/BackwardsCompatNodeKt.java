package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatNodeKt {
    public static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 DetachedModifierLocalReadScope = new BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1();
    public static final BackwardsCompatNodeKt$onDrawCacheReadsChanged$1 onDrawCacheReadsChanged = BackwardsCompatNodeKt$onDrawCacheReadsChanged$1.INSTANCE;
    public static final BackwardsCompatNodeKt$updateModifierLocalConsumer$1 updateModifierLocalConsumer = BackwardsCompatNodeKt$updateModifierLocalConsumer$1.INSTANCE;

    public static final boolean access$isChainUpdate(BackwardsCompatNode backwardsCompatNode) {
        TailModifierNode tailModifierNode = DelegatableNodeKt.requireLayoutNode(backwardsCompatNode).nodes.tail;
        Intrinsics.checkNotNull(tailModifierNode, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return tailModifierNode.attachHasBeenRun;
    }
}
