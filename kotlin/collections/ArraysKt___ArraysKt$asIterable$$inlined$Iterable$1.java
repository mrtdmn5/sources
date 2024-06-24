package kotlin.collections;

import io.ktor.http.ContentTypesKt;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Iterables.kt */
/* loaded from: classes.dex */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1 implements Iterable<Object>, KMappedMarker {
    public final /* synthetic */ Object[] $this_asIterable$inlined;

    public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(Object[] objArr) {
        this.$this_asIterable$inlined = objArr;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return ContentTypesKt.iterator(this.$this_asIterable$inlined);
    }
}
