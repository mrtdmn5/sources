package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ImageVector.kt */
/* loaded from: classes.dex */
public final class VectorGroup$iterator$1 implements Iterator<VectorNode>, KMappedMarker {
    public final Iterator<VectorNode> it;

    public VectorGroup$iterator$1(VectorGroup vectorGroup) {
        this.it = vectorGroup.children.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.it.hasNext();
    }

    @Override // java.util.Iterator
    public final VectorNode next() {
        return this.it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
