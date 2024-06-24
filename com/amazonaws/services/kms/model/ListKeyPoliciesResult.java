package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListKeyPoliciesResult implements Serializable {
    private String nextMarker;
    private List<String> policyNames = new ArrayList();
    private Boolean truncated;

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
        if (obj == null || !(obj instanceof ListKeyPoliciesResult)) {
            return false;
        }
        ListKeyPoliciesResult listKeyPoliciesResult = (ListKeyPoliciesResult) obj;
        if (listKeyPoliciesResult.getPolicyNames() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPolicyNames() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listKeyPoliciesResult.getPolicyNames() != null && !listKeyPoliciesResult.getPolicyNames().equals(getPolicyNames())) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getNextMarker() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() != null && !listKeyPoliciesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listKeyPoliciesResult.getTruncated() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTruncated() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listKeyPoliciesResult.getTruncated() == null || listKeyPoliciesResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<String> getPolicyNames() {
        return this.policyNames;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getPolicyNames() == null) {
            hashCode = 0;
        } else {
            hashCode = getPolicyNames().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getNextMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNextMarker().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTruncated() != null) {
            r1 = getTruncated().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            this.policyNames = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPolicyNames() != null) {
            sb.append("PolicyNames: " + getPolicyNames() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListKeyPoliciesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            this.policyNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.policyNames.add(str);
        }
        return this;
    }

    public ListKeyPoliciesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(Collection<String> collection) {
        setPolicyNames(collection);
        return this;
    }
}
