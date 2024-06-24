package aws.smithy.kotlin.runtime.awsprotocol.json;

import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import aws.smithy.kotlin.runtime.util.AttributesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: AwsJsonProtocol.kt */
/* loaded from: classes.dex */
public final class AwsJsonProtocol implements ModifyRequest {
    public final String serviceShapeName;
    public final String version = "1.1";

    public AwsJsonProtocol(String str) {
        this.serviceShapeName = str;
    }

    public final void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase<OperationRequest<HttpRequestBuilder>, ?> phase = op.execution.mutate;
        Phase.Order order = Phase.Order.After;
        phase.getClass();
        Intrinsics.checkNotNullParameter(order, "order");
        phase.register(new ModifyRequestMiddleware(this), order);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.io.middleware.ModifyRequest
    public final Object modifyRequest(Object obj, ModifyRequestMiddleware$handle$1 modifyRequestMiddleware$handle$1) {
        OperationRequest operationRequest = (OperationRequest) obj;
        String str = (String) AttributesKt.get(SetsKt__SetsKt.OperationName, operationRequest.context);
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) operationRequest.subject;
        httpRequestBuilder.headers.ensureListForKey(1, "X-Amz-Target").add(this.serviceShapeName + '.' + str);
        StringBuilder sb = new StringBuilder("application/x-amz-json-");
        sb.append(this.version);
        httpRequestBuilder.headers.setMissing(sb.toString());
        if (httpRequestBuilder.body instanceof HttpBody.Empty) {
            httpRequestBuilder.body = new ByteArrayContent(StringsKt__StringsJVMKt.encodeToByteArray("{}"));
        }
        return operationRequest;
    }
}
