package kotlinx.serialization.internal;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes4.dex */
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    public final KSerializer<Key> keySerializer;
    public final KSerializer<Value> valueSerializer;

    public MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        collectionSize(collection);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor);
        Iterator<Map.Entry<? extends Key, ? extends Value>> collectionIterator = collectionIterator(collection);
        int r1 = 0;
        while (collectionIterator.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = collectionIterator.next();
            Key key = next.getKey();
            Value value = next.getValue();
            int r5 = r1 + 1;
            beginCollection.encodeSerializableElement(getDescriptor(), r1, this.keySerializer, key);
            beginCollection.encodeSerializableElement(getDescriptor(), r5, this.valueSerializer, value);
            r1 = r5 + 1;
        }
        beginCollection.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int r6, Builder builder, boolean z) {
        int r8;
        Object decodeSerializableElement;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object decodeSerializableElement2 = compositeDecoder.decodeSerializableElement(getDescriptor(), r6, this.keySerializer, null);
        if (z) {
            r8 = compositeDecoder.decodeElementIndex(getDescriptor());
            if (!(r8 == r6 + 1)) {
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Value must follow key in a map, index for key: ", r6, ", returned index for value: ", r8).toString());
            }
        } else {
            r8 = r6 + 1;
        }
        boolean containsKey = builder.containsKey(decodeSerializableElement2);
        KSerializer<Value> kSerializer = this.valueSerializer;
        if (containsKey && !(kSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) {
            decodeSerializableElement = compositeDecoder.decodeSerializableElement(getDescriptor(), r8, kSerializer, MapsKt__MapsKt.getValue(decodeSerializableElement2, builder));
        } else {
            decodeSerializableElement = compositeDecoder.decodeSerializableElement(getDescriptor(), r8, kSerializer, null);
        }
        builder.put(decodeSerializableElement2, decodeSerializableElement);
    }
}
