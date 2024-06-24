package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes3.dex */
public final class HeadersImpl extends StringValuesImpl implements Headers {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadersImpl(Map<String, ? extends List<String>> values) {
        super(values);
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public final String toString() {
        return "Headers " + entries();
    }
}
