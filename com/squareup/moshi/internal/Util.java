package com.squareup.moshi.internal;

import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Util {
    public static final Set<Annotation> NO_ANNOTATIONS = Collections.emptySet();
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    /* loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = Util.canonicalize(type);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof GenericArrayType) && Types.equals(this, (GenericArrayType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final String toString() {
            return Util.typeToString(this.componentType) + "[]";
        }
    }

    /* loaded from: classes3.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type canonicalize;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || Types.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                canonicalize = null;
            } else {
                canonicalize = Util.canonicalize(type);
            }
            this.ownerType = canonicalize;
            this.rawType = Util.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int r4 = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (r4 < typeArr2.length) {
                    Type type3 = typeArr2[r4];
                    type3.getClass();
                    Util.checkNotPrimitive(type3);
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[r4] = Util.canonicalize(typeArr3[r4]);
                    r4++;
                } else {
                    return;
                }
            }
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof ParameterizedType) && Types.equals(this, (ParameterizedType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.rawType;
        }

        public final int hashCode() {
            int r1;
            int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Set<Annotation> set = Util.NO_ANNOTATIONS;
            Type type = this.ownerType;
            if (type != null) {
                r1 = type.hashCode();
            } else {
                r1 = 0;
            }
            return hashCode ^ r1;
        }

        public final String toString() {
            Type[] typeArr = this.typeArguments;
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Util.typeToString(this.rawType));
            if (typeArr.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(Util.typeToString(typeArr[0]));
            for (int r3 = 1; r3 < typeArr.length; r3++) {
                sb.append(", ");
                sb.append(Util.typeToString(typeArr[r3]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class WildcardTypeImpl implements WildcardType {
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        Type type = typeArr2[0];
                        type.getClass();
                        Util.checkNotPrimitive(type);
                        if (typeArr[0] == Object.class) {
                            this.lowerBound = Util.canonicalize(typeArr2[0]);
                            this.upperBound = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    Type type2 = typeArr[0];
                    type2.getClass();
                    Util.checkNotPrimitive(type2);
                    this.lowerBound = null;
                    this.upperBound = Util.canonicalize(typeArr[0]);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof WildcardType) && Types.equals(this, (WildcardType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type != null) {
                return new Type[]{type};
            }
            return Util.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public final int hashCode() {
            int r0;
            Type type = this.lowerBound;
            if (type != null) {
                r0 = type.hashCode() + 31;
            } else {
                r0 = 1;
            }
            return r0 ^ (this.upperBound.hashCode() + 31);
        }

        public final String toString() {
            Type type = this.lowerBound;
            if (type != null) {
                return "? super " + Util.typeToString(type);
            }
            Type type2 = this.upperBound;
            if (type2 == Object.class) {
                return "?";
            }
            return "? extends " + Util.typeToString(type2);
        }
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
            }
            return cls;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type instanceof GenericArrayTypeImpl) {
                return type;
            }
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (type instanceof WildcardTypeImpl) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int r1 = 0; r1 < length; r1++) {
                Class<?> cls3 = interfaces[r1];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[r1];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[r1], interfaces[r1], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static boolean isPlatformType(Class<?> cls) {
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("androidx.") && !name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("kotlin.") && !name.startsWith("scala.")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:            r10 = r10;     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[LOOP:0: B:1:0x0000->B:9:0x0043, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type resolve(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static void rethrowCause(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (!(targetException instanceof RuntimeException)) {
            if (targetException instanceof Error) {
                throw ((Error) targetException);
            }
            throw new RuntimeException(targetException);
        }
        throw ((RuntimeException) targetException);
    }

    public static String typeAnnotatedWithAnnotations(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String typeToString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
