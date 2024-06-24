package com.google.crypto.tink.subtle;

/* loaded from: classes3.dex */
public final class ChaCha20 extends ChaCha20Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    public final int[] createInitialState(final int[] nonce, int counter) {
        if (nonce.length == 3) {
            int[] r0 = new int[16];
            int[] r1 = ChaCha20Base.SIGMA;
            System.arraycopy(r1, 0, r0, 0, r1.length);
            System.arraycopy(this.key, 0, r0, r1.length, 8);
            r0[12] = counter;
            System.arraycopy(nonce, 0, r0, 13, nonce.length);
            return r0;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(nonce.length * 32)));
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    public final int nonceSizeInBytes() {
        return 12;
    }
}
