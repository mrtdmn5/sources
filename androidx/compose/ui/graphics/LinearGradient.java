package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush {
    public final List<Color> colors;
    public final long end;
    public final long start;
    public final List<Float> stops = null;
    public final int tileMode;

    public LinearGradient(List list, long j, long j2, int r6) {
        this.colors = list;
        this.start = j;
        this.end = j2;
        this.tileMode = r6;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* renamed from: createShader-uvyYCjk */
    public final Shader mo312createShaderuvyYCjk(long j) {
        boolean z;
        float m259getXimpl;
        boolean z2;
        float m260getYimpl;
        boolean z3;
        float m259getXimpl2;
        boolean z4;
        float m260getYimpl2;
        int r14;
        boolean z5;
        int[] r21;
        boolean z6;
        int r10;
        long Color;
        long Color2;
        long Color3;
        long Color4;
        char c;
        float f;
        float f2;
        float[] fArr;
        float lastIndex;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        Shader.TileMode tileMode;
        float[] fArr2;
        long j2 = this.start;
        if (Offset.m259getXimpl(j2) == Float.POSITIVE_INFINITY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            m259getXimpl = Size.m276getWidthimpl(j);
        } else {
            m259getXimpl = Offset.m259getXimpl(j2);
        }
        if (Offset.m260getYimpl(j2) == Float.POSITIVE_INFINITY) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            m260getYimpl = Size.m274getHeightimpl(j);
        } else {
            m260getYimpl = Offset.m260getYimpl(j2);
        }
        long j3 = this.end;
        if (Offset.m259getXimpl(j3) == Float.POSITIVE_INFINITY) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            m259getXimpl2 = Size.m276getWidthimpl(j);
        } else {
            m259getXimpl2 = Offset.m259getXimpl(j3);
        }
        if (Offset.m260getYimpl(j3) == Float.POSITIVE_INFINITY) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            m260getYimpl2 = Size.m274getHeightimpl(j);
        } else {
            m260getYimpl2 = Offset.m260getYimpl(j3);
        }
        long Offset = OffsetKt.Offset(m259getXimpl, m260getYimpl);
        long Offset2 = OffsetKt.Offset(m259getXimpl2, m260getYimpl2);
        List<Color> colors = this.colors;
        Intrinsics.checkNotNullParameter(colors, "colors");
        List<Float> list = this.stops;
        if (list == null) {
            if (colors.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (colors.size() != list.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            r14 = 0;
        } else {
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(colors);
            r14 = 0;
            for (int r13 = 1; r13 < lastIndex2; r13++) {
                if (Color.m318getAlphaimpl(colors.get(r13).value) == 0.0f) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    r14++;
                }
            }
        }
        float m259getXimpl3 = Offset.m259getXimpl(Offset);
        float m260getYimpl3 = Offset.m260getYimpl(Offset);
        float m259getXimpl4 = Offset.m259getXimpl(Offset2);
        float m260getYimpl4 = Offset.m260getYimpl(Offset2);
        if (Build.VERSION.SDK_INT >= 26) {
            int size = colors.size();
            int[] r2 = new int[size];
            for (int r5 = 0; r5 < size; r5++) {
                r2[r5] = ColorKt.m327toArgb8_81llA(colors.get(r5).value);
            }
            r21 = r2;
        } else {
            int[] r1 = new int[colors.size() + r14];
            int lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(colors);
            int size2 = colors.size();
            int r8 = 0;
            for (int r7 = 0; r7 < size2; r7++) {
                long j4 = colors.get(r7).value;
                if (Color.m318getAlphaimpl(j4) == 0.0f) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    if (r7 == 0) {
                        r10 = r8 + 1;
                        Color4 = ColorKt.Color(Color.m322getRedimpl(r12), Color.m321getGreenimpl(r12), Color.m319getBlueimpl(r12), 0.0f, Color.m320getColorSpaceimpl(colors.get(1).value));
                        r1[r8] = ColorKt.m327toArgb8_81llA(Color4);
                    } else if (r7 == lastIndex3) {
                        r10 = r8 + 1;
                        Color3 = ColorKt.Color(Color.m322getRedimpl(r12), Color.m321getGreenimpl(r12), Color.m319getBlueimpl(r12), 0.0f, Color.m320getColorSpaceimpl(colors.get(r7 - 1).value));
                        r1[r8] = ColorKt.m327toArgb8_81llA(Color3);
                    } else {
                        int r102 = r8 + 1;
                        Color = ColorKt.Color(Color.m322getRedimpl(r12), Color.m321getGreenimpl(r12), Color.m319getBlueimpl(r12), 0.0f, Color.m320getColorSpaceimpl(colors.get(r7 - 1).value));
                        r1[r8] = ColorKt.m327toArgb8_81llA(Color);
                        r8 = r102 + 1;
                        Color2 = ColorKt.Color(Color.m322getRedimpl(r12), Color.m321getGreenimpl(r12), Color.m319getBlueimpl(r12), 0.0f, Color.m320getColorSpaceimpl(colors.get(r7 + 1).value));
                        r1[r102] = ColorKt.m327toArgb8_81llA(Color2);
                    }
                } else {
                    r10 = r8 + 1;
                    r1[r8] = ColorKt.m327toArgb8_81llA(j4);
                }
                r8 = r10;
            }
            r21 = r1;
        }
        if (r14 == 0) {
            if (list != null) {
                List<Float> list2 = list;
                fArr2 = new float[list2.size()];
                Iterator<Float> it = list2.iterator();
                int r3 = 0;
                while (it.hasNext()) {
                    fArr2[r3] = it.next().floatValue();
                    r3++;
                }
            } else {
                fArr2 = null;
            }
            fArr = fArr2;
            c = 0;
        } else {
            float[] fArr3 = new float[colors.size() + r14];
            if (list != null) {
                c = 0;
                f = list.get(0).floatValue();
            } else {
                c = 0;
                f = 0.0f;
            }
            fArr3[c] = f;
            int lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(colors);
            int r82 = 1;
            for (int r72 = 1; r72 < lastIndex4; r72++) {
                long j5 = colors.get(r72).value;
                if (list != null) {
                    lastIndex = list.get(r72).floatValue();
                } else {
                    lastIndex = r72 / CollectionsKt__CollectionsKt.getLastIndex(colors);
                }
                int r142 = r82 + 1;
                fArr3[r82] = lastIndex;
                if (Color.m318getAlphaimpl(j5) == 0.0f) {
                    c2 = 1;
                } else {
                    c2 = c;
                }
                if (c2 != 0) {
                    r82 = r142 + 1;
                    fArr3[r142] = lastIndex;
                } else {
                    r82 = r142;
                }
            }
            if (list != null) {
                f2 = list.get(CollectionsKt__CollectionsKt.getLastIndex(colors)).floatValue();
            } else {
                f2 = 1.0f;
            }
            fArr3[r82] = f2;
            fArr = fArr3;
        }
        int r12 = this.tileMode;
        if (r12 == 0) {
            c3 = 1;
        } else {
            c3 = c;
        }
        if (c3 != 0) {
            tileMode = Shader.TileMode.CLAMP;
        } else {
            if (r12 == 1) {
                c4 = 1;
            } else {
                c4 = c;
            }
            if (c4 != 0) {
                tileMode = Shader.TileMode.REPEAT;
            } else {
                if (r12 == 2) {
                    c5 = 1;
                } else {
                    c5 = c;
                }
                if (c5 != 0) {
                    tileMode = Shader.TileMode.MIRROR;
                } else {
                    if (r12 == 3) {
                        c6 = 1;
                    } else {
                        c6 = c;
                    }
                    if (c6 != 0) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            tileMode = TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
                        } else {
                            tileMode = Shader.TileMode.CLAMP;
                        }
                    } else {
                        tileMode = Shader.TileMode.CLAMP;
                    }
                }
            }
        }
        return new android.graphics.LinearGradient(m259getXimpl3, m260getYimpl3, m259getXimpl4, m260getYimpl4, r21, fArr, tileMode);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        if (!Intrinsics.areEqual(this.colors, linearGradient.colors) || !Intrinsics.areEqual(this.stops, linearGradient.stops) || !Offset.m257equalsimpl0(this.start, linearGradient.start) || !Offset.m257equalsimpl0(this.end, linearGradient.end)) {
            return false;
        }
        if (this.tileMode == linearGradient.tileMode) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        if (list != null) {
            r1 = list.hashCode();
        } else {
            r1 = 0;
        }
        int r0 = (hashCode + r1) * 31;
        int r12 = Offset.$r8$clinit;
        return Integer.hashCode(this.tileMode) + Scale$$ExternalSyntheticOutline0.m(this.end, Scale$$ExternalSyntheticOutline0.m(this.start, r0, 31), 31);
    }

    public final String toString() {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        long j = this.start;
        String str3 = "";
        if (!OffsetKt.m265isFinitek4lQ0M(j)) {
            str = "";
        } else {
            str = "start=" + ((Object) Offset.m264toStringimpl(j)) + ", ";
        }
        long j2 = this.end;
        if (OffsetKt.m265isFinitek4lQ0M(j2)) {
            str3 = "end=" + ((Object) Offset.m264toStringimpl(j2)) + ", ";
        }
        StringBuilder sb = new StringBuilder("LinearGradient(colors=");
        sb.append(this.colors);
        sb.append(", stops=");
        sb.append(this.stops);
        sb.append(", ");
        sb.append(str);
        sb.append(str3);
        sb.append("tileMode=");
        int r0 = this.tileMode;
        boolean z4 = false;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str2 = "Clamp";
        } else {
            if (r0 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str2 = "Repeated";
            } else {
                if (r0 == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str2 = "Mirror";
                } else {
                    if (r0 == 3) {
                        z4 = true;
                    }
                    if (z4) {
                        str2 = "Decal";
                    } else {
                        str2 = "Unknown";
                    }
                }
            }
        }
        sb.append((Object) str2);
        sb.append(')');
        return sb.toString();
    }
}
