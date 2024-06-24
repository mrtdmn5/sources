package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;

/* loaded from: classes3.dex */
public final class XChaCha20Poly1305 extends ChaCha20Poly1305Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base
    public final ChaCha20Base newChaCha20Instance(final int key, byte[] initialCounter) throws InvalidKeyException {
        return new XChaCha20(initialCounter, key);
    }
}
