package aws.smithy.kotlin.runtime.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public final class TakeWhileMNException extends ParseException {
    public final int expected;
    public final int matched;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeWhileMNException(String input, int r4, int r5, int r6) {
        super(input, "expected at least " + r5 + " matches of predicate; only matched " + r6, r4);
        Intrinsics.checkNotNullParameter(input, "input");
        this.expected = r5;
        this.matched = r6;
    }
}
