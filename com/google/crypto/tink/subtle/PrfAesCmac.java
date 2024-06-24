package com.google.crypto.tink.subtle;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class PrfAesCmac implements Prf {
    public final SecretKeySpec keySpec;
    public byte[] subKey1;
    public byte[] subKey2;

    public PrfAesCmac(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.keySpec = secretKeySpec;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(1, secretKeySpec);
        byte[] dbl = AesUtil.dbl(engineFactory.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
    }

    @Override // com.google.crypto.tink.prf.Prf
    public final byte[] compute(final int data, byte[] outputLength) throws GeneralSecurityException {
        byte[] xor;
        if (data <= 16) {
            Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
            boolean z = true;
            engineFactory.init(1, this.keySpec);
            int max = Math.max(1, (int) Math.ceil(outputLength.length / 16.0d));
            if (max * 16 != outputLength.length) {
                z = false;
            }
            if (z) {
                xor = Bytes.xor((max - 1) * 16, outputLength, 0, this.subKey1, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(outputLength, (max - 1) * 16, outputLength.length);
                if (copyOfRange.length < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                    xor = Bytes.xor(copyOf, this.subKey2);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr = new byte[16];
            for (int r5 = 0; r5 < max - 1; r5++) {
                bArr = engineFactory.doFinal(Bytes.xor(0, bArr, r5 * 16, outputLength, 16));
            }
            return Arrays.copyOf(engineFactory.doFinal(Bytes.xor(xor, bArr)), data);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
