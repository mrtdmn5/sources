package kotlinx.serialization.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.NullableSerializer;

/* compiled from: BuiltinSerializers.kt */
/* loaded from: classes4.dex */
public final class BuiltinSerializersKt {
    public static final <T> KSerializer<T> getNullable(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        if (!kSerializer.getDescriptor().isNullable()) {
            return new NullableSerializer(kSerializer);
        }
        return kSerializer;
    }
}
