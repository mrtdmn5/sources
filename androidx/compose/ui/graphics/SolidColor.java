package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public final class SolidColor extends Brush {
    public final long value;

    public SolidColor(long j) {
        this.value = j;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo310applyToPq9zytI(float f, long j, Paint p) {
        boolean z;
        Intrinsics.checkNotNullParameter(p, "p");
        p.setAlpha(1.0f);
        if (f == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        long j2 = this.value;
        if (!z) {
            j2 = ColorKt.Color(Color.m322getRedimpl(j2), Color.m321getGreenimpl(j2), Color.m319getBlueimpl(j2), Color.m318getAlphaimpl(j2) * f, Color.m320getColorSpaceimpl(j2));
        }
        p.mo298setColor8_81llA(j2);
        if (p.getShader() != null) {
            p.setShader(null);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SolidColor)) {
            return false;
        }
        if (Color.m317equalsimpl0(this.value, ((SolidColor) obj).value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) Color.m323toStringimpl(this.value)) + ')';
    }
}
