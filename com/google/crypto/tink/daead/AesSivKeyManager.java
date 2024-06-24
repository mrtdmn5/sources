package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

/* loaded from: classes3.dex */
public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    public AesSivKeyManager() {
        super(AesSivKey.class, new KeyTypeManager.PrimitiveFactory<DeterministicAead, AesSivKey>() { // from class: com.google.crypto.tink.daead.AesSivKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final DeterministicAead getPrimitive(AesSivKey key) throws GeneralSecurityException {
                return new AesSiv(key.getKeyValue().toByteArray());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, AesSivKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey>() { // from class: com.google.crypto.tink.daead.AesSivKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesSivKey createKey(AesSivKeyFormat format) throws GeneralSecurityException {
                AesSivKey.Builder newBuilder = AesSivKey.newBuilder();
                byte[] randBytes = Random.randBytes(format.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                AesSivKey.access$300((AesSivKey) newBuilder.instance, copyFrom);
                AesSivKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((AesSivKey) newBuilder.instance).version_ = 0;
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesSivKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesSivKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(AesSivKeyFormat format) throws GeneralSecurityException {
                AesSivKeyFormat aesSivKeyFormat = format;
                if (aesSivKeyFormat.getKeySize() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivKeyFormat.getKeySize() + ". Valid keys must have 64 bytes.");
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final AesSivKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesSivKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(AesSivKey key) throws GeneralSecurityException {
        AesSivKey aesSivKey = key;
        Validators.validateVersion(aesSivKey.getVersion());
        if (aesSivKey.getKeyValue().size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + aesSivKey.getKeyValue().size() + ". Valid keys must have 64 bytes.");
    }
}
