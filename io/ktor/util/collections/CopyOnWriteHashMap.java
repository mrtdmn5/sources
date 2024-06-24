package io.ktor.util.collections;

import com.animaconnected.firebase.AnalyticsConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CopyOnWriteHashMap.kt */
/* loaded from: classes3.dex */
public final class CopyOnWriteHashMap<K, V> {
    private volatile /* synthetic */ Object current = EmptyMap.INSTANCE;

    static {
        AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, AnalyticsConstants.KEY_CURRENT);
    }

    public final V get(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (V) ((Map) this.current).get(key);
    }
}
