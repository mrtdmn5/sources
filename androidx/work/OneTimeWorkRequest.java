package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.workers.DiagnosticsWorker;

/* loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {
    public OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder() {
            super(DiagnosticsWorker.class);
            this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.WorkRequest.Builder
        public final OneTimeWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet && this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new OneTimeWorkRequest(this);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final Builder getThis() {
            return this;
        }
    }
}
