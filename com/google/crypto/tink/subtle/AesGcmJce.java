package com.google.crypto.tink.subtle;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesGcmJce implements Aead {
    public static final AnonymousClass1 localCipher = new AnonymousClass1();
    public final SecretKeySpec keySpec;

    /* renamed from: com.google.crypto.tink.subtle.AesGcmJce$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public AesGcmJce(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    public static AlgorithmParameterSpec getParams(byte[] bArr, int r5) throws GeneralSecurityException {
        boolean z;
        int r0;
        try {
            Class.forName("android.app.Application", false, null);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            try {
                r0 = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused2) {
                r0 = -1;
            }
            if (r0 <= 19) {
                return new IvParameterSpec(bArr, 0, r5);
            }
        }
        return new GCMParameterSpec(128, bArr, 0, r5);
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length >= 28) {
            AlgorithmParameterSpec params = getParams(ciphertext, 12);
            AnonymousClass1 anonymousClass1 = localCipher;
            anonymousClass1.get().init(2, this.keySpec, params);
            if (associatedData != null && associatedData.length != 0) {
                anonymousClass1.get().updateAAD(associatedData);
            }
            return anonymousClass1.get().doFinal(ciphertext, 12, ciphertext.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length <= 2147483619) {
            byte[] bArr = new byte[plaintext.length + 12 + 16];
            byte[] randBytes = Random.randBytes(12);
            System.arraycopy(randBytes, 0, bArr, 0, 12);
            AlgorithmParameterSpec params = getParams(randBytes, randBytes.length);
            AnonymousClass1 anonymousClass1 = localCipher;
            anonymousClass1.get().init(1, this.keySpec, params);
            if (associatedData != null && associatedData.length != 0) {
                anonymousClass1.get().updateAAD(associatedData);
            }
            int doFinal = anonymousClass1.get().doFinal(plaintext, 0, plaintext.length, bArr, 12);
            if (doFinal == plaintext.length + 16) {
                return bArr;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - plaintext.length)));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
