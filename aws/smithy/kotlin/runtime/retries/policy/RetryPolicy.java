package aws.smithy.kotlin.runtime.retries.policy;

/* compiled from: RetryPolicy.kt */
/* loaded from: classes.dex */
public interface RetryPolicy<R> {
    RetryDirective evaluate(Object obj);
}
