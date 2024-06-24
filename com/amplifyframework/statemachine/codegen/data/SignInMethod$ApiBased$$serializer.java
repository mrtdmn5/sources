package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: SignInMethod.kt */
/* loaded from: classes.dex */
public final class SignInMethod$ApiBased$$serializer implements GeneratedSerializer<SignInMethod.ApiBased> {
    public static final SignInMethod$ApiBased$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SignInMethod$ApiBased$$serializer signInMethod$ApiBased$$serializer = new SignInMethod$ApiBased$$serializer();
        INSTANCE = signInMethod$ApiBased$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("SignInMethod.ApiBased", signInMethod$ApiBased$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("authType", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SignInMethod$ApiBased$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{new EnumSerializer("com.amplifyframework.statemachine.codegen.data.SignInMethod.ApiBased.AuthType", SignInMethod.ApiBased.AuthType.values())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SignInMethod.ApiBased deserialize(Decoder decoder) {
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
                obj = beginStructure.decodeSerializableElement(descriptor2, 0, new EnumSerializer("com.amplifyframework.statemachine.codegen.data.SignInMethod.ApiBased.AuthType", SignInMethod.ApiBased.AuthType.values()), obj);
                r4 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new SignInMethod.ApiBased(r4, (SignInMethod.ApiBased.AuthType) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SignInMethod.ApiBased value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SignInMethod.ApiBased.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
