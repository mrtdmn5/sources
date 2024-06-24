package com.google.crypto.tink.shaded.protobuf;

import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final class UnsafeUtil {
    public static final long BYTE_ARRAY_BASE_OFFSET;
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
    public static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    public static final boolean IS_BIG_ENDIAN;
    public static final MemoryAccessor MEMORY_ACCESSOR;
    public static final Class<?> MEMORY_CLASS;
    public static final Unsafe UNSAFE;
    public static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());

    /* renamed from: com.google.crypto.tink.shaded.protobuf.UnsafeUtil$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
            return run2();
        }

        /* renamed from: run, reason: avoid collision after fix types in other method */
        public static Unsafe run2() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean getBoolean(long j, Object obj) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                if (UnsafeUtil.getByteBigEndian(j, obj) != 0) {
                    return true;
                }
                return false;
            }
            if (UnsafeUtil.getByteLittleEndian(j, obj) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final byte getByte(long j, Object obj) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(j, obj);
            }
            return UnsafeUtil.getByteLittleEndian(j, obj);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final double getDouble(long j, Object obj) {
            return Double.longBitsToDouble(getLong(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final float getFloat(long j, Object obj) {
            return Float.intBitsToFloat(getInt(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, z ? (byte) 1 : (byte) 0);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putByte(Object obj, long j, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putFloat(Object obj, long j, float f) {
            putInt(j, Float.floatToIntBits(f), obj);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean getBoolean(long j, Object obj) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                if (UnsafeUtil.getByteBigEndian(j, obj) != 0) {
                    return true;
                }
                return false;
            }
            if (UnsafeUtil.getByteLittleEndian(j, obj) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final byte getByte(long j, Object obj) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(j, obj);
            }
            return UnsafeUtil.getByteLittleEndian(j, obj);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final double getDouble(long j, Object obj) {
            return Double.longBitsToDouble(getLong(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final float getFloat(long j, Object obj) {
            return Float.intBitsToFloat(getInt(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, z ? (byte) 1 : (byte) 0);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putByte(Object obj, long j, byte b) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putDouble(Object obj, long j, double d) {
            putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putFloat(Object obj, long j, float f) {
            putInt(j, Float.floatToIntBits(f), obj);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final boolean getBoolean(long j, Object obj) {
            return this.unsafe.getBoolean(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final byte getByte(long j, Object obj) {
            return this.unsafe.getByte(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final double getDouble(long j, Object obj) {
            return this.unsafe.getDouble(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final float getFloat(long j, Object obj) {
            return this.unsafe.getFloat(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putBoolean(Object obj, long j, boolean z) {
            this.unsafe.putBoolean(obj, j, z);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putByte(Object obj, long j, byte b) {
            this.unsafe.putByte(obj, j, b);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putDouble(Object obj, long j, double d) {
            this.unsafe.putDouble(obj, j, d);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public final void putFloat(Object obj, long j, float f) {
            this.unsafe.putFloat(obj, j, f);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class MemoryAccessor {
        public final Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract boolean getBoolean(long j, Object obj);

        public abstract byte getByte(long j, Object obj);

        public abstract double getDouble(long j, Object obj);

        public abstract float getFloat(long j, Object obj);

        public final int getInt(long j, Object obj) {
            return this.unsafe.getInt(obj, j);
        }

        public final long getLong(long j, Object obj) {
            return this.unsafe.getLong(obj, j);
        }

        public final Object getObject(long j, Object obj) {
            return this.unsafe.getObject(obj, j);
        }

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j, boolean z);

        public abstract void putByte(Object obj, long j, byte b);

        public abstract void putDouble(Object obj, long j, double d);

        public abstract void putFloat(Object obj, long j, float f);

        public final void putInt(long j, int r4, Object obj) {
            this.unsafe.putInt(obj, j, r4);
        }

        public final void putLong(Object obj, long j, long j2) {
            this.unsafe.putLong(obj, j, j2);
        }

        public final void putObject(long j, Object obj, Object obj2) {
            this.unsafe.putObject(obj, j, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.UnsafeUtil.<clinit>():void");
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void arrayIndexScale(Class cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
    }

    public static Field bufferAddressField() {
        Field field;
        Field field2;
        if (Android.isOnAndroidDevice()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField(WatchSettingsFragment.addressBundleKey);
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean getBoolean(long j, Object obj) {
        return MEMORY_ACCESSOR.getBoolean(j, obj);
    }

    public static byte getByte(byte[] bArr, long j) {
        return MEMORY_ACCESSOR.getByte(BYTE_ARRAY_BASE_OFFSET + j, bArr);
    }

    public static byte getByteBigEndian(long j, Object obj) {
        return (byte) ((getInt((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static byte getByteLittleEndian(long j, Object obj) {
        return (byte) ((getInt((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255);
    }

    public static double getDouble(long j, Object obj) {
        return MEMORY_ACCESSOR.getDouble(j, obj);
    }

    public static float getFloat(long j, Object obj) {
        return MEMORY_ACCESSOR.getFloat(j, obj);
    }

    public static int getInt(long j, Object obj) {
        return MEMORY_ACCESSOR.getInt(j, obj);
    }

    public static long getLong(long j, Object obj) {
        return MEMORY_ACCESSOR.getLong(j, obj);
    }

    public static Object getObject(long j, Object obj) {
        return MEMORY_ACCESSOR.getObject(j, obj);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void putBoolean(Object obj, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(obj, j, z);
    }

    public static void putByte(byte[] bArr, long j, byte b) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j, b);
    }

    public static void putByteBigEndian(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int r2 = getInt(j2, obj);
        int r5 = ((~((int) j)) & 3) << 3;
        putInt(j2, ((255 & b) << r5) | (r2 & (~(255 << r5))), obj);
    }

    public static void putByteLittleEndian(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int r5 = (((int) j) & 3) << 3;
        putInt(j2, ((255 & b) << r5) | (getInt(j2, obj) & (~(255 << r5))), obj);
    }

    public static void putDouble(Object obj, long j, double d) {
        MEMORY_ACCESSOR.putDouble(obj, j, d);
    }

    public static void putFloat(Object obj, long j, float f) {
        MEMORY_ACCESSOR.putFloat(obj, j, f);
    }

    public static void putInt(long j, int r3, Object obj) {
        MEMORY_ACCESSOR.putInt(j, r3, obj);
    }

    public static void putLong(Object obj, long j, long j2) {
        MEMORY_ACCESSOR.putLong(obj, j, j2);
    }

    public static void putObject(long j, Object obj, Object obj2) {
        MEMORY_ACCESSOR.putObject(j, obj, obj2);
    }
}
