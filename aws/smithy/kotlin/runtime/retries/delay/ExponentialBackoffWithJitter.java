package aws.smithy.kotlin.runtime.retries.delay;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy$doTryLoop$1;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;

/* compiled from: ExponentialBackoffWithJitter.kt */
/* loaded from: classes.dex */
public final class ExponentialBackoffWithJitter implements DelayProvider {
    public final ExponentialBackoffWithJitterOptions options;
    public final Random.Default random;

    public ExponentialBackoffWithJitter() {
        ExponentialBackoffWithJitterOptions options = ExponentialBackoffWithJitterOptions.Default;
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        this.random = Random.Default;
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.DelayProvider
    public final Object backoff(int r9, StandardRetryStrategy$doTryLoop$1 standardRetryStrategy$doTryLoop$1) {
        boolean z;
        if (r9 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ExponentialBackoffWithJitterOptions exponentialBackoffWithJitterOptions = this.options;
            double min = Math.min(Math.pow(exponentialBackoffWithJitterOptions.scaleFactor, r9 - 1) * Duration.m1677getInWholeMillisecondsimpl(exponentialBackoffWithJitterOptions.initialDelay), Duration.m1688toDoubleimpl(exponentialBackoffWithJitterOptions.maxBackoff, DurationUnit.MILLISECONDS));
            double d = exponentialBackoffWithJitterOptions.jitter;
            double d2 = 0.0d;
            if (d > 0.0d) {
                d2 = this.random.nextDouble(d);
            }
            Object delay = DelayKt.delay((long) ((1.0d - d2) * min), standardRetryStrategy$doTryLoop$1);
            if (delay == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return delay;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("attempt was ", r9, " but must be greater than 0").toString());
    }
}
