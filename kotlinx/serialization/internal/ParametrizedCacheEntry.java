package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ParametrizedCacheEntry<T> {
    public final ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();
}
