package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class AccessControlList implements Serializable, S3RequesterChargedResult {
    private static final long serialVersionUID = 8095040648034788376L;
    private List<Grant> grantList;
    private Set<Grant> grantSet;
    private boolean isRequesterCharged;
    private Owner owner = null;

    private void checkState() {
        if (this.grantSet != null && this.grantList != null) {
            throw new IllegalStateException("Both grant set and grant list cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessControlList accessControlList = (AccessControlList) obj;
        Owner owner = this.owner;
        if (owner == null) {
            if (accessControlList.owner != null) {
                return false;
            }
        } else if (!owner.equals(accessControlList.owner)) {
            return false;
        }
        Set<Grant> set = this.grantSet;
        if (set == null) {
            if (accessControlList.grantSet != null) {
                return false;
            }
        } else if (!set.equals(accessControlList.grantSet)) {
            return false;
        }
        List<Grant> list = this.grantList;
        if (list == null) {
            if (accessControlList.grantList != null) {
                return false;
            }
        } else if (!list.equals(accessControlList.grantList)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public Set<Grant> getGrants() {
        checkState();
        if (this.grantSet == null) {
            if (this.grantList == null) {
                this.grantSet = new HashSet();
            } else {
                this.grantSet = new HashSet(this.grantList);
                this.grantList = null;
            }
        }
        return this.grantSet;
    }

    public List<Grant> getGrantsAsList() {
        checkState();
        if (this.grantList == null) {
            if (this.grantSet == null) {
                this.grantList = new LinkedList();
            } else {
                this.grantList = new LinkedList(this.grantSet);
                this.grantSet = null;
            }
        }
        return this.grantList;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void grantAllPermissions(Grant... grantArr) {
        for (Grant grant : grantArr) {
            grantPermission(grant.getGrantee(), grant.getPermission());
        }
    }

    public void grantPermission(Grantee grantee, Permission permission) {
        getGrantsAsList().add(new Grant(grantee, permission));
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Owner owner = this.owner;
        int r1 = 0;
        if (owner == null) {
            hashCode = 0;
        } else {
            hashCode = owner.hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        Set<Grant> set = this.grantSet;
        if (set == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = set.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        List<Grant> list = this.grantList;
        if (list != null) {
            r1 = list.hashCode();
        }
        return r02 + r1;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void revokeAllPermissions(Grantee grantee) {
        ArrayList arrayList = new ArrayList();
        for (Grant grant : getGrantsAsList()) {
            if (grant.getGrantee().equals(grantee)) {
                arrayList.add(grant);
            }
        }
        this.grantList.removeAll(arrayList);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }

    public String toString() {
        return "AccessControlList [owner=" + this.owner + ", grants=" + getGrantsAsList() + "]";
    }
}
