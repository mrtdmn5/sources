package com.animaconnected.watch.graphs;

import androidx.core.util.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ChartEntities.kt */
/* loaded from: classes3.dex */
public final class AvgMaxMinEntry$$serializer implements GeneratedSerializer<AvgMaxMinEntry> {
    public static final AvgMaxMinEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        AvgMaxMinEntry$$serializer avgMaxMinEntry$$serializer = new AvgMaxMinEntry$$serializer();
        INSTANCE = avgMaxMinEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.graphs.AvgMaxMinEntry", avgMaxMinEntry$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("avgValue", false);
        pluginGeneratedSerialDescriptor.addElement("maxValue", false);
        pluginGeneratedSerialDescriptor.addElement("minValue", false);
        pluginGeneratedSerialDescriptor.addElement("xAxisLabel", false);
        pluginGeneratedSerialDescriptor.addElement("markerLabel", true);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AvgMaxMinEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0021. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public AvgMaxMinEntry deserialize(Decoder decoder) {
        int r4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        boolean z2 = true;
        while (z2) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z2 = false;
                case 0:
                    r6 = beginStructure.decodeIntElement(descriptor2, 0);
                    r5 |= 1;
                case 1:
                    r7 = beginStructure.decodeIntElement(descriptor2, 1);
                    r4 = r5 | 2;
                    r5 = r4;
                case 2:
                    r8 = beginStructure.decodeIntElement(descriptor2, 2);
                    r4 = r5 | 4;
                    r5 = r4;
                case 3:
                    r5 |= 8;
                    str = beginStructure.decodeStringElement(descriptor2, 3);
                case 4:
                    r5 |= 16;
                    str2 = beginStructure.decodeStringElement(descriptor2, 4);
                case 5:
                    z = beginStructure.decodeBooleanElement(descriptor2, 5);
                    r4 = r5 | 32;
                    r5 = r4;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new AvgMaxMinEntry(r5, r6, r7, r8, str, str2, z, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AvgMaxMinEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AvgMaxMinEntry.write$Self$graphics_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
