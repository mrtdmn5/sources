package com.animaconnected.watch.behaviour.temperature;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.behaviour.temperature.OpenWeatherApiResponse;
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

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class OpenWeatherApiResponse$Main$$serializer implements GeneratedSerializer<OpenWeatherApiResponse.Main> {
    public static final OpenWeatherApiResponse$Main$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        OpenWeatherApiResponse$Main$$serializer openWeatherApiResponse$Main$$serializer = new OpenWeatherApiResponse$Main$$serializer();
        INSTANCE = openWeatherApiResponse$Main$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.OpenWeatherApiResponse.Main", openWeatherApiResponse$Main$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("temp", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OpenWeatherApiResponse$Main$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DoubleSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public OpenWeatherApiResponse.Main deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        double d = 0.0d;
        int r5 = 0;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else {
                if (decodeElementIndex != 0) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                d = beginStructure.decodeDoubleElement(descriptor2, 0);
                r5 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new OpenWeatherApiResponse.Main(r5, d, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, OpenWeatherApiResponse.Main value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        beginStructure.encodeDoubleElement(descriptor2, 0, value.temp);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
