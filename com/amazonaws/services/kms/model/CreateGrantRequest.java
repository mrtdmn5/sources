package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class CreateGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private GrantConstraints constraints;
    private String granteePrincipal;
    private String keyId;
    private String name;
    private String retiringPrincipal;
    private List<String> operations = new ArrayList();
    private List<String> grantTokens = new ArrayList();

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantRequest)) {
            return false;
        }
        CreateGrantRequest createGrantRequest = (CreateGrantRequest) obj;
        if (createGrantRequest.getKeyId() == null) {
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
        if (createGrantRequest.getKeyId() != null && !createGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (createGrantRequest.getGranteePrincipal() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getGranteePrincipal() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (createGrantRequest.getGranteePrincipal() != null && !createGrantRequest.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if (createGrantRequest.getRetiringPrincipal() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getRetiringPrincipal() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (createGrantRequest.getRetiringPrincipal() != null && !createGrantRequest.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if (createGrantRequest.getOperations() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getOperations() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (createGrantRequest.getOperations() != null && !createGrantRequest.getOperations().equals(getOperations())) {
            return false;
        }
        if (createGrantRequest.getConstraints() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getConstraints() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (createGrantRequest.getConstraints() != null && !createGrantRequest.getConstraints().equals(getConstraints())) {
            return false;
        }
        if (createGrantRequest.getGrantTokens() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getGrantTokens() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (createGrantRequest.getGrantTokens() != null && !createGrantRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if (createGrantRequest.getName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (createGrantRequest.getName() == null || createGrantRequest.getName().equals(getName())) {
            return true;
        }
        return false;
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
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
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getGranteePrincipal() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getGranteePrincipal().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getRetiringPrincipal() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getRetiringPrincipal().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getOperations() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getOperations().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getConstraints() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getConstraints().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getGrantTokens() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getGrantTokens().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getName() != null) {
            r1 = getName().hashCode();
        }
        return r06 + r1;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
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
        if (getGranteePrincipal() != null) {
            sb.append("GranteePrincipal: " + getGranteePrincipal() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal() + ",");
        }
        if (getOperations() != null) {
            sb.append("Operations: " + getOperations() + ",");
        }
        if (getConstraints() != null) {
            sb.append("Constraints: " + getConstraints() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateGrantRequest withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public CreateGrantRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public CreateGrantRequest withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public CreateGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public CreateGrantRequest withName(String str) {
        this.name = str;
        return this;
    }

    public CreateGrantRequest withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.operations.add(str);
        }
        return this;
    }

    public CreateGrantRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public CreateGrantRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public CreateGrantRequest withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }
}
