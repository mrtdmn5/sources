package aws.smithy.kotlin.runtime.retries.policy;

/* compiled from: RetryErrorType.kt */
/* loaded from: classes.dex */
public enum RetryErrorType {
    ServerSide,
    ClientSide,
    Throttling,
    Timeout
}
