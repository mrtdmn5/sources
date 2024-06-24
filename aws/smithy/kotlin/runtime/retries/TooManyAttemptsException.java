package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.retries.delay.RetryCapacityExceededException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public final class TooManyAttemptsException extends RetryException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooManyAttemptsException(String message, RetryCapacityExceededException retryCapacityExceededException, int r3, Object obj) {
        super(message, retryCapacityExceededException, obj);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
