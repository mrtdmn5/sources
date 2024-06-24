package kotlinx.serialization.internal;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {
    public final KSerializer<K> keySerializer;
    public final KSerializer<V> valueSerializer;

    public KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final R deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        beginStructure.decodeSequentially();
        Object obj = TuplesKt.NULL;
        Object obj2 = obj;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        obj2 = beginStructure.decodeSerializableElement(getDescriptor(), 1, this.valueSerializer, null);
                    } else {
                        throw new SerializationException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Invalid index: ", decodeElementIndex));
                    }
                } else {
                    obj = beginStructure.decodeSerializableElement(getDescriptor(), 0, this.keySerializer, null);
                }
            } else {
                beginStructure.endStructure(getDescriptor());
                Object obj3 = TuplesKt.NULL;
                if (obj != obj3) {
                    if (obj2 != obj3) {
                        return (R) toResult(obj, obj2);
                    }
                    throw new SerializationException("Element 'value' is missing");
                }
                throw new SerializationException("Element 'key' is missing");
            }
        }
    }

    public abstract K getKey(R r);

    public abstract V getValue(R r);

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, R r) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder beginStructure = encoder.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, this.keySerializer, getKey(r));
        beginStructure.encodeSerializableElement(getDescriptor(), 1, this.valueSerializer, getValue(r));
        beginStructure.endStructure(getDescriptor());
    }

    public abstract R toResult(K k, V v);
}
