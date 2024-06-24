package androidx.compose.ui.unit;

/* compiled from: Velocity.kt */
/* loaded from: classes.dex */
public final class Velocity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    public final long packedValue;

    /* renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static long m603copyOhffZ5M$default(long j, float f, float f2, int r5) {
        if ((r5 & 1) != 0) {
            f = m604getXimpl(j);
        }
        if ((r5 & 2) != 0) {
            f2 = m605getYimpl(j);
        }
        return VelocityKt.Velocity(f, f2);
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m604getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m605getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m606minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m604getXimpl(j) - m604getXimpl(j2), m605getYimpl(j) - m605getYimpl(j2));
    }

    /* renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m607plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m604getXimpl(j2) + m604getXimpl(j), m605getYimpl(j2) + m605getYimpl(j));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Velocity)) {
            return false;
        }
        if (this.packedValue != ((Velocity) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        long j = this.packedValue;
        sb.append(m604getXimpl(j));
        sb.append(", ");
        sb.append(m605getYimpl(j));
        sb.append(") px/sec");
        return sb.toString();
    }
}
