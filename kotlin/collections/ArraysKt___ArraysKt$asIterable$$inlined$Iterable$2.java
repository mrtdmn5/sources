package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Iterables.kt */
/* loaded from: classes.dex */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2 implements Iterable<Byte>, KMappedMarker {
    public final /* synthetic */ byte[] $this_asIterable$inlined;

    public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2(byte[] bArr) {
        this.$this_asIterable$inlined = bArr;
    }

    @Override // java.lang.Iterable
    public final Iterator<Byte> iterator() {
        byte[] array = this.$this_asIterable$inlined;
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayByteIterator(array);
    }
}
