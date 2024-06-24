package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.statemachine.codegen.data.serializer.DateSerializer;
import java.util.Date;
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

/* compiled from: SignedInData.kt */
/* loaded from: classes.dex */
public final class SignedInData$$serializer implements GeneratedSerializer<SignedInData> {
    public static final SignedInData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SignedInData$$serializer signedInData$$serializer = new SignedInData$$serializer();
        INSTANCE = signedInData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amplifyframework.statemachine.codegen.data.SignedInData", signedInData$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("userId", false);
        pluginGeneratedSerialDescriptor.addElement("username", false);
        pluginGeneratedSerialDescriptor.addElement("signedInDate", false);
        pluginGeneratedSerialDescriptor.addElement("signInMethod", false);
        pluginGeneratedSerialDescriptor.addElement("cognitoUserPoolTokens", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SignedInData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, DateSerializer.INSTANCE, SignInMethod.Companion.serializer(), CognitoUserPoolTokens$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SignedInData deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        Object obj = null;
        boolean z = true;
        int r7 = 0;
        Object obj2 = null;
        Object obj3 = null;
        String str = null;
        String str2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r7 |= 1;
            } else if (decodeElementIndex == 1) {
                str2 = beginStructure.decodeStringElement(descriptor2, 1);
                r7 |= 2;
            } else if (decodeElementIndex == 2) {
                obj = beginStructure.decodeSerializableElement(descriptor2, 2, DateSerializer.INSTANCE, obj);
                r7 |= 4;
            } else if (decodeElementIndex == 3) {
                obj2 = beginStructure.decodeSerializableElement(descriptor2, 3, SignInMethod.Companion.serializer(), obj2);
                r7 |= 8;
            } else {
                if (decodeElementIndex != 4) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                obj3 = beginStructure.decodeSerializableElement(descriptor2, 4, CognitoUserPoolTokens$$serializer.INSTANCE, obj3);
                r7 |= 16;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new SignedInData(r7, str, str2, (Date) obj, (SignInMethod) obj2, (CognitoUserPoolTokens) obj3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SignedInData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SignedInData.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
