package androidx.compose.ui.graphics.colorspace;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorSpace.kt */
/* loaded from: classes.dex */
public abstract class ColorSpace {
    public final int id;
    public final long model;
    public final String name;

    public ColorSpace(String name, long j, int r5) {
        boolean z;
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.model = j;
        this.id = r5;
        if (name.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (r5 >= -1 && r5 <= 63) {
                return;
            } else {
                throw new IllegalArgumentException("The id must be between -1 and 63");
            }
        }
        throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.id != colorSpace.id || !Intrinsics.areEqual(this.name, colorSpace.name)) {
            return false;
        }
        return ColorModel.m348equalsimpl0(this.model, colorSpace.model);
    }

    public abstract float[] fromXyz(float[] fArr);

    public abstract float getMaxValue(int r1);

    public abstract float getMinValue(int r1);

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        int r1 = ColorModel.$r8$clinit;
        return Scale$$ExternalSyntheticOutline0.m(this.model, hashCode, 31) + this.id;
    }

    public boolean isSrgb() {
        return false;
    }

    public final String toString() {
        return this.name + " (id=" + this.id + ", model=" + ((Object) ColorModel.m349toStringimpl(this.model)) + ')';
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float[] xyz = toXyz(new float[]{f, f2, f3});
        return (Float.floatToIntBits(xyz[0]) << 32) | (Float.floatToIntBits(xyz[1]) & 4294967295L);
    }

    public abstract float[] toXyz(float[] fArr);

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return toXyz(new float[]{f, f2, f3})[2];
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release, reason: not valid java name */
    public long mo350xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        int r0 = ColorModel.$r8$clinit;
        float[] fArr = new float[(int) (this.model >> 32)];
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        float[] fromXyz = fromXyz(fArr);
        return ColorKt.Color(fromXyz[0], fromXyz[1], fromXyz[2], f4, colorSpace);
    }
}
