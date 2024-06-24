package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {
    public PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(Class cls, TimeUnit timeUnit) {
            super(cls);
            WorkSpec workSpec = this.mWorkSpec;
            long millis = timeUnit.toMillis(1L);
            workSpec.getClass();
            long j = 900000;
            String str = WorkSpec.TAG;
            if (millis < 900000) {
                Logger.get().warning(str, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                millis = 900000;
            }
            if (millis < 900000) {
                Logger.get().warning(str, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            } else {
                j = millis;
            }
            if (millis < 300000) {
                Logger.get().warning(str, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                millis = 300000;
            }
            if (millis > j) {
                Logger.get().warning(str, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j)), new Throwable[0]);
                millis = j;
            }
            workSpec.intervalDuration = j;
            workSpec.flexDuration = millis;
        }

        @Override // androidx.work.WorkRequest.Builder
        public final PeriodicWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet && this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (!this.mWorkSpec.expedited) {
                return new PeriodicWorkRequest(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
        }

        @Override // androidx.work.WorkRequest.Builder
        public final Builder getThis() {
            return this;
        }
    }
}
