package com.animaconnected.watch.fitness;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;

/* compiled from: FitnessDataSerialization.kt */
/* loaded from: classes3.dex */
public final class SessionStatusSerializer implements KSerializer<SessionStatus> {
    public static final SessionStatusSerializer INSTANCE = new SessionStatusSerializer();
    private static final SerialDescriptor descriptor = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE).getDescriptor();

    private SessionStatusSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SessionStatus deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return SessionStatus.Companion.fromId(Integer.valueOf(decoder.decodeInt()));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SessionStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.getId() != null) {
            encoder.encodeInt(value.getId().intValue());
        } else {
            encoder.encodeNull();
        }
    }
}
