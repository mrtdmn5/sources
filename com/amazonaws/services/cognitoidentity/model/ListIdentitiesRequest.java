package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ListIdentitiesRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean hideDisabled;
    private String identityPoolId;
    private Integer maxResults;
    private String nextToken;

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
        if (obj == null || !(obj instanceof ListIdentitiesRequest)) {
            return false;
        }
        ListIdentitiesRequest listIdentitiesRequest = (ListIdentitiesRequest) obj;
        if (listIdentitiesRequest.getIdentityPoolId() == null) {
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
        if (listIdentitiesRequest.getIdentityPoolId() != null && !listIdentitiesRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (listIdentitiesRequest.getMaxResults() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMaxResults() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listIdentitiesRequest.getMaxResults() != null && !listIdentitiesRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if (listIdentitiesRequest.getNextToken() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getNextToken() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listIdentitiesRequest.getNextToken() != null && !listIdentitiesRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        if (listIdentitiesRequest.getHideDisabled() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getHideDisabled() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (listIdentitiesRequest.getHideDisabled() == null || listIdentitiesRequest.getHideDisabled().equals(getHideDisabled())) {
            return true;
        }
        return false;
    }

    public Boolean getHideDisabled() {
        return this.hideDisabled;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMaxResults() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMaxResults().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getNextToken() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getNextToken().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getHideDisabled() != null) {
            r1 = getHideDisabled().hashCode();
        }
        return r03 + r1;
    }

    public Boolean isHideDisabled() {
        return this.hideDisabled;
    }

    public void setHideDisabled(Boolean bool) {
        this.hideDisabled = bool;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken() + ",");
        }
        if (getHideDisabled() != null) {
            sb.append("HideDisabled: " + getHideDisabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentitiesRequest withHideDisabled(Boolean bool) {
        this.hideDisabled = bool;
        return this;
    }

    public ListIdentitiesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public ListIdentitiesRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public ListIdentitiesRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
