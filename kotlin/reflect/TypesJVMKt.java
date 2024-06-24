package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: TypesJVM.kt */
/* loaded from: classes.dex */
public final class TypesJVMKt {

    /* compiled from: TypesJVM.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[KVariance.values().length];
            try {
                r0[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final String access$typeToString(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence generateSequence = SequencesKt__SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                StringBuilder sb = new StringBuilder();
                Iterator it = generateSequence.iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    sb.append(((Class) next).getName());
                    sb.append(StringsKt__StringsJVMKt.repeat(SequencesKt___SequencesKt.count(generateSequence), "[]"));
                    name = sb.toString();
                } else {
                    throw new NoSuchElementException("Sequence is empty.");
                }
            } else {
                name = cls.getName();
            }
            Intrinsics.checkNotNull(name);
            return name;
        }
        return type.toString();
    }

    public static final Type computeJavaType(KType kType, boolean z) {
        Class javaClass;
        int r1;
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            if (z) {
                javaClass = JvmClassMappingKt.getJavaObjectType(kClass);
            } else {
                javaClass = JvmClassMappingKt.getJavaClass(kClass);
            }
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaClass;
            }
            if (javaClass.isArray()) {
                if (javaClass.getComponentType().isPrimitive()) {
                    return javaClass;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt___CollectionsKt.singleOrNull(arguments);
                if (kTypeProjection != null) {
                    KVariance kVariance = kTypeProjection.variance;
                    if (kVariance == null) {
                        r1 = -1;
                    } else {
                        r1 = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
                    }
                    if (r1 != -1 && r1 != 1) {
                        if (r1 != 2 && r1 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        KType kType2 = kTypeProjection.type;
                        Intrinsics.checkNotNull(kType2);
                        Type computeJavaType = computeJavaType(kType2, false);
                        if (!(computeJavaType instanceof Class)) {
                            return new GenericArrayTypeImpl(computeJavaType);
                        }
                        return javaClass;
                    }
                    return javaClass;
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return createPossiblyInnerType(javaClass, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    public static final ParameterizedTypeImpl createPossiblyInnerType(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        ParameterizedTypeImpl createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(subList, 10));
        Iterator it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
    }

    public static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance kVariance = kTypeProjection.variance;
        if (kVariance == null) {
            return WildcardTypeImpl.STAR;
        }
        KType kType = kTypeProjection.type;
        Intrinsics.checkNotNull(kType);
        int r0 = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (r0 == 1) {
            return new WildcardTypeImpl(null, computeJavaType(kType, true));
        }
        if (r0 == 2) {
            return computeJavaType(kType, true);
        }
        if (r0 == 3) {
            return new WildcardTypeImpl(computeJavaType(kType, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? computeJavaType(kType, false) : javaType;
    }
}
