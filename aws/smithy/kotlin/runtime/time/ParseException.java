package aws.smithy.kotlin.runtime.time;

import aws.smithy.kotlin.runtime.SdkBaseException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParserCombinators.kt */
/* loaded from: classes.dex */
public class ParseException extends SdkBaseException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParseException(String input, String message, int r5) {
        super("parse `" + input + "`: error at " + r5 + ": " + message);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
