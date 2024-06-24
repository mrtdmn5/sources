package kotlinx.serialization.internal;

import com.google.android.gms.cloudmessaging.zzv;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes4.dex */
public final class UShortSerializer implements KSerializer<UShort> {
    public static final UShortSerializer INSTANCE = new UShortSerializer();
    public static final InlineClassDescriptor descriptor = zzv.InlinePrimitiveDescriptor("kotlin.UShort", ShortSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UShort(decoder.decodeInline(descriptor).decodeShort());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        short s = ((UShort) obj).data;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(descriptor).encodeShort(s);
    }
}
