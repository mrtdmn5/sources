package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EncryptThenAuthenticate implements Aead {
    public final IndCpaCipher cipher;
    public final Mac mac;
    public final int macLength;

    public EncryptThenAuthenticate(final IndCpaCipher cipher, final Mac mac, int macLength) {
        this.cipher = cipher;
        this.mac = mac;
        this.macLength = macLength;
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        int length = ciphertext.length;
        int r1 = this.macLength;
        if (length >= r1) {
            byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, ciphertext.length - r1);
            byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, ciphertext.length - r1, ciphertext.length);
            if (associatedData == null) {
                associatedData = new byte[0];
            }
            this.mac.verifyMac(copyOfRange2, Bytes.concat(associatedData, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(associatedData.length * 8).array(), 8)));
            return this.cipher.decrypt(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] encrypt = this.cipher.encrypt(plaintext);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        return Bytes.concat(encrypt, this.mac.computeMac(Bytes.concat(associatedData, encrypt, Arrays.copyOf(ByteBuffer.allocate(8).putLong(associatedData.length * 8).array(), 8))));
    }
}
