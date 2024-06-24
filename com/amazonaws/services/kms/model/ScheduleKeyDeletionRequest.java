package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ScheduleKeyDeletionRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer pendingWindowInDays;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleKeyDeletionRequest)) {
            return false;
        }
        ScheduleKeyDeletionRequest scheduleKeyDeletionRequest = (ScheduleKeyDeletionRequest) obj;
        if (scheduleKeyDeletionRequest.getKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getKeyId() != null && !scheduleKeyDeletionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getPendingWindowInDays() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getPendingWindowInDays() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getPendingWindowInDays() == null || scheduleKeyDeletionRequest.getPendingWindowInDays().equals(getPendingWindowInDays())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getPendingWindowInDays() {
        return this.pendingWindowInDays;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getPendingWindowInDays() != null) {
            r1 = getPendingWindowInDays().hashCode();
        }
        return r0 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPendingWindowInDays() != null) {
            sb.append("PendingWindowInDays: " + getPendingWindowInDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public ScheduleKeyDeletionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ScheduleKeyDeletionRequest withPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
        return this;
    }
}
