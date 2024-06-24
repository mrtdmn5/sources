package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: NullableSerializer.kt */
/* loaded from: classes4.dex */
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {
    public final SerialDescriptor original;
    public final String serialName;
    public final Set<String> serialNames;

    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        this.serialName = original.getSerialName() + '?';
        this.serialNames = Platform_commonKt.cachedSerialNames(original);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerialDescriptorForNullable)) {
            return false;
        }
        if (Intrinsics.areEqual(this.original, ((SerialDescriptorForNullable) obj).original)) {
            return true;
        }
        return false;
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

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set<String> getSerialNames() {
        return this.serialNames;
    }

    public final int hashCode() {
        return this.original.hashCode() * 31;
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
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.original);
        sb.append('?');
        return sb.toString();
    }
}
