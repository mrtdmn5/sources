package androidx.compose.ui.graphics;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;

/* compiled from: Shadow.kt */
/* loaded from: classes.dex */
public final class Shadow {
    public static final Shadow None = new Shadow();
    public final float blurRadius;
    public final long color;
    public final long offset;

    public Shadow(long j, long j2, float f) {
        this.color = j;
        this.offset = j2;
        this.blurRadius = f;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        if (!Color.m317equalsimpl0(this.color, shadow.color) || !Offset.m257equalsimpl0(this.offset, shadow.offset)) {
            return false;
        }
        if (this.blurRadius == shadow.blurRadius) {
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
        int r0 = Color.$r8$clinit;
        int hashCode = Long.hashCode(this.color) * 31;
        int r1 = Offset.$r8$clinit;
        return Float.hashCode(this.blurRadius) + Scale$$ExternalSyntheticOutline0.m(this.offset, hashCode, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Shadow(color=");
        sb.append((Object) Color.m323toStringimpl(this.color));
        sb.append(", offset=");
        sb.append((Object) Offset.m264toStringimpl(this.offset));
        sb.append(", blurRadius=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.blurRadius, ')');
    }

    public Shadow() {
        this(ColorKt.Color(4278190080L), Offset.Zero, 0.0f);
    }
}
