package com.google.crypto.tink.daead;

import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {
    public static final Logger logger = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    /* loaded from: classes3.dex */
    public static class WrappedDeterministicAead implements DeterministicAead {
        public final PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public final byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
            int length = ciphertext.length;
            PrimitiveSet<DeterministicAead> primitiveSet = this.primitives;
            if (length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, 5, ciphertext.length);
                Iterator<PrimitiveSet.Entry<DeterministicAead>> it = primitiveSet.getPrimitive(copyOfRange).iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().primitive.decryptDeterministically(copyOfRange2, associatedData);
                    } catch (GeneralSecurityException e) {
                        DeterministicAeadWrapper.logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            Iterator<PrimitiveSet.Entry<DeterministicAead>> it2 = primitiveSet.getPrimitive(CryptoFormat.RAW_PREFIX).iterator();
            while (it2.hasNext()) {
                try {
                    return it2.next().primitive.decryptDeterministically(ciphertext, associatedData);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public final byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
            PrimitiveSet<DeterministicAead> primitiveSet = this.primitives;
            return Bytes.concat(primitiveSet.primary.getIdentifier(), primitiveSet.primary.primitive.encryptDeterministically(plaintext, associatedData));
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<DeterministicAead> getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final DeterministicAead wrap(final PrimitiveSet<DeterministicAead> primitives) throws GeneralSecurityException {
        return new WrappedDeterministicAead(primitives);
    }
}
