package kotlin.jvm;

import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.internal.measurement.zznl;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: JvmClassMapping.kt */
/* loaded from: classes.dex */
public final class JvmClassMappingKt implements zzdq {
    public static final /* synthetic */ JvmClassMappingKt zza = new JvmClassMappingKt();

    public static final Class getJavaClass(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return jClass;
    }

    public static final Class getJavaObjectType(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals(AnalyticsConstants.KEY_DOUBLE)) {
                    return Double.class;
                }
                return jClass;
            case 104431:
                if (name.equals("int")) {
                    return Integer.class;
                }
                return jClass;
            case 3039496:
                if (name.equals("byte")) {
                    return Byte.class;
                }
                return jClass;
            case 3052374:
                if (name.equals("char")) {
                    return Character.class;
                }
                return jClass;
            case 3327612:
                if (name.equals("long")) {
                    return Long.class;
                }
                return jClass;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return jClass;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.class;
                }
                return jClass;
            case 97526364:
                if (name.equals("float")) {
                    return Float.class;
                }
                return jClass;
            case 109413500:
                if (name.equals("short")) {
                    return Short.class;
                }
                return jClass;
            default:
                return jClass;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zznl) zznk.zza.zzb.zza()).zza());
    }
}
