package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeIdentityResult implements Serializable {
    private Date creationDate;
    private String identityId;
    private Date lastModifiedDate;
    private List<String> logins;

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
        if (obj == null || !(obj instanceof DescribeIdentityResult)) {
            return false;
        }
        DescribeIdentityResult describeIdentityResult = (DescribeIdentityResult) obj;
        if (describeIdentityResult.getIdentityId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getIdentityId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (describeIdentityResult.getIdentityId() != null && !describeIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (describeIdentityResult.getLogins() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getLogins() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (describeIdentityResult.getLogins() != null && !describeIdentityResult.getLogins().equals(getLogins())) {
            return false;
        }
        if (describeIdentityResult.getCreationDate() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getCreationDate() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (describeIdentityResult.getCreationDate() != null && !describeIdentityResult.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (describeIdentityResult.getLastModifiedDate() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getLastModifiedDate() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (describeIdentityResult.getLastModifiedDate() == null || describeIdentityResult.getLastModifiedDate().equals(getLastModifiedDate())) {
            return true;
        }
        return false;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public List<String> getLogins() {
        return this.logins;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getLogins() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLogins().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getCreationDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCreationDate().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getLastModifiedDate() != null) {
            r1 = getLastModifiedDate().hashCode();
        }
        return r03 + r1;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setLogins(Collection<String> collection) {
        if (collection == null) {
            this.logins = null;
        } else {
            this.logins = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeIdentityResult withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public DescribeIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public DescribeIdentityResult withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public DescribeIdentityResult withLogins(String... strArr) {
        if (getLogins() == null) {
            this.logins = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logins.add(str);
        }
        return this;
    }

    public DescribeIdentityResult withLogins(Collection<String> collection) {
        setLogins(collection);
        return this;
    }
}
