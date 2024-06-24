package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class AeadWrapper implements PrimitiveWrapper<Aead, Aead> {
    public static final Logger logger = Logger.getLogger(AeadWrapper.class.getName());

    /* loaded from: classes3.dex */
    public static class WrappedAead implements Aead {
        public final PrimitiveSet<Aead> pSet;

        public WrappedAead(PrimitiveSet primitiveSet) {
            this.pSet = primitiveSet;
        }

        @Override // com.google.crypto.tink.Aead
        public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
            int length = ciphertext.length;
            PrimitiveSet<Aead> primitiveSet = this.pSet;
            if (length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, 5, ciphertext.length);
                Iterator<PrimitiveSet.Entry<Aead>> it = primitiveSet.getPrimitive(copyOfRange).iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().primitive.decrypt(copyOfRange2, associatedData);
                    } catch (GeneralSecurityException e) {
                        AeadWrapper.logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            Iterator<PrimitiveSet.Entry<Aead>> it2 = primitiveSet.getPrimitive(CryptoFormat.RAW_PREFIX).iterator();
            while (it2.hasNext()) {
                try {
                    return it2.next().primitive.decrypt(ciphertext, associatedData);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        @Override // com.google.crypto.tink.Aead
        public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
            PrimitiveSet<Aead> primitiveSet = this.pSet;
            return Bytes.concat(primitiveSet.primary.getIdentifier(), primitiveSet.primary.primitive.encrypt(plaintext, associatedData));
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<Aead> getInputPrimitiveClass() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<Aead> getPrimitiveClass() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Aead wrap(final PrimitiveSet<Aead> pset) throws GeneralSecurityException {
        return new WrappedAead(pset);
    }
}
