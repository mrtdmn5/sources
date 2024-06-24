package androidx.compose.ui.unit;

/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public final class TextUnitKt {
    public static final long getEm(double d) {
        return pack((float) d, 8589934592L);
    }

    public static final long getSp(double d) {
        return pack((float) d, 4294967296L);
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m600isUnspecifiedR2X_6o(long j) {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        if ((j & 1095216660480L) == 0) {
            return true;
        }
        return false;
    }

    public static final long pack(float f, long j) {
        long floatToIntBits = j | (Float.floatToIntBits(f) & 4294967295L);
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        return floatToIntBits;
    }

    public static final long getSp(int r2) {
        return pack(r2, 4294967296L);
    }
}
