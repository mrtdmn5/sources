package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: classes.dex */
final class MultipartUploadCbcContext extends MultipartUploadCryptoContext {
    private byte[] nextIV;

    public MultipartUploadCbcContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2, contentCryptoMaterial);
    }

    public byte[] getNextInitializationVector() {
        return this.nextIV;
    }

    public void setNextInitializationVector(byte[] bArr) {
        this.nextIV = bArr;
    }
}
