package androidx.compose.ui.unit;

/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class Dp implements Comparable<Dp> {
    public final float value;

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m579equalsimpl0(float f, float f2) {
        if (Float.compare(f, f2) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m580toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Dp dp) {
        return Float.compare(this.value, dp.value);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dp)) {
            return false;
        }
        if (Float.compare(this.value, ((Dp) obj).value) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.value);
    }

    public final String toString() {
        return m580toStringimpl(this.value);
    }
}
