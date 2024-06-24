package com.animaconnected.watch.behaviour.temperature;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.behaviour.temperature.OpenWeatherApiResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class OpenWeatherApiResponse$$serializer implements GeneratedSerializer<OpenWeatherApiResponse> {
    public static final OpenWeatherApiResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        OpenWeatherApiResponse$$serializer openWeatherApiResponse$$serializer = new OpenWeatherApiResponse$$serializer();
        INSTANCE = openWeatherApiResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.OpenWeatherApiResponse", openWeatherApiResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("cod", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_MAIN, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OpenWeatherApiResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, OpenWeatherApiResponse$Main$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public OpenWeatherApiResponse deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r6 = 0;
        int r7 = 0;
        OpenWeatherApiResponse.Main main = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                r7 = beginStructure.decodeIntElement(descriptor2, 0);
                r6 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                main = (OpenWeatherApiResponse.Main) beginStructure.decodeSerializableElement(descriptor2, 1, OpenWeatherApiResponse$Main$$serializer.INSTANCE, main);
                r6 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new OpenWeatherApiResponse(r6, r7, main, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, OpenWeatherApiResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        OpenWeatherApiResponse.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
