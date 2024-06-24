package com.google.crypto.tink.mac;

import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class MacWrapper implements PrimitiveWrapper<Mac, Mac> {
    public static final Logger logger = Logger.getLogger(MacWrapper.class.getName());

    /* loaded from: classes3.dex */
    public static class WrappedMac implements Mac {
        public final byte[] formatVersion = {0};
        public final PrimitiveSet<Mac> primitives;

        public WrappedMac(PrimitiveSet primitiveSet) {
            this.primitives = primitiveSet;
        }

        @Override // com.google.crypto.tink.Mac
        public final byte[] computeMac(final byte[] data) throws GeneralSecurityException {
            PrimitiveSet<Mac> primitiveSet = this.primitives;
            if (primitiveSet.primary.outputPrefixType.equals(OutputPrefixType.LEGACY)) {
                return Bytes.concat(primitiveSet.primary.getIdentifier(), primitiveSet.primary.primitive.computeMac(Bytes.concat(data, this.formatVersion)));
            }
            return Bytes.concat(primitiveSet.primary.getIdentifier(), primitiveSet.primary.primitive.computeMac(data));
        }

        @Override // com.google.crypto.tink.Mac
        public final void verifyMac(final byte[] mac, final byte[] data) throws GeneralSecurityException {
            if (mac.length > 5) {
                byte[] copyOf = Arrays.copyOf(mac, 5);
                byte[] copyOfRange = Arrays.copyOfRange(mac, 5, mac.length);
                PrimitiveSet<Mac> primitiveSet = this.primitives;
                for (PrimitiveSet.Entry<Mac> entry : primitiveSet.getPrimitive(copyOf)) {
                    try {
                        boolean equals = entry.outputPrefixType.equals(OutputPrefixType.LEGACY);
                        Mac mac2 = entry.primitive;
                        if (equals) {
                            mac2.verifyMac(copyOfRange, Bytes.concat(data, this.formatVersion));
                            return;
                        } else {
                            mac2.verifyMac(copyOfRange, data);
                            return;
                        }
                    } catch (GeneralSecurityException e) {
                        MacWrapper.logger.info("tag prefix matches a key, but cannot verify: " + e);
                    }
                }
                Iterator<PrimitiveSet.Entry<Mac>> it = primitiveSet.getPrimitive(CryptoFormat.RAW_PREFIX).iterator();
                while (it.hasNext()) {
                    try {
                        it.next().primitive.verifyMac(mac, data);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<Mac> getInputPrimitiveClass() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public final Mac wrap(final PrimitiveSet<Mac> primitives) throws GeneralSecurityException {
        return new WrappedMac(primitives);
    }
}
