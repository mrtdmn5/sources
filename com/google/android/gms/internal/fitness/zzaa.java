package com.google.android.gms.internal.fitness;

import io.ktor.util.reflect.TypeInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzaa {
    public static final TypeInfo argumentTypeInfo(TypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(typeInfo, "<this>");
        KType kType = typeInfo.kotlinType;
        Intrinsics.checkNotNull(kType);
        KType kType2 = kType.getArguments().get(0).type;
        Intrinsics.checkNotNull(kType2);
        KClassifier classifier = kType2.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        return new TypeInfo(TypesJVMKt.getJavaType(kType2), (KClass) classifier, kType2);
    }
}
