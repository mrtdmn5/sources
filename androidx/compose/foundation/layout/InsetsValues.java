package androidx.compose.foundation.layout;

/* compiled from: WindowInsets.kt */
/* loaded from: classes.dex */
public final class InsetsValues {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public InsetsValues(int r1, int r2, int r3, int r4) {
        this.left = r1;
        this.top = r2;
        this.right = r3;
        this.bottom = r4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsValues)) {
            return false;
        }
        InsetsValues insetsValues = (InsetsValues) obj;
        if (this.left == insetsValues.left && this.top == insetsValues.top && this.right == insetsValues.right && this.bottom == insetsValues.bottom) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InsetsValues(left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.bottom, ')');
    }
}
