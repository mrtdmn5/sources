package com.google.crypto.tink.subtle;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesSiv implements DeterministicAead {
    public final byte[] aesCtrKey;
    public final PrfAesCmac cmacForS2V;
    public static final List KEY_SIZES = Arrays.asList(64);
    public static final byte[] BLOCK_ZERO = new byte[16];
    public static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    public AesSiv(final byte[] key) throws GeneralSecurityException {
        if (KEY_SIZES.contains(Integer.valueOf(key.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(key, 0, key.length / 2);
            this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
            this.cmacForS2V = new PrfAesCmac(copyOfRange);
            return;
        }
        throw new InvalidKeyException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("invalid key size: "), key.length, " bytes; key must have 64 bytes"));
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        boolean z;
        if (ciphertext.length >= 16) {
            Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, 16);
            byte[] bArr = (byte[]) copyOfRange.clone();
            bArr[8] = (byte) (bArr[8] & Byte.MAX_VALUE);
            bArr[12] = (byte) (bArr[12] & Byte.MAX_VALUE);
            engineFactory.init(2, new SecretKeySpec(this.aesCtrKey, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(bArr));
            byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, 16, ciphertext.length);
            byte[] doFinal = engineFactory.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null) {
                try {
                    Class.forName("android.app.Application", false, null);
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                if (z) {
                    doFinal = new byte[0];
                }
            }
            if (Bytes.equal(copyOfRange, s2v(associatedData, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length <= 2147483631) {
            Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] s2v = s2v(associatedData, plaintext);
            byte[] bArr = (byte[]) s2v.clone();
            bArr[8] = (byte) (bArr[8] & Byte.MAX_VALUE);
            bArr[12] = (byte) (bArr[12] & Byte.MAX_VALUE);
            engineFactory.init(1, new SecretKeySpec(this.aesCtrKey, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(bArr));
            return Bytes.concat(s2v, engineFactory.doFinal(plaintext));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public final byte[] s2v(final byte[]... s) throws GeneralSecurityException {
        byte[] xor;
        int length = s.length;
        PrfAesCmac prfAesCmac = this.cmacForS2V;
        if (length == 0) {
            return prfAesCmac.compute(16, BLOCK_ONE);
        }
        byte[] compute = prfAesCmac.compute(16, BLOCK_ZERO);
        for (int r4 = 0; r4 < s.length - 1; r4++) {
            byte[] bArr = s[r4];
            if (bArr == null) {
                bArr = new byte[0];
            }
            compute = Bytes.xor(AesUtil.dbl(compute), prfAesCmac.compute(16, bArr));
        }
        byte[] bArr2 = s[s.length - 1];
        if (bArr2.length >= 16) {
            if (bArr2.length >= compute.length) {
                int length2 = bArr2.length - compute.length;
                xor = Arrays.copyOf(bArr2, bArr2.length);
                for (int r3 = 0; r3 < compute.length; r3++) {
                    int r5 = length2 + r3;
                    xor[r5] = (byte) (xor[r5] ^ compute[r3]);
                }
            } else {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
        } else if (bArr2.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr2, 16);
            copyOf[bArr2.length] = Byte.MIN_VALUE;
            xor = Bytes.xor(copyOf, AesUtil.dbl(compute));
        } else {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        return prfAesCmac.compute(16, xor);
    }
}
