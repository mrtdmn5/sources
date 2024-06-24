package com.google.crypto.tink.aead.subtle;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesGcmSiv implements Aead {
    public static final AnonymousClass1 localCipher = new AnonymousClass1();
    public final SecretKeySpec keySpec;

    /* renamed from: com.google.crypto.tink.aead.subtle.AesGcmSiv$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM-SIV/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public AesGcmSiv(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.spec.AlgorithmParameterSpec getParams(byte[] r3, int r4) throws java.security.GeneralSecurityException {
        /*
            r0 = 0
            java.lang.String r1 = "javax.crypto.spec.GCMParameterSpec"
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> Le
            javax.crypto.spec.GCMParameterSpec r1 = new javax.crypto.spec.GCMParameterSpec     // Catch: java.lang.ClassNotFoundException -> Le
            r2 = 128(0x80, float:1.8E-43)
            r1.<init>(r2, r3, r0, r4)     // Catch: java.lang.ClassNotFoundException -> Le
            return r1
        Le:
            java.lang.String r1 = "android.app.Application"
            r2 = 0
            java.lang.Class.forName(r1, r0, r2)     // Catch: java.lang.Exception -> L16
            r1 = 1
            goto L17
        L16:
            r1 = r0
        L17:
            if (r1 == 0) goto L1f
            javax.crypto.spec.IvParameterSpec r1 = new javax.crypto.spec.IvParameterSpec
            r1.<init>(r3, r0, r4)
            return r1
        L1f:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r4 = "cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.aead.subtle.AesGcmSiv.getParams(byte[], int):java.security.spec.AlgorithmParameterSpec");
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
