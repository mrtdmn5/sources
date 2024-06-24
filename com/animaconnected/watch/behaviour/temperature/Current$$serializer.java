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
public final class Current$$serializer implements GeneratedSerializer<Current> {
    public static final Current$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Current$$serializer current$$serializer = new Current$$serializer();
        INSTANCE = current$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.temperature.Current", current$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("dt", false);
        pluginGeneratedSerialDescriptor.addElement("temp", false);
        pluginGeneratedSerialDescriptor.addElement("uvi", false);
        pluginGeneratedSerialDescriptor.addElement("weather", false);
        pluginGeneratedSerialDescriptor.addElement("instant", true);
        pluginGeneratedSerialDescriptor.addElement("asset", true);
        pluginGeneratedSerialDescriptor.addElement("iconId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Current$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Current.$childSerializers;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{LongSerializer.INSTANCE, doubleSerializer, doubleSerializer, kSerializerArr[3], InstantIso8601Serializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Current deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Current.$childSerializers;
        beginStructure.decodeSequentially();
        String str = null;
        long j = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        int r11 = 0;
        boolean z = true;
        List list = null;
        Instant instant = null;
        WatchAsset watchAsset = null;
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
                    d2 = beginStructure.decodeDoubleElement(descriptor2, 2);
                    r11 |= 4;
                    break;
                case 3:
                    r11 |= 8;
                    list = (List) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], list);
                    break;
                case 4:
                    r11 |= 16;
                    instant = (Instant) beginStructure.decodeSerializableElement(descriptor2, 4, InstantIso8601Serializer.INSTANCE, instant);
                    break;
                case 5:
                    r11 |= 32;
                    watchAsset = (WatchAsset) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], watchAsset);
                    break;
                case 6:
                    r11 |= 64;
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Current(r11, j, d, d2, list, instant, watchAsset, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Current value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Current.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
