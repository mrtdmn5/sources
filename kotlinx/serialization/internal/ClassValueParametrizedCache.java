package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    public final ClassValueReferences<ParametrizedCacheEntry<T>> classValue;
    public final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = new ClassValueReferences<>();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s, reason: not valid java name */
    public final Object mo1707getgIAlus(KClass kClass, ArrayList arrayList) {
        Object obj;
        Object createFailure;
        obj = this.classValue.get(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        T t = mutableSoftReference.reference.get();
        if (t == null) {
            t = (T) mutableSoftReference.getOrSetWithLock(new Function0<Object>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new ParametrizedCacheEntry();
                }
            });
        }
        ParametrizedCacheEntry parametrizedCacheEntry = t;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> concurrentHashMap = parametrizedCacheEntry.serializers;
        Result<KSerializer<T>> result = concurrentHashMap.get(arrayList2);
        if (result == null) {
            try {
                createFailure = (KSerializer) this.compute.invoke(kClass, arrayList);
            } catch (Throwable th) {
                createFailure = ResultKt.createFailure(th);
            }
            result = new Result<>(createFailure);
            Result<KSerializer<T>> putIfAbsent = concurrentHashMap.putIfAbsent(arrayList2, result);
            if (putIfAbsent != null) {
                result = putIfAbsent;
            }
        }
        return result.value;
    }
}
