package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
/* loaded from: classes.dex */
public final class GenericArrayTypeImpl implements GenericArrayType, Type {
    public final Type elementType;

    public GenericArrayTypeImpl(Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.elementType = elementType;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            if (Intrinsics.areEqual(this.elementType, ((GenericArrayType) obj).getGenericComponentType())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return TypesJVMKt.access$typeToString(this.elementType) + "[]";
    }

    public final int hashCode() {
        return this.elementType.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
