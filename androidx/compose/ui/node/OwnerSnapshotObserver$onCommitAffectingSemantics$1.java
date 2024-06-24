package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: OwnerSnapshotObserver.kt */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver$onCommitAffectingSemantics$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final OwnerSnapshotObserver$onCommitAffectingSemantics$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingSemantics$1();

    public OwnerSnapshotObserver$onCommitAffectingSemantics$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(LayoutNode layoutNode) {
        LayoutNode layoutNode2 = layoutNode;
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        if (layoutNode2.isAttached()) {
            layoutNode2._collapsedSemantics = null;
            LayoutNodeKt.requireOwner(layoutNode2).onSemanticsChange();
        }
        return Unit.INSTANCE;
    }
}
