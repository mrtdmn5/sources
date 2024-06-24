package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: classes.dex */
public abstract class ByteIterator implements Iterator<Byte>, KMappedMarker {
    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    public abstract byte nextByte();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
