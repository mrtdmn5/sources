package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes3.dex */
public interface EngineWrapper<T> {

    /* loaded from: classes3.dex */
    public static class TCipher implements EngineWrapper<Cipher> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public final Cipher getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Cipher.getInstance(algorithm);
            }
            return Cipher.getInstance(algorithm, provider);
        }
    }

    /* loaded from: classes3.dex */
    public static class TMac implements EngineWrapper<Mac> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public final Mac getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Mac.getInstance(algorithm);
            }
            return Mac.getInstance(algorithm, provider);
        }
    }

    T getInstance(String algorithm, Provider provider) throws GeneralSecurityException;
}
