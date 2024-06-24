package okhttp3.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import okhttp3.Request;

/* compiled from: -RequestCommon.kt */
/* loaded from: classes4.dex */
public final class _RequestCommonKt {
    public static final void commonTag(Request.Builder builder, ClassReference classReference, Object obj) {
        Map asMutableMap;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (obj == null) {
            if (!builder.tags.isEmpty()) {
                Map<KClass<?>, ? extends Object> map = builder.tags;
                Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                TypeIntrinsics.asMutableMap(map).remove(classReference);
                return;
            }
            return;
        }
        if (builder.tags.isEmpty()) {
            asMutableMap = new LinkedHashMap();
            builder.tags = asMutableMap;
        } else {
            Map<KClass<?>, ? extends Object> map2 = builder.tags;
            Intrinsics.checkNotNull(map2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
            asMutableMap = TypeIntrinsics.asMutableMap(map2);
        }
        asMutableMap.put(classReference, obj);
    }
}
