package com.amazonaws.services.s3.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EncryptedInitiateMultipartUploadRequest extends InitiateMultipartUploadRequest implements MaterialsDescriptionProvider {
    private boolean createEncryptionMaterial;
    private Map<String, String> materialsDescription;

    public EncryptedInitiateMultipartUploadRequest(String str, String str2) {
        super(str, str2);
        this.createEncryptionMaterial = true;
    }

    @Override // com.amazonaws.services.s3.model.MaterialsDescriptionProvider
    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public boolean isCreateEncryptionMaterial() {
        return this.createEncryptionMaterial;
    }

    public void setCreateEncryptionMaterial(boolean z) {
        this.createEncryptionMaterial = z;
    }

    public void setMaterialsDescription(Map<String, String> map) {
        Map<String, String> unmodifiableMap;
        if (map == null) {
            unmodifiableMap = null;
        } else {
            unmodifiableMap = Collections.unmodifiableMap(new HashMap(map));
        }
        this.materialsDescription = unmodifiableMap;
    }

    public EncryptedInitiateMultipartUploadRequest withCreateEncryptionMaterial(boolean z) {
        this.createEncryptionMaterial = z;
        return this;
    }

    public EncryptedInitiateMultipartUploadRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public EncryptedInitiateMultipartUploadRequest(String str, String str2, ObjectMetadata objectMetadata) {
        super(str, str2, objectMetadata);
        this.createEncryptionMaterial = true;
    }
}
