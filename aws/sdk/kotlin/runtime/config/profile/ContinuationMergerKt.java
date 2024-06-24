package aws.sdk.kotlin.runtime.config.profile;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: ContinuationMerger.kt */
/* loaded from: classes.dex */
public final class ContinuationMergerKt {
    public static final boolean isContinuationLine(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (CharsKt__CharKt.isWhitespace(StringsKt___StringsKt.first(str))) {
            Intrinsics.checkNotNullExpressionValue(str.substring(1), "this as java.lang.String).substring(startIndex)");
            if (!StringsKt__StringsJVMKt.isBlank(r2)) {
                return true;
            }
        }
        return false;
    }
}
