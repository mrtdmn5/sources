package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class Grant {
    private Grantee grantee;
    private Permission permission;

    public Grant(Grantee grantee, Permission permission) {
        this.grantee = grantee;
        this.permission = permission;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.grantee;
        if (grantee == null) {
            if (grant.grantee != null) {
                return false;
            }
        } else if (!grantee.equals(grant.grantee)) {
            return false;
        }
        if (this.permission == grant.permission) {
            return true;
        }
        return false;
    }

    public Grantee getGrantee() {
        return this.grantee;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public int hashCode() {
        int hashCode;
        Grantee grantee = this.grantee;
        int r1 = 0;
        if (grantee == null) {
            hashCode = 0;
        } else {
            hashCode = grantee.hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        Permission permission = this.permission;
        if (permission != null) {
            r1 = permission.hashCode();
        }
        return r0 + r1;
    }

    public String toString() {
        return "Grant [grantee=" + this.grantee + ", permission=" + this.permission + "]";
    }
}
