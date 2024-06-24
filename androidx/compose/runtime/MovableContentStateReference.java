package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class MovableContentStateReference {
    public final Anchor anchor;
    public final ControlledComposition composition;
    public final MovableContent<Object> content;
    public List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations;
    public final PersistentCompositionLocalMap locals;
    public final Object parameter;
    public final SlotTable slotTable;

    public MovableContentStateReference(MovableContent<Object> content, Object obj, ControlledComposition composition, SlotTable slotTable, Anchor anchor, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, PersistentCompositionLocalMap locals) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(slotTable, "slotTable");
        Intrinsics.checkNotNullParameter(locals, "locals");
        this.content = content;
        this.parameter = obj;
        this.composition = composition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = list;
        this.locals = locals;
    }
}
