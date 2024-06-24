package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes4.dex */
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {
    public final PrimitiveArrayDescriptor descriptor;

    public PrimitiveArraySerializer(KSerializer<Element> kSerializer) {
        super(kSerializer);
        this.descriptor = new PrimitiveArrayDescriptor(kSerializer.getDescriptor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object builder() {
        return (PrimitiveArrayBuilder) toBuilder(empty());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int builderSize(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.getPosition$kotlinx_serialization_core();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator<Element> collectionIterator(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Array deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (Array) merge(decoder);
    }

    public abstract Array empty();

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public final void insert(Object obj, int r2, Object obj2) {
        Intrinsics.checkNotNullParameter((PrimitiveArrayBuilder) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Array array) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(array);
        PrimitiveArrayDescriptor primitiveArrayDescriptor = this.descriptor;
        CompositeEncoder beginCollection = encoder.beginCollection(primitiveArrayDescriptor);
        writeContent(beginCollection, array, collectionSize);
        beginCollection.endStructure(primitiveArrayDescriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toResult(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.build$kotlinx_serialization_core();
    }

    public abstract void writeContent(CompositeEncoder compositeEncoder, Array array, int r3);
}
