package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public final long first;
    public final long last;
    public final long step;

    public LongProgression(long j, long j2) {
        this.first = j;
        if (j < j2) {
            long j3 = j2 % 1;
            long j4 = j % 1;
            long j5 = ((j3 < 0 ? j3 + 1 : j3) - (j4 < 0 ? j4 + 1 : j4)) % 1;
            j2 -= j5 < 0 ? j5 + 1 : j5;
        }
        this.last = j2;
        this.step = 1L;
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }
}
