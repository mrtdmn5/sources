package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class VersionedParcel {
    public final ArrayMap<String, Class> mParcelizerCache;
    public final ArrayMap<String, Method> mReadCache;
    public final ArrayMap<String, Method> mWriteCache;

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    public abstract VersionedParcelParcel createSubParcel();

    public final Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        String name = cls.getName();
        ArrayMap<String, Class> arrayMap = this.mParcelizerCache;
        Class orDefault = arrayMap.getOrDefault(name, null);
        if (orDefault == null) {
            Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            arrayMap.put(cls.getName(), cls2);
            return cls2;
        }
        return orDefault;
    }

    public final Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        ArrayMap<String, Method> arrayMap = this.mReadCache;
        Method orDefault = arrayMap.getOrDefault(str, null);
        if (orDefault == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            arrayMap.put(str, declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ArrayMap<String, Method> arrayMap = this.mWriteCache;
        Method orDefault = arrayMap.getOrDefault(name, null);
        if (orDefault == null) {
            Class findParcelClass = findParcelClass(cls);
            System.currentTimeMillis();
            Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
            arrayMap.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    public abstract boolean readBoolean();

    public abstract byte[] readByteArray();

    public abstract CharSequence readCharSequence();

    public abstract boolean readField(int r1);

    public abstract int readInt();

    public final int readInt(int r1, int r2) {
        return !readField(r2) ? r1 : readInt();
    }

    public abstract <T extends Parcelable> T readParcelable();

    public abstract String readString();

    public final <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (T) getReadMethod(readString).invoke(null, createSubParcel());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void setOutputField(int r1);

    public abstract void writeBoolean(boolean z);

    public abstract void writeByteArray(byte[] bArr);

    public abstract void writeCharSequence(CharSequence charSequence);

    public abstract void writeInt(int r1);

    public final void writeInt(int r1, int r2) {
        setOutputField(r2);
        writeInt(r1);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public abstract void writeString(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public final void writeVersionedParcelable$1(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
            VersionedParcelParcel createSubParcel = createSubParcel();
            try {
                getWriteMethod(versionedParcelable.getClass()).invoke(null, versionedParcelable, createSubParcel);
                createSubParcel.closeField();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
