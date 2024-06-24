package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class GetAccessKeyInfoRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessKeyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccessKeyInfoRequest)) {
            return false;
        }
        GetAccessKeyInfoRequest getAccessKeyInfoRequest = (GetAccessKeyInfoRequest) obj;
        if (getAccessKeyInfoRequest.getAccessKeyId() == null) {
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
        if (getAccessKeyInfoRequest.getAccessKeyId() == null || getAccessKeyInfoRequest.getAccessKeyId().equals(getAccessKeyId())) {
            return true;
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public int hashCode() {
        int hashCode;
        if (getAccessKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessKeyId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetAccessKeyInfoRequest withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }
}
