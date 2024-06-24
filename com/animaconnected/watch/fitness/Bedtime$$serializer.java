package com.animaconnected.watch.fitness;

import androidx.core.util.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class Bedtime$$serializer implements GeneratedSerializer<Bedtime> {
    public static final Bedtime$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Bedtime$$serializer bedtime$$serializer = new Bedtime$$serializer();
        INSTANCE = bedtime$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.fitness.Bedtime", bedtime$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("hour", true);
        pluginGeneratedSerialDescriptor.addElement("minute", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Bedtime$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Bedtime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                r6 = beginStructure.decodeIntElement(descriptor2, 0);
                r5 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                r4 = beginStructure.decodeIntElement(descriptor2, 1);
                r5 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Bedtime(r5, r6, r4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Bedtime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Bedtime.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
