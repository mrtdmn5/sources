package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;

/* compiled from: FitnessDataSerialization.kt */
/* loaded from: classes3.dex */
public final class PowerStateSerializer implements KSerializer<PowerState> {
    public static final PowerStateSerializer INSTANCE = new PowerStateSerializer();
    private static final SerialDescriptor descriptor = IntSerializer.INSTANCE.getDescriptor();

    private PowerStateSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PowerState deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return PowerState.Companion.fromId(decoder.decodeInt());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PowerState value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeInt(value.getId());
    }
}
