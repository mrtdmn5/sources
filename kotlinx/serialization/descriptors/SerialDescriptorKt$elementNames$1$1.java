package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SerialDescriptor.kt */
/* loaded from: classes4.dex */
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {
    public final /* synthetic */ SerialDescriptor $this_elementNames;
    public int elementsLeft;

    public SerialDescriptorKt$elementNames$1$1(SerialDescriptor serialDescriptor) {
        this.$this_elementNames = serialDescriptor;
        this.elementsLeft = serialDescriptor.getElementsCount();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.elementsLeft > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final String next() {
        SerialDescriptor serialDescriptor = this.$this_elementNames;
        int elementsCount = serialDescriptor.getElementsCount();
        int r2 = this.elementsLeft;
        this.elementsLeft = r2 - 1;
        return serialDescriptor.getElementName(elementsCount - r2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
