package com.amplifyframework.auth.cognito.data;

import com.amplifyframework.core.store.KeyValueRepository;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InMemoryKeyValueRepository.kt */
/* loaded from: classes.dex */
public final class InMemoryKeyValueRepository implements KeyValueRepository {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public String get(String dataKey) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return this.cache.getOrDefault(dataKey, null);
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public void put(String dataKey, String str) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        if (str != null) {
            this.cache.put(dataKey, str);
        }
    }

    @Override // com.amplifyframework.core.store.KeyValueRepository
    public void remove(String dataKey) {
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        this.cache.remove(dataKey);
    }
}
