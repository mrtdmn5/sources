package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class KeyMetadata implements Serializable {
    private String aWSAccountId;
    private String arn;
    private String cloudHsmClusterId;
    private Date creationDate;
    private String customKeyStoreId;
    private String customerMasterKeySpec;
    private Date deletionDate;
    private String description;
    private Boolean enabled;
    private String expirationModel;
    private String keyId;
    private String keyManager;
    private String keySpec;
    private String keyState;
    private String keyUsage;
    private Boolean multiRegion;
    private MultiRegionConfiguration multiRegionConfiguration;
    private String origin;
    private Integer pendingDeletionWindowInDays;
    private Date validTo;
    private XksKeyConfigurationType xksKeyConfiguration;
    private List<String> encryptionAlgorithms = new ArrayList();
    private List<String> signingAlgorithms = new ArrayList();
    private List<String> macAlgorithms = new ArrayList();

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
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        boolean z44;
        boolean z45;
        boolean z46;
        boolean z47;
        boolean z48;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyMetadata)) {
            return false;
        }
        KeyMetadata keyMetadata = (KeyMetadata) obj;
        if (keyMetadata.getAWSAccountId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAWSAccountId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (keyMetadata.getAWSAccountId() != null && !keyMetadata.getAWSAccountId().equals(getAWSAccountId())) {
            return false;
        }
        if (keyMetadata.getKeyId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getKeyId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (keyMetadata.getKeyId() != null && !keyMetadata.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (keyMetadata.getArn() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getArn() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (keyMetadata.getArn() != null && !keyMetadata.getArn().equals(getArn())) {
            return false;
        }
        if (keyMetadata.getCreationDate() == null) {
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
        if (keyMetadata.getCreationDate() != null && !keyMetadata.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (keyMetadata.getEnabled() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getEnabled() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (keyMetadata.getEnabled() != null && !keyMetadata.getEnabled().equals(getEnabled())) {
            return false;
        }
        if (keyMetadata.getDescription() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getDescription() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (keyMetadata.getDescription() != null && !keyMetadata.getDescription().equals(getDescription())) {
            return false;
        }
        if (keyMetadata.getKeyUsage() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getKeyUsage() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (keyMetadata.getKeyUsage() != null && !keyMetadata.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if (keyMetadata.getKeyState() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getKeyState() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (keyMetadata.getKeyState() != null && !keyMetadata.getKeyState().equals(getKeyState())) {
            return false;
        }
        if (keyMetadata.getDeletionDate() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getDeletionDate() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (keyMetadata.getDeletionDate() != null && !keyMetadata.getDeletionDate().equals(getDeletionDate())) {
            return false;
        }
        if (keyMetadata.getValidTo() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (getValidTo() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z19 ^ z20) {
            return false;
        }
        if (keyMetadata.getValidTo() != null && !keyMetadata.getValidTo().equals(getValidTo())) {
            return false;
        }
        if (keyMetadata.getOrigin() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (getOrigin() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z21 ^ z22) {
            return false;
        }
        if (keyMetadata.getOrigin() != null && !keyMetadata.getOrigin().equals(getOrigin())) {
            return false;
        }
        if (keyMetadata.getCustomKeyStoreId() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (getCustomKeyStoreId() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (z23 ^ z24) {
            return false;
        }
        if (keyMetadata.getCustomKeyStoreId() != null && !keyMetadata.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (keyMetadata.getCloudHsmClusterId() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (getCloudHsmClusterId() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z25 ^ z26) {
            return false;
        }
        if (keyMetadata.getCloudHsmClusterId() != null && !keyMetadata.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if (keyMetadata.getExpirationModel() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (getExpirationModel() == null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z27 ^ z28) {
            return false;
        }
        if (keyMetadata.getExpirationModel() != null && !keyMetadata.getExpirationModel().equals(getExpirationModel())) {
            return false;
        }
        if (keyMetadata.getKeyManager() == null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (getKeyManager() == null) {
            z30 = true;
        } else {
            z30 = false;
        }
        if (z29 ^ z30) {
            return false;
        }
        if (keyMetadata.getKeyManager() != null && !keyMetadata.getKeyManager().equals(getKeyManager())) {
            return false;
        }
        if (keyMetadata.getCustomerMasterKeySpec() == null) {
            z31 = true;
        } else {
            z31 = false;
        }
        if (getCustomerMasterKeySpec() == null) {
            z32 = true;
        } else {
            z32 = false;
        }
        if (z31 ^ z32) {
            return false;
        }
        if (keyMetadata.getCustomerMasterKeySpec() != null && !keyMetadata.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if (keyMetadata.getKeySpec() == null) {
            z33 = true;
        } else {
            z33 = false;
        }
        if (getKeySpec() == null) {
            z34 = true;
        } else {
            z34 = false;
        }
        if (z33 ^ z34) {
            return false;
        }
        if (keyMetadata.getKeySpec() != null && !keyMetadata.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if (keyMetadata.getEncryptionAlgorithms() == null) {
            z35 = true;
        } else {
            z35 = false;
        }
        if (getEncryptionAlgorithms() == null) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (z35 ^ z36) {
            return false;
        }
        if (keyMetadata.getEncryptionAlgorithms() != null && !keyMetadata.getEncryptionAlgorithms().equals(getEncryptionAlgorithms())) {
            return false;
        }
        if (keyMetadata.getSigningAlgorithms() == null) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (getSigningAlgorithms() == null) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (z37 ^ z38) {
            return false;
        }
        if (keyMetadata.getSigningAlgorithms() != null && !keyMetadata.getSigningAlgorithms().equals(getSigningAlgorithms())) {
            return false;
        }
        if (keyMetadata.getMultiRegion() == null) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (getMultiRegion() == null) {
            z40 = true;
        } else {
            z40 = false;
        }
        if (z39 ^ z40) {
            return false;
        }
        if (keyMetadata.getMultiRegion() != null && !keyMetadata.getMultiRegion().equals(getMultiRegion())) {
            return false;
        }
        if (keyMetadata.getMultiRegionConfiguration() == null) {
            z41 = true;
        } else {
            z41 = false;
        }
        if (getMultiRegionConfiguration() == null) {
            z42 = true;
        } else {
            z42 = false;
        }
        if (z41 ^ z42) {
            return false;
        }
        if (keyMetadata.getMultiRegionConfiguration() != null && !keyMetadata.getMultiRegionConfiguration().equals(getMultiRegionConfiguration())) {
            return false;
        }
        if (keyMetadata.getPendingDeletionWindowInDays() == null) {
            z43 = true;
        } else {
            z43 = false;
        }
        if (getPendingDeletionWindowInDays() == null) {
            z44 = true;
        } else {
            z44 = false;
        }
        if (z43 ^ z44) {
            return false;
        }
        if (keyMetadata.getPendingDeletionWindowInDays() != null && !keyMetadata.getPendingDeletionWindowInDays().equals(getPendingDeletionWindowInDays())) {
            return false;
        }
        if (keyMetadata.getMacAlgorithms() == null) {
            z45 = true;
        } else {
            z45 = false;
        }
        if (getMacAlgorithms() == null) {
            z46 = true;
        } else {
            z46 = false;
        }
        if (z45 ^ z46) {
            return false;
        }
        if (keyMetadata.getMacAlgorithms() != null && !keyMetadata.getMacAlgorithms().equals(getMacAlgorithms())) {
            return false;
        }
        if (keyMetadata.getXksKeyConfiguration() == null) {
            z47 = true;
        } else {
            z47 = false;
        }
        if (getXksKeyConfiguration() == null) {
            z48 = true;
        } else {
            z48 = false;
        }
        if (z47 ^ z48) {
            return false;
        }
        if (keyMetadata.getXksKeyConfiguration() == null || keyMetadata.getXksKeyConfiguration().equals(getXksKeyConfiguration())) {
            return true;
        }
        return false;
    }

    public String getAWSAccountId() {
        return this.aWSAccountId;
    }

    public String getArn() {
        return this.arn;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public List<String> getEncryptionAlgorithms() {
        return this.encryptionAlgorithms;
    }

    public String getExpirationModel() {
        return this.expirationModel;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyManager() {
        return this.keyManager;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyState() {
        return this.keyState;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public List<String> getMacAlgorithms() {
        return this.macAlgorithms;
    }

    public Boolean getMultiRegion() {
        return this.multiRegion;
    }

    public MultiRegionConfiguration getMultiRegionConfiguration() {
        return this.multiRegionConfiguration;
    }

    public String getOrigin() {
        return this.origin;
    }

    public Integer getPendingDeletionWindowInDays() {
        return this.pendingDeletionWindowInDays;
    }

    public List<String> getSigningAlgorithms() {
        return this.signingAlgorithms;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public XksKeyConfigurationType getXksKeyConfiguration() {
        return this.xksKeyConfiguration;
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
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        int hashCode19;
        int hashCode20;
        int hashCode21;
        int hashCode22;
        int hashCode23;
        int r1 = 0;
        if (getAWSAccountId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAWSAccountId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getKeyId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getKeyId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getArn() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getArn().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCreationDate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCreationDate().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getEnabled() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getEnabled().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getDescription() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getDescription().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getKeyUsage() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getKeyUsage().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getKeyState() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getKeyState().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getDeletionDate() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getDeletionDate().hashCode();
        }
        int r09 = (r08 + hashCode9) * 31;
        if (getValidTo() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getValidTo().hashCode();
        }
        int r010 = (r09 + hashCode10) * 31;
        if (getOrigin() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getOrigin().hashCode();
        }
        int r011 = (r010 + hashCode11) * 31;
        if (getCustomKeyStoreId() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getCustomKeyStoreId().hashCode();
        }
        int r012 = (r011 + hashCode12) * 31;
        if (getCloudHsmClusterId() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getCloudHsmClusterId().hashCode();
        }
        int r013 = (r012 + hashCode13) * 31;
        if (getExpirationModel() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getExpirationModel().hashCode();
        }
        int r014 = (r013 + hashCode14) * 31;
        if (getKeyManager() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getKeyManager().hashCode();
        }
        int r015 = (r014 + hashCode15) * 31;
        if (getCustomerMasterKeySpec() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = getCustomerMasterKeySpec().hashCode();
        }
        int r016 = (r015 + hashCode16) * 31;
        if (getKeySpec() == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = getKeySpec().hashCode();
        }
        int r017 = (r016 + hashCode17) * 31;
        if (getEncryptionAlgorithms() == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = getEncryptionAlgorithms().hashCode();
        }
        int r018 = (r017 + hashCode18) * 31;
        if (getSigningAlgorithms() == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = getSigningAlgorithms().hashCode();
        }
        int r019 = (r018 + hashCode19) * 31;
        if (getMultiRegion() == null) {
            hashCode20 = 0;
        } else {
            hashCode20 = getMultiRegion().hashCode();
        }
        int r020 = (r019 + hashCode20) * 31;
        if (getMultiRegionConfiguration() == null) {
            hashCode21 = 0;
        } else {
            hashCode21 = getMultiRegionConfiguration().hashCode();
        }
        int r021 = (r020 + hashCode21) * 31;
        if (getPendingDeletionWindowInDays() == null) {
            hashCode22 = 0;
        } else {
            hashCode22 = getPendingDeletionWindowInDays().hashCode();
        }
        int r022 = (r021 + hashCode22) * 31;
        if (getMacAlgorithms() == null) {
            hashCode23 = 0;
        } else {
            hashCode23 = getMacAlgorithms().hashCode();
        }
        int r023 = (r022 + hashCode23) * 31;
        if (getXksKeyConfiguration() != null) {
            r1 = getXksKeyConfiguration().hashCode();
        }
        return r023 + r1;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean isMultiRegion() {
        return this.multiRegion;
    }

    public void setAWSAccountId(String str) {
        this.aWSAccountId = str;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setDeletionDate(Date date) {
        this.deletionDate = date;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public void setEncryptionAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.encryptionAlgorithms = null;
        } else {
            this.encryptionAlgorithms = new ArrayList(collection);
        }
    }

    public void setExpirationModel(String str) {
        this.expirationModel = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyManager(String str) {
        this.keyManager = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyState(String str) {
        this.keyState = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setMacAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.macAlgorithms = null;
        } else {
            this.macAlgorithms = new ArrayList(collection);
        }
    }

    public void setMultiRegion(Boolean bool) {
        this.multiRegion = bool;
    }

    public void setMultiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration) {
        this.multiRegionConfiguration = multiRegionConfiguration;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setPendingDeletionWindowInDays(Integer num) {
        this.pendingDeletionWindowInDays = num;
    }

    public void setSigningAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.signingAlgorithms = null;
        } else {
            this.signingAlgorithms = new ArrayList(collection);
        }
    }

    public void setValidTo(Date date) {
        this.validTo = date;
    }

    public void setXksKeyConfiguration(XksKeyConfigurationType xksKeyConfigurationType) {
        this.xksKeyConfiguration = xksKeyConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAWSAccountId() != null) {
            sb.append("AWSAccountId: " + getAWSAccountId() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + ",");
        }
        if (getKeyUsage() != null) {
            sb.append("KeyUsage: " + getKeyUsage() + ",");
        }
        if (getKeyState() != null) {
            sb.append("KeyState: " + getKeyState() + ",");
        }
        if (getDeletionDate() != null) {
            sb.append("DeletionDate: " + getDeletionDate() + ",");
        }
        if (getValidTo() != null) {
            sb.append("ValidTo: " + getValidTo() + ",");
        }
        if (getOrigin() != null) {
            sb.append("Origin: " + getOrigin() + ",");
        }
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
        }
        if (getExpirationModel() != null) {
            sb.append("ExpirationModel: " + getExpirationModel() + ",");
        }
        if (getKeyManager() != null) {
            sb.append("KeyManager: " + getKeyManager() + ",");
        }
        if (getCustomerMasterKeySpec() != null) {
            sb.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + ",");
        }
        if (getKeySpec() != null) {
            sb.append("KeySpec: " + getKeySpec() + ",");
        }
        if (getEncryptionAlgorithms() != null) {
            sb.append("EncryptionAlgorithms: " + getEncryptionAlgorithms() + ",");
        }
        if (getSigningAlgorithms() != null) {
            sb.append("SigningAlgorithms: " + getSigningAlgorithms() + ",");
        }
        if (getMultiRegion() != null) {
            sb.append("MultiRegion: " + getMultiRegion() + ",");
        }
        if (getMultiRegionConfiguration() != null) {
            sb.append("MultiRegionConfiguration: " + getMultiRegionConfiguration() + ",");
        }
        if (getPendingDeletionWindowInDays() != null) {
            sb.append("PendingDeletionWindowInDays: " + getPendingDeletionWindowInDays() + ",");
        }
        if (getMacAlgorithms() != null) {
            sb.append("MacAlgorithms: " + getMacAlgorithms() + ",");
        }
        if (getXksKeyConfiguration() != null) {
            sb.append("XksKeyConfiguration: " + getXksKeyConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public KeyMetadata withAWSAccountId(String str) {
        this.aWSAccountId = str;
        return this;
    }

    public KeyMetadata withArn(String str) {
        this.arn = str;
        return this;
    }

    public KeyMetadata withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public KeyMetadata withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public KeyMetadata withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public KeyMetadata withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public KeyMetadata withDeletionDate(Date date) {
        this.deletionDate = date;
        return this;
    }

    public KeyMetadata withDescription(String str) {
        this.description = str;
        return this;
    }

    public KeyMetadata withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public KeyMetadata withEncryptionAlgorithms(String... strArr) {
        if (getEncryptionAlgorithms() == null) {
            this.encryptionAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.encryptionAlgorithms.add(str);
        }
        return this;
    }

    public KeyMetadata withExpirationModel(String str) {
        this.expirationModel = str;
        return this;
    }

    public KeyMetadata withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public KeyMetadata withKeyManager(String str) {
        this.keyManager = str;
        return this;
    }

    public KeyMetadata withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public KeyMetadata withKeyState(String str) {
        this.keyState = str;
        return this;
    }

    public KeyMetadata withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public KeyMetadata withMacAlgorithms(String... strArr) {
        if (getMacAlgorithms() == null) {
            this.macAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.macAlgorithms.add(str);
        }
        return this;
    }

    public KeyMetadata withMultiRegion(Boolean bool) {
        this.multiRegion = bool;
        return this;
    }

    public KeyMetadata withMultiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration) {
        this.multiRegionConfiguration = multiRegionConfiguration;
        return this;
    }

    public KeyMetadata withOrigin(String str) {
        this.origin = str;
        return this;
    }

    public KeyMetadata withPendingDeletionWindowInDays(Integer num) {
        this.pendingDeletionWindowInDays = num;
        return this;
    }

    public KeyMetadata withSigningAlgorithms(String... strArr) {
        if (getSigningAlgorithms() == null) {
            this.signingAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.signingAlgorithms.add(str);
        }
        return this;
    }

    public KeyMetadata withValidTo(Date date) {
        this.validTo = date;
        return this;
    }

    public KeyMetadata withXksKeyConfiguration(XksKeyConfigurationType xksKeyConfigurationType) {
        this.xksKeyConfiguration = xksKeyConfigurationType;
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
    }

    public void setExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
    }

    public void setKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
    }

    public void setKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
    }

    public void setKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public void setOrigin(OriginType originType) {
        this.origin = originType.toString();
    }

    public KeyMetadata withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
        return this;
    }

    public KeyMetadata withExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
        return this;
    }

    public KeyMetadata withKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
        return this;
    }

    public KeyMetadata withKeySpec(KeySpec keySpec) {
        this.keySpec = keySpec.toString();
        return this;
    }

    public KeyMetadata withKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
        return this;
    }

    public KeyMetadata withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public KeyMetadata withOrigin(OriginType originType) {
        this.origin = originType.toString();
        return this;
    }

    public KeyMetadata withEncryptionAlgorithms(Collection<String> collection) {
        setEncryptionAlgorithms(collection);
        return this;
    }

    public KeyMetadata withMacAlgorithms(Collection<String> collection) {
        setMacAlgorithms(collection);
        return this;
    }

    public KeyMetadata withSigningAlgorithms(Collection<String> collection) {
        setSigningAlgorithms(collection);
        return this;
    }
}
