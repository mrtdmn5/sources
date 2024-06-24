package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
/* loaded from: classes.dex */
public final class WildcardTypeImpl implements WildcardType, Type {
    public static final WildcardTypeImpl STAR = new WildcardTypeImpl(null, null);
    public final Type lowerBound;
    public final Type upperBound;

    public WildcardTypeImpl(Type type, Type type2) {
        this.upperBound = type;
        this.lowerBound = type2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.lowerBound;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        Type type = this.lowerBound;
        if (type != null) {
            return "? super " + TypesJVMKt.access$typeToString(type);
        }
        Type type2 = this.upperBound;
        if (type2 != null && !Intrinsics.areEqual(type2, Object.class)) {
            return "? extends " + TypesJVMKt.access$typeToString(type2);
        }
        return "?";
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.upperBound;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public final int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
