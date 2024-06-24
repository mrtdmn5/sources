package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes.dex */
public class ImportKeyMaterialRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer encryptedKeyMaterial;
    private String expirationModel;
    private ByteBuffer importToken;
    private String keyId;
    private Date validTo;

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
        if (obj == null || !(obj instanceof ImportKeyMaterialRequest)) {
            return false;
        }
        ImportKeyMaterialRequest importKeyMaterialRequest = (ImportKeyMaterialRequest) obj;
        if (importKeyMaterialRequest.getKeyId() == null) {
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
        if (importKeyMaterialRequest.getKeyId() != null && !importKeyMaterialRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (importKeyMaterialRequest.getImportToken() == null) {
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
        if (importKeyMaterialRequest.getImportToken() != null && !importKeyMaterialRequest.getImportToken().equals(getImportToken())) {
            return false;
        }
        if (importKeyMaterialRequest.getEncryptedKeyMaterial() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getEncryptedKeyMaterial() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (importKeyMaterialRequest.getEncryptedKeyMaterial() != null && !importKeyMaterialRequest.getEncryptedKeyMaterial().equals(getEncryptedKeyMaterial())) {
            return false;
        }
        if (importKeyMaterialRequest.getValidTo() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getValidTo() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (importKeyMaterialRequest.getValidTo() != null && !importKeyMaterialRequest.getValidTo().equals(getValidTo())) {
            return false;
        }
        if (importKeyMaterialRequest.getExpirationModel() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getExpirationModel() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (importKeyMaterialRequest.getExpirationModel() == null || importKeyMaterialRequest.getExpirationModel().equals(getExpirationModel())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getEncryptedKeyMaterial() {
        return this.encryptedKeyMaterial;
    }

    public String getExpirationModel() {
        return this.expirationModel;
    }

    public ByteBuffer getImportToken() {
        return this.importToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
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
        if (getEncryptedKeyMaterial() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEncryptedKeyMaterial().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getValidTo() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getValidTo().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getExpirationModel() != null) {
            r1 = getExpirationModel().hashCode();
        }
        return r04 + r1;
    }

    public void setEncryptedKeyMaterial(ByteBuffer byteBuffer) {
        this.encryptedKeyMaterial = byteBuffer;
    }

    public void setExpirationModel(String str) {
        this.expirationModel = str;
    }

    public void setImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setValidTo(Date date) {
        this.validTo = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getImportToken() != null) {
            sb.append("ImportToken: " + getImportToken() + ",");
        }
        if (getEncryptedKeyMaterial() != null) {
            sb.append("EncryptedKeyMaterial: " + getEncryptedKeyMaterial() + ",");
        }
        if (getValidTo() != null) {
            sb.append("ValidTo: " + getValidTo() + ",");
        }
        if (getExpirationModel() != null) {
            sb.append("ExpirationModel: " + getExpirationModel());
        }
        sb.append("}");
        return sb.toString();
    }

    public ImportKeyMaterialRequest withEncryptedKeyMaterial(ByteBuffer byteBuffer) {
        this.encryptedKeyMaterial = byteBuffer;
        return this;
    }

    public ImportKeyMaterialRequest withExpirationModel(String str) {
        this.expirationModel = str;
        return this;
    }

    public ImportKeyMaterialRequest withImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
        return this;
    }

    public ImportKeyMaterialRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ImportKeyMaterialRequest withValidTo(Date date) {
        this.validTo = date;
        return this;
    }

    public void setExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
    }

    public ImportKeyMaterialRequest withExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
        return this;
    }
}
