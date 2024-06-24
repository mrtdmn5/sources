package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1;

/* compiled from: DelayProvider.kt */
/* loaded from: classes.dex */
public interface DelayProvider {
    Object backoff(int r1, StandardRetryStrategy$doTryLoop$1 standardRetryStrategy$doTryLoop$1);
}
