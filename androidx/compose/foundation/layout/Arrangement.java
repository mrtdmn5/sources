package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement {
    public static final Arrangement$Start$1 Start = new Arrangement$Start$1();
    public static final Arrangement$End$1 End = new Arrangement$End$1();
    public static final Arrangement$Top$1 Top = new Arrangement$Top$1();
    public static final Arrangement$Bottom$1 Bottom = new Arrangement$Bottom$1();
    public static final Arrangement$Center$1 Center = new Arrangement$Center$1();
    public static final Arrangement$SpaceEvenly$1 SpaceEvenly = new Arrangement$SpaceEvenly$1();
    public static final Arrangement$SpaceBetween$1 SpaceBetween = new Arrangement$SpaceBetween$1();
    public static final Arrangement$SpaceAround$1 SpaceAround = new Arrangement$SpaceAround$1();

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public interface Horizontal {
        void arrange(int r1, Density density, LayoutDirection layoutDirection, int[] r4, int[] r5);

        /* renamed from: getSpacing-D9Ej5fM */
        default float mo61getSpacingD9Ej5fM() {
            return 0;
        }
    }

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public interface Vertical {
        void arrange(Density density, int r2, int[] r3, int[] r4);

        /* renamed from: getSpacing-D9Ej5fM */
        default float mo61getSpacingD9Ej5fM() {
            return 0;
        }
    }

    public static void placeCenter$foundation_layout_release(int r5, int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r1 = 0;
        int r3 = 0;
        for (int r0 : size) {
            r3 += r0;
        }
        float f = (r5 - r3) / 2;
        if (!z) {
            int length = size.length;
            int r02 = 0;
            while (r1 < length) {
                int r2 = size[r1];
                outPosition[r02] = MathKt__MathJVMKt.roundToInt(f);
                f += r2;
                r1++;
                r02++;
            }
            return;
        }
        for (int length2 = size.length - 1; -1 < length2; length2--) {
            int r12 = size[length2];
            outPosition[length2] = MathKt__MathJVMKt.roundToInt(f);
            f += r12;
        }
    }

    public static void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r0 = 0;
        if (!z) {
            int length = size.length;
            int r1 = 0;
            int r2 = 0;
            while (r0 < length) {
                int r3 = size[r0];
                outPosition[r1] = r2;
                r2 += r3;
                r0++;
                r1++;
            }
            return;
        }
        for (int length2 = size.length - 1; -1 < length2; length2--) {
            int r22 = size[length2];
            outPosition[length2] = r0;
            r0 += r22;
        }
    }

    public static void placeRightOrBottom$foundation_layout_release(int r5, int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r1 = 0;
        int r3 = 0;
        for (int r0 : size) {
            r3 += r0;
        }
        int r52 = r5 - r3;
        if (!z) {
            int length = size.length;
            int r02 = 0;
            while (r1 < length) {
                int r2 = size[r1];
                outPosition[r02] = r52;
                r52 += r2;
                r1++;
                r02++;
            }
            return;
        }
        for (int length2 = size.length - 1; -1 < length2; length2--) {
            int r12 = size[length2];
            outPosition[length2] = r52;
            r52 += r12;
        }
    }

    public static void placeSpaceAround$foundation_layout_release(int r6, int[] size, int[] outPosition, boolean z) {
        boolean z2;
        float f;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r1 = 0;
        int r3 = 0;
        for (int r0 : size) {
            r3 += r0;
        }
        if (size.length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            f = (r6 - r3) / size.length;
        } else {
            f = 0.0f;
        }
        float f2 = f / 2;
        if (!z) {
            int length = size.length;
            int r2 = 0;
            while (r1 < length) {
                int r32 = size[r1];
                outPosition[r2] = MathKt__MathJVMKt.roundToInt(f2);
                f2 += r32 + f;
                r1++;
                r2++;
            }
            return;
        }
        for (int length2 = size.length - 1; -1 < length2; length2--) {
            int r12 = size[length2];
            outPosition[length2] = MathKt__MathJVMKt.roundToInt(f2);
            f2 += r12 + f;
        }
    }

    public static void placeSpaceBetween$foundation_layout_release(int r6, int[] size, int[] outPosition, boolean z) {
        boolean z2;
        float f;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r1 = 0;
        if (size.length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        int r4 = 0;
        for (int r0 : size) {
            r4 += r0;
        }
        float max = (r6 - r4) / Math.max(size.length - 1, 1);
        if (z && size.length == 1) {
            f = max;
        } else {
            f = 0.0f;
        }
        if (!z) {
            int length = size.length;
            int r2 = 0;
            while (r1 < length) {
                int r3 = size[r1];
                outPosition[r2] = MathKt__MathJVMKt.roundToInt(f);
                f += r3 + max;
                r1++;
                r2++;
            }
            return;
        }
        for (int length2 = size.length - 1; -1 < length2; length2--) {
            int r12 = size[length2];
            outPosition[length2] = MathKt__MathJVMKt.roundToInt(f);
            f += r12 + max;
        }
    }

    public static void placeSpaceEvenly$foundation_layout_release(int r6, int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int r1 = 0;
        int r3 = 0;
        for (int r0 : size) {
            r3 += r0;
        }
        float length = (r6 - r3) / (size.length + 1);
        if (!z) {
            int length2 = size.length;
            float f = length;
            int r02 = 0;
            while (r1 < length2) {
                int r32 = size[r1];
                outPosition[r02] = MathKt__MathJVMKt.roundToInt(f);
                f += r32 + length;
                r1++;
                r02++;
            }
            return;
        }
        float f2 = length;
        for (int length3 = size.length - 1; -1 < length3; length3--) {
            int r2 = size[length3];
            outPosition[length3] = MathKt__MathJVMKt.roundToInt(f2);
            f2 += r2 + length;
        }
    }

    /* renamed from: spacedBy-0680j_4, reason: not valid java name */
    public static SpacedAligned m60spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, Arrangement$spacedBy$1.INSTANCE);
    }

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public static final class SpacedAligned implements Horizontal, Vertical {
        public final Function2<Integer, LayoutDirection, Integer> alignment;
        public final boolean rtlMirror;
        public final float space;
        public final float spacing;

        public SpacedAligned() {
            throw null;
        }

        public SpacedAligned(float f, boolean z, Arrangement$spacedBy$1 arrangement$spacedBy$1) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = arrangement$spacedBy$1;
            this.spacing = f;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public final void arrange(int r10, Density density, LayoutDirection layoutDirection, int[] sizes, int[] outPositions) {
            int r3;
            int r4;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (sizes.length == 0) {
                return;
            }
            int mo44roundToPx0680j_4 = density.mo44roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement$Start$1 arrangement$Start$1 = Arrangement.Start;
            if (!z) {
                int length = sizes.length;
                int r1 = 0;
                r3 = 0;
                r4 = 0;
                int r5 = 0;
                while (r1 < length) {
                    int r42 = sizes[r1];
                    int min = Math.min(r3, r10 - r42);
                    outPositions[r5] = min;
                    int min2 = Math.min(mo44roundToPx0680j_4, (r10 - min) - r42);
                    int r43 = outPositions[r5] + r42 + min2;
                    r1++;
                    r5++;
                    r4 = min2;
                    r3 = r43;
                }
            } else {
                r3 = 0;
                r4 = 0;
                for (int length2 = sizes.length - 1; -1 < length2; length2--) {
                    int r12 = sizes[length2];
                    int min3 = Math.min(r3, r10 - r12);
                    outPositions[length2] = min3;
                    r4 = Math.min(mo44roundToPx0680j_4, (r10 - min3) - r12);
                    r3 = outPositions[length2] + r12 + r4;
                }
            }
            int r32 = r3 - r4;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null || r32 >= r10) {
                return;
            }
            int intValue = function2.invoke(Integer.valueOf(r10 - r32), layoutDirection).intValue();
            int length3 = outPositions.length;
            for (int r2 = 0; r2 < length3; r2++) {
                outPositions[r2] = outPositions[r2] + intValue;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            if (Dp.m579equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment)) {
                return true;
            }
            return false;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public final float mo61getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode;
            int hashCode2 = Float.hashCode(this.space) * 31;
            boolean z = this.rtlMirror;
            int r1 = z;
            if (z != 0) {
                r1 = 1;
            }
            int r0 = (hashCode2 + r1) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null) {
                hashCode = 0;
            } else {
                hashCode = function2.hashCode();
            }
            return r0 + hashCode;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            if (this.rtlMirror) {
                str = "";
            } else {
                str = "Absolute";
            }
            sb.append(str);
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m580toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public final void arrange(Density density, int r9, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            arrange(r9, density, LayoutDirection.Ltr, sizes, outPositions);
        }
    }
}
