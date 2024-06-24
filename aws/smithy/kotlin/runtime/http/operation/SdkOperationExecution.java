package aws.smithy.kotlin.runtime.http.operation;

import aws.sdk.kotlin.runtime.http.retries.AwsDefaultRetryPolicy;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner$Companion$Anonymous$1;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class SdkOperationExecution<Request, Response> {
    public final Phase<OperationRequest<Request>, Response> initialize = new Phase<>();
    public final Phase<OperationRequest<HttpRequestBuilder>, Response> mutate = new Phase<>();
    public final Phase<OperationRequest<HttpRequestBuilder>, Response> onEachAttempt = new Phase<>();
    public final Phase<OperationRequest<HttpRequestBuilder>, HttpCall> receive = new Phase<>();
    public final HttpSigner$Companion$Anonymous$1 signer = HttpSigner.Companion.Anonymous;
    public RetryStrategy retryStrategy = new StandardRetryStrategy(0);
    public RetryPolicy<? super Response> retryPolicy = StandardRetryPolicy.Default;

    public final void setRetryPolicy(AwsDefaultRetryPolicy awsDefaultRetryPolicy) {
        Intrinsics.checkNotNullParameter(awsDefaultRetryPolicy, "<set-?>");
        this.retryPolicy = awsDefaultRetryPolicy;
    }

    public final void setRetryStrategy(StandardRetryStrategy standardRetryStrategy) {
        Intrinsics.checkNotNullParameter(standardRetryStrategy, "<set-?>");
        this.retryStrategy = standardRetryStrategy;
    }
}
