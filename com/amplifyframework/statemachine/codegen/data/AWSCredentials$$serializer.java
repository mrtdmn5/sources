package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AmplifyCredential.kt */
/* loaded from: classes.dex */
public final class AWSCredentials$$serializer implements GeneratedSerializer<AWSCredentials> {
    public static final AWSCredentials$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AWSCredentials$$serializer aWSCredentials$$serializer = new AWSCredentials$$serializer();
        INSTANCE = aWSCredentials$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amplifyframework.statemachine.codegen.data.AWSCredentials", aWSCredentials$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("accessKeyId", false);
        pluginGeneratedSerialDescriptor.addElement("secretAccessKey", false);
        pluginGeneratedSerialDescriptor.addElement("sessionToken", false);
        pluginGeneratedSerialDescriptor.addElement("expiration", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AWSCredentials$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AWSCredentials deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        Object obj = null;
        boolean z = true;
        int r10 = 0;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, obj);
                r10 |= 1;
            } else if (decodeElementIndex == 1) {
                obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj4);
                r10 |= 2;
            } else if (decodeElementIndex == 2) {
                obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj2);
                r10 |= 4;
            } else {
                if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, LongSerializer.INSTANCE, obj3);
                r10 |= 8;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AWSCredentials(r10, (String) obj, (String) obj4, (String) obj2, (Long) obj3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AWSCredentials value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AWSCredentials.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
