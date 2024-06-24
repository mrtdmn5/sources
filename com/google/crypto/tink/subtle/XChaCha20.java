package com.google.crypto.tink.subtle;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class XChaCha20 extends ChaCha20Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    public final int[] createInitialState(final int[] nonce, int counter) {
        if (nonce.length == 6) {
            int[] r2 = new int[16];
            int[] r3 = ChaCha20Base.SIGMA;
            System.arraycopy(r3, 0, r0, 0, r3.length);
            System.arraycopy(this.key, 0, r0, r3.length, 8);
            int[] r0 = {0, 0, 0, 0, r0[12], r0[13], r0[14], r0[15], 0, 0, 0, 0, nonce[0], nonce[1], nonce[2], nonce[3]};
            ChaCha20Base.shuffleState(r0);
            int[] copyOf = Arrays.copyOf(r0, 8);
            System.arraycopy(r3, 0, r2, 0, r3.length);
            System.arraycopy(copyOf, 0, r2, r3.length, 8);
            r2[12] = counter;
            r2[13] = 0;
            r2[14] = nonce[4];
            r2[15] = nonce[5];
            return r2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(nonce.length * 32)));
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    public final int nonceSizeInBytes() {
        return 24;
    }
}
