package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListIdentityPoolsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentityPoolsRequest)) {
            return false;
        }
        ListIdentityPoolsRequest listIdentityPoolsRequest = (ListIdentityPoolsRequest) obj;
        if (listIdentityPoolsRequest.getMaxResults() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getMaxResults() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listIdentityPoolsRequest.getMaxResults() != null && !listIdentityPoolsRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if (listIdentityPoolsRequest.getNextToken() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getNextToken() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listIdentityPoolsRequest.getNextToken() == null || listIdentityPoolsRequest.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getMaxResults() == null) {
            hashCode = 0;
        } else {
            hashCode = getMaxResults().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            r1 = getNextToken().hashCode();
        }
        return r0 + r1;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentityPoolsRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public ListIdentityPoolsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
