package com.google.crypto.tink.subtle;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    public static final AnonymousClass1 localCipher = new AnonymousClass1();
    public final int blockSize;
    public final int ivSize;
    public final SecretKeySpec keySpec;

    /* renamed from: com.google.crypto.tink.subtle.AesCtrJceCipher$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public AesCtrJceCipher(final byte[] key, int ivSize) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        int blockSize = localCipher.get().getBlockSize();
        this.blockSize = blockSize;
        if (ivSize >= 12 && ivSize <= blockSize) {
            this.ivSize = ivSize;
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public final byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        int length = ciphertext.length;
        int r1 = this.ivSize;
        if (length >= r1) {
            byte[] bArr = new byte[r1];
            System.arraycopy(ciphertext, 0, bArr, 0, r1);
            int length2 = ciphertext.length;
            int r4 = this.ivSize;
            byte[] bArr2 = new byte[length2 - r4];
            doCtr(ciphertext, r4, ciphertext.length - r4, bArr2, 0, bArr, false);
            return bArr2;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final void doCtr(final byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset, final byte[] iv, boolean encrypt) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr = new byte[this.blockSize];
        System.arraycopy(iv, 0, bArr, 0, this.ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        SecretKeySpec secretKeySpec = this.keySpec;
        if (encrypt) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(input, inputOffset, inputLen, output, outputOffset) == inputLen) {
        } else {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public final byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        int length = plaintext.length;
        int r2 = this.ivSize;
        int r1 = Integer.MAX_VALUE - r2;
        if (length <= r1) {
            byte[] bArr = new byte[plaintext.length + r2];
            byte[] randBytes = Random.randBytes(r2);
            System.arraycopy(randBytes, 0, bArr, 0, r2);
            doCtr(plaintext, 0, plaintext.length, bArr, this.ivSize, randBytes, true);
            return bArr;
        }
        throw new GeneralSecurityException(SubMenuBuilder$$ExternalSyntheticOutline0.m("plaintext length can not exceed ", r1));
    }
}
