package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey> {
    public AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesCtrHmacAeadKey>() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Aead getPrimitive(AesCtrHmacAeadKey key) throws GeneralSecurityException {
                AesCtrHmacAeadKey aesCtrHmacAeadKey = key;
                return new EncryptThenAuthenticate((IndCpaCipher) new AesCtrKeyManager().getPrimitive(aesCtrHmacAeadKey.getAesCtrKey(), IndCpaCipher.class), (Mac) new HmacKeyManager().getPrimitive(aesCtrHmacAeadKey.getHmacKey(), Mac.class), aesCtrHmacAeadKey.getHmacKey().getParams().getTagSize());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, AesCtrHmacAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>() { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCtrHmacAeadKey createKey(AesCtrHmacAeadKeyFormat format) throws GeneralSecurityException {
                AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = format;
                new AesCtrKeyManager();
                AesCtrKeyFormat aesCtrKeyFormat = aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat();
                AesCtrKey.Builder newBuilder = AesCtrKey.newBuilder();
                AesCtrParams params = aesCtrKeyFormat.getParams();
                newBuilder.copyOnWrite();
                AesCtrKey.access$300((AesCtrKey) newBuilder.instance, params);
                byte[] randBytes = Random.randBytes(aesCtrKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                AesCtrKey.access$600((AesCtrKey) newBuilder.instance, copyFrom);
                newBuilder.copyOnWrite();
                ((AesCtrKey) newBuilder.instance).version_ = 0;
                AesCtrKey build = newBuilder.build();
                new HmacKeyManager();
                HmacKeyFormat hmacKeyFormat = aesCtrHmacAeadKeyFormat.getHmacKeyFormat();
                HmacKey.Builder newBuilder2 = HmacKey.newBuilder();
                newBuilder2.copyOnWrite();
                ((HmacKey) newBuilder2.instance).version_ = 0;
                HmacParams params2 = hmacKeyFormat.getParams();
                newBuilder2.copyOnWrite();
                HmacKey.access$300((HmacKey) newBuilder2.instance, params2);
                byte[] randBytes2 = Random.randBytes(hmacKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom2 = ByteString.copyFrom(randBytes2, 0, randBytes2.length);
                newBuilder2.copyOnWrite();
                HmacKey.access$600((HmacKey) newBuilder2.instance, copyFrom2);
                HmacKey build2 = newBuilder2.build();
                AesCtrHmacAeadKey.Builder newBuilder3 = AesCtrHmacAeadKey.newBuilder();
                newBuilder3.copyOnWrite();
                AesCtrHmacAeadKey.access$300((AesCtrHmacAeadKey) newBuilder3.instance, build);
                newBuilder3.copyOnWrite();
                AesCtrHmacAeadKey.access$600((AesCtrHmacAeadKey) newBuilder3.instance, build2);
                AesCtrHmacAeadKeyManager.this.getClass();
                newBuilder3.copyOnWrite();
                ((AesCtrHmacAeadKey) newBuilder3.instance).version_ = 0;
                return newBuilder3.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCtrHmacAeadKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(AesCtrHmacAeadKeyFormat format) throws GeneralSecurityException {
                AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = format;
                new AesCtrKeyManager();
                AesCtrKeyFormat aesCtrKeyFormat = aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat();
                Validators.validateAesKeySize(aesCtrKeyFormat.getKeySize());
                AesCtrParams params = aesCtrKeyFormat.getParams();
                if (params.getIvSize() >= 12 && params.getIvSize() <= 16) {
                    new HmacKeyManager();
                    HmacKeyFormat hmacKeyFormat = aesCtrHmacAeadKeyFormat.getHmacKeyFormat();
                    if (hmacKeyFormat.getKeySize() >= 16) {
                        HmacKeyManager.validateParams(hmacKeyFormat.getParams());
                        Validators.validateAesKeySize(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat().getKeySize());
                        return;
                    }
                    throw new GeneralSecurityException("key too short");
                }
                throw new GeneralSecurityException("invalid IV size");
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final AesCtrHmacAeadKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(AesCtrHmacAeadKey key) throws GeneralSecurityException {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = key;
        Validators.validateVersion(aesCtrHmacAeadKey.getVersion());
        new AesCtrKeyManager();
        AesCtrKey aesCtrKey = aesCtrHmacAeadKey.getAesCtrKey();
        Validators.validateVersion(aesCtrKey.getVersion());
        Validators.validateAesKeySize(aesCtrKey.getKeyValue().size());
        AesCtrParams params = aesCtrKey.getParams();
        if (params.getIvSize() >= 12 && params.getIvSize() <= 16) {
            new HmacKeyManager();
            HmacKeyManager.validateKey2(aesCtrHmacAeadKey.getHmacKey());
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }
}
