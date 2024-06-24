package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: PluginGeneratedSerialDescriptor.kt */
/* loaded from: classes4.dex */
public final class PluginGeneratedSerialDescriptorKt {
    public static final int hashCodeImpl(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        boolean z;
        boolean z2;
        int r8;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int hashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        int elementsCount = serialDescriptor.getElementsCount();
        int r2 = 1;
        while (true) {
            int r3 = 0;
            if (elementsCount > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            int r5 = elementsCount - 1;
            int r22 = r2 * 31;
            String serialName = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount).getSerialName();
            if (serialName != null) {
                r3 = serialName.hashCode();
            }
            r2 = r22 + r3;
            elementsCount = r5;
        }
        int elementsCount2 = serialDescriptor.getElementsCount();
        int r4 = 1;
        while (true) {
            if (elementsCount2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int r6 = elementsCount2 - 1;
                int r42 = r4 * 31;
                SerialKind kind = serialDescriptor.getElementDescriptor(serialDescriptor.getElementsCount() - elementsCount2).getKind();
                if (kind != null) {
                    r8 = kind.hashCode();
                } else {
                    r8 = 0;
                }
                r4 = r42 + r8;
                elementsCount2 = r6;
            } else {
                return (((hashCode * 31) + r2) * 31) + r4;
            }
        }
    }
}
