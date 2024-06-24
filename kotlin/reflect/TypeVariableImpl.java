package kotlin.reflect;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
/* loaded from: classes.dex */
public final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, Type {
    public final KTypeParameter typeParameter;

    public TypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof TypeVariable) && Intrinsics.areEqual(getName(), ((TypeVariable) obj).getName())) {
            getGenericDeclaration();
            throw null;
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        List<KType> upperBounds = this.typeParameter.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVMKt.computeJavaType((KType) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(ConstraintSet$$ExternalSyntheticOutline0.m("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.typeParameter));
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return this.typeParameter.getName();
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return getName();
    }

    public final int hashCode() {
        getName().hashCode();
        getGenericDeclaration();
        throw null;
    }

    public final String toString() {
        return getName();
    }
}
