package kotlinx.serialization.internal;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: CollectionDescriptors.kt */
/* loaded from: classes4.dex */
public abstract class ListLikeDescriptor implements SerialDescriptor {
    public final SerialDescriptor elementDescriptor;
    public final int elementsCount = 1;

    public ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.elementDescriptor = serialDescriptor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        if (Intrinsics.areEqual(this.elementDescriptor, listLikeDescriptor.elementDescriptor) && Intrinsics.areEqual(getSerialName(), listLikeDescriptor.getSerialName())) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getAnnotations() {
        return EmptyList.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List<Annotation> getElementAnnotations(int r3) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return EmptyList.INSTANCE;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", ");
        m.append(getSerialName());
        m.append(" expects only non-negative indices");
        throw new IllegalArgumentException(m.toString().toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int r3) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.elementDescriptor;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", ");
        m.append(getSerialName());
        m.append(" expects only non-negative indices");
        throw new IllegalArgumentException(m.toString().toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid list index"));
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int r1) {
        return String.valueOf(r1);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind getKind() {
        return StructureKind.LIST.INSTANCE;
    }

    public final int hashCode() {
        return getSerialName().hashCode() + (this.elementDescriptor.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int r3) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", ");
        m.append(getSerialName());
        m.append(" expects only non-negative indices");
        throw new IllegalArgumentException(m.toString().toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return false;
    }

    public final String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }
}
