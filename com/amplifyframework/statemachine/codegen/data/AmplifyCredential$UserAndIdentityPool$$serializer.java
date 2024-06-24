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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AmplifyCredential.kt */
/* loaded from: classes.dex */
public final class AmplifyCredential$UserAndIdentityPool$$serializer implements GeneratedSerializer<AmplifyCredential.UserAndIdentityPool> {
    public static final AmplifyCredential$UserAndIdentityPool$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AmplifyCredential$UserAndIdentityPool$$serializer amplifyCredential$UserAndIdentityPool$$serializer = new AmplifyCredential$UserAndIdentityPool$$serializer();
        INSTANCE = amplifyCredential$UserAndIdentityPool$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("userAndIdentityPool", amplifyCredential$UserAndIdentityPool$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("signedInData", false);
        pluginGeneratedSerialDescriptor.addElement("identityId", false);
        pluginGeneratedSerialDescriptor.addElement("credentials", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AmplifyCredential$UserAndIdentityPool$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{SignedInData$$serializer.INSTANCE, StringSerializer.INSTANCE, AWSCredentials$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AmplifyCredential.UserAndIdentityPool deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        Object obj = null;
        boolean z = true;
        int r6 = 0;
        Object obj2 = null;
        String str = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                obj = beginStructure.decodeSerializableElement(descriptor2, 0, SignedInData$$serializer.INSTANCE, obj);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                obj2 = beginStructure.decodeSerializableElement(descriptor2, 2, AWSCredentials$$serializer.INSTANCE, obj2);
                r6 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AmplifyCredential.UserAndIdentityPool(r6, (SignedInData) obj, str, (AWSCredentials) obj2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AmplifyCredential.UserAndIdentityPool value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AmplifyCredential.UserAndIdentityPool.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
