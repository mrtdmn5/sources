package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes.dex */
public final class CharRange extends CharProgression implements ClosedRange<Character> {
    static {
        new CharRange((char) 1, (char) 0);
    }

    public final boolean contains(char c) {
        return Intrinsics.compare(this.first, c) <= 0 && Intrinsics.compare(c, this.last) <= 0;
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ boolean contains(Character ch) {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                if (this.first == charRange.first) {
                    if (this.last == charRange.last) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Character getEndInclusive() {
        return Character.valueOf(this.last);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Character getStart() {
        return Character.valueOf(this.first);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (Intrinsics.compare(this.first, this.last) > 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.first + ".." + this.last;
    }
}
