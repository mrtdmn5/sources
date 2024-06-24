package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.sequences.TransformingSequence$iterator$1;

/* compiled from: Regex.kt */
/* loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> {
    public final /* synthetic */ MatcherMatchResult this$0;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof MatchGroup;
        }
        if (!z) {
            return false;
        }
        return super.contains((MatchGroup) obj);
    }

    public final MatchGroup get(int r4) {
        MatcherMatchResult matcherMatchResult = this.this$0;
        Matcher matcher = matcherMatchResult.matcher;
        IntRange until = RangesKt___RangesKt.until(matcher.start(r4), matcher.end(r4));
        if (until.getStart().intValue() >= 0) {
            String group = matcherMatchResult.matcher.group(r4);
            Intrinsics.checkNotNullExpressionValue(group, "group(...)");
            return new MatchGroup(group, until);
        }
        return null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.this$0.matcher.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<MatchGroup> iterator() {
        return new TransformingSequence$iterator$1(new TransformingSequence(CollectionsKt___CollectionsKt.asSequence(new IntRange(0, getSize() - 1)), new Function1<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MatchGroup invoke(Integer num) {
                return MatcherMatchResult$groups$1.this.get(num.intValue());
            }
        }));
    }
}
