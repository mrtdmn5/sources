package kotlinx.serialization.internal;

import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class KTypeWrapper implements KType {
    public final KType origin;

    public KTypeWrapper(KType origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
    }

    public final boolean equals(Object obj) {
        KType kType;
        if (obj == null || !Intrinsics.areEqual(this.origin, obj)) {
            return false;
        }
        KClassifier classifier = getClassifier();
        if (classifier instanceof KClass) {
            KClassifier kClassifier = null;
            if (obj instanceof KType) {
                kType = (KType) obj;
            } else {
                kType = null;
            }
            if (kType != null) {
                kClassifier = kType.getClassifier();
            }
            if (kClassifier != null && (kClassifier instanceof KClass)) {
                return Intrinsics.areEqual(JvmClassMappingKt.getJavaClass((KClass) classifier), JvmClassMappingKt.getJavaClass((KClass) kClassifier));
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KType
    public final List<KTypeProjection> getArguments() {
        return this.origin.getArguments();
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.origin.getClassifier();
    }

    public final int hashCode() {
        return this.origin.hashCode();
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return this.origin.isMarkedNullable();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.origin;
    }
}
