package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* compiled from: Strings.kt */
/* loaded from: classes.dex */
public final class DelimitedRangesSequence implements Sequence<IntRange> {
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    public final CharSequence input;
    public final int limit;
    public final int startIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence input, int r3, int r4, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.startIndex = r3;
        this.limit = r4;
        this.getNextMatch = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
