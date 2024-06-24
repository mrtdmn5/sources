package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListIdentityPoolsResult implements Serializable {
    private List<IdentityPoolShortDescription> identityPools;
    private String nextToken;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentityPoolsResult)) {
            return false;
        }
        ListIdentityPoolsResult listIdentityPoolsResult = (ListIdentityPoolsResult) obj;
        if (listIdentityPoolsResult.getIdentityPools() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityPools() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listIdentityPoolsResult.getIdentityPools() != null && !listIdentityPoolsResult.getIdentityPools().equals(getIdentityPools())) {
            return false;
        }
        if (listIdentityPoolsResult.getNextToken() == null) {
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
        if (listIdentityPoolsResult.getNextToken() == null || listIdentityPoolsResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public List<IdentityPoolShortDescription> getIdentityPools() {
        return this.identityPools;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getIdentityPools() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPools().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            r1 = getNextToken().hashCode();
        }
        return r0 + r1;
    }

    public void setIdentityPools(Collection<IdentityPoolShortDescription> collection) {
        if (collection == null) {
            this.identityPools = null;
        } else {
            this.identityPools = new ArrayList(collection);
        }
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPools() != null) {
            sb.append("IdentityPools: " + getIdentityPools() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentityPoolsResult withIdentityPools(IdentityPoolShortDescription... identityPoolShortDescriptionArr) {
        if (getIdentityPools() == null) {
            this.identityPools = new ArrayList(identityPoolShortDescriptionArr.length);
        }
        for (IdentityPoolShortDescription identityPoolShortDescription : identityPoolShortDescriptionArr) {
            this.identityPools.add(identityPoolShortDescription);
        }
        return this;
    }

    public ListIdentityPoolsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListIdentityPoolsResult withIdentityPools(Collection<IdentityPoolShortDescription> collection) {
        setIdentityPools(collection);
        return this;
    }
}
