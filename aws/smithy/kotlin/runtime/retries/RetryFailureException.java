package aws.smithy.kotlin.runtime.retries;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public final class RetryFailureException extends RetryException {
    public RetryFailureException(int r2, Object obj) {
        super("The operation resulted in a non-retryable failure", null, obj);
    }
}
