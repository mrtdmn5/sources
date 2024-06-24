package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class HmacKeyManager extends KeyTypeManager<HmacKey> {

    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] r0 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r0;
            try {
                r0[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HmacKeyManager() {
        super(HmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, HmacKey>() { // from class: com.google.crypto.tink.mac.HmacKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public final Mac getPrimitive(HmacKey key) throws GeneralSecurityException {
                HmacKey hmacKey = key;
                HashType hash = hmacKey.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.getKeyValue().toByteArray(), "HMAC");
                int tagSize = hmacKey.getParams().getTagSize();
                int r0 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 == 3) {
                            return new PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), tagSize);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), tagSize);
                }
                return new PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), tagSize);
            }
        });
    }

    public static void validateParams(HmacParams params) throws GeneralSecurityException {
        if (params.getTagSize() >= 10) {
            int r0 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[params.getHash().ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 == 3) {
                        if (params.getTagSize() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                        return;
                    }
                    throw new GeneralSecurityException("unknown hash type");
                }
                if (params.getTagSize() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            }
            if (params.getTagSize() <= 20) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too big");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyTypeManager.KeyFactory<?, HmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, HmacKey>() { // from class: com.google.crypto.tink.mac.HmacKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final HmacKey createKey(HmacKeyFormat format) throws GeneralSecurityException {
                HmacKeyFormat hmacKeyFormat = format;
                HmacKey.Builder newBuilder = HmacKey.newBuilder();
                HmacKeyManager.this.getClass();
                newBuilder.copyOnWrite();
                ((HmacKey) newBuilder.instance).version_ = 0;
                HmacParams params = hmacKeyFormat.getParams();
                newBuilder.copyOnWrite();
                HmacKey.access$300((HmacKey) newBuilder.instance, params);
                byte[] randBytes = Random.randBytes(hmacKeyFormat.getKeySize());
                ByteString.LiteralByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                newBuilder.copyOnWrite();
                HmacKey.access$600((HmacKey) newBuilder.instance, copyFrom);
                return newBuilder.build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final HmacKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public final void validateKeyFormat(HmacKeyFormat format) throws GeneralSecurityException {
                HmacKeyFormat hmacKeyFormat = format;
                if (hmacKeyFormat.getKeySize() >= 16) {
                    HmacKeyManager.validateParams(hmacKeyFormat.getParams());
                    return;
                }
                throw new GeneralSecurityException("key too short");
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final HmacKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public final /* bridge */ /* synthetic */ void validateKey(HmacKey key) throws GeneralSecurityException {
        validateKey2(key);
    }

    /* renamed from: validateKey, reason: avoid collision after fix types in other method */
    public static void validateKey2(HmacKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion());
        if (key.getKeyValue().size() >= 16) {
            validateParams(key.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
