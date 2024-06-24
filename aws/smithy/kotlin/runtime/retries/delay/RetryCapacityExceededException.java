package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.ClientException;

/* compiled from: RetryTokenBucket.kt */
/* loaded from: classes.dex */
public final class RetryCapacityExceededException extends ClientException {
    public RetryCapacityExceededException() {
        super("Insufficient capacity to attempt another retry");
    }
}
