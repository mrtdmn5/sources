package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.fitness.ElevationApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: ElevationApi.kt */
/* loaded from: classes3.dex */
public final class ElevationApi$RestResultLocation$$serializer implements GeneratedSerializer<ElevationApi.RestResultLocation> {
    public static final ElevationApi$RestResultLocation$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ElevationApi$RestResultLocation$$serializer elevationApi$RestResultLocation$$serializer = new ElevationApi$RestResultLocation$$serializer();
        INSTANCE = elevationApi$RestResultLocation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.ElevationApi.RestResultLocation", elevationApi$RestResultLocation$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("lat", false);
        pluginGeneratedSerialDescriptor.addElement("lng", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ElevationApi$RestResultLocation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{doubleSerializer, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ElevationApi.RestResultLocation deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r6 = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                d = beginStructure.decodeDoubleElement(descriptor2, 0);
                r6 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                d2 = beginStructure.decodeDoubleElement(descriptor2, 1);
                r6 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new ElevationApi.RestResultLocation(r6, d, d2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ElevationApi.RestResultLocation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ElevationApi.RestResultLocation.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
