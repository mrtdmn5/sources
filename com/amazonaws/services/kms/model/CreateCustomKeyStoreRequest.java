package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CreateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreName;
    private String customKeyStoreType;
    private String keyStorePassword;
    private String trustAnchorCertificate;
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
        boolean z19;
        boolean z20;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateCustomKeyStoreRequest)) {
            return false;
        }
        CreateCustomKeyStoreRequest createCustomKeyStoreRequest = (CreateCustomKeyStoreRequest) obj;
        if (createCustomKeyStoreRequest.getCustomKeyStoreName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCustomKeyStoreName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreName() != null && !createCustomKeyStoreRequest.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCloudHsmClusterId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getCloudHsmClusterId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCloudHsmClusterId() != null && !createCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getTrustAnchorCertificate() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTrustAnchorCertificate() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (createCustomKeyStoreRequest.getTrustAnchorCertificate() != null && !createCustomKeyStoreRequest.getTrustAnchorCertificate().equals(getTrustAnchorCertificate())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getKeyStorePassword() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getKeyStorePassword() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (createCustomKeyStoreRequest.getKeyStorePassword() != null && !createCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreType() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getCustomKeyStoreType() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreType() != null && !createCustomKeyStoreRequest.getCustomKeyStoreType().equals(getCustomKeyStoreType())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getXksProxyUriEndpoint() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !createCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriPath() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getXksProxyUriPath() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriPath() != null && !createCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getXksProxyVpcEndpointServiceName() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getXksProxyAuthenticationCredential() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !createCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyConnectivity() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (getXksProxyConnectivity() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z19 ^ z20) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyConnectivity() == null || createCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity())) {
            return true;
        }
        return false;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public String getCustomKeyStoreType() {
        return this.customKeyStoreType;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public String getTrustAnchorCertificate() {
        return this.trustAnchorCertificate;
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
        int hashCode9;
        int r1 = 0;
        if (getCustomKeyStoreName() == null) {
            hashCode = 0;
        } else {
            hashCode = getCustomKeyStoreName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getCloudHsmClusterId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCloudHsmClusterId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTrustAnchorCertificate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getTrustAnchorCertificate().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getKeyStorePassword() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getKeyStorePassword().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getCustomKeyStoreType() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getCustomKeyStoreType().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getXksProxyUriEndpoint() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getXksProxyUriEndpoint().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getXksProxyUriPath() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getXksProxyUriPath().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getXksProxyAuthenticationCredential().hashCode();
        }
        int r09 = (r08 + hashCode9) * 31;
        if (getXksProxyConnectivity() != null) {
            r1 = getXksProxyConnectivity().hashCode();
        }
        return r09 + r1;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public void setCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public void setTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
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
        if (getCustomKeyStoreName() != null) {
            sb.append("CustomKeyStoreName: " + getCustomKeyStoreName() + ",");
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + ",");
        }
        if (getTrustAnchorCertificate() != null) {
            sb.append("TrustAnchorCertificate: " + getTrustAnchorCertificate() + ",");
        }
        if (getKeyStorePassword() != null) {
            sb.append("KeyStorePassword: " + getKeyStorePassword() + ",");
        }
        if (getCustomKeyStoreType() != null) {
            sb.append("CustomKeyStoreType: " + getCustomKeyStoreType() + ",");
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

    public CreateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public void setCustomKeyStoreType(CustomKeyStoreType customKeyStoreType) {
        this.customKeyStoreType = customKeyStoreType.toString();
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(CustomKeyStoreType customKeyStoreType) {
        this.customKeyStoreType = customKeyStoreType.toString();
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
