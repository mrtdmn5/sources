package com.amplifyframework.auth.cognito.data;

import android.security.keystore.KeyGenParameterSpec;
import com.amplifyframework.statemachine.codegen.errors.CredentialStoreError;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LegacyKeyProvider.kt */
/* loaded from: classes.dex */
public final class LegacyKeyProvider {
    private static final String AES_KEY_ALGORITHM = "AES";
    private static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    private static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    public static final LegacyKeyProvider INSTANCE = new LegacyKeyProvider();

    private LegacyKeyProvider() {
    }

    public final void deleteKey(String keyAlias) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
        keyStore.load(null);
        keyStore.deleteEntry(keyAlias);
    }

    /* renamed from: generateKey-IoAF18A, reason: not valid java name */
    public final Object m633generateKeyIoAF18A(String keyAlias) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
        keyStore.load(null);
        if (keyStore.containsAlias(keyAlias)) {
            return ResultKt.createFailure(new CredentialStoreError(zzav$$ExternalSyntheticOutline0.m("Key already exists for the keyAlias: ", keyAlias, " in AndroidKeyStore"), null, 2, null));
        }
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(keyAlias, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …\n                .build()");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", ANDROID_KEY_STORE_NAME);
        keyGenerator.init(build);
        return keyGenerator.generateKey();
    }

    /* renamed from: retrieveKey-IoAF18A, reason: not valid java name */
    public final Object m634retrieveKeyIoAF18A(String keyAlias) {
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
        keyStore.load(null);
        if (!keyStore.containsAlias(keyAlias)) {
            return ResultKt.createFailure(new CredentialStoreError(zzav$$ExternalSyntheticOutline0.m("Key does not exists for the keyAlias: ", keyAlias, " in AndroidKeyStore"), null, 2, null));
        }
        Key key = keyStore.getKey(keyAlias, null);
        if (key == null) {
            return ResultKt.createFailure(new CredentialStoreError(zzav$$ExternalSyntheticOutline0.m("Key is null even though the keyAlias: ", keyAlias, " is present in AndroidKeyStore"), null, 2, null));
        }
        return key;
    }
}
