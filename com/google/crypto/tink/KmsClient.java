package com.google.crypto.tink;

import com.google.crypto.tink.integration.android.AndroidKeystoreAesGcm;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public interface KmsClient {
    boolean doesSupport(String keyUri);

    AndroidKeystoreAesGcm getAead(String keyUri) throws GeneralSecurityException;
}
