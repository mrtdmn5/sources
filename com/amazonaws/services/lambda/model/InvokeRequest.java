package com.amazonaws.services.lambda.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class InvokeRequest extends AmazonWebServiceRequest implements Serializable {
    private String clientContext;
    private String functionName;
    private String invocationType;
    private String logType;
    private ByteBuffer payload;
    private String qualifier;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InvokeRequest)) {
            return false;
        }
        InvokeRequest invokeRequest = (InvokeRequest) obj;
        if (invokeRequest.getFunctionName() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getFunctionName() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (invokeRequest.getFunctionName() != null && !invokeRequest.getFunctionName().equals(getFunctionName())) {
            return false;
        }
        if (invokeRequest.getInvocationType() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getInvocationType() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (invokeRequest.getInvocationType() != null && !invokeRequest.getInvocationType().equals(getInvocationType())) {
            return false;
        }
        if (invokeRequest.getLogType() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getLogType() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (invokeRequest.getLogType() != null && !invokeRequest.getLogType().equals(getLogType())) {
            return false;
        }
        if (invokeRequest.getClientContext() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getClientContext() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (invokeRequest.getClientContext() != null && !invokeRequest.getClientContext().equals(getClientContext())) {
            return false;
        }
        if (invokeRequest.getPayload() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getPayload() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (invokeRequest.getPayload() != null && !invokeRequest.getPayload().equals(getPayload())) {
            return false;
        }
        if (invokeRequest.getQualifier() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getQualifier() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (invokeRequest.getQualifier() == null || invokeRequest.getQualifier().equals(getQualifier())) {
            return true;
        }
        return false;
    }

    public String getClientContext() {
        return this.clientContext;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public String getInvocationType() {
        return this.invocationType;
    }

    public String getLogType() {
        return this.logType;
    }

    public ByteBuffer getPayload() {
        return this.payload;
    }

    public String getQualifier() {
        return this.qualifier;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int r1 = 0;
        if (getFunctionName() == null) {
            hashCode = 0;
        } else {
            hashCode = getFunctionName().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getInvocationType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getInvocationType().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getLogType() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLogType().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getClientContext() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getClientContext().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getPayload() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPayload().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getQualifier() != null) {
            r1 = getQualifier().hashCode();
        }
        return r05 + r1;
    }

    public void setClientContext(String str) {
        this.clientContext = str;
    }

    public void setFunctionName(String str) {
        this.functionName = str;
    }

    public void setInvocationType(String str) {
        this.invocationType = str;
    }

    public void setLogType(String str) {
        this.logType = str;
    }

    public void setPayload(ByteBuffer byteBuffer) {
        this.payload = byteBuffer;
    }

    public void setQualifier(String str) {
        this.qualifier = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getFunctionName() != null) {
            sb.append("FunctionName: " + getFunctionName() + ",");
        }
        if (getInvocationType() != null) {
            sb.append("InvocationType: " + getInvocationType() + ",");
        }
        if (getLogType() != null) {
            sb.append("LogType: " + getLogType() + ",");
        }
        if (getClientContext() != null) {
            sb.append("ClientContext: " + getClientContext() + ",");
        }
        if (getPayload() != null) {
            sb.append("Payload: " + getPayload() + ",");
        }
        if (getQualifier() != null) {
            sb.append("Qualifier: " + getQualifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public InvokeRequest withClientContext(String str) {
        this.clientContext = str;
        return this;
    }

    public InvokeRequest withFunctionName(String str) {
        this.functionName = str;
        return this;
    }

    public InvokeRequest withInvocationType(String str) {
        this.invocationType = str;
        return this;
    }

    public InvokeRequest withLogType(String str) {
        this.logType = str;
        return this;
    }

    public InvokeRequest withPayload(ByteBuffer byteBuffer) {
        this.payload = byteBuffer;
        return this;
    }

    public InvokeRequest withQualifier(String str) {
        this.qualifier = str;
        return this;
    }

    public void setInvocationType(InvocationType invocationType) {
        this.invocationType = invocationType.toString();
    }

    public void setLogType(LogType logType) {
        this.logType = logType.toString();
    }

    public InvokeRequest withInvocationType(InvocationType invocationType) {
        this.invocationType = invocationType.toString();
        return this;
    }

    public InvokeRequest withLogType(LogType logType) {
        this.logType = logType.toString();
        return this;
    }
}
