package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecomposeScopeImpl.kt */
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements RecomposeScope {
    public Anchor anchor;
    public Function2<? super Composer, ? super Integer, Unit> block;
    public int currentToken;
    public int flags;
    public RecomposeScopeOwner owner;
    public IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    public IdentityArrayIntMap trackedInstances;

    /* compiled from: RecomposeScopeImpl.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static void adoptAnchoredScopes$runtime_release(SlotWriter slots, List list, RecomposeScopeOwner recomposeScopeOwner) {
            RecomposeScopeImpl recomposeScopeImpl;
            Intrinsics.checkNotNullParameter(slots, "slots");
            if (!list.isEmpty()) {
                int size = list.size();
                for (int r2 = 0; r2 < size; r2++) {
                    Anchor anchor = (Anchor) list.get(r2);
                    Intrinsics.checkNotNullParameter(anchor, "anchor");
                    Object slot = slots.slot(slots.anchorIndex(anchor), 0);
                    if (slot instanceof RecomposeScopeImpl) {
                        recomposeScopeImpl = (RecomposeScopeImpl) slot;
                    } else {
                        recomposeScopeImpl = null;
                    }
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.owner = recomposeScopeOwner;
                    }
                }
            }
        }
    }

    public RecomposeScopeImpl(CompositionImpl compositionImpl) {
        this.owner = compositionImpl;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public final void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    public final InvalidationResult invalidateForResult(Object obj) {
        InvalidationResult invalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner == null || (invalidate = recomposeScopeOwner.invalidate(this, obj)) == null) {
            return InvalidationResult.IGNORED;
        }
        return invalidate;
    }
}
