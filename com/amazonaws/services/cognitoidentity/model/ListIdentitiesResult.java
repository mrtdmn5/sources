package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListIdentitiesResult implements Serializable {
    private List<IdentityDescription> identities;
    private String identityPoolId;
    private String nextToken;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentitiesResult)) {
            return false;
        }
        ListIdentitiesResult listIdentitiesResult = (ListIdentitiesResult) obj;
        if (listIdentitiesResult.getIdentityPoolId() == null) {
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
        if (listIdentitiesResult.getIdentityPoolId() != null && !listIdentitiesResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (listIdentitiesResult.getIdentities() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getIdentities() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listIdentitiesResult.getIdentities() != null && !listIdentitiesResult.getIdentities().equals(getIdentities())) {
            return false;
        }
        if (listIdentitiesResult.getNextToken() == null) {
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
        if (listIdentitiesResult.getNextToken() == null || listIdentitiesResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public List<IdentityDescription> getIdentities() {
        return this.identities;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getIdentities() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentities().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getNextToken() != null) {
            r1 = getNextToken().hashCode();
        }
        return r02 + r1;
    }

    public void setIdentities(Collection<IdentityDescription> collection) {
        if (collection == null) {
            this.identities = null;
        } else {
            this.identities = new ArrayList(collection);
        }
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentities() != null) {
            sb.append("Identities: " + getIdentities() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentitiesResult withIdentities(IdentityDescription... identityDescriptionArr) {
        if (getIdentities() == null) {
            this.identities = new ArrayList(identityDescriptionArr.length);
        }
        for (IdentityDescription identityDescription : identityDescriptionArr) {
            this.identities.add(identityDescription);
        }
        return this;
    }

    public ListIdentitiesResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public ListIdentitiesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListIdentitiesResult withIdentities(Collection<IdentityDescription> collection) {
        setIdentities(collection);
        return this;
    }
}
