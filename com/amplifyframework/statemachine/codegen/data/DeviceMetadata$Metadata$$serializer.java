package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DeviceMetadata.kt */
/* loaded from: classes.dex */
public final class DeviceMetadata$Metadata$$serializer implements GeneratedSerializer<DeviceMetadata.Metadata> {
    public static final DeviceMetadata$Metadata$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        DeviceMetadata$Metadata$$serializer deviceMetadata$Metadata$$serializer = new DeviceMetadata$Metadata$$serializer();
        INSTANCE = deviceMetadata$Metadata$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("metadata", deviceMetadata$Metadata$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("deviceKey", false);
        pluginGeneratedSerialDescriptor.addElement("deviceGroupKey", false);
        pluginGeneratedSerialDescriptor.addElement("deviceSecret", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceMetadata$Metadata$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DeviceMetadata.Metadata deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        Object obj = null;
        boolean z = true;
        int r5 = 0;
        String str = null;
        String str2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r5 |= 1;
            } else if (decodeElementIndex == 1) {
                str2 = beginStructure.decodeStringElement(descriptor2, 1);
                r5 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                obj = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj);
                r5 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new DeviceMetadata.Metadata(r5, str, str2, (String) obj, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DeviceMetadata.Metadata value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceMetadata.Metadata.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
