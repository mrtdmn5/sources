package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

/* compiled from: ContextAware.kt */
/* loaded from: classes4.dex */
public final class ContextAwareKt {
    public static final KClass<?> getCapturedKClass(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).kClass;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return getCapturedKClass(((SerialDescriptorForNullable) serialDescriptor).original);
        }
        return null;
    }
}
