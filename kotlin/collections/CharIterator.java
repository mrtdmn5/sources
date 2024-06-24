package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: classes.dex */
public abstract class CharIterator implements Iterator<Character>, KMappedMarker {
    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(nextChar());
    }

    public abstract char nextChar();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
