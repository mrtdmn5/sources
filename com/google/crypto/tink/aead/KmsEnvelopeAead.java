package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManagerImpl;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class KmsEnvelopeAead implements Aead {
    public static final byte[] EMPTY_AAD = new byte[0];
    public final KeyTemplate dekTemplate;
    public final Aead remote;

    public KmsEnvelopeAead(KeyTemplate dekTemplate, Aead remote) {
        this.dekTemplate = dekTemplate;
        this.remote = remote;
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(ciphertext);
            int r2 = wrap.getInt();
            if (r2 > 0 && r2 <= ciphertext.length - 4) {
                byte[] bArr = new byte[r2];
                wrap.get(bArr, 0, r2);
                byte[] bArr2 = new byte[wrap.remaining()];
                wrap.get(bArr2, 0, wrap.remaining());
                return ((Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), this.remote.decrypt(bArr, EMPTY_AAD))).decrypt(bArr2, associatedData);
            }
            throw new GeneralSecurityException("invalid ciphertext");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        MessageLite messageLite;
        KeyTemplate keyTemplate = this.dekTemplate;
        Logger logger = Registry.logger;
        synchronized (Registry.class) {
            KeyManagerImpl untypedKeyManager = Registry.getKeyManagerContainerOrThrow(keyTemplate.getTypeUrl()).getUntypedKeyManager();
            if (((Boolean) Registry.newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                ByteString value = keyTemplate.getValue();
                untypedKeyManager.getClass();
                try {
                    KeyTypeManager.KeyFactory keyFactory = untypedKeyManager.keyTypeManager.keyFactory();
                    MessageLite parseKeyFormat = keyFactory.parseKeyFormat(value);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    messageLite = (MessageLite) keyFactory.createKey(parseKeyFormat);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("Failures parsing proto of type ".concat(untypedKeyManager.keyTypeManager.keyFactory().clazz.getName()), e);
                }
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        byte[] byteArray = messageLite.toByteArray();
        byte[] encrypt = this.remote.encrypt(byteArray, EMPTY_AAD);
        byte[] encrypt2 = ((Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), byteArray)).encrypt(plaintext, associatedData);
        return ByteBuffer.allocate(encrypt.length + 4 + encrypt2.length).putInt(encrypt.length).put(encrypt).put(encrypt2).array();
    }
}
