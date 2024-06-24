package com.google.crypto.tink.daead;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class DeterministicAeadConfig {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new AesSivKeyManager();
        int r0 = RegistryConfig.CONFIG_NAME_FIELD_NUMBER;
        try {
            Registry.registerKeyManager(new AesSivKeyManager(), true);
            Registry.registerPrimitiveWrapper(new DeterministicAeadWrapper());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
