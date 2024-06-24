package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MutableVectorWithMutationTracking.kt */
/* loaded from: classes.dex */
public final class MutableVectorWithMutationTracking<T> {
    public final Function0<Unit> onVectorMutated;
    public final MutableVector<T> vector;

    public MutableVectorWithMutationTracking(MutableVector mutableVector, LayoutNode$_foldedChildren$1 layoutNode$_foldedChildren$1) {
        this.vector = mutableVector;
        this.onVectorMutated = layoutNode$_foldedChildren$1;
    }
}
