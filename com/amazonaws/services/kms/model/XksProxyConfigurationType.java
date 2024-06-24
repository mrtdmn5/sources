package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class XksProxyConfigurationType implements Serializable {
    private String accessKeyId;
    private String connectivity;
    private String uriEndpoint;
    private String uriPath;
    private String vpcEndpointServiceName;

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
        if (obj == null || !(obj instanceof XksProxyConfigurationType)) {
            return false;
        }
        XksProxyConfigurationType xksProxyConfigurationType = (XksProxyConfigurationType) obj;
        if (xksProxyConfigurationType.getConnectivity() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getConnectivity() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (xksProxyConfigurationType.getConnectivity() != null && !xksProxyConfigurationType.getConnectivity().equals(getConnectivity())) {
            return false;
        }
        if (xksProxyConfigurationType.getAccessKeyId() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAccessKeyId() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (xksProxyConfigurationType.getAccessKeyId() != null && !xksProxyConfigurationType.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if (xksProxyConfigurationType.getUriEndpoint() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getUriEndpoint() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (xksProxyConfigurationType.getUriEndpoint() != null && !xksProxyConfigurationType.getUriEndpoint().equals(getUriEndpoint())) {
            return false;
        }
        if (xksProxyConfigurationType.getUriPath() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getUriPath() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (xksProxyConfigurationType.getUriPath() != null && !xksProxyConfigurationType.getUriPath().equals(getUriPath())) {
            return false;
        }
        if (xksProxyConfigurationType.getVpcEndpointServiceName() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getVpcEndpointServiceName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (xksProxyConfigurationType.getVpcEndpointServiceName() == null || xksProxyConfigurationType.getVpcEndpointServiceName().equals(getVpcEndpointServiceName())) {
            return true;
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getConnectivity() {
        return this.connectivity;
    }

    public String getUriEndpoint() {
        return this.uriEndpoint;
    }

    public String getUriPath() {
        return this.uriPath;
    }

    public String getVpcEndpointServiceName() {
        return this.vpcEndpointServiceName;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getConnectivity() == null) {
            hashCode = 0;
        } else {
            hashCode = getConnectivity().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAccessKeyId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAccessKeyId().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getUriEndpoint() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUriEndpoint().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getUriPath() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getUriPath().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getVpcEndpointServiceName() != null) {
            r1 = getVpcEndpointServiceName().hashCode();
        }
        return r04 + r1;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setConnectivity(String str) {
        this.connectivity = str;
    }

    public void setUriEndpoint(String str) {
        this.uriEndpoint = str;
    }

    public void setUriPath(String str) {
        this.uriPath = str;
    }

    public void setVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getConnectivity() != null) {
            sb.append("Connectivity: " + getConnectivity() + ",");
        }
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId() + ",");
        }
        if (getUriEndpoint() != null) {
            sb.append("UriEndpoint: " + getUriEndpoint() + ",");
        }
        if (getUriPath() != null) {
            sb.append("UriPath: " + getUriPath() + ",");
        }
        if (getVpcEndpointServiceName() != null) {
            sb.append("VpcEndpointServiceName: " + getVpcEndpointServiceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public XksProxyConfigurationType withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public XksProxyConfigurationType withConnectivity(String str) {
        this.connectivity = str;
        return this;
    }

    public XksProxyConfigurationType withUriEndpoint(String str) {
        this.uriEndpoint = str;
        return this;
    }

    public XksProxyConfigurationType withUriPath(String str) {
        this.uriPath = str;
        return this;
    }

    public XksProxyConfigurationType withVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
        return this;
    }

    public void setConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
    }

    public XksProxyConfigurationType withConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
