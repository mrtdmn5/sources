package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class RoleMapping implements Serializable {
    private String ambiguousRoleResolution;
    private RulesConfigurationType rulesConfiguration;
    private String type;

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
        if (obj == null || !(obj instanceof RoleMapping)) {
            return false;
        }
        RoleMapping roleMapping = (RoleMapping) obj;
        if (roleMapping.getType() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getType() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (roleMapping.getType() != null && !roleMapping.getType().equals(getType())) {
            return false;
        }
        if (roleMapping.getAmbiguousRoleResolution() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAmbiguousRoleResolution() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (roleMapping.getAmbiguousRoleResolution() != null && !roleMapping.getAmbiguousRoleResolution().equals(getAmbiguousRoleResolution())) {
            return false;
        }
        if (roleMapping.getRulesConfiguration() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getRulesConfiguration() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (roleMapping.getRulesConfiguration() == null || roleMapping.getRulesConfiguration().equals(getRulesConfiguration())) {
            return true;
        }
        return false;
    }

    public String getAmbiguousRoleResolution() {
        return this.ambiguousRoleResolution;
    }

    public RulesConfigurationType getRulesConfiguration() {
        return this.rulesConfiguration;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getType() == null) {
            hashCode = 0;
        } else {
            hashCode = getType().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAmbiguousRoleResolution() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAmbiguousRoleResolution().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getRulesConfiguration() != null) {
            r1 = getRulesConfiguration().hashCode();
        }
        return r02 + r1;
    }

    public void setAmbiguousRoleResolution(String str) {
        this.ambiguousRoleResolution = str;
    }

    public void setRulesConfiguration(RulesConfigurationType rulesConfigurationType) {
        this.rulesConfiguration = rulesConfigurationType;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getType() != null) {
            sb.append("Type: " + getType() + ",");
        }
        if (getAmbiguousRoleResolution() != null) {
            sb.append("AmbiguousRoleResolution: " + getAmbiguousRoleResolution() + ",");
        }
        if (getRulesConfiguration() != null) {
            sb.append("RulesConfiguration: " + getRulesConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public RoleMapping withAmbiguousRoleResolution(String str) {
        this.ambiguousRoleResolution = str;
        return this;
    }

    public RoleMapping withRulesConfiguration(RulesConfigurationType rulesConfigurationType) {
        this.rulesConfiguration = rulesConfigurationType;
        return this;
    }

    public RoleMapping withType(String str) {
        this.type = str;
        return this;
    }

    public void setAmbiguousRoleResolution(AmbiguousRoleResolutionType ambiguousRoleResolutionType) {
        this.ambiguousRoleResolution = ambiguousRoleResolutionType.toString();
    }

    public void setType(RoleMappingType roleMappingType) {
        this.type = roleMappingType.toString();
    }

    public RoleMapping withAmbiguousRoleResolution(AmbiguousRoleResolutionType ambiguousRoleResolutionType) {
        this.ambiguousRoleResolution = ambiguousRoleResolutionType.toString();
        return this;
    }

    public RoleMapping withType(RoleMappingType roleMappingType) {
        this.type = roleMappingType.toString();
        return this;
    }
}
