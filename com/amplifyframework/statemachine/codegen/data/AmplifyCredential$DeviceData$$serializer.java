package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: AmplifyCredential.kt */
/* loaded from: classes.dex */
public final class AmplifyCredential$DeviceData$$serializer implements GeneratedSerializer<AmplifyCredential.DeviceData> {
    public static final AmplifyCredential$DeviceData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AmplifyCredential$DeviceData$$serializer amplifyCredential$DeviceData$$serializer = new AmplifyCredential$DeviceData$$serializer();
        INSTANCE = amplifyCredential$DeviceData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("deviceMetadata", amplifyCredential$DeviceData$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("deviceMetadata", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AmplifyCredential$DeviceData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DeviceMetadata.Companion.serializer()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AmplifyCredential.DeviceData deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r4 = 0;
        Object obj = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else {
                if (decodeElementIndex != 0) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                obj = beginStructure.decodeSerializableElement(descriptor2, 0, DeviceMetadata.Companion.serializer(), obj);
                r4 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AmplifyCredential.DeviceData(r4, (DeviceMetadata) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AmplifyCredential.DeviceData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AmplifyCredential.DeviceData.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
