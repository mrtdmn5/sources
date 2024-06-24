package aws.smithy.kotlin.runtime.time;

import aws.smithy.kotlin.runtime.time.Needed;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public final class ParserCombinatorsKt {
    public static final String access$fmtTakeWhileErrorMsg(int r1, String str, int r3, int r4) {
        String str2;
        if (r1 == r3) {
            str2 = "exactly";
        } else {
            str2 = "at least";
        }
        return "expected " + str2 + ' ' + r4 + " digits; " + str;
    }

    public static final void precond(int r3, int r4, String input) {
        Needed size;
        Intrinsics.checkNotNullParameter(input, "input");
        boolean z = true;
        if (r4 != 0 ? r3 + r4 <= input.length() : r3 < input.length()) {
            z = false;
        }
        if (z) {
            if (r4 == 0) {
                size = Needed.Unknown.INSTANCE;
            } else {
                size = new Needed.Size(r4);
            }
            throw new IncompleteException(input, size);
        }
    }
}
