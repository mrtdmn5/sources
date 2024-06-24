package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;

/* compiled from: Interceptor.kt */
/* loaded from: classes.dex */
public interface RequestInterceptorContext<I> {
    ExecutionContext getExecutionContext();
}
