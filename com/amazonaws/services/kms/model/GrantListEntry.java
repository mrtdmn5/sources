package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class GrantListEntry implements Serializable {
    private GrantConstraints constraints;
    private Date creationDate;
    private String grantId;
    private String granteePrincipal;
    private String issuingAccount;
    private String keyId;
    private String name;
    private List<String> operations = new ArrayList();
    private String retiringPrincipal;

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
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantListEntry)) {
            return false;
        }
        GrantListEntry grantListEntry = (GrantListEntry) obj;
        if (grantListEntry.getKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (grantListEntry.getKeyId() != null && !grantListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (grantListEntry.getGrantId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getGrantId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (grantListEntry.getGrantId() != null && !grantListEntry.getGrantId().equals(getGrantId())) {
            return false;
        }
        if (grantListEntry.getName() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getName() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (grantListEntry.getName() != null && !grantListEntry.getName().equals(getName())) {
            return false;
        }
        if (grantListEntry.getCreationDate() == null) {
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
        if (grantListEntry.getCreationDate() != null && !grantListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (grantListEntry.getGranteePrincipal() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getGranteePrincipal() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (grantListEntry.getGranteePrincipal() != null && !grantListEntry.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if (grantListEntry.getRetiringPrincipal() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getRetiringPrincipal() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (grantListEntry.getRetiringPrincipal() != null && !grantListEntry.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if (grantListEntry.getIssuingAccount() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getIssuingAccount() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (grantListEntry.getIssuingAccount() != null && !grantListEntry.getIssuingAccount().equals(getIssuingAccount())) {
            return false;
        }
        if (grantListEntry.getOperations() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getOperations() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (grantListEntry.getOperations() != null && !grantListEntry.getOperations().equals(getOperations())) {
            return false;
        }
        if (grantListEntry.getConstraints() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getConstraints() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (grantListEntry.getConstraints() == null || grantListEntry.getConstraints().equals(getConstraints())) {
            return true;
        }
        return false;
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
    }

    public String getIssuingAccount() {
        return this.issuingAccount;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperations() {
        return this.operations;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getGrantId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getGrantId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getName().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCreationDate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCreationDate().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getGranteePrincipal() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getGranteePrincipal().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getRetiringPrincipal() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getRetiringPrincipal().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getIssuingAccount() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getIssuingAccount().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getOperations() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getOperations().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getConstraints() != null) {
            r1 = getConstraints().hashCode();
        }
        return r08 + r1;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
    }

    public void setIssuingAccount(String str) {
        this.issuingAccount = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperations(Collection<String> collection) {
        if (collection == null) {
            this.operations = null;
        } else {
            this.operations = new ArrayList(collection);
        }
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getGranteePrincipal() != null) {
            sb.append("GranteePrincipal: " + getGranteePrincipal() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal() + ",");
        }
        if (getIssuingAccount() != null) {
            sb.append("IssuingAccount: " + getIssuingAccount() + ",");
        }
        if (getOperations() != null) {
            sb.append("Operations: " + getOperations() + ",");
        }
        if (getConstraints() != null) {
            sb.append("Constraints: " + getConstraints());
        }
        sb.append("}");
        return sb.toString();
    }

    public GrantListEntry withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public GrantListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public GrantListEntry withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public GrantListEntry withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public GrantListEntry withIssuingAccount(String str) {
        this.issuingAccount = str;
        return this;
    }

    public GrantListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GrantListEntry withName(String str) {
        this.name = str;
        return this;
    }

    public GrantListEntry withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.operations.add(str);
        }
        return this;
    }

    public GrantListEntry withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public GrantListEntry withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }
}
