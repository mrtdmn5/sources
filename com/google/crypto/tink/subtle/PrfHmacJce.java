package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class PrfHmacJce implements Prf {
    public final String algorithm;
    public final Key key;
    public final AnonymousClass1 localMac;
    public final int maxOutputLength;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.subtle.PrfHmacJce$1, java.lang.ThreadLocal] */
    public PrfHmacJce(String algorithm, SecretKeySpec key) throws GeneralSecurityException {
        ?? r0 = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            @Override // java.lang.ThreadLocal
            public final Mac initialValue() {
                PrfHmacJce prfHmacJce = PrfHmacJce.this;
                try {
                    Mac engineFactory = EngineFactory.MAC.getInstance(prfHmacJce.algorithm);
                    engineFactory.init(prfHmacJce.key);
                    return engineFactory;
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        this.localMac = r0;
        this.algorithm = algorithm;
        this.key = key;
        if (key.getEncoded().length >= 16) {
            char c = 65535;
            switch (algorithm.hashCode()) {
                case -1823053428:
                    if (algorithm.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (algorithm.equals("HMACSHA256")) {
                        c = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (algorithm.equals("HMACSHA384")) {
                        c = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (algorithm.equals("HMACSHA512")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.maxOutputLength = 20;
                    break;
                case 1:
                    this.maxOutputLength = 32;
                    break;
                case 2:
                    this.maxOutputLength = 48;
                    break;
                case 3:
                    this.maxOutputLength = 64;
                    break;
                default:
                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(algorithm));
            }
            r0.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    @Override // com.google.crypto.tink.prf.Prf
    public final byte[] compute(int data, byte[] outputLength) throws GeneralSecurityException {
        if (data <= this.maxOutputLength) {
            AnonymousClass1 anonymousClass1 = this.localMac;
            anonymousClass1.get().update(outputLength);
            return Arrays.copyOf(anonymousClass1.get().doFinal(), data);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
