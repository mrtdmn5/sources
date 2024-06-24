package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key;
import com.google.crypto.tink.proto.ChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class ChaCha20Poly1305KeyManager extends KeyTypeManager<ChaCha20Poly1305Key> {
    public ChaCha20Poly1305KeyManager() {
        super(ChaCha20Poly1305Key.class, new KeyTypeManager.PrimitiveFactory<Aead, ChaCha20Poly1305Key>() { // from class: com.google.crypto.tink.aead.ChaCha20Poly1305KeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Aead getPrimitive(ChaCha20Poly1305Key key) throws GeneralSecurityException {
                return new ChaCha20Poly1305(key.getKeyValue().toByteArray());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, ChaCha20Poly1305Key> keyFactory() {
        return new KeyTypeManager.KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key>() { // from class: com.google.crypto.tink.aead.ChaCha20Poly1305KeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final ChaCha20Poly1305Key createKey(ChaCha20Poly1305KeyFormat format) throws GeneralSecurityException {
                ChaCha20Poly1305Key.Builder newBuilder = ChaCha20Poly1305Key.newBuilder();
                ChaCha20Poly1305KeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((ChaCha20Poly1305Key) newBuilder.instance).version_ = 0;
                byte[] randBytes = Random.randBytes(32);
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                ChaCha20Poly1305Key.access$300((ChaCha20Poly1305Key) newBuilder.instance, copyFrom);
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final ChaCha20Poly1305KeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return ChaCha20Poly1305KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final /* bridge */ /* synthetic */ void validateKeyFormat(ChaCha20Poly1305KeyFormat format) throws GeneralSecurityException {
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final ChaCha20Poly1305Key parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return ChaCha20Poly1305Key.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final void validateKey(ChaCha20Poly1305Key key) throws GeneralSecurityException {
        ChaCha20Poly1305Key chaCha20Poly1305Key = key;
        Validators.validateVersion(chaCha20Poly1305Key.getVersion());
        if (chaCha20Poly1305Key.getKeyValue().size() == 32) {
        } else {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
