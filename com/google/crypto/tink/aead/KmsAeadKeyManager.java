package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey> {
    public KmsAeadKeyManager() {
        super(KmsAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, KmsAeadKey>() { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Aead getPrimitive(KmsAeadKey keyProto) throws GeneralSecurityException {
                String keyUri = keyProto.getParams().getKeyUri();
                return KmsClients.get(keyUri).getAead(keyUri);
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, KmsAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey>() { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final KmsAeadKey createKey(KmsAeadKeyFormat format) throws GeneralSecurityException {
                KmsAeadKey.Builder newBuilder = KmsAeadKey.newBuilder();
                newBuilder.copyOnWrite();
                KmsAeadKey.access$300((KmsAeadKey) newBuilder.instance, format);
                KmsAeadKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((KmsAeadKey) newBuilder.instance).version_ = 0;
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final KmsAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return KmsAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final /* bridge */ /* synthetic */ void validateKeyFormat(KmsAeadKeyFormat format) throws GeneralSecurityException {
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KmsAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return KmsAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(KmsAeadKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion());
    }
}
