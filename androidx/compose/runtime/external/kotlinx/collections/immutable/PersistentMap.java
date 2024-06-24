package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: ImmutableMap.kt */
/* loaded from: classes.dex */
public interface PersistentMap<K, V> extends Map, KMappedMarker {

    /* compiled from: ImmutableMap.kt */
    /* loaded from: classes.dex */
    public interface Builder<K, V> extends Map<K, V>, KMutableMap {
        PersistentMap<K, V> build();
    }

    Builder<K, V> builder();
}
