package aws.smithy.kotlin.runtime.retries;

/* compiled from: StandardRetryStrategy.kt */
/* loaded from: classes.dex */
public final class StandardRetryStrategyOptions {
    public static final StandardRetryStrategyOptions Default = new StandardRetryStrategyOptions();
    public final int maxAttempts = 3;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StandardRetryStrategyOptions) && getMaxAttempts().intValue() == ((StandardRetryStrategyOptions) obj).getMaxAttempts().intValue()) {
            return true;
        }
        return false;
    }

    public final Integer getMaxAttempts() {
        return Integer.valueOf(this.maxAttempts);
    }

    public final int hashCode() {
        return getMaxAttempts().hashCode();
    }

    public final String toString() {
        return "StandardRetryStrategyOptions(maxAttempts=" + getMaxAttempts().intValue() + ')';
    }
}
