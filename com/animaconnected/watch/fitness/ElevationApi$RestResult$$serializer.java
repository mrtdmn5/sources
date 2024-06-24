package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.fitness.ElevationApi;
import java.util.List;
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

/* compiled from: ElevationApi.kt */
/* loaded from: classes3.dex */
public final class ElevationApi$RestResult$$serializer implements GeneratedSerializer<ElevationApi.RestResult> {
    public static final ElevationApi$RestResult$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ElevationApi$RestResult$$serializer elevationApi$RestResult$$serializer = new ElevationApi$RestResult$$serializer();
        INSTANCE = elevationApi$RestResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.ElevationApi.RestResult", elevationApi$RestResult$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("results", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_STATUS, false);
        pluginGeneratedSerialDescriptor.addElement("error_message", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ElevationApi$RestResult$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ElevationApi.RestResult.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ElevationApi.RestResult deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = ElevationApi.RestResult.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        List list = null;
        String str = null;
        String str2 = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                list = (List) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str2);
                r6 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ElevationApi.RestResult(r6, list, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ElevationApi.RestResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ElevationApi.RestResult.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
