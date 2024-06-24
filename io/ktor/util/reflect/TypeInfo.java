package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Type.kt */
/* loaded from: classes3.dex */
public final class TypeInfo {
    public final KType kotlinType;
    public final Type reifiedType;
    public final KClass<?> type;

    public TypeInfo(Type type, KClass kClass, KType kType) {
        this.type = kClass;
        this.reifiedType = type;
        this.kotlinType = kType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeInfo)) {
            return false;
        }
        TypeInfo typeInfo = (TypeInfo) obj;
        if (Intrinsics.areEqual(this.type, typeInfo.type) && Intrinsics.areEqual(this.reifiedType, typeInfo.reifiedType) && Intrinsics.areEqual(this.kotlinType, typeInfo.kotlinType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.reifiedType.hashCode() + (this.type.hashCode() * 31)) * 31;
        KType kType = this.kotlinType;
        if (kType == null) {
            hashCode = 0;
        } else {
            hashCode = kType.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "TypeInfo(type=" + this.type + ", reifiedType=" + this.reifiedType + ", kotlinType=" + this.kotlinType + ')';
    }
}
