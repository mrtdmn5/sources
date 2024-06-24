package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class GetParametersForImportRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private String wrappingAlgorithm;
    private String wrappingKeySpec;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetParametersForImportRequest)) {
            return false;
        }
        GetParametersForImportRequest getParametersForImportRequest = (GetParametersForImportRequest) obj;
        if (getParametersForImportRequest.getKeyId() == null) {
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
        if (getParametersForImportRequest.getKeyId() != null && !getParametersForImportRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getParametersForImportRequest.getWrappingAlgorithm() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getWrappingAlgorithm() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getParametersForImportRequest.getWrappingAlgorithm() != null && !getParametersForImportRequest.getWrappingAlgorithm().equals(getWrappingAlgorithm())) {
            return false;
        }
        if (getParametersForImportRequest.getWrappingKeySpec() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getWrappingKeySpec() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getParametersForImportRequest.getWrappingKeySpec() == null || getParametersForImportRequest.getWrappingKeySpec().equals(getWrappingKeySpec())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getWrappingAlgorithm() {
        return this.wrappingAlgorithm;
    }

    public String getWrappingKeySpec() {
        return this.wrappingKeySpec;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getWrappingAlgorithm() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getWrappingAlgorithm().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getWrappingKeySpec() != null) {
            r1 = getWrappingKeySpec().hashCode();
        }
        return r02 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setWrappingAlgorithm(String str) {
        this.wrappingAlgorithm = str;
    }

    public void setWrappingKeySpec(String str) {
        this.wrappingKeySpec = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getWrappingAlgorithm() != null) {
            sb.append("WrappingAlgorithm: " + getWrappingAlgorithm() + ",");
        }
        if (getWrappingKeySpec() != null) {
            sb.append("WrappingKeySpec: " + getWrappingKeySpec());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetParametersForImportRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetParametersForImportRequest withWrappingAlgorithm(String str) {
        this.wrappingAlgorithm = str;
        return this;
    }

    public GetParametersForImportRequest withWrappingKeySpec(String str) {
        this.wrappingKeySpec = str;
        return this;
    }

    public void setWrappingAlgorithm(AlgorithmSpec algorithmSpec) {
        this.wrappingAlgorithm = algorithmSpec.toString();
    }

    public void setWrappingKeySpec(WrappingKeySpec wrappingKeySpec) {
        this.wrappingKeySpec = wrappingKeySpec.toString();
    }

    public GetParametersForImportRequest withWrappingAlgorithm(AlgorithmSpec algorithmSpec) {
        this.wrappingAlgorithm = algorithmSpec.toString();
        return this;
    }

    public GetParametersForImportRequest withWrappingKeySpec(WrappingKeySpec wrappingKeySpec) {
        this.wrappingKeySpec = wrappingKeySpec.toString();
        return this;
    }
}
