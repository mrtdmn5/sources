package com.animaconnected.watch.behaviour.temperature;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.assets.WatchAsset;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class Daily$$serializer implements GeneratedSerializer<Daily> {
    public static final Daily$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Daily$$serializer daily$$serializer = new Daily$$serializer();
        INSTANCE = daily$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.Daily", daily$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("dt", false);
        pluginGeneratedSerialDescriptor.addElement("temp", false);
        pluginGeneratedSerialDescriptor.addElement("pop", false);
        pluginGeneratedSerialDescriptor.addElement("uvi", false);
        pluginGeneratedSerialDescriptor.addElement("weather", false);
        pluginGeneratedSerialDescriptor.addElement("instant", true);
        pluginGeneratedSerialDescriptor.addElement("asset", true);
        pluginGeneratedSerialDescriptor.addElement("smallAsset", true);
        pluginGeneratedSerialDescriptor.addElement("iconId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Daily$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Daily.$childSerializers;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{LongSerializer.INSTANCE, Temp$$serializer.INSTANCE, doubleSerializer, doubleSerializer, kSerializerArr[4], InstantIso8601Serializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002c. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Daily deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int r4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Daily.$childSerializers;
        beginStructure.decodeSequentially();
        WatchAsset watchAsset = null;
        Temp temp = null;
        long j = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        boolean z = true;
        int r11 = 0;
        List list = null;
        Instant instant = null;
        WatchAsset watchAsset2 = null;
        String str = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    j = beginStructure.decodeLongElement(descriptor2, 0);
                    r11 |= 1;
                case 1:
                    r11 |= 2;
                    temp = (Temp) beginStructure.decodeSerializableElement(descriptor2, 1, Temp$$serializer.INSTANCE, temp);
                case 2:
                    r11 |= 4;
                    d = beginStructure.decodeDoubleElement(descriptor2, 2);
                case 3:
                    d2 = beginStructure.decodeDoubleElement(descriptor2, 3);
                    r11 |= 8;
                case 4:
                    r4 = r11 | 16;
                    list = (List) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], list);
                    r11 = r4;
                case 5:
                    r4 = r11 | 32;
                    instant = (Instant) beginStructure.decodeSerializableElement(descriptor2, 5, InstantIso8601Serializer.INSTANCE, instant);
                    r11 = r4;
                case 6:
                    r4 = r11 | 64;
                    watchAsset2 = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], watchAsset2);
                    r11 = r4;
                case 7:
                    r4 = r11 | 128;
                    watchAsset = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], watchAsset);
                    r11 = r4;
                case 8:
                    r4 = r11 | 256;
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str);
                    r11 = r4;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Daily(r11, j, temp, d, d2, list, instant, watchAsset2, watchAsset, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Daily value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Daily.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
