package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: classes.dex */
class AesGcm extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 12;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;
    private static final int DEFAULT_TAG_LENGTH_IN_BITS = 128;

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int r4, Provider provider, long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        ContentCryptoScheme contentCryptoScheme = ContentCryptoScheme.AES_CTR;
        return contentCryptoScheme.createCipherLite(secretKey, contentCryptoScheme.adjustIV(bArr, j), r4, provider);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getBlockSizeInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String getCipherAlgorithm() {
        return "AES/GCM/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getIVLengthInBytes() {
        return 12;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String getKeyGeneratorAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getKeyLengthInBits() {
        return 256;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public long getMaxPlaintextSize() {
        return 68719476704L;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String getSpecificCipherProvider() {
        return "BC";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int getTagLengthInBits() {
        return 128;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int r4) {
        return new GCMCipherLite(cipher, secretKey, r4);
    }
}
