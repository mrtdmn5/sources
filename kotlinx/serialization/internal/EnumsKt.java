package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Enums.kt */
/* loaded from: classes4.dex */
public final class EnumsKt {
    public static final EnumSerializer createSimpleEnumSerializer(String str, Enum[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(str, values);
    }
}
