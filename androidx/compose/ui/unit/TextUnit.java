package androidx.compose.ui.unit;

/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public final class TextUnit {
    public static final TextUnitType[] TextUnitTypes = {new TextUnitType(0), new TextUnitType(4294967296L), new TextUnitType(8589934592L)};
    public static final long Unspecified = TextUnitKt.pack(Float.NaN, 0);
    public final long packedValue;

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m596equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m597getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) ((j & 1095216660480L) >>> 32)].type;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m598getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m599toStringimpl(long j) {
        long m597getTypeUIouoOA = m597getTypeUIouoOA(j);
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 0L)) {
            return "Unspecified";
        }
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 4294967296L)) {
            return m598getValueimpl(j) + ".sp";
        }
        if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 8589934592L)) {
            return m598getValueimpl(j) + ".em";
        }
        return "Invalid";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TextUnit)) {
            return false;
        }
        if (this.packedValue != ((TextUnit) obj).packedValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m599toStringimpl(this.packedValue);
    }
}
