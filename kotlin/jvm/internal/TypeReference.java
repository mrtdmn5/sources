package kotlin.jvm.internal;

import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* compiled from: TypeReference.kt */
/* loaded from: classes.dex */
public final class TypeReference implements KType {
    public final List<KTypeProjection> arguments;
    public final KClassifier classifier;
    public final int flags;
    public final KType platformTypeUpperBound;

    /* compiled from: TypeReference.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[KVariance.values().length];
            try {
                r0[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public TypeReference() {
        throw null;
    }

    public TypeReference(ClassReference classReference, List arguments, boolean z) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classReference;
        this.arguments = arguments;
        this.platformTypeUpperBound = null;
        this.flags = z ? 1 : 0;
    }

    public final String asString(boolean z) {
        KClass kClass;
        String name;
        String joinToString$default;
        KClassifier kClassifier = this.classifier;
        Class cls = null;
        if (kClassifier instanceof KClass) {
            kClass = (KClass) kClassifier;
        } else {
            kClass = null;
        }
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        if (cls == null) {
            name = kClassifier.toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            if (Intrinsics.areEqual(cls, boolean[].class)) {
                name = "kotlin.BooleanArray";
            } else if (Intrinsics.areEqual(cls, char[].class)) {
                name = "kotlin.CharArray";
            } else if (Intrinsics.areEqual(cls, byte[].class)) {
                name = "kotlin.ByteArray";
            } else if (Intrinsics.areEqual(cls, short[].class)) {
                name = "kotlin.ShortArray";
            } else if (Intrinsics.areEqual(cls, int[].class)) {
                name = "kotlin.IntArray";
            } else if (Intrinsics.areEqual(cls, float[].class)) {
                name = "kotlin.FloatArray";
            } else if (Intrinsics.areEqual(cls, long[].class)) {
                name = "kotlin.LongArray";
            } else if (Intrinsics.areEqual(cls, double[].class)) {
                name = "kotlin.DoubleArray";
            } else {
                name = "kotlin.Array";
            }
        } else if (z && cls.isPrimitive()) {
            Intrinsics.checkNotNull(kClassifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.getJavaObjectType((KClass) kClassifier).getName();
        } else {
            name = cls.getName();
        }
        List<KTypeProjection> list = this.arguments;
        String str = "";
        if (list.isEmpty()) {
            joinToString$default = "";
        } else {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ", ", "<", ">", new Function1<KTypeProjection, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(KTypeProjection kTypeProjection) {
                    TypeReference typeReference;
                    String valueOf;
                    String asString;
                    KTypeProjection it = kTypeProjection;
                    Intrinsics.checkNotNullParameter(it, "it");
                    TypeReference.this.getClass();
                    KVariance kVariance = it.variance;
                    if (kVariance == null) {
                        return "*";
                    }
                    KType kType = it.type;
                    if (kType instanceof TypeReference) {
                        typeReference = (TypeReference) kType;
                    } else {
                        typeReference = null;
                    }
                    if (typeReference != null && (asString = typeReference.asString(true)) != null) {
                        valueOf = asString;
                    } else {
                        valueOf = String.valueOf(kType);
                    }
                    int r0 = TypeReference.WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
                    if (r0 != 1) {
                        if (r0 != 2) {
                            if (r0 == 3) {
                                return "out ".concat(valueOf);
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        return "in ".concat(valueOf);
                    }
                    return valueOf;
                }
            }, 24);
        }
        if (isMarkedNullable()) {
            str = "?";
        }
        String m = AbstractResolvableFuture$$ExternalSyntheticOutline0.m(name, joinToString$default, str);
        KType kType = this.platformTypeUpperBound;
        if (kType instanceof TypeReference) {
            String asString = ((TypeReference) kType).asString(true);
            if (!Intrinsics.areEqual(asString, m)) {
                if (Intrinsics.areEqual(asString, m + '?')) {
                    return m + '!';
                }
                return "(" + m + ".." + asString + ')';
            }
            return m;
        }
        return m;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.areEqual(this.classifier, typeReference.classifier)) {
                if (Intrinsics.areEqual(this.arguments, typeReference.arguments) && Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KType
    public final List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.classifier;
    }

    public final int hashCode() {
        return Integer.hashCode(this.flags) + VectorGroup$$ExternalSyntheticOutline0.m(this.arguments, this.classifier.hashCode() * 31, 31);
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        if ((this.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }
}
