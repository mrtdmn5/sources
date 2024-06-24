package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.Util;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Hex;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* loaded from: classes3.dex */
public final class AndroidKeysetManager {
    public final KeysetManager keysetManager;
    public final Aead masterKey;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public KeysetManager keysetManager;
        public SharedPrefKeysetReader reader = null;
        public SharedPrefKeysetWriter writer = null;
        public String masterKeyUri = null;
        public AndroidKeystoreAesGcm masterKey = null;
        public KeyTemplate keyTemplate = null;

        public final KeysetManager readOrGenerateNewKeyset() throws GeneralSecurityException, IOException {
            try {
                AndroidKeystoreAesGcm androidKeystoreAesGcm = this.masterKey;
                if (androidKeystoreAesGcm != null) {
                    try {
                        Keyset keyset = KeysetHandle.read(this.reader, androidKeystoreAesGcm).keyset;
                        keyset.getClass();
                        GeneratedMessageLite.Builder builder = (GeneratedMessageLite.Builder) keyset.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_BUILDER);
                        builder.copyOnWrite();
                        GeneratedMessageLite.Builder.mergeFromInstance(builder.instance, keyset);
                        return new KeysetManager((Keyset.Builder) builder);
                    } catch (InvalidProtocolBufferException | GeneralSecurityException e) {
                        Log.w("AndroidKeysetManager", "cannot decrypt keyset: ", e);
                    }
                }
                Keyset parseFrom = Keyset.parseFrom(this.reader.readPref(), ExtensionRegistryLite.getEmptyRegistry());
                if (parseFrom.getKeyCount() > 0) {
                    GeneratedMessageLite.Builder builder2 = (GeneratedMessageLite.Builder) parseFrom.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_BUILDER);
                    builder2.copyOnWrite();
                    GeneratedMessageLite.Builder.mergeFromInstance(builder2.instance, parseFrom);
                    return new KeysetManager((Keyset.Builder) builder2);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (FileNotFoundException e2) {
                Log.w("AndroidKeysetManager", "keyset not found, will generate a new one", e2);
                if (this.keyTemplate != null) {
                    Keyset.Builder newBuilder = Keyset.newBuilder();
                    KeysetManager keysetManager = new KeysetManager(newBuilder);
                    KeyTemplate keyTemplate = this.keyTemplate;
                    synchronized (keysetManager) {
                        com.google.crypto.tink.proto.KeyTemplate keyTemplate2 = keyTemplate.kt;
                        synchronized (keysetManager) {
                            Keyset.Key newKey = keysetManager.newKey(keyTemplate2);
                            newBuilder.copyOnWrite();
                            Keyset.access$1700((Keyset) newBuilder.instance, newKey);
                            int keyId = Util.getKeysetInfo(keysetManager.getKeysetHandle().keyset).getKeyInfo().getKeyId();
                            synchronized (keysetManager) {
                                for (int r3 = 0; r3 < ((Keyset) keysetManager.keysetBuilder.instance).getKeyCount(); r3++) {
                                    Keyset.Key key = ((Keyset) keysetManager.keysetBuilder.instance).getKey(r3);
                                    if (key.getKeyId() == keyId) {
                                        if (key.getStatus().equals(KeyStatusType.ENABLED)) {
                                            Keyset.Builder builder3 = keysetManager.keysetBuilder;
                                            builder3.copyOnWrite();
                                            ((Keyset) builder3.instance).primaryKeyId_ = keyId;
                                            if (this.masterKey != null) {
                                                KeysetHandle keysetHandle = keysetManager.getKeysetHandle();
                                                SharedPrefKeysetWriter sharedPrefKeysetWriter = this.writer;
                                                AndroidKeystoreAesGcm androidKeystoreAesGcm2 = this.masterKey;
                                                Keyset keyset2 = keysetHandle.keyset;
                                                byte[] encrypt = androidKeystoreAesGcm2.encrypt(keyset2.toByteArray(), new byte[0]);
                                                try {
                                                    if (Keyset.parseFrom(androidKeystoreAesGcm2.decrypt(encrypt, new byte[0]), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset2)) {
                                                        EncryptedKeyset.Builder newBuilder2 = EncryptedKeyset.newBuilder();
                                                        ByteString.LiteralByteString copyFrom = ByteString.copyFrom(encrypt, 0, encrypt.length);
                                                        newBuilder2.copyOnWrite();
                                                        EncryptedKeyset.access$100((EncryptedKeyset) newBuilder2.instance, copyFrom);
                                                        KeysetInfo keysetInfo = Util.getKeysetInfo(keyset2);
                                                        newBuilder2.copyOnWrite();
                                                        EncryptedKeyset.access$300((EncryptedKeyset) newBuilder2.instance, keysetInfo);
                                                        EncryptedKeyset build = newBuilder2.build();
                                                        sharedPrefKeysetWriter.getClass();
                                                        if (!sharedPrefKeysetWriter.editor.putString(sharedPrefKeysetWriter.keysetName, Hex.encode(build.toByteArray())).commit()) {
                                                            throw new IOException("Failed to write to SharedPreferences");
                                                        }
                                                    } else {
                                                        throw new GeneralSecurityException("cannot encrypt keyset");
                                                    }
                                                } catch (InvalidProtocolBufferException unused) {
                                                    throw new GeneralSecurityException("invalid keyset, corrupted key material");
                                                }
                                            } else {
                                                KeysetHandle keysetHandle2 = keysetManager.getKeysetHandle();
                                                SharedPrefKeysetWriter sharedPrefKeysetWriter2 = this.writer;
                                                Keyset keyset3 = keysetHandle2.keyset;
                                                sharedPrefKeysetWriter2.getClass();
                                                if (!sharedPrefKeysetWriter2.editor.putString(sharedPrefKeysetWriter2.keysetName, Hex.encode(keyset3.toByteArray())).commit()) {
                                                    throw new IOException("Failed to write to SharedPreferences");
                                                }
                                            }
                                            return keysetManager;
                                        }
                                        throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + keyId);
                                    }
                                }
                                throw new GeneralSecurityException("key not found: " + keyId);
                            }
                        }
                    }
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        public final AndroidKeystoreAesGcm readOrGenerateNewMasterKey() throws GeneralSecurityException {
            AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            boolean hasKey = androidKeystoreKmsClient.hasKey(this.masterKeyUri);
            if (!hasKey) {
                try {
                    AndroidKeystoreKmsClient.generateNewAeadKey(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e) {
                    Log.w("AndroidKeysetManager", "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            }
            try {
                return androidKeystoreKmsClient.getAead(this.masterKeyUri);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!hasKey) {
                    Log.w("AndroidKeysetManager", "cannot use Android Keystore, it'll be disabled", e2);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.masterKeyUri), e2);
            }
        }

        public final void withSharedPref(Context context, String keysetName, String prefFileName) throws IOException {
            if (context != null) {
                this.reader = new SharedPrefKeysetReader(context, keysetName, prefFileName);
                this.writer = new SharedPrefKeysetWriter(context, keysetName, prefFileName);
                return;
            }
            throw new IllegalArgumentException("need an Android context");
        }
    }

    public AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        SharedPrefKeysetWriter sharedPrefKeysetWriter = builder.writer;
        this.masterKey = builder.masterKey;
        this.keysetManager = builder.keysetManager;
    }
}
