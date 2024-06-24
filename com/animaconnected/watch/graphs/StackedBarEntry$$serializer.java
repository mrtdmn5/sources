package com.animaconnected.watch.graphs;

import androidx.core.util.Preconditions;
import java.util.List;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ChartEntities.kt */
/* loaded from: classes3.dex */
public final class StackedBarEntry$$serializer implements GeneratedSerializer<StackedBarEntry> {
    public static final StackedBarEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StackedBarEntry$$serializer stackedBarEntry$$serializer = new StackedBarEntry$$serializer();
        INSTANCE = stackedBarEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.graphs.StackedBarEntry", stackedBarEntry$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.addElement("xAxisLabel", false);
        pluginGeneratedSerialDescriptor.addElement("markerLabel", true);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StackedBarEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = StackedBarEntry.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], stringSerializer, stringSerializer, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StackedBarEntry deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = StackedBarEntry.$childSerializers;
        beginStructure.decodeSequentially();
        int r6 = 0;
        boolean z = false;
        List list = null;
        String str = null;
        String str2 = null;
        boolean z2 = true;
        while (z2) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z2 = false;
            } else if (decodeElementIndex == 0) {
                list = (List) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list);
                r6 |= 1;
            } else if (decodeElementIndex == 1) {
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            } else if (decodeElementIndex == 2) {
                str2 = beginStructure.decodeStringElement(descriptor2, 2);
                r6 |= 4;
            } else {
                if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                z = beginStructure.decodeBooleanElement(descriptor2, 3);
                r6 |= 8;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new StackedBarEntry(r6, list, str, str2, z, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StackedBarEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        StackedBarEntry.write$Self$graphics_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
