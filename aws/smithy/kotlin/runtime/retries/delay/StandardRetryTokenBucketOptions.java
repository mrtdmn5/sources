package aws.smithy.kotlin.runtime.retries.delay;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: StandardRetryTokenBucket.kt */
/* loaded from: classes.dex */
public final class StandardRetryTokenBucketOptions {
    public static final StandardRetryTokenBucketOptions Default = new StandardRetryTokenBucketOptions();
    public final int maxCapacity = 500;
    public final int refillUnitsPerSecond = 10;
    public final boolean circuitBreakerMode = false;
    public final int retryCost = 5;
    public final int timeoutRetryCost = 10;
    public final int initialTryCost = 0;
    public final int initialTrySuccessIncrement = 1;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StandardRetryTokenBucketOptions)) {
            return false;
        }
        StandardRetryTokenBucketOptions standardRetryTokenBucketOptions = (StandardRetryTokenBucketOptions) obj;
        if (this.maxCapacity == standardRetryTokenBucketOptions.maxCapacity && this.refillUnitsPerSecond == standardRetryTokenBucketOptions.refillUnitsPerSecond && this.circuitBreakerMode == standardRetryTokenBucketOptions.circuitBreakerMode && this.retryCost == standardRetryTokenBucketOptions.retryCost && this.timeoutRetryCost == standardRetryTokenBucketOptions.timeoutRetryCost && this.initialTryCost == standardRetryTokenBucketOptions.initialTryCost && this.initialTrySuccessIncrement == standardRetryTokenBucketOptions.initialTrySuccessIncrement) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.refillUnitsPerSecond, Integer.hashCode(this.maxCapacity) * 31, 31);
        boolean z = this.circuitBreakerMode;
        int r1 = z;
        if (z != 0) {
            r1 = 1;
        }
        return Integer.hashCode(this.initialTrySuccessIncrement) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.initialTryCost, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.timeoutRetryCost, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.retryCost, (m + r1) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StandardRetryTokenBucketOptions(maxCapacity=");
        sb.append(this.maxCapacity);
        sb.append(", refillUnitsPerSecond=");
        sb.append(this.refillUnitsPerSecond);
        sb.append(", circuitBreakerMode=");
        sb.append(this.circuitBreakerMode);
        sb.append(", retryCost=");
        sb.append(this.retryCost);
        sb.append(", timeoutRetryCost=");
        sb.append(this.timeoutRetryCost);
        sb.append(", initialTryCost=");
        sb.append(this.initialTryCost);
        sb.append(", initialTrySuccessIncrement=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.initialTrySuccessIncrement, ')');
    }
}
