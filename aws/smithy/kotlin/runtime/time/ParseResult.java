package aws.smithy.kotlin.runtime.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public final class ParseResult<T> {
    public final int pos;
    public final T result;

    public ParseResult(int r1, T t) {
        this.pos = r1;
        this.result = t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParseResult)) {
            return false;
        }
        ParseResult parseResult = (ParseResult) obj;
        if (this.pos == parseResult.pos && Intrinsics.areEqual(this.result, parseResult.result)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = Integer.hashCode(this.pos) * 31;
        T t = this.result;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "ParseResult(pos=" + this.pos + ", result=" + this.result + ')';
    }
}
