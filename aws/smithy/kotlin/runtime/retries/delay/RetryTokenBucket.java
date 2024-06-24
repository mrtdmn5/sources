package aws.smithy.kotlin.runtime.retries.delay;

import kotlin.coroutines.Continuation;

/* compiled from: RetryTokenBucket.kt */
/* loaded from: classes.dex */
public interface RetryTokenBucket {
    Object acquireToken(Continuation<? super RetryToken> continuation);
}
