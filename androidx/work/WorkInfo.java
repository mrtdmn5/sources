package androidx.work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkInfo {
    public final UUID mId;
    public final Data mOutputData;
    public final Data mProgress;
    public final int mRunAttemptCount;
    public final State mState;
    public final HashSet mTags;

    /* loaded from: classes.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            if (this != SUCCEEDED && this != FAILED && this != CANCELLED) {
                return false;
            }
            return true;
        }
    }

    public WorkInfo(UUID id, State state, Data outputData, ArrayList tags, Data progress, int runAttemptCount) {
        this.mId = id;
        this.mState = state;
        this.mOutputData = outputData;
        this.mTags = new HashSet(tags);
        this.mProgress = progress;
        this.mRunAttemptCount = runAttemptCount;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || WorkInfo.class != o.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) o;
        if (this.mRunAttemptCount != workInfo.mRunAttemptCount || !this.mId.equals(workInfo.mId) || this.mState != workInfo.mState || !this.mOutputData.equals(workInfo.mOutputData) || !this.mTags.equals(workInfo.mTags)) {
            return false;
        }
        return this.mProgress.equals(workInfo.mProgress);
    }

    public final int hashCode() {
        return ((this.mProgress.hashCode() + ((this.mTags.hashCode() + ((this.mOutputData.hashCode() + ((this.mState.hashCode() + (this.mId.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.mRunAttemptCount;
    }

    public final String toString() {
        return "WorkInfo{mId='" + this.mId + "', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + ", mProgress=" + this.mProgress + '}';
    }
}
