package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.runtime.collection.MutableVector;

/* compiled from: LazyLayoutBeyondBoundsInfo.kt */
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsInfo {
    public final MutableVector<Interval> beyondBoundsItems = new MutableVector<>(new Interval[16]);

    /* compiled from: LazyLayoutBeyondBoundsInfo.kt */
    /* loaded from: classes.dex */
    public static final class Interval {
        public final int end;
        public final int start;

        public Interval(int r5, int r6) {
            boolean z;
            this.start = r5;
            this.end = r6;
            if (r5 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (r6 >= r5) {
                    return;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            if (this.start == interval.start && this.end == interval.end) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.end) + (Integer.hashCode(this.start) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Interval(start=");
            sb.append(this.start);
            sb.append(", end=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.end, ')');
        }
    }
}
