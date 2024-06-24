package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CustomKeyStoresListEntry implements Serializable {
    private String cloudHsmClusterId;
    private String connectionErrorCode;
    private String connectionState;
    private Date creationDate;
    private String customKeyStoreId;
    private String customKeyStoreName;
    private String customKeyStoreType;
    private String trustAnchorCertificate;
    private XksProxyConfigurationType xksProxyConfiguration;

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
        if (obj == null || !(obj instanceof CustomKeyStoresListEntry)) {
            return false;
        }
        CustomKeyStoresListEntry customKeyStoresListEntry = (CustomKeyStoresListEntry) obj;
        if (customKeyStoresListEntry.getCustomKeyStoreId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCustomKeyStoreId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreId() != null && !customKeyStoresListEntry.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCustomKeyStoreName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreName() != null && !customKeyStoresListEntry.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if (customKeyStoresListEntry.getCloudHsmClusterId() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getCloudHsmClusterId() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (customKeyStoresListEntry.getCloudHsmClusterId() != null && !customKeyStoresListEntry.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if (customKeyStoresListEntry.getTrustAnchorCertificate() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getTrustAnchorCertificate() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (customKeyStoresListEntry.getTrustAnchorCertificate() != null && !customKeyStoresListEntry.getTrustAnchorCertificate().equals(getTrustAnchorCertificate())) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionState() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getConnectionState() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionState() != null && !customKeyStoresListEntry.getConnectionState().equals(getConnectionState())) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionErrorCode() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getConnectionErrorCode() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionErrorCode() != null && !customKeyStoresListEntry.getConnectionErrorCode().equals(getConnectionErrorCode())) {
            return false;
        }
        if (customKeyStoresListEntry.getCreationDate() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getCreationDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (customKeyStoresListEntry.getCreationDate() != null && !customKeyStoresListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreType() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getCustomKeyStoreType() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreType() != null && !customKeyStoresListEntry.getCustomKeyStoreType().equals(getCustomKeyStoreType())) {
            return false;
        }
        if (customKeyStoresListEntry.getXksProxyConfiguration() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getXksProxyConfiguration() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (customKeyStoresListEntry.getXksProxyConfiguration() == null || customKeyStoresListEntry.getXksProxyConfiguration().equals(getXksProxyConfiguration())) {
            return true;
        }
        return false;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getConnectionErrorCode() {
        return this.connectionErrorCode;
    }

    public String getConnectionState() {
        return this.connectionState;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public String getCustomKeyStoreType() {
        return this.customKeyStoreType;
    }

    public String getTrustAnchorCertificate() {
        return this.trustAnchorCertificate;
    }

    public XksProxyConfigurationType getXksProxyConfiguration() {
        return this.xksProxyConfiguration;
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
        if (getCustomKeyStoreId() == null) {
            hashCode = 0;
        } else {
            hashCode = getCustomKeyStoreId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getCustomKeyStoreName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCustomKeyStoreName().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getCloudHsmClusterId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCloudHsmClusterId().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getTrustAnchorCertificate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getTrustAnchorCertificate().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getConnectionState() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getConnectionState().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getConnectionErrorCode() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getConnectionErrorCode().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getCreationDate() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCreationDate().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getCustomKeyStoreType() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getCustomKeyStoreType().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getXksProxyConfiguration() != null) {
            r1 = getXksProxyConfiguration().hashCode();
        }
        return r08 + r1;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setConnectionErrorCode(String str) {
        this.connectionErrorCode = str;
    }

    public void setConnectionState(String str) {
        this.connectionState = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public void setCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
    }

    public void setTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
    }

    public void setXksProxyConfiguration(XksProxyConfigurationType xksProxyConfigurationType) {
        this.xksProxyConfiguration = xksProxyConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getCustomKeyStoreName() != null) {
            sb.append("CustomKeyStoreName: " + getCustomKeyStoreName() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
        }
        if (getTrustAnchorCertificate() != null) {
            sb.append("TrustAnchorCertificate: " + getTrustAnchorCertificate() + ",");
        }
        if (getConnectionState() != null) {
            sb.append("ConnectionState: " + getConnectionState() + ",");
        }
        if (getConnectionErrorCode() != null) {
            sb.append("ConnectionErrorCode: " + getConnectionErrorCode() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getCustomKeyStoreType() != null) {
            sb.append("CustomKeyStoreType: " + getCustomKeyStoreType() + ",");
        }
        if (getXksProxyConfiguration() != null) {
            sb.append("XksProxyConfiguration: " + getXksProxyConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public CustomKeyStoresListEntry withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public CustomKeyStoresListEntry withConnectionErrorCode(String str) {
        this.connectionErrorCode = str;
        return this;
    }

    public CustomKeyStoresListEntry withConnectionState(String str) {
        this.connectionState = str;
        return this;
    }

    public CustomKeyStoresListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
        return this;
    }

    public CustomKeyStoresListEntry withTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
        return this;
    }

    public CustomKeyStoresListEntry withXksProxyConfiguration(XksProxyConfigurationType xksProxyConfigurationType) {
        this.xksProxyConfiguration = xksProxyConfigurationType;
        return this;
    }

    public void setConnectionErrorCode(ConnectionErrorCodeType connectionErrorCodeType) {
        this.connectionErrorCode = connectionErrorCodeType.toString();
    }

    public void setConnectionState(ConnectionStateType connectionStateType) {
        this.connectionState = connectionStateType.toString();
    }

    public void setCustomKeyStoreType(CustomKeyStoreType customKeyStoreType) {
        this.customKeyStoreType = customKeyStoreType.toString();
    }

    public CustomKeyStoresListEntry withConnectionErrorCode(ConnectionErrorCodeType connectionErrorCodeType) {
        this.connectionErrorCode = connectionErrorCodeType.toString();
        return this;
    }

    public CustomKeyStoresListEntry withConnectionState(ConnectionStateType connectionStateType) {
        this.connectionState = connectionStateType.toString();
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreType(CustomKeyStoreType customKeyStoreType) {
        this.customKeyStoreType = customKeyStoreType.toString();
        return this;
    }
}
