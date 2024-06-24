package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> {
    public final KeyTypeManager<KeyProtoT> keyTypeManager;
    public final Class<PrimitiveT> primitiveClass;

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager, Class<PrimitiveT> primitiveClass) {
        if (!keyTypeManager.factories.keySet().contains(primitiveClass) && !Void.class.equals(primitiveClass)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), primitiveClass.getName()));
        }
        this.keyTypeManager = keyTypeManager;
        this.primitiveClass = primitiveClass;
    }

    public final KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException {
        KeyTypeManager<KeyProtoT> keyTypeManager = this.keyTypeManager;
        try {
            KeyTypeManager.KeyFactory<?, KeyProtoT> keyFactory = keyTypeManager.keyFactory();
            Object parseKeyFormat = keyFactory.parseKeyFormat(serializedKeyFormat);
            keyFactory.validateKeyFormat(parseKeyFormat);
            KeyProtoT createKey = keyFactory.createKey(parseKeyFormat);
            KeyData.Builder newBuilder = KeyData.newBuilder();
            String keyType = keyTypeManager.getKeyType();
            newBuilder.copyOnWrite();
            KeyData.access$100((KeyData) newBuilder.instance, keyType);
            ByteString.LiteralByteString byteString = createKey.toByteString();
            newBuilder.copyOnWrite();
            KeyData.access$400((KeyData) newBuilder.instance, byteString);
            KeyData.KeyMaterialType keyMaterialType = keyTypeManager.keyMaterialType();
            newBuilder.copyOnWrite();
            KeyData.access$700((KeyData) newBuilder.instance, keyMaterialType);
            return newBuilder.build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
