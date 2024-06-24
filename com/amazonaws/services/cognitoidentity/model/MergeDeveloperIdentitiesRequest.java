package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class MergeDeveloperIdentitiesRequest extends AmazonWebServiceRequest implements Serializable {
    private String destinationUserIdentifier;
    private String developerProviderName;
    private String identityPoolId;
    private String sourceUserIdentifier;

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
        if (obj == null || !(obj instanceof MergeDeveloperIdentitiesRequest)) {
            return false;
        }
        MergeDeveloperIdentitiesRequest mergeDeveloperIdentitiesRequest = (MergeDeveloperIdentitiesRequest) obj;
        if (mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getSourceUserIdentifier() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getSourceUserIdentifier().equals(getSourceUserIdentifier())) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getDestinationUserIdentifier() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier().equals(getDestinationUserIdentifier())) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDeveloperProviderName() == null) {
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
        if (mergeDeveloperIdentitiesRequest.getDeveloperProviderName() != null && !mergeDeveloperIdentitiesRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getIdentityPoolId() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null || mergeDeveloperIdentitiesRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return true;
        }
        return false;
    }

    public String getDestinationUserIdentifier() {
        return this.destinationUserIdentifier;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getSourceUserIdentifier() {
        return this.sourceUserIdentifier;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getSourceUserIdentifier() == null) {
            hashCode = 0;
        } else {
            hashCode = getSourceUserIdentifier().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getDestinationUserIdentifier() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDestinationUserIdentifier().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getDeveloperProviderName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperProviderName().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getIdentityPoolId() != null) {
            r1 = getIdentityPoolId().hashCode();
        }
        return r03 + r1;
    }

    public void setDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getSourceUserIdentifier() != null) {
            sb.append("SourceUserIdentifier: " + getSourceUserIdentifier() + ",");
        }
        if (getDestinationUserIdentifier() != null) {
            sb.append("DestinationUserIdentifier: " + getDestinationUserIdentifier() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public MergeDeveloperIdentitiesRequest withDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
        return this;
    }
}
