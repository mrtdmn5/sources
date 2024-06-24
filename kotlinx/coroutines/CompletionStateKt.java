package kotlinx.coroutines;

import kotlin.ResultKt;

/* compiled from: CompletionState.kt */
/* loaded from: classes4.dex */
public final class CompletionStateKt {
    public static final Object recoverResult(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            return ResultKt.createFailure(((CompletedExceptionally) obj).cause);
        }
        return obj;
    }
}
