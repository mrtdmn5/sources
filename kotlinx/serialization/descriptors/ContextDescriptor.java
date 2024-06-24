package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ContextAware.kt */
/* loaded from: classes4.dex */
public final class ContextDescriptor implements SerialDescriptor {
    public final KClass<?> kClass;
    public final SerialDescriptor original;
    public final String serialName;

    public ContextDescriptor(SerialDescriptorImpl serialDescriptorImpl, KClass kClass) {
        this.original = serialDescriptorImpl;
        this.kClass = kClass;
        this.serialName = serialDescriptorImpl.serialName + '<' + kClass.getSimpleName() + '>';
    }

    public final boolean equals(Object obj) {
        ContextDescriptor contextDescriptor;
        if (obj instanceof ContextDescriptor) {
            contextDescriptor = (ContextDescriptor) obj;
        } else {
            contextDescriptor = null;
        }
        if (contextDescriptor == null || !Intrinsics.areEqual(this.original, contextDescriptor.original) || !Intrinsics.areEqual(contextDescriptor.kClass, this.kClass)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getElementAnnotations(int r2) {
        return this.original.getElementAnnotations(r2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int r2) {
        return this.original.getElementDescriptor(r2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.original.getElementIndex(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int r2) {
        return this.original.getElementName(r2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind getKind() {
        return this.original.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return this.serialName.hashCode() + (this.kClass.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int r2) {
        return this.original.isElementOptional(r2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return this.original.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return this.original.isNullable();
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
