package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public interface Prf {
    byte[] compute(int input, byte[] outputLength) throws GeneralSecurityException;
}
