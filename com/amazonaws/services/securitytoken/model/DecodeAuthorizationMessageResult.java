package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class DecodeAuthorizationMessageResult implements Serializable {
    private String decodedMessage;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecodeAuthorizationMessageResult)) {
            return false;
        }
        DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = (DecodeAuthorizationMessageResult) obj;
        if (decodeAuthorizationMessageResult.getDecodedMessage() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getDecodedMessage() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (decodeAuthorizationMessageResult.getDecodedMessage() == null || decodeAuthorizationMessageResult.getDecodedMessage().equals(getDecodedMessage())) {
            return true;
        }
        return false;
    }

    public String getDecodedMessage() {
        return this.decodedMessage;
    }

    public int hashCode() {
        int hashCode;
        if (getDecodedMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getDecodedMessage().hashCode();
        }
        return 31 + hashCode;
    }

    public void setDecodedMessage(String str) {
        this.decodedMessage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getDecodedMessage() != null) {
            sb.append("DecodedMessage: " + getDecodedMessage());
        }
        sb.append("}");
        return sb.toString();
    }

    public DecodeAuthorizationMessageResult withDecodedMessage(String str) {
        this.decodedMessage = str;
        return this;
    }
}
