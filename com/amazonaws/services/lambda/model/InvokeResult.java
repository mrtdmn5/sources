package com.amazonaws.services.lambda.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class InvokeResult implements Serializable {
    private String executedVersion;
    private String functionError;
    private String logResult;
    private ByteBuffer payload;
    private Integer statusCode;

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
        if (obj == null || !(obj instanceof InvokeResult)) {
            return false;
        }
        InvokeResult invokeResult = (InvokeResult) obj;
        if (invokeResult.getStatusCode() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getStatusCode() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (invokeResult.getStatusCode() != null && !invokeResult.getStatusCode().equals(getStatusCode())) {
            return false;
        }
        if (invokeResult.getFunctionError() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getFunctionError() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (invokeResult.getFunctionError() != null && !invokeResult.getFunctionError().equals(getFunctionError())) {
            return false;
        }
        if (invokeResult.getLogResult() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getLogResult() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (invokeResult.getLogResult() != null && !invokeResult.getLogResult().equals(getLogResult())) {
            return false;
        }
        if (invokeResult.getPayload() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getPayload() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (invokeResult.getPayload() != null && !invokeResult.getPayload().equals(getPayload())) {
            return false;
        }
        if (invokeResult.getExecutedVersion() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getExecutedVersion() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (invokeResult.getExecutedVersion() == null || invokeResult.getExecutedVersion().equals(getExecutedVersion())) {
            return true;
        }
        return false;
    }

    public String getExecutedVersion() {
        return this.executedVersion;
    }

    public String getFunctionError() {
        return this.functionError;
    }

    public String getLogResult() {
        return this.logResult;
    }

    public ByteBuffer getPayload() {
        return this.payload;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r1 = 0;
        if (getStatusCode() == null) {
            hashCode = 0;
        } else {
            hashCode = getStatusCode().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getFunctionError() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getFunctionError().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getLogResult() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLogResult().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getPayload() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPayload().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getExecutedVersion() != null) {
            r1 = getExecutedVersion().hashCode();
        }
        return r04 + r1;
    }

    public void setExecutedVersion(String str) {
        this.executedVersion = str;
    }

    public void setFunctionError(String str) {
        this.functionError = str;
    }

    public void setLogResult(String str) {
        this.logResult = str;
    }

    public void setPayload(ByteBuffer byteBuffer) {
        this.payload = byteBuffer;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getStatusCode() != null) {
            sb.append("StatusCode: " + getStatusCode() + ",");
        }
        if (getFunctionError() != null) {
            sb.append("FunctionError: " + getFunctionError() + ",");
        }
        if (getLogResult() != null) {
            sb.append("LogResult: " + getLogResult() + ",");
        }
        if (getPayload() != null) {
            sb.append("Payload: " + getPayload() + ",");
        }
        if (getExecutedVersion() != null) {
            sb.append("ExecutedVersion: " + getExecutedVersion());
        }
        sb.append("}");
        return sb.toString();
    }

    public InvokeResult withExecutedVersion(String str) {
        this.executedVersion = str;
        return this;
    }

    public InvokeResult withFunctionError(String str) {
        this.functionError = str;
        return this;
    }

    public InvokeResult withLogResult(String str) {
        this.logResult = str;
        return this;
    }

    public InvokeResult withPayload(ByteBuffer byteBuffer) {
        this.payload = byteBuffer;
        return this;
    }

    public InvokeResult withStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
