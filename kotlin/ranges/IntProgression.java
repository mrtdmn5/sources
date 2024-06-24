package kotlin.ranges;

import java.util.Iterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes.dex */
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    public final int first;
    public final int last;
    public final int step;

    public IntProgression(int r2, int r3, int r4) {
        if (r4 != 0) {
            if (r4 != Integer.MIN_VALUE) {
                this.first = r2;
                this.last = ProgressionUtilKt.getProgressionLastElement(r2, r3, r4);
                this.step = r4;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (this.first != intProgression.first || this.last != intProgression.last || this.step != intProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        int r0 = this.step;
        int r3 = this.last;
        int r4 = this.first;
        if (r0 > 0) {
            if (r4 > r3) {
                return true;
            }
        } else if (r4 < r3) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int r1 = this.last;
        int r2 = this.first;
        int r3 = this.step;
        if (r3 > 0) {
            sb = new StringBuilder();
            sb.append(r2);
            sb.append("..");
            sb.append(r1);
            sb.append(" step ");
            sb.append(r3);
        } else {
            sb = new StringBuilder();
            sb.append(r2);
            sb.append(" downTo ");
            sb.append(r1);
            sb.append(" step ");
            sb.append(-r3);
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new IntProgressionIterator(this.first, this.last, this.step);
    }
}
