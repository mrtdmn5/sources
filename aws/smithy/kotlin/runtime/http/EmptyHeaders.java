package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.ValuesMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;

/* compiled from: Headers.kt */
/* loaded from: classes.dex */
public final class EmptyHeaders implements Headers {
    public static final EmptyHeaders INSTANCE = new EmptyHeaders();

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final Set<Map.Entry<String, List<String>>> entries() {
        return EmptySet.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final void forEach(Function2<? super String, ? super List<? extends String>, Unit> function2) {
        ValuesMap.DefaultImpls.forEach(this, function2);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final String get(String str) {
        return (String) CollectionsKt___CollectionsKt.firstOrNull((List) EmptyList.INSTANCE);
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMap
    public final List<String> getAll(String str) {
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
