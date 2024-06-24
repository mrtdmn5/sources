package kotlinx.serialization.internal;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: BuiltInSerializers.kt */
/* loaded from: classes4.dex */
public final class DurationSerializer implements KSerializer<Duration> {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int r0 = Duration.$r8$clinit;
        String value = decoder.decodeString();
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            return new Duration(DurationKt.access$parseDuration(value));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Invalid ISO duration string format: '", value, "'."), e);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        long j;
        boolean z;
        boolean z2;
        long j2 = ((Duration) obj).rawValue;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int r11 = Duration.$r8$clinit;
        StringBuilder sb = new StringBuilder();
        if (Duration.m1685isNegativeimpl(j2)) {
            sb.append('-');
        }
        sb.append("PT");
        if (Duration.m1685isNegativeimpl(j2)) {
            j = Duration.m1691unaryMinusUwyO8pc(j2);
        } else {
            j = j2;
        }
        long m1676getInWholeHoursimpl = Duration.m1676getInWholeHoursimpl(j);
        int m1680getMinutesComponentimpl = Duration.m1680getMinutesComponentimpl(j);
        int m1682getSecondsComponentimpl = Duration.m1682getSecondsComponentimpl(j);
        int m1681getNanosecondsComponentimpl = Duration.m1681getNanosecondsComponentimpl(j);
        if (Duration.m1684isInfiniteimpl(j2)) {
            m1676getInWholeHoursimpl = 9999999999999L;
        }
        boolean z3 = true;
        if (m1676getInWholeHoursimpl != 0) {
            z = true;
        } else {
            z = false;
        }
        if (m1682getSecondsComponentimpl == 0 && m1681getNanosecondsComponentimpl == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (m1680getMinutesComponentimpl == 0 && (!z2 || !z)) {
            z3 = false;
        }
        if (z) {
            sb.append(m1676getInWholeHoursimpl);
            sb.append('H');
        }
        if (z3) {
            sb.append(m1680getMinutesComponentimpl);
            sb.append('M');
        }
        if (z2 || (!z && !z3)) {
            Duration.m1671appendFractionalimpl(sb, m1682getSecondsComponentimpl, m1681getNanosecondsComponentimpl, 9, "S", true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        encoder.encodeString(sb2);
    }
}
