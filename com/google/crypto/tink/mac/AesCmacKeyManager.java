package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.AesCmacKey;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class AesCmacKeyManager extends KeyTypeManager<AesCmacKey> {
    public AesCmacKeyManager() {
        super(AesCmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, AesCmacKey>() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Mac getPrimitive(AesCmacKey key) throws GeneralSecurityException {
                AesCmacKey aesCmacKey = key;
                return new PrfMac(new PrfAesCmac(aesCmacKey.getKeyValue().toByteArray()), aesCmacKey.getParams().getTagSize());
            }
        });
    }

    public static void validateParams(AesCmacParams params) throws GeneralSecurityException {
        if (params.getTagSize() >= 10) {
            if (params.getTagSize() <= 16) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too long");
            }
        }
        throw new GeneralSecurityException("tag size too short");
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, AesCmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCmacKeyFormat, AesCmacKey>() { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCmacKey createKey(AesCmacKeyFormat format) throws GeneralSecurityException {
                AesCmacKeyFormat aesCmacKeyFormat = format;
                AesCmacKey.Builder newBuilder = AesCmacKey.newBuilder();
                newBuilder.copyOnWrite();
                ((AesCmacKey) newBuilder.instance).version_ = 0;
                byte[] randBytes = Random.randBytes(aesCmacKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                AesCmacKey.access$300((AesCmacKey) newBuilder.instance, copyFrom);
                AesCmacParams params = aesCmacKeyFormat.getParams();
                newBuilder.copyOnWrite();
                AesCmacKey.access$500((AesCmacKey) newBuilder.instance, params);
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final AesCmacKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(AesCmacKeyFormat format) throws GeneralSecurityException {
                AesCmacKeyFormat aesCmacKeyFormat = format;
                AesCmacKeyManager.validateParams(aesCmacKeyFormat.getParams());
                if (aesCmacKeyFormat.getKeySize() == 32) {
                } else {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final AesCmacKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(AesCmacKey key) throws GeneralSecurityException {
        AesCmacKey aesCmacKey = key;
        Validators.validateVersion(aesCmacKey.getVersion());
        if (aesCmacKey.getKeyValue().size() == 32) {
            validateParams(aesCmacKey.getParams());
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }
}
