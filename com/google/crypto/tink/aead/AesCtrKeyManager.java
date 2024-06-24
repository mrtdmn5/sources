package com.google.crypto.tink.aead;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class AesCtrKeyManager extends KeyTypeManager<AesCtrKey> {
    public AesCtrKeyManager() {
        super(AesCtrKey.class, new KeyTypeManager.PrimitiveFactory<IndCpaCipher, AesCtrKey>() { // from class: com.google.crypto.tink.aead.AesCtrKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final IndCpaCipher getPrimitive(AesCtrKey key) throws GeneralSecurityException {
                AesCtrKey aesCtrKey = key;
                return new AesCtrJceCipher(aesCtrKey.getKeyValue().toByteArray(), aesCtrKey.getParams().getIvSize());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, AesCtrKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrKeyFormat, AesCtrKey>() { // from class: com.google.crypto.tink.aead.AesCtrKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCtrKey createKey(AesCtrKeyFormat format) throws GeneralSecurityException {
                AesCtrKeyFormat aesCtrKeyFormat = format;
                AesCtrKey.Builder newBuilder = AesCtrKey.newBuilder();
                AesCtrParams params = aesCtrKeyFormat.getParams();
                newBuilder.copyOnWrite();
                AesCtrKey.access$300((AesCtrKey) newBuilder.instance, params);
                byte[] randBytes = Random.randBytes(aesCtrKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                AesCtrKey.access$600((AesCtrKey) newBuilder.instance, copyFrom);
                AesCtrKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((AesCtrKey) newBuilder.instance).version_ = 0;
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCtrKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(AesCtrKeyFormat format) throws GeneralSecurityException {
                AesCtrKeyFormat aesCtrKeyFormat = format;
                Validators.validateAesKeySize(aesCtrKeyFormat.getKeySize());
                AesCtrParams params = aesCtrKeyFormat.getParams();
                AesCtrKeyManager.this.getClass();
                if (params.getIvSize() >= 12 && params.getIvSize() <= 16) {
                } else {
                    throw new GeneralSecurityException("invalid IV size");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final AesCtrKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(AesCtrKey key) throws GeneralSecurityException {
        AesCtrKey aesCtrKey = key;
        Validators.validateVersion(aesCtrKey.getVersion());
        Validators.validateAesKeySize(aesCtrKey.getKeyValue().size());
        AesCtrParams params = aesCtrKey.getParams();
        if (params.getIvSize() >= 12 && params.getIvSize() <= 16) {
        } else {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
