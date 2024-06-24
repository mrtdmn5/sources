package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObserverModifierNode.kt */
/* loaded from: classes.dex */
public final class ObserverModifierNodeKt {
    public static final <T extends Modifier.Node & ObserverModifierNode> void observeReads(T t, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        ObserverNodeOwnerScope observerNodeOwnerScope = t.ownerScope;
        if (observerNodeOwnerScope == null) {
            observerNodeOwnerScope = new ObserverNodeOwnerScope(t);
            t.ownerScope = observerNodeOwnerScope;
        }
        DelegatableNodeKt.requireOwner(t).getSnapshotObserver().observeReads$ui_release(observerNodeOwnerScope, ObserverNodeOwnerScope.OnObserveReadsChanged, function0);
    }
}
