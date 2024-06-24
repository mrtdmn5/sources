package aws.smithy.kotlin.runtime.retries.policy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public /* synthetic */ class StandardRetryPolicy$evaluationStrategies$1 extends FunctionReferenceImpl implements Function1<Throwable, RetryDirective> {
    public StandardRetryPolicy$evaluationStrategies$1(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateSpecificExceptions", "evaluateSpecificExceptions(Ljava/lang/Throwable;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(Throwable th) {
        Throwable p0 = th;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((StandardRetryPolicy) this.receiver).evaluateSpecificExceptions(p0);
    }
}
