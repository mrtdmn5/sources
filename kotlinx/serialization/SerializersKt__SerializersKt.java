package kotlinx.serialization;

import com.google.common.hash.AbstractHasher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.SerializerCache;

/* compiled from: Serializers.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class SerializersKt__SerializersKt {
    public static final KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(AbstractHasher abstractHasher, KType kType, boolean z) {
        Object mo1707getgIAlus;
        KSerializer<? extends Object> kSerializer;
        KSerializer kSerializer2;
        KClass clazz = Platform_commonKt.kclass(kType);
        boolean isMarkedNullable = kType.isMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            KType kType2 = ((KTypeProjection) it.next()).type;
            if (kType2 != null) {
                arrayList.add(kType2);
            } else {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kType).toString());
            }
        }
        if (arrayList.isEmpty()) {
            SerializerCache<? extends Object> serializerCache = SerializersCacheKt.SERIALIZERS_CACHE;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            if (!isMarkedNullable) {
                kSerializer = SerializersCacheKt.SERIALIZERS_CACHE.get(clazz);
                if (kSerializer == null) {
                    kSerializer = null;
                }
            } else {
                kSerializer = SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE.get(clazz);
            }
        } else {
            SerializerCache<? extends Object> serializerCache2 = SerializersCacheKt.SERIALIZERS_CACHE;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            if (!isMarkedNullable) {
                mo1707getgIAlus = SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE.mo1707getgIAlus(clazz, arrayList);
            } else {
                mo1707getgIAlus = SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo1707getgIAlus(clazz, arrayList);
            }
            if (z) {
                if (mo1707getgIAlus instanceof Result.Failure) {
                    mo1707getgIAlus = null;
                }
                kSerializer = (KSerializer) mo1707getgIAlus;
            } else {
                if (Result.m1661exceptionOrNullimpl(mo1707getgIAlus) != null) {
                    return null;
                }
                kSerializer = (KSerializer) mo1707getgIAlus;
            }
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        if (arrayList.isEmpty()) {
            kSerializer2 = abstractHasher.getContextual(clazz, EmptyList.INSTANCE);
        } else {
            ArrayList serializersForParameters = ExceptionsKt.serializersForParameters(abstractHasher, arrayList, z);
            if (serializersForParameters == null) {
                return null;
            }
            KSerializer parametrizedSerializerOrNull = ExceptionsKt.parametrizedSerializerOrNull(clazz, arrayList, serializersForParameters);
            if (parametrizedSerializerOrNull == null) {
                kSerializer2 = abstractHasher.getContextual(clazz, serializersForParameters);
            } else {
                kSerializer2 = parametrizedSerializerOrNull;
            }
        }
        if (kSerializer2 == null) {
            return null;
        }
        if (isMarkedNullable) {
            kSerializer2 = BuiltinSerializersKt.getNullable(kSerializer2);
        }
        return kSerializer2;
    }
}
