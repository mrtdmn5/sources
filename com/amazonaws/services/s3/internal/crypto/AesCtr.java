package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: classes.dex */
class AesCtr extends ContentCryptoScheme {
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 16;
    private static final int SUPPORTED_IV_LENGTH = 12;

    private byte[] computeJ0(byte[] bArr) {
        int blockSizeInBytes = getBlockSizeInBytes();
        byte[] bArr2 = new byte[blockSizeInBytes];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[blockSizeInBytes - 1] = 1;
        return ContentCryptoScheme.incrementBlocks(bArr2, 1L);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public byte[] adjustIV(byte[] bArr, long j) {
        if (bArr.length == 12) {
            int blockSizeInBytes = getBlockSizeInBytes();
            long j2 = blockSizeInBytes;
            long j3 = j / j2;
            if (j2 * j3 == j) {
                return ContentCryptoScheme.incrementBlocks(computeJ0(bArr), j3);
            }
            throw new IllegalArgumentException("Expecting byteOffset to be multiple of 16, but got blockOffset=" + j3 + ", blockSize=" + blockSizeInBytes + ", byteOffset=" + j);
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getBlockSizeInBytes() {
        return ContentCryptoScheme.AES_GCM.getBlockSizeInBytes();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String getCipherAlgorithm() {
        return "AES/CTR/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getIVLengthInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String getKeyGeneratorAlgorithm() {
        return ContentCryptoScheme.AES_GCM.getKeyGeneratorAlgorithm();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getKeyLengthInBits() {
        return ContentCryptoScheme.AES_GCM.getKeyLengthInBits();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public long getMaxPlaintextSize() {
        return -1L;
    }
}
