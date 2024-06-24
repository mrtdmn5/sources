package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes.dex */
public class GetParametersForImportResult implements Serializable {
    private ByteBuffer importToken;
    private String keyId;
    private Date parametersValidTo;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetParametersForImportResult)) {
            return false;
        }
        GetParametersForImportResult getParametersForImportResult = (GetParametersForImportResult) obj;
        if (getParametersForImportResult.getKeyId() == null) {
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
        if (getParametersForImportResult.getKeyId() != null && !getParametersForImportResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getParametersForImportResult.getImportToken() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getImportToken() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (getParametersForImportResult.getImportToken() != null && !getParametersForImportResult.getImportToken().equals(getImportToken())) {
            return false;
        }
        if (getParametersForImportResult.getPublicKey() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPublicKey() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (getParametersForImportResult.getPublicKey() != null && !getParametersForImportResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (getParametersForImportResult.getParametersValidTo() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getParametersValidTo() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (getParametersForImportResult.getParametersValidTo() == null || getParametersForImportResult.getParametersValidTo().equals(getParametersValidTo())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getImportToken() {
        return this.importToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getParametersValidTo() {
        return this.parametersValidTo;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getImportToken() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getImportToken().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPublicKey() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPublicKey().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getParametersValidTo() != null) {
            r1 = getParametersValidTo().hashCode();
        }
        return r03 + r1;
    }

    public void setImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setParametersValidTo(Date date) {
        this.parametersValidTo = date;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getImportToken() != null) {
            sb.append("ImportToken: " + getImportToken() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getParametersValidTo() != null) {
            sb.append("ParametersValidTo: " + getParametersValidTo());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetParametersForImportResult withImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
        return this;
    }

    public GetParametersForImportResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetParametersForImportResult withParametersValidTo(Date date) {
        this.parametersValidTo = date;
        return this;
    }

    public GetParametersForImportResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }
}
