package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes4.dex */
public final class StackTraceRecoveryKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Object createFailure;
        Object createFailure2;
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
        new StackTraceElement("_COROUTINE._BOUNDARY", "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            createFailure = BaseContinuationImpl.class.getCanonicalName();
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (Result.m1661exceptionOrNullimpl(createFailure) != null) {
            createFailure = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            createFailure2 = StackTraceRecoveryKt.class.getCanonicalName();
        } catch (Throwable th2) {
            createFailure2 = ResultKt.createFailure(th2);
        }
        if (Result.m1661exceptionOrNullimpl(createFailure2) != null) {
            createFailure2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
