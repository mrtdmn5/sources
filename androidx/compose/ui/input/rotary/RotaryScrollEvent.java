package androidx.compose.ui.input.rotary;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: RotaryScrollEvent.kt */
/* loaded from: classes.dex */
public final class RotaryScrollEvent {
    public final float horizontalScrollPixels;
    public final long uptimeMillis;
    public final float verticalScrollPixels;

    public RotaryScrollEvent(float f, float f2, long j) {
        this.verticalScrollPixels = f;
        this.horizontalScrollPixels = f2;
        this.uptimeMillis = j;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof RotaryScrollEvent)) {
            return false;
        }
        RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) obj;
        if (rotaryScrollEvent.verticalScrollPixels == this.verticalScrollPixels) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (rotaryScrollEvent.horizontalScrollPixels == this.horizontalScrollPixels) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || rotaryScrollEvent.uptimeMillis != this.uptimeMillis) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.uptimeMillis) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.horizontalScrollPixels, Float.hashCode(this.verticalScrollPixels) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RotaryScrollEvent(verticalScrollPixels=");
        sb.append(this.verticalScrollPixels);
        sb.append(",horizontalScrollPixels=");
        sb.append(this.horizontalScrollPixels);
        sb.append(",uptimeMillis=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.uptimeMillis, ')');
    }
}
