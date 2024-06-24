package com.amplifyframework.core.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadWrapper;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.KeyGenerator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: EncryptedKeyValueRepository.kt */
/* loaded from: classes.dex */
public final class EncryptedKeyValueRepository implements KeyValueRepository {
    private final Context context;
    private final Lazy editor$delegate;
    private final Lazy sharedPreferences$delegate;
    private final String sharedPreferencesName;

    public EncryptedKeyValueRepository(Context context, String sharedPreferencesName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferencesName, "sharedPreferencesName");
        this.context = context;
        this.sharedPreferencesName = sharedPreferencesName;
        this.sharedPreferences$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.amplifyframework.core.store.EncryptedKeyValueRepository$sharedPreferences$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                String str;
                Context context2;
                String str2;
                String installationIdentifier;
                Context context3;
                AndroidKeysetManager androidKeysetManager;
                KeysetHandle keysetHandle;
                AndroidKeysetManager androidKeysetManager2;
                KeysetHandle keysetHandle2;
                StringBuilder sb = new StringBuilder();
                str = EncryptedKeyValueRepository.this.sharedPreferencesName;
                sb.append(str);
                sb.append('.');
                EncryptedKeyValueRepository encryptedKeyValueRepository = EncryptedKeyValueRepository.this;
                context2 = encryptedKeyValueRepository.context;
                str2 = EncryptedKeyValueRepository.this.sharedPreferencesName;
                installationIdentifier = encryptedKeyValueRepository.getInstallationIdentifier(context2, str2);
                sb.append(installationIdentifier);
                String sb2 = sb.toString();
                KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
                if (keyGenParameterSpec.getKeySize() == 256) {
                    if (Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
                        if (keyGenParameterSpec.getPurposes() == 3) {
                            if (Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
                                if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
                                    throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
                                }
                                String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
                                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                                keyStore.load(null);
                                if (!keyStore.containsAlias(keystoreAlias)) {
                                    KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, "AndroidKeyStore");
                                    keyGenerator.init(keyGenParameterSpec);
                                    keyGenerator.generateKey();
                                }
                                String keystoreAlias2 = keyGenParameterSpec.getKeystoreAlias();
                                context3 = EncryptedKeyValueRepository.this.context;
                                EncryptedSharedPreferences.PrefKeyEncryptionScheme prefKeyEncryptionScheme = EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV;
                                EncryptedSharedPreferences.PrefValueEncryptionScheme prefValueEncryptionScheme = EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM;
                                int r6 = DeterministicAeadConfig.$r8$clinit;
                                Registry.registerKeyManager(new AesSivKeyManager(), true);
                                Registry.registerPrimitiveWrapper(new DeterministicAeadWrapper());
                                AeadConfig.register();
                                AndroidKeysetManager.Builder builder = new AndroidKeysetManager.Builder();
                                builder.keyTemplate = prefKeyEncryptionScheme.getKeyTemplate();
                                builder.withSharedPref(context3, "__androidx_security_crypto_encrypted_prefs_key_keyset__", sb2);
                                String str3 = "android-keystore://" + keystoreAlias2;
                                if (str3.startsWith("android-keystore://")) {
                                    builder.masterKeyUri = str3;
                                    synchronized (builder) {
                                        if (builder.masterKeyUri != null) {
                                            builder.masterKey = builder.readOrGenerateNewMasterKey();
                                        }
                                        builder.keysetManager = builder.readOrGenerateNewKeyset();
                                        androidKeysetManager = new AndroidKeysetManager(builder);
                                    }
                                    synchronized (androidKeysetManager) {
                                        keysetHandle = androidKeysetManager.keysetManager.getKeysetHandle();
                                    }
                                    AndroidKeysetManager.Builder builder2 = new AndroidKeysetManager.Builder();
                                    builder2.keyTemplate = prefValueEncryptionScheme.getKeyTemplate();
                                    builder2.withSharedPref(context3, "__androidx_security_crypto_encrypted_prefs_value_keyset__", sb2);
                                    String str4 = "android-keystore://" + keystoreAlias2;
                                    if (str4.startsWith("android-keystore://")) {
                                        builder2.masterKeyUri = str4;
                                        synchronized (builder2) {
                                            if (builder2.masterKeyUri != null) {
                                                builder2.masterKey = builder2.readOrGenerateNewMasterKey();
                                            }
                                            builder2.keysetManager = builder2.readOrGenerateNewKeyset();
                                            androidKeysetManager2 = new AndroidKeysetManager(builder2);
                                        }
                                        synchronized (androidKeysetManager2) {
                                            keysetHandle2 = androidKeysetManager2.keysetManager.getKeysetHandle();
                                        }
                                        return new EncryptedSharedPreferences(sb2, context3.getSharedPreferences(sb2, 0), (Aead) keysetHandle2.getPrimitive(Aead.class), (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
                                    }
                                    throw new IllegalArgumentException("key URI must start with android-keystore://");
                                }
                                throw new IllegalArgumentException("key URI must start with android-keystore://");
                            }
                            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
                        }
                        throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
                    }
                    throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
                }
                throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
            }
        });
        this.editor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences.Editor>() { // from class: com.amplifyframework.core.store.EncryptedKeyValueRepository$editor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences.Editor invoke() {
                return EncryptedKeyValueRepository.this.getSharedPreferences$com_amplifyframework_core().edit();
            }
        });
    }

    private final String createInstallationIdentifier(File file) {
        String str = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        try {
            FilesKt__FileReadWriteKt.writeText$default(file, str);
        } catch (Exception unused) {
        }
        return str;
    }

    private final String getExistingInstallationIdentifier(File file) {
        if (!file.exists()) {
            return null;
        }
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String readText = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            if (StringsKt__StringsJVMKt.isBlank(readText)) {
                return null;
            }
            return readText;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public final synchronized String getInstallationIdentifier(Context context, String str) {
        String existingInstallationIdentifier;
        File file = new File(context.getNoBackupFilesDir(), str + ".installationIdentifier");
        existingInstallationIdentifier = getExistingInstallationIdentifier(file);
        if (existingInstallationIdentifier == null) {
            existingInstallationIdentifier = createInstallationIdentifier(file);
        }
        return existingInstallationIdentifier;
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public String get(String dataKey) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return getSharedPreferences$com_amplifyframework_core().getString(dataKey, null);
    }

    public final SharedPreferences.Editor getEditor$com_amplifyframework_core() {
        Object value = this.editor$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-editor>(...)");
        return (SharedPreferences.Editor) value;
    }

    public final SharedPreferences getSharedPreferences$com_amplifyframework_core() {
        return (SharedPreferences) this.sharedPreferences$delegate.getValue();
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public void put(String dataKey, String str) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        SharedPreferences.Editor editor$com_amplifyframework_core = getEditor$com_amplifyframework_core();
        editor$com_amplifyframework_core.putString(dataKey, str);
        editor$com_amplifyframework_core.apply();
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public void remove(String dataKey) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        SharedPreferences.Editor editor$com_amplifyframework_core = getEditor$com_amplifyframework_core();
        editor$com_amplifyframework_core.remove(dataKey);
        editor$com_amplifyframework_core.apply();
    }

    public static /* synthetic */ void getEditor$com_amplifyframework_core$annotations() {
    }

    public static /* synthetic */ void getSharedPreferences$com_amplifyframework_core$annotations() {
    }
}
