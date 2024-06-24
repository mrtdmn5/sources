package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.ValuesMapImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes.dex */
public final class HeadersImpl extends ValuesMapImpl<String> implements Headers {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadersImpl(Map<String, ? extends List<String>> values) {
        super(values, true);
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public final String toString() {
        return "Headers " + entries();
    }
}
