package com.amplifyframework.auth.cognito.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amplifyframework.core.store.KeyValueRepository;
import com.amplifyframework.statemachine.codegen.errors.CredentialStoreError;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LegacyKeyValueRepository.kt */
/* loaded from: classes.dex */
public final class LegacyKeyValueRepository implements KeyValueRepository {
    private static final int AWS_KEY_VALUE_STORE_VERSION = 1;
    private static final String AWS_KEY_VALUE_STORE_VERSION_1_KEY_STORE_ALIAS_FOR_AES_SUFFIX = ".aesKeyStoreAlias";
    private static final String CHARSET_NAME = "UTF-8";
    private static final String CIPHER_AES_GCM_NOPADDING = "AES/GCM/NoPadding";
    private static final int CIPHER_AES_GCM_NOPADDING_IV_LENGTH_IN_BYTES = 12;
    private static final int CIPHER_AES_GCM_NOPADDING_TAG_LENGTH_LENGTH_IN_BITS = 128;
    public static final Companion Companion = new Companion(null);
    private static final String SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX = ".encrypted";
    private static final String SHARED_PREFERENCES_IV_SUFFIX = ".iv";
    private static final String SHARED_PREFERENCES_STORE_VERSION_SUFFIX = ".keyvaluestoreversion";
    private final Map<String, String> cache;
    private final Map<String, Map<String, String>> cacheFactory;
    private boolean isPersistenceEnabled;
    private final SecureRandom secureRandom;
    private SharedPreferences sharedPreferencesForData;
    private final String sharedPreferencesName;

    /* compiled from: LegacyKeyValueRepository.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LegacyKeyValueRepository(Context context, String sharedPreferencesName, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferencesName, "sharedPreferencesName");
        this.sharedPreferencesName = sharedPreferencesName;
        this.isPersistenceEnabled = z;
        this.secureRandom = new SecureRandom();
        this.cacheFactory = new LinkedHashMap();
        this.cache = getCacheForKey(sharedPreferencesName);
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferencesName, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.sharedPreferencesForData = sharedPreferences;
    }

    private final String decrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(encryptedData, Base64.DEFAULT)");
            Cipher cipher = Cipher.getInstance(CIPHER_AES_GCM_NOPADDING);
            cipher.init(2, key, algorithmParameterSpec);
            byte[] decryptedData = cipher.doFinal(decode);
            Intrinsics.checkNotNullExpressionValue(decryptedData, "decryptedData");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(CHARSET_NAME)");
            return new String(decryptedData, forName);
        } catch (Exception unused) {
            return null;
        }
    }

    private final String encrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, String str) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_AES_GCM_NOPADDING);
            cipher.init(1, key, algorithmParameterSpec);
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (Exception e) {
            Log.e("Error in encrypting data. ", e.toString());
            return null;
        }
    }

    /* renamed from: generateEncryptionKey-IoAF18A, reason: not valid java name */
    private final synchronized Object m635generateEncryptionKeyIoAF18A(String str) {
        return LegacyKeyProvider.INSTANCE.m633generateKeyIoAF18A(str);
    }

    private final byte[] generateInitializationVector() {
        byte[] bArr = new byte[12];
        this.secureRandom.nextBytes(bArr);
        return bArr;
    }

    private final Map<String, String> getCacheForKey(String str) {
        Map<String, Map<String, String>> map = this.cacheFactory;
        Map<String, String> map2 = map.get(str);
        if (map2 == null) {
            map2 = new LinkedHashMap<>();
            map.put(str, map2);
        }
        return map2;
    }

    private final String getDataKeyUsedInPersistentStore(String str) {
        return ComposableInvoker$$ExternalSyntheticOutline0.m(str, SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX);
    }

    private final String getEncryptionKeyAlias() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.sharedPreferencesName, AWS_KEY_VALUE_STORE_VERSION_1_KEY_STORE_ALIAS_FOR_AES_SUFFIX);
    }

    private final AlgorithmParameterSpec getInitializationVector(String str) throws Exception {
        String m = ComposableInvoker$$ExternalSyntheticOutline0.m(str, SHARED_PREFERENCES_IV_SUFFIX);
        if (this.sharedPreferencesForData.contains(m)) {
            String string = this.sharedPreferencesForData.getString(m, null);
            if (string != null) {
                boolean z = false;
                byte[] decode = Base64.decode(string, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(initializationVec…InString, Base64.DEFAULT)");
                if (decode.length == 0) {
                    z = true;
                }
                if (!z) {
                    return new GCMParameterSpec(128, decode);
                }
                throw new Exception(zzav$$ExternalSyntheticOutline0.m("Cannot base64 decode the initialization vector for ", str, " read from SharedPreferences."));
            }
            throw new Exception(zzav$$ExternalSyntheticOutline0.m("Cannot read the initialization vector for ", str, " from SharedPreferences."));
        }
        throw new Exception(zzav$$ExternalSyntheticOutline0.m("Initialization vector for ", str, " is missing from the SharedPreferences."));
    }

    /* renamed from: retrieveEncryptionKey-IoAF18A, reason: not valid java name */
    private final synchronized Object m636retrieveEncryptionKeyIoAF18A(String str) {
        Object m634retrieveKeyIoAF18A;
        LegacyKeyProvider legacyKeyProvider = LegacyKeyProvider.INSTANCE;
        m634retrieveKeyIoAF18A = legacyKeyProvider.m634retrieveKeyIoAF18A(str);
        if (Result.m1661exceptionOrNullimpl(m634retrieveKeyIoAF18A) != null) {
            legacyKeyProvider.deleteKey(str);
            ResultKt.createFailure(new CredentialStoreError("Key cannot be retrieved. Deleting the encryption key identified by the keyAlias: " + str, null, 2, null));
        }
        return m634retrieveKeyIoAF18A;
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public synchronized String get(String dataKey) {
        Integer num;
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        if (!this.isPersistenceEnabled) {
            return this.cache.get(dataKey);
        }
        String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(dataKey);
        Object m636retrieveEncryptionKeyIoAF18A = m636retrieveEncryptionKeyIoAF18A(getEncryptionKeyAlias());
        String str = null;
        if (Result.m1661exceptionOrNullimpl(m636retrieveEncryptionKeyIoAF18A) != null) {
            return null;
        }
        if (!this.sharedPreferencesForData.contains(dataKeyUsedInPersistentStore)) {
            return null;
        }
        try {
            String string = this.sharedPreferencesForData.getString(dataKeyUsedInPersistentStore + SHARED_PREFERENCES_STORE_VERSION_SUFFIX, "-1");
            if (string != null) {
                num = Integer.valueOf(Integer.parseInt(string));
            } else {
                num = null;
            }
        } catch (Exception unused) {
            remove(dataKey);
        }
        if (num != null && num.intValue() == 1) {
            String string2 = this.sharedPreferencesForData.getString(dataKeyUsedInPersistentStore, null);
            ResultKt.throwOnFailure(m636retrieveEncryptionKeyIoAF18A);
            String decrypt = decrypt((Key) m636retrieveEncryptionKeyIoAF18A, getInitializationVector(dataKeyUsedInPersistentStore), string2);
            if (decrypt != null) {
                this.cache.put(dataKey, decrypt);
                str = decrypt;
            }
            return str;
        }
        return null;
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public void put(String dataKey, String str) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        if (str != null) {
            this.cache.put(dataKey, str);
        }
        if (!this.isPersistenceEnabled) {
            return;
        }
        if (str == null) {
            remove(dataKey);
            return;
        }
        String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(dataKey);
        String encryptionKeyAlias = getEncryptionKeyAlias();
        Object m636retrieveEncryptionKeyIoAF18A = m636retrieveEncryptionKeyIoAF18A(encryptionKeyAlias);
        if (Result.m1661exceptionOrNullimpl(m636retrieveEncryptionKeyIoAF18A) != null) {
            m635generateEncryptionKeyIoAF18A(encryptionKeyAlias);
        }
        if (Result.m1661exceptionOrNullimpl(m636retrieveEncryptionKeyIoAF18A) != null) {
            return;
        }
        try {
            byte[] generateInitializationVector = generateInitializationVector();
            ResultKt.throwOnFailure(m636retrieveEncryptionKeyIoAF18A);
            String encrypt = encrypt((Key) m636retrieveEncryptionKeyIoAF18A, new GCMParameterSpec(128, generateInitializationVector), str);
            String encodeToString = Base64.encodeToString(generateInitializationVector, 0);
            if (encodeToString != null) {
                this.sharedPreferencesForData.edit().putString(dataKeyUsedInPersistentStore, encrypt).putString(dataKeyUsedInPersistentStore + SHARED_PREFERENCES_IV_SUFFIX, encodeToString).putInt(dataKeyUsedInPersistentStore + SHARED_PREFERENCES_STORE_VERSION_SUFFIX, 1).apply();
                return;
            }
            throw new Exception("Error in Base64 encoding the IV for dataKey = ".concat(dataKey));
        } catch (Exception unused) {
        }
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public synchronized void remove(String dataKey) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        this.cache.remove(dataKey);
        if (this.isPersistenceEnabled) {
            String dataKeyUsedInPersistentStore = getDataKeyUsedInPersistentStore(dataKey);
            this.sharedPreferencesForData.edit().remove(dataKeyUsedInPersistentStore).remove(dataKeyUsedInPersistentStore + SHARED_PREFERENCES_IV_SUFFIX).remove(dataKeyUsedInPersistentStore + SHARED_PREFERENCES_STORE_VERSION_SUFFIX).apply();
        }
    }

    public /* synthetic */ LegacyKeyValueRepository(Context context, String str, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (r4 & 4) != 0 ? true : z);
    }
}
