package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: classes.dex */
public class EncryptionInstruction {
    private final byte[] encryptedSymmetricKey;
    private final Map<String, String> materialsDescription;
    private final Cipher symmetricCipher;
    private final CipherFactory symmetricCipherFactory;

    public EncryptionInstruction(Map<String, String> map, byte[] bArr, SecretKey secretKey, Cipher cipher) {
        this.materialsDescription = map;
        this.encryptedSymmetricKey = bArr;
        this.symmetricCipher = cipher;
        this.symmetricCipherFactory = null;
    }

    public CipherFactory getCipherFactory() {
        return this.symmetricCipherFactory;
    }

    public byte[] getEncryptedSymmetricKey() {
        return this.encryptedSymmetricKey;
    }

    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public Cipher getSymmetricCipher() {
        return this.symmetricCipher;
    }

    public EncryptionInstruction(Map<String, String> map, byte[] bArr, SecretKey secretKey, CipherFactory cipherFactory) {
        this.materialsDescription = map;
        this.encryptedSymmetricKey = bArr;
        this.symmetricCipherFactory = cipherFactory;
        this.symmetricCipher = cipherFactory.createCipher();
    }
}
