package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class WorkRequest {
    public final UUID mId;
    public final Set<String> mTags;
    public final WorkSpec mWorkSpec;

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        public boolean mBackoffCriteriaSet = false;
        public UUID mId;
        public final HashSet mTags;
        public WorkSpec mWorkSpec;

        public Builder(Class<? extends ListenableWorker> workerClass) {
            HashSet hashSet = new HashSet();
            this.mTags = hashSet;
            this.mId = UUID.randomUUID();
            this.mWorkSpec = new WorkSpec(this.mId.toString(), workerClass.getName());
            hashSet.add(workerClass.getName());
            getThis();
        }

        public final W build() {
            boolean z;
            W buildInternal = buildInternal();
            Constraints constraints = this.mWorkSpec.constraints;
            boolean z2 = true;
            if (constraints.mContentUriTriggers.mTriggers.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !constraints.mRequiresBatteryNotLow && !constraints.mRequiresCharging && !constraints.mRequiresDeviceIdle) {
                z2 = false;
            }
            WorkSpec workSpec = this.mWorkSpec;
            if (workSpec.expedited) {
                if (!z2) {
                    if (workSpec.initialDelay > 0) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
            }
            this.mId = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec2;
            workSpec2.id = this.mId.toString();
            return buildInternal;
        }

        public abstract W buildInternal();

        public abstract B getThis();
    }

    public WorkRequest(UUID id, WorkSpec workSpec, HashSet tags) {
        this.mId = id;
        this.mWorkSpec = workSpec;
        this.mTags = tags;
    }
}
