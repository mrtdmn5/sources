package aws.sdk.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import aws.smithy.kotlin.runtime.util.EnvironmentProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SystemDefaultProvider;
import aws.smithy.kotlin.runtime.util.text.TextKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: RecursionDetection.kt */
/* loaded from: classes.dex */
public final class RecursionDetection implements ModifyRequest {
    public final EnvironmentProvider env;

    public RecursionDetection() {
        PlatformProvider.Companion.getClass();
        SystemDefaultProvider env = PlatformProvider.Companion.System;
        Intrinsics.checkNotNullParameter(env, "env");
        this.env = env;
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
        boolean z;
        OperationRequest operationRequest = (OperationRequest) obj;
        HeadersBuilder headersBuilder = ((HttpRequestBuilder) operationRequest.subject).headers;
        headersBuilder.getClass();
        if (!headersBuilder.values.containsKey("X-Amzn-Trace-Id")) {
            EnvironmentProvider environmentProvider = this.env;
            String str = environmentProvider.getenv("_X_AMZN_TRACE_ID");
            if (environmentProvider.getenv("AWS_LAMBDA_FUNCTION_NAME") != null && str != null) {
                HeadersBuilder headersBuilder2 = ((HttpRequestBuilder) operationRequest.subject).headers;
                StringBuilder sb = new StringBuilder(str.length());
                for (byte b : StringsKt__StringsJVMKt.encodeToByteArray(str)) {
                    char c = (char) b;
                    if (c >= 0 && c < ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        TextKt.percentEncodeTo(b, sb);
                    } else {
                        sb.append(c);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                headersBuilder2.set(sb2, "X-Amzn-Trace-Id");
            }
        }
        return operationRequest;
    }
}
