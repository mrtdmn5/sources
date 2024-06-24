package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

/* loaded from: classes3.dex */
public final class Random {
    public static final AnonymousClass1 localRandom = new AnonymousClass1();

    /* renamed from: com.google.crypto.tink.subtle.Random$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<SecureRandom> {
        @Override // java.lang.ThreadLocal
        public final SecureRandom initialValue() {
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextLong();
            return secureRandom;
        }
    }

    public static byte[] randBytes(int size) {
        byte[] bArr = new byte[size];
        localRandom.get().nextBytes(bArr);
        return bArr;
    }
}
