package aws.sdk.kotlin.runtime.http.middleware;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.operation.SdkOperationExecution;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.io.middleware.Middleware;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsRetryHeaderMiddleware.kt */
/* loaded from: classes.dex */
public final class AwsRetryHeaderMiddleware<O> implements Middleware {
    public int attempt;
    public Integer maxAttempts;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final Object handle(Object obj, Handler handler, Continuation continuation) {
        String str;
        OperationRequest operationRequest = (OperationRequest) obj;
        this.attempt++;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) operationRequest.subject;
        String sdkRequestId = SdkHttpOperationKt.getSdkRequestId(operationRequest.context);
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.headers.ensureListForKey(1, "amz-sdk-invocation-id").add(sdkRequestId);
        int r0 = this.attempt;
        Integer num = this.maxAttempts;
        if (num == null || (str = SubMenuBuilder$$ExternalSyntheticOutline0.m("; max=", num.intValue())) == null) {
            str = "";
        }
        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) operationRequest.subject;
        String value = "attempt=" + r0 + str;
        Intrinsics.checkNotNullParameter(httpRequestBuilder2, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        httpRequestBuilder2.headers.ensureListForKey(1, "amz-sdk-request").add(value);
        return handler.call(operationRequest, continuation);
    }

    public final void install(SdkHttpOperation<?, O> sdkHttpOperation) {
        SdkOperationExecution<?, O> sdkOperationExecution = sdkHttpOperation.execution;
        this.maxAttempts = sdkOperationExecution.retryStrategy.getOptions().getMaxAttempts();
        sdkOperationExecution.onEachAttempt.register(this, Phase.Order.After);
    }
}
