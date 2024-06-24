package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$success$1;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: RetryTokenBucket.kt */
/* loaded from: classes.dex */
public interface RetryToken {
    Unit notifyFailure();

    Object notifySuccess(StandardRetryStrategy$success$1 standardRetryStrategy$success$1);

    Object scheduleRetry(RetryErrorType retryErrorType, Continuation<? super RetryToken> continuation);
}
