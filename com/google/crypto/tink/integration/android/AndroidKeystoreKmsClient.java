package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* loaded from: classes3.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    public KeyStore keyStore;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public KeyStore keyStore;

        public Builder() {
            this.keyStore = null;
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    public static void generateNewAeadKey(String keyUri) throws GeneralSecurityException {
        if (!new AndroidKeystoreKmsClient().hasKey(keyUri)) {
            String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(keyUri);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(validateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            keyGenerator.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", keyUri));
    }

    @Override // com.google.crypto.tink.KmsClient
    public final synchronized boolean doesSupport(String uri) {
        return uri.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    @Override // com.google.crypto.tink.KmsClient
    public final synchronized AndroidKeystoreAesGcm getAead(String uri) throws GeneralSecurityException {
        AndroidKeystoreAesGcm androidKeystoreAesGcm;
        androidKeystoreAesGcm = new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(uri), this.keyStore);
        byte[] randBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(randBytes, androidKeystoreAesGcm.decrypt(androidKeystoreAesGcm.encrypt(randBytes, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return androidKeystoreAesGcm;
    }

    public final synchronized boolean hasKey(String keyUri) throws GeneralSecurityException {
        String validateKmsKeyUriAndRemovePrefix;
        validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(keyUri);
        try {
        } catch (NullPointerException unused) {
            Log.w("AndroidKeystoreKmsClient", "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.keyStore.containsAlias(validateKmsKeyUriAndRemovePrefix);
        }
        return this.keyStore.containsAlias(validateKmsKeyUriAndRemovePrefix);
    }

    public AndroidKeystoreKmsClient(Builder builder) {
        this.keyStore = builder.keyStore;
    }
}
