package com.animaconnected.watch.fitness;

import com.animaconnected.watch.workout.SleepType;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;

/* compiled from: FitnessDataSerialization.kt */
/* loaded from: classes3.dex */
public final class SleepTypeSerializer implements KSerializer<SleepType> {
    public static final SleepTypeSerializer INSTANCE = new SleepTypeSerializer();
    private static final SerialDescriptor descriptor = IntSerializer.INSTANCE.getDescriptor();

    private SleepTypeSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SleepType deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SleepType parse = SleepType.Companion.parse(decoder.decodeInt());
        Intrinsics.checkNotNull(parse);
        return parse;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SleepType value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeInt(value.getValue());
    }
}
