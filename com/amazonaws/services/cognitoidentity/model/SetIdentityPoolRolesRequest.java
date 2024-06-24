package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SetIdentityPoolRolesRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;
    private Map<String, RoleMapping> roleMappings;
    private Map<String, String> roles;

    public SetIdentityPoolRolesRequest addRoleMappingsEntry(String str, RoleMapping roleMapping) {
        if (this.roleMappings == null) {
            this.roleMappings = new HashMap();
        }
        if (!this.roleMappings.containsKey(str)) {
            this.roleMappings.put(str, roleMapping);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public SetIdentityPoolRolesRequest addRolesEntry(String str, String str2) {
        if (this.roles == null) {
            this.roles = new HashMap();
        }
        if (!this.roles.containsKey(str)) {
            this.roles.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public SetIdentityPoolRolesRequest clearRoleMappingsEntries() {
        this.roleMappings = null;
        return this;
    }

    public SetIdentityPoolRolesRequest clearRolesEntries() {
        this.roles = null;
        return this;
    }

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
        if (obj == null || !(obj instanceof SetIdentityPoolRolesRequest)) {
            return false;
        }
        SetIdentityPoolRolesRequest setIdentityPoolRolesRequest = (SetIdentityPoolRolesRequest) obj;
        if (setIdentityPoolRolesRequest.getIdentityPoolId() == null) {
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
        if (setIdentityPoolRolesRequest.getIdentityPoolId() != null && !setIdentityPoolRolesRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoles() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getRoles() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoles() != null && !setIdentityPoolRolesRequest.getRoles().equals(getRoles())) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoleMappings() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getRoleMappings() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoleMappings() == null || setIdentityPoolRolesRequest.getRoleMappings().equals(getRoleMappings())) {
            return true;
        }
        return false;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, RoleMapping> getRoleMappings() {
        return this.roleMappings;
    }

    public Map<String, String> getRoles() {
        return this.roles;
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
        if (getRoles() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRoles().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getRoleMappings() != null) {
            r1 = getRoleMappings().hashCode();
        }
        return r02 + r1;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
    }

    public void setRoles(Map<String, String> map) {
        this.roles = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getRoles() != null) {
            sb.append("Roles: " + getRoles() + ",");
        }
        if (getRoleMappings() != null) {
            sb.append("RoleMappings: " + getRoleMappings());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetIdentityPoolRolesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public SetIdentityPoolRolesRequest withRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
        return this;
    }

    public SetIdentityPoolRolesRequest withRoles(Map<String, String> map) {
        this.roles = map;
        return this;
    }
}
