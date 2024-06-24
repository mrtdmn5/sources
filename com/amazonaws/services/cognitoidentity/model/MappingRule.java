package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MappingRule implements Serializable {
    private String claim;
    private String matchType;
    private String roleARN;
    private String value;

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
        if (obj == null || !(obj instanceof MappingRule)) {
            return false;
        }
        MappingRule mappingRule = (MappingRule) obj;
        if (mappingRule.getClaim() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getClaim() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (mappingRule.getClaim() != null && !mappingRule.getClaim().equals(getClaim())) {
            return false;
        }
        if (mappingRule.getMatchType() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getMatchType() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (mappingRule.getMatchType() != null && !mappingRule.getMatchType().equals(getMatchType())) {
            return false;
        }
        if (mappingRule.getValue() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getValue() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (mappingRule.getValue() != null && !mappingRule.getValue().equals(getValue())) {
            return false;
        }
        if (mappingRule.getRoleARN() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getRoleARN() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (mappingRule.getRoleARN() == null || mappingRule.getRoleARN().equals(getRoleARN())) {
            return true;
        }
        return false;
    }

    public String getClaim() {
        return this.claim;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public String getRoleARN() {
        return this.roleARN;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getClaim() == null) {
            hashCode = 0;
        } else {
            hashCode = getClaim().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getMatchType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMatchType().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getValue() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getValue().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getRoleARN() != null) {
            r1 = getRoleARN().hashCode();
        }
        return r03 + r1;
    }

    public void setClaim(String str) {
        this.claim = str;
    }

    public void setMatchType(String str) {
        this.matchType = str;
    }

    public void setRoleARN(String str) {
        this.roleARN = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getClaim() != null) {
            sb.append("Claim: " + getClaim() + ",");
        }
        if (getMatchType() != null) {
            sb.append("MatchType: " + getMatchType() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue() + ",");
        }
        if (getRoleARN() != null) {
            sb.append("RoleARN: " + getRoleARN());
        }
        sb.append("}");
        return sb.toString();
    }

    public MappingRule withClaim(String str) {
        this.claim = str;
        return this;
    }

    public MappingRule withMatchType(String str) {
        this.matchType = str;
        return this;
    }

    public MappingRule withRoleARN(String str) {
        this.roleARN = str;
        return this;
    }

    public MappingRule withValue(String str) {
        this.value = str;
        return this;
    }

    public void setMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
    }

    public MappingRule withMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
        return this;
    }
}
