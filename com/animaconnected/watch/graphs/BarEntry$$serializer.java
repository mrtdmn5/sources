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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ChartEntities.kt */
/* loaded from: classes3.dex */
public final class BarEntry$$serializer implements GeneratedSerializer<BarEntry> {
    public static final BarEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BarEntry$$serializer barEntry$$serializer = new BarEntry$$serializer();
        INSTANCE = barEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.graphs.BarEntry", barEntry$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("xAxisLabel", true);
        pluginGeneratedSerialDescriptor.addElement("xAxisValue", true);
        pluginGeneratedSerialDescriptor.addElement("barValueLabel", true);
        pluginGeneratedSerialDescriptor.addElement("markerLabel", true);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BarEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{IntSerializer.INSTANCE, stringSerializer, LongSerializer.INSTANCE, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0025. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public BarEntry deserialize(Decoder decoder) {
        int r6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        int r8 = 0;
        int r9 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        boolean z2 = true;
        while (z2) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z2 = false;
                case 0:
                    r9 = beginStructure.decodeIntElement(descriptor2, 0);
                    r8 |= 1;
                case 1:
                    r6 = r8 | 2;
                    str = beginStructure.decodeStringElement(descriptor2, 1);
                    r8 = r6;
                case 2:
                    j = beginStructure.decodeLongElement(descriptor2, 2);
                    r8 |= 4;
                case 3:
                    r6 = r8 | 8;
                    str2 = beginStructure.decodeStringElement(descriptor2, 3);
                    r8 = r6;
                case 4:
                    r6 = r8 | 16;
                    str3 = beginStructure.decodeStringElement(descriptor2, 4);
                    r8 = r6;
                case 5:
                    z = beginStructure.decodeBooleanElement(descriptor2, 5);
                    r8 |= 32;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new BarEntry(r8, r9, str, j, str2, str3, z, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BarEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        BarEntry.write$Self$graphics_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
