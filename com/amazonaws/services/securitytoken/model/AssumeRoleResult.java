package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AssumeRoleResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private Credentials credentials;
    private Integer packedPolicySize;
    private String sourceIdentity;

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
        if (obj == null || !(obj instanceof AssumeRoleResult)) {
            return false;
        }
        AssumeRoleResult assumeRoleResult = (AssumeRoleResult) obj;
        if (assumeRoleResult.getCredentials() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCredentials() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (assumeRoleResult.getCredentials() != null && !assumeRoleResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if (assumeRoleResult.getAssumedRoleUser() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAssumedRoleUser() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (assumeRoleResult.getAssumedRoleUser() != null && !assumeRoleResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if (assumeRoleResult.getPackedPolicySize() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPackedPolicySize() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (assumeRoleResult.getPackedPolicySize() != null && !assumeRoleResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if (assumeRoleResult.getSourceIdentity() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getSourceIdentity() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (assumeRoleResult.getSourceIdentity() == null || assumeRoleResult.getSourceIdentity().equals(getSourceIdentity())) {
            return true;
        }
        return false;
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getCredentials() == null) {
            hashCode = 0;
        } else {
            hashCode = getCredentials().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAssumedRoleUser() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAssumedRoleUser().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPackedPolicySize() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPackedPolicySize().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getSourceIdentity() != null) {
            r1 = getSourceIdentity().hashCode();
        }
        return r03 + r1;
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getAssumedRoleUser() != null) {
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize() + ",");
        }
        if (getSourceIdentity() != null) {
            sb.append("SourceIdentity: " + getSourceIdentity());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
        return this;
    }

    public AssumeRoleResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public AssumeRoleResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public AssumeRoleResult withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }
}
