package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.fitness.ElevationApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ElevationApi.kt */
/* loaded from: classes3.dex */
public final class ElevationApi$RestResultEntry$$serializer implements GeneratedSerializer<ElevationApi.RestResultEntry> {
    public static final ElevationApi$RestResultEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ElevationApi$RestResultEntry$$serializer elevationApi$RestResultEntry$$serializer = new ElevationApi$RestResultEntry$$serializer();
        INSTANCE = elevationApi$RestResultEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.ElevationApi.RestResultEntry", elevationApi$RestResultEntry$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("elevation", false);
        pluginGeneratedSerialDescriptor.addElement("location", false);
        pluginGeneratedSerialDescriptor.addElement("resolution", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ElevationApi$RestResultEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{doubleSerializer, ElevationApi$RestResultLocation$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(doubleSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ElevationApi.RestResultEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r7 = 0;
        ElevationApi.RestResultLocation restResultLocation = null;
        Double d = null;
        double d2 = 0.0d;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                d2 = beginStructure.decodeDoubleElement(descriptor2, 0);
                r7 |= 1;
            } else if (decodeElementIndex == 1) {
                restResultLocation = (ElevationApi.RestResultLocation) beginStructure.decodeSerializableElement(descriptor2, 1, ElevationApi$RestResultLocation$$serializer.INSTANCE, restResultLocation);
                r7 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                d = (Double) beginStructure.decodeNullableSerializableElement(descriptor2, 2, DoubleSerializer.INSTANCE, d);
                r7 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ElevationApi.RestResultEntry(r7, d2, restResultLocation, d, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ElevationApi.RestResultEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ElevationApi.RestResultEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
