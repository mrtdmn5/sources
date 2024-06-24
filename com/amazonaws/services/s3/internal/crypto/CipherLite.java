package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class CipherLite {
    static final CipherLite NULL = new CipherLite() { // from class: com.amazonaws.services.s3.internal.crypto.CipherLite.1
        @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
        public CipherLite createInverse() {
            return this;
        }

        @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
        public CipherLite createAuxiliary(long j) {
            return this;
        }
    };
    private final Cipher cipher;
    private final int cipherMode;
    private final ContentCryptoScheme scheme;
    private final SecretKey secreteKey;

    public CipherLite createAuxiliary(long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return this.scheme.createAuxillaryCipher(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider(), j);
    }

    public CipherLite createInverse() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        int r0 = this.cipherMode;
        int r1 = 1;
        if (r0 != 2) {
            if (r0 == 1) {
                r1 = 2;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), r1, this.cipher.getProvider());
    }

    public CipherLite createUsingIV(byte[] bArr) {
        return this.scheme.createCipherLite(this.secreteKey, bArr, this.cipherMode, this.cipher.getProvider());
    }

    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal();
    }

    public final int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public final String getCipherAlgorithm() {
        return this.cipher.getAlgorithm();
    }

    public final int getCipherMode() {
        return this.cipherMode;
    }

    public final Provider getCipherProvider() {
        return this.cipher.getProvider();
    }

    public final ContentCryptoScheme getContentCryptoScheme() {
        return this.scheme;
    }

    public final byte[] getIV() {
        return this.cipher.getIV();
    }

    public int getOutputSize(int r2) {
        return this.cipher.getOutputSize(r2);
    }

    public final String getSecretKeyAlgorithm() {
        return this.secreteKey.getAlgorithm();
    }

    public long mark() {
        return -1L;
    }

    public boolean markSupported() {
        return false;
    }

    public CipherLite recreate() {
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider());
    }

    public void reset() {
        throw new IllegalStateException("mark/reset not supported");
    }

    public byte[] update(byte[] bArr, int r3, int r4) {
        return this.cipher.update(bArr, r3, r4);
    }

    private CipherLite() {
        this.cipher = new NullCipher();
        this.scheme = null;
        this.secreteKey = null;
        this.cipherMode = -1;
    }

    public byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr);
    }

    public byte[] doFinal(byte[] bArr, int r3, int r4) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr, r3, r4);
    }

    public CipherLite(Cipher cipher, ContentCryptoScheme contentCryptoScheme, SecretKey secretKey, int r4) {
        this.cipher = cipher;
        this.scheme = contentCryptoScheme;
        this.secreteKey = secretKey;
        this.cipherMode = r4;
    }
}
