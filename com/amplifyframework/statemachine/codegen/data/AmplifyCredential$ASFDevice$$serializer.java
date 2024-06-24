package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AmplifyCredential.kt */
/* loaded from: classes.dex */
public final class AmplifyCredential$ASFDevice$$serializer implements GeneratedSerializer<AmplifyCredential.ASFDevice> {
    public static final AmplifyCredential$ASFDevice$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AmplifyCredential$ASFDevice$$serializer amplifyCredential$ASFDevice$$serializer = new AmplifyCredential$ASFDevice$$serializer();
        INSTANCE = amplifyCredential$ASFDevice$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("asfDevice", amplifyCredential$ASFDevice$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement(ConfigurationItem.COLUMN_NAME_ID, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AmplifyCredential$ASFDevice$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AmplifyCredential.ASFDevice deserialize(Decoder decoder) {
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
                obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, obj);
                r4 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AmplifyCredential.ASFDevice(r4, (String) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AmplifyCredential.ASFDevice value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AmplifyCredential.ASFDevice.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
