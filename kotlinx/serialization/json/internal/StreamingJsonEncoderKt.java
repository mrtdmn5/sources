package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortSerializer;

/* compiled from: StreamingJsonEncoder.kt */
/* loaded from: classes4.dex */
public final class StreamingJsonEncoderKt {
    public static final Set<SerialDescriptor> unsignedNumberDescriptors = SetsKt__SetsKt.setOf((Object[]) new SerialDescriptor[]{UIntSerializer.descriptor, ULongSerializer.descriptor, UByteSerializer.descriptor, UShortSerializer.descriptor});

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor.isInline() && unsignedNumberDescriptors.contains(serialDescriptor)) {
            return true;
        }
        return false;
    }
}
