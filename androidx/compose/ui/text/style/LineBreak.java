package androidx.compose.ui.text.style;

/* compiled from: LineBreak.android.kt */
/* loaded from: classes.dex */
public final class LineBreak {
    public static final int Simple = 66305;
    public final int mask;

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class Strategy {
        public final int value;

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m554toStringimpl(int r3) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (r3 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return "Strategy.Simple";
            }
            if (r3 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return "Strategy.HighQuality";
            }
            if (r3 == 3) {
                z3 = true;
            }
            if (z3) {
                return "Strategy.Balanced";
            }
            return "Invalid";
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Strategy)) {
                return false;
            }
            if (this.value != ((Strategy) obj).value) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Integer.hashCode(this.value);
        }

        public final String toString() {
            return m554toStringimpl(this.value);
        }
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class Strictness {
        public final int value;

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m555toStringimpl(int r3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = false;
            if (r3 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return "Strictness.None";
            }
            if (r3 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return "Strictness.Loose";
            }
            if (r3 == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return "Strictness.Normal";
            }
            if (r3 == 4) {
                z4 = true;
            }
            if (z4) {
                return "Strictness.Strict";
            }
            return "Invalid";
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Strictness)) {
                return false;
            }
            if (this.value != ((Strictness) obj).value) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Integer.hashCode(this.value);
        }

        public final String toString() {
            return m555toStringimpl(this.value);
        }
    }

    /* compiled from: LineBreak.android.kt */
    /* loaded from: classes.dex */
    public static final class WordBreak {
        public final int value;

        public final boolean equals(Object obj) {
            if (!(obj instanceof WordBreak)) {
                return false;
            }
            if (this.value != ((WordBreak) obj).value) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Integer.hashCode(this.value);
        }

        public final String toString() {
            boolean z;
            int r0 = this.value;
            boolean z2 = false;
            if (r0 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return "WordBreak.None";
            }
            if (r0 == 2) {
                z2 = true;
            }
            if (z2) {
                return "WordBreak.Phrase";
            }
            return "Invalid";
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LineBreak)) {
            return false;
        }
        if (this.mask != ((LineBreak) obj).mask) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.mask);
    }

    public final String toString() {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder("LineBreak(strategy=");
        int r1 = this.mask;
        sb.append((Object) Strategy.m554toStringimpl(r1 & 255));
        sb.append(", strictness=");
        sb.append((Object) Strictness.m555toStringimpl((r1 >> 8) & 255));
        sb.append(", wordBreak=");
        int r12 = (r1 >> 16) & 255;
        boolean z2 = false;
        if (r12 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "WordBreak.None";
        } else {
            if (r12 == 2) {
                z2 = true;
            }
            if (z2) {
                str = "WordBreak.Phrase";
            } else {
                str = "Invalid";
            }
        }
        sb.append((Object) str);
        sb.append(')');
        return sb.toString();
    }
}
