package aws.smithy.kotlin.runtime.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public final class IncompleteException extends ParseException {
    public final Needed needed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompleteException(String input, Needed needed) {
        super(input, needed.toString(), input.length() - 1);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(needed, "needed");
        this.needed = needed;
    }
}
