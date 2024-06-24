package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class LocationEntry$$serializer implements GeneratedSerializer<LocationEntry> {
    public static final LocationEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        LocationEntry$$serializer locationEntry$$serializer = new LocationEntry$$serializer();
        INSTANCE = locationEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.LocationEntry", locationEntry$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("historyDeviceId", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ActivityEntry$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(new String[]{FitnessDataKt.oldJsonNameForHistoryDeviceId}));
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("long", false);
        pluginGeneratedSerialDescriptor.addElement("lat", false);
        pluginGeneratedSerialDescriptor.addElement("accuracy", false);
        pluginGeneratedSerialDescriptor.addElement("altitude", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocationEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{HistoryDeviceId$$serializer.INSTANCE, LongSerializer.INSTANCE, doubleSerializer, doubleSerializer, FloatSerializer.INSTANCE, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocationEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r11 = 0;
        String str = null;
        long j = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f = 0.0f;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                    break;
                case 0:
                    HistoryDeviceId historyDeviceId = (HistoryDeviceId) beginStructure.decodeSerializableElement(descriptor2, 0, HistoryDeviceId$$serializer.INSTANCE, str != null ? HistoryDeviceId.m1556boximpl(str) : null);
                    str = historyDeviceId != null ? historyDeviceId.m1562unboximpl() : null;
                    r11 |= 1;
                    break;
                case 1:
                    r11 |= 2;
                    j = beginStructure.decodeLongElement(descriptor2, 1);
                    break;
                case 2:
                    r11 |= 4;
                    d = beginStructure.decodeDoubleElement(descriptor2, 2);
                    break;
                case 3:
                    r11 |= 8;
                    d2 = beginStructure.decodeDoubleElement(descriptor2, 3);
                    break;
                case 4:
                    r11 |= 16;
                    f = beginStructure.decodeFloatElement(descriptor2, 4);
                    break;
                case 5:
                    r11 |= 32;
                    d3 = beginStructure.decodeDoubleElement(descriptor2, 5);
                    break;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new LocationEntry(r11, str, j, d, d2, f, d3, (SerializationConstructorMarker) null, (DefaultConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocationEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LocationEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
