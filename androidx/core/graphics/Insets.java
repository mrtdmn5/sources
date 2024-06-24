package androidx.core.graphics;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class Insets {
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static android.graphics.Insets of(int r0, int r1, int r2, int r3) {
            return android.graphics.Insets.of(r0, r1, r2, r3);
        }
    }

    public Insets(int r1, int r2, int r3, int r4) {
        this.left = r1;
        this.top = r2;
        this.right = r3;
        this.bottom = r4;
    }

    public static Insets max(Insets insets, Insets insets2) {
        return of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    public static Insets of(int r1, int r2, int r3, int r4) {
        if (r1 == 0 && r2 == 0 && r3 == 0 && r4 == 0) {
            return NONE;
        }
        return new Insets(r1, r2, r3, r4);
    }

    public static Insets toCompatInsets(android.graphics.Insets insets) {
        int r0;
        int r1;
        int r2;
        int r3;
        r0 = insets.left;
        r1 = insets.top;
        r2 = insets.right;
        r3 = insets.bottom;
        return of(r0, r1, r2, r3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        if (this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.bottom, '}');
    }
}
