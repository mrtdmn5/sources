package com.google.crypto.tink.integration.android;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes3.dex */
public final class AndroidKeystoreAesGcm implements Aead {
    public final SecretKey key;

    public AndroidKeystoreAesGcm(String keyId, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey secretKey = (SecretKey) keyStore.getKey(keyId, null);
        this.key = secretKey;
        if (secretKey != null) {
        } else {
            throw new InvalidKeyException(ConstraintSet$$ExternalSyntheticOutline0.m("Keystore cannot load the key with ID: ", keyId));
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] aad) throws GeneralSecurityException {
        try {
            return decryptInternal(ciphertext, aad);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w("AndroidKeystoreAesGcm", "encountered a potentially transient KeyStore error, will wait and retry", e);
            try {
                Thread.sleep((int) (Math.random() * 100.0d));
            } catch (InterruptedException unused) {
            }
            return decryptInternal(ciphertext, aad);
        }
    }

    public final byte[] decryptInternal(final byte[] ciphertext, final byte[] aad) throws GeneralSecurityException {
        if (ciphertext.length >= 28) {
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, ciphertext, 0, 12);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, this.key, gCMParameterSpec);
            cipher.updateAAD(aad);
            return cipher.doFinal(ciphertext, 12, ciphertext.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] aad) throws GeneralSecurityException {
        try {
            return encryptInternal(plaintext, aad);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w("AndroidKeystoreAesGcm", "encountered a potentially transient KeyStore error, will wait and retry", e);
            try {
                Thread.sleep((int) (Math.random() * 100.0d));
            } catch (InterruptedException unused) {
            }
            return encryptInternal(plaintext, aad);
        }
    }

    public final byte[] encryptInternal(final byte[] plaintext, final byte[] aad) throws GeneralSecurityException {
        if (plaintext.length <= 2147483619) {
            byte[] bArr = new byte[plaintext.length + 12 + 16];
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, this.key);
            cipher.updateAAD(aad);
            cipher.doFinal(plaintext, 0, plaintext.length, bArr, 12);
            System.arraycopy(cipher.getIV(), 0, bArr, 0, 12);
            return bArr;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
