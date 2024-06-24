package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && Intrinsics.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof KProperty)) {
            return false;
        }
        return obj.equals(compute());
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    public final String toString() {
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KProperty getReflected() {
        if (!this.syntheticJavaProperty) {
            return (KProperty) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int r14) {
        super(obj, cls, str, str2, (r14 & 1) == 1);
        this.syntheticJavaProperty = (r14 & 2) == 2;
    }
}
