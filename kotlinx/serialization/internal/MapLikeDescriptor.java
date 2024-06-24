package kotlinx.serialization.internal;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
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
public abstract class MapLikeDescriptor implements SerialDescriptor {
    public final int elementsCount = 2;
    public final SerialDescriptor keyDescriptor;
    public final String serialName;
    public final SerialDescriptor valueDescriptor;

    public MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.serialName = str;
        this.keyDescriptor = serialDescriptor;
        this.valueDescriptor = serialDescriptor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        if (Intrinsics.areEqual(this.serialName, mapLikeDescriptor.serialName) && Intrinsics.areEqual(this.keyDescriptor, mapLikeDescriptor.keyDescriptor) && Intrinsics.areEqual(this.valueDescriptor, mapLikeDescriptor.valueDescriptor)) {
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
        throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", "), this.serialName, " expects only non-negative indices").toString());
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
            int r32 = r3 % 2;
            if (r32 != 0) {
                if (r32 == 1) {
                    return this.valueDescriptor;
                }
                throw new IllegalStateException("Unreached".toString());
            }
            return this.keyDescriptor;
        }
        throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", "), this.serialName, " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid map index"));
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
        return StructureKind.MAP.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return this.valueDescriptor.hashCode() + ((this.keyDescriptor.hashCode() + (this.serialName.hashCode() * 31)) * 31);
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
        throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(SuggestionsAdapter$$ExternalSyntheticOutline0.m("Illegal index ", r3, ", "), this.serialName, " expects only non-negative indices").toString());
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
        return this.serialName + '(' + this.keyDescriptor + ", " + this.valueDescriptor + ')';
    }
}
