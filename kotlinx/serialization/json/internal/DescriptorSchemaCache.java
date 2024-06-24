package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: SchemaCache.kt */
/* loaded from: classes4.dex */
public final class DescriptorSchemaCache {
    public final ConcurrentHashMap map = new ConcurrentHashMap(16);

    /* compiled from: SchemaCache.kt */
    /* loaded from: classes4.dex */
    public static final class Key<T> {
    }

    public final <T> T get(SerialDescriptor descriptor, Key<T> key) {
        Object obj;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Map map = (Map) this.map.get(descriptor);
        if (map != null) {
            obj = map.get(key);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }
}
