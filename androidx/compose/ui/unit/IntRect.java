package androidx.compose.ui.unit;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: IntRect.kt */
/* loaded from: classes.dex */
public final class IntRect {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public IntRect(int r1, int r2, int r3, int r4) {
        this.left = r1;
        this.top = r2;
        this.right = r3;
        this.bottom = r4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) obj;
        if (this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.bottom) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.right, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IntRect.fromLTRB(");
        sb.append(this.left);
        sb.append(", ");
        sb.append(this.top);
        sb.append(", ");
        sb.append(this.right);
        sb.append(", ");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.bottom, ')');
    }
}
