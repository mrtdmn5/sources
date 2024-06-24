package androidx.compose.ui.text.style;

/* compiled from: LineHeightStyle.kt */
/* loaded from: classes.dex */
public final class LineHeightStyle {
    public static final LineHeightStyle Default = new LineHeightStyle(Alignment.Proportional);
    public final float alignment;
    public final int trim = 17;

    /* compiled from: LineHeightStyle.kt */
    /* loaded from: classes.dex */
    public static final class Alignment {
        public static final float Bottom;
        public static final float Center;
        public static final float Proportional;

        static {
            m556constructorimpl(0.0f);
            m556constructorimpl(0.5f);
            Center = 0.5f;
            m556constructorimpl(-1.0f);
            Proportional = -1.0f;
            m556constructorimpl(1.0f);
            Bottom = 1.0f;
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static void m556constructorimpl(float f) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            if (0.0f <= f && f <= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (f == -1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z3 = false;
                }
            }
            if (z3) {
            } else {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
            }
        }
    }

    public LineHeightStyle(float f) {
        this.alignment = f;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        float f = lineHeightStyle.alignment;
        float f2 = Alignment.Center;
        if (Float.compare(this.alignment, f) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.trim == lineHeightStyle.trim) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        float f = Alignment.Center;
        return Integer.hashCode(this.trim) + (Float.hashCode(this.alignment) * 31);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("LineHeightStyle(alignment=");
        float f = Alignment.Center;
        float f2 = this.alignment;
        boolean z4 = false;
        if (f2 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "LineHeightStyle.Alignment.Top";
        } else {
            if (f2 == Alignment.Center) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = "LineHeightStyle.Alignment.Center";
            } else {
                if (f2 == Alignment.Proportional) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str = "LineHeightStyle.Alignment.Proportional";
                } else {
                    if (f2 == Alignment.Bottom) {
                        z4 = true;
                    }
                    if (z4) {
                        str = "LineHeightStyle.Alignment.Bottom";
                    } else {
                        str = "LineHeightStyle.Alignment(topPercentage = " + f2 + ')';
                    }
                }
            }
        }
        sb.append((Object) str);
        sb.append(", trim=");
        int r1 = this.trim;
        if (r1 == 1) {
            str2 = "LineHeightStyle.Trim.FirstLineTop";
        } else if (r1 == 16) {
            str2 = "LineHeightStyle.Trim.LastLineBottom";
        } else if (r1 == 17) {
            str2 = "LineHeightStyle.Trim.Both";
        } else if (r1 == 0) {
            str2 = "LineHeightStyle.Trim.None";
        } else {
            str2 = "Invalid";
        }
        sb.append((Object) str2);
        sb.append(')');
        return sb.toString();
    }
}
