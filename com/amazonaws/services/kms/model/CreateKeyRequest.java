package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class CreateKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String customKeyStoreId;
    private String customerMasterKeySpec;
    private String description;
    private String keySpec;
    private String keyUsage;
    private Boolean multiRegion;
    private String origin;
    private String policy;
    private List<Tag> tags = new ArrayList();
    private String xksKeyId;

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
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateKeyRequest)) {
            return false;
        }
        CreateKeyRequest createKeyRequest = (CreateKeyRequest) obj;
        if (createKeyRequest.getPolicy() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPolicy() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (createKeyRequest.getPolicy() != null && !createKeyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (createKeyRequest.getDescription() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getDescription() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (createKeyRequest.getDescription() != null && !createKeyRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (createKeyRequest.getKeyUsage() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyUsage() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (createKeyRequest.getKeyUsage() != null && !createKeyRequest.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if (createKeyRequest.getCustomerMasterKeySpec() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getCustomerMasterKeySpec() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (createKeyRequest.getCustomerMasterKeySpec() != null && !createKeyRequest.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if (createKeyRequest.getKeySpec() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getKeySpec() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (createKeyRequest.getKeySpec() != null && !createKeyRequest.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if (createKeyRequest.getOrigin() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getOrigin() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (createKeyRequest.getOrigin() != null && !createKeyRequest.getOrigin().equals(getOrigin())) {
            return false;
        }
        if (createKeyRequest.getCustomKeyStoreId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getCustomKeyStoreId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (createKeyRequest.getCustomKeyStoreId() != null && !createKeyRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (createKeyRequest.getBypassPolicyLockoutSafetyCheck() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (createKeyRequest.getBypassPolicyLockoutSafetyCheck() != null && !createKeyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return false;
        }
        if (createKeyRequest.getTags() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getTags() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (createKeyRequest.getTags() != null && !createKeyRequest.getTags().equals(getTags())) {
            return false;
        }
        if (createKeyRequest.getMultiRegion() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (getMultiRegion() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z19 ^ z20) {
            return false;
        }
        if (createKeyRequest.getMultiRegion() != null && !createKeyRequest.getMultiRegion().equals(getMultiRegion())) {
            return false;
        }
        if (createKeyRequest.getXksKeyId() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (getXksKeyId() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z21 ^ z22) {
            return false;
        }
        if (createKeyRequest.getXksKeyId() == null || createKeyRequest.getXksKeyId().equals(getXksKeyId())) {
            return true;
        }
        return false;
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public Boolean getMultiRegion() {
        return this.multiRegion;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getXksKeyId() {
        return this.xksKeyId;
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
        int hashCode9;
        int hashCode10;
        int r1 = 0;
        if (getPolicy() == null) {
            hashCode = 0;
        } else {
            hashCode = getPolicy().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getDescription() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDescription().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyUsage() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyUsage().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCustomerMasterKeySpec() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCustomerMasterKeySpec().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getKeySpec() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getKeySpec().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getOrigin() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getOrigin().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getCustomKeyStoreId() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCustomKeyStoreId().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getTags() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getTags().hashCode();
        }
        int r09 = (r08 + hashCode9) * 31;
        if (getMultiRegion() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getMultiRegion().hashCode();
        }
        int r010 = (r09 + hashCode10) * 31;
        if (getXksKeyId() != null) {
            r1 = getXksKeyId().hashCode();
        }
        return r010 + r1;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public Boolean isMultiRegion() {
        return this.multiRegion;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setMultiRegion(Boolean bool) {
        this.multiRegion = bool;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setXksKeyId(String str) {
        this.xksKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + ",");
        }
        if (getKeyUsage() != null) {
            sb.append("KeyUsage: " + getKeyUsage() + ",");
        }
        if (getCustomerMasterKeySpec() != null) {
            sb.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + ",");
        }
        if (getKeySpec() != null) {
            sb.append("KeySpec: " + getKeySpec() + ",");
        }
        if (getOrigin() != null) {
            sb.append("Origin: " + getOrigin() + ",");
        }
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck() + ",");
        }
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
        }
        if (getMultiRegion() != null) {
            sb.append("MultiRegion: " + getMultiRegion() + ",");
        }
        if (getXksKeyId() != null) {
            sb.append("XksKeyId: " + getXksKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateKeyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public CreateKeyRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public CreateKeyRequest withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public CreateKeyRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateKeyRequest withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public CreateKeyRequest withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public CreateKeyRequest withMultiRegion(Boolean bool) {
        this.multiRegion = bool;
        return this;
    }

    public CreateKeyRequest withOrigin(String str) {
        this.origin = str;
        return this;
    }

    public CreateKeyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public CreateKeyRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public CreateKeyRequest withXksKeyId(String str) {
        this.xksKeyId = str;
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
    }

    public void setKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public void setOrigin(OriginType originType) {
        this.origin = originType.toString();
    }

    public CreateKeyRequest withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
        return this;
    }

    public CreateKeyRequest withKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
        return this;
    }

    public CreateKeyRequest withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public CreateKeyRequest withOrigin(OriginType originType) {
        this.origin = originType.toString();
        return this;
    }

    public CreateKeyRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
