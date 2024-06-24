package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import aws.smithy.kotlin.runtime.util.ValuesMapBuilder;
import aws.smithy.kotlin.runtime.util.ValuesMapKt;
import java.util.LinkedHashMap;
import kotlinx.coroutines.Deferred;

/* compiled from: DeferredHeaders.kt */
/* loaded from: classes.dex */
public final class DeferredHeadersBuilder extends ValuesMapBuilder<Deferred<? extends String>> implements CanDeepCopy<DeferredHeadersBuilder> {
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public final DeferredHeadersBuilder deepCopy() {
        LinkedHashMap deepCopy = ValuesMapKt.deepCopy(this.values);
        DeferredHeadersBuilder deferredHeadersBuilder = new DeferredHeadersBuilder();
        deferredHeadersBuilder.values.putAll(deepCopy);
        return deferredHeadersBuilder;
    }
}
