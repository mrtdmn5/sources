package aws.sdk.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.util.AttributeKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CustomUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class CustomUserAgentMetadata {
    public static final AttributeKey<CustomUserAgentMetadata> ContextKey = new AttributeKey<>("CustomUserAgentMetadata");
    public final LinkedHashMap extras;
    public final ArrayList typedExtras;

    /* compiled from: CustomUserAgentMetadata.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final LinkedHashMap fromEnvironment$findAndStripKeyPrefix(String str, Map map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (StringsKt__StringsJVMKt.startsWith((String) entry.getKey(), str, false)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String substring = ((String) entry2.getKey()).substring(str.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                linkedHashMap2.put(substring, entry2.getValue());
            }
            return linkedHashMap2;
        }
    }

    public CustomUserAgentMetadata() {
        this((LinkedHashMap) null, 3);
    }

    public CustomUserAgentMetadata(Map<String, String> extras, List<Object> typedExtras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(typedExtras, "typedExtras");
        this.extras = MapsKt__MapsKt.toMutableMap(extras);
        this.typedExtras = CollectionsKt___CollectionsKt.toMutableList((Collection) typedExtras);
    }

    public /* synthetic */ CustomUserAgentMetadata(LinkedHashMap linkedHashMap, int r3) {
        this((Map<String, String>) ((r3 & 1) != 0 ? EmptyMap.INSTANCE : linkedHashMap), (r3 & 2) != 0 ? EmptyList.INSTANCE : null);
    }
}
