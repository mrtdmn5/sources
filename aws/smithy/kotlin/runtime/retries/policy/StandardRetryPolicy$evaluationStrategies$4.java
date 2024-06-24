package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public /* synthetic */ class StandardRetryPolicy$evaluationStrategies$4 extends FunctionReferenceImpl implements Function1<ClientException, RetryDirective> {
    public StandardRetryPolicy$evaluationStrategies$4(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateClientException", "evaluateClientException(Laws/smithy/kotlin/runtime/ClientException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(ClientException clientException) {
        ClientException p0 = clientException;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StandardRetryPolicy) this.receiver).getClass();
        if (p0.sdkErrorMetadata.isRetryable()) {
            return new RetryDirective.RetryError(RetryErrorType.ClientSide);
        }
        return null;
    }
}
