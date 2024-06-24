package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DecodeAuthorizationMessageRequest extends AmazonWebServiceRequest implements Serializable {
    private String encodedMessage;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecodeAuthorizationMessageRequest)) {
            return false;
        }
        DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest = (DecodeAuthorizationMessageRequest) obj;
        if (decodeAuthorizationMessageRequest.getEncodedMessage() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getEncodedMessage() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (decodeAuthorizationMessageRequest.getEncodedMessage() == null || decodeAuthorizationMessageRequest.getEncodedMessage().equals(getEncodedMessage())) {
            return true;
        }
        return false;
    }

    public String getEncodedMessage() {
        return this.encodedMessage;
    }

    public int hashCode() {
        int hashCode;
        if (getEncodedMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getEncodedMessage().hashCode();
        }
        return 31 + hashCode;
    }

    public void setEncodedMessage(String str) {
        this.encodedMessage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEncodedMessage() != null) {
            sb.append("EncodedMessage: " + getEncodedMessage());
        }
        sb.append("}");
        return sb.toString();
    }

    public DecodeAuthorizationMessageRequest withEncodedMessage(String str) {
        this.encodedMessage = str;
        return this;
    }
}
