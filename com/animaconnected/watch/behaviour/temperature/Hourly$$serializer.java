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

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class Hourly$$serializer implements GeneratedSerializer<Hourly> {
    public static final Hourly$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Hourly$$serializer hourly$$serializer = new Hourly$$serializer();
        INSTANCE = hourly$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.Hourly", hourly$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("dt", false);
        pluginGeneratedSerialDescriptor.addElement("temp", false);
        pluginGeneratedSerialDescriptor.addElement("weather", false);
        pluginGeneratedSerialDescriptor.addElement("instant", true);
        pluginGeneratedSerialDescriptor.addElement("smallAsset", true);
        pluginGeneratedSerialDescriptor.addElement("bigAsset", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Hourly$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Hourly.$childSerializers;
        return new KSerializer[]{LongSerializer.INSTANCE, DoubleSerializer.INSTANCE, kSerializerArr[2], InstantIso8601Serializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Hourly deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Hourly.$childSerializers;
        beginStructure.decodeSequentially();
        WatchAsset watchAsset = null;
        long j = 0;
        double d = 0.0d;
        int r11 = 0;
        boolean z = true;
        List list = null;
        Instant instant = null;
        WatchAsset watchAsset2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    j = beginStructure.decodeLongElement(descriptor2, 0);
                    r11 |= 1;
                    break;
                case 1:
                    d = beginStructure.decodeDoubleElement(descriptor2, 1);
                    r11 |= 2;
                    break;
                case 2:
                    r11 |= 4;
                    list = (List) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], list);
                    break;
                case 3:
                    r11 |= 8;
                    instant = (Instant) beginStructure.decodeSerializableElement(descriptor2, 3, InstantIso8601Serializer.INSTANCE, instant);
                    break;
                case 4:
                    r11 |= 16;
                    watchAsset = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], watchAsset);
                    break;
                case 5:
                    r11 |= 32;
                    watchAsset2 = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], watchAsset2);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Hourly(r11, j, d, list, instant, watchAsset, watchAsset2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Hourly value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Hourly.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
