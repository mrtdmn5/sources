package com.amazonaws.services.s3.model;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EncryptedPutObjectRequest extends PutObjectRequest implements MaterialsDescriptionProvider {
    private Map<String, String> materialsDescription;

    public EncryptedPutObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    @Override // com.amazonaws.services.s3.model.MaterialsDescriptionProvider
    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
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

    public EncryptedPutObjectRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public EncryptedPutObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public EncryptedPutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
    }

    @Override // com.amazonaws.services.s3.model.PutObjectRequest, com.amazonaws.services.s3.model.AbstractPutObjectRequest, com.amazonaws.AmazonWebServiceRequest
    /* renamed from: clone */
    public EncryptedPutObjectRequest mo622clone() {
        EncryptedPutObjectRequest encryptedPutObjectRequest = new EncryptedPutObjectRequest(getBucketName(), getKey(), getFile());
        super.copyPutObjectBaseTo(encryptedPutObjectRequest);
        Map<String, String> materialsDescription = getMaterialsDescription();
        encryptedPutObjectRequest.withMaterialsDescription(materialsDescription == null ? null : new HashMap(materialsDescription));
        return encryptedPutObjectRequest;
    }
}
