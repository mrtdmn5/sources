package io.ktor.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes3.dex */
public final class StringValuesKt {
    public static final void appendAll(StringValuesBuilderImpl stringValuesBuilderImpl, StringValuesBuilder builder) {
        Intrinsics.checkNotNullParameter(stringValuesBuilderImpl, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterator<T> it = builder.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stringValuesBuilderImpl.appendAll((String) entry.getKey(), (List) entry.getValue());
        }
    }
}
