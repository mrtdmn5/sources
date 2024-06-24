package androidx.work.impl.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.arch.core.util.Function;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkSpec {
    public static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public static final AnonymousClass1 WORK_INFO_MAPPER = new AnonymousClass1();
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    public String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    public long periodStartTime;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    public String workerClassName;

    /* renamed from: androidx.work.impl.model.WorkSpec$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Function<List<WorkInfoPojo>, List<WorkInfo>> {
        @Override // androidx.arch.core.util.Function
        public final List<WorkInfo> apply(List<WorkInfoPojo> input) {
            Data data;
            List<WorkInfoPojo> list = input;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo workInfoPojo : list) {
                ArrayList arrayList2 = workInfoPojo.progress;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    data = (Data) workInfoPojo.progress.get(0);
                } else {
                    data = Data.EMPTY;
                }
                arrayList.add(new WorkInfo(UUID.fromString(workInfoPojo.id), workInfoPojo.state, workInfoPojo.output, workInfoPojo.tags, data, workInfoPojo.runAttemptCount));
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class IdAndState {
        public String id;
        public WorkInfo.State state;

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) o;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.id.equals(idAndState.id);
        }

        public final int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }
    }

    /* loaded from: classes.dex */
    public static class WorkInfoPojo {
        public String id;
        public Data output;
        public ArrayList progress;
        public int runAttemptCount;
        public WorkInfo.State state;
        public ArrayList tags;

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) o;
            if (this.runAttemptCount != workInfoPojo.runAttemptCount) {
                return false;
            }
            String str = this.id;
            if (str == null ? workInfoPojo.id != null : !str.equals(workInfoPojo.id)) {
                return false;
            }
            if (this.state != workInfoPojo.state) {
                return false;
            }
            Data data = this.output;
            if (data == null ? workInfoPojo.output != null : !data.equals(workInfoPojo.output)) {
                return false;
            }
            ArrayList arrayList = this.tags;
            if (arrayList == null ? workInfoPojo.tags != null : !arrayList.equals(workInfoPojo.tags)) {
                return false;
            }
            ArrayList arrayList2 = this.progress;
            ArrayList arrayList3 = workInfoPojo.progress;
            if (arrayList2 != null) {
                return arrayList2.equals(arrayList3);
            }
            if (arrayList3 == null) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int r0;
            int r2;
            int r22;
            int r23;
            String str = this.id;
            int r1 = 0;
            if (str != null) {
                r0 = str.hashCode();
            } else {
                r0 = 0;
            }
            int r02 = r0 * 31;
            WorkInfo.State state = this.state;
            if (state != null) {
                r2 = state.hashCode();
            } else {
                r2 = 0;
            }
            int r03 = (r02 + r2) * 31;
            Data data = this.output;
            if (data != null) {
                r22 = data.hashCode();
            } else {
                r22 = 0;
            }
            int r04 = (((r03 + r22) * 31) + this.runAttemptCount) * 31;
            ArrayList arrayList = this.tags;
            if (arrayList != null) {
                r23 = arrayList.hashCode();
            } else {
                r23 = 0;
            }
            int r05 = (r04 + r23) * 31;
            ArrayList arrayList2 = this.progress;
            if (arrayList2 != null) {
                r1 = arrayList2.hashCode();
            }
            return r05 + r1;
        }
    }

    public WorkSpec(String id, String workerClassName) {
        this.state = WorkInfo.State.ENQUEUED;
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000L;
        this.scheduleRequestedAt = -1L;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.id = id;
        this.workerClassName = workerClassName;
    }

    public final long calculateNextRunTime() {
        boolean z;
        long j;
        long j2;
        long scalb;
        boolean z2 = true;
        boolean z3 = false;
        if (this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                z3 = true;
            }
            if (z3) {
                scalb = this.backoffDelayDuration * this.runAttemptCount;
            } else {
                scalb = Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            j2 = this.periodStartTime;
            j = Math.min(18000000L, scalb);
        } else {
            long j3 = 0;
            if (isPeriodic()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = this.periodStartTime;
                if (j4 == 0) {
                    j4 = this.initialDelay + currentTimeMillis;
                }
                long j5 = this.flexDuration;
                long j6 = this.intervalDuration;
                if (j5 == j6) {
                    z2 = false;
                }
                if (z2) {
                    if (j4 == 0) {
                        j3 = j5 * (-1);
                    }
                    return j4 + j6 + j3;
                }
                if (j4 != 0) {
                    j3 = j6;
                }
                return j4 + j3;
            }
            j = this.periodStartTime;
            if (j == 0) {
                j = System.currentTimeMillis();
            }
            j2 = this.initialDelay;
        }
        return j + j2;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || WorkSpec.class != o.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) o;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.expedited != workSpec.expedited || !this.id.equals(workSpec.id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName != null : !str.equals(workSpec.inputMergerClassName)) {
            return false;
        }
        if (this.input.equals(workSpec.input) && this.output.equals(workSpec.output) && this.constraints.equals(workSpec.constraints) && this.backoffPolicy == workSpec.backoffPolicy && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy) {
            return true;
        }
        return false;
    }

    public final boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public final int hashCode() {
        int r1;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.workerClassName, (this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31);
        String str = this.inputMergerClassName;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int hashCode = (this.output.hashCode() + ((this.input.hashCode() + ((m + r1) * 31)) * 31)) * 31;
        long j = this.initialDelay;
        int r0 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.intervalDuration;
        int r02 = (r0 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.flexDuration;
        int hashCode2 = (this.backoffPolicy.hashCode() + ((((this.constraints.hashCode() + ((r02 + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31;
        long j4 = this.backoffDelayDuration;
        int r03 = (hashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.periodStartTime;
        int r04 = (r03 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.minimumRetentionDuration;
        int r05 = (r04 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.scheduleRequestedAt;
        return this.outOfQuotaPolicy.hashCode() + ((((r05 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.expedited ? 1 : 0)) * 31);
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration != 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("{WorkSpec: "), this.id, "}");
    }

    public WorkSpec(WorkSpec other) {
        this.state = WorkInfo.State.ENQUEUED;
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000L;
        this.scheduleRequestedAt = -1L;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.id = other.id;
        this.workerClassName = other.workerClassName;
        this.state = other.state;
        this.inputMergerClassName = other.inputMergerClassName;
        this.input = new Data(other.input);
        this.output = new Data(other.output);
        this.initialDelay = other.initialDelay;
        this.intervalDuration = other.intervalDuration;
        this.flexDuration = other.flexDuration;
        this.constraints = new Constraints(other.constraints);
        this.runAttemptCount = other.runAttemptCount;
        this.backoffPolicy = other.backoffPolicy;
        this.backoffDelayDuration = other.backoffDelayDuration;
        this.periodStartTime = other.periodStartTime;
        this.minimumRetentionDuration = other.minimumRetentionDuration;
        this.scheduleRequestedAt = other.scheduleRequestedAt;
        this.expedited = other.expedited;
        this.outOfQuotaPolicy = other.outOfQuotaPolicy;
    }
}
