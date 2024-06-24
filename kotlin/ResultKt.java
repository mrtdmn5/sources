package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
/* loaded from: classes.dex */
public final class ResultKt {
    public static final Result.Failure createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void throwOnFailure(Object obj) {
        if (!(obj instanceof Result.Failure)) {
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }
}
