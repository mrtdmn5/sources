package io.ktor.serialization.kotlinx;

import com.google.common.hash.AbstractHasher;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt__SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SerializerLookup.kt */
/* loaded from: classes3.dex */
public final class SerializerLookupKt {
    public static final KSerializer<?> elementSerializer(Collection<?> collection, AbstractHasher abstractHasher) {
        boolean z;
        Collection<?> collection2 = collection;
        ArrayList filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(collection2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(filterNotNull, 10));
        Iterator it = filterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(guessSerializer(it.next(), abstractHasher));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (hashSet.add(((KSerializer) next).getDescriptor().getSerialName())) {
                arrayList2.add(next);
            }
        }
        boolean z2 = true;
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((KSerializer) it3.next()).getDescriptor().getSerialName());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        KSerializer<?> kSerializer = (KSerializer) CollectionsKt___CollectionsKt.singleOrNull(arrayList2);
        if (kSerializer == null) {
            kSerializer = StringSerializer.INSTANCE;
        }
        if (kSerializer.getDescriptor().isNullable()) {
            return kSerializer;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it4 = collection2.iterator();
            while (it4.hasNext()) {
                if (it4.next() == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return BuiltinSerializersKt.getNullable(kSerializer);
        }
        return kSerializer;
    }

    public static final KSerializer<Object> guessSerializer(Object obj, AbstractHasher module) {
        KSerializer<Object> contextual;
        ClassReference orCreateKotlinClass;
        boolean z;
        Intrinsics.checkNotNullParameter(module, "module");
        if (obj == null) {
            return BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
        }
        if (obj instanceof List) {
            contextual = new ArrayListSerializer<>(elementSerializer((Collection) obj, module));
        } else {
            Object obj2 = null;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    obj2 = objArr[0];
                }
                if (obj2 != null) {
                    return guessSerializer(obj2, module);
                }
                contextual = new ArrayListSerializer<>(StringSerializer.INSTANCE);
            } else if (obj instanceof Set) {
                contextual = new LinkedHashSetSerializer<>(elementSerializer((Collection) obj, module));
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                contextual = new LinkedHashMapSerializer<>(elementSerializer(map.keySet(), module), elementSerializer(map.values(), module));
            } else {
                contextual = module.getContextual(Reflection.getOrCreateKotlinClass(obj.getClass()), EmptyList.INSTANCE);
                if (contextual == null && (contextual = ExceptionsKt.serializerOrNull((orCreateKotlinClass = Reflection.getOrCreateKotlinClass(obj.getClass())))) == null) {
                    Platform_commonKt.serializerNotRegistered(orCreateKotlinClass);
                    throw null;
                }
            }
        }
        return contextual;
    }

    public static final KSerializer<?> serializerForTypeInfo(AbstractHasher abstractHasher, TypeInfo typeInfo) {
        KSerializer<?> serializerByKTypeImpl$SerializersKt__SerializersKt;
        Intrinsics.checkNotNullParameter(abstractHasher, "<this>");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        boolean z = false;
        KType kType = typeInfo.kotlinType;
        if (kType != null) {
            if (kType.getArguments().isEmpty()) {
                serializerByKTypeImpl$SerializersKt__SerializersKt = null;
            } else {
                serializerByKTypeImpl$SerializersKt__SerializersKt = SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(abstractHasher, kType, false);
            }
            if (serializerByKTypeImpl$SerializersKt__SerializersKt != null) {
                return serializerByKTypeImpl$SerializersKt__SerializersKt;
            }
        }
        EmptyList emptyList = EmptyList.INSTANCE;
        KClass<?> kClass = typeInfo.type;
        KSerializer<?> contextual = abstractHasher.getContextual(kClass, emptyList);
        if (contextual != null) {
            if (kType != null && kType.isMarkedNullable()) {
                z = true;
            }
            if (z) {
                contextual = BuiltinSerializersKt.getNullable(contextual);
            }
        } else {
            Intrinsics.checkNotNullParameter(kClass, "<this>");
            contextual = ExceptionsKt.serializerOrNull(kClass);
            if (contextual != null) {
                if (kType != null && kType.isMarkedNullable()) {
                    z = true;
                }
                if (z) {
                    contextual = BuiltinSerializersKt.getNullable(contextual);
                }
            } else {
                Platform_commonKt.serializerNotRegistered(kClass);
                throw null;
            }
        }
        return contextual;
    }
}
