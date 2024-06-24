package kotlin.collections;

import androidx.compose.runtime.Composer;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Sets.kt */
/* loaded from: classes.dex */
public class SetsKt__SetsKt implements zzdq {
    public static final AttributeKey OperationName = new AttributeKey("OperationName");
    public static final AttributeKey ServiceName = new AttributeKey("ServiceName");
    public static final AttributeKey LogMode = new AttributeKey("LogMode");
    public static final /* synthetic */ SetsKt__SetsKt zza = new SetsKt__SetsKt();

    public static final void invokeComposable(Composer composer, Function2 composable) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(composable, "composable");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, composable);
        composable.invoke(composer, 1);
    }

    public static final Set mutableSetOf(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static final Set setOf(Object obj) {
        Set singleton = Collections.singleton(obj);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
        return singleton;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Integer.valueOf((int) zznn.zza.zza().zzA());
    }

    public static final Set setOf(Object... objArr) {
        return objArr.length > 0 ? ArraysKt___ArraysKt.toSet(objArr) : EmptySet.INSTANCE;
    }
}
