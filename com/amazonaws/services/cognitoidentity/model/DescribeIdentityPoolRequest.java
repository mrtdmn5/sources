package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DescribeIdentityPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeIdentityPoolRequest)) {
            return false;
        }
        DescribeIdentityPoolRequest describeIdentityPoolRequest = (DescribeIdentityPoolRequest) obj;
        if (describeIdentityPoolRequest.getIdentityPoolId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityPoolId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (describeIdentityPoolRequest.getIdentityPoolId() == null || describeIdentityPoolRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return true;
        }
        return false;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public int hashCode() {
        int hashCode;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeIdentityPoolRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }
}
