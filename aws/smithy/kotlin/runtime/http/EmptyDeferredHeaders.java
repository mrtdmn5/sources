package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.ValuesMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;

/* compiled from: DeferredHeaders.kt */
/* loaded from: classes.dex */
public final class EmptyDeferredHeaders implements DeferredHeaders {
    public static final EmptyDeferredHeaders INSTANCE = new EmptyDeferredHeaders();

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<Map.Entry<String, List<Deferred<? extends String>>>> entries() {
        return EmptySet.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final void forEach(Function2<? super String, ? super List<? extends Deferred<? extends String>>, Unit> function2) {
        ValuesMap.DefaultImpls.forEach(this, function2);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final List<Deferred<? extends String>> getAll(String str) {
        return EmptyList.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<String> names() {
        return EmptySet.INSTANCE;
    }
}
