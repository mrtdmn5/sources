package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GetKeyRotationStatusResult implements Serializable {
    private Boolean keyRotationEnabled;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyRotationStatusResult)) {
            return false;
        }
        GetKeyRotationStatusResult getKeyRotationStatusResult = (GetKeyRotationStatusResult) obj;
        if (getKeyRotationStatusResult.getKeyRotationEnabled() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyRotationEnabled() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (getKeyRotationStatusResult.getKeyRotationEnabled() == null || getKeyRotationStatusResult.getKeyRotationEnabled().equals(getKeyRotationEnabled())) {
            return true;
        }
        return false;
    }

    public Boolean getKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public int hashCode() {
        int hashCode;
        if (getKeyRotationEnabled() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyRotationEnabled().hashCode();
        }
        return 31 + hashCode;
    }

    public Boolean isKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public void setKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyRotationEnabled() != null) {
            sb.append("KeyRotationEnabled: " + getKeyRotationEnabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetKeyRotationStatusResult withKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
        return this;
    }
}
