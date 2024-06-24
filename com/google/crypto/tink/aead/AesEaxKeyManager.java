package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey> {
    public AesEaxKeyManager() {
        super(AesEaxKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesEaxKey>() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Aead getPrimitive(AesEaxKey key) throws GeneralSecurityException {
                AesEaxKey aesEaxKey = key;
                return new AesEaxJce(aesEaxKey.getKeyValue().toByteArray(), aesEaxKey.getParams().getIvSize());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, AesEaxKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey>() { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesEaxKey createKey(AesEaxKeyFormat format) throws GeneralSecurityException {
                AesEaxKeyFormat aesEaxKeyFormat = format;
                AesEaxKey.Builder newBuilder = AesEaxKey.newBuilder();
                byte[] randBytes = Random.randBytes(aesEaxKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                AesEaxKey.access$600((AesEaxKey) newBuilder.instance, copyFrom);
                AesEaxParams params = aesEaxKeyFormat.getParams();
                newBuilder.copyOnWrite();
                AesEaxKey.access$300((AesEaxKey) newBuilder.instance, params);
                AesEaxKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((AesEaxKey) newBuilder.instance).version_ = 0;
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesEaxKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesEaxKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(AesEaxKeyFormat format) throws GeneralSecurityException {
                AesEaxKeyFormat aesEaxKeyFormat = format;
                Validators.validateAesKeySize(aesEaxKeyFormat.getKeySize());
                if (aesEaxKeyFormat.getParams().getIvSize() != 12 && aesEaxKeyFormat.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final AesEaxKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesEaxKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(AesEaxKey key) throws GeneralSecurityException {
        AesEaxKey aesEaxKey = key;
        Validators.validateVersion(aesEaxKey.getVersion());
        Validators.validateAesKeySize(aesEaxKey.getKeyValue().size());
        if (aesEaxKey.getParams().getIvSize() != 12 && aesEaxKey.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
