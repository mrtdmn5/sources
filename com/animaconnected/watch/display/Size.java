package com.animaconnected.watch.display;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public final class Size {
    private final float height;
    private final float width;

    public Size(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    public static /* synthetic */ Size copy$default(Size size, float f, float f2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            f = size.width;
        }
        if ((r3 & 2) != 0) {
            f2 = size.height;
        }
        return size.copy(f, f2);
    }

    public final float component1() {
        return this.width;
    }

    public final float component2() {
        return this.height;
    }

    public final Size copy(float f, float f2) {
        return new Size(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (Float.compare(this.width, size.width) == 0 && Float.compare(this.height, size.height) == 0) {
            return true;
        }
        return false;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Float.hashCode(this.height) + (Float.hashCode(this.width) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Size(width=");
        sb.append(this.width);
        sb.append(", height=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.height, ')');
    }
}
