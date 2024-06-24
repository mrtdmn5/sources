package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes3.dex */
public final class PrfMac implements Mac {
    public final int tagSize;
    public final Prf wrappedPrf;

    public PrfMac(Prf wrappedPrf, int tagSize) throws GeneralSecurityException {
        this.wrappedPrf = wrappedPrf;
        this.tagSize = tagSize;
        if (tagSize >= 10) {
            wrappedPrf.compute(tagSize, new byte[0]);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // com.google.crypto.tink.Mac
    public final byte[] computeMac(byte[] data) throws GeneralSecurityException {
        return this.wrappedPrf.compute(this.tagSize, data);
    }

    @Override // com.google.crypto.tink.Mac
    public final void verifyMac(byte[] mac, byte[] data) throws GeneralSecurityException {
        if (Bytes.equal(computeMac(data), mac)) {
        } else {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
