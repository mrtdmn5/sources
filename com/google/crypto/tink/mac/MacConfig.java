package com.google.crypto.tink.mac;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class MacConfig {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new HmacKeyManager();
        int r0 = RegistryConfig.CONFIG_NAME_FIELD_NUMBER;
        try {
            Registry.registerKeyManager(new HmacKeyManager(), true);
            Registry.registerKeyManager(new AesCmacKeyManager(), true);
            Registry.registerPrimitiveWrapper(new MacWrapper());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
