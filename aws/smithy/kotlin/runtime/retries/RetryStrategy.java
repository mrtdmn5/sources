package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.http.middleware.PolicyLogger;
import aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$result$outcome$1;
import kotlin.coroutines.Continuation;

/* compiled from: RetryStrategy.kt */
/* loaded from: classes.dex */
public interface RetryStrategy {
    StandardRetryStrategyOptions getOptions();

    Object retry(PolicyLogger policyLogger, RetryMiddleware$handle$result$outcome$1 retryMiddleware$handle$result$outcome$1, Continuation continuation);
}
