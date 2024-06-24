package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class DeleteIdentitiesResult implements Serializable {
    private List<UnprocessedIdentityId> unprocessedIdentityIds;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentitiesResult)) {
            return false;
        }
        DeleteIdentitiesResult deleteIdentitiesResult = (DeleteIdentitiesResult) obj;
        if (deleteIdentitiesResult.getUnprocessedIdentityIds() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getUnprocessedIdentityIds() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (deleteIdentitiesResult.getUnprocessedIdentityIds() == null || deleteIdentitiesResult.getUnprocessedIdentityIds().equals(getUnprocessedIdentityIds())) {
            return true;
        }
        return false;
    }

    public List<UnprocessedIdentityId> getUnprocessedIdentityIds() {
        return this.unprocessedIdentityIds;
    }

    public int hashCode() {
        int hashCode;
        if (getUnprocessedIdentityIds() == null) {
            hashCode = 0;
        } else {
            hashCode = getUnprocessedIdentityIds().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUnprocessedIdentityIds(Collection<UnprocessedIdentityId> collection) {
        if (collection == null) {
            this.unprocessedIdentityIds = null;
        } else {
            this.unprocessedIdentityIds = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUnprocessedIdentityIds() != null) {
            sb.append("UnprocessedIdentityIds: " + getUnprocessedIdentityIds());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteIdentitiesResult withUnprocessedIdentityIds(UnprocessedIdentityId... unprocessedIdentityIdArr) {
        if (getUnprocessedIdentityIds() == null) {
            this.unprocessedIdentityIds = new ArrayList(unprocessedIdentityIdArr.length);
        }
        for (UnprocessedIdentityId unprocessedIdentityId : unprocessedIdentityIdArr) {
            this.unprocessedIdentityIds.add(unprocessedIdentityId);
        }
        return this;
    }

    public DeleteIdentitiesResult withUnprocessedIdentityIds(Collection<UnprocessedIdentityId> collection) {
        setUnprocessedIdentityIds(collection);
        return this;
    }
}
