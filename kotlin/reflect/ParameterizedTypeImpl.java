package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
/* loaded from: classes.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, Type {
    public final Type ownerType;
    public final Class<?> rawType;
    public final Type[] typeArguments;

    public ParameterizedTypeImpl(Class cls, Type type, ArrayList arrayList) {
        this.rawType = cls;
        this.ownerType = type;
        this.typeArguments = (Type[]) arrayList.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.areEqual(this.rawType, parameterizedType.getRawType()) && Intrinsics.areEqual(this.ownerType, parameterizedType.getOwnerType())) {
                if (Arrays.equals(this.typeArguments, parameterizedType.getActualTypeArguments())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Class<?> cls = this.rawType;
        Type type = this.ownerType;
        if (type != null) {
            sb.append(TypesJVMKt.access$typeToString(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(TypesJVMKt.access$typeToString(cls));
        }
        Type[] typeArr = this.typeArguments;
        if (typeArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ArraysKt___ArraysKt.joinTo(typeArr, sb, ", ", "<", ">", -1, "...", ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final int hashCode() {
        int r1;
        int hashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        if (type != null) {
            r1 = type.hashCode();
        } else {
            r1 = 0;
        }
        return (hashCode ^ r1) ^ Arrays.hashCode(this.typeArguments);
    }

    public final String toString() {
        return getTypeName();
    }
}
