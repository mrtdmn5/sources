package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class ScheduleKeyDeletionResult implements Serializable {
    private Date deletionDate;
    private String keyId;
    private String keyState;
    private Integer pendingWindowInDays;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleKeyDeletionResult)) {
            return false;
        }
        ScheduleKeyDeletionResult scheduleKeyDeletionResult = (ScheduleKeyDeletionResult) obj;
        if (scheduleKeyDeletionResult.getKeyId() == null) {
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
        if (scheduleKeyDeletionResult.getKeyId() != null && !scheduleKeyDeletionResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (scheduleKeyDeletionResult.getDeletionDate() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getDeletionDate() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (scheduleKeyDeletionResult.getDeletionDate() != null && !scheduleKeyDeletionResult.getDeletionDate().equals(getDeletionDate())) {
            return false;
        }
        if (scheduleKeyDeletionResult.getKeyState() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyState() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (scheduleKeyDeletionResult.getKeyState() != null && !scheduleKeyDeletionResult.getKeyState().equals(getKeyState())) {
            return false;
        }
        if (scheduleKeyDeletionResult.getPendingWindowInDays() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getPendingWindowInDays() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (scheduleKeyDeletionResult.getPendingWindowInDays() == null || scheduleKeyDeletionResult.getPendingWindowInDays().equals(getPendingWindowInDays())) {
            return true;
        }
        return false;
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyState() {
        return this.keyState;
    }

    public Integer getPendingWindowInDays() {
        return this.pendingWindowInDays;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getDeletionDate() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDeletionDate().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyState() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyState().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getPendingWindowInDays() != null) {
            r1 = getPendingWindowInDays().hashCode();
        }
        return r03 + r1;
    }

    public void setDeletionDate(Date date) {
        this.deletionDate = date;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyState(String str) {
        this.keyState = str;
    }

    public void setPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getDeletionDate() != null) {
            sb.append("DeletionDate: " + getDeletionDate() + ",");
        }
        if (getKeyState() != null) {
            sb.append("KeyState: " + getKeyState() + ",");
        }
        if (getPendingWindowInDays() != null) {
            sb.append("PendingWindowInDays: " + getPendingWindowInDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public ScheduleKeyDeletionResult withDeletionDate(Date date) {
        this.deletionDate = date;
        return this;
    }

    public ScheduleKeyDeletionResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ScheduleKeyDeletionResult withKeyState(String str) {
        this.keyState = str;
        return this;
    }

    public ScheduleKeyDeletionResult withPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
        return this;
    }

    public void setKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
    }

    public ScheduleKeyDeletionResult withKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
        return this;
    }
}
