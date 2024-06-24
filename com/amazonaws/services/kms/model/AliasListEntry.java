package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class AliasListEntry implements Serializable {
    private String aliasArn;
    private String aliasName;
    private Date creationDate;
    private Date lastUpdatedDate;
    private String targetKeyId;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AliasListEntry)) {
            return false;
        }
        AliasListEntry aliasListEntry = (AliasListEntry) obj;
        if (aliasListEntry.getAliasName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAliasName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (aliasListEntry.getAliasName() != null && !aliasListEntry.getAliasName().equals(getAliasName())) {
            return false;
        }
        if (aliasListEntry.getAliasArn() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAliasArn() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (aliasListEntry.getAliasArn() != null && !aliasListEntry.getAliasArn().equals(getAliasArn())) {
            return false;
        }
        if (aliasListEntry.getTargetKeyId() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTargetKeyId() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (aliasListEntry.getTargetKeyId() != null && !aliasListEntry.getTargetKeyId().equals(getTargetKeyId())) {
            return false;
        }
        if (aliasListEntry.getCreationDate() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getCreationDate() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (aliasListEntry.getCreationDate() != null && !aliasListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (aliasListEntry.getLastUpdatedDate() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getLastUpdatedDate() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (aliasListEntry.getLastUpdatedDate() == null || aliasListEntry.getLastUpdatedDate().equals(getLastUpdatedDate())) {
            return true;
        }
        return false;
    }

    public String getAliasArn() {
        return this.aliasArn;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public String getTargetKeyId() {
        return this.targetKeyId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getAliasName() == null) {
            hashCode = 0;
        } else {
            hashCode = getAliasName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAliasArn() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAliasArn().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTargetKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getTargetKeyId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCreationDate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCreationDate().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getLastUpdatedDate() != null) {
            r1 = getLastUpdatedDate().hashCode();
        }
        return r04 + r1;
    }

    public void setAliasArn(String str) {
        this.aliasArn = str;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setLastUpdatedDate(Date date) {
        this.lastUpdatedDate = date;
    }

    public void setTargetKeyId(String str) {
        this.targetKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAliasName() != null) {
            sb.append("AliasName: " + getAliasName() + ",");
        }
        if (getAliasArn() != null) {
            sb.append("AliasArn: " + getAliasArn() + ",");
        }
        if (getTargetKeyId() != null) {
            sb.append("TargetKeyId: " + getTargetKeyId() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getLastUpdatedDate() != null) {
            sb.append("LastUpdatedDate: " + getLastUpdatedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public AliasListEntry withAliasArn(String str) {
        this.aliasArn = str;
        return this;
    }

    public AliasListEntry withAliasName(String str) {
        this.aliasName = str;
        return this;
    }

    public AliasListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public AliasListEntry withLastUpdatedDate(Date date) {
        this.lastUpdatedDate = date;
        return this;
    }

    public AliasListEntry withTargetKeyId(String str) {
        this.targetKeyId = str;
        return this;
    }
}
