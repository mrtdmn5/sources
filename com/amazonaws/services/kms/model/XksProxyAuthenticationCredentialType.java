package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class XksProxyAuthenticationCredentialType implements Serializable {
    private String accessKeyId;
    private String rawSecretAccessKey;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksProxyAuthenticationCredentialType)) {
            return false;
        }
        XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType = (XksProxyAuthenticationCredentialType) obj;
        if (xksProxyAuthenticationCredentialType.getAccessKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAccessKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (xksProxyAuthenticationCredentialType.getAccessKeyId() != null && !xksProxyAuthenticationCredentialType.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if (xksProxyAuthenticationCredentialType.getRawSecretAccessKey() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getRawSecretAccessKey() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (xksProxyAuthenticationCredentialType.getRawSecretAccessKey() == null || xksProxyAuthenticationCredentialType.getRawSecretAccessKey().equals(getRawSecretAccessKey())) {
            return true;
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getRawSecretAccessKey() {
        return this.rawSecretAccessKey;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getAccessKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getRawSecretAccessKey() != null) {
            r1 = getRawSecretAccessKey().hashCode();
        }
        return r0 + r1;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setRawSecretAccessKey(String str) {
        this.rawSecretAccessKey = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId() + ",");
        }
        if (getRawSecretAccessKey() != null) {
            sb.append("RawSecretAccessKey: " + getRawSecretAccessKey());
        }
        sb.append("}");
        return sb.toString();
    }

    public XksProxyAuthenticationCredentialType withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public XksProxyAuthenticationCredentialType withRawSecretAccessKey(String str) {
        this.rawSecretAccessKey = str;
        return this;
    }
}
