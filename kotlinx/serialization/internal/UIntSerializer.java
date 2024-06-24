package kotlinx.serialization.internal;

import com.google.android.gms.cloudmessaging.zzv;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: ValueClasses.kt */
/* loaded from: classes4.dex */
public final class UIntSerializer implements KSerializer<UInt> {
    public static final UIntSerializer INSTANCE = new UIntSerializer();
    public static final InlineClassDescriptor descriptor = zzv.InlinePrimitiveDescriptor("kotlin.UInt", IntSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UInt(decoder.decodeInline(descriptor).decodeInt());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        int r3 = ((UInt) obj).data;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(descriptor).encodeInt(r3);
    }
}
