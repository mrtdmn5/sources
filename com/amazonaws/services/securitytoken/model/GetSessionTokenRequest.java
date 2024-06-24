package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class GetSessionTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String serialNumber;
    private String tokenCode;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSessionTokenRequest)) {
            return false;
        }
        GetSessionTokenRequest getSessionTokenRequest = (GetSessionTokenRequest) obj;
        if (getSessionTokenRequest.getDurationSeconds() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getDurationSeconds() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getSessionTokenRequest.getDurationSeconds() != null && !getSessionTokenRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if (getSessionTokenRequest.getSerialNumber() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSerialNumber() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getSessionTokenRequest.getSerialNumber() != null && !getSessionTokenRequest.getSerialNumber().equals(getSerialNumber())) {
            return false;
        }
        if (getSessionTokenRequest.getTokenCode() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTokenCode() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getSessionTokenRequest.getTokenCode() == null || getSessionTokenRequest.getTokenCode().equals(getTokenCode())) {
            return true;
        }
        return false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getTokenCode() {
        return this.tokenCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getDurationSeconds() == null) {
            hashCode = 0;
        } else {
            hashCode = getDurationSeconds().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getSerialNumber() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSerialNumber().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTokenCode() != null) {
            r1 = getTokenCode().hashCode();
        }
        return r02 + r1;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setTokenCode(String str) {
        this.tokenCode = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds() + ",");
        }
        if (getSerialNumber() != null) {
            sb.append("SerialNumber: " + getSerialNumber() + ",");
        }
        if (getTokenCode() != null) {
            sb.append("TokenCode: " + getTokenCode());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetSessionTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetSessionTokenRequest withSerialNumber(String str) {
        this.serialNumber = str;
        return this;
    }

    public GetSessionTokenRequest withTokenCode(String str) {
        this.tokenCode = str;
        return this;
    }
}
