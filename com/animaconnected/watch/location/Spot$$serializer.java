package com.animaconnected.watch.location;

import androidx.core.util.Preconditions;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LocationResult.kt */
/* loaded from: classes3.dex */
public final class Spot$$serializer implements GeneratedSerializer<Spot> {
    public static final Spot$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Spot$$serializer spot$$serializer = new Spot$$serializer();
        INSTANCE = spot$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.location.Spot", spot$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("timeStamp", true);
        pluginGeneratedSerialDescriptor.addElement("latitude", true);
        pluginGeneratedSerialDescriptor.addElement("longitude", true);
        pluginGeneratedSerialDescriptor.addElement("addressLine", true);
        pluginGeneratedSerialDescriptor.addElement("accuracy", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("altitude", true);
        pluginGeneratedSerialDescriptor.addElement(TransferTable.COLUMN_SPEED, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Spot$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        return new KSerializer[]{LongSerializer.INSTANCE, doubleSerializer, doubleSerializer, BuiltinSerializersKt.getNullable(stringSerializer), floatSerializer, BuiltinSerializersKt.getNullable(stringSerializer), doubleSerializer, BuiltinSerializersKt.getNullable(floatSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002c. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Spot deserialize(Decoder decoder) {
        int r8;
        int r10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        String str = null;
        int r11 = 0;
        long j = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f = 0.0f;
        boolean z = true;
        String str2 = null;
        Float f2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    j = beginStructure.decodeLongElement(descriptor2, 0);
                    r11 |= 1;
                case 1:
                    r10 = r11 | 2;
                    d = beginStructure.decodeDoubleElement(descriptor2, 1);
                    r11 = r10;
                case 2:
                    d2 = beginStructure.decodeDoubleElement(descriptor2, 2);
                    r8 = r11 | 4;
                    r11 = r8;
                case 3:
                    str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str2);
                    r8 = r11 | 8;
                    r11 = r8;
                case 4:
                    f = beginStructure.decodeFloatElement(descriptor2, 4);
                    r11 |= 16;
                case 5:
                    str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str);
                    r8 = r11 | 32;
                    r11 = r8;
                case 6:
                    r10 = r11 | 64;
                    d3 = beginStructure.decodeDoubleElement(descriptor2, 6);
                    r11 = r10;
                case 7:
                    f2 = (Float) beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, f2);
                    r8 = r11 | 128;
                    r11 = r8;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Spot(r11, j, d, d2, str2, f, str, d3, f2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Spot value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Spot.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
