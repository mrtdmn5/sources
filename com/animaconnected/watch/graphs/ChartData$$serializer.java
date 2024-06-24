package com.animaconnected.watch.graphs;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: ChartEntities.kt */
/* loaded from: classes3.dex */
public final class ChartData$$serializer<T> implements GeneratedSerializer<ChartData<? extends T>> {
    private final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;
    private final /* synthetic */ KSerializer<?> typeSerial0;

    private ChartData$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.graphs.ChartData", this, 3);
        pluginGeneratedSerialDescriptor.addElement("entries", false);
        pluginGeneratedSerialDescriptor.addElement("hasOlderData", false);
        pluginGeneratedSerialDescriptor.addElement("isDataEmpty", false);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    private final KSerializer<T> getTypeSerial0() {
        return (KSerializer<T>) this.typeSerial0;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{new ArrayListSerializer(this.typeSerial0), booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ChartData<T> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        beginStructure.decodeSequentially();
        int r5 = 0;
        boolean z = false;
        boolean z2 = false;
        List list = null;
        boolean z3 = true;
        while (z3) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor);
            if (decodeElementIndex == -1) {
                z3 = false;
            } else if (decodeElementIndex == 0) {
                list = (List) beginStructure.decodeSerializableElement(descriptor, 0, new ArrayListSerializer(this.typeSerial0), list);
                r5 |= 1;
            } else if (decodeElementIndex == 1) {
                z = beginStructure.decodeBooleanElement(descriptor, 1);
                r5 |= 2;
            } else {
                if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                z2 = beginStructure.decodeBooleanElement(descriptor, 2);
                r5 |= 4;
            }
        }
        beginStructure.endStructure(descriptor);
        return new ChartData<>(r5, list, z, z2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ChartData<? extends T> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        ChartData.write$Self$graphics_release(value, beginStructure, descriptor, this.typeSerial0);
        beginStructure.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return new KSerializer[]{this.typeSerial0};
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChartData$$serializer(KSerializer typeSerial0) {
        this();
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
