package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: ArrayPools.kt */
/* loaded from: classes4.dex */
public final class ArrayPoolsKt {
    public static final int MAX_CHARS_IN_POOL;

    static {
        Object createFailure;
        int r0;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            createFailure = StringsKt__StringNumberConversionsKt.toIntOrNull(property);
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (createFailure instanceof Result.Failure) {
            createFailure = null;
        }
        Integer num = (Integer) createFailure;
        if (num != null) {
            r0 = num.intValue();
        } else {
            r0 = 2097152;
        }
        MAX_CHARS_IN_POOL = r0;
    }
}
