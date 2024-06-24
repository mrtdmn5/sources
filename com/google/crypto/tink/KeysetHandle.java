package com.google.crypto.tink;

import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.integration.android.SharedPrefKeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class KeysetHandle {
    public final Keyset keyset;

    public KeysetHandle(Keyset keyset) {
        this.keyset = keyset;
    }

    public static final KeysetHandle read(SharedPrefKeysetReader reader, Aead masterKey) throws GeneralSecurityException, IOException {
        EncryptedKeyset parseFrom = EncryptedKeyset.parseFrom(reader.readPref(), ExtensionRegistryLite.getEmptyRegistry());
        if (parseFrom.getEncryptedKeyset().size() != 0) {
            try {
                Keyset parseFrom2 = Keyset.parseFrom(masterKey.decrypt(parseFrom.getEncryptedKeyset().toByteArray(), new byte[0]), ExtensionRegistryLite.getEmptyRegistry());
                if (parseFrom2.getKeyCount() > 0) {
                    return new KeysetHandle(parseFrom2);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (InvalidProtocolBufferException unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class inputPrimitiveClass;
        byte[] array;
        PrimitiveWrapper primitiveWrapper = (PrimitiveWrapper) Registry.primitiveWrapperMap.get(cls);
        if (primitiveWrapper == null) {
            inputPrimitiveClass = null;
        } else {
            inputPrimitiveClass = primitiveWrapper.getInputPrimitiveClass();
        }
        if (inputPrimitiveClass != null) {
            int r2 = Util.$r8$clinit;
            Keyset keyset = this.keyset;
            int primaryKeyId = keyset.getPrimaryKeyId();
            boolean z = true;
            int r7 = 0;
            boolean z2 = false;
            for (Keyset.Key key : keyset.getKeyList()) {
                if (key.getStatus() == KeyStatusType.ENABLED) {
                    if (key.hasKeyData()) {
                        if (key.getOutputPrefixType() != OutputPrefixType.UNKNOWN_PREFIX) {
                            if (key.getStatus() != KeyStatusType.UNKNOWN_STATUS) {
                                if (key.getKeyId() == primaryKeyId) {
                                    if (!z2) {
                                        z2 = true;
                                    } else {
                                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                                    }
                                }
                                if (key.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                                    z = false;
                                }
                                r7++;
                            } else {
                                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(key.getKeyId())));
                            }
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(key.getKeyId())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(key.getKeyId())));
                    }
                }
            }
            if (r7 != 0) {
                if (!z2 && !z) {
                    throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
                }
                PrimitiveSet primitiveSet = new PrimitiveSet(inputPrimitiveClass);
                for (Keyset.Key key2 : keyset.getKeyList()) {
                    KeyStatusType status = key2.getStatus();
                    KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                    if (status == keyStatusType) {
                        Object primitiveInternal = Registry.getPrimitiveInternal(key2.getKeyData().getTypeUrl(), key2.getKeyData().getValue(), inputPrimitiveClass);
                        if (key2.getStatus() == keyStatusType) {
                            int r11 = CryptoFormat.AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[key2.getOutputPrefixType().ordinal()];
                            if (r11 != 1 && r11 != 2) {
                                if (r11 != 3) {
                                    if (r11 == 4) {
                                        array = CryptoFormat.RAW_PREFIX;
                                    } else {
                                        throw new GeneralSecurityException("unknown output prefix type");
                                    }
                                } else {
                                    array = ByteBuffer.allocate(5).put((byte) 1).putInt(key2.getKeyId()).array();
                                }
                            } else {
                                array = ByteBuffer.allocate(5).put((byte) 0).putInt(key2.getKeyId()).array();
                            }
                            PrimitiveSet.Entry<P> entry = new PrimitiveSet.Entry<>(primitiveInternal, array, key2.getStatus(), key2.getOutputPrefixType());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(entry);
                            PrimitiveSet.Prefix prefix = new PrimitiveSet.Prefix(entry.getIdentifier());
                            ConcurrentHashMap concurrentHashMap = primitiveSet.primitives;
                            List list = (List) concurrentHashMap.put(prefix, Collections.unmodifiableList(arrayList));
                            if (list != null) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.addAll(list);
                                arrayList2.add(entry);
                                concurrentHashMap.put(prefix, Collections.unmodifiableList(arrayList2));
                            }
                            if (key2.getKeyId() != keyset.getPrimaryKeyId()) {
                                continue;
                            } else if (entry.status == keyStatusType) {
                                if (!primitiveSet.getPrimitive(entry.getIdentifier()).isEmpty()) {
                                    primitiveSet.primary = entry;
                                } else {
                                    throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
                                }
                            } else {
                                throw new IllegalArgumentException("the primary entry has to be ENABLED");
                            }
                        } else {
                            throw new GeneralSecurityException("only ENABLED key is allowed");
                        }
                    }
                }
                PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) Registry.primitiveWrapperMap.get(cls);
                Class<P> cls2 = primitiveSet.primitiveClass;
                if (primitiveWrapper2 != null) {
                    if (primitiveWrapper2.getInputPrimitiveClass().equals(cls2)) {
                        return (P) primitiveWrapper2.wrap(primitiveSet);
                    }
                    throw new GeneralSecurityException("Wrong input primitive class, expected " + primitiveWrapper2.getInputPrimitiveClass() + ", got " + cls2);
                }
                throw new GeneralSecurityException("No wrapper found for ".concat(cls2.getName()));
            }
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    public final String toString() {
        return Util.getKeysetInfo(this.keyset).toString();
    }
}
