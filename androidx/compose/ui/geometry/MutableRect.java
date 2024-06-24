package androidx.compose.ui.geometry;

/* compiled from: MutableRect.kt */
/* loaded from: classes.dex */
public final class MutableRect {
    public float left = 0.0f;
    public float top = 0.0f;
    public float right = 0.0f;
    public float bottom = 0.0f;

    public final void intersect(float f, float f2, float f3, float f4) {
        this.left = Math.max(f, this.left);
        this.top = Math.max(f2, this.top);
        this.right = Math.min(f3, this.right);
        this.bottom = Math.min(f4, this.bottom);
    }

    public final boolean isEmpty() {
        if (this.left < this.right && this.top < this.bottom) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom) + ')';
    }
}
