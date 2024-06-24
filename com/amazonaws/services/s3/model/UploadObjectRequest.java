package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.UploadObjectObserver;
import com.amazonaws.services.s3.internal.MultiFileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class UploadObjectRequest extends AbstractPutObjectRequest implements MaterialsDescriptionProvider {
    static final int MIN_PART_SIZE = 5242880;
    private static final long serialVersionUID = 1;
    private long diskLimit;
    private transient ExecutorService executorService;
    private Map<String, String> materialsDescription;
    private transient MultiFileOutputStream multiFileOutputStream;
    private long partSize;
    private transient UploadObjectObserver uploadObjectObserver;
    private ObjectMetadata uploadPartMetadata;

    public UploadObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
        this.partSize = 5242880L;
        this.diskLimit = Long.MAX_VALUE;
    }

    public long getDiskLimit() {
        return this.diskLimit;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Override // com.amazonaws.services.s3.model.MaterialsDescriptionProvider
    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public MultiFileOutputStream getMultiFileOutputStream() {
        return this.multiFileOutputStream;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public UploadObjectObserver getUploadObjectObserver() {
        return this.uploadObjectObserver;
    }

    public ObjectMetadata getUploadPartMetadata() {
        return this.uploadPartMetadata;
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

    public void setUploadPartMetadata(ObjectMetadata objectMetadata) {
        this.uploadPartMetadata = objectMetadata;
    }

    public UploadObjectRequest withDiskLimit(long j) {
        this.diskLimit = j;
        return this;
    }

    public UploadObjectRequest withExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    public UploadObjectRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public UploadObjectRequest withMultiFileOutputStream(MultiFileOutputStream multiFileOutputStream) {
        this.multiFileOutputStream = multiFileOutputStream;
        return this;
    }

    public UploadObjectRequest withPartSize(long j) {
        if (j >= 5242880) {
            this.partSize = j;
            return this;
        }
        throw new IllegalArgumentException("partSize must be at least 5242880");
    }

    public UploadObjectRequest withUploadObjectObserver(UploadObjectObserver uploadObjectObserver) {
        this.uploadObjectObserver = uploadObjectObserver;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends UploadObjectRequest> T withUploadPartMetadata(ObjectMetadata objectMetadata) {
        setUploadPartMetadata(objectMetadata);
        return this;
    }

    public UploadObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
        this.partSize = 5242880L;
        this.diskLimit = Long.MAX_VALUE;
    }

    @Override // com.amazonaws.services.s3.model.AbstractPutObjectRequest, com.amazonaws.AmazonWebServiceRequest
    /* renamed from: clone */
    public UploadObjectRequest mo622clone() {
        UploadObjectRequest uploadObjectRequest = (UploadObjectRequest) super.mo622clone();
        super.copyPutObjectBaseTo(uploadObjectRequest);
        Map<String, String> materialsDescription = getMaterialsDescription();
        ObjectMetadata uploadPartMetadata = getUploadPartMetadata();
        return uploadObjectRequest.withMaterialsDescription(materialsDescription == null ? null : new HashMap(materialsDescription)).withDiskLimit(getDiskLimit()).withExecutorService(getExecutorService()).withPartSize(getPartSize()).withUploadObjectObserver(getUploadObjectObserver()).withUploadPartMetadata(uploadPartMetadata != null ? uploadPartMetadata.m625clone() : null);
    }
}
