package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class UnlinkDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String developerProviderName;
    private String developerUserIdentifier;
    private String identityId;
    private String identityPoolId;

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
        if (obj == null || !(obj instanceof UnlinkDeveloperIdentityRequest)) {
            return false;
        }
        UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest = (UnlinkDeveloperIdentityRequest) obj;
        if (unlinkDeveloperIdentityRequest.getIdentityId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityId() != null && !unlinkDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityPoolId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentityPoolId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityPoolId() != null && !unlinkDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getDeveloperProviderName() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() != null && !unlinkDeveloperIdentityRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getDeveloperUserIdentifier() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null || unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier().equals(getDeveloperUserIdentifier())) {
            return true;
        }
        return false;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
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

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentityPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityPoolId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getDeveloperProviderName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperProviderName().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getDeveloperUserIdentifier() != null) {
            r1 = getDeveloperUserIdentifier().hashCode();
        }
        return r03 + r1;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
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

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getDeveloperUserIdentifier() != null) {
            sb.append("DeveloperUserIdentifier: " + getDeveloperUserIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public UnlinkDeveloperIdentityRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }
}
