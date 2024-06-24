package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetSessionTokenResult implements Serializable {
    private Credentials credentials;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSessionTokenResult)) {
            return false;
        }
        GetSessionTokenResult getSessionTokenResult = (GetSessionTokenResult) obj;
        if (getSessionTokenResult.getCredentials() == null) {
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
        if (getSessionTokenResult.getCredentials() == null || getSessionTokenResult.getCredentials().equals(getCredentials())) {
            return true;
        }
        return false;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public int hashCode() {
        int hashCode;
        if (getCredentials() == null) {
            hashCode = 0;
        } else {
            hashCode = getCredentials().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetSessionTokenResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }
}
