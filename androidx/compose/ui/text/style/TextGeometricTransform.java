package androidx.compose.ui.text.style;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;

/* compiled from: TextGeometricTransform.kt */
/* loaded from: classes.dex */
public final class TextGeometricTransform {
    public static final TextGeometricTransform None = new TextGeometricTransform(1.0f, 0.0f);
    public final float scaleX;
    public final float skewX;

    public TextGeometricTransform(float f, float f2) {
        this.scaleX = f;
        this.skewX = f2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextGeometricTransform)) {
            return false;
        }
        TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj;
        if (this.scaleX == textGeometricTransform.scaleX) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.skewX == textGeometricTransform.skewX) {
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
        return Float.hashCode(this.skewX) + (Float.hashCode(this.scaleX) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextGeometricTransform(scaleX=");
        sb.append(this.scaleX);
        sb.append(", skewX=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.skewX, ')');
    }

    public TextGeometricTransform() {
        this(1.0f, 0.0f);
    }
}
