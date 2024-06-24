package kotlin.jvm.internal;

import com.animaconnected.firebase.AnalyticsConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ClassReference.kt */
/* loaded from: classes.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    public static final HashMap<String, String> classFqNames;
    public static final LinkedHashMap simpleNames;
    public final Class<?> jClass;

    static {
        int r1 = 0;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        for (Object obj : listOf) {
            int r4 = r1 + 1;
            if (r1 >= 0) {
                arrayList.add(new Pair((Class) obj, Integer.valueOf(r1)));
                r1 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        FUNCTION_CLASSES = MapsKt__MapsKt.toMap(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put(AnalyticsConstants.KEY_DOUBLE, "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            Intrinsics.checkNotNull(str);
            sb.append(StringsKt__StringsKt.substringAfterLast$default(str));
            sb.append("CompanionObject");
            hashMap3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            Class<? extends Function<?>> key = entry.getKey();
            int intValue = entry.getValue().intValue();
            hashMap3.put(key.getName(), "kotlin.Function" + intValue);
        }
        classFqNames = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(hashMap3.size()));
        Iterator<T> it = hashMap3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.substringAfterLast$default((String) entry2.getValue()));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj))) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class<?> getJClass() {
        return this.jClass;
    }

    public final String getQualifiedName() {
        String str;
        Class<?> jClass = this.jClass;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        String str2 = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        boolean isArray = jClass.isArray();
        HashMap<String, String> hashMap = classFqNames;
        if (isArray) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = hashMap.get(componentType.getName())) != null) {
                str2 = str.concat("Array");
            }
            if (str2 == null) {
                return "kotlin.Array";
            }
            return str2;
        }
        String str3 = hashMap.get(jClass.getName());
        if (str3 == null) {
            return jClass.getCanonicalName();
        }
        return str3;
    }

    @Override // kotlin.reflect.KClass
    public final String getSimpleName() {
        String str;
        Class<?> jClass = this.jClass;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        String str2 = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (jClass.isLocalClass()) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$');
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$');
            }
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) simpleName, '$', 0, false, 6);
            if (indexOf$default != -1) {
                String substring = simpleName.substring(indexOf$default + 1, simpleName.length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return substring;
            }
            return simpleName;
        }
        boolean isArray = jClass.isArray();
        LinkedHashMap linkedHashMap = simpleNames;
        if (isArray) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                str2 = str.concat("Array");
            }
            if (str2 == null) {
                return "Array";
            }
            return str2;
        }
        String str3 = (String) linkedHashMap.get(jClass.getName());
        if (str3 == null) {
            return jClass.getSimpleName();
        }
        return str3;
    }

    public final int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInstance(Object obj) {
        Class<?> jClass = this.jClass;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Map<Class<? extends Function<?>>, Integer> map = FUNCTION_CLASSES;
        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = map.get(jClass);
        if (num != null) {
            return TypeIntrinsics.isFunctionOfArity(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = JvmClassMappingKt.getJavaObjectType(Reflection.getOrCreateKotlinClass(jClass));
        }
        return jClass.isInstance(obj);
    }

    public final String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
