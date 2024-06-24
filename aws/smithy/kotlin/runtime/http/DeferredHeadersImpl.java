package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.ValuesMapImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* compiled from: DeferredHeaders.kt */
/* loaded from: classes.dex */
public final class DeferredHeadersImpl extends ValuesMapImpl<Deferred<? extends String>> implements DeferredHeaders {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredHeadersImpl(Map<String, ? extends List<? extends Deferred<String>>> values) {
        super(values, true);
        Intrinsics.checkNotNullParameter(values, "values");
    }
}
