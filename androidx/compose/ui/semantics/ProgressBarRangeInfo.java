package androidx.compose.ui.semantics;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.ClosedFloatingPointRange;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class ProgressBarRangeInfo {
    public static final ProgressBarRangeInfo Indeterminate = new ProgressBarRangeInfo(0.0f, new ClosedFloatRange(0.0f, 0.0f), 0);
    public final float current;
    public final ClosedFloatingPointRange<Float> range;
    public final int steps;

    public ProgressBarRangeInfo(float f, ClosedFloatingPointRange<Float> range, int r4) {
        Intrinsics.checkNotNullParameter(range, "range");
        this.current = f;
        this.range = range;
        this.steps = r4;
        if (!Float.isNaN(f)) {
        } else {
            throw new IllegalArgumentException("current must not be NaN".toString());
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarRangeInfo)) {
            return false;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
        if (this.current == progressBarRangeInfo.current) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(this.range, progressBarRangeInfo.range) && this.steps == progressBarRangeInfo.steps) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.range.hashCode() + (Float.hashCode(this.current) * 31)) * 31) + this.steps;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProgressBarRangeInfo(current=");
        sb.append(this.current);
        sb.append(", range=");
        sb.append(this.range);
        sb.append(", steps=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.steps, ')');
    }
}
