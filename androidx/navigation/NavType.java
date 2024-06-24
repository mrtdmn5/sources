package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class NavType<T> {
    public final boolean mNullableAllowed;
    public static final AnonymousClass1 IntType = new AnonymousClass1();
    public static final AnonymousClass2 ReferenceType = new NavType<Integer>() { // from class: androidx.navigation.NavType.2
        @Override // androidx.navigation.NavType
        public final Integer get(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "reference";
        }

        @Override // androidx.navigation.NavType
        public final Integer parseValue(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    };
    public static final AnonymousClass3 IntArrayType = new NavType<int[]>() { // from class: androidx.navigation.NavType.3
        @Override // androidx.navigation.NavType
        public final int[] get(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "integer[]";
        }

        @Override // androidx.navigation.NavType
        public final int[] parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, int[] r3) {
            bundle.putIntArray(str, r3);
        }
    };
    public static final AnonymousClass4 LongType = new AnonymousClass4();
    public static final AnonymousClass5 LongArrayType = new NavType<long[]>() { // from class: androidx.navigation.NavType.5
        @Override // androidx.navigation.NavType
        public final long[] get(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "long[]";
        }

        @Override // androidx.navigation.NavType
        public final long[] parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    };
    public static final AnonymousClass6 FloatType = new AnonymousClass6();
    public static final AnonymousClass7 FloatArrayType = new NavType<float[]>() { // from class: androidx.navigation.NavType.7
        @Override // androidx.navigation.NavType
        public final float[] get(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "float[]";
        }

        @Override // androidx.navigation.NavType
        public final float[] parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    };
    public static final AnonymousClass8 BoolType = new AnonymousClass8();
    public static final AnonymousClass9 BoolArrayType = new NavType<boolean[]>() { // from class: androidx.navigation.NavType.9
        @Override // androidx.navigation.NavType
        public final boolean[] get(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "boolean[]";
        }

        @Override // androidx.navigation.NavType
        public final boolean[] parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    };
    public static final AnonymousClass10 StringType = new NavType<String>() { // from class: androidx.navigation.NavType.10
        @Override // androidx.navigation.NavType
        public final String get(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "string";
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }

        @Override // androidx.navigation.NavType
        public final String parseValue(String str) {
            return str;
        }
    };
    public static final AnonymousClass11 StringArrayType = new NavType<String[]>() { // from class: androidx.navigation.NavType.11
        @Override // androidx.navigation.NavType
        public final String[] get(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "string[]";
        }

        @Override // androidx.navigation.NavType
        public final String[] parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    };

    /* renamed from: androidx.navigation.NavType$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends NavType<Integer> {
        public AnonymousClass1() {
            super(false);
        }

        @Override // androidx.navigation.NavType
        public final Integer get(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "integer";
        }

        @Override // androidx.navigation.NavType
        public final Integer parseValue(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* renamed from: androidx.navigation.NavType$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends NavType<Long> {
        public AnonymousClass4() {
            super(false);
        }

        @Override // androidx.navigation.NavType
        public final Long get(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "long";
        }

        @Override // androidx.navigation.NavType
        public final Long parseValue(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    /* renamed from: androidx.navigation.NavType$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 extends NavType<Float> {
        public AnonymousClass6() {
            super(false);
        }

        @Override // androidx.navigation.NavType
        public final Float get(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "float";
        }

        @Override // androidx.navigation.NavType
        public final Float parseValue(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    /* renamed from: androidx.navigation.NavType$8, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass8 extends NavType<Boolean> {
        public AnonymousClass8() {
            super(false);
        }

        @Override // androidx.navigation.NavType
        public final Boolean get(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return "boolean";
        }

        @Override // androidx.navigation.NavType
        public final Boolean parseValue(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        public final Class<D[]> mArrayType;

        public ParcelableArrayType(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable.");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ParcelableArrayType.class == obj.getClass()) {
                return this.mArrayType.equals(((ParcelableArrayType) obj).mArrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.mArrayType.getName();
        }

        public final int hashCode() {
            return this.mArrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.mArrayType.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class ParcelableType<D> extends NavType<D> {
        public final Class<D> mType;

        public ParcelableType(Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
            }
            this.mType = cls;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ParcelableType.class == obj.getClass()) {
                return this.mType.equals(((ParcelableType) obj).mType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        public final D get(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.mType.getName();
        }

        public final int hashCode() {
            return this.mType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final D parseValue(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, D d) {
            this.mType.cast(d);
            if (d != null && !(d instanceof Parcelable)) {
                if (d instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) d);
                    return;
                }
                return;
            }
            bundle.putParcelable(str, (Parcelable) d);
        }
    }

    /* loaded from: classes.dex */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        public final Class<D[]> mArrayType;

        public SerializableArrayType(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SerializableArrayType.class == obj.getClass()) {
                return this.mArrayType.equals(((SerializableArrayType) obj).mArrayType);
            }
            return false;
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.mArrayType.getName();
        }

        public final int hashCode() {
            return this.mArrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            ?? r4 = (Serializable[]) obj;
            this.mArrayType.cast(r4);
            bundle.putSerializable(str, r4);
        }
    }

    /* loaded from: classes.dex */
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        public final Class<D> mType;

        public SerializableType(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                if (!cls.isEnum()) {
                    this.mType = cls;
                    return;
                }
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return this.mType.equals(((SerializableType) obj).mType);
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.mType.getName();
        }

        public final int hashCode() {
            return this.mType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.mType.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public SerializableType(Class cls, int r3) {
            super(false);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    public NavType(boolean z) {
        this.mNullableAllowed = z;
    }

    public abstract T get(Bundle bundle, String str);

    public abstract String getName();

    public abstract T parseValue(String str);

    public abstract void put(Bundle bundle, String str, T t);

    public final String toString() {
        return getName();
    }

    /* loaded from: classes.dex */
    public static final class EnumType<D extends Enum> extends SerializableType<D> {
        public final Class<D> mType;

        public EnumType(Class<D> cls) {
            super(cls, 0);
            if (cls.isEnum()) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public final String getName() {
            return this.mType.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public final D parseValue(String str) {
            Class<D> cls = this.mType;
            for (D d : cls.getEnumConstants()) {
                if (d.name().equals(str)) {
                    return d;
                }
            }
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Enum value ", str, " not found for type ");
            m.append(cls.getName());
            m.append(InstructionFileId.DOT);
            throw new IllegalArgumentException(m.toString());
        }
    }
}
