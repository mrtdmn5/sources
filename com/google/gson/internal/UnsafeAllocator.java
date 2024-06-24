package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE;

    /* renamed from: com.google.gson.internal.UnsafeAllocator$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 extends UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public final <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    static {
        UnsafeAllocator anonymousClass4;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            anonymousClass4 = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                @Override // com.google.gson.internal.UnsafeAllocator
                public final <T> T newInstance(Class<T> cls2) throws Exception {
                    UnsafeAllocator.access$000(cls2);
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    anonymousClass4 = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public final <T> T newInstance(Class<T> cls2) throws Exception {
                            UnsafeAllocator.access$000(cls2);
                            return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                        }
                    };
                } catch (Exception unused2) {
                    anonymousClass4 = new AnonymousClass4();
                }
            } catch (Exception unused3) {
                final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                anonymousClass4 = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                    @Override // com.google.gson.internal.UnsafeAllocator
                    public final <T> T newInstance(Class<T> cls2) throws Exception {
                        UnsafeAllocator.access$000(cls2);
                        return (T) declaredMethod3.invoke(null, cls2, Object.class);
                    }
                };
            }
        }
        INSTANCE = anonymousClass4;
    }

    public static void access$000(Class cls) {
        String checkInstantiable = ConstructorConstructor.checkInstantiable(cls);
        if (checkInstantiable == null) {
        } else {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(checkInstantiable));
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
