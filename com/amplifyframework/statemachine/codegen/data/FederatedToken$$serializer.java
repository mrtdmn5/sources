package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
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
public final class FederatedToken$$serializer implements GeneratedSerializer<FederatedToken> {
    public static final FederatedToken$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        FederatedToken$$serializer federatedToken$$serializer = new FederatedToken$$serializer();
        INSTANCE = federatedToken$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amplifyframework.statemachine.codegen.data.FederatedToken", federatedToken$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement(AWSCognitoLegacyCredentialStore.TOKEN_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("providerName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FederatedToken$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FederatedToken deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r6 = 0;
        String str = null;
        String str2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str2 = beginStructure.decodeStringElement(descriptor2, 0);
                r6 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new FederatedToken(r6, str2, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FederatedToken value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FederatedToken.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
