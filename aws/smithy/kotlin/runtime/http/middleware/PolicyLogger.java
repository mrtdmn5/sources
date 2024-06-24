package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.tracing.EventLevel;
import aws.smithy.kotlin.runtime.tracing.TraceSpan;
import aws.smithy.kotlin.runtime.tracing.TraceSpanExtKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: RetryMiddleware.kt */
/* loaded from: classes.dex */
public final class PolicyLogger<O> implements RetryPolicy<O> {
    public final RetryPolicy<O> policy;
    public final TraceSpan traceSpan;

    /* JADX WARN: Multi-variable type inference failed */
    public PolicyLogger(RetryPolicy<? super O> policy, TraceSpan traceSpan) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(traceSpan, "traceSpan");
        this.policy = policy;
        this.traceSpan = traceSpan;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public final RetryDirective evaluate(Object obj) {
        RetryDirective evaluate = this.policy.evaluate(obj);
        if (evaluate instanceof RetryDirective.TerminateAndFail) {
            EventLevel eventLevel = EventLevel.Debug;
            String qualifiedName = Reflection.getOrCreateKotlinClass(RetryMiddleware.class).getQualifiedName();
            if (qualifiedName != null) {
                TraceSpanExtKt.log(this.traceSpan, eventLevel, qualifiedName, new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.middleware.PolicyLogger$evaluate$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "request failed with non-retryable error";
                    }
                });
            } else {
                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
            }
        }
        return evaluate;
    }
}
