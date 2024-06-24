package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;

@Deprecated
/* loaded from: classes.dex */
class MultipartUploadCryptoContext extends MultipartUploadContext {
    private final ContentCryptoMaterial cekMaterial;
    private int partNumber;
    private volatile boolean partUploadInProgress;

    public MultipartUploadCryptoContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2);
        this.cekMaterial = contentCryptoMaterial;
    }

    public void beginPartUpload(int r4) {
        if (r4 >= 1) {
            if (!this.partUploadInProgress) {
                synchronized (this) {
                    if (r4 - this.partNumber <= 1) {
                        this.partNumber = r4;
                        this.partUploadInProgress = true;
                    } else {
                        throw new AmazonClientException("Parts are required to be uploaded in series (partNumber=" + this.partNumber + ", nextPartNumber=" + r4 + ")");
                    }
                }
                return;
            }
            throw new AmazonClientException("Parts are required to be uploaded in series");
        }
        throw new IllegalArgumentException("part number must be at least 1");
    }

    public void endPartUpload() {
        this.partUploadInProgress = false;
    }

    public CipherLite getCipherLite() {
        return this.cekMaterial.getCipherLite();
    }

    public ContentCryptoMaterial getContentCryptoMaterial() {
        return this.cekMaterial;
    }
}
