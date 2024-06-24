package com.animaconnected.watch.behaviour.temperature;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
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

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class Weather$$serializer implements GeneratedSerializer<Weather> {
    public static final Weather$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Weather$$serializer weather$$serializer = new Weather$$serializer();
        INSTANCE = weather$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.Weather", weather$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_CURRENT, true);
        pluginGeneratedSerialDescriptor.addElement("daily", true);
        pluginGeneratedSerialDescriptor.addElement("hourly", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Weather$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Weather.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(Current$$serializer.INSTANCE), kSerializerArr[1], kSerializerArr[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Weather deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Weather.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        Current current = null;
        List list = null;
        List list2 = null;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                current = (Current) beginStructure.decodeNullableSerializableElement(descriptor2, 0, Current$$serializer.INSTANCE, current);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                list = (List) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], list);
                r6 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], list2);
                r6 |= 4;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Weather(r6, current, list, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Weather value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Weather.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
