package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    public final Class<KeyProtoT> clazz;
    public final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    public final Class<?> firstPrimitiveClass;

    /* loaded from: classes3.dex */
    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT> {
        public final Class<KeyFormatProtoT> clazz;

        public KeyFactory(Class<KeyFormatProtoT> clazz) {
            this.clazz = clazz;
        }

        public abstract KeyT createKey(KeyFormatProtoT keyFormat) throws GeneralSecurityException;

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void validateKeyFormat(KeyFormatProtoT keyFormatProto) throws GeneralSecurityException;
    }

    /* loaded from: classes3.dex */
    public static abstract class PrimitiveFactory<PrimitiveT, KeyT> {
        public final Class<PrimitiveT> clazz;

        public PrimitiveFactory(Class<PrimitiveT> clazz) {
            this.clazz = clazz;
        }

        public abstract PrimitiveT getPrimitive(KeyT key) throws GeneralSecurityException;
    }

    @SafeVarargs
    public KeyTypeManager(Class<KeyProtoT> clazz, PrimitiveFactory<?, KeyProtoT>... factories) {
        this.clazz = clazz;
        HashMap hashMap = new HashMap();
        for (PrimitiveFactory<?, KeyProtoT> primitiveFactory : factories) {
            boolean containsKey = hashMap.containsKey(primitiveFactory.clazz);
            Class<?> cls = primitiveFactory.clazz;
            if (!containsKey) {
                hashMap.put(cls, primitiveFactory);
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
            }
        }
        if (factories.length > 0) {
            this.firstPrimitiveClass = factories[0].clazz;
        } else {
            this.firstPrimitiveClass = Void.class;
        }
        this.factories = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        PrimitiveFactory<?, KeyProtoT> primitiveFactory = this.factories.get(cls);
        if (primitiveFactory != null) {
            return (P) primitiveFactory.getPrimitive(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract KeyFactory<?, KeyProtoT> keyFactory();

    public abstract KeyData.KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString) throws InvalidProtocolBufferException;

    public abstract void validateKey(KeyProtoT keyProto) throws GeneralSecurityException;
}
