package kotlinx.serialization.descriptors;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.PrimitivesKt;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes4.dex */
public final class SerialDescriptorsKt {
    public static final PrimitiveSerialDescriptor PrimitiveSerialDescriptor(String str, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            Iterator<KClass<? extends Object>> it = PrimitivesKt.BUILTIN_SERIALIZERS.keySet().iterator();
            while (it.hasNext()) {
                String simpleName = it.next().getSimpleName();
                Intrinsics.checkNotNull(simpleName);
                String capitalize = PrimitivesKt.capitalize(simpleName);
                if (StringsKt__StringsJVMKt.equals(str, "kotlin." + capitalize) || StringsKt__StringsJVMKt.equals(str, capitalize)) {
                    StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exist ");
                    m.append(PrimitivesKt.capitalize(capitalize));
                    m.append("Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                    throw new IllegalArgumentException(StringsKt__IndentKt.trimIndent(m.toString()));
                }
            }
            return new PrimitiveSerialDescriptor(str, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptorImpl buildClassSerialDescriptor(String str, SerialDescriptor[] serialDescriptorArr, Function1 builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            builderAction.invoke(classSerialDescriptorBuilder);
            return new SerialDescriptorImpl(str, StructureKind.CLASS.INSTANCE, classSerialDescriptorBuilder.elementNames.size(), ArraysKt___ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptorImpl buildSerialDescriptor(String serialName, SerialKind kind, SerialDescriptor[] serialDescriptorArr, Function1 builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!StringsKt__StringsJVMKt.isBlank(serialName)) {
            if (!Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
                builder.invoke(classSerialDescriptorBuilder);
                return new SerialDescriptorImpl(serialName, kind, classSerialDescriptorBuilder.elementNames.size(), ArraysKt___ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
            }
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }
}
