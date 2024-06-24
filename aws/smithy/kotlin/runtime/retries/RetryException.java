package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.retries.delay.RetryCapacityExceededException;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public abstract class RetryException extends ClientException {
    public final Object lastResponse;

    public RetryException(String str, RetryCapacityExceededException retryCapacityExceededException, Object obj) {
        super(str, retryCapacityExceededException);
        this.lastResponse = obj;
    }
}
