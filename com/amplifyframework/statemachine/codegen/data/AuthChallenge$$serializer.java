package com.amplifyframework.statemachine.codegen.data;

import androidx.core.util.Preconditions;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AuthChallenge.kt */
/* loaded from: classes.dex */
public final class AuthChallenge$$serializer implements GeneratedSerializer<AuthChallenge> {
    public static final AuthChallenge$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        AuthChallenge$$serializer authChallenge$$serializer = new AuthChallenge$$serializer();
        INSTANCE = authChallenge$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amplifyframework.statemachine.codegen.data.AuthChallenge", authChallenge$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("challengeName", false);
        pluginGeneratedSerialDescriptor.addElement("username", true);
        pluginGeneratedSerialDescriptor.addElement("session", false);
        pluginGeneratedSerialDescriptor.addElement("parameters", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AuthChallenge$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(stringSerializer, stringSerializer))};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AuthChallenge deserialize(Decoder decoder) {
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
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r7 |= 1;
            } else if (decodeElementIndex == 1) {
                obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj);
                r7 |= 2;
            } else if (decodeElementIndex == 2) {
                obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj2);
                r7 |= 4;
            } else {
                if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, new LinkedHashMapSerializer(stringSerializer, stringSerializer), obj3);
                r7 |= 8;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AuthChallenge(r7, str, (String) obj, (String) obj2, (Map) obj3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AuthChallenge value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AuthChallenge.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
