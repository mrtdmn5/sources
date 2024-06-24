package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class CacheEntry<T> {
    public final KSerializer<T> serializer;

    public CacheEntry(KSerializer<T> kSerializer) {
        this.serializer = kSerializer;
    }
}
