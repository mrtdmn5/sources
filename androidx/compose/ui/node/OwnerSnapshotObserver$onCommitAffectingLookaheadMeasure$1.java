package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: OwnerSnapshotObserver.kt */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1();

    public OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(LayoutNode layoutNode) {
        LayoutNode layoutNode2 = layoutNode;
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        if (layoutNode2.isAttached()) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode2, false, 3);
        }
        return Unit.INSTANCE;
    }
}
