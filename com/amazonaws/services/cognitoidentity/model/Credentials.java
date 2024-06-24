package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class Credentials implements Serializable {
    private String accessKeyId;
    private Date expiration;
    private String secretKey;
    private String sessionToken;

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
        if (obj == null || !(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if (credentials.getAccessKeyId() == null) {
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
        if (credentials.getAccessKeyId() != null && !credentials.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if (credentials.getSecretKey() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getSecretKey() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (credentials.getSecretKey() != null && !credentials.getSecretKey().equals(getSecretKey())) {
            return false;
        }
        if (credentials.getSessionToken() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getSessionToken() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (credentials.getSessionToken() != null && !credentials.getSessionToken().equals(getSessionToken())) {
            return false;
        }
        if (credentials.getExpiration() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getExpiration() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (credentials.getExpiration() == null || credentials.getExpiration().equals(getExpiration())) {
            return true;
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getAccessKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getSecretKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSecretKey().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getSessionToken() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSessionToken().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getExpiration() != null) {
            r1 = getExpiration().hashCode();
        }
        return r03 + r1;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId() + ",");
        }
        if (getSecretKey() != null) {
            sb.append("SecretKey: " + getSecretKey() + ",");
        }
        if (getSessionToken() != null) {
            sb.append("SessionToken: " + getSessionToken() + ",");
        }
        if (getExpiration() != null) {
            sb.append("Expiration: " + getExpiration());
        }
        sb.append("}");
        return sb.toString();
    }

    public Credentials withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Credentials withExpiration(Date date) {
        this.expiration = date;
        return this;
    }

    public Credentials withSecretKey(String str) {
        this.secretKey = str;
        return this;
    }

    public Credentials withSessionToken(String str) {
        this.sessionToken = str;
        return this;
    }
}
