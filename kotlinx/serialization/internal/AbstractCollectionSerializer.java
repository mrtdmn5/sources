package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes4.dex */
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    public abstract Builder builder();

    public abstract int builderSize(Builder builder);

    public abstract Iterator<Element> collectionIterator(Collection collection);

    public abstract int collectionSize(Collection collection);

    @Override // kotlinx.serialization.DeserializationStrategy
    public Collection deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (Collection) merge(decoder);
    }

    public final Object merge(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Builder builder = builder();
        int builderSize = builderSize(builder);
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        beginStructure.decodeSequentially();
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
            if (decodeElementIndex != -1) {
                readElement(beginStructure, decodeElementIndex + builderSize, builder, true);
            } else {
                beginStructure.endStructure(getDescriptor());
                return toResult(builder);
            }
        }
    }

    public abstract void readElement(CompositeDecoder compositeDecoder, int r2, Builder builder, boolean z);

    public abstract Builder toBuilder(Collection collection);

    public abstract Collection toResult(Builder builder);
}
