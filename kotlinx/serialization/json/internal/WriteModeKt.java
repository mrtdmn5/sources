package kotlinx.serialization.json.internal;

import com.google.common.hash.AbstractHasher;
import io.ktor.http.ContentTypesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;

/* compiled from: WriteMode.kt */
/* loaded from: classes4.dex */
public final class WriteModeKt {
    public static final SerialDescriptor carrierDescriptor(SerialDescriptor serialDescriptor, AbstractHasher module) {
        SerialDescriptor serialDescriptor2;
        SerialDescriptor carrierDescriptor;
        KSerializer contextual;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (Intrinsics.areEqual(serialDescriptor.getKind(), SerialKind.CONTEXTUAL.INSTANCE)) {
            KClass<?> capturedKClass = ContextAwareKt.getCapturedKClass(serialDescriptor);
            if (capturedKClass != null && (contextual = module.getContextual(capturedKClass, EmptyList.INSTANCE)) != null) {
                serialDescriptor2 = contextual.getDescriptor();
            } else {
                serialDescriptor2 = null;
            }
            if (serialDescriptor2 != null && (carrierDescriptor = carrierDescriptor(serialDescriptor2, module)) != null) {
                return carrierDescriptor;
            }
            return serialDescriptor;
        }
        if (serialDescriptor.isInline()) {
            return carrierDescriptor(serialDescriptor.getElementDescriptor(0), module);
        }
        return serialDescriptor;
    }

    public static final WriteMode switchMode(SerialDescriptor desc, Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        SerialKind kind = desc.getKind();
        if (kind instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            return WriteMode.LIST;
        }
        if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            SerialDescriptor carrierDescriptor = carrierDescriptor(desc.getElementDescriptor(0), json.serializersModule);
            SerialKind kind2 = carrierDescriptor.getKind();
            if (!(kind2 instanceof PrimitiveKind) && !Intrinsics.areEqual(kind2, SerialKind.ENUM.INSTANCE)) {
                if (json.configuration.allowStructuredMapKeys) {
                    return WriteMode.LIST;
                }
                throw ContentTypesKt.InvalidKeyKindException(carrierDescriptor);
            }
            return WriteMode.MAP;
        }
        return WriteMode.OBJ;
    }
}
