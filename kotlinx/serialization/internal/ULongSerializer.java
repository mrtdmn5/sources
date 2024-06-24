package kotlinx.serialization.internal;

import com.google.android.gms.cloudmessaging.zzv;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes4.dex */
public final class ULongSerializer implements KSerializer<ULong> {
    public static final ULongSerializer INSTANCE = new ULongSerializer();
    public static final InlineClassDescriptor descriptor = zzv.InlinePrimitiveDescriptor("kotlin.ULong", LongSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new ULong(decoder.decodeInline(descriptor).decodeLong());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        long j = ((ULong) obj).data;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(descriptor).encodeLong(j);
    }
}
