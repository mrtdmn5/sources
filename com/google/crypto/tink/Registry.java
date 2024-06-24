package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.lang.reflect.GenericDeclaration;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Registry {
    public static final ConcurrentHashMap primitiveWrapperMap;
    public static final Logger logger = Logger.getLogger(Registry.class.getName());
    public static final ConcurrentHashMap keyManagerMap = new ConcurrentHashMap();
    public static final ConcurrentHashMap keyDeriverMap = new ConcurrentHashMap();
    public static final ConcurrentHashMap newKeyAllowedMap = new ConcurrentHashMap();

    /* renamed from: com.google.crypto.tink.Registry$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 {
    }

    /* loaded from: classes3.dex */
    public interface KeyManagerContainer {
        Class<?> getImplementingClass();

        KeyManagerImpl getKeyManager(Class primitiveClass) throws GeneralSecurityException;

        KeyManagerImpl getUntypedKeyManager();

        Set<Class<?>> supportedPrimitives();
    }

    static {
        new ConcurrentHashMap();
        primitiveWrapperMap = new ConcurrentHashMap();
    }

    public static synchronized void ensureKeyManagerInsertable(String typeUrl, Class<?> implementingClass, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            ConcurrentHashMap concurrentHashMap = keyManagerMap;
            if (!concurrentHashMap.containsKey(typeUrl)) {
                return;
            }
            KeyManagerContainer keyManagerContainer = (KeyManagerContainer) concurrentHashMap.get(typeUrl);
            if (keyManagerContainer.getImplementingClass().equals(implementingClass)) {
                if (newKeyAllowed && !((Boolean) newKeyAllowedMap.get(typeUrl)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + typeUrl);
                }
                return;
            }
            logger.warning("Attempted overwrite of a registered key manager for key type " + typeUrl);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", typeUrl, keyManagerContainer.getImplementingClass().getName(), implementingClass.getName()));
        }
    }

    public static synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String typeUrl) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainer;
        synchronized (Registry.class) {
            ConcurrentHashMap concurrentHashMap = keyManagerMap;
            if (concurrentHashMap.containsKey(typeUrl)) {
                keyManagerContainer = (KeyManagerContainer) concurrentHashMap.get(typeUrl);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + typeUrl);
            }
        }
        return keyManagerContainer;
    }

    public static Object getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
        return getPrimitiveInternal(str, ByteString.copyFrom(bArr, 0, bArr.length), Aead.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> P getPrimitiveInternal(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainerOrThrow = getKeyManagerContainerOrThrow(str);
        if (keyManagerContainerOrThrow.supportedPrimitives().contains(cls)) {
            KeyManagerImpl keyManager = keyManagerContainerOrThrow.getKeyManager(cls);
            KeyTypeManager<KeyProtoT> keyTypeManager = keyManager.keyTypeManager;
            try {
                MessageLite parseKey = keyTypeManager.parseKey(byteString);
                GenericDeclaration genericDeclaration = keyManager.primitiveClass;
                if (!Void.class.equals(genericDeclaration)) {
                    keyTypeManager.validateKey(parseKey);
                    return (P) keyTypeManager.getPrimitive(parseKey, genericDeclaration);
                }
                throw new GeneralSecurityException("Cannot create a primitive for Void");
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Failures parsing proto of type ".concat(keyTypeManager.clazz.getName()), e);
            }
        }
        StringBuilder sb = new StringBuilder("Primitive type ");
        sb.append(cls.getName());
        sb.append(" not supported by key manager of type ");
        sb.append(keyManagerContainerOrThrow.getImplementingClass());
        sb.append(", supported primitives: ");
        Set<Class<?>> supportedPrimitives = keyManagerContainerOrThrow.supportedPrimitives();
        StringBuilder sb2 = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : supportedPrimitives) {
            if (!z) {
                sb2.append(", ");
            }
            sb2.append(cls2.getCanonicalName());
            z = false;
        }
        sb.append(sb2.toString());
        throw new GeneralSecurityException(sb.toString());
    }

    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManagerImpl untypedKeyManager = getKeyManagerContainerOrThrow(keyTemplate.getTypeUrl()).getUntypedKeyManager();
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(final KeyTypeManager<KeyProtoT> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, manager.getClass(), newKeyAllowed);
            ConcurrentHashMap concurrentHashMap = keyManagerMap;
            if (!concurrentHashMap.containsKey(keyType)) {
                concurrentHashMap.put(keyType, new KeyManagerContainer() { // from class: com.google.crypto.tink.Registry.2
                    @Override // com.google.crypto.tink.Registry.KeyManagerContainer
                    public final Class<?> getImplementingClass() {
                        return KeyTypeManager.this.getClass();
                    }

                    @Override // com.google.crypto.tink.Registry.KeyManagerContainer
                    public final KeyManagerImpl getKeyManager(Class primitiveClass) throws GeneralSecurityException {
                        try {
                            return new KeyManagerImpl(KeyTypeManager.this, primitiveClass);
                        } catch (IllegalArgumentException e) {
                            throw new GeneralSecurityException("Primitive type not supported", e);
                        }
                    }

                    @Override // com.google.crypto.tink.Registry.KeyManagerContainer
                    public final KeyManagerImpl getUntypedKeyManager() {
                        KeyTypeManager keyTypeManager = KeyTypeManager.this;
                        return new KeyManagerImpl(keyTypeManager, keyTypeManager.firstPrimitiveClass);
                    }

                    @Override // com.google.crypto.tink.Registry.KeyManagerContainer
                    public final Set<Class<?>> supportedPrimitives() {
                        return KeyTypeManager.this.factories.keySet();
                    }
                });
                keyDeriverMap.put(keyType, new AnonymousClass4());
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(final PrimitiveWrapper<B, P> wrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            Class<P> primitiveClass = wrapper.getPrimitiveClass();
            ConcurrentHashMap concurrentHashMap = primitiveWrapperMap;
            if (concurrentHashMap.containsKey(primitiveClass)) {
                PrimitiveWrapper primitiveWrapper = (PrimitiveWrapper) concurrentHashMap.get(primitiveClass);
                if (!wrapper.getClass().equals(primitiveWrapper.getClass())) {
                    logger.warning("Attempted overwrite of a registered SetWrapper for type " + primitiveClass);
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", primitiveClass.getName(), primitiveWrapper.getClass().getName(), wrapper.getClass().getName()));
                }
            }
            concurrentHashMap.put(primitiveClass, wrapper);
        }
    }
}
