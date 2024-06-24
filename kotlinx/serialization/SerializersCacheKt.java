package kotlinx.serialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ClassValueCache;
import kotlinx.serialization.internal.ClassValueParametrizedCache;
import kotlinx.serialization.internal.ConcurrentHashMapCache;
import kotlinx.serialization.internal.ConcurrentHashMapParametrizedCache;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleKt;

/* compiled from: SerializersCache.kt */
/* loaded from: classes4.dex */
public final class SerializersCacheKt {
    public static final ParametrizedSerializerCache<? extends Object> PARAMETRIZED_SERIALIZERS_CACHE;
    public static final ParametrizedSerializerCache<Object> PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE;
    public static final SerializerCache<? extends Object> SERIALIZERS_CACHE;
    public static final SerializerCache<Object> SERIALIZERS_CACHE_NULLABLE;

    static {
        SerializerCache<? extends Object> concurrentHashMapCache;
        SerializerCache<Object> concurrentHashMapCache2;
        ParametrizedSerializerCache<? extends Object> concurrentHashMapParametrizedCache;
        ParametrizedSerializerCache<Object> concurrentHashMapParametrizedCache2;
        boolean z = CachingKt.useClassValue;
        SerializersCacheKt$SERIALIZERS_CACHE$1 factory = new Function1<KClass<?>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE$1
            @Override // kotlin.jvm.functions.Function1
            public final KSerializer<? extends Object> invoke(KClass<?> kClass) {
                KClass<?> it = kClass;
                Intrinsics.checkNotNullParameter(it, "it");
                return ExceptionsKt.serializerOrNull(it);
            }
        };
        Intrinsics.checkNotNullParameter(factory, "factory");
        boolean z2 = CachingKt.useClassValue;
        if (z2) {
            concurrentHashMapCache = new ClassValueCache<>(factory);
        } else {
            concurrentHashMapCache = new ConcurrentHashMapCache<>(factory);
        }
        SERIALIZERS_CACHE = concurrentHashMapCache;
        SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 factory2 = new Function1<KClass<?>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1
            @Override // kotlin.jvm.functions.Function1
            public final KSerializer<Object> invoke(KClass<?> kClass) {
                KClass<?> it = kClass;
                Intrinsics.checkNotNullParameter(it, "it");
                KSerializer serializerOrNull = ExceptionsKt.serializerOrNull(it);
                if (serializerOrNull != null) {
                    return BuiltinSerializersKt.getNullable(serializerOrNull);
                }
                return null;
            }
        };
        Intrinsics.checkNotNullParameter(factory2, "factory");
        if (z2) {
            concurrentHashMapCache2 = new ClassValueCache<>(factory2);
        } else {
            concurrentHashMapCache2 = new ConcurrentHashMapCache<>(factory2);
        }
        SERIALIZERS_CACHE_NULLABLE = concurrentHashMapCache2;
        SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 factory3 = new Function2<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1
            @Override // kotlin.jvm.functions.Function2
            public final KSerializer<? extends Object> invoke(KClass<Object> kClass, List<? extends KType> list) {
                KClass<Object> clazz = kClass;
                List<? extends KType> types = list;
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Intrinsics.checkNotNullParameter(types, "types");
                ArrayList serializersForParameters = ExceptionsKt.serializersForParameters(SerializersModuleKt.EmptySerializersModule, types, true);
                Intrinsics.checkNotNull(serializersForParameters);
                return ExceptionsKt.parametrizedSerializerOrNull(clazz, types, serializersForParameters);
            }
        };
        Intrinsics.checkNotNullParameter(factory3, "factory");
        if (z2) {
            concurrentHashMapParametrizedCache = new ClassValueParametrizedCache<>(factory3);
        } else {
            concurrentHashMapParametrizedCache = new ConcurrentHashMapParametrizedCache<>(factory3);
        }
        PARAMETRIZED_SERIALIZERS_CACHE = concurrentHashMapParametrizedCache;
        SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 factory4 = new Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1
            @Override // kotlin.jvm.functions.Function2
            public final KSerializer<Object> invoke(KClass<Object> kClass, List<? extends KType> list) {
                KClass<Object> clazz = kClass;
                List<? extends KType> types = list;
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Intrinsics.checkNotNullParameter(types, "types");
                ArrayList serializersForParameters = ExceptionsKt.serializersForParameters(SerializersModuleKt.EmptySerializersModule, types, true);
                Intrinsics.checkNotNull(serializersForParameters);
                KSerializer parametrizedSerializerOrNull = ExceptionsKt.parametrizedSerializerOrNull(clazz, types, serializersForParameters);
                if (parametrizedSerializerOrNull != null) {
                    return BuiltinSerializersKt.getNullable(parametrizedSerializerOrNull);
                }
                return null;
            }
        };
        Intrinsics.checkNotNullParameter(factory4, "factory");
        if (z2) {
            concurrentHashMapParametrizedCache2 = new ClassValueParametrizedCache<>(factory4);
        } else {
            concurrentHashMapParametrizedCache2 = new ConcurrentHashMapParametrizedCache<>(factory4);
        }
        PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = concurrentHashMapParametrizedCache2;
    }
}
