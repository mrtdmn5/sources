package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.SerializersModuleCollector$contextual$1;

/* compiled from: PolymorphismValidator.kt */
/* loaded from: classes4.dex */
public final class PolymorphismValidator {
    public final String discriminator;
    public final boolean useArrayPolymorphism;

    public PolymorphismValidator(boolean z, String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.useArrayPolymorphism = z;
        this.discriminator = discriminator;
    }

    public final void contextual(KClass kClass, SerializersModuleCollector$contextual$1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    public final <Base, Sub extends Base> void polymorphic(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer) {
        SerialDescriptor descriptor = kSerializer.getDescriptor();
        SerialKind kind = descriptor.getKind();
        if (!(kind instanceof PolymorphicKind) && !Intrinsics.areEqual(kind, SerialKind.CONTEXTUAL.INSTANCE)) {
            boolean z = this.useArrayPolymorphism;
            if (z || (!Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) && !Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE) && !(kind instanceof PrimitiveKind) && !(kind instanceof SerialKind.ENUM))) {
                if (!z) {
                    int elementsCount = descriptor.getElementsCount();
                    for (int r0 = 0; r0 < elementsCount; r0++) {
                        String elementName = descriptor.getElementName(r0);
                        if (Intrinsics.areEqual(elementName, this.discriminator)) {
                            throw new IllegalArgumentException("Polymorphic serializer for " + kClass2 + " has property '" + elementName + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                        }
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Serializer for " + kClass2.getSimpleName() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
        throw new IllegalArgumentException("Serializer for " + kClass2.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
    }
}
