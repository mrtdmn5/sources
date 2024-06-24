package retrofit2;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class Utils {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    /* loaded from: classes4.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = type;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof GenericArrayType) && Utils.equals(this, (GenericArrayType) obj)) {
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
            return Utils.typeToString(this.componentType) + "[]";
        }
    }

    /* loaded from: classes4.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            boolean z;
            if (type2 instanceof Class) {
                if (type == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                Utils.checkNotPrimitive(type3);
            }
            this.ownerType = type;
            this.rawType = type2;
            this.typeArguments = (Type[]) typeArr.clone();
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof ParameterizedType) && Utils.equals(this, (ParameterizedType) obj)) {
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
            int length = typeArr.length;
            Type type = this.rawType;
            if (length == 0) {
                return Utils.typeToString(type);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Utils.typeToString(type));
            sb.append("<");
            sb.append(Utils.typeToString(typeArr[0]));
            for (int r4 = 1; r4 < typeArr.length; r4++) {
                sb.append(", ");
                sb.append(Utils.typeToString(typeArr[r4]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class WildcardTypeImpl implements WildcardType {
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        Type type = typeArr2[0];
                        type.getClass();
                        Utils.checkNotPrimitive(type);
                        if (typeArr[0] == Object.class) {
                            this.lowerBound = typeArr2[0];
                            this.upperBound = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    Type type2 = typeArr[0];
                    type2.getClass();
                    Utils.checkNotPrimitive(type2);
                    this.lowerBound = null;
                    this.upperBound = typeArr[0];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof WildcardType) && Utils.equals(this, (WildcardType) obj)) {
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
            return Utils.EMPTY_TYPE_ARRAY;
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
                return "? super " + Utils.typeToString(type);
            }
            Type type2 = this.upperBound;
            if (type2 == Object.class) {
                return "?";
            }
            return "? extends " + Utils.typeToString(type2);
        }
    }

    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if ((ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
            return true;
        }
        return false;
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

    public static Type getParameterUpperBound(int r4, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (r4 >= 0 && r4 < actualTypeArguments.length) {
            Type type = actualTypeArguments[r4];
            if (type instanceof WildcardType) {
                return ((WildcardType) type).getUpperBounds()[0];
            }
            return type;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index ", r4, " not in range [0,");
        m.append(actualTypeArguments.length);
        m.append(") for ");
        m.append(parameterizedType);
        throw new IllegalArgumentException(m.toString());
    }

    public static Class<?> getRawType(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type getSupertype(Type type, Class cls) {
        if (Map.class.isAssignableFrom(cls)) {
            return resolve(type, cls, getGenericSupertype(type, cls, Map.class));
        }
        throw new IllegalArgumentException();
    }

    public static boolean hasUnresolvableType(Type type) {
        String name;
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (hasUnresolvableType(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return hasUnresolvableType(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        if (type == null) {
            name = Constants.NULL_VERSION_ID;
        } else {
            name = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }

    public static boolean isAnnotationPresent(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static IllegalArgumentException methodError(Method method, Exception exc, String str, Object... objArr) {
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(String.format(str, objArr), "\n    for method ");
        m.append(method.getDeclaringClass().getSimpleName());
        m.append(InstructionFileId.DOT);
        m.append(method.getName());
        return new IllegalArgumentException(m.toString(), exc);
    }

    public static IllegalArgumentException parameterError(Method method, int r2, String str, Object... objArr) {
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, " (parameter #");
        m.append(r2 + 1);
        m.append(")");
        return methodError(method, null, m.toString(), objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:            r10 = r10;     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[LOOP:0: B:1:0x0000->B:18:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type resolve(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.Utils.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static void throwIfFatal(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (!(th instanceof LinkageError)) {
                    return;
                } else {
                    throw ((LinkageError) th);
                }
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }

    public static String typeToString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public static IllegalArgumentException parameterError(Method method, Exception exc, int r3, String str, Object... objArr) {
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, " (parameter #");
        m.append(r3 + 1);
        m.append(")");
        return methodError(method, exc, m.toString(), objArr);
    }
}
