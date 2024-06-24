package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    public final ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> cache;
    public final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s */
    public final Object mo1707getgIAlus(KClass kClass, ArrayList arrayList) {
        Object createFailure;
        ParametrizedCacheEntry<T> putIfAbsent;
        ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> concurrentHashMap = this.cache;
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(kClass);
        ParametrizedCacheEntry<T> parametrizedCacheEntry = concurrentHashMap.get(javaClass);
        if (parametrizedCacheEntry == null && (putIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (parametrizedCacheEntry = new ParametrizedCacheEntry<>()))) != null) {
            parametrizedCacheEntry = putIfAbsent;
        }
        ParametrizedCacheEntry<T> parametrizedCacheEntry2 = parametrizedCacheEntry;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> concurrentHashMap2 = parametrizedCacheEntry2.serializers;
        Result<KSerializer<T>> result = concurrentHashMap2.get(arrayList2);
        if (result == null) {
            try {
                createFailure = (KSerializer) this.compute.invoke(kClass, arrayList);
            } catch (Throwable th) {
                createFailure = ResultKt.createFailure(th);
            }
            result = new Result<>(createFailure);
            Result<KSerializer<T>> putIfAbsent2 = concurrentHashMap2.putIfAbsent(arrayList2, result);
            if (putIfAbsent2 != null) {
                result = putIfAbsent2;
            }
        }
        return result.value;
    }
}
