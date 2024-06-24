package kotlin;

import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.common.hash.AbstractHasher;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt__SerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.TripleSerializer;

/* compiled from: Exceptions.kt */
/* loaded from: classes.dex */
public final class ExceptionsKt implements zzdq {
    public static final /* synthetic */ ExceptionsKt zza = new ExceptionsKt();

    public static final void addSuppressed(Throwable th, Throwable exception) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, exception);
        }
    }

    public static final KSerializer parametrizedSerializerOrNull(KClass kClass, List types, ArrayList arrayList) {
        boolean areEqual;
        boolean areEqual2;
        boolean areEqual3;
        boolean areEqual4;
        boolean areEqual5;
        boolean areEqual6;
        boolean areEqual7;
        KSerializer kSerializer;
        KSerializer referenceArraySerializer;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(types, "types");
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Collection.class))) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class));
        }
        if (areEqual) {
            areEqual2 = true;
        } else {
            areEqual2 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class));
        }
        if (areEqual2) {
            areEqual3 = true;
        } else {
            areEqual3 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(ArrayList.class));
        }
        if (areEqual3) {
            kSerializer = new ArrayListSerializer((KSerializer) arrayList.get(0));
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashSet.class))) {
            kSerializer = new HashSetSerializer((KSerializer) arrayList.get(0));
        } else {
            if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class))) {
                areEqual4 = true;
            } else {
                areEqual4 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class));
            }
            if (areEqual4) {
                areEqual5 = true;
            } else {
                areEqual5 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashSet.class));
            }
            if (areEqual5) {
                kSerializer = new LinkedHashSetSerializer((KSerializer) arrayList.get(0));
            } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashMap.class))) {
                kSerializer = new HashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
            } else {
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class))) {
                    areEqual6 = true;
                } else {
                    areEqual6 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class));
                }
                if (areEqual6) {
                    areEqual7 = true;
                } else {
                    areEqual7 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashMap.class));
                }
                if (areEqual7) {
                    kSerializer = new LinkedHashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1));
                } else {
                    if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
                        KSerializer keySerializer = (KSerializer) arrayList.get(0);
                        KSerializer valueSerializer = (KSerializer) arrayList.get(1);
                        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
                        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
                        referenceArraySerializer = new MapEntrySerializer(keySerializer, valueSerializer);
                    } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
                        KSerializer keySerializer2 = (KSerializer) arrayList.get(0);
                        KSerializer valueSerializer2 = (KSerializer) arrayList.get(1);
                        Intrinsics.checkNotNullParameter(keySerializer2, "keySerializer");
                        Intrinsics.checkNotNullParameter(valueSerializer2, "valueSerializer");
                        referenceArraySerializer = new PairSerializer(keySerializer2, valueSerializer2);
                    } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Triple.class))) {
                        KSerializer aSerializer = (KSerializer) arrayList.get(0);
                        KSerializer bSerializer = (KSerializer) arrayList.get(1);
                        KSerializer cSerializer = (KSerializer) arrayList.get(2);
                        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
                        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
                        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
                        kSerializer = new TripleSerializer(aSerializer, bSerializer, cSerializer);
                    } else if (JvmClassMappingKt.getJavaClass(kClass).isArray()) {
                        KClassifier classifier = ((KType) types.get(0)).getClassifier();
                        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                        KSerializer elementSerializer = (KSerializer) arrayList.get(0);
                        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
                        referenceArraySerializer = new ReferenceArraySerializer((KClass) classifier, elementSerializer);
                    } else {
                        kSerializer = null;
                    }
                    kSerializer = referenceArraySerializer;
                }
            }
        }
        if (kSerializer == null) {
            KSerializer[] kSerializerArr = (KSerializer[]) arrayList.toArray(new KSerializer[0]);
            return PlatformKt.constructSerializerForGivenTypeArgs(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
        }
        return kSerializer;
    }

    public static final KSerializer serializer(AbstractHasher abstractHasher, KType type) {
        Intrinsics.checkNotNullParameter(abstractHasher, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(abstractHasher, type, true);
        if (serializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return serializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        KClass<Object> kclass = Platform_commonKt.kclass(type);
        Intrinsics.checkNotNullParameter(kclass, "<this>");
        Platform_commonKt.serializerNotRegistered(kclass);
        throw null;
    }

    public static final KSerializer serializerOrNull(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(kClass, new KSerializer[0]);
        if (constructSerializerForGivenTypeArgs == null) {
            return PrimitivesKt.BUILTIN_SERIALIZERS.get(kClass);
        }
        return constructSerializerForGivenTypeArgs;
    }

    public static final ArrayList serializersForParameters(AbstractHasher abstractHasher, List typeArguments, boolean z) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(abstractHasher, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (z) {
            List list = typeArguments;
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(serializer(abstractHasher, (KType) it.next()));
            }
        } else {
            List<KType> list2 = typeArguments;
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
            for (KType type : list2) {
                Intrinsics.checkNotNullParameter(type, "type");
                KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(abstractHasher, type, false);
                if (serializerByKTypeImpl$SerializersKt__SerializersKt == null) {
                    return null;
                }
                arrayList.add(serializerByKTypeImpl$SerializersKt__SerializersKt);
            }
        }
        return arrayList;
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Integer.valueOf((int) zznn.zza.zza().zze());
    }
}
