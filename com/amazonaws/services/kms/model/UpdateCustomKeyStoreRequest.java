package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class UpdateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreId;
    private String keyStorePassword;
    private String newCustomKeyStoreName;
    private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;
    private String xksProxyConnectivity;
    private String xksProxyUriEndpoint;
    private String xksProxyUriPath;
    private String xksProxyVpcEndpointServiceName;

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
        if (obj == null || !(obj instanceof UpdateCustomKeyStoreRequest)) {
            return false;
        }
        UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest = (UpdateCustomKeyStoreRequest) obj;
        if (updateCustomKeyStoreRequest.getCustomKeyStoreId() == null) {
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
        if (updateCustomKeyStoreRequest.getCustomKeyStoreId() != null && !updateCustomKeyStoreRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getNewCustomKeyStoreName() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getNewCustomKeyStoreName() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getNewCustomKeyStoreName() != null && !updateCustomKeyStoreRequest.getNewCustomKeyStoreName().equals(getNewCustomKeyStoreName())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getKeyStorePassword() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getKeyStorePassword() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getKeyStorePassword() != null && !updateCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCloudHsmClusterId() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getCloudHsmClusterId() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCloudHsmClusterId() != null && !updateCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getXksProxyUriEndpoint() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !updateCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriPath() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getXksProxyUriPath() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriPath() != null && !updateCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getXksProxyVpcEndpointServiceName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getXksProxyAuthenticationCredential() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyConnectivity() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getXksProxyConnectivity() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyConnectivity() == null || updateCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity())) {
            return true;
        }
        return false;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public String getNewCustomKeyStoreName() {
        return this.newCustomKeyStoreName;
    }

    public XksProxyAuthenticationCredentialType getXksProxyAuthenticationCredential() {
        return this.xksProxyAuthenticationCredential;
    }

    public String getXksProxyConnectivity() {
        return this.xksProxyConnectivity;
    }

    public String getXksProxyUriEndpoint() {
        return this.xksProxyUriEndpoint;
    }

    public String getXksProxyUriPath() {
        return this.xksProxyUriPath;
    }

    public String getXksProxyVpcEndpointServiceName() {
        return this.xksProxyVpcEndpointServiceName;
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
        if (getNewCustomKeyStoreName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNewCustomKeyStoreName().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getKeyStorePassword() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyStorePassword().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getCloudHsmClusterId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCloudHsmClusterId().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getXksProxyUriEndpoint() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getXksProxyUriEndpoint().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getXksProxyUriPath() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getXksProxyUriPath().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getXksProxyAuthenticationCredential().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getXksProxyConnectivity() != null) {
            r1 = getXksProxyConnectivity().hashCode();
        }
        return r08 + r1;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public void setNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
    }

    public void setXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
    }

    public void setXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
    }

    public void setXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
    }

    public void setXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
    }

    public void setXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + ",");
        }
        if (getNewCustomKeyStoreName() != null) {
            sb.append("NewCustomKeyStoreName: " + getNewCustomKeyStoreName() + ",");
        }
        if (getKeyStorePassword() != null) {
            sb.append("KeyStorePassword: " + getKeyStorePassword() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
        }
        if (getXksProxyUriEndpoint() != null) {
            sb.append("XksProxyUriEndpoint: " + getXksProxyUriEndpoint() + ",");
        }
        if (getXksProxyUriPath() != null) {
            sb.append("XksProxyUriPath: " + getXksProxyUriPath() + ",");
        }
        if (getXksProxyVpcEndpointServiceName() != null) {
            sb.append("XksProxyVpcEndpointServiceName: " + getXksProxyVpcEndpointServiceName() + ",");
        }
        if (getXksProxyAuthenticationCredential() != null) {
            sb.append("XksProxyAuthenticationCredential: " + getXksProxyAuthenticationCredential() + ",");
        }
        if (getXksProxyConnectivity() != null) {
            sb.append("XksProxyConnectivity: " + getXksProxyConnectivity());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
