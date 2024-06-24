package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: InlineClassDescriptor.kt */
/* loaded from: classes4.dex */
public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {
    public final boolean isInline;

    public InlineClassDescriptor(String str, GeneratedSerializer<?> generatedSerializer) {
        super(str, generatedSerializer, 1);
        this.isInline = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineClassDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(this.serialName, serialDescriptor.getSerialName())) {
                InlineClassDescriptor inlineClassDescriptor = (InlineClassDescriptor) obj;
                if (inlineClassDescriptor.isInline && Arrays.equals((SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue(), (SerialDescriptor[]) inlineClassDescriptor.typeParameterDescriptors$delegate.getValue())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int elementsCount = serialDescriptor.getElementsCount();
                    int r3 = this.elementsCount;
                    if (r3 == elementsCount) {
                        for (int r7 = 0; r7 < r3; r7++) {
                            if (Intrinsics.areEqual(getElementDescriptor(r7).getSerialName(), serialDescriptor.getElementDescriptor(r7).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(r7).getKind(), serialDescriptor.getElementDescriptor(r7).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return this.isInline;
    }
}
