package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class XksKeyConfigurationType implements Serializable {
    private String id;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksKeyConfigurationType)) {
            return false;
        }
        XksKeyConfigurationType xksKeyConfigurationType = (XksKeyConfigurationType) obj;
        if (xksKeyConfigurationType.getId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (xksKeyConfigurationType.getId() == null || xksKeyConfigurationType.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode;
        if (getId() == null) {
            hashCode = 0;
        } else {
            hashCode = getId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getId() != null) {
            sb.append("Id: " + getId());
        }
        sb.append("}");
        return sb.toString();
    }

    public XksKeyConfigurationType withId(String str) {
        this.id = str;
        return this;
    }
}
