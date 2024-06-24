package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ConcurrentHashMapCache<T> implements SerializerCache<T> {
    public final ConcurrentHashMap<Class<?>, CacheEntry<T>> cache;
    public final Function1<KClass<?>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public final KSerializer<T> get(KClass<Object> kClass) {
        CacheEntry<T> putIfAbsent;
        ConcurrentHashMap<Class<?>, CacheEntry<T>> concurrentHashMap = this.cache;
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(kClass);
        CacheEntry<T> cacheEntry = concurrentHashMap.get(javaClass);
        if (cacheEntry == null && (putIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (cacheEntry = new CacheEntry<>(this.compute.invoke(kClass))))) != null) {
            cacheEntry = putIfAbsent;
        }
        return cacheEntry.serializer;
    }
}
