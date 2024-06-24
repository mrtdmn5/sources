package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey> {
    public KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, KmsEnvelopeAeadKey>() { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Aead getPrimitive(KmsEnvelopeAeadKey keyProto) throws GeneralSecurityException {
                KmsEnvelopeAeadKey kmsEnvelopeAeadKey = keyProto;
                String kekUri = kmsEnvelopeAeadKey.getParams().getKekUri();
                return new KmsEnvelopeAead(kmsEnvelopeAeadKey.getParams().getDekTemplate(), KmsClients.get(kekUri).getAead(kekUri));
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, KmsEnvelopeAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>() { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final KmsEnvelopeAeadKey createKey(KmsEnvelopeAeadKeyFormat format) throws GeneralSecurityException {
                KmsEnvelopeAeadKey.Builder newBuilder = KmsEnvelopeAeadKey.newBuilder();
                newBuilder.copyOnWrite();
                KmsEnvelopeAeadKey.access$300((KmsEnvelopeAeadKey) newBuilder.instance, format);
                KmsEnvelopeAeadKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((KmsEnvelopeAeadKey) newBuilder.instance).version_ = 0;
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final KmsEnvelopeAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return KmsEnvelopeAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final /* bridge */ /* synthetic */ void validateKeyFormat(KmsEnvelopeAeadKeyFormat format) throws GeneralSecurityException {
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KmsEnvelopeAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return KmsEnvelopeAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(KmsEnvelopeAeadKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion());
    }
}
