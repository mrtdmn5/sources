package kotlin.ranges;

import java.util.Iterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes.dex */
public class CharProgression implements Iterable<Character>, KMappedMarker {
    public final char first;
    public final char last;
    public final int step = 1;

    public CharProgression(char c, char c2) {
        this.first = c;
        this.last = (char) ProgressionUtilKt.getProgressionLastElement(c, c2, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator<Character> iterator() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }
}
