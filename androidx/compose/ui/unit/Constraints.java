package androidx.compose.ui.unit;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;

/* compiled from: Constraints.kt */
/* loaded from: classes.dex */
public final class Constraints {
    public final long value;
    public static final int[] MinHeightOffsets = {18, 20, 17, 15};
    public static final int[] WidthMask = {65535, 262143, 32767, 8191};
    public static final int[] HeightMask = {32767, 8191, 65535, 262143};

    /* compiled from: Constraints.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static int bitsNeedForSize(int r3) {
            if (r3 < 8191) {
                return 13;
            }
            if (r3 < 32767) {
                return 15;
            }
            if (r3 < 65535) {
                return 16;
            }
            if (r3 < 262143) {
                return 18;
            }
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Can't represent a size of ", r3, " in Constraints"));
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release, reason: not valid java name */
        public static long m569createConstraintsZbe2FdA$ui_unit_release(int r6, int r7, int r8, int r9) {
            int r1;
            int r3;
            long j;
            int r72;
            if (r9 == Integer.MAX_VALUE) {
                r1 = r8;
            } else {
                r1 = r9;
            }
            int bitsNeedForSize = bitsNeedForSize(r1);
            if (r7 == Integer.MAX_VALUE) {
                r3 = r6;
            } else {
                r3 = r7;
            }
            int bitsNeedForSize2 = bitsNeedForSize(r3);
            if (bitsNeedForSize + bitsNeedForSize2 <= 31) {
                if (bitsNeedForSize2 != 13) {
                    if (bitsNeedForSize2 != 18) {
                        if (bitsNeedForSize2 != 15) {
                            if (bitsNeedForSize2 == 16) {
                                j = 0;
                            } else {
                                throw new IllegalStateException("Should only have the provided constants.");
                            }
                        } else {
                            j = 2;
                        }
                    } else {
                        j = 1;
                    }
                } else {
                    j = 3;
                }
                int r32 = 0;
                if (r7 == Integer.MAX_VALUE) {
                    r72 = 0;
                } else {
                    r72 = r7 + 1;
                }
                if (r9 != Integer.MAX_VALUE) {
                    r32 = r9 + 1;
                }
                int r92 = Constraints.MinHeightOffsets[(int) j];
                return (r72 << 33) | j | (r6 << 2) | (r8 << r92) | (r32 << (r92 + 31));
            }
            throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Can't represent a width of ", r3, " and height of ", r1, " in Constraints"));
        }

        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public static long m570fixedJhjzzOo(int r3, int r4) {
            boolean z;
            if (r3 >= 0 && r4 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return m569createConstraintsZbe2FdA$ui_unit_release(r3, r3, r4, r4);
            }
            throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("width(", r3, ") and height(", r4, ") must be >= 0").toString());
        }

        /* renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public static long m571fixedHeightOenEA2s(int r2) {
            boolean z;
            if (r2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return m569createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, r2, r2);
            }
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("height(", r2, ") must be >= 0").toString());
        }

        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public static long m572fixedWidthOenEA2s(int r2) {
            boolean z;
            if (r2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return m569createConstraintsZbe2FdA$ui_unit_release(r2, r2, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("width(", r2, ") must be >= 0").toString());
        }
    }

    public /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static long m558copyZbe2FdA$default(long j, int r4, int r5, int r6, int r7, int r8) {
        boolean z;
        boolean z2;
        if ((r8 & 1) != 0) {
            r4 = m567getMinWidthimpl(j);
        }
        if ((r8 & 2) != 0) {
            r5 = m565getMaxWidthimpl(j);
        }
        if ((r8 & 4) != 0) {
            r6 = m566getMinHeightimpl(j);
        }
        if ((r8 & 8) != 0) {
            r7 = m564getMaxHeightimpl(j);
        }
        boolean z3 = true;
        if (r6 >= 0 && r4 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r5 < r4 && r5 != Integer.MAX_VALUE) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (r7 < r6 && r7 != Integer.MAX_VALUE) {
                    z3 = false;
                }
                if (z3) {
                    return Companion.m569createConstraintsZbe2FdA$ui_unit_release(r4, r5, r6, r7);
                }
                throw new IllegalArgumentException(("maxHeight(" + r7 + ") must be >= minHeight(" + r6 + ')').toString());
            }
            throw new IllegalArgumentException(("maxWidth(" + r5 + ") must be >= minWidth(" + r4 + ')').toString());
        }
        throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("minHeight(", r6, ") and minWidth(", r4, ") must be >= 0").toString());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m559equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m560getHasBoundedHeightimpl(long j) {
        int r0 = (int) (3 & j);
        if ((((int) (j >> (MinHeightOffsets[r0] + 31))) & HeightMask[r0]) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m561getHasBoundedWidthimpl(long j) {
        if ((((int) (j >> 33)) & WidthMask[(int) (3 & j)]) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m562getHasFixedHeightimpl(long j) {
        if (m564getMaxHeightimpl(j) == m566getMinHeightimpl(j)) {
            return true;
        }
        return false;
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m563getHasFixedWidthimpl(long j) {
        if (m565getMaxWidthimpl(j) == m567getMinWidthimpl(j)) {
            return true;
        }
        return false;
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m564getMaxHeightimpl(long j) {
        int r0 = (int) (3 & j);
        int r3 = ((int) (j >> (MinHeightOffsets[r0] + 31))) & HeightMask[r0];
        if (r3 == 0) {
            return Integer.MAX_VALUE;
        }
        return r3 - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m565getMaxWidthimpl(long j) {
        int r3 = ((int) (j >> 33)) & WidthMask[(int) (3 & j)];
        if (r3 == 0) {
            return Integer.MAX_VALUE;
        }
        return r3 - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m566getMinHeightimpl(long j) {
        int r0 = (int) (3 & j);
        return ((int) (j >> MinHeightOffsets[r0])) & HeightMask[r0];
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m567getMinWidthimpl(long j) {
        return ((int) (j >> 2)) & WidthMask[(int) (3 & j)];
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m568toStringimpl(long j) {
        String valueOf;
        int m565getMaxWidthimpl = m565getMaxWidthimpl(j);
        String str = "Infinity";
        if (m565getMaxWidthimpl == Integer.MAX_VALUE) {
            valueOf = "Infinity";
        } else {
            valueOf = String.valueOf(m565getMaxWidthimpl);
        }
        int m564getMaxHeightimpl = m564getMaxHeightimpl(j);
        if (m564getMaxHeightimpl != Integer.MAX_VALUE) {
            str = String.valueOf(m564getMaxHeightimpl);
        }
        return "Constraints(minWidth = " + m567getMinWidthimpl(j) + ", maxWidth = " + valueOf + ", minHeight = " + m566getMinHeightimpl(j) + ", maxHeight = " + str + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Constraints)) {
            return false;
        }
        if (this.value != ((Constraints) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m568toStringimpl(this.value);
    }
}
