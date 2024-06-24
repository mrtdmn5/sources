package com.google.crypto.tink.subtle;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.animaconnected.secondo.R;
import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesEaxJce implements Aead {
    public final byte[] b;
    public final int ivSizeInBytes;
    public final SecretKeySpec keySpec;
    public final byte[] p;
    public static final AnonymousClass1 localEcbCipher = new AnonymousClass1();
    public static final AnonymousClass2 localCtrCipher = new AnonymousClass2();

    /* renamed from: com.google.crypto.tink.subtle.AesEaxJce$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.AesEaxJce$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        public final Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public AesEaxJce(final byte[] key, int ivSizeInBytes) throws GeneralSecurityException {
        if (ivSizeInBytes != 12 && ivSizeInBytes != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.ivSizeInBytes = ivSizeInBytes;
        Validators.validateAesKeySize(key.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.keySpec = secretKeySpec;
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, secretKeySpec);
        byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
        this.b = multiplyByX;
        this.p = multiplyByX(multiplyByX);
    }

    public static byte[] multiplyByX(final byte[] block) {
        byte[] bArr = new byte[16];
        int r1 = 0;
        int r2 = 0;
        while (r2 < 15) {
            int r4 = r2 + 1;
            bArr[r2] = (byte) (((block[r2] << 1) ^ ((block[r4] & 255) >>> 7)) & 255);
            r2 = r4;
        }
        int r22 = block[15] << 1;
        if ((block[0] & 128) != 0) {
            r1 = R.styleable.AppTheme_stepsHistoryColumnColorActivity;
        }
        bArr[15] = (byte) (r22 ^ r1);
        return bArr;
    }

    public static byte[] xor(final byte[] x, final byte[] y) {
        int length = x.length;
        byte[] bArr = new byte[length];
        for (int r2 = 0; r2 < length; r2++) {
            bArr[r2] = (byte) (x[r2] ^ y[r2]);
        }
        return bArr;
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] bArr;
        int length = ciphertext.length;
        int r8 = this.ivSizeInBytes;
        int r9 = (length - r8) - 16;
        if (r9 >= 0) {
            Cipher cipher = localEcbCipher.get();
            SecretKeySpec secretKeySpec = this.keySpec;
            cipher.init(1, secretKeySpec);
            byte[] omac = omac(cipher, 0, ciphertext, 0, this.ivSizeInBytes);
            if (associatedData == null) {
                bArr = new byte[0];
            } else {
                bArr = associatedData;
            }
            byte[] omac2 = omac(cipher, 1, bArr, 0, bArr.length);
            byte[] omac3 = omac(cipher, 2, ciphertext, this.ivSizeInBytes, r9);
            int length2 = ciphertext.length - 16;
            byte b = 0;
            for (int r14 = 0; r14 < 16; r14++) {
                b = (byte) (b | (((ciphertext[length2 + r14] ^ omac2[r14]) ^ omac[r14]) ^ omac3[r14]));
            }
            if (b == 0) {
                Cipher cipher2 = localCtrCipher.get();
                cipher2.init(1, secretKeySpec, new IvParameterSpec(omac));
                return cipher2.doFinal(ciphertext, r8, r9);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] bArr;
        int length = plaintext.length;
        int r8 = this.ivSizeInBytes;
        if (length <= (Integer.MAX_VALUE - r8) - 16) {
            byte[] bArr2 = new byte[plaintext.length + r8 + 16];
            byte[] randBytes = Random.randBytes(r8);
            System.arraycopy(randBytes, 0, bArr2, 0, r8);
            Cipher cipher = localEcbCipher.get();
            SecretKeySpec secretKeySpec = this.keySpec;
            cipher.init(1, secretKeySpec);
            byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
            if (associatedData == null) {
                bArr = new byte[0];
            } else {
                bArr = associatedData;
            }
            byte[] omac2 = omac(cipher, 1, bArr, 0, bArr.length);
            Cipher cipher2 = localCtrCipher.get();
            cipher2.init(1, secretKeySpec, new IvParameterSpec(omac));
            cipher2.doFinal(plaintext, 0, plaintext.length, bArr2, this.ivSizeInBytes);
            byte[] omac3 = omac(cipher, 2, bArr2, this.ivSizeInBytes, plaintext.length);
            int length2 = plaintext.length + r8;
            for (int r11 = 0; r11 < 16; r11++) {
                bArr2[length2 + r11] = (byte) ((omac2[r11] ^ omac[r11]) ^ omac3[r11]);
            }
            return bArr2;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public final byte[] omac(Cipher ecb, int tag, final byte[] data, int offset, int length) throws IllegalBlockSizeException, BadPaddingException {
        byte[] copyOf;
        byte[] bArr = new byte[16];
        bArr[15] = (byte) tag;
        byte[] bArr2 = this.b;
        if (length == 0) {
            return ecb.doFinal(xor(bArr, bArr2));
        }
        byte[] doFinal = ecb.doFinal(bArr);
        int r3 = 0;
        while (length - r3 > 16) {
            for (int r4 = 0; r4 < 16; r4++) {
                doFinal[r4] = (byte) (doFinal[r4] ^ data[(offset + r3) + r4]);
            }
            doFinal = ecb.doFinal(doFinal);
            r3 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(data, r3 + offset, offset + length);
        if (copyOfRange.length == 16) {
            copyOf = xor(copyOfRange, bArr2);
        } else {
            copyOf = Arrays.copyOf(this.p, 16);
            for (int r2 = 0; r2 < copyOfRange.length; r2++) {
                copyOf[r2] = (byte) (copyOf[r2] ^ copyOfRange[r2]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
        }
        return ecb.doFinal(xor(doFinal, copyOf));
    }
}
