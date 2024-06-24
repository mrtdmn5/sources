package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes4.dex */
public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {
    public final KSerializer<Element> elementSerializer;

    public CollectionLikeSerializer(KSerializer kSerializer) {
        this.elementSerializer = kSerializer;
    }

    public abstract void insert(Builder builder, int r2, Element element);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder compositeDecoder, int r4, Builder builder, boolean z) {
        insert(builder, r4, compositeDecoder.decodeSerializableElement(getDescriptor(), r4, this.elementSerializer, null));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(collection);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor);
        Iterator<Element> collectionIterator = collectionIterator(collection);
        for (int r2 = 0; r2 < collectionSize; r2++) {
            beginCollection.encodeSerializableElement(getDescriptor(), r2, this.elementSerializer, collectionIterator.next());
        }
        beginCollection.endStructure(descriptor);
    }
}
