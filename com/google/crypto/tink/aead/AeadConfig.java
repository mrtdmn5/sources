package com.google.crypto.tink.aead;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.mac.AesCmacKeyManager;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.mac.MacWrapper;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public final class AeadConfig {
    static {
        new AesCtrHmacAeadKeyManager();
        new AesGcmKeyManager();
        new AesGcmSivKeyManager();
        new AesEaxKeyManager();
        new KmsAeadKeyManager();
        new KmsEnvelopeAeadKeyManager();
        new ChaCha20Poly1305KeyManager();
        new XChaCha20Poly1305KeyManager();
        int r0 = RegistryConfig.CONFIG_NAME_FIELD_NUMBER;
        try {
            register();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void register() throws GeneralSecurityException {
        boolean z;
        int r0 = MacConfig.$r8$clinit;
        Registry.registerKeyManager(new HmacKeyManager(), true);
        Registry.registerKeyManager(new AesCmacKeyManager(), true);
        Registry.registerPrimitiveWrapper(new MacWrapper());
        Registry.registerKeyManager(new AesCtrHmacAeadKeyManager(), true);
        Registry.registerKeyManager(new AesEaxKeyManager(), true);
        Registry.registerKeyManager(new AesGcmKeyManager(), true);
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            z = true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            z = false;
        }
        if (z) {
            Registry.registerKeyManager(new AesGcmSivKeyManager(), true);
        }
        Registry.registerKeyManager(new ChaCha20Poly1305KeyManager(), true);
        Registry.registerKeyManager(new KmsAeadKeyManager(), true);
        Registry.registerKeyManager(new KmsEnvelopeAeadKeyManager(), true);
        Registry.registerKeyManager(new XChaCha20Poly1305KeyManager(), true);
        Registry.registerPrimitiveWrapper(new AeadWrapper());
    }
}
