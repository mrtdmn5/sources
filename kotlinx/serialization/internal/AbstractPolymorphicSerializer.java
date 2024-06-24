package kotlinx.serialization.internal;

import com.google.android.gms.common.wrappers.InstantApps;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._HostnamesJvmKt;

/* compiled from: AbstractPolymorphicSerializer.kt */
/* loaded from: classes4.dex */
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        beginStructure.decodeSequentially();
        T t = null;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex != 1) {
                        StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                        String str = (String) ref$ObjectRef.element;
                        if (str == null) {
                            str = "unknown class";
                        }
                        sb.append(str);
                        sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        sb.append(decodeElementIndex);
                        throw new SerializationException(sb.toString());
                    }
                    T t2 = ref$ObjectRef.element;
                    if (t2 != 0) {
                        ref$ObjectRef.element = t2;
                        String str2 = (String) t2;
                        DeserializationStrategy<T> findPolymorphicSerializerOrNull = findPolymorphicSerializerOrNull(beginStructure, str2);
                        if (findPolymorphicSerializerOrNull != null) {
                            t = (T) beginStructure.decodeSerializableElement(getDescriptor(), decodeElementIndex, findPolymorphicSerializerOrNull, null);
                        } else {
                            InstantApps.throwSubtypeNotRegistered(str2, getBaseClass());
                            throw null;
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                    }
                } else {
                    ref$ObjectRef.element = (T) beginStructure.decodeStringElement(getDescriptor(), decodeElementIndex);
                }
            } else {
                if (t != null) {
                    beginStructure.endStructure(descriptor);
                    return t;
                }
                throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.element)).toString());
            }
        }
    }

    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.getSerializersModule().getPolymorphic(str, (KClass) getBaseClass());
    }

    public abstract KClass<T> getBaseClass();

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy<? super T> findPolymorphicSerializer = _HostnamesJvmKt.findPolymorphicSerializer(this, encoder, value);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        beginStructure.encodeStringElement(getDescriptor(), 0, findPolymorphicSerializer.getDescriptor().getSerialName());
        beginStructure.encodeSerializableElement(getDescriptor(), 1, findPolymorphicSerializer, value);
        beginStructure.endStructure(descriptor);
    }

    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return encoder.getSerializersModule().getPolymorphic(value, getBaseClass());
    }
}
