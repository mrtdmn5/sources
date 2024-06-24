package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class LookupDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String developerUserIdentifier;
    private String identityId;
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
        boolean z9;
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LookupDeveloperIdentityRequest)) {
            return false;
        }
        LookupDeveloperIdentityRequest lookupDeveloperIdentityRequest = (LookupDeveloperIdentityRequest) obj;
        if (lookupDeveloperIdentityRequest.getIdentityPoolId() == null) {
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
        if (lookupDeveloperIdentityRequest.getIdentityPoolId() != null && !lookupDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getIdentityId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getIdentityId() != null && !lookupDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getDeveloperUserIdentifier() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getDeveloperUserIdentifier() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getDeveloperUserIdentifier() != null && !lookupDeveloperIdentityRequest.getDeveloperUserIdentifier().equals(getDeveloperUserIdentifier())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getMaxResults() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getMaxResults() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getMaxResults() != null && !lookupDeveloperIdentityRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getNextToken() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getNextToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getNextToken() == null || lookupDeveloperIdentityRequest.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getDeveloperUserIdentifier() {
        return this.developerUserIdentifier;
    }

    public String getIdentityId() {
        return this.identityId;
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
        int hashCode4;
        int r1 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentityId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getDeveloperUserIdentifier() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperUserIdentifier().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getMaxResults() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getMaxResults().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getNextToken() != null) {
            r1 = getNextToken().hashCode();
        }
        return r04 + r1;
    }

    public void setDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
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
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getDeveloperUserIdentifier() != null) {
            sb.append("DeveloperUserIdentifier: " + getDeveloperUserIdentifier() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public LookupDeveloperIdentityRequest withDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public LookupDeveloperIdentityRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
