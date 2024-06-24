package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ClassValueCache<T> implements SerializerCache<T> {
    public final ClassValueReferences<CacheEntry<T>> classValue;
    public final Function1<KClass<?>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = new ClassValueReferences<>();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public final KSerializer<T> get(final KClass<Object> kClass) {
        Object obj;
        obj = this.classValue.get(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        T t = mutableSoftReference.reference.get();
        if (t == null) {
            t = (T) mutableSoftReference.getOrSetWithLock(new Function0<T>() { // from class: kotlinx.serialization.internal.ClassValueCache$get$$inlined$getOrSet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return (T) new CacheEntry(ClassValueCache.this.compute.invoke(kClass));
                }
            });
        }
        return t.serializer;
    }
}
