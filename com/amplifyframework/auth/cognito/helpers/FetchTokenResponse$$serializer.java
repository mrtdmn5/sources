package com.amplifyframework.auth.cognito.helpers;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: HostedUIHttpHelper.kt */
/* loaded from: classes.dex */
public final class FetchTokenResponse$$serializer implements GeneratedSerializer<FetchTokenResponse> {
    public static final FetchTokenResponse$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        FetchTokenResponse$$serializer fetchTokenResponse$$serializer = new FetchTokenResponse$$serializer();
        INSTANCE = fetchTokenResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amplifyframework.auth.cognito.helpers.FetchTokenResponse", fetchTokenResponse$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("access_token", true);
        pluginGeneratedSerialDescriptor.addElement("id_token", true);
        pluginGeneratedSerialDescriptor.addElement("refresh_token", true);
        pluginGeneratedSerialDescriptor.addElement("expires_in", true);
        pluginGeneratedSerialDescriptor.addElement("error", true);
        pluginGeneratedSerialDescriptor.addElement("expiration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FetchTokenResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0022. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public FetchTokenResponse deserialize(Decoder decoder) {
        int r11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        Object obj = null;
        boolean z = true;
        int r12 = 0;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, obj);
                    r12 |= 1;
                case 1:
                    obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj2);
                    r11 = r12 | 2;
                    r12 = r11;
                case 2:
                    obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj6);
                    r11 = r12 | 4;
                    r12 = r11;
                case 3:
                    obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, obj3);
                    r11 = r12 | 8;
                    r12 = r11;
                case 4:
                    obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, obj4);
                    r11 = r12 | 16;
                    r12 = r11;
                case 5:
                    obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, LongSerializer.INSTANCE, obj5);
                    r11 = r12 | 32;
                    r12 = r11;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new FetchTokenResponse(r12, (String) obj, (String) obj2, (String) obj6, (Integer) obj3, (String) obj4, (Long) obj5, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FetchTokenResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FetchTokenResponse.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
